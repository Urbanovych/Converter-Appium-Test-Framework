package free.unit.converter;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import org.urbanovych.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NavigationTest extends BaseTest {

    private final String layoutTitleId = "android:id/action_bar_title";

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
