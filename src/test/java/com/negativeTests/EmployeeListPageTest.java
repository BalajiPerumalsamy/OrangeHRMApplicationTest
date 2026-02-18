package com.negativeTests;

import com.Listeners.MyListener;
import com.orangeHRMPages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Properties;

@Listeners(MyListener.class)
public class EmployeeListPageTest
{
    public Base_Page basePage;
    public Login_Page loginPage;
    public Dashboard_Page dashboardPage;
    public PIM_Page pimPage;
    public EmployeeList_Page employeeList;
    public Properties properties;

    @BeforeMethod
    public void setUp()
    {
        basePage=new Base_Page();
        basePage.navigateToApplication();
        loginPage=new Login_Page();
        dashboardPage=new Dashboard_Page();
        pimPage=new PIM_Page();
        employeeList=new EmployeeList_Page();
        loginPage.login(basePage.properties.getProperty("userName"),basePage.properties.getProperty("password"));
        dashboardPage.navigateToPIM();
        pimPage.navigateToEmployeeList();
        Assert.assertEquals(pimPage.actualEmployeeList(),pimPage.expectedEmployeeList(),"Couldn't navigate to Employee list page");
    }

    @Test
    public void verifySearchEmployee()
    {
        employeeList.clickSearchButton(basePage.properties.getProperty("invalidEmpName"),basePage.properties.getProperty("invalidEmpID"));
        Assert.assertEquals(employeeList.invalidActualOutput(),employeeList.invalidExpectedOutput(),"No employee record found");
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