package tests;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Common {
	
	private final AppiumDriver<MobileElement> driver;

	public Common(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public void clickByXpath (String xpath) {
		MobileElement elementToClick = driver.findElement(By.xpath(xpath));
		elementToClick.click();
		System.out.println("Click on:"  + xpath);
	}
	
	public void newsAppStartFlow() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		clickByXpath("//*[@text='BEGIN']");
		clickByXpath("//*[@text='YES']");
		driver.findElement(By.xpath("//*[@text='Does this newspaper contain pictures?']")).isDisplayed();
		clickByXpath("//*[@text='YES']");
		clickByXpath("//*[@text='OKAY']");
	}
	
	public void scrollDown () {
		Dimension dimension = driver.manage().window().getSize();
		Double scrollHeightStart = dimension.getHeight() * 0.5;
		int scrollStart = scrollHeightStart.intValue();
		Double scrollHeightEnd = dimension.getHeight() * 0.2;
		int scrollEnd = scrollHeightEnd.intValue();
		new TouchAction((PerformsTouchActions)driver)
		.press(PointOption.point(0, scrollStart))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point(0, scrollEnd)).release().perform();
	}
	
	public List<MobileElement> getItemWebView(){
		return driver.findElements(By.xpath("//android.widget.LinearLayout[@index='4']"));
	}
	
	public void scrollTillWebView () throws InterruptedException {
		while(getItemWebView().size() == 0) {
			scrollDown();
		}
		if(getItemWebView().size() > 0) {
			getItemWebView().get(0).click();
		}
		Thread.sleep(500);
	}
	
	public void swipeAction(int Xcoordinate, int Ycoordinate, String direction) {
	    //get device width and height
	    Dimension dimension = driver.manage().window().getSize();
	    int deviceHeight = dimension.getHeight();
	    int deviceWidth = dimension.getWidth();
	    System.out.println("Height x Width of device is: " + deviceHeight + " x " + deviceWidth);
	    System.out.println("X Coordinates of field: " +Xcoordinate);
	    System.out.println("Y Coordinates of field: " +Ycoordinate);
	    switch (direction) {
	        case "Left":
	            System.out.println("Swipe Right to Left");
	            //define starting and ending X and Y coordinates
	            int startX=deviceWidth - Xcoordinate;
	            int startY=Ycoordinate; // (int) (height * 0.2);
	            int endX=Xcoordinate;
	            int endY=Ycoordinate;
	            //perform swipe from right to left
	            new TouchAction((AppiumDriver) driver).longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();
	            break;

	        case "Right":
	            System.out.println("Swipe Left to Right");
	            //define starting X and Y coordinates
	            startX=Xcoordinate;
	            startY=Ycoordinate;
	            endX=deviceWidth - Xcoordinate;
	            endY=Ycoordinate;
	            //perform swipe from left to right
	            new TouchAction((AppiumDriver) driver).longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();
	            break;
	    }
	}

	private WaitOptions waitOptions(Object ofMillis) {
		// TODO Auto-generated method stub
		return null;
	}

	private Object ofMillis(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	private PointOption point(int startPoint, int anchor) {
		// TODO Auto-generated method stub
		return null;
	}

}
