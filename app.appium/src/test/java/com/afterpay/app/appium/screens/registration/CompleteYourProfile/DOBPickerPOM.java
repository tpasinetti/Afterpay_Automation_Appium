package com.afterpay.app.appium.screens.registration.CompleteYourProfile;

import com.afterpay.app.appium.appium_infrastructure.AppiumController;
import com.afterpay.app.appium.appium_infrastructure.AppiumHelper;
import com.afterpay.app.appium.models.data_models.CreateAccountData;
import com.fasterxml.jackson.databind.deser.impl.CreatorCollector;

import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

public class DOBPickerPOM extends AppiumHelper implements DOBPicker{

    //LOCATORS
    @FindBy(id = "com.afterpaymobile.qatest:id/month_grid")
    MobileElement dOBMonthGrid;

    @FindBy(id = "com.afterpaymobile.qatest:id/month_navigation_fragment_toggle")
    MobileElement dOBYearDropDown;

    @FindBy(id = "com.afterpaymobile.qatest:id/confirm_button")
    MobileElement datePickerSelectButton;

    @FindBy(id = "com.afterpaymobile.qatest:id/mtrl_picker_header_toggle")
    MobileElement dOBEntryIcon;
    
    @FindBy
    (id = "com.afterpaymobile.qatest:id/mtrl_picker_text_input_date")
    MobileElement dOBManualEntryField;

    public DOBPickerPOM(AppiumDriver<?> driver) {
    }

    //METHODS
    @Override
    public void enterDOBString(CreateAccountData createAccountData) {
       inputString(dOBManualEntryField, createAccountData.getDOBString());
    }

    @Override
    public void clickDOBManualEntryIcon() {
        clickElement(dOBEntryIcon);
    }

    @Override
    public void selectDOBDay(String day){
        clickElement(dOBMonthGrid.findElementByXPath("//android.widget.TextView[@text='"+ day + "']"));
    }

    @Override
    public void selectDOBYear(String year){
        clickElement(dOBYearDropDown);
        AndroidElement list = (AndroidElement) AppiumController.instance.driver.findElementByXPath("//android.widget.TextView[contains(@content-desc, 'Navigate to year')]");
        MobileElement yearItem = (MobileElement) AppiumController.instance.driver.findElement(
            MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
         ".scrollIntoView(new UiSelector().text(\"" + year + "\"))"));
        clickElement(yearItem);
    }

    @Override
    public void clickDatePickerSelectButton() {
        clickElement(datePickerSelectButton); 
    }

    public void selectDOB(String year, String day){
        selectDOBYear(year);
        selectDOBDay(day);
    }

    @Override
    public void selectDOBFromPicker(CreateAccountData createAccountData) {
       this.selectDOB(createAccountData.getDOBYear(), createAccountData.getDOBDay());
    }
}
