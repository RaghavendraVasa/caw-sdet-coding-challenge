package com.caw.steps;

import org.openqa.selenium.WebElement;

import com.caw.pageObjects.ProductPage;

public class ProductPageSteps {

	public static ProductPage product=new ProductPage();
	public void verifySearchResults(WebElement searchresults) {
		  product.verifySearchResults(searchresults);
	}
	public void sortFromHighToLow(WebElement sortDropDown, int i) {
		 product.sortFromHighToLow(sortDropDown,i);
		
	}
	public void verifysearchResultsAfterPriceChange(WebElement searchresults) {
		 product.verifysearchResultsAfterPriceChange(searchresults);
	}

}
