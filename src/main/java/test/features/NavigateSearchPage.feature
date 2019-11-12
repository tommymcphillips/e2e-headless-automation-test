Feature: Navigate Search Page
  As a MarsAir Sales Director (Mark)
  I want potential customers to be able to search for flights to Mars
  So that they see what trips are available

  Acceptance criteria
    There should be ‘departure’ and ‘return’ fields on a search form.
    Flights leave every six months, in July and December, both ways.
    Trips for the next two years should be searchable.
    If there are seats, display “Seats available! Call 0800 MARSAIR to book!”
    If there are no seats, display “Sorry, there are no more seats available.”

  @basicsearch @smoketest
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

  Scenario Outline: Navigate MarsAir (Validating Content)
    Given I navigate to search Marsair page
    Then The "<Text>" should appear in the Search Form
    Examples:
      |Text                                |
      |Book a ticket to the red planet now!|




