package toDelete;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BStack_test1 extends BStack{

	public WebDriver we;
	public BStack_page p;


	ExtentReports report;
	ExtentTest test;

	@BeforeClass
	public void bf() throws Exception {
		we = getDriver();
		p = new BStack_page(we);
		this.report = getInstance();

	}
	@AfterMethod
	public void getResult(ITestResult testResult) throws IOException {
		if(testResult.getStatus()==ITestResult.FAILURE) {
			String path = takeScreenshot(this.we, testResult.getName());
			System.out.println(path);
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, testResult.getName(),imagePath);
			System.out.println( testResult.getName()+" : Failed");

		}else if(testResult.getStatus()==ITestResult.SUCCESS){

			test.log(LogStatus.INFO, testResult.getName(),"Passed");
			System.out.println( testResult.getName()+" : Passed");

		}
		report.endTest(test);
		report.flush();

	}

	@AfterClass
	public void af() {
		we.quit();
	}
	@Test
	public void t1Google() throws InterruptedException, IOException {
		boolean res =  p.test1();
		test = report.startTest("google");
		Thread.sleep(1000);
		Assert.assertTrue(res);
	}
	@Test
	public void t2FB() {
		boolean res = p.test2();
		test = report.startTest("fb");
		Assert.assertTrue(res);
	}
}
