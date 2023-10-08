package org.urbanovych.actions.text;

import static org.urbanovych.actions.wait.WaitHelper.getVisibleElementById;
import static org.urbanovych.actions.wait.WaitHelper.getVisibleElementByXpath;

public class GetTextHelper {

    public static String getTextByXpath(String xpathLocator) {
        return getVisibleElementByXpath(xpathLocator).getText();
    }

    public static String getTextById(String idLocator) {
        return getVisibleElementById(idLocator).getText();
    }
}
