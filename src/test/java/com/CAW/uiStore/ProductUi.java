package com.CAW.uiStore;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductUi {

	private WebDriver driver;

	public ProductUi(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@class='product_sort_container']")
	public static WebElement productsortDropDown;

	@FindBy(xpath = "//select[@class='product_sort_container']/option[1]")
	public static WebElement productsortDropWithTextNameAtoZ;

	@FindBy(xpath = "//div[@class='inventory_item_name ']")
	public static List<WebElement> Allproducts;
	@FindBy(xpath = "//span[contains(text(),'Products')]")
	public static WebElement productsText;
	@FindBy(xpath = "//div[@class='inventory_item_name ' or @class='inventory_item_name align_right']")
	public static List<WebElement> AllProductsNames;
	@FindBy(xpath = "//div[@class='inventory_item_price']")
	public static List<WebElement> AllProductsPrices;

	@FindBy(xpath = "//button[contains(text(),'Add to cart')]")
	public static List<WebElement> addTocartButton;
	@FindBy(css = ".shopping_cart_badge")
	public static WebElement cartIconCount;
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	public static List<WebElement> productsNamesInCart;
	@FindBy(xpath = "//div[@class='inventory_item_price']")
	public static List<WebElement> productsPricesInCart;

	@FindBy(xpath = "//input[@id='first-name']")
	public static WebElement firstName;
	@FindBy(xpath = "//input[@id='last-name']")
	public static WebElement lastName;
	@FindBy(xpath = "//input[@id='postal-code']")
	public static WebElement postelcode;
	@FindBy(xpath = "//button[@id='checkout']")
	public static WebElement checkoutButton;
	@FindBy(xpath = "//input[@id='continue']")
	public static WebElement continueToCheckout;
	@FindBy(xpath = "//div[@class='summary_subtotal_label']")
	public static WebElement sumOfProducts;
	@FindBy(xpath = "//div[@class='summary_tax_label']")
	public static WebElement tax;
	@FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
	public static WebElement totalAmount;
	@FindBy(xpath = "//button[@id='finish']")
	public static WebElement finishButton;

	@FindBy(xpath = "//h2[@class='complete-header']")
	public static WebElement thankyouMessage;

	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	public static WebElement burgerMenuIcon;

	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	public static WebElement logoutButton;

}
