package com.afterpay.app.appium.screens.registration.CompleteYourProfile;

import com.afterpay.app.appium.models.data_models.CreateAccountData;

public interface DOBPicker {
    
    public void enterDOBString(CreateAccountData createAccountData);
    public void selectDOBDay(String day);
    public void selectDOBYear(String year);
    public void clickDatePickerSelectButton();
    public void clickDOBManualEntryIcon();

    public void selectDOBFromPicker(CreateAccountData createAccountData);

}
