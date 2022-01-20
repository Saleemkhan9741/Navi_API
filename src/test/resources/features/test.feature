Feature: This will test reqres website

  Scenario: Get List of Users
    Given endPoint is set to "/api/users?page=2"
    Given headers are set to
      |   content-type  |   application/json    |
    When the "GET" call is made to the request
    Then the response of the status should be 200

  Scenario: Create a User
    Given endPoint is set to "/api/users"
    Given headers are set to
      |   content-type  |   application/json    |
    And payload is created to create a user
    When the "POST" call is made to the request
    Then the response of the status should be 201
    
