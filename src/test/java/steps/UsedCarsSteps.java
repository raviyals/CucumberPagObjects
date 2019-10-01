package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.actions.CarsGuideHomePageActions;
import pages.actions.UsedSearchPageActions;

public class UsedCarsSteps {

	CarsGuideHomePageActions carsGuideHomePageActions = new CarsGuideHomePageActions();
	UsedSearchPageActions usedSearchPageActions = new UsedSearchPageActions();
	
	@When("^click on \"([^\"]*)\" car link$")
	public void click_on_car_link(String arg1) throws Throwable {
		carsGuideHomePageActions.clickOnUsedCarsMenu();
	}

	@When("^select carbrand as \"([^\"]*)\" from usedMake dropdown$")
	public void select_carbrand_as_from_usedMake_dropdown(String carMake) throws Throwable {
		usedSearchPageActions.selectCarMake(carMake);
	}

	@When("^select carmodel as \"([^\"]*)\" from usedModel dropdown$")
	public void select_carmodel_as_from_usedModel_dropdown(String carModel) throws Throwable {
		usedSearchPageActions.selectCarModel(carModel);
	}

	@When("^select location as \"([^\"]*)\" from usedLocation dropdown$")
	public void select_location_as_from_usedLocation_dropdown(String carLocation) throws Throwable {
		usedSearchPageActions.selectCarLocation(carLocation);
	}

	@When("^select price as \"([^\"]*)\" from UsedPrice dropdown$")
	public void select_price_as_from_UsedPrice_dropdown(String carPrice) throws Throwable {
		usedSearchPageActions.selectCarPrice(carPrice);
	}

	@When("^click on used Find_My_Next_Car button$")
	public void click_on_used_Find_My_Next_Car_button() throws Throwable {
		usedSearchPageActions.clickOnFindMyCarButton();
	}
	
	@Then("^I should see list of used searched cars$")
	public void i_should_see_list_of_used_searched_cars() throws Throwable {
		System.out.println("Used Car list found");
	}
}
