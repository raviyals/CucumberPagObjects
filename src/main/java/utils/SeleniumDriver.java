package utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.service.DriverService;

public class SeleniumDriver {

	private static SeleniumDriver seleniumDriver;
	
	//init WebDriver
	private static WebDriver driver;
	
	public final static int TIMEOUT = 30;
	public final static int PAGE_LOAD_TIMEOUT = 50;
	
	private SeleniumDriver() throws FileNotFoundException {

		// Only logging severe errors in selenium library
		java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);

		/* Run firefox with no logging in headless mode

			FirefoxBinary firefoxBinary = new FirefoxBinary();
            firefoxBinary.addCommandLineOptions("--headless");
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/geckodriver.exe");
            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
         */

		// Run Chrome with no logging in headless mode

		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless=new");
		chromeOptions.addArguments("--silent");
		chromeOptions.addArguments("--log-level=3");
		chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

		driver = new ChromeDriver(chromeOptions);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}
	
	public static void openPage(String url) {
		driver.get(url);
	}
	
	public static WebDriver getDriver() {
		
		return driver;
	}
	
	public static void setDriver() throws FileNotFoundException {
		
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

