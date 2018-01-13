/**
 * 
 */
package com.DemoQa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

/**
 * @author partha
 *
 */
public class HomePage {
	WebDriver wd;
	static String HomePageTitle = "Demoqa | Just another WordPress site";
	/*ExtentHtmlReporter htmlReporter;
	ExtentReports extent;*/

	public HomePage(WebDriver driver) {
		wd = driver;
		 PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}

	@FindBy(partialLinkText = "Tab 1 ")
	WebElement tab1;
	@FindBy(partialLinkText = "Tab 2 ")
	WebElement tab2;
	@FindBy(partialLinkText = "Tab 3 ")
	WebElement tab3;
	@FindBy(partialLinkText = "Tab 4 ")
	WebElement tab4;
	@FindBy(partialLinkText = "Tab 5 ")
	WebElement tab5;
	@FindBy(xpath = "(//div[@class='tabcontent ui-tabs-panel ui-widget-content ui-corner-bottom']/b)[1]")
	WebElement TabText;

	public void ClickAndAssertTabFunction() {
			tab2.click();
			System.out.println(TabText.getText());
			Assert.assertEquals(TabText.getText(), "Content 1 Title");
		}


}
