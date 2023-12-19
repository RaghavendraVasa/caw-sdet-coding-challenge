package com.CAW.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.CAW.ReusebleMethods.ReusebleMethods;
import com.CAW.uiStore.LoginUi;

public class LoginPage {
	ReusebleMethods reuse = new ReusebleMethods();
	public static WebDriver driver;
	public static String password;
	public static String username;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		LoginUi login = new LoginUi(driver);
	}

	public void checkUsernameAndPasswordFields() {
		reuse.chekediatable(LoginUi.usernameInputField);
		reuse.chekediatable(LoginUi.passwordInputField);

	}

	public void validatePageTitle() {
		String Title = driver.getTitle();
		System.out.println("The page Title is" + Title);
		Assert.assertEquals(Title, "Swag Labs");

	}

	public void getUserNameAndPasswordfieldsAndLogin() {

		reuse.sendkeystoField(LoginUi.usernameInputField, username = LoginUi.userName.getText().substring(23, 37));
		reuse.sendkeystoField(LoginUi.passwordInputField,
				password = LoginUi.passwordForAllusers.getText().substring(23, 36));
		System.out.println("username And password is " + username + " " + password);
	}

	public void clickOnLogin() {
		reuse.waitAndClick(LoginUi.loginButton);

	}

	public void verifyLogin(WebElement productsText) {
		Assert.assertTrue(productsText.getText().equals("Products"), "Login is unsuccessful");

	}

	public void verifyLoginPage(WebElement loginButton) {
		Assert.assertTrue(loginButton.isDisplayed(), "logout is unsuccsful");
	}

}
