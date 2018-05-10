package POM.Pegasus;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class TestNgListner implements ITestListener{

	@Override
	public void onFinish(ITestContext context) {
		//super.onFinish(context);
		String wd=(String)context.getAttribute("webdriver");
		 
	}

	@Override
	public void onStart(ITestContext context) {
		context.setAttribute("webdriver",new BrowserFactory().getBrowserName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//if((String)ITestContext.getAttribute("webdriver")=="Chrome")
		ExtentTestManage.getChromeTest().fail(result.getName());
		ExtentTestManage.getFFTest().fail(result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTestManage.getChromeTest().skip(result.getName());
		ExtentTestManage.getFFTest().skip(result.getName());
	}

	@Override
	public void onTestStart(ITestResult result) {
		String name =result.getName(); //new Object(){}.getClass().getEnclosingMethod().getName();
		ExtentTestManage.createChromeTest(name); // new
		ExtentTestManage.createFFTest(name); 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestManage.getChromeTest().pass(result.getName());
		ExtentTestManage.getFFTest().pass(result.getName());
	}
	@AfterMethod
	public void afterInvocation(IInvokedMethod arg, ITestResult arg1) { 
	      System.out.println(arg.getTestMethod().getMethodName());
	      ExtentTestManage.getChromeTest().info(arg1.getMethod().getDescription());
	      ExtentTestManage.getFFTest().info(arg1.getMethod().getDescription());
	    }
}
