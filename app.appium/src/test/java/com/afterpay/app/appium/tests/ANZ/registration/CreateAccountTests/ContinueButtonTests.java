package com.afterpay.app.appium.tests.ANZ.registration.CreateAccountTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import com.afterpay.app.appium.models.data_models.ANZ_CreateAccountData;
import com.afterpay.app.appium.models.data_providers.CsvToCreateAccountData;
import com.afterpay.app.appium.tests.ANZ.BaseTest;

import org.junit.Assert;

public class ContinueButtonTests extends BaseTest{
    
    
    @Test
    public void verifyContinueButtonIsDisabled() {
        Assert.assertEquals(false, createAccountScreen.isContinueButtonEnabled());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data_resources/SuccessfulCreateAccountData.csv", numLinesToSkip = 1)
    public void verifyVerificationScreenAfterSuccessfulCreateAccount(@CsvToCreateAccountData ANZ_CreateAccountData createAccountData)
            throws InterruptedException {
        createAccountScreen.enterAllCreateAccountDetails(createAccountData);
        createAccountScreen.clickContinueButton();
        Assert.assertTrue(verificationScreen.verifyVerificationScreenIsLoaded());
    }
}
