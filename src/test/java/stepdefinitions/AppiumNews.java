package stepdefinitions;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class AppiumNews {

	AppiumDriver <MobileElement> driver;
	
	@Given("Launch News app")
	public void launch_news_app() {
		setupAndAppLaunch();
	    throw new io.cucumber.java.PendingException();
	}

	@When("Welcome flow is over I can see news feed")
	public void welcome_flow_is_over_i_can_see_news_feed() throws InterruptedException {
		newsAppStartFlow();
	    throw new io.cucumber.java.PendingException();
	}

	@And("and open first news option")
	public void and_open_first_news_option() {
		clickByXpath("//*[@text='General']");
		clickByXpath("//*[@text='ABC News']");
	    throw new io.cucumber.java.PendingException();
	}

	@And("click on favorites icon")
	public void click_on_favorites_icon() {
		clickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.CheckBox");
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I validate selected news in my list")
	public void i_validate_selected_news_in_my_list() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		MobileElement favIcon = driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Favorites\"]/android.widget.ImageView"));
		favIcon.click();
	    throw new io.cucumber.java.PendingException();
	}
	
public void setupAndAppLaunch () {
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

public void newsAppStartFlow() throws InterruptedException{
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	clickByXpath("//*[@text='BEGIN']");
	clickByXpath("//*[@text='YES']");
	driver.findElement(By.xpath("//*[@text='Does this newspaper contain pictures?']")).isDisplayed();
	clickByXpath("//*[@text='YES']");
	clickByXpath("//*[@text='OKAY']");
}

public void clickByXpath (String xpath) {
	MobileElement elementToClick = driver.findElement(By.xpath(xpath));
	elementToClick.click();
	System.out.println("Click on:"  + xpath);
}
	
	
}
