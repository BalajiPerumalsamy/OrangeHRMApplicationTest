package com.orangeHRMPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v125.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout_Page extends Base_Page
{
    public Logout_Page()
    {
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
    WebElement dropdownButton;

    @FindBy(xpath="//a[text()='Logout']")
    WebElement logout;

    @FindBy(xpath="//h5[text()='Login']")
    WebElement verifyLogOutFunction;

    public void logout()
    {
        clickButton(dropdownButton);
        clickButton(logout);
    }

    public String actualOutput()
    {
        return verifyLogOutFunction.getText();
    }
    public String expectedOutput()
    {
        return "Login";
    }


}
