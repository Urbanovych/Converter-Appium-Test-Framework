package free.unit.converter;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import jdk.jfr.Description;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.urbanovych.BaseTest;

import java.net.MalformedURLException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MeasureTest {

    private AndroidDriver driver;
    private final String temperatureLinearLayoutXpath = "//android.widget.RelativeLayout[2]/android.widget.LinearLayout";
    private final String celsiusXpath = "//android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView";
    private final String fahrenheitXpath = "//android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView";
    private final String kelvinXpath = "//android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.RelativeLayout[1]/android.widget.TextView";
    private Dimension size;

    @BeforeEach
    public void setup() {
        try {
            BaseTest.configureAppiumWithAndroidDriver();
            driver = BaseTest.getDriver();
            size = driver.manage().window().getSize();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    public void cleanUp() {
        BaseTest.tearDown();
    }

    @Test
    public void s() {
        System.out.println(size.getHeight());
        System.out.println(size.getWidth());

        System.out.println(size.getHeight() * 0.4);
        System.out.println(size.getWidth() * 0.3);
        System.out.println(size.getWidth() * 0.23);
    }

    @Description("Verify that user can change measure unit to fahrenheit from celsius")
    @Test
    public void changeMeasureToFahrenheitTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath(temperatureLinearLayoutXpath)).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//        Sequence dragNDrop = new Sequence(finger, 1)
//                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), (int) (size.getHeight() * 0.4), (int) (size.getWidth() * 0.3)))
//                .addAction(finger.createPointerUp(PointerInput.MouseButton.FORWARD.asArg()))
//                .addAction(new Pause(finger, Duration.ofMillis(500)))
//                .addAction(finger.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), (int) (size.getHeight() * 0.4), (int) (size.getWidth() * 0.23)))
//                .addAction(finger.createPointerDown(PointerInput.MouseButton.BACK.asArg()));
//        driver.perform(Collections.singletonList(dragNDrop));

        TouchAction swipeToFahrenheit = new TouchAction(driver);
        swipeToFahrenheit
                .press(PointOption.point((int) (size.getHeight() * 0.4), (int) (size.getWidth() * 0.3)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point((int) (size.getHeight() * 0.4), (int) (size.getWidth() * 0.20)))
                .perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assertEquals(driver.findElement(By.xpath(celsiusXpath)).getText(), "-17.22222");
        assertEquals(driver.findElement(By.xpath(fahrenheitXpath)).getText(), "1");
        assertEquals(driver.findElement(By.xpath(kelvinXpath)).getText(), "255.92777");
    }

    @Description("Verify that user can change measure unit to fahrenheit from celsius")
    @Test
    public void changeMeasureToKelvinTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath(temperatureLinearLayoutXpath)).click();

        assertEquals(driver.findElement(By.xpath(celsiusXpath)).getText(), "-272.15");
        assertEquals(driver.findElement(By.xpath(fahrenheitXpath)).getText(), "-457.86998");
        assertEquals(driver.findElement(By.xpath(kelvinXpath)).getText(), "1");
    }
}
