package com.caw.pageObjects;

import org.openqa.selenium.WebElement;

import com.caw.reusableMethods.Reuseblemethods;
import com.caw.stepdef.Hooks;
import com.caw.uiStore.AmazonHomeUi;

public class AmazonHomePage {
	public static Reuseblemethods reuse = new Reuseblemethods();
	public static AmazonHomeUi uistore = new AmazonHomeUi(Hooks.driver);
	

	public void enterProductInsearchbox(WebElement searcInputhBox, String product) {
		reuse.sendData(searcInputhBox, product);

	}

	public void clickOnsearchBox(WebElement searchButton) {
		reuse.waitAndClick(searchButton);

	}

	public boolean verifysuccessfulLogin(WebElement signInButton) {
		if (signInButton.getText().equals("Hello, mahesh"))
			return true;
		else
			return false;

	}

	public void clickOnDeliveryAddress(WebElement deliveryAddress) {
		 reuse.waitAndClick(deliveryAddress);
	}

	public void sendLocation(WebElement enterPicode, String string) {
		 reuse.sendData(enterPicode, string);
		
	}

	public void submitDeliveryLocation(WebElement submitPincode) {
		 reuse.waitAndClick(submitPincode);
		
	}

	public boolean verifyDeliveryLocation(WebElement enterPicode, String location) {
		 if(enterPicode.getText().equals(location))
			 return true;
		 else
			 return false;
		
	}

}
