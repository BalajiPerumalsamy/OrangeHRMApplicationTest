package com.orangeHRMTests;

import com.orangeHRMPages.Base_Page;
import com.orangeHRMPages.Dashboard_Page;
import com.orangeHRMPages.Login_Page;
import com.orangeHRMPages.PIM_Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PIMPageTest
{
    public Base_Page basePage;
    public Login_Page loginPage;
    public Dashboard_Page dashboardPage;
    public PIM_Page pimPage;

    @BeforeMethod
    public void setUp()
    {
        basePage=new Base_Page();
        basePage.navigateToApplication();
        loginPage=new Login_Page();
        dashboardPage=new Dashboard_Page();
        pimPage=new PIM_Page();
        loginPage.login();
        dashboardPage.navigateToPIM();
    }
    @Test
    public void verify()
    {
        pimPage.navigateToAddEmployee();
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