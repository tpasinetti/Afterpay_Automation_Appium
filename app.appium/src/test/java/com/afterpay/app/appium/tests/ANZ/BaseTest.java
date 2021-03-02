package com.afterpay.app.appium.tests.ANZ;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.afterpay.app.appium.appium_infrastructure.AppiumBaseClass;
import com.afterpay.app.appium.appium_infrastructure.AppiumController;
import com.afterpay.app.appium.screens.CreateAccount.CreateAccountPOM;
import com.afterpay.app.appium.screens.SMSVerification.SMSVerificationPOM;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest extends AppiumBaseClass{
    
  
	protected CreateAccountPOM createAccount;
	protected SMSVerificationPOM verification;

	@BeforeEach
	public void setUp() throws Exception {
		AppiumController.instance.start();
		switch (AppiumController.executionOS) {
			case ANDROID:
				
				createAccount = new CreateAccountPOM(driver());
				verification = new SMSVerificationPOM(driver());
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
}
