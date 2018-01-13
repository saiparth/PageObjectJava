package POM.Pegasus;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManage {

	private static ThreadLocal<Object> extentTest=new ThreadLocal<>();
    private static ExtentReports extent = ExtentReportHelperClass.getInstance();

    public synchronized static ExtentTest getTest() {
        return (ExtentTest) extentTest.get();
    }

    public synchronized static ExtentTest createTest(String name, String description, String category) {
        ExtentTest test = extent.createTest(name, description);
        if (category != null && !category.isEmpty())
            test.assignCategory(category);
        extentTest.set(test);

        return getTest();
    }

    public synchronized static ExtentTest createTest(String name, String description) {
        return createTest(name, description, null);
    }

    public synchronized static ExtentTest createTest(String name) {
        return createTest(name, null);
    }

    public synchronized static void log(String message) {
        getTest().info(message);
    }

}