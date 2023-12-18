package com.caw.reusableMethods;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.caw.stepdef.Hooks;


import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Reuseblemethods {

	private JavascriptExecutor executor = (JavascriptExecutor) Hooks.driver;
	public static ExtentReports extentReport;
	public static ExtentHtmlReporter htmlReport;
	public static String extentReportFilePath;

	public void waitAndClick(WebElement element) {
		boolean clicked = false;

		int attemps = 0;
		while (!clicked && attemps <= 10) {
			try {
				element.isDisplayed();
				element.isDisplayed();
				element.click();
				System.out.println("=========Clicked on given locator=========");
				clicked = true;
			} catch (Exception e) {
				System.out.println("=======unable to wait and click on given locator============");
			}
			attemps++;
		}
	}

	public static WebDriver getDriver(String string) {
		WebDriver driver;
		if (string.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
		} else if (string.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
		} else if (string.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		} else
			driver = null;
		return driver;

	}

	public static ExtentReports startReport() {
		SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
//		System.getProperty("user.dir") + screenshot + "/Screenshot" + dateFormat.format(new java.util.Date())
//		+ ".png";
		htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir")+ extentReportFilePath +
				  "report "+date.format(new java.util.Date()) + "ExtentReport.html");
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReport);
		return extentReport;

	}

	 

	public static void applyWeight(Duration time, WebDriver driver) throws Exception {

		driver.manage().timeouts().implicitlyWait(time);
	}

	public void sendData(WebElement searchBox, String data) {

		try {
			String value = searchBox.getAttribute("value");
			System.out.println("enteredvale is" + value);
			searchBox.sendKeys(data);
			System.out.println("============data send sccesfully============");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void actionMoveAndClick(WebElement element) {
		Actions ac = new Actions(Hooks.driver);

		try {
			element.isEnabled();
			ac.moveToElement(element).click().build().perform();
			System.out.println("=====clicked sccessflly by action move and click======");
		} catch (StaleElementReferenceException e) {
			WebElement elementClick = element;
			Boolean elementPresent = elementClick.isEnabled();
			if (elementPresent == true) {
				ac.moveToElement(elementClick).click().build().perform();
				System.out.println("=====staleException & moved and clicked sccessfully by action=====");
			}
		} catch (Exception e) {
			System.out.println("===== unable to click======");
			Assert.fail("unable to click on element " + e.getMessage());

		}
	}

	public void SelectValueFromDropDown(WebElement element, int selector) {

		try {
			Select dropdown = new Select(element);
			dropdown.selectByIndex(selector);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	  
	public void isDisplayed(WebElement logOutIcon) {
		logOutIcon.isDisplayed();

	}

	public void waitForpageToload() {
		String pageLoadStatus = null;
		try {
			do {
				pageLoadStatus = (String) executor.executeScript("return document.readyState");

			} while (!pageLoadStatus.equals("complete"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void creatingExtentReport(ExtentTest extentTest, WebDriver driver, String screenshotPath,
			String failedScreenshotPath, Scenario scenario) throws Exception {
		String file = Reuseblemethods.takeScreenshot(driver, screenshotPath);
		extentTest.addScreenCaptureFromPath(file);
		if (scenario.isFailed()) {
			String failedOnes = Reuseblemethods.takeScreenshot(driver, failedScreenshotPath);
		}
	}

	public static String takeScreenshot(WebDriver driver, String screenshot) {
		String path = "";
		try {
			TakesScreenshot snapshot = (TakesScreenshot) driver;
			File file = snapshot.getScreenshotAs(OutputType.FILE);
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
			path = System.getProperty("user.dir") + screenshot + "/Screenshot" + dateFormat.format(new java.util.Date())
					+ ".png";
			File pathvar = new File(path);
			FileUtils.copyFile(file, pathvar);
		} catch (WebDriverException e) {
			System.err.println("failing here" + e.getMessage());
		} catch (IOException e) {
			System.err.println("failing here" + e.getMessage());
		}
		return path;

	}
	public static void ReadProperties() throws Exception {
		FileReader read = new FileReader(
				System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\config.properties");
		Properties properties = new Properties();
		properties.load(read);

		 Hooks.URL = properties.getProperty("URL");
		 Hooks.browserSelection  = properties.getProperty("browserSelection");
		Hooks.screenshotPath = properties.getProperty("screenShotpath");
		Hooks.failedScreenshotPath = properties.getProperty("failedscreenshotpath");
		extentReportFilePath=properties.getProperty("extentReportFilePath");
		 

	}

}
