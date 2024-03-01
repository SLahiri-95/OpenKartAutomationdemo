package pageObjects;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends BasePage {

	private static final String String = null;



	public RegistrationPage(WebDriver driver) {
		super(driver);

	}

	public By inputEmail = By.xpath("//input[@id='email_address']");
	public	By inputfirstname = By.xpath("//input[@name='firstname']");
	public	By inputlastname = By.xpath("//input[@name='lastname']");
	public By inputPasswd = By.xpath("//input[@id='password']");
	public By inputConfPwd = By.xpath("//input[@name='password_confirmation']");
	public By btnRegister = By.xpath("//button[@title='Create an Account']");
	public By CountryDD = By.xpath("//select[@id='input-country']/option");
	

	

	public void setusrnm(String str) {
		driver.findElement(inputfirstname).sendKeys(str);

	}

	public void setLastname(String str1) {
		driver.findElement(inputlastname).sendKeys(str1);

	}

	public void setEmail(String Email) {
		driver.findElement(inputEmail).sendKeys(Email);

	}

	public void selectCountry() {
		List<WebElement> ops = driver.findElements(CountryDD);
		for (int i = 0; i < ops.size(); i++) {
			if (ops.get(i).getText().equalsIgnoreCase("India")) {
				ops.get(i).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			}

		}

	}
	public void setPwd(String pwd) {
		driver.findElement(inputPasswd).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(inputPasswd).sendKeys(pwd);
		String cnf;
		cnf=pwd;
		driver.findElement(inputConfPwd).sendKeys(cnf);

	}
	public void createAC (){
		driver.findElement(btnRegister).click();
		
	}

}
