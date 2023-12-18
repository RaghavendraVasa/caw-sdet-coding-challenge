package com.caw.stepdef;

import org.openqa.selenium.WebDriver;

import com.caw.reusableMethods.Reuseblemethods;
import com.caw.steps.AmazonHomeSteps;
import com.caw.steps.SigninPageSteps;
import com.caw.uiStore.AmazonHomeUi;
import com.caw.uiStore.SignInUi;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonHomepagestepdef {
	public static AmazonHomeSteps homesteps = new AmazonHomeSteps();
	public static Reuseblemethods reuse = new Reuseblemethods();

	public static SigninPageSteps signIn = new SigninPageSteps();
	public static WebDriver driver = Hooks.driver;

	 
	@When("user enters {string} in searchbox in amazon")
	public void user_enters_in_searchbox_in_amazon(String product) {
		try {
			Hooks.extentTest = Hooks.report.createTest("user searches product in homepagein amazon ");
			homesteps.enterProductInsearchbox(AmazonHomeUi.searcInputhBox, product);
			Hooks.report.flush();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@When("user click on searchbox in homepage")
	public void user_click_on_searchbox_in_homepage() {
		try {
			Hooks.extentTest = Hooks.report.createTest("click on searchbox in amazon ");
			homesteps.clickOnsearchBox(AmazonHomeUi.searchButton);
			Hooks.report.flush();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@When("user waits for page to load")
	public void user_waits_for_page_to_load() {
		try {
			Hooks.extentTest = Hooks.report.createTest("wait for page to load");
			reuse.waitForpageToload();
			Hooks.report.flush();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Then("user should be navigate to homepage")
	public void user_should_be_navigate_to_homepage() {
		try {
			Hooks.extentTest=Hooks.report.createTest("user should navigate to homepagein amazon ");	 
			homesteps.verifysuccessfulLogin(SignInUi.signInButton);
			Hooks.report.flush();
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		 
	}

	@When("use click on delivey address locator")
	public void use_click_on_delivey_address_locator() {
		try {
			Hooks.extentTest=Hooks.report.createTest("click on delivery address in amazon ");	 
			homesteps.clickOnDeliveryAddress(AmazonHomeUi.deliveryAddress);
			Hooks.report.flush();
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		 
	}

	@Then("user update delivery address in Choose your location popup")
	public void user_update_delivery_address_in_choose_your_location_popup() {
		try {
			Hooks.extentTest=Hooks.report.createTest("u updating delivery location in amazon ");	 
			homesteps.sendLocation(AmazonHomeUi.enterPicode, "50008");
			homesteps.submitDeliveryLocation(AmazonHomeUi.submitPincode);
			Hooks.report.flush();
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		 
	}

	@Then("location should should updated to {string}")
	public void location_should_should_updated_to(String location) {
		try {
			Hooks.extentTest=Hooks.report.createTest("verify delivery location");	 
			homesteps.verifyDeliveryLocation(AmazonHomeUi.enterPicode, location);
			Hooks.report.flush();
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		 
	}
}
