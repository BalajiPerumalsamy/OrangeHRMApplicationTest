package com.positiveTests;

import com.Listeners.MyListener;
import com.orangeHRMPages.Base_Page;
import com.orangeHRMPages.Dashboard_Page;
import com.orangeHRMPages.Login_Page;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(MyListener.class)
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
        loginPage.login(basePage.properties.getProperty("userName"),basePage.properties.getProperty("password"));
        dashboardPage=new Dashboard_Page();
    }

    @Test
    public void verifyPIMPage()
    {
        dashboardPage.navigateToPIM();
        Assert.assertEquals(dashboardPage.actualOutput(),dashboardPage.ExpectedOutput(),"Couldn't navigate to PIM page");
    }

    @Test
    public void navigateToBuzzPage()
    {
        dashboardPage.navigateToBuzz();
        Assert.assertTrue(dashboardPage.verifyBuzz.isDisplayed(),"Couldn't navigate to Buzz Page");
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