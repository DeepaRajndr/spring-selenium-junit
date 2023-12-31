Feature: Google Search

  @google
  Scenario Outline: I want to search on google site
    Given I am on the google site
    When I enter "<keyword>" as the keyword
    Then I should see search results page
    Then I should see at least <count> results

    Examples:
      | keyword  | count |
      | selenium | 2     |
      | java     | 5     |
      | spring   | 7     |

