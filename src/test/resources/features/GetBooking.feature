Feature: GetBooking endpoint test scenarios

  Scenario: User should see valid response when user sends valid id
    Given User sets the "bookingId" path as 1
    When User sends a request to "/booking/{bookingId}"
    Then User should see expected booking record

  Scenario: User should see invalid response when user sends id as String

#    When User gets booking {int}