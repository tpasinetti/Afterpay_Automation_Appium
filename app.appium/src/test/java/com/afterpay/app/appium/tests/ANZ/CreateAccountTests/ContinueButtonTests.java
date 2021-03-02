package com.afterpay.app.appium.tests.ANZ.CreateAccountTests;

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
        Assert.assertEquals(false, createAccount.isContinueButtonEnabled());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dataResources/SuccessfulCreateAccountData.csv", numLinesToSkip = 1)
    public void verifyVerificationScreenAfterSuccessfulCreateAccount(@CsvToCreateAccountData ANZ_CreateAccountData createAccountData)
            throws InterruptedException {
        createAccount.enterAllCreateAccountDetails(createAccountData);
        createAccount.clickContinueButton();
        Assert.assertTrue(verification.verifyVerificationScreenIsLoaded());
    }
}
