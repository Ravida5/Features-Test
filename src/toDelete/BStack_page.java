package toDelete;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BStack_page extends SeleniumDriver{
	public WebDriver we;
	public BStack_page(WebDriver we) throws SecurityException, IOException {
		super(we);
		this.we = we; 
	}

	public boolean test1() throws IOException, InterruptedException {
		//		we.get("http://www.google.com");
		//		return we.getTitle().equalsIgnoreCase("Google");
		int randnum1 = new Random().nextInt(10000); 
		String randnum = Integer.toString(randnum1);
		FileWriter  myObj = new FileWriter(System.getProperty("user.dir")+"/src/uploadFiles/"+randnum+".wav");
		myObj.write("abcd");
		myObj.close();
		we.get("https://www.w3schools.com/howto/howto_html_file_upload_button.asp");
		String path = System.getProperty("user.dir")+"\\src\\uploadFiles\\"+randnum+".wav";
		we.findElement(By.xpath("//input[@id='myFile']")).sendKeys(path);

		//		this.sendData(path, "//input[@id='myFile']", "xpath");
		return false;

	}
	public boolean test2() {
		we.get("http://www.facebook.com");
		return we.getTitle().equalsIgnoreCase("Facebook – log in or sign up");
	}
	public boolean test3() {
		we.get("http://www.instagram.com");
		return we.getTitle().equalsIgnoreCase("Instagram");
	}
	public boolean test4() {
		we.get("http://www.whatsapp.com");
		//	    System.out.println("Title : "+we.getTitle());
		return we.getTitle().equalsIgnoreCase("WhatsApp");
	}
}
