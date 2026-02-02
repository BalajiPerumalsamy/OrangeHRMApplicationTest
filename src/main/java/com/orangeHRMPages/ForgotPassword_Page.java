package com.orangeHRMPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


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

    @FindBy(xpath="//h6[contains(@class,'orangehrm-forgot-password-title')]")
    //@FindBy(xpath="//h6[text()='Reset Password link sent successfully']")
    WebElement verifyResetPassword;

    public void passwordReset(String name)
    {
        clickButton(wait.until(ExpectedConditions.elementToBeClickable(forgotPassword)));
        writeText(name,userName);
        clickButton(wait.until(ExpectedConditions.elementToBeClickable(submit)));
    }

    public String actualOutput()
    {
        return wait.until(ExpectedConditions.visibilityOf(verifyResetPassword)).getText();
    }

    public String expectedOutput()
    {
        return "Reset Password link sent successfully";
    }
}
