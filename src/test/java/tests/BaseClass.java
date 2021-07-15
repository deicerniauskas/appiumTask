package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	AppiumDriver <MobileElement> driver;
	
	@BeforeTest
	public void setup () {
		
		try {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("chromedriverExecutable","C:\\chromedriver\\chromedriver.exe");
		cap.setCapability("deviceName", "SM-G970F/DS");
		cap.setCapability("udid", "RF8M50LZGJR");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11");
		cap.setCapability("appPackage", "com.example.newsapp");
		cap.setCapability("appActivity", "com.example.newsapp.splash.SplashActivity");
		
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url,cap);
		} catch (Exception exp) {
			System.out.println("Cause is : "+ exp.getCause());
			System.out.println("Message is : "+ exp.getMessage());
			exp.printStackTrace();
		}
		System.out.println("Application");

	}
	
	@AfterTest
	public void teardown () {
		System.out.println("Test complete");
		driver.close();
		driver.quit();
	}

}
