package com.saucelab.utils;

import com.saucelab.base.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TakeScreenShot extends TestBase {
    public static String takeFailedScreenShot (ITestResult testResult) {

        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver ();
        File source = takesScreenshot.getScreenshotAs (OutputType.FILE);
        File destination = new File ("src/test/resources/failedScreenShot/" + new SimpleDateFormat ("(MM-dd_HH:mm:ss_)").format (Calendar.getInstance ().getTime ()) + testResult.getTestName () + ".png");
        try {
            FileHandler.copy (source, destination);
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
    return destination.getPath ();

    }
}
