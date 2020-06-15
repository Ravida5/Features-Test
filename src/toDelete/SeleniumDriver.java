package toDelete;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
//
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.*;

public class SeleniumDriver extends BStack {

	WebDriver driver;
	ExtentTest test;


	public  SeleniumDriver(WebDriver driver) throws SecurityException, IOException {
		this.driver = driver;
	}


	public WebElement getElement( String locator, String locatorType) {
		locatorType = locatorType.toLowerCase();
		WebElement element;
		WebDriverWait wait = new WebDriverWait(this.driver,20);


		try {
			if(locatorType.equals("id")) {
				//				element = this.driver.findElement(By.id(locator));
				element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
				if(element!=null) {
					logs("Element found with locator "+locator +"  and locatorType "+locatorType);
					test.log(LogStatus.INFO,"Element found with locator "+locator +"  and locatorType "+locatorType);
					return element;
				}
			}
			else if (locatorType.contentEquals("name")) {
				//				element = this.driver.findElement(By.name(locator));
				element = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locator)));

				if(element!=null) {
					logs("Element found with locator "+locator +"  and locatorType "+locatorType);
					return element;
				}
			}
			else if (locatorType.contentEquals("xpath")) {
				//				element = this.driver.findElement(By.xpath(locator));
				element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));

				if(element!=null) {
					logs("Element found with locator "+locator +"  and locatorType "+locatorType);
					return element;
				}
			}
			else if (locatorType.contentEquals("css")) {
				//				element = this.driver.findElement(By.cssSelector(locator));
				element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));

				if(element!=null) {
					logs("Element found with locator "+locator +"  and locatorType "+locatorType);
					return element;
				}
			}
			else if (locatorType.contentEquals("class")) {
				//				element = this.driver.findElement(By.className(locator));
				element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locator)));

				if(element!=null) {
					logs("Element found with locator "+locator +"  and locatorType "+locatorType);
					return element;
				}
			}
			else if (locatorType.contentEquals("link")) {
				//				element = this.driver.findElement(By.linkText(locator));
				element = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(locator)));
				if(element!=null) {
					logs("Element found with locator "+locator +"  and locatorType "+locatorType);
					return element;
				}
			}
			else {
				logs("Element not found with locator "+locator +"  and locatorType "+locatorType);
				return null;
			}
		}

		catch(Exception e){ 
			logs("Element not found with locator "+locator +"  and locatorType "+locatorType);
			return null;
		}
		return null;

	}


	public List<WebElement> getElements( String locator, String locatorType) {
		locatorType = locatorType.toLowerCase();
		try {
			//			if(locatorType.equals("id")) {
			//				logs("Elements found with locator "+locator +"  and locatorType "+locatorType);
			//				return this.driver.findElements(By.id(locator));
			//			}
			//			else if (locatorType.contentEquals("name")) {
			//				logs("Elements found with locator "+locator +"  and locatorType "+locatorType);
			//				return this.driver.findElements(By.name(locator));
			//			}
			if (locatorType.contentEquals("xpath")) {
				List<WebElement> we= this.driver.findElements(By.xpath(locator));
				if(we.size()==0) {
					logs("Elements not found with locator "+locator +"  and locatorType "+locatorType);

					return null;
				}
				else {
					logs("Elements found with locator "+locator +"  and locatorType "+locatorType);

					return we;
				}
			}
			//			else if (locatorType.contentEquals("css")) {
			//				logs("Elements found with locator "+locator +"  and locatorType "+locatorType);
			//				return this.driver.findElements(By.cssSelector(locator));
			//			}
			//			else if (locatorType.contentEquals("class")) {
			//				logs("Elements found with locator "+locator +"  and locatorType "+locatorType);
			//				return this.driver.findElements(By.className(locator));
			//			}
			//			else if (locatorType.contentEquals("link")) {
			//				logs("Elements found with locator "+locator +"  and locatorType "+locatorType);
			//				return this.driver.findElements(By.linkText(locator));
			//			}
			else {
				logs("Elements not found with locator "+locator +"  and locatorType 1"+locatorType);
				return null;
			}
		}

		catch(Exception e){ 
			logs("Elements not found with locator "+locator +"  and locatorType "+locatorType);
			return null;
		}

	}



	public boolean isElementPresent(String locator, String locatorType) {
		if(this.getElement(locator, locatorType) != null) {
			logs("Element present");
			return true;
		}
		else {
			logs("Element not present");
			return false;
		}

	}


	public void elementClick(String locator, String locatorType) {
		try {
			WebElement element = this.getElement(locator, locatorType);
			element.click(); 
			logs("Clicked on element with locator "+locator +"  and locatorType "+locatorType);

		}

		catch(Exception e) {

			logs("Cannot click on element with locator "+locator +"  and locatorType "+locatorType);

		}
	}
	public void getUrl(String URL) {
		try{
			this.driver.get(URL);
			logs("Fetched the given URL");

		}catch(Exception e) {
			logs("Cannot Fetch the given URL");

		}
	}
	public void elementClick_element(WebElement we) {
		try {
			we.click();
			logs("Clicked on element sent");
		}

		catch(Exception e) {

			logs("Cannot click on element sent");

		}
	}


	public void sendData(String data, String locator, String locatorType) {
		try { 
			WebElement element = this.getElement(locator, locatorType);
			element.clear();
			element.sendKeys(data);
			logs("Sent data on element with locator "+locator +"  and locatorType "+locatorType);

		}
		catch(Exception e) {
			logs("Cannot send on element with locator "+locator +"  and locatorType "+locatorType);

		}


	} 
	public void sendData1(String data, String locator, String locatorType) {
		try {
			WebElement element = this.getElement(locator, locatorType);
			element.sendKeys(data);
			logs("Sent data on element with locator "+locator +"  and locatorType "+locatorType);

		}
		catch(Exception e) {
			logs("Cannot send on element with locator "+locator +"  and locatorType "+locatorType);

		}


	} 
	public void clearText(String locator, String locatorType) {
		try {
			WebElement element = this.getElement(locator, locatorType);
			element.clear();
			logs("Cleared text on element with locator "+locator +"  and locatorType "+locatorType);

		}
		catch(Exception e) {
			logs("Cannot clear text on element with locator "+locator +"  and locatorType "+locatorType);

		}


	} 

	public String getText1(WebElement we) {
		try {
			//		WebElement element = this.getElement(locator, locatorType);
			String text=we.getText();
			logs("Got text");
			return text;
		}
		catch(Exception e) {
			logs("Could not get text");
			return "none";
		}


	}

	public String getAttribute1(String locator, String locatorType, String att_type) {
		//		Thread.sleep(3000);
		WebElement we = this.getElement(locator, locatorType);
		try {
			System.out.println(we.getAttribute(att_type));
			String att =  we.getAttribute(att_type);

			logs("Attribute found with locator :" + locator +", Attribute Value : " +att);
			return att;

		}catch(Exception e) {
			System.out.println("Attribute not present");
			logs("Attribute not found : ");

			return "";
		}

	}
	public String getAttribute1_element(WebElement we, String att_type) {
		try {
			return we.getAttribute(att_type);
		}catch(Exception e) {
			return "element not present";
		}

	}


	public boolean wait_for_presence(String locator,String locatorType) {
		WebDriverWait wait = new WebDriverWait(this.driver,30);
		WebElement element ;
		try {		
			element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));

			if(element==null)
				return false;


		}
		catch(Exception e){
			return false;

		}
		return true;

	}
	public boolean wait_for_visibility(String locator,String locatorType) {
		WebDriverWait wait = new WebDriverWait(this.driver,30);
		WebElement element ;
		try {		
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

			if(element==null)
				return false;
			logs("Element visible with locator "+locator +"  and locatorType "+locatorType);


		}
		catch(Exception e){
			logs("Element not visible with locator "+locator +"  and locatorType "+locatorType);
			return false;


		}
		return true;

	}
	public boolean wait_for_inVisibility(String locator,String locatorType) {
		WebDriverWait wait = new WebDriverWait(this.driver,30);
		Boolean element ;
		try {		
			element = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));

			if(element==null)
				return false;


		}
		catch(Exception e){
			return false;

		}
		return true;

	}

	public void hover(String locator, String locatorType) {
		try {
			Actions action = new Actions(this.driver);
			WebElement we = this.getElement(locator, locatorType);
			action.moveToElement(we).perform();
			logs("Mouse hovered over"+locator);
			action.build();
			action.moveToElement(we).click().perform();
		}
		catch(Exception e){
			logs("Mouse not hovered over"+locator+" Exception :"+e);

		}
	}
	public void hover2(String locator, String locatorType) {
		try {
			Actions action = new Actions(this.driver);
			WebElement we = this.getElement(locator, locatorType);
			action.moveToElement(we).perform();
			logs("Mouse hovered over"+locator);
			action.build();
			action.moveToElement(we).perform();
		}
		catch(Exception e){
			logs("Mouse not hovered over"+locator+" Exception :"+e);

		}
	}


	public boolean selectOptionByIndex(String locator, String locatorType, int index) {
		try {
			WebElement we = this.getElement(locator, locatorType);
			Select se = new Select(we);
			se.selectByIndex(index);
			logs("Selected dropdown by given index");
			return true;
		}catch(Exception e){
			logs("Could not Selected dropdown by given index");

			return false;
		}
	}

	public boolean selectOptionByValue(String locator, String locatorType, String value) {
		try {
			WebElement we = this.getElement(locator, locatorType);
			Select se = new Select(we);
			se.selectByValue(value);
			logs("Selected dropdown by given value");

			return true;
		}catch(Exception e){
			logs("Could not Select dropdown by given value");

			return false;
		}
	}

	public boolean selectOptionByText(String locator, String locatorType, String text) {
		try {
			WebElement we = this.getElement(locator, locatorType);
			Select se = new Select(we);
			se.selectByVisibleText(text);
			logs("Selected dropdown by given text");

			return true;
		}catch(Exception e){
			logs("Could not Selected dropdown by given text");

			return false;
		}
	}

	public String firstSelectedOption(String locator, String locatorType) {
		try {
			WebElement we = this.getElement(locator, locatorType);
			Select se = new Select(we);
			logs("Found the first selected option");

			return se.getFirstSelectedOption().getText();
		}catch(Exception e){
			logs("Cannot find the first selected option");

			return " ";
		}
	}
	public boolean isSelected(String locator, String locatorType) {
		try {
			WebElement we = this.getElement(locator, locatorType);
			if(we.isSelected())
				return true;
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}

	public boolean isSelected_element(WebElement we) {
		try {
			if(we.isSelected())
				return true;
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}

	public boolean isEnabled(String locator, String locatorType) {
		try {
			WebElement we = this.getElement(locator, locatorType);
			if(we.isEnabled()) {
				//				System.out.println("Element Enabled");
				return true;
			}
			else {
				//				System.out.println("Element Not Enabled");
				return false;
			}
		}catch(Exception e){
			//			System.out.println("Entered isEnabled Catch block");
			return false;
		}
	}
	public void refresh() {
		try {
			driver.navigate().refresh();
		}catch(Exception e){
		}
	}

	public void deleteFile(String path) {
		try {
			File file = new File(path);
			File[] files = file.listFiles(); 
			for (File f:files) 
			{
				if (f.isFile() && f.exists()) 
				{
					f.delete();
					//					System.out.println("successfully deleted");
				}else{
					System.out.println("cant delete a file due to open or error");

				}

			}
		}
		catch(Exception e) {
			System.out.println("cant delete a file due to file-open or error");

		}
	}

	public String refined(String client) {
		char [] li = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', ',', '<', '>', '.', '?', '/',
				'"', ':', ';', '{', '}', '[', ']', '|', '\\'};
		String client_refined="";
		boolean flag = false;
		try {
			for(int i=0;i<client.length();i++) {
				for(int j=0;j<li.length;j++) {
					flag=false;
					if(client.charAt(i)==li[j] || client.charAt(i)==' ') {
						flag=true;
						break;
					}
				}
				if(flag==false)
					client_refined=client_refined+client.charAt(i);

			}
			System.out.println(client_refined);
		}catch(Exception e) {

		}
		return client_refined;	
	}
	public boolean selectOptionByText_element(WebElement we, String text) {
		try {
			Select se = new Select(we);
			se.selectByVisibleText(text);
			logs("Selected dropdown by given text");

			return true;
		}catch(Exception e){
			logs("Could not Selected dropdown by given text");

			return false;
		}
	}
	public boolean isEnabled_element(WebElement we) {
		try {
			if(we.isEnabled())
				return true;
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}
	public String firstSelectedOption_element(Select se) {
		try {
			//			WebElement we = this.getElement(locator, locatorType);
			//			Select se = new Select(we);
			logs("Found the first selected option");
			String text = se.getFirstSelectedOption().getText();
			System.out.println(text);
			return text;
		}catch(Exception e){
			logs("Cannot find the first selected option");

			return " ";
		}
	}
}


