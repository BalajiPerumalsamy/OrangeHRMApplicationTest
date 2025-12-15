package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager
{
    public static ExtentReports extent;

    public static ExtentReports getReport() {
        ExtentSparkReporter reporter =
                new ExtentSparkReporter("ExtentReport.html");

        reporter.config().setReportName("Automation Test Report");
        reporter.config().setDocumentTitle("OrangeHRM Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        return extent;
    }
}
