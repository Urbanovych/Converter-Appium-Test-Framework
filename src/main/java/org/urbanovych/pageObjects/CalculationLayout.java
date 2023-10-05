package org.urbanovych.pageObjects;

import static org.urbanovych.wait.WaitHelper.clickVisibleElementById;

public class CalculationLayout {

    private static final String numberFiveCalcBtnId = "com.unitconverter.freeunitconversioncalculator:id/petica";
    private static final String okCalcBtnId = "com.unitconverter.freeunitconversioncalculator:id/spustitastaturu";
    private static final String calcIconId = "com.unitconverter.freeunitconversioncalculator:id/imageView16";
    private static final String clearAllCalcBtnId = "com.unitconverter.freeunitconversioncalculator:id/clear";
    private static final String deleteSymbolCalcBtnId = "com.unitconverter.freeunitconversioncalculator:id/delete";
    private static final String plusMinusCalcBtnId = "com.unitconverter.freeunitconversioncalculator:id/plusminus";
    private static final String commaCalcBtnId = "com.unitconverter.freeunitconversioncalculator:id/zarez";

    public static void clickOkCalculationButton() {
        clickVisibleElementById(okCalcBtnId);
    }

    public static void clickNumberFive() {
        clickVisibleElementById(numberFiveCalcBtnId);
    }

    public static void clickCalculationIcon() {
        clickVisibleElementById(calcIconId);
    }

    public static void clickClearAllCalculationButton() {
        clickVisibleElementById(clearAllCalcBtnId);
    }

    public static void clickDeleteSymbolButton() {
        clickVisibleElementById(deleteSymbolCalcBtnId);
    }

    public static void clickPlusMinusButton() {
        clickVisibleElementById(plusMinusCalcBtnId);
    }

    public static void clickCommaCalcButton() {
        clickVisibleElementById(commaCalcBtnId);
    }

}
