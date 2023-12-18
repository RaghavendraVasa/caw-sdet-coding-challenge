package com.caw.stepdef;

import org.openqa.selenium.WebDriver;

import com.caw.reusableMethods.Reuseblemethods;
import com.caw.steps.ProductPageSteps;
import com.caw.uiStore.AmazonHomeUi;
import com.caw.uiStore.ProductPageUi;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductStepDef {

	public static ProductPageSteps product = new ProductPageSteps();
	public static Reuseblemethods reuse = new Reuseblemethods();
	public static WebDriver driver = Hooks.driver;

	@Then("search results should display")
	public void search_results_should_display() {
		try {
			Hooks.extentTest = Hooks.report.createTest("user search results should display ");
			product.verifySearchResults(ProductPageUi.searchresults);
			Hooks.report.flush();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@When("user sorts products from high to low")
	public void user_sorts_products_from_high_to_low() {
		try {
			Hooks.extentTest = Hooks.report.createTest("user sorts products from high to low ");
			product.sortFromHighToLow(ProductPageUi.sortDropDown, 2);
			Hooks.report.flush();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Then("search results count should change")
	public void search_results_count_should_change() {
		try {
			Hooks.extentTest = Hooks.report.createTest("search results count should change ");
			product.verifysearchResultsAfterPriceChange(ProductPageUi.searchresults);
			Hooks.report.flush();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
