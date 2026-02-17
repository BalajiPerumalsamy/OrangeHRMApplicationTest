package com.positiveTests;

import com.Listeners.MyListener;
import com.orangeHRMPages.Base_Page;
import com.orangeHRMPages.ForgotPassword_Page;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyListener.class)
public class ForgotPasswordPageTest
{
    Base_Page basePage;
    ForgotPassword_Page forgotPasswordPage;

    @BeforeMethod
    public void setUp()
    {
        basePage=new Base_Page();
        basePage.navigateToApplication();
        forgotPasswordPage=new ForgotPassword_Page();
    }

    @Test
    public void verifyForgotPassword()
    {
        forgotPasswordPage.passwordReset(basePage.properties.getProperty("userName"));
        Assert.assertEquals(forgotPasswordPage.actualOutput(),forgotPasswordPage.expectedOutput(),"Couldn't Reset password");
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