package com.CAW.pageObjects;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v117.page.model.BackForwardCacheNotRestoredExplanationTree;
import org.testng.Assert;

import com.CAW.ReusebleMethods.ReusebleMethods;
import com.CAW.uiStore.ProductUi;
import com.google.gson.Gson;

public class ProductPage {
	ReusebleMethods re = new ReusebleMethods();
	WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		ProductUi product = new ProductUi(driver);
	}

	public void valiadteDropDown() {
		ProductUi.productsortDropDown.isDisplayed();
		ProductUi.productsortDropDown.isEnabled(); // Validating dropdown

	}

	public void validateALLProductsByName() {
		List<WebElement> productNames = ProductUi.Allproducts;
		// Validating all products is in ascending order ?
		boolean isAscending = isListInAscendingOrder(productNames);
		if (isAscending) {
			System.out.println("The products is in ascending order.");
		} else {
			System.out.println("The list is NOT in ascending order.");
		}

	}

	private static boolean isListInAscendingOrder(List<WebElement> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			String currentElement = list.get(i).getText();
			String nextElement = list.get(i + 1).getText();
			if (currentElement.compareTo(nextElement) > 0) {
				return false; // If false ->out of order, the list is not in ascending order
			}
		}
		return true; // if true All elements are in ascending order
	}

	public void verify(WebElement productsortDropWithTextNameAtoZ) {
		Assert.assertEquals(productsortDropWithTextNameAtoZ.getText(), "Name (A to Z)", "DropDown not displayed");
	}

	public void storingNameAndPriceInJson(List<WebElement> allProductsNames, List<WebElement> allProductsPrices) {

		List<Products> productList = new ArrayList<Products>();

		for (int i = 0; i < allProductsNames.size(); i++) {
			String productName = allProductsNames.get(i).getText();
			String productPrice = allProductsPrices.get(i).getText();

			productList.add(new Products(productName, productPrice));
		}

		String json = new Gson().toJson(productList);

		try (FileWriter writer = new FileWriter("products.json")) {
			writer.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addAllproductsToCartAndCheckCartIcon(List<WebElement> addTocartButton, WebElement cartIconCount) {
		for (WebElement ele : addTocartButton) {
			re.waitAndClick(ele);
		}

		if (Integer.parseInt(cartIconCount.getText()) == 0)
			Assert.assertTrue(false, "cart not updated");
		else
			System.out.println("cart updated with products");
	}

	public void validateAllProductsPrices(List<WebElement> productsNamesInCart, List<WebElement> productsPricesInCart) {
		re.waitAndClick(ProductUi.cartIconCount);
		List<Products> productsFromFile = re.readProductsFromJson("products.json");
		List<Products> productsFromAnotherSource = null;
		for (int i = 0; i < productsNamesInCart.size(); i++) {
			productsFromAnotherSource = Arrays
					.asList(new Products(productsNamesInCart.get(i).getText(), productsPricesInCart.get(i).getText()));

		}
		re.compareProducts(productsFromFile, productsFromAnotherSource);
	}

	public void verifyingTotalPrice(WebElement tax, WebElement totalAmount, WebElement sumOfProducts) {
		if (Double.parseDouble(sumOfProducts.getText().substring(13, 19))
				+ Double.parseDouble(tax.getText().substring(6, 11)) == Double
						.parseDouble(totalAmount.getText().substring(8, 14)))
			System.out.println("Total price is matched ");
		else
			Assert.assertTrue(false, "Total price is not matching please check again");

	}

	public void validateThankYouMessage(WebElement finishButton, WebElement thankyouMessage) {

		re.waitAndClick(finishButton);
		if (thankyouMessage.getText().equalsIgnoreCase("Thank you for your order!"))
			System.out.println("order places succesfully");
		else
			Assert.assertTrue(false, "order not places please check");
	}

	public void logoutFromSwagLabs(WebElement burgerMenuIcon, WebElement logoutButton) throws InterruptedException {
		re.waitAndClick(burgerMenuIcon);
		// re.applyweight();
		re.waitAndClick(logoutButton);
	}

	public void checkoutTheCartAndCheckAndCheckinginputFieldsAReEditable(WebElement checkoutButton) {
		re.waitAndClick(ProductUi.cartIconCount);
		re.waitAndClick(checkoutButton);
		// checking firstname
		re.chekediatable(ProductUi.firstName);
		re.sendkeystoField(ProductUi.firstName, "mahesh");
		// checking lastname
		re.chekediatable(ProductUi.lastName);
		re.sendkeystoField(ProductUi.lastName, "pydi");
		// checking postalcode
		re.chekediatable(ProductUi.postelcode);
		re.sendkeystoField(ProductUi.postelcode, "500032");
		re.waitAndClick(ProductUi.continueToCheckout);

	}

}
