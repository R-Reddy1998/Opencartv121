package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDataproviderTest extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups="DataDriver") // getting data provider from different
																				// class
	public void verify_LoginDataProvider(String Email, String password, String exp) {
	
		logger.info("*** starting TC003_LoginDataProvider ***");
		
		try 
		{
		// Home page
		HomePage hp = new HomePage(driver);
		hp.clickMyaccount();
		hp.clickLogin();

		LoginPage loginp = new LoginPage(driver);
		loginp.setEmail("Email");
		loginp.setPassword("password");
		loginp.clickloginbtn();

		// MyAccount
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExists();
		/*
		 * Data is valid - login success - test pass - lougout 
		 * Data is valid - login failed - test fail
		 * 
		 * Data is invalid - login  success - test fail - lougout
		 *  Data is valid - login  failed - test pass
		 */
		if (exp.equalsIgnoreCase("valid")) {
			if (targetPage == true) {
				
				 macc.clickLogout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if (exp.equalsIgnoreCase("invalid"))
		{
			if (targetPage == true) 
			{
				macc.clickLogout();
				Assert.assertTrue(false);
				
			}
			else
			{
				Assert.assertTrue(true);
			}
		

	}
	}
		catch (Exception e)
		{
		Assert.fail();
		}
		logger.info("*** finished TC003_LoginDataProvider ***");

	}
	}
