package com.assessment.commonUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigs {

    /**
     * returns the value of browser declared in config.properties file
     */
    public static String returnBrowserType() {
        return fetchDataFromConfig("browser");
    }

    /**
     * returns the value of url declared in config.properties file
     */
    public static String returnUrl() {
        return fetchDataFromConfig("url");
    }

    /**
     * returns the value of implicitWaitTimeout declared in config.properties file
     */
    public static int returnWaitTime() {
        String timeout = fetchDataFromConfig("implicitWaitTimeout");
        return new Integer(timeout);
    }

    /**
     * @param configKey should be the key from configurations mentioned in config.properties file
     * @return  returns value of the key
     */
    public static String fetchDataFromConfig(String configKey) {
        String value = null;
        try {
            File file = new File("./test-config/config.properties");
            FileInputStream fis = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fis);
            value = (String) properties.get(configKey);
            return value;
        } catch (Exception e) {
            Logs.error("File not found, please check the file path");
        }
        return value;
    }


}
