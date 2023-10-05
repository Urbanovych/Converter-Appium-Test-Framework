package org.urbanovych;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    private static AppiumDriverLocalService server;
    protected static AndroidDriver driver;
    protected static WebDriverWait wait;

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

}
