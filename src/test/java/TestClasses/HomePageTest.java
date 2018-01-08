package TestClasses;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;


public class HomePageTest extends HomePage{
	
	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	final static Logger logger = Logger.getLogger(HomePageTest.class);
	
	@Test(description="Test method to verify the logout Functionaity")
	public void verifyLogoutfunctionality()
	{
		try
		{ 
			LoginPage login = new LoginPage();
			login.initializeLoginPage();
			if(login.login() == null)
				Assert.fail("Unable to login to the portal");
			isUserLoggedIn();
			clickLogoutLink();
		}
		catch (Exception e) {
			logger.error("VerifyLoginFunctionality failed because of "+e.getMessage());
		}
	}
	
	@Test(description="Test method to verify the logout Functionaity")
	public void verifyUserGuideLink()
	{
		try
		{ 
			LoginPage login = new LoginPage();
			login.initializeLoginPage();
			if(login.login() == null)
				Assert.fail("Unable to login to the portal");
			clickUserGuideLink();
		}
		catch (Exception e) {
			logger.error("VerifyLoginFunctionality failed because of "+e.getMessage());
		}
	}
	@Test(description="Test method to verify the logout Functionaity")
	public void failedTestCase()
	{
		try
		{ 
			Assert.assertFalse(true);
		}
		catch (Exception e) {
			logger.error("VerifyLoginFunctionality failed because of "+e.getMessage());
		}
	}
	
}
