package com.caw.steps;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.caw.pageObjects.AmazonHomePage;
import com.caw.uiStore.SignInUi;
 

public class AmazonHomeSteps {
	
	public static AmazonHomePage homepage = new AmazonHomePage();

	public void enterProductInsearchbox(WebElement searcInputhBox, String product) {
		homepage.enterProductInsearchbox(searcInputhBox, product);

	}

	public void clickOnsearchBox(WebElement searchButton) {
		homepage.clickOnsearchBox(searchButton);

	}

	public void verifysuccessfulLogin(WebElement signInButton) {
		Assert.assertTrue("login is unsuccesful", homepage.verifysuccessfulLogin(signInButton));

	}

	public void clickOnDeliveryAddress(WebElement deliveryAddress) {
		homepage.clickOnDeliveryAddress(deliveryAddress);

	}

	public void sendLocation(WebElement enterPicode, String string) {
		homepage.sendLocation(enterPicode, string);

	}

	public void submitDeliveryLocation(WebElement submitPincode) {
		homepage.submitDeliveryLocation(submitPincode);

	}

	public void verifyDeliveryLocation(WebElement enterPicode, String location) {
		Assert.assertTrue("delivery location not updated", homepage.verifyDeliveryLocation(enterPicode, location));

	}

}
