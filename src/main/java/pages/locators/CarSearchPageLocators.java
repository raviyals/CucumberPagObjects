package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CarSearchPageLocators {

	@FindBy(how=How.XPATH,using="//*[@id=\"makes\"]")
	public WebElement anyMakeDropDown;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"models\"]")
	public WebElement anyModelDropDown;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"locations\"]")
	public WebElement anyLocationDropDown;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"priceTo\"]")
	public WebElement anyPriceDropDown;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"search-submit\"]")
	public WebElement findMyNextCarButton;
}
