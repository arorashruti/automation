package com.assessment.commonUtils;

import com.assessment.core.web.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class TakeScreenshot {

    public static void takeScreenshot() throws IOException {
        try {
            TakesScreenshot scrShot = ((TakesScreenshot) BaseClass.driver);
            File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File destFile = new File("./screenshots/"+LocalDateTime.now()+".png");
            FileUtils.copyFile(srcFile, destFile);
        } catch (Exception e) {
            Logs.info("Unable to capture screenshot");
        }

    }

}
