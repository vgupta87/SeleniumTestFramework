package TestClasses;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Pages.LoginPage;


public class LoginPageTest extends LoginPage{
	
	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	final static Logger logger = Logger.getLogger(LoginPageTest.class);
	
	@Test(priority=1, description="Test method to verify the Login Functionaity")
	public void verifyLoginfunctionality()
	{
		try
		{
			initializeLoginPage();
			login();
		}
		catch (Exception e) {
			logger.error("VerifyLoginFunctionality failed because of "+e.getMessage());
		}
	}
	@Test(priority=2, description="Test method to verify the Login Functionaity")
	public void test()
	{
		try
		{
			initializeLoginPage();
			login();
		}
		catch (Exception e) {
			logger.error("VerifyLoginFunctionality failed because of "+e.getMessage());
		}
	}
}
