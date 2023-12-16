package com.CAW.uiStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends PageFactory {
	
	@FindBy(xpath= "//*[@id=\"user-name\"]") 
	 public static WebElement username;
	
	@FindBy(css= "#password") 
	 public static WebElement password;
	
	@FindBy(css= "#login-button") 
	 public static WebElement loginButton;

	private WebDriver driver;

	public Login(WebDriver driver) {
		 
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	

	public static void valiadteHeader() {
		 
		
	}

}
