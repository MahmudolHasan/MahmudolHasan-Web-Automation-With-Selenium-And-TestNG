package com.sauce.testscipts;

import com.saucelab.base.TestBase;
import org.testng.annotations.AfterSuite;

public class BaseTest extends TestBase {

    @AfterSuite
    public void Quitebrowser(){
        getDriver ().quit ();
        closeDriver ();
    }
}
