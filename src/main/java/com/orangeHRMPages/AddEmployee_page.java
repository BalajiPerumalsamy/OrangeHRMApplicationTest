package com.orangeHRMPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddEmployee_page extends Base_Page
{
    public AddEmployee_page()
    {
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//input[@name='firstName']")
    WebElement firstname;

    @FindBy(xpath="//input[@name='lastName']")
    WebElement lastname;

    @FindBy(xpath="//button[@type='submit']")
    WebElement saveButton;

    @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/input")
    WebElement licenceNumber;

    @FindBy(xpath="//input[@placeholder='yyyy-dd-mm']")
    WebElement licenceExpiryDate;

    @FindBy(xpath="//label[text()='Nationality']/../following-sibling::div//i")
    WebElement countryDropdown;

    @FindBy(xpath="//div[@role='listbox']//span[contains(text(),'Indian')]")
    WebElement selectCountry;

    @FindBy(xpath="//label[text()='Marital Status']/../following-sibling::div//i")
    WebElement maritalStatusDropdown;

    @FindBy(xpath="//div[@role='listbox']//span[contains(text(),'Single')]")
    WebElement selectMaritalStatus;

    @FindBy(xpath="//label[text()='Date of Birth']/../following-sibling::div//input")
    WebElement dateOfBirth;

    @FindBy(xpath="//label[text()='Male']/span")
    WebElement gender;

    @FindBy(xpath="//p[contains(text(),'Successfully Updated')]")
    WebElement message;

    public void AddEmployee(String firstName, String lastName,String licenceNum,String licenceExpDate,String dofBirth)
    {
        writeText(firstName,firstname);
        writeText(lastName,lastname);
        clickButton(saveButton);

        writeText(licenceNum,licenceNumber);
        writeText(licenceExpDate,licenceExpiryDate);

        clickButton(countryDropdown);
        wait.until(ExpectedConditions.visibilityOf(selectCountry));
        clickButton(selectCountry);

        clickButton(maritalStatusDropdown);
        wait.until(ExpectedConditions.visibilityOf(selectMaritalStatus));
        clickButton(selectMaritalStatus);

        writeText(dofBirth,dateOfBirth);
        clickButton(gender);
        clickButton(saveButton);
        wait.until(ExpectedConditions.visibilityOf(message));
        System.out.println("Message = "+message.getText());
    }
}
