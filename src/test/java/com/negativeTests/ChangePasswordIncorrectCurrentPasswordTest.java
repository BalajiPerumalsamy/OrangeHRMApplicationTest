package com.negativeTests;

import com.BassPage.BaseClass;
import com.Listeners.MyListener;
import com.orangeHRMPages.ChangePassword_Page;
import com.orangeHRMPages.Login_Page;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyListener.class)

public class ChangePasswordIncorrectCurrentPasswordTest
{
    public BaseClass basePage;
    public Login_Page loginPage;
    public ChangePassword_Page passwordPage;

    @BeforeMethod
    public void setup()
    {
        basePage=new BaseClass();
        basePage.navigateToApplication();
        loginPage=new Login_Page();
        loginPage.login(basePage.properties.getProperty("userName"),basePage.properties.getProperty("password"));
        Assert.assertEquals(loginPage.actualOutput(),
                loginPage.expectedOutput(),"Couldn't navigate to Dashboard page");

    }

    @Test
    public void verifyChangePassword()
    {
        passwordPage=new ChangePassword_Page();
        passwordPage.passwordChange(basePage.properties.getProperty("incorrectCurrentPassword"),
                basePage.properties.getProperty("newPassword"),basePage.properties.getProperty("confirmPassword"));
        Assert.assertEquals(passwordPage.incorrectCurrentPasswordActualOutput(),
                passwordPage.incorrectCurrentPasswordExpectedOutput(),"Password update Successful");
    }

    @AfterMethod
    public void tearDown()
    {
        basePage.quitApplication();
    }
}
