package toDelete;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class browserHIT {


	public static void main(String [] args) {
		SeleniumDriver sel = null;
		try {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\util\\chromedriver.exe");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("download.default_directory",  System.getProperty("user.dir")+"\\src\\exportfiles\\");
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			WebDriver driver = new ChromeDriver(options);
			sel = new SeleniumDriver(driver);

			driver.get("https://qa.platformcentral.247-inc.net/support/em#manage_users_section");
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sel.elementClick("//div[@id='more_manage_users']//a[contains(text(), 'Read more about this topic')]", "xpath");
		System.out.println("The image is visible : "+sel.wait_for_visibility("//div[@id='more_manage_users_section']//ol[1]//img", "xpath"));

	}
}
