package com.orangeHRMPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Reports_Page extends Base_Page
{
    public Reports_Page()
    {
        super();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//input[@placeholder='Type for hints...']")
    WebElement report;
    @FindBy(xpath="//button[@type='submit']")
    WebElement search;
    public void employeeReport()
    {
        writeText(properties.getProperty("reportName"),report);
        clickButton(search);
    }
}
