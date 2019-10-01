package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UsedCarsSearchPageLocators {

	@FindBy(how=How.XPATH,using="//*[@id=\"makes\"]")
	public WebElement usedMakeDropDown;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"models\"]")
	public WebElement usedModelDropDown;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"locations\"]")
	public WebElement usedLocationDropDown;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"priceTo\"]")
	public WebElement usedPriceDropDown;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"search-submit\"]")
	public WebElement findMyNextCarButton;
}
