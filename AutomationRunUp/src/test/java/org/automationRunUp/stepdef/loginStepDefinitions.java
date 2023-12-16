package org.automationRunUp.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

@Test
public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver",
            "C:\\Users\\Shashank Shekhar\\IdeaProjects\\AutomationRunUp\\chromedriver_win32\\chromedriver.exe");
    public class loginStepDefinitions {
        WebDriver driver = new ChromeDriver();

        @When("Navigate to Swag Labs Website and verify")
        public void Navigate_to_Swag_Labs_Website_and_verify() {
            driver.get("https://www.saucedemo.com/");
            String PageTittle = driver.getTitle();
            Assert.assertEquals("Swag Labs", PageTittle);
        }

        //    driver.get("https://www.saucedemo.com/");
        @Given("user should be logged in")
        public void user_should_be_logged_in() {

        }

        @Given("I have entered a valid username and password")
        public void i_have_entered_a_valid_username_and_password() {

        }

        @When("I click on the login button")
        public void i_click_on_the_login_button() {

        }

        @Then("I should be logged in successfully")
        public void i_should_be_logged_in_successfully() {

        }

        @Given("I have entered invalid {string} and {string}")
        public void i_have_entered_invalid_and(String string, String string2) {

        }

        @Then("I should see an error message indicating {string}")
        public void i_should_see_an_error_message_indicating(String string) {

        }
    }
}
