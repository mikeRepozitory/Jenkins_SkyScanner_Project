package com.skyScanner.constants;

public class Config {

    public static final String chromeDriver = "webdriver.chrome.driver";
    public static final String driverPath = System.getProperty("user.dir") + "//drivers//chromedriver.exe";

    public static final String URL = "https://www.skyscanner.com/";
    public static final String log4jFilePath = System.getProperty("user.dir") + "//src//test///resources///log4j///log4j.properties";


    public static final String ExcelFilePath = System.getProperty("user.dir") + "//src//main//resources//data//TestData.xlsx";
    public static final String mySqlConnString = "jdbc:mysql://127.0.0.1:3306/testdatas";
    public static final String mySqlUser = "root";
    public static final String mySqlPassword = "admin";

    public static final long smallTimeout = 5;
    public static final long mediumTimeout = 15;
    public static final long largeTimeout = 30;
    public static final String cyramacademyteachablecom = "Cyramqatest123";


}
