package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class BasePage {

	public static WebDriver bpdriver;

	

	public void setDriver(WebDriver driver) {
		BasePage.bpdriver = driver;
	}

	protected boolean isVisible(By locator) {
		return find(locator).isDisplayed();
	}

	protected WebElement find(By locator) {
		return bpdriver.findElement(locator);
	}

	protected List<WebElement> finds(By locator) {
		return bpdriver.findElements(locator);
	}

	protected void click(By locator) {
		find(locator).click();
	}

	protected void input(By locator, String input) {
		find(locator).sendKeys(input);
	}

	protected String get_Text(By locator) {
		return find(locator).getText();
	}

	


	
	public String getCurrentUrl() {
		return bpdriver.getCurrentUrl();
	}


}


