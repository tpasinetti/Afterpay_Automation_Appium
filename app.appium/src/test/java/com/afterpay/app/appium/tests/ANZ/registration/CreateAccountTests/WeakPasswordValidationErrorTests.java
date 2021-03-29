package com.afterpay.app.appium.tests.ANZ.registration.CreateAccountTests;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.afterpay.app.appium.models.data_models.CreateAccountData;
import com.afterpay.app.appium.models.data_providers.CsvToCreateAccountData;
import com.afterpay.app.appium.tests.ANZ.BaseTest;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import static io.qameta.allure.Allure.step;

public class WeakPasswordValidationErrorTests extends BaseTest {

    @Severity(SeverityLevel.CRITICAL)
    @Feature("Verify weak password validation")
    @Story("User is shown a registration errow when trying to create an account with a weak password")
    @Link("https://link_to_notion_placeholder")
    @Description("This test verifies the weak password verification error message")
    @CsvFileSource(resources = "/data_resources/CreateAccountWeakPasswordData.csv", numLinesToSkip = 1)
    @ParameterizedTest
    public void verifyWeakPasswordError(@CsvToCreateAccountData CreateAccountData createAccountData)
            throws FileNotFoundException, IOException, ParseException {
        step("Open Create account page");
        createAccountScreen.enterAllCreateAccountDetails(createAccountData);
        createAccountScreen.clickContinueButton();
        Assert.assertEquals(getErrorCodeFromJSONFile("weakPasswordError"),
                createAccountScreen.getRegistrationErrorMessage());
    }
}
