package POM.Pegasus;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;


public class BrowserFactory {
	final static Logger log = Logger.getLogger(BrowserFactory.class);
	static WebDriver wd = null;
	
	public String getBrowserName() {
		Capabilities cap=((RemoteWebDriver)wd).getCapabilities();
		return cap.getBrowserName();
	}
	@BeforeSuite
	public static void extent( )
	{
		DateFormat dateformat = new SimpleDateFormat("ddMMyyyyHHmmss");
		Date date = new Date();
		String chrome = "C:\\Users\\partha\\Desktop\\Reports\\chrome\\" +  dateformat.format(date) + ".html";
		String firefox = "C:\\Users\\partha\\Desktop\\Reports\\FF\\" +  dateformat.format(date) + ".html";
		 if (ExtentReportHelperClass.getChromeInstance() == null)
		 {
			 ExtentReportHelperClass.createChromeInstance(chrome);
		 }
		 if (ExtentReportHelperClass.getFFInstance() == null)
		 {
			 ExtentReportHelperClass.createFFInstance(firefox);
		 }
	}
	
	//@BeforeClass
	@Parameters({ "browser"})
	public static WebDriver browserStarter(String browser)
	{
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/log4j.properties");
		log.debug("browser intailizing - " + browser);
		try {
			switch (browser.toLowerCase()) 
			{
			case "chrome":
				wd = new ChromeDriver();
				wd.manage().window().maximize();
				break;
			case "firefox":
				wd = new FirefoxDriver();
				break;
			default:
				wd = new ChromeDriver();
				break;
			}
		} catch (Exception e) {
			log.fatal("error in intalizing browser" + e);
			throw e;
		}
		return wd;
	}

	@AfterClass
	@Parameters({ "reportPath" })
	public synchronized void closeDriver(String s) {
		
		log.info("executing " + s);
	}

	@AfterSuite
	public synchronized void tearDown()  {
		wd.quit();
		ExtentReportHelperClass.Chromeflush();
		ExtentReportHelperClass.FFflush();
	}
}
