package com.orangeHRMTests;

import com.orangeHRMPages.Base_Page;
import com.orangeHRMPages.Login_Page;
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
        loginPage=new Login_Page();
    }
    @Test
    public void verifyLogin()
    {
        loginPage.login();
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