package com.util;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class MyReports {


public ExtentReports reports = new ExtentReports(System.getProperty("user.dir")+"/extentreport/test-report.html");
public ExtentTest test = reports.startTest("ExtentDemo");

}