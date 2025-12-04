package com.orangeHRMPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeList_Page extends Base_Page
{
    public EmployeeList_Page()
    {
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//input[@placeholder='Type for hints...']")
    WebElement empName;

    @FindBy(xpath="/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input")
    WebElement empID;

    @FindBy(xpath="//button[@type='submit']")
    WebElement search;

    @FindBy(xpath="//span[contains(normalize-space(),'Record Found')]")
    WebElement recordFound;

    public void clickSearchButton()
    {
        writeText(properties.getProperty("empName"),empName);
        writeText(properties.getProperty("empID"),empID);
        clickButton(search);
    }

    public String actualOutput()
    {
        return recordFound.getText();
    }

    public String expectedOutput()
    {
        return "(1) Record Found";
    }
}