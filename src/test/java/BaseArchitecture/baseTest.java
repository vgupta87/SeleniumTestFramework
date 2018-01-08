package BaseArchitecture;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class baseTest extends driverInit{

	public static WebDriver webdriver;
	public static WebDriverWait wait;
	public static Properties commonProperty;
	final static Logger logger = Logger.getLogger(baseTest.class);
	private HashMap<String, String> failedTestCases = new HashMap<String,String>();
	

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() throws IOException
	{
		String workingDir = System.getProperty("user.dir");
		InputStream input;
		try {
			input = new FileInputStream(workingDir + "//src//test//resources//Config.properties");
			commonProperty = new Properties();
			commonProperty.load(input);
		} catch (FileNotFoundException e) {
			logger.error("Unable to load Configuration because of "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	@BeforeMethod(alwaysRun = true)
	public void navigateToURL(){		
		driverInit instance = driverInit.getInstance();
		webdriver = instance.driverInitialize();
		driverInitialize().manage().window().maximize();
		driverInitialize().manage().deleteAllCookies();
		webdriver.get(commonProperty.getProperty("url"));
		wait = new WebDriverWait(webdriver, 60);
		
	}

	
	@AfterMethod
	public void afterTestMethod(ITestResult result)
	{
	    try
	 {
	    if(result.getStatus() == ITestResult.SUCCESS)
	    {
	    	logger.info("Log Message:: Test Method "+result.getName()+"- has Passed");	        
	    }
	    else if(result.getStatus() == ITestResult.FAILURE)
	    {
	    	onTestFailure(result);

	    }

	     else if(result.getStatus() == ITestResult.SKIP ){

	    	 logger.info("Log Message:: Test Method "+result.getName()+"- has Skipped");

	    }
	}
	   catch(Exception e)
	   {
	     e.printStackTrace();
	   }
	}
	
	//Method to handle failed test cases.
	public void onTestFailure(ITestResult result) {
		failedTestCases.put(result.getClass().toString(), result.getName());
		File src= ((TakesScreenshot)webdriver). getScreenshotAs(OutputType. FILE);
		try {
			FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"//screenshots//"+result.getName()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Log Message::Test Method "+result.getName()+"- has Failed");
		
	}
	@AfterMethod(alwaysRun = true)
	public void testMethodEnd() {
		webdriver.quit();
		CreateNullInstance();
	}
	
	
	
	
}
