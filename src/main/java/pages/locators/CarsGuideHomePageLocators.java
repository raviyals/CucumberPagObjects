package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CarsGuideHomePageLocators {

	@FindBy(how=How.XPATH,using="/html/body/header/div[2]/div/div[1]/ul/li[1]/a")
	public WebElement buyAndSellLink;
	
	@FindBy(how=How.LINK_TEXT,using="reviews")
	public WebElement reviewsLink;
	
	@FindBy(how=How.XPATH,using="/html/body/header/div[2]/div/div[1]/ul/li[1]/div/div/div[1]/ul/li[1]/a")
	public WebElement searchCarsLink;
	
	@FindBy(how=How.XPATH,using="/html/body/header/div[2]/div/div[1]/ul/li[1]/div/div/div[1]/ul/li[2]/a")
	public WebElement usedLink;
	
	@FindBy(how=How.LINK_TEXT,using="New")
	public WebElement newLink;
}
