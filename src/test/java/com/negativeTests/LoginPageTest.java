package com.negativeTests;

import com.BassPage.BaseClass;
import com.Listeners.MyListener;
import com.orangeHRMPages.Login_Page;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyListener.class)
public class LoginPageTest
{
    public BaseClass basePage;
    public Login_Page loginPage;

    @BeforeMethod
    public void setUp()
    {
        basePage=new BaseClass();
        basePage.navigateToApplication();
    }

    @Test
    public void loginFailed()
    {
        loginPage=new Login_Page();
        loginPage.login(basePage.properties.getProperty("invalidUserName"),basePage.properties.getProperty("pass"));
        Assert.assertEquals(loginPage.invalidActualOutput(),loginPage.invalidExpectedOutput(),"Navigate to Dashboard page");
    }

    @AfterMethod
    public void tearDown()
    {
        basePage.quitApplication();
    }
}