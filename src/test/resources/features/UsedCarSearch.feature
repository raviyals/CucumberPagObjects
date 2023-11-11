@Used-Search-Cars
Feature: Acceptance testing to validate Used Search cars page is working fine.
  In order to validate that
  the used search cars page is working file
  we will do the acceptance testing

  @Used-Search-Cars-Positive
  Scenario: Validate used search cars page
    Given I am on the Home Page "https://www.carsguide.com.au" of CarsGuide website
    When I move to the menu
      | Menu       |
      | buy + sell |
      | reviews    |
    And click on "Used" car link
    And select carbrand as "Hyundai" from usedMake dropdown
    And select carmodel as "Santa Fe" from usedModel dropdown
    And select location as "ACT - All" from usedLocation dropdown
    And select price as "$15,000" from UsedPrice dropdown
    And click on used Find_My_Next_Car button
    Then I should see list of used searched cars
    And the page title should be "Used Hyundai Santa Fe Under 15,000 for Sale ACT - Second Hand Hyundai Santa Fe Under 15,000 in ACT | CarsGuide"
