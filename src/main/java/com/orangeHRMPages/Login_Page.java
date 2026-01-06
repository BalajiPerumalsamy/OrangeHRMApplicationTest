package com.orangeHRMPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page extends Base_Page
{
    public Login_Page()
    {
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//input[@name='username']")
    WebElement userName;

    @FindBy(xpath="//input[@name='password']")
    WebElement password;

    @FindBy(xpath="//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath="//h6[text()='Dashboard']")
    WebElement verifyLoginFunction;

    @FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")
    WebElement invalidLoginFunction;

    public void login(String name,String pass)
    {
        writeText(name,userName);
        writeText(pass,password);
        clickButton(loginButton);
    }

    public String actualOutput()
    {
        return verifyLoginFunction.getText();
    }

    public String expectedOutput()
    {
        return "Dashboard";
    }

    public String invalidActualOutput()
    {
        return invalidLoginFunction.getText();
    }

    public String invalidExpectedOutput()
    {
        return "Invalid credentials";
    }

}