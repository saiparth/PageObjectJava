/**
 * 
 */
package POM.Pegasus;
import java.io.File;
import java.io.IOException;
import java.awt.AWTException;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.DemoQa.HomePage;
import com.google.common.io.Files;

/**
 * @author partha
 *
 */
public class TestSelenium extends BrowserFactory {
	static WebDriver driver;
	final static Logger log = Logger.getLogger(TestSelenium.class);
	
	@Test(description="click all tabs")
	public static void TestTabLinkFunction() throws AWTException, IOException 
	{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		//ExtentTestManage.createTest(name);
		log.info(name);
		driver=wd;
		driver.get("file:///E:/webs/http___demoqa.com_/demoqa.com/index.html");
		//driver.get("file:///C:/Users/partha/Desktop/Tryit%20Editor%20v3.5.html");
		/*File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(f, new File("C:\\Users\\partha\\Desktop\\chiinu.png"));
		HomePage hp=new HomePage(driver);
		hp.ClickAndAssertTabFunction();*/
		//driver.quit();
		/*By up=By.id("myFile");
		By frame=By.id("iframeResult");
		driver.switchTo().frame(driver.findElement(frame));
	driver.findElement(up).click();
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_A);
	r.keyRelease(KeyEvent.VK_A);
	File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	Files.copy(f, new File("C:\\Users\\partha\\Desktop\\chiinu.png"));	*/
	}
}
