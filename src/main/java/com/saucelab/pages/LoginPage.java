package com.saucelab.pages;

import com.saucelab.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(id = "user-name")
    WebElement inputUsername;

    @FindBy(id = "password")
    WebElement inputPassword;

    @FindBy(id = "login-button")
    WebElement btnLogin;
    @FindBy(className = "bot_column")
    WebElement imgSideLogo;

    public LoginPage () {
        PageFactory.initElements (getDriver (), this);
    }

    public String loginPageTitle () {
        return getDriver ().getTitle ();
    }

    public boolean sideLogoExistence () {
        try {
            return imgSideLogo.isDisplayed ();
        }catch(Exception e){//
            return false;//
        }//
    }

    public HomePage login (String username, String password) throws InterruptedException {
        inputUsername.sendKeys (username);
        inputPassword.sendKeys (password);
        btnLogin.click ();
        Thread.sleep (5000);
        return new HomePage ();
    }

}
