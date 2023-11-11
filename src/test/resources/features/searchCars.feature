@Search-Cars
Feature: Acceptance testing to validate Search cars page is working fine.
  In order to validate that
  the search cars page is working file
  we will do the acceptance testing

  @Search-Cars-Positive
  Scenario: Validate search cars page
    Given I am on the Home Page "https://www.carsguide.com.au" of CarsGuide website
    When I move to the menu
      | Menu       |
      | buy + sell |
      | reviews    |
    And click on "Search Cars" link
    And select carbrand as "BMW" from AnyMake dropdown
    And select carmodel as "1 Series" from AnyModel dropdown
    And select location as "ACT - All" from AnyLocation dropdown
    And select price as "$10,000" from Price dropdown
    And click on Find_My_Next_Car button
    Then I should see list of searched cars
    And the page title should be "Cheap BMW 1 Series Under 10,000 for Sale ACT | CarsGuide"
