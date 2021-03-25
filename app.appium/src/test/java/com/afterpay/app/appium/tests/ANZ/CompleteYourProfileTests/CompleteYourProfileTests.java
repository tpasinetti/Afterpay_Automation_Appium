package com.afterpay.app.appium.tests.ANZ.CompleteYourProfileTests;

import com.afterpay.app.appium.models.data_models.ANZ_CreateAccountData;
import com.afterpay.app.appium.models.data_providers.CsvToCreateAccountData;
import com.afterpay.app.appium.tests.ANZ.BaseTest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CompleteYourProfileTests extends BaseTest{
    
    @ParameterizedTest
    @CsvFileSource(resources = "/data_resources/ValidCreateAccountDetails.csv", numLinesToSkip = 1)
    public void verifyScreenTitle(
            @CsvToCreateAccountData ANZ_CreateAccountData createAccountData) {

        createAccountScreen.enterAllCreateAccountDetails(createAccountData);
        createAccountScreen.clickContinueButton();
        verificationScreen.enterVerificationCode("111111");
        completeYourProfileScreen.getScreenTitle();

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data_resources/ValidCreateAccountDetails.csv", numLinesToSkip = 1)
    public void enterFirstName( @CsvToCreateAccountData ANZ_CreateAccountData createAccountData){
        createAccountScreen.enterAllCreateAccountDetails(createAccountData);
        createAccountScreen.clickContinueButton();
        verificationScreen.enterVerificationCode("111111");
        completeYourProfileScreen.setFirstName("Tinika");

    }


}
