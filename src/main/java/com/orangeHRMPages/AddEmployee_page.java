package com.orangeHRMPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployee_page extends Base_Page
{
    public AddEmployee_page()
    {
        super();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//input[@name='firstName']")
    WebElement firstname;
    @FindBy(xpath="//input[@name='lastName']")
    WebElement lastname;
    @FindBy(xpath=" //button[@type='submit']")
    WebElement saveButton;
    public void AddEmployee(String firstName, String lastName)
    {
        writeText(firstName,firstname);
        writeText(lastName,lastname);
        clickButton(saveButton);
    }
}