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
        pimPage.navigateToEmployeeList();
    }
    @Test
    public void verifyEmployeeList()
    {
        employeeList.clickSearchButton();
    }
    @AfterMethod
    public void tearDown()
    {
        try
        {
            Assert.assertEquals(pimPage.actualEmployeeList(),pimPage.expectedEmployeeList(),"Actual and Expected Output is mismatch");
            Thread.sleep(15000);
            basePage.quit();
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }
}
