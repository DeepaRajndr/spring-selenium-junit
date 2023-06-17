Feature: Google Search

  Scenario Outline: I want to search on google site
    Given I am on the google site
    When I enter "<keyword>" as the keyword
    And I click on the search button
    Then I should see at least <count> results

    Examples:
      | keyword  | count |
      | selenium | 2     |
      | java     | 5     |
      | spring   | 7     |

