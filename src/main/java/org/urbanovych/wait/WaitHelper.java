package org.urbanovych.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.urbanovych.BaseTest;

public class WaitHelper extends BaseTest {

    private static final String layoutTitleId = "android:id/action_bar_title";

    public static void clickVisibleElementByXpath (String xpathLocator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator))).click();
    }

    public static String getTextVisibleElementByXpath (String xpathLocator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator))).getText();
    }

    public static void waitForPageLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(layoutTitleId)));
    }

}
