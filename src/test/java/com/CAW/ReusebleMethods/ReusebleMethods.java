package com.CAW.ReusebleMethods;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CAW.pageObjects.Products;
import com.google.gson.Gson;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusebleMethods {
	public static WebDriver driver;

	public WebDriver getDriver() {
		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--disable-notifications");

		driver = new EdgeDriver(options);
		return driver = new EdgeDriver(options);

	}

	public void waitAndClick(WebElement element) {

		int attemps = 0;

		try {
			element.click();
			System.out.println("=========Clicked on given locator=========");

		} catch (Exception e) {
			System.out.println("=======unable to wait and click on given locator============");
		}
	}

	public void chekediatable(WebElement field) {
		try {
			String editable = field.getAttribute("readonly");
			boolean isEditable = !(editable != null && editable.equals("true"));
			if (isEditable)
				System.out.println("======= field is ediatable============");
			else
				System.out.println("=======field is not ediatable============");
		} catch (Exception e) {
			System.out.println("=======not ediatable============");

		}

	}

	public void sendkeystoField(WebElement field, String usn) {
		try {
			field.isEnabled();
			field.clear();
			field.sendKeys(usn);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());

		}
	}

	public void getURL(String uRL, WebDriver driver) {
		driver.get(uRL);
		driver.manage().window().maximize();

	}

	public void SelectValueFromDropDown(WebElement element, int selector) {

		try {
			Select dropdown = new Select(element);
			dropdown.selectByIndex(selector);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static List<Products> readProductsFromJson(String filePath) {
		try (FileReader reader = new FileReader(filePath)) {
			return Arrays.asList(new Gson().fromJson(reader, Products[].class));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void compareProducts(List<Products> products1, List<Products> products2) {

		for (Products product1 : products1) {
			for (Products product2 : products2) {
				if (product1.getName().equals(product2.getName())) {
					// Comparing prices
					if (product1.getPrice().equals(product2.getPrice())) {
						System.out.println("Product " + product1.getName() + " has the same price in both sources.");
					} else {
						System.out
								.println("Product " + product1.getName() + " has different prices in the two sources.");
					}
					break; // Break inner loop since we found a match
				}
			}
		}
	}
}
