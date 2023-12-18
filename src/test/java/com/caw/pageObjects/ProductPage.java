package com.caw.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.caw.reusableMethods.Reuseblemethods;
import com.caw.stepdef.Hooks;
import com.caw.uiStore.ProductPageUi;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductPage {
	public static Reuseblemethods reuse = new Reuseblemethods();
	public static ProductPageUi productUi = new ProductPageUi(Hooks.driver);
	int productSearchResults;

	public void verifySearchResults(WebElement searchresults) {
		int searchResults = Integer.parseInt(searchresults.getText().substring(13, 14).replace(",", ""));
		productSearchResults = searchResults;

		if (searchResults <= 0)
			Assert.assertTrue("no search results found" + searchResults, false);
		else
			System.out.println("given search has given " + searchResults + " results");

	}

	public void sortFromHighToLow(WebElement sortDropDown, int i) {
		reuse.SelectValueFromDropDown(sortDropDown, i);

	}

	public void verifysearchResultsAfterPriceChange(WebElement searchresults) {
		int searchResults = Integer.parseInt(searchresults.getText().substring(13, 14).replace(",", ""));
		if (searchResults <= 0)
			Assert.assertTrue("no search results found" + searchResults, false);
		else
		{
			System.out.println("given search has given " + searchResults + " results");
		if(productSearchResults!=0)
			System.out.println("Search results is changed to "+searchResults);
		else
			Assert.assertTrue("Search results not changed", false);

	}
	}
}
