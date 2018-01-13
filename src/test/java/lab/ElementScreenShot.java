package lab;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.utils.FileUtil;

public class ElementScreenShot {

	public static void main(String[] args) throws IOException {
		WebDriver wd=new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("http://localhost/login.do");
		WebElement img=wd.findElement(By.cssSelector("img[src='/img/custom/logo.0.00864989673945582.jpg?hash=970179041']"));
		// Taking an element screenshot IWebElement element = driver.FindElement(By.XPath("//*[@id='tve_editor']/div"));
		//var cropArea = new Rectangle(element.Location, element.Size); 
		//var bitmap = bmpScreen.Clone(cropArea, bmpScreen.PixelFormat);
		//bitmap.Save(fileName); 
		File or= ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		
		int width=img.getSize().getWidth();
		int height=img.getSize().getHeight();
		Point p=img.getLocation();
		
		int x=p.getX();
		int y=p.getY();
		
		BufferedImage image=ImageIO.read(or);
		
		BufferedImage dest=image.getSubimage(x, y, width, height);
		ImageIO.write(dest, "png", or);
		FileUtils.copyFile(or, new File("C:\\Users\\Public\\Desktop\\CCleaner.png"));
	}
}
