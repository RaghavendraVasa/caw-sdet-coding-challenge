import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.CAW.ReusebleMethods.ReusebleMethods;
import com.CAW.pageObjects.LoginPage;
import com.CAW.pageObjects.ProductPage;
import com.CAW.uiStore.Login;

@SuppressWarnings("unused")
public class Test {

	public static ReusebleMethods re = new ReusebleMethods();
	public static WebDriver driver = re.getDriver();
	public static LoginPage login = new LoginPage(driver);
	public static ProductPage product = new ProductPage(driver);
	public static String URL ="https://www.saucedemo.com/";
	

	@org.testng.annotations.Test
	public void validateUsernameAndPasswordFields() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 re.getURL(URL,driver);
		login.checkUsernameAndPasswordFields();

	}
	@org.testng.annotations.Test

	private void validateHeaer() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 re.getURL(URL,driver);
		login.validatePageTitle();

	}

	@org.testng.annotations.Test
	private void LogintoAccount() {
		re.getURL(URL,driver);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 
		login.LoginToAcc("standard_user", "secret_sauce");

	}
	@org.testng.annotations.Test
	private void getcredsFromWeb() {
		re.getURL(URL,driver);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		login.getcredsFromWeb();

	}
	@org.testng.annotations.Test
	private void  handleAlert() throws InterruptedException {
		re.getURL(URL,driver);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		login.handleAlert("standard_user", "secret_sauce");

	}
	@org.testng.annotations.Test
	public void  valiadteDropDown() throws InterruptedException {
		re.getURL(URL,driver);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		login.handleAlert("standard_user", "secret_sauce");

	}
	@org.testng.annotations.Test
	public void  validateAllProducts() {
	re.getURL(URL,driver);
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 product.valiadteDropDown();
		 

	}
	@org.testng.annotations.Test
	public void  validateALLProductsByName() {
	re.getURL(URL,driver);
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		product.valiadteDropDown();
		 product.validateALLProductsByName();
		  		 

	}
	}

