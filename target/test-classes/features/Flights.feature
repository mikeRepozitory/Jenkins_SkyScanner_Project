@Flights
Feature: Flight

  @OneWayFlight
  Scenario: Successfully book a flight from Florida to Washington DC
    Given user selects "Flights" tab
    Then user selects "One way" trip
    Then user selects from "Fort Lauderdale International, FL (FLL)"
    Then user selects to "Washington Ronald Reagan, VA (DCA)"
    Then user selects departure date "7/16/21"
    Then user selects Cabin Class & Travelers "Economy"
    Then user selects number of Travelers "1"



