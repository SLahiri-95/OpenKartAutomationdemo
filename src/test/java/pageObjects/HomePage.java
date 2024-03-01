package pageObjects;
import java.time.Duration;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends BasePage {
	// constructor
	public HomePage(WebDriver driver) {
		super(driver);
		// super is invoking the parent class constructor(BasePage)
	}
	
	By lnkRegistration = By.xpath("(//a[text()='Create an Account'])[1]");
	
	
	public void clickOnRegister() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(lnkRegistration).click();	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void verifyReg() {
		WebElement txtRegtxt = driver.findElement(By.xpath("//div[contains(text(),'Thank you')]"));
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.visibilityOf(txtRegtxt));
		 String verify =txtRegtxt.getText();
		 if(txtRegtxt.isDisplayed()) {
			 System.out.println("Test case Pass " + verify);
		 }
		 	
		}

}
