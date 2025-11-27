/*
package com.orangeHRMPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteEmployee_Page extends Base_Page
{
    public DeleteEmployee_Page()
    {
        super();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[1]/div/div/label/span/i")
    WebElement selectEmployee;
    @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/div/button")
    WebElement deleteButton;
    public void delete()
    {
        clickButton(selectEmployee);
        clickButton(deleteButton);
    }
}
*/


package com.orangeHRMPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteEmployee_Page extends Base_Page
{
    public DeleteEmployee_Page()
    {
        super();
        PageFactory.initElements(driver,this);
    }

    // Select first employee checkbox
    @FindBy(xpath="//div[@class='oxd-table-card']//i")
    WebElement selectEmployee;

    // Delete button above the table
    @FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-horizontal-margin']")
    WebElement deleteButton;

    // Popup confirm
    @FindBy(xpath="//button[normalize-space()='Yes, Delete']")
    WebElement confirmDeleteButton;

    public void delete()
    {
        js.executeScript("arguments[0].scrollIntoView(true);", selectEmployee);

        clickButton(selectEmployee);
        clickButton(deleteButton);
        clickButton(confirmDeleteButton);
    }
}
