package com.caw.uiStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInUi extends PageFactory  {

	public SignInUi(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#ap_email")
	public static WebElement email;
	@FindBy(xpath = "//input[@id='continue']")//#s-result-sort-select
	public static WebElement submitToEmail;
	@FindBy(css = "#ap_password")//#s-result-sort-select
	public static WebElement  password;
	@FindBy(xpath = "//input[@id='signInSubmit']")
	public static WebElement submitPassword;
	@FindBy(css = "#nav-link-accountList-nav-line-1")
	public static WebElement signInButton;
	

}
