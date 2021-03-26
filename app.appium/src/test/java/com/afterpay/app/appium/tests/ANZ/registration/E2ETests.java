package com.afterpay.app.appium.tests.ANZ.registration;


import com.afterpay.app.appium.models.data_models.ANZ_CreateAccountData;
import com.afterpay.app.appium.models.data_providers.CsvToCreateAccountData;
import com.afterpay.app.appium.tests.ANZ.BaseTest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import org.junit.Assert;


public class E2ETests extends BaseTest{

    @ParameterizedTest
    @CsvFileSource(resources = "/data_resources/CreateAccountData.csv", numLinesToSkip = 1)
    public void createANZUserAccount( @CsvToCreateAccountData ANZ_CreateAccountData createAccountData){
        createAccountScreen.enterAllCreateAccountDetails(createAccountData);
        createAccountScreen.clickContinueButton();

        verificationScreen.enterVerificationCode(createAccountData);

        completeYourProfileScreen.enterNameDetails(createAccountData);

        completeYourProfileScreen.openDOBPicker();
        completeYourProfileScreen.selectDOBFromPicker(createAccountData);
        completeYourProfileScreen.clickDatePickerSelectButton();

        completeYourProfileScreen.openAddressBottomSheet();

        addressBottomSheet.enterAddressString(createAccountData);

        completeYourProfileScreen.clickAgreeAndContinueButton();

        Assert.assertEquals(true, discoverScreen.discoverScreenIsDisplayed());
    }

    
}
