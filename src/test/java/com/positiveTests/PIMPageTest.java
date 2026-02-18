package com.positiveTests;

import com.Listeners.MyListener;
import com.orangeHRMPages.Base_Page;
import com.orangeHRMPages.Dashboard_Page;
import com.orangeHRMPages.Login_Page;
import com.orangeHRMPages.PIM_Page;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Properties;

@Listeners(MyListener.class)
public class PIMPageTest
{
    public Base_Page basePage;
    public Login_Page loginPage;
    public Dashboard_Page dashboardPage;
    public PIM_Page pimPage;
    public Properties properties;

    @BeforeMethod
    public void setUp()
    {
        basePage=new Base_Page();
        basePage.navigateToApplication();
        loginPage=new Login_Page();
        dashboardPage=new Dashboard_Page();
        pimPage=new PIM_Page();
        loginPage.login(basePage.properties.getProperty("userName"),basePage.properties.getProperty("password"));
        dashboardPage.navigateToPIM();
    }

    @Test(priority=1)
    public void verifyAddEmployeeNavigate()
    {
        pimPage.navigateToAddEmployee();
        Assert.assertEquals(pimPage.actualAddEmployee(),pimPage.expectedAddEmployee(),"Couldn't Navigate to Add Employee Page");
    }

    @Test(priority=2)
    public void verifyEmployeeListNavigate()
    {
        pimPage.navigateToEmployeeList();
        Assert.assertEquals(pimPage.actualEmployeeList(),pimPage.expectedEmployeeList(),"Couldn't Navigate to Employee List Page");
    }

    @Test(priority=3)
    public void verifyReportNavigate()
    {
        pimPage.navigateToReport();
        Assert.assertEquals(pimPage.actualEmployeeReport(),pimPage.expectedEmployeeReport(),"Couldn't Navigate to Employee Reports Page");
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
