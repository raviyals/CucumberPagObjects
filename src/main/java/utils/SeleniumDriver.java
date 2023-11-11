package utils;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumDriver {

	private static SeleniumDriver seleniumDriver;
	
	//init WebDriver
	private static WebDriver driver;
	
//	private static WebDriverWait waitDriver;
	public final static int TIMEOUT = 30;
	public final static int PAGE_LOAD_TIMEOUT = 50;
	
	private SeleniumDriver() {
		System.setProperty("webdriver.gecko.driver","C:\\Ravy\\Development\\lib\\executables\\geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
//		waitDriver = new WebDriverWait(driver,TIMEOUT);
		
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}
	
	public static void openPage(String url) {
		driver.get(url);
	}
	
	public static WebDriver getDriver() {
		
		return driver;
	}
	
	public static void setDriver() {
		
		if (seleniumDriver==null) {
			seleniumDriver = new SeleniumDriver();		}
	}
	
	public static void tearDown() {
		
		if (driver != null) {
			driver.quit();
		}
		seleniumDriver = null;
	}
}

