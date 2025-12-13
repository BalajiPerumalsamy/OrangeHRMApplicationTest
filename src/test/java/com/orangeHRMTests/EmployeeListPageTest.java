package com.orangeHRMTests;

import com.orangeHRMPages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmployeeListPageTest
{
    public Base_Page basePage;
    public Login_Page loginPage;
    public Dashboard_Page dashboardPage;
    public PIM_Page pimPage;
    public EmployeeList_Page employeeList;

    @BeforeMethod
    public void setUp()
    {
        basePage=new Base_Page();
        basePage.navigateToApplication();
        loginPage=new Login_Page();
        dashboardPage=new Dashboard_Page();
        pimPage=new PIM_Page();
        employeeList=new EmployeeList_Page();
        loginPage.login();
        dashboardPage.navigateToPIM();
        try
        {
            pimPage.navigateToEmployeeList();
            Assert.assertEquals(pimPage.actualEmployeeList(),pimPage.expectedEmployeeList(),"Couldn't navigate to Employee list page");
        }
        catch(AssertionError e)
        {
            System.out.println("Employee list page Error acquired so Page not move forward");
            basePage.captureScreenshot("EmployeeListPage");
        }
    }
    @Test
    public void verifyEmployeeList()
    {
        try
        {
            employeeList.clickSearchButton();
            Assert.assertEquals(employeeList.actualOutput(),employeeList.expectedOutput(),"No employee record found");
        }
        catch(AssertionError e)
        {
            System.out.println("Error acquired Employee list Page not move forward");
            basePage.captureScreenshot("SearchEmployeeList");
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
