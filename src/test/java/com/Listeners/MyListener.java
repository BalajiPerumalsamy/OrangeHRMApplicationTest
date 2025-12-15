package com.Listeners;

import com.aventstack.extentreports.*;
import com.orangeHRMPages.Base_Page;
import com.reports.ReportManager;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener
{
    ExtentReports extent=ReportManager.getReport();
    ExtentTest test;
    Base_Page basePage;

    @Override
    public void onTestStart(ITestResult result)
    {
        test=extent.createTest(result.getName());
        test.log(Status.INFO,"Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        test.log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        String testName=result.getName();
        test.log(Status.FAIL,"Test Failed");
        basePage=new Base_Page();
        String path=basePage.captureScreenshot(testName);
        test.fail(result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromPath(path).build());
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        test=extent.createTest(result.getName());
        test.skip("Test Skipped");
        if(result.getThrowable()!=null)
        {
            test.skip("Skip Reason: "+result.getThrowable().getMessage());
        }
        basePage=new Base_Page();
        String path=basePage.captureScreenshot(result.getName());
        test.skip(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
    }

    @Override
    public void onFinish(org.testng.ITestContext context)
    {
        extent.flush();
    }
}