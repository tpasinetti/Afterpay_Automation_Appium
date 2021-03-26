package com.afterpay.app.appium.screens.registration.CompleteYourProfile;

import com.afterpay.app.appium.models.data_models.ANZ_CreateAccountData;

public interface CompleteYourProfile {
    
    public String getScreenTitle();

    public void enterFirstNameField(String firstName);
    public void enterMiddleNameField(String middleName);
    public void enterLastNameField(String lastName);
    public void enterDOBString(String dob);

    public void openDOBPicker();
    public void selectDOBDay(String day);
    public void selectDOBYear(String year);
    public void clickDatePickerSelectButton();

    public void openAddressBottomSheet();

    public void clickAgreeAndContinueButton();

    public void enterNameDetails(ANZ_CreateAccountData createAccountData);
    public void selectDOBFromPicker(ANZ_CreateAccountData createAccountData);
}
