package free.unit.converter;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import jdk.jfr.Description;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.urbanovych.BaseTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MeasureTest extends BaseTest {

    private final String celsiusXpath = "//android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView";
    private final String fahrenheitXpath = "//android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView";
    private final String kelvinXpath = "//android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.RelativeLayout[1]/android.widget.TextView";
    private final String scrollBar = "//android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.ImageView";

    @Description("Verify that user can change measure unit to fahrenheit from celsius")
    @Test
    public void changeMeasureToFahrenheitTest() {
        clickTemperatureLayout();
        waitForPageLoaded();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(scrollBar)));

        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 1100, "top", 210, "width", 200, "height", 300,
                "direction", "down",
                "percent", 0.3
        ));

        assertEquals(driver.findElement(By.xpath(celsiusXpath)).getText(), "-17.22222");
        assertEquals(driver.findElement(By.xpath(fahrenheitXpath)).getText(), "1");
        assertEquals(driver.findElement(By.xpath(kelvinXpath)).getText(), "255.92777");
    }

    @Description("Verify that user can change measure unit to fahrenheit from celsius")
    @Test
    public void changeMeasureToKelvinTest() {
        clickTemperatureLayout();
        waitForPageLoaded();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(scrollBar)));

        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 1100, "top", 210, "width", 200, "height", 300,
                "direction", "down",
                "percent", 1.0
        ));

        assertEquals(driver.findElement(By.xpath(celsiusXpath)).getText(), "-272.15");
        assertEquals(driver.findElement(By.xpath(fahrenheitXpath)).getText(), "-457.86998");
        assertEquals(driver.findElement(By.xpath(kelvinXpath)).getText(), "1");
    }
}
