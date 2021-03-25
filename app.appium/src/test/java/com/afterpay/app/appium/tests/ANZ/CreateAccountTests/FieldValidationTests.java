package com.afterpay.app.appium.tests.ANZ.CreateAccountTests;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.afterpay.app.appium.models.data_models.ANZ_CreateAccountData;
import com.afterpay.app.appium.models.data_providers.CsvToCreateAccountData;
import com.afterpay.app.appium.tests.ANZ.BaseTest;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static io.qameta.allure.Allure.step;

public class FieldValidationTests extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/data_resources/InvalidCreateAccountDetailsd.csv", numLinesToSkip = 1)
    public void verifyInvalidEmailAndMobileErrorMessages(
            @CsvToCreateAccountData ANZ_CreateAccountData createAccountData)
            throws FileNotFoundException, IOException, ParseException {

        createAccountScreen.enterAllCreateAccountDetails(createAccountData);
        createAccountScreen.clickContinueButton();

        step("Verify email error message");
        Assert.assertEquals(getErrorCodeFromJSONFile("invalidEmailError"), createAccountScreen.getEmailErrorMessage());
        step("Verify mobile number error message");
        Assert.assertEquals(getErrorCodeFromJSONFile("invalidMobileError"),
                createAccountScreen.getMobileErrorMessage());
    }

    @ParameterizedTest
    @CsvSource({ "1903_6@test.com,Test@123,0402888551" })
    public void verifyUserCanEnterMobileNumberWithLeadingZero(
            @CsvToCreateAccountData ANZ_CreateAccountData createAccountData)
            throws FileNotFoundException, IOException, ParseException {

        createAccountScreen.enterAllCreateAccountDetails(createAccountData);
        createAccountScreen.clickContinueButton();

        step("Verify verification screen is displayed");
        Assert.assertTrue(verificationScreen.verifyVerificationScreenIsLoaded());
    }

    @Test
    public void verifyCountryDialCodes() {

        step("Verify AU dial code is +61");
        Assert.assertEquals("+61",createAccountScreen.getDialCode());

        step("Select NZ from the country flag picker");
        createAccountScreen.clickCountryDropDown();
        createAccountScreen.selectNZFromCountryFlagPicker();


        step("Verify NZ dial code is +64");
        Assert.assertEquals("+64",createAccountScreen.getDialCode());

       
    }



}
