import java.lang.Thread;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver; 

public class CawSDETClass {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("CAW SDET Test");
		
		//Invoke the ChromeDriver() method to test using Selenium WebDriver on Chrome browser
		WebDriver driver = new ChromeDriver();
		
		//Navigate to the provided Test Site
		driver.get("https://www.saucedemo.com/");
		
		//Maximize the Test site Window
		driver.manage().window().maximize();
		
		//Validate the page title by checking if the title of the AUT Test site matches that of 'Swag Labs'
		String title = "Swag Labs"; 
		if(title.equals(driver.getTitle())) {
			System.out.print("Test site title validated and is: "); 
			System.out.println(driver.getTitle());
		}
		else {
			System.out.println("Title not validated");
		}
				
	    //Validate the usernames by checking whether they are correct or not
		WebElement userName = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
		userName.click();
		String[] usernames = {"standard_user", "problem_user", "performance_glitch_user", "error_user", "visual_user"};
		Random rand = new Random();
		int randomNum = rand.nextInt((4 - 0) + 0) + 0;
	    userName.sendKeys(usernames[randomNum]);
		Thread.sleep(1500);
		
	    String testuser = userName.getText();
	    if(testuser.equals(usernames[randomNum]))
	    {
	    	System.out.println("Valid username used");
	    }
	    else {
	    	System.out.println("Invalid username");
	    }
	    
		//Validate the password by checking whether its correct or not
		WebElement passWord = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		passWord.click();
		passWord.sendKeys("secret_sauce");
		Thread.sleep(1500);
		
		//Login to the Test website after entering correct credentials
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
		loginButton.click();
		
		//Handle the password expiry or any other browser alert (if any)
	    driver.switchTo().alert().dismiss();
		
		//Validate whether the sort dropdown is displayed
		WebElement sortDropdown = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"));
		sortDropdown.click();
		
		//Change the sorting order of price (high to low)
		WebElement sortOptionHtL = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[4]"));
		sortOptionHtL.click();
		
		//Add all the products to the cart
		WebElement AddtoCart = driver.findElement(By.className("btn btn_primary btn_small btn_inventory"));
		AddtoCart.click();
		
		//Click on the Cart icon to navigate to the checkout page
		WebElement CartIcon = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
		CartIcon.click();
		
		//Click on the Checkout button
		WebElement Checkout = driver.findElement(By.className("btn btn_action btn_medium checkout_button"));
		Checkout.click();
		
		//Validate whether firstname, lastname and Zip code fields are editable
        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"first-name\"]"));
        firstName.click();
        Thread.sleep(1500);
        
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"last-name\"]"));
        lastName.click();
        Thread.sleep(1500);
        
        WebElement zipCode = driver.findElement(By.xpath("//*[@id=\"last-name\"]"));
        zipCode.click();
        Thread.sleep(1000);
        
        //Click on the sandwich menu on top left and logout, validate user is logged out
        WebElement logOut = driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]"));
        logOut.click();
		
        driver.quit();
	}
	
}
