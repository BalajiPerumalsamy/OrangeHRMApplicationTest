package com.Listeners;

import com.aventstack.extentreports.*;
import com.orangeHRMPages.Base_Page;
import com.reports.ReportManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener
{
    ExtentReports extent=ReportManager.getReport();
    ExtentTest test;
    Base_Page basePage;

    public void onStart(ITestContext context)
    {
        System.out.println("Test Suite Started : " + context.getName());
        System.out.println("Test Suite Started time : "+context.getStartDate());
    }

    public void onTestStart(ITestResult result)
    {
        test=extent.createTest(result.getName());
        test.log(Status.INFO,"Test Started");
    }

    public void onTestSuccess(ITestResult result)
    {
        test.log(Status.PASS,"Test Passed");
    }

    public void onTestFailure(ITestResult result)
    {
        String testName=result.getName();
        test.log(Status.FAIL,"Test Failed");
        basePage=new Base_Page();
        String path=basePage.captureScreenshot(testName);
        test.fail(result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromPath(path).build());
    }

    public void onTestSkipped(ITestResult result)
    {
        test.log(Status.SKIP,"Test Skipped");
        if(result.getThrowable()!=null)
        {
            test.skip("Skip Reason : "+result.getThrowable().getMessage());
        }
        basePage=new Base_Page();
        String path=basePage.captureScreenshot(result.getName());
        test.skip(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
    }

    public void onFinish(ITestContext context)
    {
        System.out.println("Total Passed Tests : " + context.getPassedTests().size());
        System.out.println("Total Failed Tests : " + context.getFailedTests().size());
        System.out.println("Total Skipped Tests : " + context.getSkippedTests().size());
        System.out.println("Test Suite End Time : " + context.getEndDate());
        extent.flush();
    }
}