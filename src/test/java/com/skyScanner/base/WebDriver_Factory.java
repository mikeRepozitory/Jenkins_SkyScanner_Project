package com.skyScanner.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class WebDriver_Factory {

    public static WebDriver createWebDriver() {
        String browser = System.getProperty("driver");
        if (browser != null) {
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver();
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    return new FirefoxDriver();
                case "ie":
                    WebDriverManager.iedriver().setup();
                    return new InternetExplorerDriver();
                case "opera":
                    WebDriverManager.operadriver().setup();
                    return new OperaDriver();
                default:
                    System.out.println("default to chrome driver");
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver();
            }
        } else {
            System.out.println("default to chrome driver");
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    }
  //      throw  new RuntimeException("driver is not configured");


}
