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


}
