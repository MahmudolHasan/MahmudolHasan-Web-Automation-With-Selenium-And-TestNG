package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;
import pages.LoginPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseTest {
	LoginPage loginPage = new LoginPage();
	SoftAssert softassert;
	/* WebDriverWait wait; */

	@Test(priority = 0)
	public void UnsuccessfulLogin_Message_With_Wrong_Username_Password() throws InterruptedException {
		softassert = new SoftAssert();
		if (loginPage.errorMessageVisibleWithCrossButton()) {
			String actualErrorMsg = loginPage.ErrorMessageOnWrongCredential();
			String expectedErrorMsg = "Epic sadface: Username and password do not match any user in this service";
			softassert.assertEquals(actualErrorMsg,
					expectedErrorMsg,
					"The error message for providing wrong username and password is not visible!");
		}
		softassert.assertAll();
		Thread.sleep(3);
		loginPage.cleanUpBothInputField();

	}

	//	@ // Test(priority = 3)
	//	public void inputTest() throws InterruptedException {
	//		loginPage.cleanUpBothInputField();
	//		softassert = new SoftAssert();
	//		List<String> actualInput = new ArrayList<>();
	//		actualInput = loginPage.ListInputtedCredentials();
	//		System.out.println(actualInput);
	//		softassert.assertEquals(actualInput.get(0), "standard_user", "The provided username is wrong!");
	//		softassert.assertEquals(actualInput.get(1), "secret_sauce", "The provided password is wrong!");
	//		softassert.assertAll();
	//		System.out.print("All is Ok in wrong input!T3\n");
	//	}

	//	@//Test(priority = 1)
	//	public void loginButtonFunctionality() throws InterruptedException {
	//		softassert = new SoftAssert();
	//
	//		loginPage.cleanUpBothInputField();
	////		TimeUnit.SECONDS.sleep(2);
	////		
	////		loginPage.inputCredential();
	////		TimeUnit.SECONDS.sleep(2);
	////		
	////		loginPage.clickOnLoginButton();
	////		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	////		softassert.assertEquals(loginPage.getCurrentUrl(),
	////				"https://www.saucedemo.com/v1/inventory.html",
	////				"User didn't directed to HomePage!");
	////		softassert.assertAll();
	//
	//		// return new HomePage();
	//
	//	}
	@Test(priority = 2)
	public void loginButtonFunctionality() throws InterruptedException {
		loginPage.cleanUpBothInputField();
		loginPage.inputUserName();
		Thread.sleep(2);
		loginPage.cleanUpInputField();
		loginPage.inputPassword();
		loginPage.clickOnLoginButton();
	}

	//	public void debugging() {
	//		loginPage.forDebugging();
	//	}

}
