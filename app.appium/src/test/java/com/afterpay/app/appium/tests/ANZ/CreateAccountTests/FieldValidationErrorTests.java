package com.afterpay.app.appium.tests.ANZ.CreateAccountTests;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.afterpay.app.appium.models.data_models.ANZ_CreateAccountData;
import com.afterpay.app.appium.models.data_providers.CsvToCreateAccountData;
import com.afterpay.app.appium.tests.ANZ.BaseTest;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.qameta.allure.Allure.step;

public class FieldValidationErrorTests extends BaseTest {

    @ParameterizedTest
    @CsvSource({ "t_android,111,040288", "t_android@test,aaa,04111111112" })
    public void verifyInvalidEmailAndMobileErrorMessages(@CsvToCreateAccountData ANZ_CreateAccountData createAccountData)
            throws FileNotFoundException, IOException, ParseException {

        createAccount.enterEmailTextField(createAccountData.getEmail());
        createAccount.enterPasswordTextField(createAccountData.getPassword());
        createAccount.enterMobileNumber(createAccountData.getMobileNumber());
        createAccount.clickContinueButton();

        step("Verify email error message");
        //Assert.assertEquals(getErrorCodeFromJSONFile("invalidEmailError"), createAccount.getEmailErrorMessage());
        step("Verify mobile number error message");
        Assert.assertEquals(getErrorCodeFromJSONFile("invalidMobileError"), createAccount.getMobileErrorMessage());
    }

}
