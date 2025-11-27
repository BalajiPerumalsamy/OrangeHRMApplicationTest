package com.orangeHRMTests;

import com.orangeHRMPages.*;
import com.utils.ExcelUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddEmployeePageTest
{
    public Base_Page basePage;
    public Login_Page loginPage;
    public Dashboard_Page dashboardPage;
    public PIM_Page pimPage;
    public AddEmployee_page addEmployeePage;

    @BeforeMethod
    public void setUp()
    {
        basePage=new Base_Page();
        basePage.navigateToApplication();
        loginPage=new Login_Page();
        dashboardPage=new Dashboard_Page();
        pimPage=new PIM_Page();
        addEmployeePage=new AddEmployee_page();
        loginPage.login();
        dashboardPage.navigateToPIM();
        pimPage.navigateToAddEmployee();
    }
    @DataProvider(name="excelData")
    public Object[][] getEmployeeData()
    {
        String filePath="C://Users//ELCOT//Desktop//Test case//InputData.xlsx";
        return ExcelUtils.getExcelData(filePath, "Sheet1");
    }

    @Test(dataProvider="excelData")
    public void verifyAddEmployee(String firstName, String lastName)
    {
        addEmployeePage.AddEmployee(firstName,lastName);
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
