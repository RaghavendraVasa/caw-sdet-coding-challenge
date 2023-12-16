package appiumtest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class LaunchAPP{
	
	//WebDriver driver;
	 static WebDriver driver = new ChromeDriver();
	//AndroidDriver driver3;
	
	public static void main(String[] args) throws InterruptedException {
		
		//Launching the App
		driver.get("https://www.saucedemo.com");
		
		//Getting username element through XPath
		WebElement username = driver.findElement(By.id("user-name"));
		//Getting address of password field
		WebElement password = driver.findElement(By.id("password"));
		
	//waiting to get the element visible
		Actions action = new Actions(driver);
		action.click(username);
		username.click();
		username.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		
		//validating whether username field is editable
		String useValue = username.getAttribute("Value");
		if(useValue != "") {
			System.out.println("The username field is editble");
		}
		else {
			System.out.println("The username field is not editable");
		}
		//validating whether password field is editable
		String passValue = password.getAttribute("Value");
		if(passValue != "") {
			System.out.println("The password field is editble");
		}
		else {
			System.out.println("The password field is not editable");
		}
		
		//Getting the page Title
		
		String PageTitle = driver.getTitle();
		System.out.println("Title of the page is " + PageTitle);
		
		//Getting user and password details
		WebElement user = driver.findElement(By.xpath("//div[@id=\"login_credentials\"]/br[1]"));
		System.out.println(user.getText());
		
	}
	
}
