package com.positiveTests;

import com.BassPage.BaseClass;
import com.Listeners.MyListener;
import com.orangeHRMPages.Buzz_Page;
import com.orangeHRMPages.Dashboard_Page;
import com.orangeHRMPages.Login_Page;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyListener.class)

public class BuzzPageTest
{
    public BaseClass basePage;
    public Login_Page loginPage;
    public Dashboard_Page dashboardPage;
    public Buzz_Page buzzPage;

    @BeforeMethod
    public void setUp()
    {
        basePage=new BaseClass();
        basePage.navigateToApplication();
        loginPage=new Login_Page();
        loginPage.login(basePage.properties.getProperty("userName"),basePage.properties.getProperty("password"));
        Assert.assertEquals(loginPage.actualOutput(),loginPage.expectedOutput(),
                "Couldn't navigate to Dashboard page");
        dashboardPage=new Dashboard_Page();
        dashboardPage.navigateToBuzz();
    }

    @Test
    public void verifyBuzzPage()
    {
        buzzPage=new Buzz_Page();
        buzzPage.buzzNewsFeed(basePage.properties.getProperty("feed"));
        Assert.assertTrue(buzzPage.confirmationMessage.isDisplayed(),"couldn't show confirmation message");
    }

    @AfterMethod
    public void tearDown()
    {
        basePage.quitApplication();
    }
}