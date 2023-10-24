package tests;

import pages.HomePage;
import pages.LoginPage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HomeTest extends BaseTest {
    String link = "https://www.saucedemo.com/v1/inventory.html";
    HomePage home_page = new HomePage();
    SoftAssert softassert;

   
    @Test()
    public void LogoutButton() throws InterruptedException {
    	Thread.sleep(2);
    	softassert = new SoftAssert();
    	softassert.assertEquals(home_page.clickOnMenuBar(), "True","SideBar menu is not clicked!");
    	Thread.sleep(3);
    	home_page.clickOnMenuButton();
    	
    	
    }
    @Test
    public void logout() {
    	home_page.clickOnLogout();
    }

}
