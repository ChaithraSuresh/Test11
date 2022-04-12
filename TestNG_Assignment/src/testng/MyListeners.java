package testng;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.util.MyReports;

public class MyListeners extends MyReports implements ITestListener{

	MyReports report = new MyReports();
	@Override		
    public void onFinish(ITestContext Result) {					
		report.reports.flush();
	    report.reports.endTest(report.test);
    }		

    @Override		
    public void onStart(ITestContext Result) {					
    				
        		
    }		

    /*@Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }*/		

    @Override		
    public void onTestFailure(ITestResult Result) {					
    	System.out.println("name of the testcase failed :"+Result.getName());
    	report.test.log(LogStatus.FAIL, "Test failed");
    	
        		
    }		

    @Override		
    public void onTestSkipped(ITestResult Result) {					
    	System.out.println("The name of the testcase Skipped is :"+Result.getName());			
        		
    }		

    @Override		
    public void onTestStart(ITestResult Result) {					
    	System.out.println("The testcase started:"+Result.getName());			
        		
    }		

    @Override		
    public void onTestSuccess(ITestResult Result) {					
    	System.out.println("name of the testcase passed :"+Result.getName());	
    	report.test.log(LogStatus.PASS, "Test Passed");
        		
    }		
}
