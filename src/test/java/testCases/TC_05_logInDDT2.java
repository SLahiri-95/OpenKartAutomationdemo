package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.LoginPg;
import utils.DataProviders;

public class TC_05_logInDDT2 extends BaseClass {

	@Test (dataProvider = "LoginData" , dataProviderClass = DataProviders.class)
	public void LoginDDT(String email , String pwd , String Verify) {

		LoginPg llp = new LoginPg(driver);
		llp.clickSignIn();
		llp.setEmailid(email);
		llp.setPassword(pwd);
		llp.clickSubmit();
		llp.verifyLogin();
		boolean tp=llp.loginPageexist();
		if(Verify.equalsIgnoreCase("valid")) {
			if (tp==true) {
				System.out.println(tp);
				
				Assert.assertTrue(true);
				llp.logout(p.getProperty("val"));
			}
			else {
				
				Assert.fail();
			}
		}
		if(Verify.equalsIgnoreCase("Invalid")) {
			if (tp==true) {
				llp.logout(p.getProperty("val"));
				Assert.assertTrue(false);
			}
			else {
				
				Assert.assertTrue(true);
			}
		}
		
	}

}
