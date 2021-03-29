package com.afterpay.app.appium.tests.ANZ.registration.CompleteYourProfileTests;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.afterpay.app.appium.models.data_models.CreateAccountData;
import com.afterpay.app.appium.models.data_providers.CsvToCreateAccountData;
import com.afterpay.app.appium.tests.ANZ.BaseTest;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class AddressTests extends BaseTest{
    
    @ParameterizedTest
    @CsvFileSource(resources = "/data_resources/CreateAccountData.csv", numLinesToSkip = 1)
    public void verifyNoSearchResultsForAddressSearch(
            @CsvToCreateAccountData CreateAccountData createAccountData) throws FileNotFoundException, IOException, ParseException {

        createAccountScreen.enterAllCreateAccountDetails(createAccountData);
        createAccountScreen.clickContinueButton();
        verificationScreen.enterVerificationCode(createAccountData);
        completeYourProfileScreen.enterNameDetails(createAccountData);
        completeYourProfileScreen.openAddressBottomSheet();
        addressBottomSheet.enterAddress("adjfanjfakjf");
        
        Assert.assertEquals(addressBottomSheet.getAddressSearchSuggestionError(), getErrorCodeFromJSONFile("addressSearchError"));
    }
    

}
