package steps;

import org.openqa.selenium.WebDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import utils.SeleniumDriver;

public class AfterActions {
	
	@After
	public void tearDown(Scenario scenario)
	{
		WebDriver driver = SeleniumDriver.getDriver();
		byte[] screenshotBytes = ((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
		scenario.embed(screenshotBytes, "image/png");
		
		SeleniumDriver.tearDown();
	}
}
