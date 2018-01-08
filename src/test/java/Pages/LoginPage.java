package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import BaseArchitecture.baseTest;
import ObjectRepository.HomePageOR;
import ObjectRepository.LoginPageOR;

public class LoginPage extends baseTest{

	final static Logger logger = Logger.getLogger(LoginPage.class);
	
	// Method will login into the system and will return to the home page
	public HomePageOR login() {
		
		if( wait.until(ExpectedConditions.visibilityOf(LoginPageOR.lnkLogin)) != null)
			LoginPageOR.lnkLogin.click();
		else
		{
			logger.error("Unable to click on Login link");
			return null;
		}
		if( wait.until(ExpectedConditions.visibilityOf(LoginPageOR.txtUserName)) != null)
			LoginPageOR.txtUserName.sendKeys(commonProperty.getProperty("username"));
		else
		{
			logger.error("Unable to set the username");
			return null;
		}
		if(wait.until(ExpectedConditions.visibilityOf(LoginPageOR.txtPassword)) != null)
			LoginPageOR.txtPassword.sendKeys(commonProperty.getProperty("password"));
		else
		{
			logger.error("Unable to set the username");
			return null;
		}
		if(wait.until(ExpectedConditions.visibilityOf(LoginPageOR.btnLogin)) != null)
			LoginPageOR.btnLogin.click();
		else
		{
			logger.error("Unable to click Login button");
			return null;
		}
		logger.info("login to the portal"+ commonProperty.getProperty("username") + " and " + commonProperty.getProperty("password"));
		return new HomePageOR(driverInitialize());
	}
	    //Method used to return page object elements
		public LoginPageOR initializeLoginPage()
		{
			return new LoginPageOR(driverInitialize());
		}
}
