package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups={"Sanity","Master"})
	public void verify_Login() {

		 logger.info("*** starting TC002_LOginTest ***");
		try {
			// Home page
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			Thread.sleep(3000);
			hp.clickLogin();

			// its user manually enter the login details
//		LoginPage loginp = new LoginPage(driver);
//		loginp.setEmail("laxmikanthkanth77@gmail.com");
//		Thread.sleep(3000);
//		loginp.setPassword("reddy@1234");
//		Thread.sleep(2000);
//		loginp.clickloginbtn();
			
			// Login
			LoginPage loginp = new LoginPage(driver);
			loginp.setEmail(P.getProperty("Email"));
			loginp.setPassword(P.getProperty("password"));
			loginp.clickloginbtn();

//		loginp.setEmail(randomString() + "@gmail.com");
//		Thread.sleep(3000);
//		loginp.setPassword(randomAlphaNumaric());
//		Thread.sleep(2000);
//		loginp.clickloginbtn();
			
			// MyAccount page
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExists();
			Assert.assertTrue(targetPage);
		}
		catch (Exception e) {
			Assert.fail();
		}

		logger.info("*** finished TC002_LoginTest ***");

	}

}
