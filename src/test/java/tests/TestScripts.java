package tests;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TestScripts extends BaseClass {
	
	Common common;
	@BeforeTest
	public void setup () {
		super.setup();
		common = new Common(driver);
	}
	
	@Test
	public void task3() throws InterruptedException {
		common.newsAppStartFlow();
		driver.findElement(By.xpath("//*[@text='General']")).isDisplayed();
		common.swipeAction(200, 300, "Left");
		common.clickByXpath("//*[@text='Sports']");
//		List<MobileElement> list = driver.findElements(By.xpath("//*[@class = '//*[@class = 'android.widget.LinearLayout']"));
//		list.get(4).click(); //not finding elements, needed more time to troubleshoot
		common.scrollDown();
		common.clickByXpath("//android.widget.LinearLayout[@index='4']");
		List<MobileElement> list2 = driver.findElements(By.xpath("//*[@class = '//*[@class = 'android.widget.LinearLayout']"));
		System.out.println("Number of elements on page: " + list2.size());
	}
	
	@Test
	public void task4() throws InterruptedException {
		common.newsAppStartFlow();
		common.clickByXpath("//*[@text='General']");
		common.clickByXpath("//*[@text='ABC News']");
		common.clickByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.CheckBox");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		MobileElement favIcon = driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Favorites\"]/android.widget.ImageView"));
		favIcon.click();
	}
	
}
	
