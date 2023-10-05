package free.unit.converter;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import org.urbanovych.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.urbanovych.pageObjects.CategoryLayout.clickLengthLayout;
import static org.urbanovych.pageObjects.CategoryLayout.clickTemperatureLayout;
import static org.urbanovych.pageObjects.HeaderLayout.clickBurgerIcon;
import static org.urbanovych.pageObjects.HeaderLayout.getMeasurePageTitle;

public class NavigationTest extends BaseTest {


    @Description("Verify that user can move between category pages from start page")
    @Test
    public void moveToCategoryPageTest() {
        clickTemperatureLayout();

        assertEquals(getMeasurePageTitle(), "Temperature");
    }

    @Description("Verify that user can move between category pages")
    @Test
    public void moveBetweenCategoryPageTest() {
        clickTemperatureLayout();

        assertEquals(getMeasurePageTitle(), "Temperature");

        clickBurgerIcon();
        clickLengthLayout();

        assertEquals(getMeasurePageTitle(), "Length");
    }

}
