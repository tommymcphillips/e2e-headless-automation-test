Feature: Basic Search
  As a MarsAir Sales Director (Mark)
  I want potential customers to be able to search for flights to Mars
  So that they see what trips are available

  Scenario Outline: Doing a valid search in Search Page <Departure> & <Returning>
    Given I navigate to search Marsair page
    When I perform a search with "<Departure>", "<Returning>" values
    Then I should see the successful result page
    Examples:
      | Departure | Returning                   |
      | July      | December (two year from now)|


