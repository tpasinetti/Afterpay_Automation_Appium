package com.afterpay.app.appium.screens.registration.CompleteYourProfile;

import com.afterpay.app.appium.models.data_models.CreateAccountData;

public interface AddressBottomSheet {

    public Boolean isBottomSheetDisplayed();
    public void enterAddress(String address);
    public void enterAddressAndSelectSuggestionByIndex(CreateAccountData createAccountData, int index);
    public void selectAddressSuggestionByIndex(int index);

    public String getAddressSearchSuggestionError();
    
}
