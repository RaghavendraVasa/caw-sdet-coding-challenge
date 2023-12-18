package com.caw.stepdef;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.caw.reusableMethods.Reuseblemethods;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;

public class Hooks {
	public static WebDriver driver;
	public static Reuseblemethods reuse = new Reuseblemethods();
	public static ExtentTest extentTest;
	public static ExtentReports report;
	public static String screenshotPath;
	public static String failedScreenshotPath;
	public static String URL;
	public static String browserSelection;

	@Given("user is successfully naviaged to {string}")
	public void user_is_successfully_naviaged_to(String string) {
		extentTest = report.createTest("selected browser and opening application");
		driver.get(string);
		report.flush();
	}

	@SuppressWarnings("static-access")
	@Before(value = "@seacrchfunctionality", order = 1)
	public void Searchproduct() throws Exception {
		reuse.ReadProperties();
		driver = reuse.getDriver(browserSelection);

		System.out.println("================>selected browser =" + browserSelection);
		report = reuse.startReport();
	}

	@Before(value = "@loginAmazon", order = 2)
	public void loginToAmazon() throws Exception {
		reuse.ReadProperties();
		driver = reuse.getDriver(browserSelection);

		System.out.println("================>selected browser =" + browserSelection);
	}

	@AfterStep
	public void Teardown(Scenario scenario) throws Exception {
		reuse.creatingExtentReport(extentTest, driver, screenshotPath ,failedScreenshotPath, scenario);
		report.flush();
	}
}
