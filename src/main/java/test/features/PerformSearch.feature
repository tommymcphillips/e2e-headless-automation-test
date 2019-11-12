Feature: Basic Search
  As a MarsAir Sales Director (Mark)
  I want potential customers to be able to search for flights to Mars
  So that they see what trips are available

  Acceptance criteria
    There should be ‘departure’ and ‘return’ fields on a search form.
    Flights leave every six months, in July and December, both ways.
    Trips for the next two years should be searchable.
    If there are seats, display “Seats available! Call 0800 MARSAIR to book!”
    If there are no seats, display “Sorry, there are no more seats available.”

  Invalid Return Dates
  As a MarsAir Sales Director (Mark)
  I want to prevent potential customers from searching for invalid trips
  So that they don’t waste time, and book valid ones

  Acceptance criteria
    “Unfortunately, this schedule is not possible. Please try again.” displayed when return date is less than 1 year from the departure.
  @basicsearch
  Scenario Outline: Doing search in Search Page with <Departure> & <Returning>
    Given I navigate to search Marsair page
    When I perform a search with "<Departure>", "<Returning>" values
    Then I should see the result page with the "<SearchContent>"
    Examples:
      | Departure | Returning                   | SearchContent |
      | July      | December (two year from now)| Seats available! Call 0800 MARSAIR to book!|
      | July      | July (next year)            | Sorry, there are no more seats available.  |
  @basicsearch @invalidreturndates
   Scenario Outline: Searching for invalid trips in Search Page <Departure> & <Returning>
    Given I navigate to search Marsair page
    When I perform a search with "<Departure>", "<Returning>" values
    Then I should see the result page with the "<SearchContent>"
    Examples:
      | Departure                     | Returning                   | SearchContent |
      | July                          | December                    | Unfortunately, this schedule is not possible. Please try again.|
      | December (two year from now)  | July                        | Unfortunately, this schedule is not possible. Please try again.|
      | July                          | July                        | Unfortunately, this schedule is not possible. Please try again.|






