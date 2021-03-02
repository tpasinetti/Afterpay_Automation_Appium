package com.afterpay.app.appium.tests.ANZ.VerificationScreenTests;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.afterpay.app.appium.models.data_models.ANZ_CreateAccountData;
import com.afterpay.app.appium.models.data_providers.CsvToCreateAccountData;
import com.afterpay.app.appium.tests.ANZ.BaseTest;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class VerificationScreenTests extends BaseTest{
    @ParameterizedTest
    @CsvFileSource(resources = "/dataResources/SuccessfulCreateAccountData.csv", numLinesToSkip = 1)
    public void verifyErrorForInvalidCode(@CsvToCreateAccountData ANZ_CreateAccountData createAccountData)
            throws FileNotFoundException, IOException, ParseException {
        createAccount.enterAllCreateAccountDetails(createAccountData);
        createAccount.clickContinueButton();
        verification.enterVerificationCode("222222");
        Assert.assertEquals(getErrorCodeFromJSONFile("verificationError"), verification.getIncorrectCodeError());
    }

    // @ParameterizedTest
    // @CsvFileSource(resources = "/dataResources/SuccessfulCreateAccountData.csv", numLinesToSkip = 1)
    // public void clickResendButtonAndVerifyToast(@CsvToCreateAccountData CreateAccountData createAccountData) {

    //     createAccount.enterAllCreateAccountDetails(createAccountData);
    //     createAccount.clickContinueButton();
    //     verification.clickMobileCodeResendButton();

    // }
}
