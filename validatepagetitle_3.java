package swag_labs;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class validatepagetitle_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.manage().window().maximize();
		//Navigate to url
		driver.get("https://www.saucedemo.com/");
		//Validate page title
		WebElement disp=driver.findElement(By.xpath("//div[@class='login_logo']"));
		
		boolean bo=disp.isDisplayed();
		System.out.println(bo);
	}

}
