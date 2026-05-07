package com.orangeHRMPages;

import com.BassPage.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Buzz_Page extends BaseClass
{
    public Buzz_Page()
    {
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//textarea[@placeholder=\"What's on your mind?\"]")
    WebElement content;

    @FindBy(xpath="//button[@type='submit']")
    WebElement clickPost;

    @FindBy(xpath="//p[contains(@class,'oxd-text--toast-message')]")
    public WebElement confirmationMessage;

    public void buzzNewsFeed(String text)
    {
        writeText(text,content);
        clickButton(clickPost);
    }
}