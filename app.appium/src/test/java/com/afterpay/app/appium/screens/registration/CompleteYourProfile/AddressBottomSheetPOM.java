package com.afterpay.app.appium.screens.registration.CompleteYourProfile;

import com.afterpay.app.appium.appium_infrastructure.AppiumController;
import com.afterpay.app.appium.appium_infrastructure.AppiumHelper;
import com.afterpay.app.appium.models.data_models.ANZ_CreateAccountData;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddressBottomSheetPOM extends AppiumHelper implements AddressBottomSheet{

    public AppiumController appiumController = new AppiumController();

    // Constructor
    public AddressBottomSheetPOM(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //LOCATORS
    @FindBy(id = "com.afterpaymobile.qatest:id/auto_address_entry")
    MobileElement addressEntryBottomSheet;

    @FindBy(xpath = "//android.widget.EditText[@text='Residential address']")
    MobileElement autoAddressSearchField;
    
    @FindBy(id = "com.afterpaymobile.qatest:id/address_search_suggestions")
    MobileElement searchSuggestions;

    //METHODS
    @Override
    public Boolean isBottomSheetDisplayed() {
        return addressEntryBottomSheet.isDisplayed();
    }

    @Override
    public void enterAddressString(ANZ_CreateAccountData createAccountData) {
        inputString(autoAddressSearchField, createAccountData.getAddress());
        selectAddressSuggestionByIndex(1);
    }

    @Override
    public void selectAddressSuggestionByIndex(int index) {
        AppiumController.instance.driver.findElementsById("com.afterpaymobile.qatest:id/suggestion_description").get(index).click();
    }

    

    
}
