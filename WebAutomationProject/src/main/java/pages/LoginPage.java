package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {
	private final By userNameInput = By.xpath("//input[@id='user-name']");
	private final By passWordInput = By.id("password");
	private final By btnLogin = By.id("login-button");
	private final By btnErrorMessage = By.xpath("//*[name()='svg']");
	private final By errorMessage = By.cssSelector("h3[data-test='error']");
	protected WebDriver driver;

	public void inputUserName() throws InterruptedException {

		input(userNameInput, "standard_user");
		TimeUnit.SECONDS.sleep(3);
		//System.out.println("Url Login Page:" + getCurrentUrl());
		// System.out.printf("Login Page executed");
	}
	public void inputPassword() throws InterruptedException {
		input(passWordInput, "secret_sauce");
		TimeUnit.SECONDS.sleep(3);
	}
	

	public List<String> ListInputtedCredentials() throws InterruptedException {
		List<String> credentials = new ArrayList<>();
		inputUserName();
		
		credentials.add(find(userNameInput).getAttribute("value"));
		credentials.add(find(passWordInput).getAttribute("value"));
		return credentials;
	}

	public void clickOnLoginButton() {
		click(btnLogin);
		
	}

	private void wrongCredintial() {
		input(userNameInput, "standard_user05");
		input(passWordInput, "secret_sauce");
	}

	public boolean errorMessageVisibleWithCrossButton() {
		wrongCredintial();
		click(btnLogin);
		return isVisible(btnErrorMessage) && isVisible(errorMessage);


	}

	public void ClickOnBtnErrorMessage() {
		click(btnErrorMessage);
	}

	public String ErrorMessageOnWrongCredential() {
		return get_Text(errorMessage);
	}

	public boolean clickOnErrorMessageCrossButton() {
		click(btnErrorMessage);
		return find(btnErrorMessage).isDisplayed();
	}

	public void forDebugging() {
		input(userNameInput, "standard_user05");
		input(passWordInput, "secret_sauce");
		click(btnLogin);
		boolean flag = find(errorMessage).isDisplayed();
		String msg;
		msg = find(errorMessage).getText();
		System.out.print("Msg Status: ." + flag + ".\n Message: " + msg);


	}

	public void cleanUpBothInputField() {
		find(userNameInput).clear();
		find(passWordInput).clear();
	}
	public void cleanUpInputField() {
		//find(userNameInput).clear();
		find(passWordInput).clear();
	}
}

