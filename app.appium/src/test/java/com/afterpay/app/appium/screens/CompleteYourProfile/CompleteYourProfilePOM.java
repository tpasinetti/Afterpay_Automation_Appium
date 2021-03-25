package com.afterpay.app.appium.screens.CompleteYourProfile;

import com.afterpay.app.appium.appium_infrastructure.AppiumController;
import com.afterpay.app.appium.appium_infrastructure.AppiumHelper;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CompleteYourProfilePOM extends AppiumHelper implements CompleteYourProfile {
    
    public AppiumController appiumController = new AppiumController();

     //LOCATORS
     @FindBy(id = "com.afterpaymobile.qatest:id/title")
     MobileElement screenTitle;

     @FindBy(xpath = "//android.widget.EditText[@text='Legal first name']")
     MobileElement firstNameField;

     @FindBy(xpath = "//android.widget.EditText[@text='Legal last Name']")
     MobileElement lastNameField;

    public CompleteYourProfilePOM(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Override
    public String getScreenTitle() {
        return getText(screenTitle);
    }

    @Override
    public void setFirstName(String firstName) {
        inputString(firstNameField, firstName);
    }

    
    
}
