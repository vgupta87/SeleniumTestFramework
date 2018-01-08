package BaseArchitecture;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class driverInit {

	private static WebDriver _driver;
	private static driverInit instance = null;

	protected driverInit() {
		// Exists only to defeat instantiation.
	}

	public static driverInit getInstance() {
		if (instance == null) {
			instance = new driverInit();
		}
		return instance;
	}

	// Method to instantiate the driver
	public WebDriver driverInitialize() {

		String browserType = baseTest.commonProperty.getProperty("browser");
		String workingDir = System.getProperty("user.dir");
		if(_driver == null)
		{
			if (browserType.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", workingDir + "//drivers//chromedriver.exe");
				_driver = new ChromeDriver();
				_driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				new WebDriverWait(_driver, 60);
	
			} else if (browserType.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", workingDir + "//drivers//geckodriver.exe");
				_driver = new FirefoxDriver();
				_driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				new WebDriverWait(_driver, 60);
			} else {
				_driver = new InternetExplorerDriver();
				_driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				new WebDriverWait(_driver, 60);
			}
		}
		return _driver;
		
		
	}
	
	//Method to reset the instance
	public void CreateNullInstance(){
		instance = null;
		_driver = null;
	}
}
