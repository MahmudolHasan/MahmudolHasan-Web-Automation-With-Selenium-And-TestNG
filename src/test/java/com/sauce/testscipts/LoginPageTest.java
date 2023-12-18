package com.sauce.testscipts;

import com.saucelab.base.TestBase;
import com.saucelab.pages.HomePage;
import com.saucelab.pages.LoginPage;
import com.saucelab.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    Utils util;

    static String sheetName = "LoginData" ;
    public LoginPageTest () {
        super ();
    }

    @BeforeMethod
    public void setup () {
        initialization ();
        loginPage = new LoginPage ();

    }

    @DataProvider(name ="LoginData")
    public Object[][] getLoginData()
    {
        util = new Utils ();
        return util.getData (sheetName);
    }

    @Test(priority = 3,dataProvider = "LoginData")
    public void loginWithValidCredentialTest(String username,String password) throws InterruptedException {
        homePage = loginPage.login (username,password);
        Assert.assertFalse (loginPage.sideLogoExistence ());//
    }
    @Test(priority = 0)
    public void validateLoginPageTitle(){
        String title = getDriver ().getTitle ();
        Assert.assertEquals (title,"Swag Labs");
    }
    @Test(priority = 1)
    public void sidePictureTest(){
        boolean flag = loginPage.sideLogoExistence ();
        Assert.assertTrue (flag);
    }
    @AfterMethod
    public void tearDown () {
        getDriver ().quit ();
        closeDriver ();
    }
}
