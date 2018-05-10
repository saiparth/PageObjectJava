package POM.Pegasus;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManage {

	private static ThreadLocal<Object> extentTest=new ThreadLocal<>();
    private static ExtentReports ChromeExtent = ExtentReportHelperClass.getChromeInstance();
    private static ExtentReports FFExtent = ExtentReportHelperClass.getFFInstance();
    
    public synchronized static ExtentTest getChromeTest() 
    {
    	//extentTest.set(createChromeTest());
        return (ExtentTest) extentTest.get();
    }
    public synchronized static ExtentTest getFFTest() 
    {
    	//extentTest.set(FFExtent);
        return (ExtentTest) extentTest.get();
    }
    public synchronized static ExtentTest createChromeTest(String name, String description, String category) {
        ExtentTest Chrome = ChromeExtent.createTest(name, description);
        if (category != null && !category.isEmpty())
        Chrome.assignCategory(category);
        extentTest.set(Chrome);
        return getChromeTest();
    }
 
    public synchronized static ExtentTest createFFTest(String name, String description, String category) {
        ExtentTest ffTest = FFExtent.createTest(name, description);
        if (category != null && !category.isEmpty())
        ffTest.assignCategory(category);
        extentTest.set(ffTest);
        return getFFTest();
    }
    public synchronized static ExtentTest createChromeTest(String name, String description) {
        return createChromeTest(name, description, null);
    }
    public synchronized static ExtentTest createFFTest(String name, String description) {
        return createFFTest(name, description, null);
    }
    public synchronized static ExtentTest createChromeTest(String name) {
        return createChromeTest(name, null);
    }
    public synchronized static ExtentTest createFFTest(String name) {
        return createFFTest(name, null);
    }
    public synchronized static void log(String message) {
        getChromeTest().info(message);
        getFFTest().info(message);
    }

}