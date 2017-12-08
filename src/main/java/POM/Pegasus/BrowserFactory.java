package POM.Pegasus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Hello world!
 *
 */
public class BrowserFactory {
	@Parameters({ "browser" })
	@Test
	public static void etster(String browser) {
		WebDriver wd = null;
		switch (browser.toLowerCase()) {
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

	}
}
