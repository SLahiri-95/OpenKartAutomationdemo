package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


//creating constructor to invoke browser from page class
public class BasePage {

 	WebDriver driver;
	
	public BasePage (WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
}
