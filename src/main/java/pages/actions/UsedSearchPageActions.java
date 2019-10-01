package pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pages.locators.UsedCarsSearchPageLocators;
import utils.SeleniumDriver;

public class UsedSearchPageActions {

	UsedCarsSearchPageLocators usedCarsSearchPageLocators=null;
	
	public UsedSearchPageActions()
	{
		this.usedCarsSearchPageLocators = new UsedCarsSearchPageLocators();
		PageFactory.initElements(SeleniumDriver.getDriver(), usedCarsSearchPageLocators);
	}
	
	public void selectCarMake(String carMake) {
		Select selectCarMaker = new Select(usedCarsSearchPageLocators.usedMakeDropDown);
		selectCarMaker.selectByVisibleText(carMake);
	}
	public void selectCarModel(String carModel) {
		Select selectCarModel = new Select(usedCarsSearchPageLocators.usedModelDropDown);
		selectCarModel.selectByVisibleText(carModel);
	}
	public void selectCarLocation(String carLocation) {
		Select selectCarLocation = new Select(usedCarsSearchPageLocators.usedLocationDropDown);
		selectCarLocation.selectByVisibleText(carLocation);
	}
	public void selectCarPrice(String carPrice) {
		Select selectCarPrice = new Select(usedCarsSearchPageLocators.usedPriceDropDown);
		selectCarPrice.selectByVisibleText(carPrice);
	}
	
	public void clickOnFindMyCarButton() {
		usedCarsSearchPageLocators.findMyNextCarButton.click();
	}
	

}
