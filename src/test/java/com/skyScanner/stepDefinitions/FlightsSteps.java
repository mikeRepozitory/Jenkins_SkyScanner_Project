package com.skyScanner.stepDefinitions;

import com.skyScanner.pages.FlightsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.skyScanner.base.Hook.driver;


public class FlightsSteps {


    FlightsPage flightsPage = new FlightsPage(driver);


    @Given("user selects {string} tab")
    public void userSelectsTab(String navigationType) throws InterruptedException {
        flightsPage.getFlightNavigationType_Option(navigationType);

    }

    @Then("user selects {string} trip")
    public void userSelectsTrip(String oneWayTrip_option) throws InterruptedException {
        flightsPage.selectTripTypeSelector_option(oneWayTrip_option);
    }

    @Then("user selects from {string}")
    public void userSelectsFrom(String from) {
        flightsPage.selectFlyingFrom_option(from);
    }

    @Then("user selects to {string}")
    public void userSelectsTo(String to) {
        flightsPage.selectFlyingTo_option(to);
    }

    @Then("user selects departure date {string}")
    public void userSelectsDepartureDate(String departureDate) {
        flightsPage.setDepartureDate(departureDate);
    }

    @Then("user selects Cabin Class & Travelers {string}")
    public void userSelectsCabinClassTravelers(String cabinClass)  {
        flightsPage.searchForTheFlight();
    }

    @Then("user selects number of Travelers {string}")
    public void userSelectsNumberOfTravelers(String numberOfTravelers) {


    }
}
