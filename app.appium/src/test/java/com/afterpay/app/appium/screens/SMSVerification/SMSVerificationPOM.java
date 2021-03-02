package com.afterpay.app.appium.screens.SMSVerification;

import com.afterpay.app.appium.appium_infrastructure.AppiumController;
import com.afterpay.app.appium.appium_infrastructure.AppiumHelper;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SMSVerificationPOM extends AppiumHelper implements SMSVerification{
    public AppiumController appiumController = new AppiumController();

    public SMSVerificationPOM(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    //LOCATORS
    @FindBy(id = "com.afterpaymobile:id/title")
    MobileElement screenTitle;

    @FindBy(id = "com.afterpaymobile:id/code_entry_error_view")
    MobileElement codeError;

    @FindBy(id = "com.afterpaymobile:id/snackbar_message")
    MobileElement toastMessage;

    //BUTTON
    @FindBy(id="com.afterpaymobile:id/verify_mobile_resend_button")
    MobileElement mobileCodeResendButton;

    //FIELD
    @FindBy(id = "com.afterpaymobile:id/internal_entry_view")
    MobileElement codeEntryField;


    /*
    METHODS
    **/

    //GET
    @Override
    public String getScreenTitle() {
        return getText(screenTitle);
    }

    @Override
    public String getIncorrectCodeError() {
        return getText(codeError);
    }

    //SET
    @Override
    public void enterVerificationCode(String stringToBeEntered) {
       inputString(codeEntryField, stringToBeEntered);

    }

    //BUTTON
    @Override
    public void clickMobileCodeResendButton() {
      clickElement(mobileCodeResendButton);
    }

    //GENERAL
    @Override
    public Boolean verifyVerificationScreenIsLoaded() {
        WebDriverWait wait=new WebDriverWait(AppiumController.instance.driver, 120);
        return wait.until(ExpectedConditions.textToBePresentInElement(screenTitle, "Confirm your mobile"));
    }

    @Override
    public String getToastMessage() {
        return getText(toastMessage);
    }

    
}
