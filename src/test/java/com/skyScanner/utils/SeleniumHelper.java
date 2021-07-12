package com.skyScanner.utils;

import com.skyScanner.constants.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SeleniumHelper {

    public static WebElement waitForElementPresent(WebDriver driver, long timeout, By by){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement elem = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        driver.manage().timeouts().implicitlyWait(Config.mediumTimeout, TimeUnit.SECONDS);
        return elem;
    }




}
