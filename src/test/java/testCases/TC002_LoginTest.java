package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("Starting TC_002_LoginTest");
		try
		{
		//HomeLogin
		HomePage hp = new HomePage(driver);
		hp.ClickMyAccount();
		hp.ClickLogin();
		
		//LoginPage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccountPage
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		AssertJUnit.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			AssertJUnit.fail();
			
		}
		
		logger.info("Finished TC_002_LoginTest");

	}

}
