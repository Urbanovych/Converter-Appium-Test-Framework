package org.urbanovych;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    private static AppiumDriverLocalService server;
    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        return driver;
    }

    public static void configureAppiumWithAndroidDriver() throws MalformedURLException {
        // AndroidDriver, IosDriver
        // Appium Code -> Appium Server -> Mobile Device
        AppiumServiceBuilder appiumDriverLocalService = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .usingDriverExecutable(new File("/usr/local/bin/node"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withLogFile(new File("AppiumLog.txt"));
        server = AppiumDriverLocalService.buildService(appiumDriverLocalService);
        server.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 2 XL Lollipop");
        options.setApp("src/main/resources/FreeUnitConverter.apk");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), options);
    }

    public static void tearDown() {
        driver.quit();
        server.stop();
    }

}
