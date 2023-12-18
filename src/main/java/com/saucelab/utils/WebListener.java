package com.saucelab.utils;

import com.saucelab.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Arrays;

public class WebListener extends TestBase implements WebDriverListener {

    private static final Logger log = LogManager.getLogger (WebListener.class); //JavaClass.class.getName() to get class Name

    @Override
    public void beforeGet (WebDriver driver, String url) {

        //System.out.println ("Navigating to : "+url);
        log.info ("Navigating to : " + url);
    }

    @Override
    public void afterGet (WebDriver driver, String url) {
        log.info ("Navigated to : " + url);
        //System.out.println ("Navigated to : "+url);
    }

    @Override
    public void afterFindElement (WebDriver driver, By locator, WebElement result) {
        // System.out.println ("Element found :"+ result);
        log.info ("Element found :" + result);
    }

    @Override
    public void afterClose (WebDriver driver) {
        log.info ("Method execution completed!Driver closed!");
        // System.out.println ("Method execution completed!Driver closed!");
    }

    @Override
    public void afterQuit (WebDriver driver) {
        //System.out.println ("Test execution completed!Driver Quited!");
        log.info ("********** Test execution completed!Driver Quited! **********");
    }

    @Override
    public void beforeClick (WebElement element) {
        log.info ("Element to be clicked :" + element);
        //System.out.println ("Element to be clicked :"+element);
    }

    @Override
    public void afterClick (WebElement element) {
        log.info ("Element clicked :" + element);
        // System.out.println ("Element clicked :"+element);
    }

    @Override
    public void onError (Object target, Method method, Object[] args, InvocationTargetException e) {
        //System.out.println ("Exception caught! Exception :"+e);
        log.error ("Exception caught!");
        try {
            log.info ("Screenshot Captured!");
            Utils.takeScreenshot (method);
        } catch (Exception ex) {
            // System.out.println ("Something happened while capturing screenshot!Error: WBL_OE_01");
            log.warn ("Something happened while capturing screenshot!Error: WBL_OE_01");

        }
    }

    @Override
    public void beforeImplicitlyWait (WebDriver.Timeouts timeouts, Duration duration) {
        //System.out.println ("Implicit timeout countdown begins!");
        log.info ("Implicit timeout countdown begins!");
    }

    @Override
    public void afterImplicitlyWait (WebDriver.Timeouts timeouts, Duration duration) {
        //System.out.println ("Implicit timeout!");
        log.info ("Implicit timeout!");
    }

    @Override
    public void beforePageLoadTimeout (WebDriver.Timeouts timeouts, Duration duration) {
        //System.out.println ("Pageload timeout countdown begins!");
        log.info ("Pageload timeout countdown begins!");
    }

    @Override
    public void afterPageLoadTimeout (WebDriver.Timeouts timeouts, Duration duration) {
        //System.out.println ("Pageload timeout countdown ends!");
        log.info ("Pageload timeout countdown ends!");
    }

    @Override
    public void beforeSendKeys (WebElement element, CharSequence... keysToSend) {
        // System.out.println ("Keys to send : "+ Arrays.toString (keysToSend));
        log.info ("Keys to send : " + Arrays.toString (keysToSend));
    }

    @Override
    public void afterSendKeys (WebElement element, CharSequence... keysToSend) {
        //System.out.println ("Keys to send : "+ Arrays.toString (keysToSend));
        log.info ("Keys  send : " + Arrays.toString (keysToSend));
    }


}
