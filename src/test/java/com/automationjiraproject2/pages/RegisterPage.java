package com.automationjiraproject2.pages;

import com.automationjiraproject2.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    public RegisterPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//i[@class='fa fa-lock']")
    public WebElement signinLoginButton;

    @FindBy(xpath = "//h2[.='New User Signup!']")
    public WebElement newUserSignupMessage;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    public WebElement nameBox;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement emailAddressBox;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement newSignupButton;

    @FindBy(xpath = "//b[.='Enter Account Information']")
    public WebElement enterAccountInformationMessage;

    @FindBy(id = "id_gender1")
    public WebElement title;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(id = "days")
    public WebElement daysDropDown;

    @FindBy(id="months")
    public WebElement monthsDropDown;

    @FindBy(id="years")
    public WebElement yearsDropDown;

}
