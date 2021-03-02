package com.afterpay.app.appium.appium_infrastructure;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
/*
BASIC COMMON APPIUM ACTIONS e.g. Click, Enter text
*/
public class AppiumHelper {

	//wait for maximum 30 seconds before any operation
	WebDriverWait wait = new WebDriverWait(AppiumController.instance.driver, 30);

	protected String getPageSource() {
		return AppiumController.instance.driver.getPageSource();
	}

	protected void inputString(MobileElement mobileElement, String stringToBeEntered) {
		mobileElement = waitTillElementVisible(mobileElement);
		mobileElement.sendKeys(stringToBeEntered);
		AppiumController.instance.driver.hideKeyboard();
	}

	protected void clickElement(MobileElement mobileElement) {
		mobileElement = waitTillElementVisible(mobileElement);
		mobileElement.click();
	}

	protected String getText(MobileElement mobileElement) {
		mobileElement = waitTillElementVisible(mobileElement);
		return mobileElement.getText();
	}

	protected String getAttribute(MobileElement mobileElement, String attr) {
		mobileElement = waitTillElementVisible(mobileElement);
		return mobileElement.getAttribute(attr);
    }
    
    protected String getFrameViewText(MobileElement mobileElement){
        mobileElement = waitTillElementVisible(mobileElement);
        return mobileElement.getText();
    }

	protected void goBack() {
		AppiumController.instance.driver.navigate().back();
	}

	protected boolean isVisible(MobileElement mobileElement) {

		boolean status = false;
		try {
			mobileElement = waitTillElementVisible(mobileElement);
			status = true;
		} catch (Exception e) {

		}
		return status;
	}

	private MobileElement waitTillElementVisible(MobileElement mobileElement) {
		return (MobileElement) wait.until(ExpectedConditions.visibilityOf(mobileElement));

	}

}

