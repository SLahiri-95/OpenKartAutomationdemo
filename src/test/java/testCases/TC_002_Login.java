package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import TestBase.BaseClass;

import pageObjects.LoginPg;

public class TC_002_Login extends BaseClass {

	@Test(groups={"smoke","regression"})
	public void Login() {

		LoginPg llp = new LoginPg(driver);
		llp.clickSignIn();
		llp.setEmailid(p.getProperty("email"));
		llp.setPassword(p.getProperty("password"));
		llp.clickSubmit();
		llp.verifyLogin();
		llp.logout(p.getProperty("val"));
		
	}

}
