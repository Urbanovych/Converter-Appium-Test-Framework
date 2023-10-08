package org.urbanovych.actions.click;

import static org.urbanovych.actions.wait.WaitHelper.getVisibleElementById;
import static org.urbanovych.actions.wait.WaitHelper.getVisibleElementByXpath;

public class ClickHelper {

    public static void makeClickByXpath(String xpathLocator) {
        getVisibleElementByXpath(xpathLocator).click();
    }

    public static void makeClickById(String idLocator) {
        getVisibleElementById(idLocator).click();
    }
}
