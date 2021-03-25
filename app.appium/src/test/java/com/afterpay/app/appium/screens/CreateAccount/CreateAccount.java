package com.afterpay.app.appium.screens.CreateAccount;

import com.afterpay.app.appium.models.data_models.ANZ_CreateAccountData;

public interface CreateAccount {
    
    //SET
    public void enterEmailTextField(String email);
    public void enterPasswordTextField(String password);
    public void enterMobileNumber(String mobile);

    //GET
    public String getEmailErrorMessage();
    public String getMobileErrorMessage();
    public String getRegistrationErrorMessage();
    public String getTitle();
    public String getDialCode();

    //BUTTONS
    public void clickContinueButton();
    public Boolean isContinueButtonEnabled();

    //ACTIONS
    public void enterAllCreateAccountDetails(ANZ_CreateAccountData createAccountData);
    public void clickCountryDropDown();
    public void selectNZFromCountryFlagPicker();
}

