package com.orangeHRMTests;

import com.orangeHRMPages.Base_Page;
import com.orangeHRMPages.Dashboard_Page;
import com.orangeHRMPages.Login_Page;
import com.orangeHRMPages.PIM_Page;
import org.testng.Assert;
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
    @Test(priority=1)
    public void verifyAddEmployee()
    {
        try
        {
            pimPage.navigateToAddEmployee();
            Assert.assertEquals(pimPage.actualAddEmployee(),pimPage.expectedAddEmployee(),"Couldn't Navigate to Add Employee Page");
        }
        catch(AssertionError e)
        {
            System.out.println("Error acquired PIM Page not move forward");
            basePage.captureScreenshot("AddEmployeePade1");
        }
    }
    @Test(priority=2)
    public void verifyEmployeeList()
    {
        try
        {
            pimPage.navigateToEmployeeList();
            Assert.assertEquals(pimPage.actualEmployeeList(),pimPage.expectedEmployeeList(),"Couldn't Navigate to Employee List Page");
        }
        catch(AssertionError e)
        {
            System.out.println("Error acquired PIM Page not move forward");
            basePage.captureScreenshot("EmployeeListPage1");
        }
    }
    @Test(priority=3)
    public void verifyReport()
    {
        try
        {
            pimPage.navigateToReport();
            Assert.assertEquals(pimPage.actualEmployeeReport(),pimPage.expectedEmployeeReport(),"Couldn't Navigate to Employee Reports Page");
        }
        catch(AssertionError e)
        {
            System.out.println("Error acquired PIM Page not move forward");
            basePage.captureScreenshot("ReportPage");
        }

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