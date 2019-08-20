# Created by argo at 20/08/2019
@SeleniumEasy
Feature: User open selenium easy and trying to test the page

  Background:
    Given user open selenium easy page

  @Form @Regression
  Scenario Outline: User open Home page selenium easy and fill the form
    When user click on button start practicing
    And user click on simple form demo
    Then input enter message is appear
    When user type "<text>" in text message
    And user click on button show message
    Then user shouldable to see text "<text>" in result
    When user type "<a>" into text field a
    And user type "<b>" into text field b
    And user click on button get total
    Then user should see the result "<expectedSum>"
    Examples:
      | text        | a    | b         | expectedSum |
      | Hello World | 1    | 1         | 2           |
      |             | argo | triwidodo | NaN         |
      | Hello World |      | triwidodo | NaN         |
      | Hello World | 1    |           | NaN         |
      | Hello World |      | -1        | NaN         |
      | Hello World | 0    | -1        | -1          |

  @SelectionTest
  Scenario: user open home page selenium easy and select some of select box
    When user click on button start practicing
    And user click on select drop down list button
    Then select should be avaiable
    When user select on "Sunday"
    Then user should see "Sunday"
    When user select on "Wednesday"
    Then user should see "Wednesday"
    When user click on first Selected
    Then user should see "undefined" on multiple select
    When user select on multiple select "California"
    And user click on first Selected
    Then user should see "California" on multiple select
    When user deselect all country
    When user select on multiple select "Ohio,Texas,Washington"
    And user click on first Selected
    Then user should see "Ohio" on multiple select
    When user click on all Selected
    Then user should see "Washington,Texas,Ohio" on multiple select
