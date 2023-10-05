package free.unit.converter;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import org.urbanovych.BaseTest;

import static org.urbanovych.pageObjects.CalculationLayout.clickNumberFive;
import static org.urbanovych.pageObjects.CalculationLayout.clickOkCalculationButton;
import static org.urbanovych.pageObjects.CalculationLayout.clickCalculationIcon;
import static org.urbanovych.pageObjects.CalculationLayout.clickDeleteSymbolButton;
import static org.urbanovych.pageObjects.CalculationLayout.clickCommaCalcButton;
import static org.urbanovych.pageObjects.CalculationLayout.clickPlusMinusButton;
import static org.urbanovych.pageObjects.CalculationLayout.clickClearAllCalculationButton;
import static org.urbanovych.pageObjects.CategoryLayout.clickTemperatureLayout;
import static org.urbanovych.pageObjects.MeasureLayout.assertMeasures;
import static org.urbanovych.pageObjects.MeasureLayout.clickInputValuePlaceholder;

public class CalculationTest extends BaseTest {

    @Description("Verify that we can change input value in value placeholder")
    @Test
    public void changeInputValueUsingValuePlaceholderTest() {
        clickTemperatureLayout();
        clickInputValuePlaceholder();
        clickNumberFive();
        clickOkCalculationButton();

        assertMeasures("5", "40.99999", "278.15");
    }

    @Description("Verify that we can change input value using calculation icon")
    @Test
    public void changeInputValueUsingCalculationIconTest() {
        clickTemperatureLayout();
        clickCalculationIcon();
        clickNumberFive();
        clickOkCalculationButton();

        assertMeasures("5", "40.99999", "278.15");
    }

    @Description("Verify that we can change input value to negative number")
    @Test
    public void changeInputValueToNegativeValue() {
        clickTemperatureLayout();
        clickInputValuePlaceholder();
        clickNumberFive();
        clickPlusMinusButton();
        clickOkCalculationButton();

        assertMeasures("-5", "23", "268.15");
    }

    @Description("Verify that we can change input value to fractional number")
    @Test
    public void changeInputValueToFractionalNumber() {
        clickTemperatureLayout();
        clickInputValuePlaceholder();
        clickNumberFive();
        clickCommaCalcButton();
        clickNumberFive();
        clickOkCalculationButton();

        assertMeasures("5.5", "41.89999", "278.65");
    }

    @Description("Verify that we can clear only input value 1 symbol")
    @Test
    public void clearOneSymbolTest() {
        clickTemperatureLayout();
        clickInputValuePlaceholder();
        clickNumberFive();
        clickNumberFive();
        clickOkCalculationButton();

        assertMeasures("55", "130.99999", "328.15");

        clickInputValuePlaceholder();
        clickDeleteSymbolButton();
        clickOkCalculationButton();

        assertMeasures("5", "40.99999", "278.15");
    }

    @Description("Verify that we can clear all input value symbols (after clear all symbols input should be 1)")
    @Test
    public void clearAllSymbolsTest() {
        clickTemperatureLayout();
        clickInputValuePlaceholder();
        clickNumberFive();
        clickNumberFive();
        clickOkCalculationButton();

        assertMeasures("55", "130.99999", "328.15");

        clickInputValuePlaceholder();
        clickClearAllCalculationButton();
        clickOkCalculationButton();

        assertMeasures("1", "33.79999", "274.15");
    }
}
