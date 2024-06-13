Feature: Get Affiliates

  Scenario: Retrieve affiliates list
    Given the API is available
    When I send a GET request
    Then the response status should be 200
    And the response should contain a list of affiliates
