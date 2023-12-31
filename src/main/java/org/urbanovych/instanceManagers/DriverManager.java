package org.urbanovych.instanceManagers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.urbanovych.properties.PropertiesHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import static org.urbanovych.properties.PropertiesHelper.getPropertiesFromPath;

public class DriverManager {

    private static ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();

    private DriverManager(){};

    public static AndroidDriver getInstance() throws IOException {
        if (driver.get() == null) {
            Properties androidDriverProperties = getPropertiesFromPath("src/main/resources/androidDriver.properties");
            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName(androidDriverProperties.getProperty("deviceName"));
            options.setApp(androidDriverProperties.getProperty("appPath"));
            options.setAutomationName(androidDriverProperties.getProperty("automationName"));

            driver.set(new AndroidDriver(new URL("http://0.0.0.0:4723"), options));
        }
        return driver.get();
    }

    public static void quit() {
        driver.get().quit();
        driver.remove();
    }
}
