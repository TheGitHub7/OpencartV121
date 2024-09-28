package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	

	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("**** Starting TC001_AccountRegistrationTest ****");
	
		try
		{
		HomePage hp = new HomePage(driver);
		hp.ClickMyAccount();
		logger.info("Clicked on MyAccount Link");
		
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		
		
		logger.info("Providing Customer details");
		regpage.setFirstName(randomeString());
		regpage.setLastName(randomeString());
		regpage.setEmail(randomeString()+"@gmail.com");//randomly generated the email
		regpage.setTelephone(randomeNumber());
		
		String password = "randomeString()";
		regpage.setPassword(password);
		regpage.setConfirmPassword(password); 
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		
		logger.info("Validating expected message");
		String confmsg  = regpage.getConfirmationMsg();
		AssertJUnit.assertEquals(confmsg,"Your Account Has Been Created!");
		
		
	}
		catch(Exception e)
		{
			logger.error("Test Failed");
			logger.debug("Debug logs");
			Assert.fail();
		}
	
		logger.info("**** Finished TC001_AccountRegistrationTest ****");
	

	
	}
	
	

}