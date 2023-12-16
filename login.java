package saucelab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class login {
	WebDriver driver;
	@BeforeClass
	public void setUp() throws InterruptedException  {
	
	driver=new ChromeDriver();
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Nikhilnick\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	
	driver.get("https://www.saucedemo.com");
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();
	driver.manage().window().maximize();
	Thread.sleep(3000);
	
	
	}
	@Test
	public void test() throws InterruptedException {
		;
		String title =driver.getTitle();
		System.out.println(title);
	//	driver.switchTo().alert().accept();
		WebElement dd=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"));
		Select s1=new Select(dd);
		 s1.getFirstSelectedOption();
	
		
		
	}
	@AfterClass
	public void teardown() {
		driver.close();
		driver.quit();
	}
	

}
