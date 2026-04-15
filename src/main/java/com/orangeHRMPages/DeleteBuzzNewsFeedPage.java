package com.orangeHRMPages;

import com.BassPage.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteBuzzNewsFeedPage extends BaseClass
{
    public DeleteBuzzNewsFeedPage()
    {
        super();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//i[@class='oxd-icon bi-three-dots']")
    WebElement icon;

    @FindBy(xpath="//p[text()='Delete Post']")
    WebElement delete;

    @FindBy(xpath="//button[text()=' Yes, Delete ']")
    WebElement clickDeleteButton;

    @FindBy(xpath="//p[contains(@class,'oxd-text--toast-message')]")
    WebElement message;

    public void delete()
    {
        clickButton(icon);
        clickButton(delete);
        clickButton(clickDeleteButton);
        System.out.println("Confirmation message = "+message.getText());
    }

}
