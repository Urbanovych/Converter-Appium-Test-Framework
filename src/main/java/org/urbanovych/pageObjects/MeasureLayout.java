package org.urbanovych.pageObjects;

import org.urbanovych.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.urbanovych.actions.click.ClickHelper.makeClickById;
import static org.urbanovych.actions.scroll.ScrollHelper.scrollMeasure;
import static org.urbanovych.actions.text.GetTextHelper.getTextByXpath;

public class MeasureLayout extends BaseTest {

    private static final String celsiusXpath = "//android.widget.ListView/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView";
    private static final String fahrenheitXpath = "//android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView";
    private static final String kelvinXpath = "//android.widget.ListView/android.widget.LinearLayout[3]/android.widget.RelativeLayout[1]/android.widget.TextView";
    private static final String inputValuePlaceholderId = "com.unitconverter.freeunitconversioncalculator:id/unesena_vrednost";

    public static void assertMeasures(String celsiusExpectedValue, String fahrenheitExpectedValue, String kelvinExpectedValue) {
        assertEquals(getTextByXpath(celsiusXpath), celsiusExpectedValue);
        assertEquals(getTextByXpath(fahrenheitXpath), fahrenheitExpectedValue);
        assertEquals(getTextByXpath(kelvinXpath), kelvinExpectedValue);
    }

    public static void moveToFahrenheitMeasure() {
        scrollMeasure(0.3);
    }

    public static void moveToKelvinMeasure() {
        scrollMeasure(1.0);
    }

    public static void clickInputValuePlaceholder() {
        makeClickById(inputValuePlaceholderId);
    }
}
