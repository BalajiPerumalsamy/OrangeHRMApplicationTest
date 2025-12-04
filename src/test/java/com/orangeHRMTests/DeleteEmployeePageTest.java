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
        employeeListPage.clickSearchButton();
    }
    @Test
    public void verifyDelete()
    {
        deleteEmployeePage=new DeleteEmployee_Page();
        deleteEmployeePage.delete();
        Assert.assertEquals(deleteEmployeePage.actualOutput(),deleteEmployeePage.expectedOutput(),"Couldn't Delete user data");
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