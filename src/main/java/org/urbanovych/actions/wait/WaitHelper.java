package org.urbanovych.actions.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.urbanovych.BaseTest;

public class WaitHelper extends BaseTest {

    private static final String layoutTitleId = "android:id/action_bar_title";

    public static WebElement getVisibleElementByXpath(String xpathLocator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)));
    }

    public static WebElement getVisibleElementById(String idLocator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idLocator)));
    }

    public static void waitForPageLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(layoutTitleId)));
    }

}
