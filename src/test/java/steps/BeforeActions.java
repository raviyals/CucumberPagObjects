package steps;

import cucumber.api.java.Before;
import utils.SeleniumDriver;

import java.io.FileNotFoundException;

public class BeforeActions {
	
	@Before
	public static void setUp() throws FileNotFoundException {
		SeleniumDriver.setDriver();
	}
	
}
