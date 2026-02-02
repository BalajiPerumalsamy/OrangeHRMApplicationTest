package com.orangeHRMPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(xpath="//span[text()='No Records Found' or text()='(1) Record Found' ]")
    WebElement recordFound;

    public void clickSearchButton(String name,String id)
    {
        writeText(name,empName);
        writeText(id,empID);
        clickButton(search);
        Actions act=new Actions(driver);
        act.scrollByAmount(0,500).perform();
    }

    public String actualOutput()
    {
        return recordFound.getText();
    }

    public String expectedOutput()
    {
        return "(1) Record Found";
    }

    public String invalidActualOutput()
    {
        return recordFound.getText();
    }

    public String invalidExpectedOutput()
    {
        return "No Records Found";
    }
}