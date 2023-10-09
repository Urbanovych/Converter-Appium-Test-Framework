package org.urbanovych.actions.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.urbanovych.BaseTest.getWait;

public class WaitHelper {

    private static final String layoutTitleId = "android:id/action_bar_title";

    public static WebElement getVisibleElementByXpath(String xpathLocator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)));
    }

    public static WebElement getVisibleElementById(String idLocator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id(idLocator)));
    }

    public static void waitForPageLoaded() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id(layoutTitleId)));
    }

}
