package org.urbanovych.pageObjects;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.urbanovych.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.urbanovych.wait.WaitHelper.getTextVisibleElementByXpath;

public class MeasureLayout extends BaseTest {

    private static final String celsiusXpath = "//android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView";
    private static final String fahrenheitXpath = "//android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView";
    private static final String kelvinXpath = "//android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.RelativeLayout[1]/android.widget.TextView";

    public static void assertMeasures(String celsiusExpectedValue, String fahrenheitExpectedValue, String kelvinExpectedValue) {
        assertEquals(getTextVisibleElementByXpath(celsiusXpath), celsiusExpectedValue);
        assertEquals(getTextVisibleElementByXpath(fahrenheitXpath), fahrenheitExpectedValue);
        assertEquals(getTextVisibleElementByXpath(kelvinXpath), kelvinExpectedValue);
    }

    public static void moveToFahrenheitMeasure() {
        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 1100, "top", 210, "width", 200, "height", 300,
                "direction", "down",
                "percent", 0.3));
    }

    public static void moveToKelvinMeasure() {
        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 1100, "top", 210, "width", 200, "height", 300,
                "direction", "down",
                "percent", 1.0));
    }
}
