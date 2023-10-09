package org.urbanovych;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.urbanovych.instanceManagers.DriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static org.urbanovych.properties.PropertiesHelper.getPropertiesFromPath;

public class BaseTest {

    private static AppiumDriverLocalService server;
    protected static AndroidDriver driver;
    protected static WebDriverWait wait;

    @BeforeEach
    public void configureAppiumWithAndroidDriver() throws IOException {
        Properties appiumDriverProperties = getPropertiesFromPath("src/main/resources/appiumDriver.properties");
        AppiumServiceBuilder appiumDriverLocalService = new AppiumServiceBuilder()
                .withAppiumJS(new File(appiumDriverProperties.getProperty("appiumJsPath")))
                .usingDriverExecutable(new File(appiumDriverProperties.getProperty("driverExecutablePath")))
                .withIPAddress(appiumDriverProperties.getProperty("ipAddress"))
                .usingPort(Integer.parseInt(appiumDriverProperties.getProperty("port")));
        server = AppiumDriverLocalService.buildService(appiumDriverLocalService);
        server.start();

        driver = DriverManager.getInstance();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterEach
    public void tearDown() {
        DriverManager.quit();
        server.stop();
    }

    public static WebDriverWait getWait() {
        return wait;
    }

}
