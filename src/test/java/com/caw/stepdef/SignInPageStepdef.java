package com.caw.stepdef;

import org.openqa.selenium.WebDriver;

import com.caw.reusableMethods.Reuseblemethods;
import com.caw.steps.SigninPageSteps;
import com.caw.uiStore.SignInUi;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class SignInPageStepdef {
	public static SigninPageSteps signIn = new SigninPageSteps();
	public static Reuseblemethods reuse = new Reuseblemethods();
	public static WebDriver driver = Hooks.driver;

	@When("user enters username in sign in page")
	public void user_enters_username_in_sign_in_page() {
		try {
			Hooks.extentTest = Hooks.report.createTest("user enters username in sign in page");
			signIn.enterUserName(SignInUi.email, "maheshchowpydi@gmail.com");
			Hooks.report.flush();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@And("user submit the username in sign in page")
	public void user_submit_the_username_in_sign_in_page() {
		try {
			Hooks.extentTest = Hooks.report.createTest("user submit the username in sign in page");
			signIn.submitUserName(SignInUi.submitToEmail);
			Hooks.report.flush();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@When("user enters password in sign in page")
	public void user_enters_password_in_sign_in_page() {
		try {
			Hooks.extentTest = Hooks.report.createTest("user enters password in sign in page");
			signIn.enterPassword(SignInUi.password, "Bigbang@98");
			Hooks.report.flush();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@And("user submit the password sign in page")
	public void user_submit_the_password_sign_in_page() {
		try {
			Hooks.extentTest = Hooks.report.createTest("user submit the password sign in page");
			signIn.submitPassword(SignInUi.submitPassword);
			Hooks.report.flush();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@When("user click on signIn button")
	public void user_click_on_sign_in_button() {
		try {
			Hooks.extentTest = Hooks.report.createTest("user click on signIn button");
			signIn.clickOnSignButton(SignInUi.signInButton);
			Hooks.report.flush();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
