package com.automationjiraproject2.step_definitions;

import com.automationjiraproject2.pages.RegisterPage;
import com.automationjiraproject2.utilities.BrowserUtils;
import com.automationjiraproject2.utilities.ConfigurationReader;
import com.automationjiraproject2.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.*;

public class RegisterStepDefinitions {

    RegisterPage registerPage = new RegisterPage();

    @Given("user navigate to homepage")
    public void user_navigate_to_homepage() {
        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("url"));
    }
    @Then("verify that homepage is visible successfully")
    public void verify_that_homepage_is_visible_successfully() {
        String expectedUrl = "https://automationexercise.com";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        assertTrue(actualUrl.contains(expectedUrl));

    }
    @When("user clicks on signup\\/login button")
    public void user_clicks_on_signup_login_button() {
        BrowserUtils.sleep(2);
        registerPage.signinLoginButton.click();
    }
    @Then("verify {string} is visible")
    public void verify_is_visible(String string) {
        BrowserUtils.sleep(2);
        assertTrue(registerPage.newUserSignupMessage.isDisplayed());
        System.out.println("registerPage.newUserSignupMessage.getText() = " + registerPage.newUserSignupMessage.getText());
    }


}
