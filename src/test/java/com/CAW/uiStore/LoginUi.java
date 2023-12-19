package com.CAW.uiStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginUi extends PageFactory {

	@FindBy(xpath = "//input[@id='user-name']")
	public static WebElement usernameInputField;
	@FindBy(xpath = "//div[contains(text(),'standard_user')]")
	public static WebElement userName;

	@FindBy(xpath = "//div[contains(text(),'secret_sauce')]")
	public static WebElement passwordForAllusers;
	@FindBy(css = "#password")
	public static WebElement passwordInputField;

	@FindBy(css = "#login-button")
	public static WebElement loginButton;

	private WebDriver driver;

	public LoginUi(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
