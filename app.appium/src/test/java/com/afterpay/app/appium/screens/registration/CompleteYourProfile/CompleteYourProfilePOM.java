package com.afterpay.app.appium.screens.registration.CompleteYourProfile;

import com.afterpay.app.appium.appium_infrastructure.AppiumController;
import com.afterpay.app.appium.appium_infrastructure.AppiumHelper;
import com.afterpay.app.appium.models.data_models.ANZ_CreateAccountData;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CompleteYourProfilePOM extends AppiumHelper implements CompleteYourProfile {
    
    public AppiumController appiumController = new AppiumController();

     //LOCATORS
     @FindBy(id = "com.afterpaymobile.qatest:id/title")
     MobileElement screenTitle;

     @FindBy(xpath = "//android.widget.EditText[@text='Legal first name']")
     MobileElement firstNameField;

     @FindBy(xpath = "//android.widget.EditText[@text='Legal middle name']")
     MobileElement middleNameField;

     @FindBy(xpath = "//android.widget.EditText[@text='Legal last name']")
     MobileElement lastNameField;

     @FindBy(id = "com.afterpaymobile.qatest:id/submit_button")
     MobileElement agreeAndContinueButton;

    //DOB LOCATORS
    @FindBy(id = "com.afterpaymobile.qatest:id/profile_creation_dob")
    MobileElement dOBPicker;

    @FindBy(id = "com.afterpaymobile.qatest:id/month_grid")
    MobileElement dOBMonthGrid;

    @FindBy(id = "com.afterpaymobile.qatest:id/month_navigation_fragment_toggle")
    MobileElement dOBYearDropDown;

    @FindBy(id = "com.afterpaymobile.qatest:id/confirm_button")
    MobileElement datePickerSelectButton;

    //ADDRESS
    @FindBy(xpath = "//android.widget.EditText[@text='Residential address']")
    MobileElement addressField;

    public CompleteYourProfilePOM(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Override
    public String getScreenTitle() {
        return getText(screenTitle);
    }

    @Override
    public void enterFirstNameField(String firstName) {
        inputString(firstNameField, firstName);
    }

    @Override
    public void enterMiddleNameField(String middleName) {
        inputString(middleNameField, middleName);
    }

    @Override
    public void enterLastNameField(String lastName) {
        inputString(lastNameField, lastName);
    }

    @Override
    public void enterDOBString(String dob) {
    }

    //DOB
    @Override
    public void openDOBPicker() {
        clickElement(dOBPicker);
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
         ".scrollIntoView(new UiSelector().text(\"1993\"))"));
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
    public void openAddressBottomSheet() {
        clickElement(addressField);
    }

    @Override
    public void clickAgreeAndContinueButton() {
        clickElement(agreeAndContinueButton);
    }

    @Override
    public void enterNameDetails(ANZ_CreateAccountData createAccountData) {
       this.enterFirstNameField(createAccountData.getFirstName());
       this.enterMiddleNameField(createAccountData.getMiddleName());
       this.enterLastNameField(createAccountData.getLastName());
    }

    @Override
    public void selectDOBFromPicker(ANZ_CreateAccountData createAccountData) {
       this.selectDOB(createAccountData.getDOBYear(), createAccountData.getDOBDay());
    }

    
  

    
    


    
    
}
