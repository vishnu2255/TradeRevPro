@smoke
Feature: Validate careers page and filtering


  @career
  Scenario Outline: UI - Check Canada TradeRev careers page is displayed properly
    Given I launch TradeRev home page
    And   Navigate to <section> page
    And   Validate the <section> page is displayed correctly
    When  I click on <country> job opportunities
    Then  Validate <country> job site is displayed correctly

  Examples:
    |section|country|
    |careers|canadian|

  @filter1
  Scenario Outline: UI - Check location filter
    Given I launch TradeRev job portal
    And  I check the job portal is loaded
    When  I filter the search results by location <city>
    Then  Validate the listed job results should belong to <city>
    And   I log the total number of jobs listed

    Examples:
      |city  |
      |Toronto, Ontario, Canada|

  @filter2
  Scenario Outline: UI - Check location and team filters
    Given I launch TradeRev job portal
    And  I check the job portal is loaded
    When  I filter the search results by <city> and <team>
    Then  Validate the listed jobs belong to <city> and <team>
    And   I log the total number of jobs listed

    Examples:
      |city   |team|
      |Toronto, Ontario, Canada|Engineering|