package nexgen.automation.framework.connectionRepo.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import nexgen.automation.framework.constant.Constant;

//import nexgen.automation.pageclasses.otherpages.HomePage;
import nexgen.automation.framework.reports.ListenerTest;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.connectionRepo.ConnectionHome;
import nexgen.automation.framework.connectionRepo.ConnectionUtil;
import nexgen.automation.framework.connectionRepo.DB2Connection;
//import nexgen.automation.pageclasses.pages.LoginPage;

@Listeners(ListenerTest.class)
public class ValidateDB2ConnectionTest extends BaseSuite{
	
	String connection = System.getProperty("user.dir") + "/src/main/resources/testdata/Connections/DB2.xlsx";
	
	XLUtils XlReader = new XLUtils();

	PageUtil page = new PageUtil();
	
	@Test(groups ="Smoke")
	public void VerifycreateDB2Connection() throws Exception
	{
		test = extent.createTest("VerifycreateDB2Connection");
		SoftAssert soft = new SoftAssert();
		
		reportLog("Launching browser");
		//LoginPage loginTest = new LoginPage(driver);			
		reportLog("Entering login details");

		DB2Connection mysql = new DB2Connection(driver);
		
		XLUtils xl = new XLUtils();
						
		ConnectionUtil cu = new ConnectionUtil(driver);

		PageUtil pageUtil = new PageUtil();
		
		int rowNumber = 0;

		int testCaseStatus = 1;// this status is just a flag to define the status as pass or fail.
		
		
		
		//if (loginTest.login(username, password))
			soft.fail("Failed to login into application. Aborting test execution");
		
		ConnectionHome connect = new ConnectionHome(driver);
		connect.ConnectionRepo();
		
		int rowCount = xl.getRowCount(connection, "Create-Connection");

		BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + connection);
		for (int rowNum = 0; rowNum < rowCount; rowNum++) {

			rowNumber = rowNum + 1;

			BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + "Iteration");

			List<String> inputs = pageUtil.getColumnNamesUsingSheet(connection, "Create-Connection");

			List<String> output = XlReader.getDetails(inputs, rowNumber, "Create-Connection", XlReader, connection);
			mysql.createDB2Connection(driver,output.get(1),output.get(10),output.get(2),output.get(3),output.get(4),output.get(5),output.get(6),output.get(7),
			output.get(8),output.get(0),soft,output.get(9),output.get(11),output.get(12),output.get(13),connection,rowNumber, 
			testCaseStatus,"Status","Create-Connection","VerifycreateDB2Connection",test,log,output.get(14));
			
			xl.getCellData(connection, "Create-Connection", rowNumber, 14);
			
	}
}
	
	@Test(groups = { "DepthFirst", "ConnectionRepo", "testcases" })
	public void VerifyupdateDB2Connection() throws Exception {
		test = extent.createTest("VerifycreateDB2Connection");
		SoftAssert soft = new SoftAssert();

		reportLog("Launching browser");
		//LoginPage loginTest = new LoginPage(driver);
		reportLog("Entering login details");

		DB2Connection DB2 = new DB2Connection(driver);

		XLUtils xl = new XLUtils();

		ConnectionUtil cu = new ConnectionUtil(driver);

		PageUtil pageUtil = new PageUtil();

		int rowNumber = 0;

		int testCaseStatus = 1;// this status is just a flag to define the status as pass or fail.

		//if (loginTest.login(username, password))
			soft.fail("Failed to login into application. Aborting test execution");

		ConnectionHome connect = new ConnectionHome(driver);
		connect.ConnectionRepo();

		int rowCount = xl.getRowCount(connection, "Create-Connection");

		BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + connection);
		for (int rowNum = 0; rowNum < rowCount; rowNum++) {

			rowNumber = rowNum + 1;

			BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

			List<String> inputs = pageUtil.getColumnNamesUsingSheet(connection, "Create-Connection");

			List<String> output = XlReader.getDetails(inputs, rowNumber, "Create-Connection", XlReader, connection);
			DB2.updateDB2Connection(driver, output.get(1),output.get(15),output.get(6), output.get(2), output.get(3),
					output.get(4), output.get(7), output.get(8), output.get(0),soft, output.get(13),
					output.get(12), output.get(9), output.get(11), output.get(14),connection,"Create-Connection", rowNumber,
					testCaseStatus, "Status",log,test, "VerifyupdateDB2Connection");

			xl.getCellData(connection, "Create-Connection", rowNumber, 16);

		}
	}
	
	@Test(groups = { "DepthFirst", "Administration", "testcases" })
	public void VerifyDB2ConnectionMandatory() throws Exception {
		
		test = extent.createTest("DB2_Mandatory");

		//Constant.issueKey = "IC2-5910";

		SoftAssert soft = new SoftAssert();

		reportLog("Launching browser");
		//LoginPage loginTest = new LoginPage(driver);
		reportLog("Entering login details");

		DB2Connection DB2 = new DB2Connection(driver);

		XLUtils xl = new XLUtils();
		
		int rowCount = XlReader.getRowCount(connection, "Mandatory");
		int testCaseStatus = 1;// this status is just a flag to define the status as pass or fail.
			
		//if (loginTest.login(username, password))
			soft.fail("Failed to login into application. Aborting test execution");

		ConnectionHome connect = new ConnectionHome(driver);
		connect.ConnectionRepo();
		
		for (int rowNum = 0; rowNum < rowCount; rowNum++) {

			int rowNumber = rowNum + 1;
			BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");
			List<String> input = new ArrayList<String>() {
				{
					add("connectionType");
					add("connFormat");
					add("SpecialChar");
					add("ConnectionName");
					add("host");
					add("port");
					add("serviceDBName");
					add("fullUrl");
					add("userName");
					add("password");
					add("connProp");
					add("Conn_Type");
					add("portdata");
				}
			};
			List<String> output = xl.getDetails(input, rowNumber, "Mandatory", xl, connection);

			DB2.DB2MandatoryField(soft, output.get(0), output.get(1), output.get(2), output.get(3), output.get(4),
					output.get(5), output.get(6), output.get(7), output.get(8), output.get(9), output.get(10),
					output.get(11), output.get(12), connection, "Mandatory", "Status", rowNumber, test,
					log,"DB2MandatoryField", testCaseStatus);
		}

		soft.assertAll();
		DB2.testCaseStatus(testCaseStatus, log);

	}
}
