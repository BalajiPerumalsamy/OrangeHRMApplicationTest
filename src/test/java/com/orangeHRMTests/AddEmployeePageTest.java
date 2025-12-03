package com.orangeHRMTests;

import com.orangeHRMPages.*;
import com.utils.ExcelUtils;
import org.testng.Assert;
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
    public void verifyAddEmployee(String firstName, String lastName,String licenceNum,String licenceExpDate,String dofBirth)
    {
        addEmployeePage.AddEmployee(firstName,lastName,licenceNum,licenceExpDate,dofBirth);
    }
    @AfterMethod
    public void tearDown()
    {
        try
        {
            Assert.assertEquals(pimPage.actualAddEmployee(),pimPage.expectedAddEmployee(),"Actual and Expected Output is mismatch");
            Assert.assertEquals(addEmployeePage.actualDataSaved(),addEmployeePage.expectedDataSaved(),"Actual and Expected Output is mismatch");
            Assert.assertEquals(addEmployeePage.actualDataUpdated(),addEmployeePage.expectedDataUpdated(),"Actual and Expected Output is mismatch");
            Thread.sleep(10000);
            basePage.quit();
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }
}
