package com.caw.uiStore;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPageUi extends PageFactory {

	public ProductPageUi(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']/span[1]")
	public static WebElement searchresults;
	@FindBy(css = "#s-result-sort-select")//#s-result-sort-select
	public static WebElement sortDropDown;
}
