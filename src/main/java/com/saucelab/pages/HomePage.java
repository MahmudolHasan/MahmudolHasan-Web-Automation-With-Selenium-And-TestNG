package com.saucelab.pages;

import com.saucelab.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath = "//div[contains(text(),'Sauce Labs Backpack')]//..//../following-sibling::div[@class='pricebar']/button")
    WebElement loc_addRemoveBackPackToCart;
//    @FindBy(xpath = "//div[@id='shopping_cart_container']/descendant::span")
//    WebElement loc_cartItemNumber;
    By loc_cartItemNumber = By.xpath("//div[@id='shopping_cart_container']/descendant::span");

    public HomePage () {
        PageFactory.initElements (getDriver (), this);
    }

    public void addBackPackToCart () {
        loc_addRemoveBackPackToCart.click ();
    }

    public String cartStatusOfbackPack () {
        return loc_addRemoveBackPackToCart.getText ();
    }

    public String cartItem () {
        WebElement test = getDriver ().findElement (loc_cartItemNumber);
        return test.getText ();
    }

}
