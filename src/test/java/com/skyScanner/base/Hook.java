package com.skyScanner.base;

import com.skyScanner.constants.Config;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Hook {

    public static WebDriver driver;
    private static Logger logger = Logger.getLogger(Hook.class);

    @Before
    public void beforeEachScenario() {
        logger.info("BEFORE SCENARIO");
        System.setProperty(Config.chromeDriver, Config.driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Config.mediumTimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Config.mediumTimeout, TimeUnit.SECONDS);
        driver.get(Config.URL);
        logger.info("website open ");


        //***********************Initializing Log4j ********************************8\\
        //Log4j configuration
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        Date currentDate = new Date();
        String timeStamp = dateFormat.format(currentDate);
        System.setProperty("currenttime", timeStamp);
        PropertyConfigurator.configure(Config.log4jFilePath);
        logger.info("Log4j Configured");
        //Initializing Log4j Done********************************


    }

    @After
    public void afterEachScenario() throws InterruptedException {
        logger.info("After SCENARIO");
        Thread.sleep(2000);
        driver.quit();
    }
}
