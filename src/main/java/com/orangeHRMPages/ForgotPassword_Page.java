package com.orangeHRMPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class ForgotPassword_Page extends Base_Page
{
    public ForgotPassword_Page()
    {
        super();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//p[text()='Forgot your password? ']")
    WebElement forgotPassword;
    @FindBy(xpath="//input[@name='username']")
    WebElement userName;
    @FindBy(xpath="//button[@type='submit']")
    WebElement submit;

    public void passwordReset()
    {
        clickButton(forgotPassword);
        writeText(properties.getProperty("userName"),userName);
        clickButton(submit);
    }
}
