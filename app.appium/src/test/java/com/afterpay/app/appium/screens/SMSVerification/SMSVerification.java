package com.afterpay.app.appium.screens.SMSVerification;

public interface SMSVerification {
    
    public String getScreenTitle();
    public String getIncorrectCodeError();
    public String getToastMessage();

    public void clickMobileCodeResendButton();

    public Boolean verifyVerificationScreenIsLoaded();

    public void enterVerificationCode(String stringToBeEntered);
}
