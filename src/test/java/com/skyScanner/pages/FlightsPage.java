package com.skyScanner.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.skyScanner.base.Hook.driver;

public class FlightsPage {
    private static final org.apache.log4j.Logger logger = Logger.getLogger(FlightsPage.class);


    public FlightsPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        logger.info("Constructor initialized");
    }

    String navigationType = null;
    String tripSelector = null;
    String currentURL = null;
    String cabinOptions = null;
    String numberOfAdultsTravelers = null;
    Actions actions = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, 10);

    @FindBy(xpath = "//div[@aria-label='To continue, we need to double-check you’re not a bot! Please click and hold the button until the verification process is complete.']")
    WebElement areYouARobot_PopUp;

    @FindBy(xpath = "//iframe")
    WebElement popUo_Iframe;


    @FindBy(xpath = "//nav[@class='PrimaryNav_PrimaryNav__3g1eL']/div")
    List<WebElement> primaryNav_Buttons;
    @FindBy(xpath = "//label[@class='BpkRadio_bpk-radio__3J6D- TripTypeSelector_TripTypeSelector__1qmS8']")
    List<WebElement> app_flights_selector_options;
    @FindBy(xpath = "(//input[@placeholder='Country, city or airport'])[1]")
    WebElement flyingFrom_placeholder;
    @FindBy(xpath = "(//input[@placeholder='Country, city or airport'])[2]")
    WebElement flyingTO_placeholder;
    @FindBy(xpath = "//a[@aria-label='Close feedback form']")
    WebElement popUpClose_button;

    @FindBy(css = "[title='Departure date']")
    WebElement departureDate_textBox;
    @FindBy(css = "[id='CabinClassTravellersSelector_fsc-class-travellers-trigger__LeM38']")
    WebElement cabinClassTravellersSelector;
    @FindBy(css = "[id='search-controls-cabin-class-dropdown']")
    WebElement cabinClass_SelectOption;

    @FindBy(css = "[id='search-controls-adults-nudger']")
    WebElement numberOFAdultTravelersDefaultOption;
    @FindBy(css = "[title='Decrease number of adults']")
    WebElement decreaseNumberOfAdults_Button;
    @FindBy(css = "[title='Increase number of adults']")
    WebElement increaseNumberOfAdults_Button;
    @FindBy(css = "[aria-label='Search flights']")
    WebElement searchFlights_Button;

    public String getFlightNavigationType_Option(String navigationTypeSelector) throws InterruptedException {
        currentURL = driver.getCurrentUrl();
        try {
            for (WebElement element : primaryNav_Buttons) {
                navigationType = element.getText();
                if (navigationTypeSelector.equalsIgnoreCase(navigationType)) {
                    element.click();
                    logger.info("currentURL: " + currentURL);
                    logger.info("clicked on: " + navigationType);
                    Thread.sleep(1000);
                    break;
                }
                logger.info("invalid navigationTypeSelector:  " + navigationType);
            }
        } catch (Exception e) {
            driver.switchTo().frame(6);
            actions.moveToElement(areYouARobot_PopUp).clickAndHold().build().perform();
            Thread.sleep(5000);
            driver.switchTo().defaultContent();

            for (WebElement element : primaryNav_Buttons) {
                navigationType = element.getText();
                if (navigationTypeSelector.equalsIgnoreCase(navigationType)) {
                    element.click();
                    logger.info("currentURL: " + currentURL);
                    logger.info("clicked on: " + navigationType);
                    Thread.sleep(1000);
                    break;
                }
                logger.info("invalid navigationTypeSelector:  " + navigationType);
            }
        }
        return navigationType;

    }

    public String selectTripTypeSelector_option(String tripTypeSelector) {
        app_flights_selector_options = driver.findElements(By.xpath("//label[@class='BpkRadio_bpk-radio__3J6D- TripTypeSelector_TripTypeSelector__1qmS8']"));
        for (WebElement element : app_flights_selector_options) {
            tripSelector = element.getText();
            if (tripTypeSelector.equalsIgnoreCase(tripSelector)) {
                element.click();
                logger.info("clicked on: " + tripSelector);
                logger.info("currentURL: " + currentURL);
                break;
            }
        }
        return tripSelector;
    }

    public String selectFlyingFrom_option(String flyingFromWhere) {
        try {
            logger.info("in the try selectFlyingFrom_option ");
            flyingFrom_placeholder.sendKeys(flyingFromWhere);
        } catch (Exception e) {
            logger.info("in the catch selectFlyingFrom_option ");

            driver.switchTo().frame(4);
            popUpClose_button.click();
            driver.switchTo().defaultContent();
            flyingFrom_placeholder.sendKeys(flyingFromWhere);
            e.printStackTrace();
        } finally {
            logger.info("in the finally selectFlyingFrom_option ");

            flyingFrom_placeholder.sendKeys(flyingFromWhere);
        }

        return flyingFromWhere;
    }

    public String selectFlyingTo_option(String flyingTo) {
        try {
            flyingTO_placeholder.sendKeys(flyingTo);
        } catch (Exception e) {
            driver.switchTo().frame(4);
            popUpClose_button.click();
            driver.switchTo().defaultContent();
            flyingTO_placeholder.sendKeys(flyingTo);
            e.printStackTrace();
        } finally {
            flyingTO_placeholder.sendKeys(flyingTo);
        }

        return flyingTo;
    }


    public void setDepartureDate(String desiredDate) {
        departureDate_textBox.sendKeys(desiredDate);
        logger.info("desiredDate submitted: " + desiredDate);
    }


    public void searchForTheFlight() {
        searchFlights_Button.click();
    }
/*
    public String setCabinClass(String desiredCabinClassOption) throws InterruptedException {
        actions.moveToElement(cabinClassTravellersSelector).click().build().perform();
        Select select = new Select(cabinClass_SelectOption);
        for (int i = 0; i < select.getAllSelectedOptions().size(); i++) {
            cabinOptions = select.getAllSelectedOptions().get(i).getText();
            if (desiredCabinClassOption.equalsIgnoreCase(cabinOptions)) {
                select.getAllSelectedOptions().get(i).click();
                logger.info("clicked on: " + cabinOptions);
                Thread.sleep(1000);
                break;
            }
            logger.info("invalid navigationTypeSelector:  " + cabinOptions);
        }
        logger.info("cabinOptions:  " + cabinOptions);
        return cabinOptions;

    }*/
/*

    public String setNumberOfTravelers(String desiredNumberOfTravelers) {

        numberOfAdultsTravelers = numberOFAdultTravelersDefaultOption.getCssValue("value");
        logger.info("numberOfAdultsTravelers: " + numberOfAdultsTravelers);

        if (numberOfAdultsTravelers.equalsIgnoreCase(desiredNumberOfTravelers)) {
            SearchFlights_Button.click();
            logger.info("numberOfAdultsTravelers: " + numberOfAdultsTravelers);
        } else
            decreaseNumberOfAdults_Button.click();
        logger.info("failed to search flight !!! ");
        return numberOfAdultsTravelers;
    }

*/

}


