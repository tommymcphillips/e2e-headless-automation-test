Feature: Basic Search
  As a MarsAir Sales Director (Mark)
  I want potential customers to be able to search for flights to Mars
  So that they see what trips are available

  Scenario: Navigate MarsAir
    Given I navigate to search Marsair page
    Then There should be departure and return fields on a search form
    And Only the following departure months are displayed
      |July|
      |December|
    And Only the following returning months are displayed
      |July|
      |December|
    And Departure and returning fields should have the following options
      |July (two years from now)|
      |December (two years from now)|



