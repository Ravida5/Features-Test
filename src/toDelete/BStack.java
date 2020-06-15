package toDelete;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentReports;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BStack {

	public static final String USERNAME = "raviteja86";
	public static final String AUTOMATE_KEY = "sh4pkpk2tWEVRcWHQ9Xz";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	static String time_stamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss"));
	SeleniumDriver selDriver;
	ExtentReports extent;
	
	
	
	public void logs(String string) {
		try {
			String fileName=System.getProperty("user.dir")+"/src/logs/log_data.txt";
			FileWriter fw = new FileWriter(fileName,true);
			fw.write((LocalDateTime.now()).format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))+" : "+string+"\n");
			fw.close();
		}
		catch(IOException e) {
			System.out.println("IOexception : "+e.getMessage());
		}
	}

	
	public static ExtentReports getInstance() {
		ExtentReports extent;
		System.out.println(time_stamp);
		
		String Path = System.getProperty("user.dir")+"//src//reports//report"+time_stamp+".html";
		extent = new ExtentReports(Path, false);
		extent
		.addSystemInfo("Selenium Version", "3.141.59")
		.addSystemInfo("Platform","Windows");
		//		

		return extent;

	}

	public static String takeScreenshot(WebDriver driver, String fileName) throws IOException {
		fileName = fileName+".png";
		String directory = System.getProperty("user.dir")+"//src//screenshots//";
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + fileName));
		String destination = directory+fileName;
		return destination;
	}
	public WebDriver getDriver() throws Exception {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "80.0");
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("resolution", "1280x1024");
		caps.setCapability("name", "TVP-Test");
		
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		driver.manage().window().maximize();
		return driver;

	}
}