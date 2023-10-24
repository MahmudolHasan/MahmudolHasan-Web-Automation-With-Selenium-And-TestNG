package tests;



import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.github.dockerjava.api.model.Driver;

import pages.BasePage;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class BaseTest {
    protected WebDriver driver;
    protected BasePage base_page;
    // protected LoginPage login_page;
    protected String URL = "https://www.saucedemo.com/v1/index.html";

    
   // public void setupBrowser() {}

    @BeforeTest
    public void LoadApplications() {
    	driver = new FirefoxDriver();
        driver.manage().window().maximize();
        base_page = new BasePage();
        base_page.setDriver(driver);
        driver.get(URL);


    }

    @AfterMethod
    public void FailedTestScreenShot(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(
                    System.getProperty("user.dir") + "/src/test/resources/failed_test_screenshots/" + testResult.getName() + ".png");

            try {
                FileHandler.copy(source, destination);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
       
        // System.out.println("After Method Printed!");
        //driver.close();


    }
   

    @AfterSuite
    public void quiteBrowser() {
        driver.quit();
        // System.out.println("After Suite Printed!");
    }


}

