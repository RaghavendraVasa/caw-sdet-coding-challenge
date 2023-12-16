package com.CAW.uiStore;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product {
	

	private WebDriver driver;

	public Product(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath= "//*[@id=\"header_container\"]/div[2]/div/span/span") 
	 public static WebElement product;
	
	@FindBy(xpath= "//div[@class='inventory_item_name ']") 
	 public static List<WebElement>  Allproducts;

}
