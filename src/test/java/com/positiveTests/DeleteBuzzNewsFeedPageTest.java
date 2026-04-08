package com.positiveTests;

import com.Listeners.MyListener;
import com.orangeHRMPages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyListener.class)
public class DeleteBuzzNewsFeedPageTest
{
    public Base_Page basePage;
    public Login_Page loginPage;
    public Dashboard_Page dashboardPage;
    public Buzz_Page buzzPage;
    public DeleteBuzzNewsFeedPage buzzNewsFeedPage;

    @BeforeMethod
    public void setUp()
    {
        basePage=new Base_Page();
        basePage.navigateToApplication();
        loginPage=new Login_Page();
        loginPage.login(basePage.properties.getProperty("userName"),basePage.properties.getProperty("password"));
        Assert.assertEquals(loginPage.actualOutput(),loginPage.expectedOutput(),
                "Couldn't navigate to Dashboard page");
        dashboardPage=new Dashboard_Page();
        dashboardPage.navigateToBuzz();
        buzzPage=new Buzz_Page();
        buzzPage.buzzNewsFeed(basePage.properties.getProperty("feed"));
        Assert.assertTrue(buzzPage.confirmationMessage.isDisplayed(),
                "couldn't show confirmation message");
    }

    @Test
    public void verifyBuzzDelete()
    {
        buzzNewsFeedPage=new DeleteBuzzNewsFeedPage();
        buzzNewsFeedPage.delete();
    }

    @AfterMethod
    public void tearDown()
    {
        basePage.quitApplication();
    }
}
