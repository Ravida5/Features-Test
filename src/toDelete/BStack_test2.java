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

public class BStack_test2 extends BStack{

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
	public void t1Insta() throws InterruptedException {
		boolean res =  p.test3();
		test = report.startTest("Instagram");
		Thread.sleep(1000);
		Assert.assertTrue(res);
	}
	@Test
	public void t2Whatsapp() {
		boolean res = p.test4();
		test = report.startTest("Whatsapp");
		Assert.assertTrue(res);
	}
}
