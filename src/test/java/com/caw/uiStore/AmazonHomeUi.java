package com.caw.uiStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomeUi extends PageFactory {
	public AmazonHomeUi(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#twotabsearchtextbox")
	public static WebElement searcInputhBox;
	@FindBy(css = "#nav-search-submit-button")
	public static WebElement searchButton;
	@FindBy(css = "#glow-ingress-line2")
	public static WebElement  deliveryAddress;
	@FindBy(css = "#GLUXZipUpdateInput")
	public static WebElement enterPicode;
	@FindBy(xpath = "//input[@aria-labelledby='GLUXZipUpdate-announce']")
	public static WebElement submitPincode;

}
