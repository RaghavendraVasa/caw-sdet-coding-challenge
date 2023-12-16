package com.CAW.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.CAW.ReusebleMethods.ReusebleMethods;
import com.CAW.uiStore.Login;

public class LoginPage {
	ReusebleMethods re = new ReusebleMethods();
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		Login login = new Login(driver);
	}

	public void checkUsernameAndPasswordFields() {
		re.chekediatable(Login.username);
		re.chekediatable(Login.password);

	}

	public void validatePageTitle() {
		String Title = driver.getTitle();
		System.out.println(Title);
		Assert.assertEquals(driver.getTitle(), "Swag Labs");

	}

	public void LoginToAcc(String usn, String pwd) {
		System.out.println("field is" + usn);
		System.out.println("field is" + pwd);
		re.sendkeystoField(Login.username, usn, Login.password, pwd);

	}

	public void getcredsFromWeb() {
		String userName = Login.username.getAttribute("value");
		String password = Login.password.getAttribute("value");

		System.out.println("the username and password ares are " + userName + "  " + password);

	}

	public void handleAlert(String usn, String pwd) throws InterruptedException {
		re.sendkeystoField(Login.username, usn, Login.password, pwd);
		re.waitAndClick(Login.loginButton);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		Alert alert = driver.switchTo().alert();
//
//		// Get the text of the alert
//		String alertText = alert.getText();
//		System.out.println("Alert Text: " + alertText);
//
//		// Handle the alert (e.g., accept or dismiss)
//		alert.accept();

	}

}
