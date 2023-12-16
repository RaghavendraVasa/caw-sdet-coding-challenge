package testcases;

import org.json.simple.JSONArray;

import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.google.gson.JsonParser;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import java.util.HashMap;

import java.util.List;

public class TC001 {
	
	private WebDriver driver;

	private WebDriverWait wait;

	private String url = "https://www.saucedemo.com/";
	
	
	@BeforeClass
	public void setUp() throws Exception {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
	}
	
	@Test
	private void TC0011() throws IOException, ParseException {

         driver.get(url);
		
		//Asserting the username and password fields are enabled
		WebElement usernameField = driver.findElement(By.id("user-name"));
		WebElement passwordField = driver.findElement(By.id("password"));
		Assert.assertTrue(usernameField.isEnabled(), "Username field is not editable!");
		Assert.assertTrue(passwordField.isEnabled(), "Password field is not editable!");
		
		//Asserting the upage Title

		String expectedTitle = "Swag Labs";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle, "Page title mismatch!");
		
		driver.findElement(By.id("login-button")).click();
		driver.switchTo().alert().accept();
		
		WebElement dropdown_element = driver.findElement(By.className("product_sort_container"));
		
		// Assert if the element is displayed
		assert dropdown_element.isDisplayed();
		
		Select dropdownElement = new Select(dropdown_element);
		dropdownElement.selectByValue("hilo");
		
		JSONParser parser = new JSONParser();

		FileReader reader = new FileReader(".\\src\\test\\resources\\configfiles\\JSONdata.json");

		JSONArray jsonArray =(JSONArray) parser.parse(reader);{
		
		for (int i = 0; i < jsonArray.size(); i++) {

			JSONObject jsonObject = (JSONObject) jsonArray.get(i);
		
		HashMap<String, Object> dataMap = new HashMap<String, Object>();
		
		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
		
		WebElement cartIcon = driver.findElement(By.className("shopping_cart_badge"));
		
		String itemCountText = cartIcon.getText(); // Get the text content of the cart icon
		int itemCount = Integer.parseInt(itemCountText); // Parse the text to an integer
		
		Assert.assertEquals(6, itemCount, "Number of items in cart is not 6!");
		cartIcon.click();
		
		driver.findElement(By.id("checkout")).click();
		
		WebElement firstnameField = driver.findElement(By.id("first-name"));
		WebElement lastnameField = driver.findElement(By.id("last-name"));
		WebElement postalcodeField = driver.findElement(By.id("postal-code"));
		
		//Asserting the fields
		Assert.assertTrue(firstnameField.isEnabled(), "First name field is not editable!");
		Assert.assertTrue(lastnameField.isEnabled(), "Last name field is not editable!");
		Assert.assertTrue(postalcodeField.isEnabled(), "Postal code field is not editable!");
		
		firstnameField.sendKeys("Grace");
		lastnameField.sendKeys("K");
		postalcodeField.sendKeys("560037");
		
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
		
		WebElement messageElement = driver.findElement(By.xpath("//h2[contains()='Thank you for your order!']"));

		String expectedmessage = "Thank you for your order!";
		String actualmessage = messageElement.getText();
		
		//Asserting the thank you message
		Assert.assertEquals(expectedmessage, actualmessage, "Incorrect thank you message displayed!");

		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		
		//Asserting the home page is coming and validating the swag labs
		Assert.assertEquals(expectedTitle, actualTitle, "Page title mismatch!");

	} 

		
	}
	}

	
}
	
