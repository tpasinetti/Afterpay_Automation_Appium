package com.afterpay.app.appium.tests.ANZ;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.afterpay.app.appium.appium_infrastructure.AppiumBaseClass;
import com.afterpay.app.appium.appium_infrastructure.AppiumController;
import com.afterpay.app.appium.appium_infrastructure.AppiumController.VARIANT;
import com.afterpay.app.appium.screens.home.DiscoverScreen;
import com.afterpay.app.appium.screens.home.DiscoverScreenPOM;
import com.afterpay.app.appium.screens.registration.CompleteYourProfile.AddressBottomSheetPOM;
import com.afterpay.app.appium.screens.registration.CompleteYourProfile.CompleteYourProfilePOM;
import com.afterpay.app.appium.screens.registration.CompleteYourProfile.DOBPickerPOM;
import com.afterpay.app.appium.screens.registration.CreateAccount.CreateAccountPOM;
import com.afterpay.app.appium.screens.registration.SMSVerification.SMSVerificationPOM;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest extends AppiumBaseClass{
    
  
	protected CreateAccountPOM createAccountScreen;
	protected SMSVerificationPOM verificationScreen;
	protected CompleteYourProfilePOM completeYourProfileScreen;
	protected AddressBottomSheetPOM addressBottomSheet;
	protected DOBPickerPOM dobPicker;
	protected DiscoverScreen discoverScreen;


	@BeforeEach
	public void setUp() throws Exception {
		AppiumController.instance.start();
		switch (AppiumController.executionOS) {
			case ANDROID:
				createAccountScreen = new CreateAccountPOM(driver());
				verificationScreen = new SMSVerificationPOM(driver());
				completeYourProfileScreen = new CompleteYourProfilePOM(driver());
				addressBottomSheet = new AddressBottomSheetPOM(driver());
				dobPicker = new DOBPickerPOM(driver());
				discoverScreen = new DiscoverScreenPOM(driver());

				break;

		}
	}

	@AfterEach
	public void tearDown() throws IOException {
		AppiumController.instance.stop();
    }
    

	/**
	 * Gets the error message based on the key from the ErrorCodes.json file to remove hard coded errors in tests
	 */
	public String getErrorCodeFromJSONFile(String errorKey) throws IOException, ParseException, FileNotFoundException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/ErrorCodes.json");
		Object obj = jsonParser.parse(reader);
        JSONObject errorCodes = (JSONObject) obj;
        
        return (String) errorCodes.get(errorKey);
	}    
	
	/**
	 * Gets the toast message based on the key from the ErrorCodes.json file to remove hard coded errors in tests
	 */
	public String getToastMessageFromJSONFile(String toastMessage) throws IOException, ParseException, FileNotFoundException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/ToastMessages.json");
		Object obj = jsonParser.parse(reader);
        JSONObject errorCodes = (JSONObject) obj;
        
        return (String) errorCodes.get(toastMessage);
    }  
}
