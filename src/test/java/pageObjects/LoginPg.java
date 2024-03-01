package pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.ui.*;
import TestBase.BaseClass;

@SuppressWarnings("unused")
public class LoginPg extends BasePage{

	public LoginPg(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public By lnkSignIn= By.xpath("(//a[contains(text(),'Sign ')])[1]");
	public By logInEmail = By.xpath("//input[@id='email']");
	public By loginPwd = By.xpath("//input[@id='pass' and @title='Password' ]");
	public By btnSignIn = By.xpath("//input[@id='pass' and @title='Password' ]//..//..//..//span[text()='Sign In']");
	public By txtWelcome = By.xpath("(//span[text()='Welcome, SNEHAJIT LAHIRI!'])[1]");
	public By ddMenu = By.xpath("(//button[@class='action switch'])[1]");
	public By menuOps=By.xpath("(//ul[@class='header links'])[1]/li");
	
	public void clickSignIn() {
		driver.findElement(lnkSignIn).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public boolean loginPageexist() {
		try {
			boolean welcomeTxt=driver.findElement(txtWelcome).isDisplayed() ;
			return welcomeTxt;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public void setEmailid(String Emailid) {
		driver.findElement(logInEmail).sendKeys(Emailid);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void setPassword(String pwdset) {
		driver.findElement(loginPwd).sendKeys(pwdset);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void clickSubmit() {
		driver.findElement(btnSignIn).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void verifyLogin() {
		
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
			WebElement txtLogin=driver.findElement(txtWelcome);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
			wait.until(ExpectedConditions.visibilityOf(txtLogin));
			boolean verify = txtLogin.isDisplayed();
			Assert.assertEquals(verify, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void logout(String val) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(ddMenu).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List <WebElement> ops= driver.findElements(menuOps);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		;
		
		for (int i=0;i<ops.size();i++) {
		String op= ops.get(i).getText();
			if(op.contains(val))
			ops.get(i).click();
		}
	}

}
