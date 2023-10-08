package org.urbanovych.actions.scroll;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.JavascriptExecutor;
import org.urbanovych.BaseTest;

public class ScrollHelper extends BaseTest {

    public static void scrollMeasure(double percent) {
        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 1100, "top", 210, "width", 200, "height", 300,
                "direction", "down",
                "percent", percent));
    }
}
