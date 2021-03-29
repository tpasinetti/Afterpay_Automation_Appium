package com.afterpay.app.appium.screens.registration.CompleteYourProfile;

import com.afterpay.app.appium.models.data_models.CreateAccountData;

public interface CompleteYourProfile {
    
    public String getScreenTitle();

    public void enterFirstNameField(CreateAccountData createAccountData);
    public void enterMiddleNameField(CreateAccountData createAccountData);
    public void enterLastNameField(CreateAccountData createAccountData);
    public void enterNameDetails(CreateAccountData createAccountData);
    
    public void openDOBPicker();
    public String getDOBError();
    
    public void openAddressBottomSheet();
    public void clickAgreeAndContinueButton();
}
