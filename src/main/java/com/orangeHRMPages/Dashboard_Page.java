package com.orangeHRMPages;

import com.BassPage.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard_Page extends BaseClass
{
    public Dashboard_Page()
    {
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//span[text()='PIM']")
    WebElement pim;

    @FindBy(xpath="//span[text()='Buzz']")
    WebElement buzz;

    @FindBy(xpath="//h6[text()='PIM']")
    WebElement verifyPIM;

    @FindBy(xpath="//h6[text()='Buzz']")
    public WebElement verifyBuzz;

    public void navigateToPIM()
    {
        clickButton(pim);
    }

    public void navigateToBuzz()
    {
        clickButton(buzz);
    }

    public String actualOutput()
    {
        return verifyPIM.getText();
    }

    public String ExpectedOutput()
    {
        return "PIM";
    }
}