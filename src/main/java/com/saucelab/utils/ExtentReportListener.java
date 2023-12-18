package com.saucelab.utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {

    private static ExtentReports extent;
    private static ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        System.out.println ("The excuation started!");
        ExtentSparkReporter sparkReport  = new ExtentSparkReporter ("reports/ExtentSparkReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReport);
    }

    @Override
    public void onTestSkipped(ITestResult result){
        System.out.println("Test started: " + result.getMethod().getMethodName());
        test.log (Status.SKIP,"Test Skipped");
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test failed");
        test.addScreenCaptureFromPath (TakeScreenShot.takeFailedScreenShot (result));

    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}
