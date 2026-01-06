package com.orangeHRMTests;

import com.Listeners.MyListener;
import com.orangeHRMPages.*;
import com.utils.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Properties;

@Listeners(MyListener.class)
public class AddEmployeePageTest
 {
    public Base_Page basePage;
    public Login_Page loginPage;
    public Dashboard_Page dashboardPage;
    public PIM_Page pimPage;
    public AddEmployee_Page addEmployeePage;
    public Properties properties;

    @BeforeMethod
    public void setUp()
    {
        basePage=new Base_Page();
        basePage.navigateToApplication();
        loginPage=new Login_Page();
        dashboardPage=new Dashboard_Page();
        pimPage=new PIM_Page();
        addEmployeePage=new AddEmployee_Page();
        properties=new Properties();
        loginPage.login(basePage.properties.getProperty("userName"),basePage.properties.getProperty("password"));
        dashboardPage.navigateToPIM();
        pimPage.navigateToAddEmployee();
        Assert.assertEquals(pimPage.actualAddEmployee(),pimPage.expectedAddEmployee(),"Couldn't navigate to Add Employee page");
    }

    @DataProvider(name="excelData")
    public Object[][] getEmployeeData()
    {
        String filePath="C://Users//ELCOT//Desktop//Test case//InputData.xlsx";
        return ExcelUtils.getExcelData(filePath, "Sheet1");
    }

    @Test(dataProvider="excelData")
    public void verifyAddEmployeeData(String firstName, String lastName,String licenceNum,String licenceExpDate,String dofBirth)
    {
        addEmployeePage.AddEmployee(firstName,lastName,licenceNum,licenceExpDate,dofBirth);
        Assert.assertEquals(addEmployeePage.actualDataSaved(), addEmployeePage.expectedDataSaved(),"Couldn't save user data");
        Assert.assertEquals(addEmployeePage.actualDataUpdated(), addEmployeePage.expectedDataUpdated(),"Couldn't update user data");
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