package org.urbanovych;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    private static AppiumDriverLocalService server;
    protected static AndroidDriver driver;
    protected static WebDriverWait wait;

    @BeforeEach
    public void configureAppiumWithAndroidDriver() throws IOException {
        Properties appiumDriverProperties = new Properties();
        FileInputStream appiumFileInputStream = new FileInputStream("src/main/resources/appiumDriver.properties");
        appiumDriverProperties.load(appiumFileInputStream);
        AppiumServiceBuilder appiumDriverLocalService = new AppiumServiceBuilder()
                .withAppiumJS(new File(appiumDriverProperties.getProperty("appiumJsPath")))
                .usingDriverExecutable(new File(appiumDriverProperties.getProperty("driverExecutablePath")))
                .withIPAddress(appiumDriverProperties.getProperty("ipAddress"))
                .usingPort(Integer.parseInt(appiumDriverProperties.getProperty("port")));
        server = AppiumDriverLocalService.buildService(appiumDriverLocalService);
        server.start();

        Properties androidDriverProperties = new Properties();
        FileInputStream androidFileInputStream = new FileInputStream("src/main/resources/androidDriver.properties");
        androidDriverProperties.load(androidFileInputStream);
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(androidDriverProperties.getProperty("deviceName"));
        options.setApp(androidDriverProperties.getProperty("appPath"));
        options.setAutomationName(androidDriverProperties.getProperty("automationName"));

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        server.stop();
    }

}
