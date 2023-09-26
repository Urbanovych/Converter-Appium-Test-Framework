package free.unit.converter;

import io.appium.java_client.android.AndroidDriver;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;

import org.urbanovych.BaseTest;

import java.net.MalformedURLException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NavigationTest {

    private AndroidDriver driver;
    private final String temperatureLinearLayoutXpath = "//android.widget.RelativeLayout[2]/android.widget.LinearLayout";
    private final String lengthLinearLayoutXpath = "//android.widget.RelativeLayout[3]/android.widget.LinearLayout";
    private final String burgerIconId = "android:id/home";
    private final String layoutTitleId = "android:id/action_bar_title";

    @BeforeEach
    public void setup() {
        try {
            BaseTest.configureAppiumWithAndroidDriver();
            driver = BaseTest.getDriver();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    public void cleanUp() {
        BaseTest.tearDown();
    }

    @Description("Verify that user can move between category pages from start page")
    @Test
    public void moveToCategoryPageTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath(temperatureLinearLayoutXpath)).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assertEquals(driver.findElement(By.id(layoutTitleId)).getText(), "Temperature");
    }

    @Description("Verify that user can move between category pages")
    @Test
    public void moveBetweenCategoryPageTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath(temperatureLinearLayoutXpath)).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assertEquals(driver.findElement(By.id(layoutTitleId)).getText(), "Temperature");

        driver.findElement(By.id(burgerIconId)).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(lengthLinearLayoutXpath)).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assertEquals(driver.findElement(By.id(layoutTitleId)).getText(), "Length");
    }

}
