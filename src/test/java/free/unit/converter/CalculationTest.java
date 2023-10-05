package free.unit.converter;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import org.urbanovych.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationTest extends BaseTest {

    private final String celsiusXpath = "//android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView";
    private final String fahrenheitXpath = "//android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView";
    private final String kelvinXpath = "//android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.RelativeLayout[1]/android.widget.TextView";

    @Description("Verify that we can change input value in value placeholder")
    @Test
    public void changeInputValueUsingValuePlaceholderTest() {
        clickTemperatureLayout();
        waitForPageLoaded();
        clickInputValuePlaceholder();
        clickNumberFive();
        clickOkCalculationButton();

        assertEquals(driver.findElement(By.xpath(celsiusXpath)).getText(), "5");
        assertEquals(driver.findElement(By.xpath(fahrenheitXpath)).getText(), "40.99999");
        assertEquals(driver.findElement(By.xpath(kelvinXpath)).getText(), "278.15");
    }

    @Description("Verify that we can change input value using calculation icon")
    @Test
    public void changeInputValueUsingCalculationIconTest() {
        clickTemperatureLayout();
        waitForPageLoaded();
        clickCalculationIcon();
        clickNumberFive();
        clickOkCalculationButton();

        assertEquals(driver.findElement(By.xpath(celsiusXpath)).getText(), "5");
        assertEquals(driver.findElement(By.xpath(fahrenheitXpath)).getText(), "40.99999");
        assertEquals(driver.findElement(By.xpath(kelvinXpath)).getText(), "278.15");
    }

    @Description("Verify that we can change input value to negative number")
    @Test
    public void changeInputValueToNegativeValue() {
        clickTemperatureLayout();
        waitForPageLoaded();
        clickInputValuePlaceholder();
        clickNumberFive();
        clickPlusMinusButton();
        clickOkCalculationButton();

        assertEquals(driver.findElement(By.xpath(celsiusXpath)).getText(), "-5");
        assertEquals(driver.findElement(By.xpath(fahrenheitXpath)).getText(), "23");
        assertEquals(driver.findElement(By.xpath(kelvinXpath)).getText(), "268.15");
    }

    @Description("Verify that we can change input value to fractional number")
    @Test
    public void changeInputValueToFractionalNumber() {
        clickTemperatureLayout();
        waitForPageLoaded();
        clickInputValuePlaceholder();
        clickNumberFive();
        clickCommaCalcButton();
        clickNumberFive();
        clickOkCalculationButton();

        assertEquals(driver.findElement(By.xpath(celsiusXpath)).getText(), "5.5");
        assertEquals(driver.findElement(By.xpath(fahrenheitXpath)).getText(), "41.89999");
        assertEquals(driver.findElement(By.xpath(kelvinXpath)).getText(), "278.65");
    }

    @Description("Verify that we can clear only input value 1 symbol")
    @Test
    public void clearOneSymbolTest() {
        clickTemperatureLayout();
        waitForPageLoaded();
        clickInputValuePlaceholder();
        clickNumberFive();
        clickNumberFive();
        clickOkCalculationButton();

        assertEquals(driver.findElement(By.xpath(celsiusXpath)).getText(), "55");
        assertEquals(driver.findElement(By.xpath(fahrenheitXpath)).getText(), "130.99999");
        assertEquals(driver.findElement(By.xpath(kelvinXpath)).getText(), "328.15");

        clickInputValuePlaceholder();
        clickDeleteSymbolButton();
        clickOkCalculationButton();

        assertEquals(driver.findElement(By.xpath(celsiusXpath)).getText(), "5");
        assertEquals(driver.findElement(By.xpath(fahrenheitXpath)).getText(), "40.99999");
        assertEquals(driver.findElement(By.xpath(kelvinXpath)).getText(), "278.15");
    }

    @Description("Verify that we can clear all input value symbols (after clear all symbols input should be 1)")
    @Test
    public void clearAllSymbolsTest() {
        clickTemperatureLayout();
        waitForPageLoaded();
        clickInputValuePlaceholder();
        clickNumberFive();
        clickNumberFive();
        clickOkCalculationButton();

        assertEquals(driver.findElement(By.xpath(celsiusXpath)).getText(), "55");
        assertEquals(driver.findElement(By.xpath(fahrenheitXpath)).getText(), "130.99999");
        assertEquals(driver.findElement(By.xpath(kelvinXpath)).getText(), "328.15");

        clickInputValuePlaceholder();
        clickClearAllCalculationButton();
        clickOkCalculationButton();

        assertEquals(driver.findElement(By.xpath(celsiusXpath)).getText(), "1");
        assertEquals(driver.findElement(By.xpath(fahrenheitXpath)).getText(), "33.79999");
        assertEquals(driver.findElement(By.xpath(kelvinXpath)).getText(), "274.15");
    }
}
