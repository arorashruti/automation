package com.assessment.tests;

import com.assessment.commonUtils.Logs;
import com.assessment.commonUtils.ReadTestDataFromExcel;
import com.assessment.core.web.WebCoreTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.assessment.commonUtils.Listeners.class)
public class SearchTest extends WebCoreTest {

    private String sheet = "Sheet1";
    private int row = 1;

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("allure description :  test case to search in google")
    @Step("another allure feature")
    public void searchTermTest() {
        Logs.startTestCase("searchTermTest");
        googleSearchScreen.searchOnGoogle("Robot");
        String actualResult = googleSearchScreen.getFirstResult();
        Assert.assertEquals(actualResult, "Robot - Wikipedia", "verify second test in first class");
        Logs.endTestCase("searchTermTest");
    }

    @Test
    public void searchAnotherTermTest() {
        Logs.startTestCase("searchAnotherTermTest");
        googleSearchScreen.searchOnGoogle(ReadTestDataFromExcel.fetchDataFromExcel(sheet, row, 0));
        String actualResult = googleSearchScreen.getFirstResult();
        Assert.assertEquals(actualResult, ReadTestDataFromExcel.fetchDataFromExcel(sheet, row, 1), "verify first result");
        Logs.endTestCase("searchAnotherTermTest");
    }

}
