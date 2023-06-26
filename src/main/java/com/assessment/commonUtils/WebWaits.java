package com.assessment.commonUtils;

import com.assessment.core.web.BaseClass;

import java.time.Duration;

public class WebWaits {

    /** this wait provides a default wait time in seconds
     * fetched from config.properties
     */
    public static void implicitWait(){
        BaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ReadConfigs.returnWaitTime()));
    }

    /** explain about explicit wait here
     *
     */
    public static void explicitWait(){

    }

    /** explain about fluent wait here
     *
     */
    public static void fluentWait(){

    }


}
