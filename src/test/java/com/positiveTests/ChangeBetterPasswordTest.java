package com.positiveTests;

import com.Listeners.MyListener;
import com.orangeHRMPages.Base_Page;
import com.orangeHRMPages.ChangePassword_Page;
import com.orangeHRMPages.Login_Page;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Properties;

@Listeners(MyListener.class)
public class ChangeBetterPasswordTest
{
    public Base_Page basePage;
    public Login_Page loginPage;
    public Properties properties;
    public ChangePassword_Page passwordPage;

    @BeforeMethod
    public void setup()
    {
        basePage=new Base_Page();
        basePage.navigateToApplication();
        loginPage=new Login_Page();
        loginPage.login(basePage.properties.getProperty("userName"),basePage.properties.getProperty("password"));
        Assert.assertEquals(loginPage.actualOutput(),loginPage.expectedOutput(),"Couldn't navigate to Dashboard page");
    }

    @Test
    public void verifyWeakPasswordChange()
    {
        passwordPage=new ChangePassword_Page();
        passwordPage.passwordChange(basePage.properties.getProperty("currentPassword"),basePage.properties.getProperty("betterNewPassword"),basePage.properties.getProperty("betterConfirmPassword"));
        Assert.assertTrue(passwordPage.betterPassword.isDisplayed(),"Better is not visible");
    }

    @AfterMethod
    public void tearDown()
    {
        try
        {
            Thread.sleep(10000);
            basePage.quit();
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }
}
