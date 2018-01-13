package POM.Pegasus;

import org.testng.IInvokedMethod;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class TestNgListner implements ITestListener{

	@Override
	public void onFinish(ITestContext context) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentTestManage.getTest().fail(result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTestManage.getTest().skip(result.getName());
	}

	@Override
	public void onTestStart(ITestResult result) {
		String name =result.getName(); //new Object(){}.getClass().getEnclosingMethod().getName();
		ExtentTestManage.createTest(name); // new
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestManage.getTest().pass(result.getName());
	}
	@AfterMethod
	public void afterInvocation(IInvokedMethod arg, ITestResult arg1) { 
	      System.out.println(arg.getTestMethod().getMethodName());
	      ExtentTestManage.getTest().info(arg1.getMethod().getDescription());
	    }
}
