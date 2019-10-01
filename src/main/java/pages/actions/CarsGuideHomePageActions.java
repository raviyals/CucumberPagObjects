package pages.actions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import pages.locators.CarsGuideHomePageLocators;
import utils.SeleniumDriver;

public class CarsGuideHomePageActions {

	CarsGuideHomePageLocators carsGuideHomePageLocators=null;
	
	public CarsGuideHomePageActions()
	{
		this.carsGuideHomePageLocators = new CarsGuideHomePageLocators();
		PageFactory.initElements(SeleniumDriver.getDriver(), carsGuideHomePageLocators);
	}
	
	public void moveToBuySellMenu() {
		Actions action = new Actions(SeleniumDriver.getDriver());
		action.moveToElement(carsGuideHomePageLocators.buyAndSellLink).perform();;
	}
	
	public void clickOnSearchCarsMenu() {
		
		//moveToBuySellMenu
		carsGuideHomePageLocators.searchCarsLink.click();
	}
	
	public void clickOnUsedCarsMenu() {
		
		//moveToBuySellMenu
		carsGuideHomePageLocators.usedLink.click();
	}
	
	public void clickOnNewCarsMenu() {
		
		//moveToBuySellMenu
		carsGuideHomePageLocators.newLink.click();
	}
}
