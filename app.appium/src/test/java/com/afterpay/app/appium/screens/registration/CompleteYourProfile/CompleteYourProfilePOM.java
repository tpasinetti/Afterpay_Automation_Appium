package com.afterpay.app.appium.screens.registration.CompleteYourProfile;

import com.afterpay.app.appium.appium_infrastructure.AppiumController;
import com.afterpay.app.appium.appium_infrastructure.AppiumHelper;
import com.afterpay.app.appium.models.data_models.CreateAccountData;

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

    @FindBy(id = "com.afterpaymobile.qatest:id/error_message")
    MobileElement dOBErrorMessage;

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
    public void enterFirstNameField(CreateAccountData createAccountData) {
        inputString(firstNameField, createAccountData.getFirstName());
    }

    @Override
    public void enterMiddleNameField(CreateAccountData createAccountData) {
        inputString(middleNameField, createAccountData.getMiddleName());
    }

    @Override
    public void enterLastNameField(CreateAccountData createAccountData) {
        inputString(lastNameField, createAccountData.getLastName());
    }

    
    //DOB
    @Override
    public void openDOBPicker() {
        clickElement(dOBPicker);
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
    public void enterNameDetails(CreateAccountData createAccountData) {
       this.enterFirstNameField(createAccountData);
       this.enterMiddleNameField(createAccountData);
       this.enterLastNameField(createAccountData);
    }

    @Override
    public String getDOBError() {
        return getText(dOBErrorMessage);
    }

    
  

    
    


    
    
}
