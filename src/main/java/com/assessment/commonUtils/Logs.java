package com.assessment.commonUtils;

import org.apache.log4j.Logger;

public class Logs {


    private static Logger Log = Logger.getLogger(Logs.class.getName());

    /**
     * This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
     */
    public static void startTestCase(String testCaseName) {
        Log.info("********************************************************************");
        Log.info("######## start test case : " + testCaseName + " ########");
        Log.info("********************************************************************");
    }


    /**
     * This is to print log for the ending of the test case
     */
    public static void endTestCase(String testCaseName) {
        Log.info("********************************************************************");
        Log.info("######## End test case : " + testCaseName + " ########");
        Log.info("XXXX");
    }

    public static void info(String message) {
        Log.info(message);
    }

    public static void warn(String message) {
        Log.warn(message);
    }

    public static void error(String message) {
        Log.error(message);
    }

    public static void fatal(String message) {
        Log.fatal(message);
    }

    public static void debug(String message) {
        Log.debug(message);
    }


}
