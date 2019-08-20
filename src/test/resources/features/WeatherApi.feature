# Created by argo at 20/08/2019
  @WeatherApiFeature
Feature: as a user , i want to test weather api
  Background:
    Given user preparing for request

  Scenario: Get weather by city like
    When user get woeid from city "london"
    Then response code should be 200 in city response
    And 1 city is found in response
    And one of them is "London"
    When user hit get api location with id from previous steps
    Then response code should be 200 in weather responses
    And title in the response is "London"
    #Have more than one Result
    When user get woeid from city "lon"
    Then response code should be 200 in city response
    And 3 city is found in response
    And one of them is "Barcelona"
    When user hit get api location with id from previous steps
    Then response code should be 200 in weather responses
    And title in the response is "London,Barcelona,Long Beach"
    #negative test
    When user get woeid from city ""
    Then response code should be 403 in city response
    When user get woeid from city "Lalala"
    Then response code should be 200 in city response
    And 0 city is found in response
    When user hit on get detail weather with woeid 143
    Then response code should be 404 in weather response
