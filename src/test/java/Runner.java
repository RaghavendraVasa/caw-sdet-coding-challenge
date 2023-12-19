import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CAW.ReusebleMethods.ReusebleMethods;
import com.CAW.pageObjects.LoginPage;
import com.CAW.pageObjects.ProductPage;
import com.CAW.uiStore.LoginUi;
import com.CAW.uiStore.ProductUi;

public class Runner {

	public static ReusebleMethods reuse = new ReusebleMethods();
	public static WebDriver driver = reuse.getDriver();
	public static LoginPage login = new LoginPage(driver);
	public static ProductPage product = new ProductPage(driver);
	public static String URL = "https://www.saucedemo.com/";

	@BeforeMethod
	public void openeingBrowser() {
		reuse.getURL(URL, driver);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@Test(description = "verifying username and password are editable", priority = 1)
	public void validateUsernameAndPasswordFields() { // verifying username and password are editable
		login.checkUsernameAndPasswordFields();

	}

	@Test(description = "verifying  page title", priority = 2)
	public void validatepageTitle() { // verifying page title
		login.validatePageTitle();

	}

	@Test(description = "get username and password from attribute and login ", priority = 3)
	public void getUserNameAndPasswordfieldsAndLogin() {
		login.getUserNameAndPasswordfieldsAndLogin(); // get username and password from attribute and login
		login.clickOnLogin();
		login.verifyLogin(ProductUi.productsText);

	}

	@SuppressWarnings("deprecation")
	@Test(description = "validating dropdown in productpage", priority = 4)
	public void validateDropDownInProductPage() {
		login.getUserNameAndPasswordfieldsAndLogin(); // validating dropdown in productpage
		login.clickOnLogin();
		product.valiadteDropDown();
		product.verify(ProductUi.productsortDropWithTextNameAtoZ);
	}

	@SuppressWarnings("deprecation")
	@Test(description = "verifying  all products are in ascending order by name", priority = 5)
	public void validateALLProductsByName() {
		validateDropDownInProductPage();
		product.validateALLProductsByName(); // verifying all products are in ascending order by name
		reuse.SelectValueFromDropDown(ProductUi.productsortDropDown, 1);
		product.validateALLProductsByName();

	}

	@SuppressWarnings("deprecation")
	@Test(description = "verifying  all products are in descnding order by name", priority = 6)
	public void changeSortingOfPriceHighToLowAndCheck() {
		login.getUserNameAndPasswordfieldsAndLogin();
		login.clickOnLogin();
		product.valiadteDropDown(); // verifying all products are in descnding order by name
		product.verify(ProductUi.productsortDropWithTextNameAtoZ);
		reuse.SelectValueFromDropDown(ProductUi.productsortDropDown, 1);
		product.validateALLProductsByName();

	}

	@Test(description = " Storing name and price in json file", priority = 6)
	public void storingNameAndPriceInJson() {
		login.getUserNameAndPasswordfieldsAndLogin();
		login.clickOnLogin(); // Storing name and price in json file
		product.valiadteDropDown();
		product.verify(ProductUi.productsortDropWithTextNameAtoZ);
		product.storingNameAndPriceInJson(ProductUi.AllProductsNames, ProductUi.AllProductsPrices);

	}

	@Test(description = "Add all products to cart and check cart icon and comapring prices with jsonfile", priority = 7)
	public void addAllproductsToCartAndCheckCartIcon() throws InterruptedException {
		login.getUserNameAndPasswordfieldsAndLogin(); // Add all products to cart and check cart icon and comapring
														// prices with jsonfile
		login.clickOnLogin();
		product.addAllproductsToCartAndCheckCartIcon(ProductUi.addTocartButton, ProductUi.cartIconCount);
		product.validateAllProductsPrices(ProductUi.productsNamesInCart, ProductUi.productsPricesInCart);

	}

	@Test(description = "Add all products to cart and checkout and other price validation", priority = 7)
	public void addAllproductsToCartAndCheckout() throws InterruptedException {
		login.getUserNameAndPasswordfieldsAndLogin(); // Add all products to cart and checkout and other price
														// validations
		login.clickOnLogin();
		product.addAllproductsToCartAndCheckCartIcon(ProductUi.addTocartButton, ProductUi.cartIconCount);
		product.checkoutTheCartAndCheckAndCheckinginputFieldsAReEditable(ProductUi.checkoutButton);
		product.verifyingTotalPrice(ProductUi.tax, ProductUi.totalAmount, ProductUi.sumOfProducts);

		// validate thankyou message
		product.validateThankYouMessage(ProductUi.finishButton, ProductUi.thankyouMessage);

		// logout after order placed
		product.logoutFromSwagLabs(ProductUi.burgerMenuIcon, ProductUi.logoutButton);
		// validating login page is dispalyed ?
		login.verifyLoginPage(LoginUi.loginButton);
	}
//	@AfterMethod
//	public void closinBrowser() {
//		Object reuse;
//		ReusebleMethods.driver.quit();
//	}

}
