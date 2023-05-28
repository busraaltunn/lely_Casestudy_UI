Feature: Search Function

  Background: user is on the web page
    Given user is on the web page

    @testA
  Scenario: Users should be able to see the word they searched with the search button in all results
    When User clicks the search button and verify search area appeared
    And User enters “happy” into the search area and click the search button
    Then User should see that the descriptions of each of the search results contain the searched word



