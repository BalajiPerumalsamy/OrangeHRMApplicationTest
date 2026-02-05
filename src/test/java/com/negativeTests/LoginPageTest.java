package com.negativeTests;

import com.Listeners.MyListener;
import com.orangeHRMPages.Base_Page;
import com.orangeHRMPages.Login_Page;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Properties;

@Listeners(MyListener.class)
public class LoginPageTest
{
    public Base_Page basePage;
    public Login_Page loginPage;
    public Properties properties;

    @BeforeMethod
    public void setUp()
    {
        basePage=new Base_Page();
        basePage.navigateToApplication();
    }

    @Test
    public void loginFailed()
    {
        loginPage=new Login_Page();
        properties=new Properties();
        loginPage.login(basePage.properties.getProperty("invalidUserName"),basePage.properties.getProperty("pass"));
        Assert.assertEquals(loginPage.invalidActualOutput(),loginPage.invalidExpectedOutput(),"Navigate to Dashboard page");
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