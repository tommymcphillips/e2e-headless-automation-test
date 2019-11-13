Feature: Promotional Codes
  As a MarsAir Sales Director (Mark)
  I want to distribute promotional codes to customers
  So that they get discounts and are more tempted to purchase tickets

  Acceptance criteria
    Promotional codes are in the format XX9-XXX-999.
    Characters are all random.
    The first digit indicates the discount percentage (2 = 20%, 3 = 30% etc).
    The next two digits are random.
    The final digit is a check digit; it is equal to the sum of all other digits modulo 10, eg:
  @promotionalcode
  Scenario Outline: Doing search with <PromotionalCode> in Search Page <Departure> & <Returning>
    Given I navigate to search Marsair page
    When I perform a search with "<Departure>", "<Returning>", and "<PromotionalCode>" values
    Then I should see the promotion result page with the "<PromotionalMessage>"
    Examples:
      | Departure | Returning                     | PromotionalCode   | PromotionalMessage                                |
      | July      | December (two year from now)  | AF1-FJK-416       | Promotional code AF1-FJK-416 used: 10% discount!  |
      | July      | December (two year from now)  | AF2-FJK-417       | Promotional code AF2-FJK-417 used: 20% discount!  |
      | July      | December (two year from now)  | AF3-FJK-418       | Promotional code AF3-FJK-418 used: 30% discount!  |
      | July      | December (two year from now)  | AF4-FJK-419       | Promotional code AF4-FJK-419 used: 40% discount!  |
      | July      | December (two year from now)  | JJ5-OPQ-320       | Promotional code JJ5-OPQ-320 used: 50% discount!  |
      | July      | December (two year from now)  | JJ6-OPQ-321       | Promotional code JJ6-OPQ-321 used: 60% discount!  |
      | July      | December (two year from now)  | JJ7-OPQ-322       | Promotional code JJ7-OPQ-322 used: 70% discount!  |
      | July      | December (two year from now)  | JJ8-OPQ-323       | Promotional code JJ8-OPQ-323 used: 80% discount!  |
      | July      | December (two year from now)  | JJ9-OPQ-324       | Promotional code JJ9-OPQ-324 used: 90% discount!  |

  @promotionalcode
  Scenario Outline: Doing search with invalid <PromotionalCode> in Search Page <Departure> & <Returning>
    Given I navigate to search Marsair page
    When I perform a search with "<Departure>", "<Returning>", and "<PromotionalCode>" values
    Then I should see the promotion result page with the "<PromotionalMessage>"
    Examples:
      | Departure | Returning                     | PromotionalCode   | PromotionalMessage                    |
      | July      | December (two year from now)  | AF1-FJK-414       | Sorry, code AF1-FJK-414 is not valid  |
      | July      | December (two year from now)  | AF2-FJK-418       | Sorry, code AF2-FJK-418 is not valid  |
      | July      | December (two year from now)  | AF3-FJK-411       | Sorry, code AF3-FJK-411 is not valid  |
      | July      | December (two year from now)  | AF3-FJK-148       | Sorry, code AF3-FJK-148 is not valid  |
      | July      | December (two year from now)  | AF4-FJK-329       | Sorry, code AF4-FJK-419 is not valid  |
      | July      | December (two year from now)  | JJ5-OPQ-311       | Sorry, code JJ5-OPQ-311 is not valid  |
      | July      | December (two year from now)  | JJ6-OPQ-111       | Sorry, code JJ6-OPQ-111 is not valid  |
      | July      | December (two year from now)  | JJ1-OPQ-657       | Sorry, code JJ1-OPQ-657 is not valid  |
      | July      | December (two year from now)  | JJ9-OPQ-851       | Sorry, code JJ9-OPQ-851 is not valid  |
      | July      | December (two year from now)  | JJ10-OPQ-112      | Sorry, code JJ10-OPQ-112 is not valid |

  @promotionalcode
  Scenario Outline: Doing unavailable search with a valid <PromotionalCode> in Search Page <Departure> & <Returning>
    Given I navigate to search Marsair page
    When I perform a search with "<Departure>", "<Returning>", and "<PromotionalCode>" values
    Then I should see the result page with the "<SearchContent>"
    Examples:
      | Departure | Returning                     | PromotionalCode   | SearchContent                              |
      | July      | July (two year from now)      | AF1-FJK-414       | Sorry, there are no more seats available.  |