package com.afterpay.app.appium.tests.ANZ.registration.CompleteYourProfileTests;

import com.afterpay.app.appium.models.data_models.CreateAccountData;
import com.afterpay.app.appium.models.data_providers.CsvToCreateAccountData;
import com.afterpay.app.appium.tests.ANZ.BaseTest;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;



public class CompleteYourProfileTests extends BaseTest{

    
    @ParameterizedTest
    @CsvFileSource(resources = "/data_resources/ValidCreateAccountDetails.csv", numLinesToSkip = 1)
    public void verifyCompleteYourProfileScreenTitle(
            @CsvToCreateAccountData CreateAccountData createAccountData) {

        createAccountScreen.enterAllCreateAccountDetails(createAccountData);
        createAccountScreen.clickContinueButton();
        verificationScreen.enterVerificationCode(createAccountData);
        Assert.assertEquals("Complete your profile", completeYourProfileScreen.getScreenTitle());
    }

    






    

}
