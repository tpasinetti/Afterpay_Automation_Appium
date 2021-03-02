package com.afterpay.app.appium.appium_infrastructure;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.Attachment;

import static io.qameta.allure.Allure.step;

public class AppiumController {

	public static OS executionOS = OS.ANDROID;

	public enum OS {
		ANDROID
	}

	public static AppiumController instance = new AppiumController();
	public AppiumDriver<?> driver;

	public void start() throws MalformedURLException {
		if (driver != null) {
			return;
		}
		switch (executionOS) {
		case ANDROID:
            final String app = "/Users/tinika.pasinetti/Documents/Android_Code/Latest_Build/app-oceania-prod-debug.apk";
			
            
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3x_API_30_x86");
			capabilities.setCapability("isHeadless", true); 
            capabilities.setCapability(MobileCapabilityType.APP, app);
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
			capabilities.setCapability("appPackage", "com.afterpaymobile");
			capabilities.setCapability("avdArgs", "-no-window");
			capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AndroidDriver(url, capabilities);
			step("Started app on Android");
			break;
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void stop() throws IOException {
		attachScreenshot();
		if (driver != null) {
			driver.quit();
			driver = null;
			step("App closed");
		}
	}

	@Attachment(value="screenshot", type="image/png")
    public byte[] attachScreenshot() throws IOException {
        return ((TakesScreenshot)AppiumController.instance.driver).getScreenshotAs(OutputType.BYTES);
	}
	
	

}
