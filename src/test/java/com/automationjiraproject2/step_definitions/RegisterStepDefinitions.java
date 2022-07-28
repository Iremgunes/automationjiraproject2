package com.automationjiraproject2.step_definitions;

import com.automationjiraproject2.pages.RegisterPage;
import com.automationjiraproject2.utilities.BrowserUtils;
import com.automationjiraproject2.utilities.ConfigurationReader;
import com.automationjiraproject2.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

import static org.junit.Assert.*;

public class RegisterStepDefinitions {

    RegisterPage registerPage = new RegisterPage();
    Faker faker = new Faker();

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

    @When("user enter name and email address")
    public void user_enter_name_and_email_address() {
        BrowserUtils.sleep(1);
        registerPage.nameBox.sendKeys(faker.name().firstName());
        registerPage.emailAddressBox.sendKeys(faker.internet().emailAddress());

    }
    @When("user clicks on new signup button")
    public void user_clicks_on_new_signup_button() {
        registerPage.newSignupButton.click();

    }
    @Then("verify that {string} is visible")
    public void verify_that_is_visible(String string) {
        BrowserUtils.sleep(2);
        assertTrue(registerPage.enterAccountInformationMessage.isDisplayed());

    }

    @Then("fill details following information")
    public void fill_details_following_information( ) {
        registerPage.title.click();
        registerPage.passwordBox.sendKeys(faker.internet().password());

        Select select = new Select(registerPage.daysDropDown);
        select.selectByIndex(3);

        Select select1 = new Select(registerPage.monthsDropDown);
        select1.selectByValue("4");

        Select select2 = new Select(registerPage.yearsDropDown);
        select2.selectByValue("2021");



    }






}
