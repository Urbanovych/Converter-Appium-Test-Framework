package org.urbanovych.pageObjects;

import org.urbanovych.BaseTest;

import static org.urbanovych.wait.WaitHelper.clickVisibleElementById;
import static org.urbanovych.wait.WaitHelper.getTextVisibleElementById;

public class HeaderLayout {

    private static final String layoutTitleId = "android:id/action_bar_title";
    private static final String burgerIconId = "android:id/home";

    public static String getMeasurePageTitle() {
        return getTextVisibleElementById(layoutTitleId);
    }

    public static void clickBurgerIcon() {
        clickVisibleElementById(burgerIconId);
    }

}
