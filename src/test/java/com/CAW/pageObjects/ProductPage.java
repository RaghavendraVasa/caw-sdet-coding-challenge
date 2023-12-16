package com.CAW.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.CAW.ReusebleMethods.ReusebleMethods;
import com.CAW.uiStore.Login;
import com.CAW.uiStore.Product;

public class ProductPage {
	ReusebleMethods re = new ReusebleMethods();
	WebDriver driver;
	 
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		 Product p=new Product(driver);
	}

	public void valiadteDropDown() {
		 Product.product.isDisplayed();
		 Product.product.isEnabled();
		 
		
	}

	public void validateALLProductsByName() {
		 List<WebElement>  productNames=Product.Allproducts;
		 
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
            String nextElement = list.get(i + 1).getText();;

            // Compare current and next elements
            if (currentElement.compareTo(nextElement) > 0) {
                return false; // If out of order, the list is not in ascending order
            }
        }
        return true; // All elements are in ascending order
    }

}
