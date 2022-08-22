package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.Base_Class;
import utilities.ExtentReporter;

public class Listeners extends Base_Class implements ITestListener {

	ExtentReports extentReport = ExtentReporter.getExtentReport();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extenttestThread = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
	
		String testName = result.getName();
	    extentTest = extentReport.createTest(testName+"executed started");
	    extenttestThread.set(extentTest);
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testName = result.getName();
		//extentTest.log(Status.PASS, testName+" got passed");
		extenttestThread.get().log(Status.PASS, testName+" got passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname = result.getName();
		
	//	extentTest.fail(result.getThrowable());
		extenttestThread.get().fail(result.getThrowable());
		
		try {
		   driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
		
			e.printStackTrace();
		}
	
		
			
				try {
					String dest= takeScreenshot(testname,driver);
					extenttestThread.get().addScreenCaptureFromPath(dest,testname);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		
	
}

	@Override
	public void onTestSkipped(ITestResult result) {
	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}
	@Override
	public void onStart(ITestContext context) {
	
	}

	@Override
	public void onFinish(ITestContext context) {
	
		extentReport.flush();
	}

	
	
}