package free.unit.converter;

import jdk.jfr.Description;

import org.junit.jupiter.api.Test;
import org.urbanovych.BaseTest;

import static org.urbanovych.pageObjects.CategoryLayout.clickTemperatureLayout;
import static org.urbanovych.pageObjects.MeasureLayout.moveToFahrenheitMeasure;
import static org.urbanovych.pageObjects.MeasureLayout.moveToKelvinMeasure;
import static org.urbanovych.pageObjects.MeasureLayout.assertMeasures;

public class MeasureTest extends BaseTest {

    @Description("Verify that user can change measure unit to fahrenheit from celsius")
    @Test
    public void changeMeasureToFahrenheitTest() {
        clickTemperatureLayout();
        moveToFahrenheitMeasure();

        assertMeasures("-17.22222", "1", "255.92777");
    }

    @Description("Verify that user can change measure unit to fahrenheit from celsius")
    @Test
    public void changeMeasureToKelvinTest() {
        clickTemperatureLayout();
        moveToKelvinMeasure();

        assertMeasures("-272.15", "-457.86998", "1");
    }
}
