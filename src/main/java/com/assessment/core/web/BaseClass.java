package com.assessment.core.web;

import com.assessment.commonUtils.Logs;
import com.assessment.commonUtils.ReadConfigs;
import com.assessment.enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.OutputStream;
import java.time.Duration;

public class BaseClass {

    public static WebDriver driver;
    private static final String baseUrl = ReadConfigs.returnUrl();
    private static final String browserType = ReadConfigs.returnBrowserType();

    /**
     * creates driver instance and opens and maximizes it based on the browser type fetched from config.properties
     */
    @BeforeMethod
    public WebDriver initializeDriver() {

        if (browserType.equalsIgnoreCase(BrowserType.CHROME.getbrowserType())) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("enable-automation");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--disable-gpu");
            options.addArguments("--remote-allow-origins=*");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            driver = new ChromeDriver(options);
        } else if (browserType.equalsIgnoreCase(BrowserType.SAFARI.getbrowserType())) {
            WebDriverManager.safaridriver().setup();
            SafariOptions options = new SafariOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            driver = new SafariDriver();
        } else if (browserType.equalsIgnoreCase(BrowserType.EDGE.getbrowserType())) {
            WebDriverManager.edgedriver().setup();
            EdgeDriverService service = EdgeDriverService.createDefaultService();
            service.sendOutputTo(OutputStream.nullOutputStream());
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            driver = new EdgeDriver(service, options);
        } else {
            Logs.error("Invalid browser option provided, please check config file");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ReadConfigs.returnWaitTime()));
        driver.get(baseUrl);
        return driver;
    }


    /**
     * closes all opened driver instances
     */
    @AfterMethod()
    public void quitDriver() {
        driver.quit();
    }

}
