package free.unit.converter;

import io.appium.java_client.android.AndroidDriver;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;

import org.urbanovych.BaseTest;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.urbanovych.BaseTest.*;

public class NavigationTest {

    private AndroidDriver driver;
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
        clickTemperatureLayout();
        waitForPageLoaded();

        assertEquals(driver.findElement(By.id(layoutTitleId)).getText(), "Temperature");
    }

    @Description("Verify that user can move between category pages")
    @Test
    public void moveBetweenCategoryPageTest() {
        clickTemperatureLayout();
        waitForPageLoaded();

        assertEquals(driver.findElement(By.id(layoutTitleId)).getText(), "Temperature");

        clickBurgerIcon();
        clickLengthLayout();
        waitForPageLoaded();

        assertEquals(driver.findElement(By.id(layoutTitleId)).getText(), "Length");
    }

}
