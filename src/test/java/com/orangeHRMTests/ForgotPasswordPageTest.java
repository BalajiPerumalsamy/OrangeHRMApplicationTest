package com.orangeHRMTests;

import com.orangeHRMPages.Base_Page;
import com.orangeHRMPages.ForgotPassword_Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        forgotPasswordPage.passwordReset();
    }
    @AfterMethod
    public void tearDown()
    {
        try
        {
            Thread.sleep(15000);
            basePage.quit();
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }
}
