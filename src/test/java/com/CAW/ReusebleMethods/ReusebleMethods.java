package com.CAW.ReusebleMethods;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusebleMethods {
	public WebDriver getDriver() {
		WebDriverManager.edgedriver().setup();
		 EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-notifications");

        // Pass ChromeOptions when creating the ChromeDriver instance
         
		WebDriver driver = new EdgeDriver(options);
		return driver;
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

	public void chekediatable(WebElement username) {
		try {

			username.isEnabled();
			username.sendKeys("randomtext");
			username.clear();
			System.out.println("======= ediatable============");
		} catch (Exception e) {
			System.out.println("=======not ediatable============");

		}

	}

	public void sendkeystoField(WebElement field, String usn, WebElement password, String pwd) {
		try {
			field.isEnabled();
			field.clear();

			field.sendKeys(usn);
			System.out.println("");
			password.isEnabled();
			password.clear();

			password.sendKeys(pwd);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());

		}
	}

	public void getURL(String uRL, WebDriver driver) {
		driver.get(uRL);
		driver.manage().window().maximize();

	}
}
