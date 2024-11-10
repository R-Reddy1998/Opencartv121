package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
 
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {
		
		logger.info("*** Starting TC001_AccountRegistrationTest ***");
		try 
		{
					
		HomePage hp = new HomePage(driver);
		hp.clickMyaccount();
		hp.clickRegister();
		
//	manually enter the login data like fname lname email password 
		
//		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
//		regpage.setFirstName("Chinni");
//		regpage.setLastname("Reddy");
//		regpage.setEmail("chinnireddy@gmail.com");
//		regpage.setPassword("reddy@12345");
//		regpage.setSubscribechkbox();
//		regpage.setprivacypolicy();
//		regpage.clickContinue();
//	String confmsg=regpage.getConfirmationMsg();
//	Assert.assertEquals(confmsg,"Your Account Has Been Created!");
//	}
//	
 
		// random auto generated login details 
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		regpage.setFirstName(randomeString().toUpperCase());				// random fname generated
		regpage.setLastname(randomeString().toUpperCase());					// random lname generated
		regpage.setEmail( randomeString()+"@gmail.com");					//random email generated
		regpage.setPassword(randomAlphaNumaric());									// random password generated
		regpage.setSubscribechkbox();
		regpage.setprivacypolicy();
		regpage.clickContinue();
		
		logger.info("validateing expeted message..");
	String confmsg=regpage.getConfirmationMsg();
	if (confmsg.equals("Your Account Has Been Created!")) {
		Assert.assertTrue(true);
	}
	else
	{
		logger.error("Test failed..");
		logger.debug("Debug logs..");
		Assert.assertTrue(false);
	}
	Assert.assertEquals(confmsg,"Your Account Has Been Created!");
	}
		
		catch(Exception e)
		{
			
			Assert.fail();
			
		}
	
	logger.info("*** Finished TC001_AccountRegistrationTest ***");
	
	}

}
	
	

