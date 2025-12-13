package com.orangeHRMTests;

import com.orangeHRMPages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteEmployeePageTest
{
    Base_Page basePage;
    Login_Page loginPage;
    Dashboard_Page dashboardPage;
    PIM_Page pimPage;
    AddEmployee_Page addEmployeePage;
    EmployeeList_Page employeeListPage;
    DeleteEmployee_Page deleteEmployeePage;

    @BeforeMethod
    public void setUp()
    {
        basePage=new Base_Page();
        basePage.navigateToApplication();
        loginPage=new Login_Page();
        loginPage.login();
        dashboardPage=new Dashboard_Page();
        dashboardPage.navigateToPIM();
        pimPage=new PIM_Page();
        pimPage.navigateToEmployeeList();
        employeeListPage=new EmployeeList_Page();
        deleteEmployeePage=new DeleteEmployee_Page();
        try
        {
            employeeListPage.clickSearchButton();
            Assert.assertEquals(deleteEmployeePage.actualOutputRecord(),deleteEmployeePage.expectedOutputRecord(),"No employee record found");
        }
        catch(AssertionError e)
        {
            System.out.println("Error acquired Delete employee Page not move forward");
            basePage.captureScreenshot("EmployeeNoRecord");
        }
    }
    @Test
    public void verifyDelete()
    {
        try
        {
            deleteEmployeePage.delete();
            Assert.assertEquals(deleteEmployeePage.actualOutput(),deleteEmployeePage.expectedOutput(),"Couldn't Delete user data");
        }
        catch(AssertionError e)
        {
            System.out.println("Error acquired Page not move forward");
            basePage.captureScreenshot("DeletePage");
        }
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