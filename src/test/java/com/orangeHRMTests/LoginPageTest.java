package com.orangeHRMTests;

import com.orangeHRMPages.Base_Page;
import com.orangeHRMPages.Login_Page;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest
{
    public Base_Page basePage;
    public Login_Page loginPage;
    @BeforeMethod
    public void setUp()
    {
        basePage=new Base_Page();
        basePage.navigateToApplication();
    }
    @Test
    public void verifyLogin()
    {
        try
        {
            loginPage=new Login_Page();
            loginPage.login();
            Assert.assertEquals(loginPage.actualOutput(),loginPage.expectedOutput(),"Couldn't navigate to Dashboard page");
        }
        catch(AssertionError e)
        {
            System.out.println("Error acquired Login Page not move forward");
            basePage.captureScreenshot("LoginPage");
        }
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