package com.orangeHRMPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChangePassword_Page extends Base_Page
{
    public ChangePassword_Page()
    {
        super();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
    WebElement dropdownButton;

    @FindBy(xpath="//a[text()='Change Password']")
    WebElement passwordChange;

    @FindBy(xpath="//input[@type='password']")
    WebElement currentPassword;

    @FindBy(xpath=" //*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")
    WebElement newPassword;

    @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")
    WebElement confirmPassword;

    @FindBy(xpath="//button[text()=' Save ']")
    WebElement clickSaveButton;

    @FindBy(xpath="//p[contains(@class,'oxd-text--toast-message')]")
    WebElement incorrectCurrentPassword;

    @FindBy(xpath="//p[contains(@class,'oxd-text--toast-message')]")
    WebElement message;

    public void passwordChange(String oldPassword, String newPass, String confirmPass)
    {
        clickButton(dropdownButton);
        clickButton(passwordChange);
        writeText(oldPassword,currentPassword);
        writeText(newPass,newPassword);
        writeText(confirmPass,confirmPassword);
        clickButton(clickSaveButton);
    }

    public String actualOutput()
    {
        wait.until(ExpectedConditions.visibilityOf(message));
        System.out.println("Actual Output = "+message.getText());
        return message.getText();
    }

    public String expectedOutput()
    {
        return "Successfully Saved";
    }

    public String incorrectCurrentPasswordActualOutput()
    {
        return incorrectCurrentPassword.getText();
    }

    public String incorrectCurrentPasswordExpectedOutput()
    {
        return "Current Password is Incorrect";
    }

}
