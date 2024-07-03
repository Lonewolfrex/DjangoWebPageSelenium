Feature: Testing Django Demo Website home page feature
  Scenario: View the Home Page
    Given I launch the Django demo website
    Then I view the Home Page
    Then I click on the "<select_feature>"
    #Then I revert back to home page

    Examples:
      | select_feature				|
      | calculator						|
      | fibonacci							|
      | palindrome						|
      