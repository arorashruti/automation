package com.assessment.tests;

import com.assessment.core.web.WebCoreTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondSearchTest extends WebCoreTest {

    @Test
    public void secondSearchTest() {
        googleSearchScreen.searchOnGoogle("Testing");
        String actualResult = googleSearchScreen.getFirstResult();
        Assert.assertEquals(actualResult,"What is Software Testing and How Does it Work?","verify first test in second class");
    }

    @Test
    public void searchAnotherTermTest() {
        googleSearchScreen.searchOnGoogle("Google");
        String actualResult = googleSearchScreen.getFirstResult();
        Assert.assertEquals(actualResult,"Google","verify second test in second class");

    }

}
