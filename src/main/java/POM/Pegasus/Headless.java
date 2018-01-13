package POM.Pegasus;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.google.common.io.Files;

public class Headless {
	public static void main(String[] args)  throws AWTException, IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\workspace\\Pegasus\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("headless");
		//options.addArguments("window-size=1400,800");
		WebDriver wd = new ChromeDriver(options);
		 wd.manage().window().maximize();//setSize(new Dimension(700,700));
		wd.get("file:///C:/Users/partha/Desktop/Tryit%20Editor%20v3.5.html");
		By up = By.id("myFile");
		By frame = By.id("iframeResult");
		wd.switchTo().frame(wd.findElement(frame));
		wd.findElement(up).click();
		Thread.sleep(3000);
		System.setProperty("java.awt.headless", "false");
		Robot r = new Robot();
		String test = "C:\\Users\\partha\\Desktop\\chiinu.png";
		StringSelection sel = new StringSelection(test);
		Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
		clip.setContents(sel, sel);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		File f = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
		Files.copy(f, new File("C:\\Users\\partha\\Desktop\\chiinu.png"));
 
		wd.quit();
	}
}
