package swag_labs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sortdropdown_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.manage().window().maximize();
		//Navigate to url
		driver.get("https://www.saucedemo.com/");
		//Check get user name
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("visual_user");
		//Check get password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		//login pageclick
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		//next page
		WebElement dropdown=driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		Boolean bo=dropdown.isDisplayed();
		System.out.println(bo);
		
	}

}
