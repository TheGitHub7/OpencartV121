package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC003_loginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProvider.class)//getting dataProvider from the different class
	public void verify_login(String email,String pwd,String expected)
	{
		logger.info("Starting TC_003_loginDDT");
		
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
		
		
	/* Data is Valid - login suucess - test pass - logout
	                    login failed - test fail
	                    
	    Data is inValid - login success - test fail - logout
	                       login failed - test pass                
	 
	 */
		
		if(expected.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{ 
				macc.clickLogout();
				AssertJUnit.assertTrue(true);
			}
			else
			{
				AssertJUnit.assertTrue(false);
			}
		}
		
		if(expected.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
			macc.clickLogout();
			AssertJUnit.assertTrue(false);
			}
			else
			{
				AssertJUnit.assertTrue(true);
			}
		}
	}
	catch(Exception e)
	{
		AssertJUnit.fail();
		
		
		

	}
	
	
	logger.info("finishedTC_003_loginDDT");
	
	
	

}
	
}
