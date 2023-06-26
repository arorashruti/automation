package com.assessment.screens;

import com.assessment.commonUtils.Logs;
import com.assessment.commonUtils.WebWaits;
import com.assessment.core.web.BaseClass;
import org.openqa.selenium.By;

public class GoogleSearchScreen {

    public static final String SEARCH_BOX = "//textarea[@title='Search']";
    public static final String GOOGLE_SEARCH_BUTTON = "//div[contains(@class,'FPdoLc')]//input[@name='btnK']";
    public static final String FIRST_RESULT_XPATH = "(//div[@id='search']//h3)[1]";

    public void searchOnGoogle(String searchTerm) {
        WebWaits.implicitWait();
        Logs.info("Search "+searchTerm+" in google");
        BaseClass.driver.findElement(By.xpath(SEARCH_BOX)).sendKeys(searchTerm);
        BaseClass.driver.findElement(By.xpath(GOOGLE_SEARCH_BUTTON)).click();
    }

    public String getFirstResult() {
        WebWaits.implicitWait();
        Logs.info("locate first result in search result");
        return BaseClass.driver.findElement(By.xpath(FIRST_RESULT_XPATH)).getText();
    }

}
