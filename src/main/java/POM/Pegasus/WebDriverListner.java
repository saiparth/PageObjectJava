package POM.Pegasus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class WebDriverListner extends AbstractWebDriverEventListener {

	public void beforeNavigateTo(String url, WebDriver driver) {
		//ExtentTestManage.getTest().info("Before navigating to: '" + url + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		//ExtentTestManage.getTest().info("Navigated to:'" + url + "'");
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		//ExtentTestManage.getTest().info("Trying to click on: " + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		//ExtentTestManage.getTest().info("Clicked on: " + element.toString());
	}

	public void onException(Throwable error, WebDriver driver) {
		//ExtentTestManage.getTest().info("Error occurred: " + error);
	}
}
