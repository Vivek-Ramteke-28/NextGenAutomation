package nexgen.automation.framework.reports;
	

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.ExecutionResult;
import nexgen.automation.framework.constant.RunTimeVariables;
import nexgen.automation.framework.util.BaseClassUtil;
import nexgen.automation.framework.util.XLUtils;



public class ListenerTest implements  ITestListener						
{	
	final Logger log = Logger.getLogger(ListenerTest.class);
	XLUtils xlReader = new XLUtils();
	
	boolean testSuccess = true;

	 public static String ReportDocument =null;
	 
	    
	 //Do tier down operations for extentreports reporting!
	 @Override		
    public void onFinish(ITestContext Result) 	
    {	
    	/*    extentsreporterExtentTestManager.endTest();
	     ExtentManager.getReporter().flush();*/
    }		

    @Override		
    public void onStart(ITestContext Result)	
        
    {		   
		ExecutionResult.suitename = Result.getCurrentXmlTest().getSuite().getName();

		ExecutionResult.reportDocPath = XLUtils.createWorkBook();
		ReportDocument = ExecutionResult.reportDocPath;
		 
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result)					
    {		
    		
    }		

    // When Test case get failed, this method is called.		
    @Override		
    public void onTestFailure(ITestResult Result) 					
    {		
    	
     RunTimeVariables runtimeIssueKeyFailed = new RunTimeVariables();
    	 
     runtimeIssueKeyFailed.issueKeySetValue(ExecutionResult.issueKey);
    	
     String issueKeyFailed = runtimeIssueKeyFailed.issueKeyGetValue();
    	
     log.info("The name of the testcase failed is :"+Result.getName());	

     ExecutionResult.failedTC ++;

	 String statuFailed = String.valueOf(Result.getStatus());

	    RunTimeVariables components = new RunTimeVariables();
		 
	    components.issueKeySetValue(ExecutionResult.components);
	    	    	
	    String components1 = components.issueKeyGetValue();
	    
	    RunTimeVariables lables = new RunTimeVariables();
		 
	    lables.issueKeySetValue(ExecutionResult.lables);
	    	    	
	    String lables1 = lables.issueKeyGetValue();
	    
	    Throwable description = Result.getThrowable();
	    
	    String environment = "baseURL-- "+BaseSuite.baseURL+", username-- "+BaseSuite.username+" and Version: "+BaseSuite.version;
	 
	    String summary = Result.getMethod().getMethodName()+" Failed";
	    
    try {
    	
    	BaseClassUtil util = new BaseClassUtil();
    	
		String screenshotPath2 = util.takeScreenshot(Result.getMethod().getMethodName(),BaseSuite.driver);
		
		ExecutionResult.screenshotPath = screenshotPath2;
				
		xlReader.setCellData(ReportDocument, ExecutionResult.currentRowNum, 1, issueKeyFailed);
		
		xlReader.setCellData(ReportDocument,  ExecutionResult.currentRowNum, 2, statuFailed);
		
		xlReader.setCellData(ReportDocument,  ExecutionResult.currentRowNum, 3, summary);
		
		xlReader.setCellData(ReportDocument,  ExecutionResult.currentRowNum, 4, ExecutionResult.screenshotPath);
		
		xlReader.setCellData(ReportDocument,  ExecutionResult.currentRowNum, 5, components1);
		
		xlReader.setCellData(ReportDocument,  ExecutionResult.currentRowNum, 6, lables1);
		
		xlReader.setCellData(ReportDocument,  ExecutionResult.currentRowNum, 7, description.toString());
		
		xlReader.setCellData(ReportDocument,  ExecutionResult.currentRowNum, 8, environment);
		
		ExecutionResult.currentRowNum++;
		
	} catch (IOException e) {
	
		log.error(e.getMessage());
	}
    
    }		

    // When Test case get Skipped, this method is called.		
    @Override		
    public void onTestSkipped(ITestResult Result)					
    {		
    	
    RunTimeVariables runtimeIssueKeySkipped = new RunTimeVariables();
    	 
    runtimeIssueKeySkipped.issueKeySetValue(ExecutionResult.issueKey);
    	
    String issueKeySkipped = runtimeIssueKeySkipped.issueKeyGetValue();
    	
    
    log.info("The name of the testcase Skipped is :"+Result.getName());
    
    if(ExecutionResult.retryFlag) {
    
    	ExecutionResult.retryFlagCount++;
    	
    }else {
    	
    	ExecutionResult.testskip ++;
    
    }
    String statuSkipped = String.valueOf(Result.getStatus());
    
    try {
    	
		xlReader.setCellData(ReportDocument,  ExecutionResult.currentRowNum, 1, issueKeySkipped);
		
		xlReader.setCellData(ReportDocument,  ExecutionResult.currentRowNum, 2, statuSkipped);
		
		ExecutionResult.currentRowNum++;
		
	} catch (Exception e) {

		log.error(e.getMessage());
	}
    
    }		

    // When Test case get Started, this method is called.		
    @Override			
    public void onTestStart(ITestResult Result)					
    {		
    	log.info(Result.getName()+" test case started");	
    
    
    	ExecutionResult.retryFlag = false;
    
    	ExecutionResult.test++;
    
    }		

    // When Test case get passed, this method is called.		
    @Override		
    public void onTestSuccess(ITestResult Result)					
    {		
    	
    RunTimeVariables runtimeIssueKeyPassed = new RunTimeVariables();
    	 
    runtimeIssueKeyPassed.issueKeySetValue(ExecutionResult.issueKey);
    	    	
    String issueKeyPassed = runtimeIssueKeyPassed.issueKeyGetValue();
    
    log.info("The name of the testcase passed is :"+Result.getName());
   
    ExecutionResult.passedTC ++;

    String statuPassed = String.valueOf(Result.getStatus());
    try {
    	
		xlReader.setCellData(ReportDocument,  ExecutionResult.currentRowNum, 1, issueKeyPassed);
		
		xlReader.setCellData(ReportDocument,  ExecutionResult.currentRowNum, 2, statuPassed);
		
		ExecutionResult.currentRowNum++;
		
	} catch (Exception e) {
	
		log.error(e.getMessage());
	}
    }		

}