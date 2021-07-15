#Author: dei.cerniauskas@gmail.com
@appium
Feature: Validate Favorites functionality on News app

  @tag
  Scenario: In News application user selects news feature and saves it as favorite
    Given Launch News app
    When Welcome flow is over I can see news feed
    And and open first news option
    And click on favorites icon
    Then I validate selected news in my list
