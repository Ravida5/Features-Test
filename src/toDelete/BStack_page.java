package toDelete;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebDriver;

public class BStack_page {
	public WebDriver we;
	public BStack_page(WebDriver we) {
		this.we = we; 
	}

	public boolean test1() throws IOException {
		//		we.get("http://www.google.com");
		//		return we.getTitle().equalsIgnoreCase("Google");
		int randnum1 = new Random().nextInt(10000); 
		String randnum = Integer.toString(randnum1);
		FileWriter  myObj = new FileWriter(System.getProperty("user.dir")+"//src//uploadFiles//"+randnum+".wav");
		myObj.write("abcd");
		myObj.close();
		return true;

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
