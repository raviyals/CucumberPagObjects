package pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pages.locators.CarSearchPageLocators;
import utils.SeleniumDriver;

public class CarSearchPageActions {

	CarSearchPageLocators carSearchPageLocators=null;
	
	public CarSearchPageActions()
	{
		this.carSearchPageLocators = new CarSearchPageLocators();
		PageFactory.initElements(SeleniumDriver.getDriver(), carSearchPageLocators);
	}
	
	public void selectCarMake(String carMake) {
		Select selectCarMaker = new Select(carSearchPageLocators.anyMakeDropDown);
		selectCarMaker.selectByVisibleText(carMake);
	}
	public void selectCarModel(String carModel) {
		Select selectCarModel = new Select(carSearchPageLocators.anyModelDropDown);
		selectCarModel.selectByVisibleText(carModel);
	}
	public void selectCarLocation(String carLocation) {
		Select selectCarLocation = new Select(carSearchPageLocators.anyLocationDropDown);
		selectCarLocation.selectByVisibleText(carLocation);
	}
	public void selectCarPrice(String carPrice) {
		Select selectCarPrice = new Select(carSearchPageLocators.anyPriceDropDown);
		selectCarPrice.selectByVisibleText(carPrice);
	}
	
	public void clickOnFindMyCarButton() {
		carSearchPageLocators.findMyNextCarButton.click();
	}
	

}
