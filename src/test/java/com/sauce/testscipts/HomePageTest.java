package com.sauce.testscipts;

import com.saucelab.base.TestBase;
import com.saucelab.pages.HomePage;
import com.saucelab.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;

    public HomePageTest () {
        super ();
    }

    @BeforeMethod
    public void setupHomePageTest () throws InterruptedException {
        initialization ();
        loginPage = new LoginPage ();
        homePage =
                loginPage.login (prop.getProperty ("username"), prop.getProperty ("password"));

    }

    @Test(priority = 0)
    public void addItemToCartTest () {
        homePage.addBackPackToCart ();
        String status = homePage.cartStatusOfbackPack ();
        Assert.assertEquals (status, "REMOVE");

        String cartItemNumber = homePage.cartItem ();
        Assert.assertEquals (cartItemNumber, "1");
        System.out.println ("reached 1st gate");


        homePage.addBackPackToCart ();
        String cartstatus = homePage.cartStatusOfbackPack ();
        Assert.assertEquals (cartstatus, "ADD TO CART");
        System.out.println ("reached 2nd gate");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown () {
        getDriver ().quit ();

    }
}
