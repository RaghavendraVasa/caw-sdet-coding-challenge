package com.caw.steps;

import org.openqa.selenium.WebElement;

import com.caw.pageObjects.AmazonHomePage;
import com.caw.pageObjects.SigninPage;

public class SigninPageSteps {

	public static SigninPage signinpage=new SigninPage();

	public void enterUserName(WebElement email, String string) {
		 signinpage.enterUserName(email,string);
		
	}

	public void enterPassword(WebElement password, String string) {
		 signinpage.enterPassword(password,string);
		
	}

	public void submitUserName(WebElement submitToEmail) {
		 signinpage.submitUserName(submitToEmail);
		
	}

	public void submitPassword(WebElement submitPassword) {
		 signinpage.submitPassword(submitPassword);
		
	}

	public void clickOnSignButton(WebElement signInButton) {
		 signinpage.clickOnSignButton(signInButton);
		
	}
}
