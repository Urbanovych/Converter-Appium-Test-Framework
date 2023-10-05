package org.urbanovych.pageObjects;

import static org.urbanovych.wait.WaitHelper.clickVisibleElementByXpath;
import static org.urbanovych.wait.WaitHelper.waitForPageLoaded;

public class CategoryLayout {

    private static final String temperatureLinearLayoutXpath = "//android.widget.RelativeLayout[2]/android.widget.LinearLayout";

    public static void clickTemperatureLayout() {
        clickVisibleElementByXpath(temperatureLinearLayoutXpath);
        waitForPageLoaded();
    }
}