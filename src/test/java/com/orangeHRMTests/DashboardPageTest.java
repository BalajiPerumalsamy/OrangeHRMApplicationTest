package com.orangeHRMTests;

import com.orangeHRMPages.Base_Page;
import com.orangeHRMPages.Dashboard_Page;
import com.orangeHRMPages.Login_Page;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardPageTest
{
    public Base_Page basePage;
    public Login_Page loginPage;
    public Dashboard_Page dashboardPage;

    @BeforeMethod
    public void setUp()
    {
        basePage=new Base_Page();
        basePage.navigateToApplication();
        loginPage=new Login_Page();
        loginPage.login();
        dashboardPage=new Dashboard_Page();
    }
    @Test
    public void verifyPIM()
    {
        dashboardPage.navigateToPIM();
    }
    @AfterMethod
    public void tearDown()
    {
        try
        {
            Assert.assertEquals(dashboardPage.actualOutput(),dashboardPage.ExpectedOutput(),"Actual and  Expected output is mismatch");
            Thread.sleep(10000);
            basePage.quit();
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }
}
