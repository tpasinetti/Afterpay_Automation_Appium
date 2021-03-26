package com.afterpay.app.appium.screens.registration.CreateAccount;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import static io.qameta.allure.Allure.step;

import com.afterpay.app.appium.appium_infrastructure.AppiumController;
import com.afterpay.app.appium.appium_infrastructure.AppiumHelper;
import com.afterpay.app.appium.models.data_models.ANZ_CreateAccountData;

public class CreateAccountPOM extends AppiumHelper implements CreateAccount {

    public AppiumController appiumController = new AppiumController();

    // Constructor
    public CreateAccountPOM(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /*
     * LOCATORS
     */

    // EMAIL
    @FindBy(xpath = "//android.widget.EditText[@text='Email address']")
    //@FindBy(id = "com.afterpaymobile.qatest:id/registration_email")
    public MobileElement emailTextField;

    @FindBy(id = "com.afterpaymobile.qatest:id/error_message")
    public MobileElement emailErrorMessage;

    // PASSWORD
    //@FindBy(xpath = "com.afterpaymobile.qatest:id/registration_password")
    @FindBy(xpath = "//android.widget.EditText[@text='Password']")
    public MobileElement passwordTextField;

    // MOBILE NUMBER
    @FindBy(id = "com.afterpaymobile.qatest:id/phone_number_input")
    //@FindBy(xpath = "//android.widget.EditText[@text='Phone Number']")
    public MobileElement mobileNumberField;

    @FindBy(id = "com.afterpaymobile.qatest:id/country_picker")
    public MobileElement countryPicker;

    @FindBy(id="com.afterpaymobile.qatest:id/country_dial_code")
    MobileElement countryDialCode;

    @FindBy(xpath = "//android.widget.TextView[@text='New Zealand']")
    MobileElement nZCountryFromDropDown;

    @FindBy(id = "com.afterpaymobile:id/phone_number_error_view")
    public MobileElement mobileErrorMessage;

    // BUTTONS
    @FindBy(id = "com.afterpaymobile.qatest:id/submit_button")
    public MobileElement continueBtn;

    @FindBy(id = "com.afterpaymobile.qatest:id/text_input_end_icon")
    public MobileElement showPassword;

    // ERRORS
    @FindBy(id = "com.afterpaymobile.qatest:id/registration_error_message")
    public MobileElement registrationError;

    // TITLE
    @FindBy(id = "com.afterpaymobile.qatest:id/title")
    MobileElement createAccountTitle;

    //DEV SETTINGS
    @FindBy(xpath = "//android.widget.TextView[@text='Testing']")
    public MobileElement testSettings;

    @FindBy(xpath = "//android.widget.RadioButton[@text='SANDBOX']")
    public MobileElement sandboxRadioButton;

    /*
     * METHODS
     */

    @Override
    public void enterEmailTextField(String email) {
        inputString(emailTextField, email);
        step("Entered email: " + email);
    }

    @Override
    public void enterPasswordTextField(String password) {
        inputString(passwordTextField, password);
        step("Entered password: " + password);
    }

    @Override
    public void enterMobileNumber(String mobile) {
        inputString(mobileNumberField, mobile);
        step("Entered mobile number: " + mobile);
    }

    @Override
    public void clickContinueButton() {
        clickElement(continueBtn);
        step("Clicked continue button");
    }

    @Override
    public Boolean isContinueButtonEnabled() {
        step("Verify if continue button is enabled");
        return continueBtn.isEnabled();
    }

    // ONE STEP ENTER CREATE ACCOUNT DETAILS
    @Override
    public void enterAllCreateAccountDetails(ANZ_CreateAccountData createAccountData) {
        this.enterEmailTextField(createAccountData.getEmail());
        this.enterPasswordTextField(createAccountData.getPassword());
        this.enterMobileNumber(createAccountData.getMobileNumber());
    }

    // ERROR MESSAGES
    @Override
    public String getEmailErrorMessage() {
        return getText(emailErrorMessage);
    }

    @Override
    public String getMobileErrorMessage() {
        return getText(mobileErrorMessage);
    }

    @Override
    public String getRegistrationErrorMessage() {
        return getText(registrationError);
    }

    //OTHER GETTERS
    @Override
    public String getTitle() {
        return getText(createAccountTitle);
    }

    @Override
    public String getDialCode() {
        return getText(countryDialCode);
    }

    @Override
    public void selectNZFromCountryFlagPicker() {
        clickElement(nZCountryFromDropDown);
        
    }

    @Override
    public void clickCountryDropDown() {
        clickElement(countryPicker);
        
    }

  

    

    

   
    
}