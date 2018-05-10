package POM.Pegasus;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportHelperClass {
    
    static ExtentReports ChromeExtent;
    static ExtentReports FFExtent;
    
    public static ExtentReports getChromeInstance() 
    {	
        return ChromeExtent;
    }
    
    public static ExtentReports getFFInstance() 
    {	
        return FFExtent;
    }
    
    public static synchronized ExtentReports createChromeInstance(String fileName) 
    {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Automation Chrome Report");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);
        ChromeExtent = new ExtentReports();
        ChromeExtent.attachReporter(htmlReporter);
        return ChromeExtent;
    }
    public static synchronized ExtentReports createFFInstance(String fileName) 
    {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Automation FF Report");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);
        FFExtent = new ExtentReports();
        FFExtent.attachReporter(htmlReporter);
        return FFExtent;
    }
    public static synchronized void Chromeflush() 
    {
    	getChromeInstance().flush();	
    }
    public static synchronized void FFflush() 
    {
    	getFFInstance().flush();	
    }
}

