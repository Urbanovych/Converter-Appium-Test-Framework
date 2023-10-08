package org.urbanovych.pageObjects;

import static org.urbanovych.actions.click.ClickHelper.makeClickByXpath;
import static org.urbanovych.actions.wait.WaitHelper.waitForPageLoaded;

public class CategoryLayout {

    private static final String temperatureLinearLayoutXpath = "//android.widget.RelativeLayout[2]/android.widget.LinearLayout";
    private static final String lengthLinearLayoutXpath = "//android.widget.RelativeLayout[3]/android.widget.LinearLayout";

    public static void clickTemperatureLayout() {
        makeClickByXpath(temperatureLinearLayoutXpath);
        waitForPageLoaded();
    }

    public static void clickLengthLayout() {
        makeClickByXpath(lengthLinearLayoutXpath);
        waitForPageLoaded();
    }
}
