package com.orangeHRMPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIM_Page extends Base_Page
{
    public PIM_Page()
    {
        super();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//a[text()='Add Employee']")
    WebElement addEmp;
    @FindBy(xpath="//a[text()='Employee List']")
    WebElement empList;
    @FindBy(xpath="//a[text()='Reports']")
    WebElement report;
    public void navigateToAddEmployee()
    {
        clickButton(addEmp);
    }
    public void navigateToEmployeeList()
    {
        clickButton(empList);
    }
    public void navigateToReport()
    {
        clickButton(report);
    }
}