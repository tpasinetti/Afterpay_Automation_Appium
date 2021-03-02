package com.afterpay.app.appium.tests.ANZ.CreateAccountTests;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.afterpay.app.appium.tests.ANZ.BaseTest;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ExistingAccountErrorTests extends BaseTest{
   
    @Test
    public void verifyExistingAccountError_Mobile() throws FileNotFoundException, IOException, ParseException {
        createAccount.enterEmailTextField("t2_android@test.com");
        createAccount.enterPasswordTextField("111");
        createAccount.enterMobileNumber("0402599157"); // mobile number already been used
        createAccount.clickContinueButton();
        Assert.assertEquals(getErrorCodeFromJSONFile("existingAccountError"),
                createAccount.getRegistrationErrorMessage());

    }

    // // need to check if we allow same email address
    // @ParameterizedTest
    // @CsvFileSource(resources = "/dataResources/CreateAccountData.csv",
    // numLinesToSkip = 1)
    // public void verifyExistingAccountError_Email(@CsvToCreateAccountData
    // ANZ_CreateAccountData createAccountData)
    // throws InterruptedException, FileNotFoundException, IOException,
    // ParseException {

    // createAccount.enterEmailTextField(createAccountData.getEmail()); // email
    // already been used
    // createAccount.enterPasswordTextField(createAccountData.getPassword());
    // createAccount.enterMobileNumber(createAccountData.getMobileNumber());
    // createAccount.clickContinueButton();

    // Assert.assertEquals(getErrorCodeFromJSONFile("existingAccountError"),
    // createAccount.getRegistrationErrorMessage());

    // }
}
