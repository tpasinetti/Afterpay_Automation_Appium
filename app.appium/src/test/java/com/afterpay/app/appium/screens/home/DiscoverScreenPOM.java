package com.afterpay.app.appium.screens.home;

import com.afterpay.app.appium.appium_infrastructure.AppiumHelper;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DiscoverScreenPOM extends AppiumHelper implements DiscoverScreen{

    // Constructor
    public DiscoverScreenPOM(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "com.afterpaymobile.qatest:id/bottom_nav")
    MobileElement discoverScreenNavBar;


    @Override
    public Boolean discoverScreenIsDisplayed() {
        return discoverScreenNavBar.isDisplayed();
    }
    
}
