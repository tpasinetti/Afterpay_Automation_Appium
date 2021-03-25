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
import org.junit.jupiter.params.provider.CsvSource;

public class ExistingAccountErrorTests extends BaseTest {

    @Test
    public void verifyExistingAccountError_Mobile() throws FileNotFoundException, IOException, ParseException {
        createAccountScreen.enterEmailTextField("t2_android@test.com");
        createAccountScreen.enterPasswordTextField("111");
        createAccountScreen.enterMobileNumber("0402599157"); // mobile number already been used
        createAccountScreen.clickContinueButton();
        Assert.assertEquals(getErrorCodeFromJSONFile("existingAccountError"),
                createAccountScreen.getRegistrationErrorMessage());

    }

    // need to check if we allow same email address
    @ParameterizedTest
    @CsvSource({ "existingemail@test.com,Test@123,0402888551" })
    public void verifyExistingAccountError_Email(@CsvToCreateAccountData ANZ_CreateAccountData createAccountData)
            throws InterruptedException, FileNotFoundException, IOException, ParseException {

        createAccountScreen.enterAllCreateAccountDetails(createAccountData); // email already in use
        createAccountScreen.clickContinueButton();
        Assert.assertEquals(getErrorCodeFromJSONFile("existingAccountError"),
                createAccountScreen.getRegistrationErrorMessage());

    }
}
