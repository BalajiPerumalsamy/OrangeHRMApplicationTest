package com.orangeHRMTests;

import com.Listeners.MyListener;
import com.orangeHRMPages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Properties;

@Listeners(MyListener.class)
public class DeleteEmployeePageTest
{
    Base_Page basePage;
    Login_Page loginPage;
    Dashboard_Page dashboardPage;
    PIM_Page pimPage;
    AddEmployee_Page addEmployeePage;
    EmployeeList_Page employeeListPage;
    DeleteEmployee_Page deleteEmployeePage;
    public Properties properties;

    @BeforeMethod
    public void setUp()
    {
        basePage=new Base_Page();
        basePage.navigateToApplication();
        loginPage=new Login_Page();
        properties=new Properties();
        loginPage.login(basePage.properties.getProperty("userName"),basePage.properties.getProperty("password"));
        dashboardPage=new Dashboard_Page();
        dashboardPage.navigateToPIM();
        pimPage=new PIM_Page();
        pimPage.navigateToEmployeeList();
        employeeListPage=new EmployeeList_Page();
        deleteEmployeePage=new DeleteEmployee_Page();
        employeeListPage.clickSearchButton(basePage.properties.getProperty("empName"),basePage.properties.getProperty("empID"));
        Assert.assertEquals(deleteEmployeePage.actualOutputRecord(),deleteEmployeePage.expectedOutputRecord(),"No employee record found");
    }

    @Test
    public void verifyDeleteEmployee()
    {
        deleteEmployeePage.delete();
        Assert.assertEquals(deleteEmployeePage.actualOutput(),deleteEmployeePage.expectedOutput(),"Couldn't Delete user data");
    }

    @AfterMethod(alwaysRun=true)
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