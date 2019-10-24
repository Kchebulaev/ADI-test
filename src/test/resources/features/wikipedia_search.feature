Feature: As a User I want to go to Wikipedia and search for a few fruits
  @RegressionSuite
  Scenario Outline: Searching wikipedia for fruits (Negative flow)
    Given I am on the Wikipedia landing page
    When I search for <query>
    Then I get error message <error message>
    And I see link for page creation

    Examples:
      | query         | error message                             |
      | 1234567899812947861238741 | There were no results matching the query. |
      | qazwsxedcrfv | There were no results matching the query. |


  @RegressionSuite @SmokeSuite
  Scenario Outline: Searching wikipedia for fruits (Positive flow)
    Given I am on the Wikipedia landing page
    When I search for <entry>
    Then I get article with title <entry>
    And I see content of the page

    Examples:
      | entry  |
      | Orange |
      | Lemon  |

  @RegressionSuite @SmokeSuite
    Scenario: Search input is available on Wikipedia landing page
      Given I am on the Wikipedia landing page
      Then I see search input
      And Search input in empty
