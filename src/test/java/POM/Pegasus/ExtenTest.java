package POM.Pegasus;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtenTest {
	public static ExtentReports extent;
	public static ExtentTest test;

	public static void main(String[] args) {
		// initialize the HtmlReporter
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter
				("C:\\Users\\partha\\Desktop\\waste.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.setAppendExisting(true);
		ExtentTest test = extent.createTest("MyFirstTest");
		test.pass("details");
		test.fail("details");
		test. warning("details");
		test.debug("details");
		test.pass("details");
		test.pass("details");
		test.fatal("fatal");
		// short-hand for above
		//extent.createTest("MyFirstTest").pass("details");

		// test with description
		ExtentTest test2 =extent.createTest("description", "Test Description");
		test2.pass("details");
		test2.fail("details");
		test2. warning("details");
		test2.debug("details");
		test2.pass("details");
		test2.pass("details");
		test2.fatal("fatal");
		extent.flush();
		/*
		 * 
		 * // creating nodes	
ExtentTest parentTest = extent.createTest("MyFirstTest");
ExtentTest childTest = parentTest.createNode("MyFirstChildTest");
childTest.pass("details");

// short-hand for above
extent
    .createTest("MyFirstTest")
    .createNode("MyFirstChildTest")
	.pass("details");
	
// node description
ExtentTest childTest = parentTest.createNode("MyFirstChildTest", "Node Description");

*ExtentTest test = extent.createTest("Test");
extent.removeTest(test);
test.assignCategory("Regression");
test.assignCategory("Regression", "ExtentAPI");
test.assignCategory("Regression", "ExtentAPI", "category-3", "cagegory-4", ..);

// while creating test
extent
    .createTest("MyFirstTest")
	.assignCategory("Regression")
    .pass("details");
    
    
    test.assignAuthor("aventstack");
test.assignAuthor("name1", "name2");

// while creating test
extent
    .createTest("MyFirstTest")
	.assignAuthor("aventstack")
    .pass("details");
    
    // adding screenshots to log
test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

// or:
MediaModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build();
test.fail("details", mediaModel);	

// adding screenshots to test
test.fail("details").addScreenCaptureFromPath("screenshot.png");
Inserting custom HTML
extent.log(LogStatus.INFO, "HTML", "Usage: BOLD TEXT");

Adding System Info
It is possible to add system or environment info for your using using the setSystemInfo method.

Note: This method automatically adds system information to all started reporters.


extent.setSystemInfo("os", "win7")
*/
	}
}
