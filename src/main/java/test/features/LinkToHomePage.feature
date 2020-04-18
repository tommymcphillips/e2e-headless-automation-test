Feature: Link to Home Page
  As a MarsAir Sales Director (Mark)
  I want potential customers to be able to go back to the flight search from anywhere on the site
  So that they are guided towards booking trips

  Acceptance criteria
    “Book a ticket to the red planet now!” should apperar somewhere prominent on the page.
    Clicking it takes the user to the home page.
    Clicking the MarsAir logo on the top left should also take the user to the home page.

  @linktohomepage
  Scenario Outline: Navigating back to Search page from Result page
    Given I navigate to search Marsair page
    And I perform a search with "<Departure>", "<Returning>" values
    When I click the back button in the result page
    Then I should be back at the Search Page
    And The "<Text>" should appear in the Search Form
    Examples:
      | Departure | Returning                     |Text                                |
      | July      | December (two year from now)  |Book a ticket to the red planet now!|

  @linktohomepage
  Scenario Outline: Clicking Logo in search result page
    Given I navigate to search Marsair page
    And I perform a search with "<Departure>", "<Returning>" values
    When I click the MarsAirs logo in the result page
    Then I should be back at the Search Page
    Examples:
      | Departure | Returning                   |
      | July      | December (two year from now |