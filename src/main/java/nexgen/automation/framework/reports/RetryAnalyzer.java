package nexgen.automation.framework.reports;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import nexgen.automation.framework.config.ReadConfig;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ExecutionResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	ReadConfig readconfig = new ReadConfig();
	
	String count = readconfig.retry();
	
	int counter = 0;
	int retryLimit = Integer.parseInt(count);
	
	
	public boolean retry(ITestResult result){
		if(counter < retryLimit){
			counter++;
			
			ExecutionResult.retryFlag = true;
			
			return true;
		}
		return false;
	}
	
	
	
}