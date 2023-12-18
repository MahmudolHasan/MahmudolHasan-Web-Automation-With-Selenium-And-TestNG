package com.saucelab.base;

import com.saucelab.utils.Utils;
import com.saucelab.utils.WebListener;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

public class TestBase {

    public static Properties prop;

    Logger logger;
    public static WebDriverListener listener = new WebListener();
    //public static WebFiringDecorator

    public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<> ();

    public TestBase () {
        try {
            prop = new Properties ();
            FileInputStream fileInputStream = new FileInputStream (
                    "src/main/java/com/saucelab/config/config.properties");
            prop.load (fileInputStream);
        } catch (NotFoundException e) {
            e.printStackTrace ();
        } catch (IOException io) {
            io.printStackTrace ();
        }
    }

    public static synchronized WebDriver getDriver () {
        return threadLocal.get ();
    }

    public static synchronized void closeDriver () {
        threadLocal.remove ();
    }

    public void initialization () {
        WebDriver driver;
        String browserName = prop.getProperty ("browser");
        if (browserName.equalsIgnoreCase ("chrome")) {
            driver = new ChromeDriver ();
           // threadLocal.set (driver);
        } else if (browserName.equalsIgnoreCase ("firefox")) {
            driver = new FirefoxDriver ();
            //threadLocal.set (driver);
        } else {
            driver = new EdgeDriver ();
            //threadLocal.set (driver);
        }
        driver = new EventFiringDecorator<> (listener).decorate (driver);
        threadLocal.set (driver);
        getDriver ().manage ().window ().maximize ();
        getDriver ().manage ().timeouts ().pageLoadTimeout (Duration.ofSeconds (Utils.pageLoadTimeOut));
        getDriver ().manage ().timeouts ().implicitlyWait (Duration.ofSeconds (Utils.implicitTimeOut));
        getDriver ().get (prop.getProperty ("url"));

    }
    @AfterSuite
    public void tearDown () {
        getDriver ().close ();
        getDriver ().quit ();
        closeDriver ();

    }

}