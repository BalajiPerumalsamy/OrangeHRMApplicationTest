package com.orangeHRMPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard_Page extends Base_Page
{
    public Dashboard_Page()
    {
        super();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//span[text()='PIM']")
    WebElement pim;
    public void navigateToPIM()
    {
        clickButton(pim);
    }
}