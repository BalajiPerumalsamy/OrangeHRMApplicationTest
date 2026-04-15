package com.positiveTests;

import com.BassPage.BaseClass;
import com.Listeners.MyListener;
import com.orangeHRMPages.ForgotPassword_Page;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyListener.class)
public class ForgotPasswordPageTest
{
    public BaseClass basePage;
    public ForgotPassword_Page forgotPasswordPage;

    @BeforeMethod
    public void setUp()
    {
        basePage=new BaseClass();
        basePage.navigateToApplication();
        forgotPasswordPage=new ForgotPassword_Page();
    }

    @Test
    public void verifyForgotPassword()
    {
        forgotPasswordPage.passwordReset(basePage.properties.getProperty("userName"));
        Assert.assertEquals(forgotPasswordPage.actualOutput(),forgotPasswordPage.expectedOutput(),
                "Couldn't Reset password");
    }

    @AfterMethod
    public void tearDown()
    {
        basePage.quitApplication();
    }
}