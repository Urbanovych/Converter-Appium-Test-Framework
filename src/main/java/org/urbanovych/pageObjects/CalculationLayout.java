package org.urbanovych.pageObjects;

import static org.urbanovych.actions.click.ClickHelper.makeClickById;

public class CalculationLayout {

    private static final String numberFiveCalcBtnId = "com.unitconverter.freeunitconversioncalculator:id/petica";
    private static final String okCalcBtnId = "com.unitconverter.freeunitconversioncalculator:id/spustitastaturu";
    private static final String calcIconId = "com.unitconverter.freeunitconversioncalculator:id/imageView16";
    private static final String clearAllCalcBtnId = "com.unitconverter.freeunitconversioncalculator:id/clear";
    private static final String deleteSymbolCalcBtnId = "com.unitconverter.freeunitconversioncalculator:id/delete";
    private static final String plusMinusCalcBtnId = "com.unitconverter.freeunitconversioncalculator:id/plusminus";
    private static final String commaCalcBtnId = "com.unitconverter.freeunitconversioncalculator:id/zarez";

    public static void clickOkCalculationButton() {
        makeClickById(okCalcBtnId);
    }

    public static void clickNumberFive() {
        makeClickById(numberFiveCalcBtnId);
    }

    public static void clickCalculationIcon() {
        makeClickById(calcIconId);
    }

    public static void clickClearAllCalculationButton() {
        makeClickById(clearAllCalcBtnId);
    }

    public static void clickDeleteSymbolButton() {
        makeClickById(deleteSymbolCalcBtnId);
    }

    public static void clickPlusMinusButton() {
        makeClickById(plusMinusCalcBtnId);
    }

    public static void clickCommaCalcButton() {
        makeClickById(commaCalcBtnId);
    }

}
