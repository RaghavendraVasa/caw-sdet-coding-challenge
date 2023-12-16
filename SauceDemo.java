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
	}
		public void dropdown() throws InterruptedException{
		By driver = null;
		Alert alt=((WebDriver) driver).switchTo().alert();
		//Handle the password expiry browser alert and proceed
		alt.accept();
		//Validate whether sort dropdown is displayed
		WebElement dropdown1=driver.findElement((SearchContext) By.className("select_container"));
		dropdown1.isDisplayed();
		Thread.sleep(5);
		dropdown1.click();
		//Validate whether the products are displayed according to ascending order of Name by default
		Select select1=new Select(driver.findElement((SearchContext) By.className("product_sort_container")));
		select1.selectByValue("Name (A to Z)");
		
		//Change the sorting order of price (high to low)
		select1.selectByValue("Price (high to low)");
		//Validate whether the products are displayed according to descending order of price
		//Read all the product names and prices and store it in a json file as an object with key and value pair.
		List<WebElement> list1=(List<WebElement>) driver.findElements((SearchContext) By.xpath("//div[@class=\'inventory_item\']"));
		//div[@class="inventory_item_name "]
		System.out.println(list1.get(0));
		List<WebElement> readAllTheProductnames=(List<WebElement>) driver.findElements((SearchContext) By.xpath("//div[@class=\'inventory_item_name \']"));
		List<WebElement> readAllTheProductprices=(List<WebElement>) driver.findElements((SearchContext) By.xpath("//div[@class=\'inventory_item_price\']"));;
		// Add all the products to the cart
		}
		public void validateProduct() throws InterruptedException{
		
		By driver = null;
		WebElement product1=driver.findElement((SearchContext) By.xpath("//button[@class=\'btn btn_primary btn_small btn_inventory \'][1]"));
		product1.click();
		WebElement product2=driver.findElement((SearchContext) By.xpath("//button[@class=\'btn btn_primary btn_small btn_inventory \'][2]"));
		product2.click();
		WebElement product3=driver.findElement((SearchContext) By.xpath("//button[@class=\'btn btn_primary btn_small btn_inventory \'][3]"));
		product3.click();
		WebElement product4=driver.findElement((SearchContext) By.xpath("//button[@class=\'btn btn_primary btn_small btn_inventory \'][4]"));
		product4.click();
		WebElement product5=driver.findElement((SearchContext) By.xpath("//button[@class=\'btn btn_primary btn_small btn_inventory \'][5]"));
		product5.click();
		WebElement product6=driver.findElement((SearchContext) By.xpath("//button[@class=\'btn btn_primary btn_small btn_inventory \'][6]"));
		product6.click();
		
		((WebDriver) driver).manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		}
		//Validate the number of items displayed on cart icon
		@Test
		public void validateitems() throws InterruptedException{
		By driver = null;
		WebElement No_of_items=driver.findElement((SearchContext) By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
		String items=No_of_items.getText();
		System.out.println(No_of_items.getText());
		
		if(items.equals('6')) {
			System.out.println("User sleected 6 items");
		}
		else {
			System.out.println("User not sleected 6 items");
		}
		}
		//Click on cart icon to navigate to checkout page
		public void cart() throws InterruptedException{
		WebElement cart=driver.findElement((SearchContext) By.xpath("//*[@id=\'shopping_cart_container\']/a"));
		cart.click();
		//Click on checkout button
		WebElement checkout=driver.findElement((SearchContext) By.id("checkout"));
		checkout.click();
		//Validate firstname, last name and Zip code fields are editable
		//Provide the details and click on continue button
		Thread.sleep(5);
		}
		public void closeBrowser() throws InterruptedException{
		
		}
	

	private Assert Assert(WebDriver driver2) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
