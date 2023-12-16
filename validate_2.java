package swag_labs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class validate_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.manage().window().maximize();
		//Navigate to url
		driver.get("https://www.saucedemo.com/");
		//Check fields are editable are not
		WebElement user=driver.findElement(By.xpath("//input[@id='user-name']"));
		Boolean bo=user.isEnabled();
		System.out.println(bo);
		//Check fields are editable are not
		WebElement pass=driver.findElement(By.xpath("//input[@id='password']"));
		Boolean bo1=user.isEnabled();
		System.out.println(bo1);
		
	}

}
