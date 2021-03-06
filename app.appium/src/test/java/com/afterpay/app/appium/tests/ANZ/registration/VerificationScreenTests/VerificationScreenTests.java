package com.afterpay.app.appium.tests.ANZ.registration.VerificationScreenTests;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.afterpay.app.appium.models.data_models.CreateAccountData;
import com.afterpay.app.appium.models.data_providers.CsvToCreateAccountData;
import com.afterpay.app.appium.tests.ANZ.BaseTest;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.qameta.allure.Allure.step;

public class VerificationScreenTests extends BaseTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/data_resources/SuccessfulCreateAccountData.csv", numLinesToSkip = 1)
    public void verifyErrorForInvalidCode(@CsvToCreateAccountData CreateAccountData createAccountData)
            throws FileNotFoundException, IOException, ParseException {
        createAccountScreen.enterAllCreateAccountDetails(createAccountData);
        createAccountScreen.clickContinueButton();
        verificationScreen.enterVerificationCode(createAccountData);
        Assert.assertEquals(getErrorCodeFromJSONFile("verificationError"), verificationScreen.getIncorrectCodeError());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data_resources/SuccessfulCreateAccountData.csv", numLinesToSkip = 1)
    public void verifyToastAfterClickingResend(@CsvToCreateAccountData CreateAccountData createAccountData)
            throws FileNotFoundException, IOException, ParseException {

        createAccountScreen.enterAllCreateAccountDetails(createAccountData);
        createAccountScreen.clickContinueButton();
        verificationScreen.clickMobileCodeResendButton();
        Assert.assertEquals(getToastMessageFromJSONFile("verificationToast"), verificationScreen.getToastMessage());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data_resources/SuccessfulCreateAccountData.csv", numLinesToSkip = 1)
    public void verifyUserCanVerifyMobileNumber(@CsvToCreateAccountData CreateAccountData createAccountData)
            throws FileNotFoundException, IOException, ParseException {

        createAccountScreen.enterAllCreateAccountDetails(createAccountData);
        createAccountScreen.clickContinueButton();

        step("Verify verification screen is displayed");
        Assert.assertTrue(verificationScreen.verifyVerificationScreenIsLoaded());
    }
}
