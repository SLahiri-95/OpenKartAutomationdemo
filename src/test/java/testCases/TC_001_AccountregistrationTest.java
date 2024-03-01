package testCases;

import java.time.Duration;
import pageObjects.RegistrationPage;
import pageObjects.HomePage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import TestBase.BaseClass;


public class TC_001_AccountregistrationTest extends BaseClass {
	

	@Test(groups= {"sanity","regression"})
	public void acRegistration() {
		HomePage hp = new HomePage(driver);
		logger.debug("*** Test started***");
		hp.clickOnRegister();
		RegistrationPage reg = new RegistrationPage(driver);
		logger.info("set 1st step");
		reg.setusrnm(randomString().toUpperCase());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		reg.setLastname(randomString().toUpperCase());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		reg.setEmail(randomString().toLowerCase() + "@gmail.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		reg.setPwd(randomAlphanumeric());
		reg.createAC();
		hp.verifyReg();
		logger.info("***Test END***");
	}

	

}
