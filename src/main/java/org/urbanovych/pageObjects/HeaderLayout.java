package org.urbanovych.pageObjects;

import static org.urbanovych.actions.click.ClickHelper.makeClickById;
import static org.urbanovych.actions.text.GetTextHelper.getTextById;


public class HeaderLayout {

    private static final String layoutTitleId = "android:id/action_bar_title";
    private static final String burgerIconId = "android:id/home";

    public static String getMeasurePageTitle() {
        return getTextById(layoutTitleId);
    }

    public static void clickBurgerIcon() {
        makeClickById(burgerIconId);
    }

}
