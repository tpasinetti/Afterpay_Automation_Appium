package com.afterpay.app.appium.screens.registration.SMSVerification;

import com.afterpay.app.appium.models.data_models.ANZ_CreateAccountData;

public interface SMSVerification {
    
    public String getScreenTitle();
    public String getIncorrectCodeError();
    public String getToastMessage();

    public void setVerificationCode(String code);

    public void clickMobileCodeResendButton();

    public Boolean verifyVerificationScreenIsLoaded();

    public void enterVerificationCode(ANZ_CreateAccountData createAccountData);
}