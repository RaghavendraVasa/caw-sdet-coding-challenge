package com.caw.pageObjects;

import org.openqa.selenium.WebElement;

import com.caw.reusableMethods.Reuseblemethods;
import com.caw.stepdef.Hooks;
import com.caw.uiStore.SignInUi;

public class SigninPage {

	public static Reuseblemethods reuse = new Reuseblemethods();
	public static SignInUi signinpPage = new SignInUi(Hooks.driver);
	public void enterUserName(WebElement email, String string) {
		 reuse.sendData(email, string);
		
	}
	public void enterPassword(WebElement password, String string) {
		 reuse.sendData(password,string);
		
	}
	public void submitUserName(WebElement submitToEmail) {
		 reuse.waitAndClick(submitToEmail);
		
	}
	public void submitPassword(WebElement submitPassword) {
		 reuse.waitAndClick(submitPassword);
		
	}
	public void clickOnSignButton(WebElement signInButton) {
		 reuse.waitAndClick(signInButton);
		
	}
}
