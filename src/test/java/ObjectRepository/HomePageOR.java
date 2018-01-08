package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseArchitecture.baseTest;


public class HomePageOR extends baseTest{

	public HomePageOR(WebDriver driver) 
	{	
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(css="header.main-header h2")
	public static WebElement homePageLogo;
	
	@FindBy(css="a[title='logout']")
	public static WebElement lnkLogout;
	
	@FindBy(css="div.user svg.icon")
	public static WebElement lnkUser;
	
	@FindBy(css="a.actions")
	public static WebElement lnkQuickGuide;
	
}
