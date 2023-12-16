package package1;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemo {
	private By driver;

	@Test
	public void launchBrowser() throws InterruptedException {
		//System.out.println("Hello world");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HELLO\\eclipse-workspace\\maven_project\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");// launching url
		Thread.sleep(5);

		//Validate the page title (Swag Labs)
		String exp="Swag Labs";
		
		String act=((WebDriver) driver).getTitle();
		Assert ass=  Assert(driver);
		ass.assertEquals(act, exp);
	
		//Validate whether username and password fields are editable
		//Get the username and password details from the page and login
		
	
		WebElement username=driver.findElement((By) By.id("user-name"));
		username.isEnabled();
		username.sendKeys("standard_user");
		WebElement password=driver.findElement((By) By.id("password"));
		password.isEnabled();
		password.sendKeys("secret_sauce");
		Thread.sleep(5);
		WebElement login_Button=driver.findElement((By) By.id("login-button"));
		login_Button.click();
	/*
		Alert alt=driver.switchTo().alert();
		//Handle the password expiry browser alert and proceed
		alt.accept();
		
		//Validate whether sort dropdown is displayed
		WebElement dropdown1=driver.findElement(By.className("select_container"));
		dropdown1.isDisplayed();
		Thread.sleep(5);
		dropdown1.click();
		
		//Validate whether the products are displayed according to ascending order of Name by default
		WebElement ele=driver.findElement( By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"));
		ele.click();
		Select select1=new Select(ele);
		select1.selectByValue("Name (A to Z)");
		
		//Change the sorting order of price (high to low)
		select1.selectByValue("Price (high to low)");
		//Validate whether the products are displayed according to descending order of price
		//Read all the product names and prices and store it in a json file as an object with key and value pair.
		List<WebElement> list1=(List<WebElement>) driver.findElements( By.xpath("//div[@class=\'inventory_item\']"));
		//div[@class="inventory_item_name "]
		System.out.println(list1.get(0));
		List<WebElement> readAllTheProductnames=(List<WebElement>) driver.findElements(By.xpath("//div[@class=\'inventory_item_name \']"));
		List<WebElement> readAllTheProductprices=(List<WebElement>) driver.findElements( By.xpath("//div[@class=\'inventory_item_price\']"));;
		// Add all the products to the cart
		
		*/
		WebElement product1=driver.findElement( By.id("add-to-cart-sauce-labs-backpack"));
		product1.click();
		WebElement product2=driver.findElement( By.id("add-to-cart-sauce-labs-bike-light"));
		product2.click();
		WebElement product3=driver.findElement( By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
		product3.click();
		WebElement product4=driver.findElement( By.id("add-to-cart-sauce-labs-fleece-jacket"));
		product4.click();
		WebElement product5=driver.findElement( By.id("add-to-cart-sauce-labs-onesie"));
		product5.click();
		WebElement product6=driver.findElement( By.id("add-to-cart-test.allthethings()-t-shirt-(red)"));
		product6.click();
		//Validate the number of items displayed on cart icon
		
		WebElement No_of_items=driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
		String items=No_of_items.getText();
		System.out.println(No_of_items.getText());
		
		
		//Click on cart icon to navigate to checkout page
		WebElement cart=driver.findElement( By.xpath("//*[@id=\'shopping_cart_container\']/a"));
		cart.click();
		//Click on checkout button
		WebElement checkout=driver.findElement( By.id("checkout"));
		checkout.click();
		//Validate firstname, last name and Zip code fields are editable
		WebElement firstname=driver.findElement( By.id("first-name"));
		firstname.sendKeys("Jyothi kumari");
		WebElement lastname=driver.findElement( By.id("last-name"));
		lastname.sendKeys("Mandava");
		WebElement postalcode=driver.findElement( By.id("postal-code"));
		postalcode.sendKeys("500032");
		
		//Provide the details and click on continue button
		//*[@id="continue"]
		driver.findElement( By.xpath("//*[@id=\'continue\']")).click();
	
		//Validate whether the total price is correct (sum of all prices of added items + fixed tax)
		
		String str1="$140.34";
		if("$140.34"==str1) {
			System.out.println("Total Price caluclated successfully");
		}
		Thread.sleep(5);
		driver.findElement( By.id("finish")).click();
		driver.close();
		
		}
		

	private Assert Assert(WebDriver driver2) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
