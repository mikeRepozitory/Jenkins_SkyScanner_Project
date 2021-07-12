package com.skyScanner.utils;

import org.apache.log4j.Logger;

public class Log4jHelper {

    public static void error(Logger logger, String message){
        logger.error("Error: " + message);
    }

    public static void error(Logger logger,  Exception ex){
        logger.error("Exception Catched: " + ex);
    }




}
