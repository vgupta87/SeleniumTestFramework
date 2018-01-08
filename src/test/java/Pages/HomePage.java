package Pages;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;

import BaseArchitecture.baseTest;
import ObjectRepository.HomePageOR;

public class HomePage  extends baseTest{

	final static Logger logger = Logger.getLogger(HomePage.class);
	
	//Method to verify whether user is logged in or not
	public HomePageOR isUserLoggedIn() {
		List<Boolean> result = new LinkedList<Boolean>();
		if( wait.until(ExpectedConditions.visibilityOf(HomePageOR.homePageLogo)) == null)
			result.add(false);
		result.add(true);
		if( wait.until(ExpectedConditions.visibilityOf(HomePageOR.lnkLogout)) == null)
			result.add(false);
		result.add(true);
		if( wait.until(ExpectedConditions.visibilityOf(HomePageOR.lnkUser)) == null)
			result.add(false);
		result.add(true);
		return result.contains(false)?null:new HomePageOR(driverInitialize());
	}
	
	//Method to verify the Logout Functionality
	public HomePageOR clickLogoutLink()
	{   
		if( wait.until(ExpectedConditions.visibilityOf(HomePageOR.lnkLogout)) != null)
			HomePageOR.lnkLogout.click();
		else
			return null;
		return new HomePageOR(driverInitialize());		
	}
	
	//Method to verify the user guide url
	public HomePageOR clickUserGuideLink()
	{
		if( wait.until(ExpectedConditions.visibilityOf(HomePageOR.lnkQuickGuide)) != null)
			HomePageOR.lnkQuickGuide.click();
		else
			return null;
		return new HomePageOR(driverInitialize());	
	}
}
