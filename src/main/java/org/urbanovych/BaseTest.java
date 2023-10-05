package org.urbanovych;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    private static AppiumDriverLocalService server;
    protected static AndroidDriver driver;
    protected static WebDriverWait wait;
    private static final String layoutTitleId = "android:id/action_bar_title";
    private static final String inputValuePlaceholderId = "com.unitconverter.freeunitconversioncalculator:id/unesena_vrednost";
    private static final String numberFiveCalcBtnId = "com.unitconverter.freeunitconversioncalculator:id/petica";
    private static final String okCalcBtnId = "com.unitconverter.freeunitconversioncalculator:id/spustitastaturu";
    private static final String calcIconId = "com.unitconverter.freeunitconversioncalculator:id/imageView16";
    private static final String clearAllCalcBtnId = "com.unitconverter.freeunitconversioncalculator:id/clear";
    private static final String deleteSymbolCalcBtnId = "com.unitconverter.freeunitconversioncalculator:id/delete";
    private static final String plusMinusCalcBtnId = "com.unitconverter.freeunitconversioncalculator:id/plusminus";
    private static final String commaCalcBtnId = "com.unitconverter.freeunitconversioncalculator:id/zarez";

    public static AndroidDriver getDriver() {
        return driver;
    }

    @BeforeEach
    public void configureAppiumWithAndroidDriver() throws MalformedURLException {
        AppiumServiceBuilder appiumDriverLocalService = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .usingDriverExecutable(new File("/usr/local/bin/node"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723);
        server = AppiumDriverLocalService.buildService(appiumDriverLocalService);
        server.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 2 XL Lollipop");
        options.setApp("src/main/resources/FreeUnitConverter.apk");
        options.setAutomationName("UiAutomator2");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        server.stop();
    }

    public static void clickOkCalculationButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(okCalcBtnId)));
        driver.findElement(By.id(okCalcBtnId)).click();
    }

    public static void clickInputValuePlaceholder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputValuePlaceholderId)));
        driver.findElement(By.id(inputValuePlaceholderId)).click();
    }

    public static void clickNumberFive() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(numberFiveCalcBtnId)));
        driver.findElement(By.id(numberFiveCalcBtnId)).click();
    }

    public static void clickCalculationIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(calcIconId)));
        driver.findElement(By.id(calcIconId)).click();
    }

    public static void clickClearAllCalculationButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(clearAllCalcBtnId)));
        driver.findElement(By.id(clearAllCalcBtnId)).click();
    }

    public static void clickDeleteSymbolButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(deleteSymbolCalcBtnId)));
        driver.findElement(By.id(deleteSymbolCalcBtnId)).click();
    }

    public static void clickPlusMinusButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(plusMinusCalcBtnId)));
        driver.findElement(By.id(plusMinusCalcBtnId)).click();
    }

    public static void clickCommaCalcButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(commaCalcBtnId)));
        driver.findElement(By.id(commaCalcBtnId)).click();
    }

    public static void waitForPageLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(layoutTitleId)));
    }



}
