package nexgen.automation.framework.reports;


import java.util.List;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import nexgen.automation.framework.xray.UpdateTestExecutions;


public class GenerateTestNGReport implements IReporter {

	
	@Override
	public void generateReport(List<XmlSuite> arg0, List<ISuite> arg1, String arg2) {
		
		UpdateTestExecutions.updateXrayTestResults();
	
				
	}
}
	

