package com.afterpay.app.appium.screens.registration.CompleteYourProfile;

import com.afterpay.app.appium.models.data_models.ANZ_CreateAccountData;

public interface AddressBottomSheet {

    public Boolean isBottomSheetDisplayed();
    public void enterAddressString(ANZ_CreateAccountData createAccountData);
    public void selectAddressSuggestionByIndex(int index);
    
}
