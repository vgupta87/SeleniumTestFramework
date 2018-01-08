package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import BaseArchitecture.baseTest;

public class LoginPageOR extends baseTest{

	public LoginPageOR(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.CSS,css="a[href^='/CSA_Server/login']")
	public static WebElement lnkLogin;
	
	@FindBy(how=How.NAME,name="j_username")
	public static WebElement txtUserName;
		
	@FindBy(how=How.NAME,name="j_password")
	public static WebElement txtPassword;
	
	@FindBy(how=How.CSS,css="button[type='submit']")
	public static WebElement btnLogin;
	
	
}
