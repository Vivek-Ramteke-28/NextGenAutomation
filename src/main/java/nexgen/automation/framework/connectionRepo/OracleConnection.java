package nexgen.automation.framework.connectionRepo;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;


public class OracleConnection extends ConnectionUtil {
	
	WebDriver driver;
	
	public OracleConnection(WebDriver driver)
	{
		super(driver);
	}
	
	public void createOracleConnection(WebDriver driver,String connectionName, String ConnectionType,String host, String port,
			String serviceDBName, String JDBCUrl, String fullurl, String userName, String password,String connType, SoftAssert soft, String JDBCUrlTog,String scenarioType,
			String connectionStatus,String connectionTestMess,String filepath,int rowNumber,int testCaseStatus,String StatuscolName,
			String sheetName,String methodName,ExtentTest test, Logger log,String connectionSaveMess) throws Exception
	{
		XLUtils Xl = new XLUtils();
		PageUtil pageUtil = new PageUtil();
		boolean testCaseFlag = false;
		String e1 = null;
		
		
		try {
			//ConnectionUtil connectiontab1 = new ConnectionUtil(driver);
			//connectiontab1.
			ClickonConnectionsMenu();
			BaseSuite.reportLog("Click on connections tab");
			displayAndClick(clickonNewConnectionButton);
			BaseSuite.reportLog("Connection type is getting display after click on new connection Button");
			Thread.sleep(3000);
			clickOnConnectionName(ConnectionType);
			
			CreateConnection(driver,connectionName,host, port, serviceDBName,JDBCUrl,
							fullurl, userName, password,connType,soft,JDBCUrlTog);
			
			if(scenarioType.equalsIgnoreCase("valid"))
			{
				TestConnection(driver,soft, connectionTestMess,connectionStatus);
				BaseSuite.validationReportLog("Connection tested successfully");
				saveConnection(driver,connectionSaveMess,soft);
				//To check for the duplicate connection name
				verifyDuplicateConnection(driver,connectionSaveMess,soft);
				
			}
			else 
			{
				TestInvalidConnection(driver,soft, connectionStatus,connectionTestMess);
				discardConnection(driver);
			}
			
			
			Xl.writeToExcel("Pass", filepath, sheetName, rowNumber, StatuscolName);
			testCaseFlag = false;
		}
		catch (Exception e2) {

			testCaseFlag = true;

			testCaseStatus++;// increment this flag to mark the test case as failed

			e1 = e2.getMessage();

		} 
			  finally { if (testCaseFlag) {
			  
			  continueNext(sheetName, test, rowNumber, e1, log, StatuscolName,
			 methodName, filepath); } }
			 
	}
	
	public void updateOracleConnection(WebDriver driver,String connectionName,String updatedConnectionName, String fullUrl, String host, String port, String serviceDBName,
			String userName, String password, String connType,SoftAssert soft,String connectionTestMess, String connectionStatus,String JDBCUrlTog, String scenarioType,
			String connectionSaveMess, String filepath, String sheetName,int rowNumber,int testCaseStatus, String StatuscolName,Logger log,ExtentTest test,String methodName) throws Exception {
		
				XLUtils Xl = new XLUtils();
				PageUtil pageUtil = new PageUtil();
				boolean testCaseFlag = false;
				String e1 = null;
				try {	
				ClickonConnectionsMenu();
				SearchConnection(connectionName);
				
				updateConnection(updatedConnectionName, fullUrl, host, port, serviceDBName, userName, password, connType, soft, JDBCUrlTog);
				
				if(scenarioType.equalsIgnoreCase("valid"))
				{
					TestConnection(driver,soft, connectionTestMess,connectionStatus);
					BaseSuite.validationReportLog("Connection tested successfully");
					saveConnection(driver,connectionSaveMess,soft);
										
				}
				else 
				{
					TestInvalidConnection(driver,soft, connectionStatus,connectionTestMess);
					discardConnection(driver);
				}
								
				Xl.writeToExcel("Pass", filepath, sheetName, rowNumber, StatuscolName);
				testCaseFlag = false;
				}
				catch(Exception e2)
				{
					testCaseFlag = true;

					testCaseStatus++;// increment this flag to mark the test case as failed

					e1 = e2.getMessage();
				}
				finally { if (testCaseFlag) {
					  
					  continueNext(sheetName, test, rowNumber, e1, log, StatuscolName,
					 methodName, filepath); } }
			}
	
	public void OracleMandatoryField(SoftAssert soft, String connectionType, String connFormat,
			String SpecialChar, String connectionName, String host, String port, String serviceDBName, String fullUrl,
			String userName, String password, String connProp, String connType, String portdata, String fileName,
			String sheetName, String colName, int rowNumber, ExtentTest test, Logger log,
			String methodName, int testCaseStatus) throws Exception {

		{
			XLUtils Xl = new XLUtils();

			boolean testCaseFlag = false;

			String e1 = null;

			try {
				mandatoryField(soft, connectionType, connFormat, SpecialChar, connectionName, host,
						port, serviceDBName, fullUrl, userName, password, connProp, connType, portdata);

				Xl.writeToExcel("Pass", fileName, sheetName, rowNumber, colName);

				testCaseFlag = false;
			} catch (Exception e2) {

				testCaseFlag = true;

				testCaseStatus++;// increment this flag to mark the test case as failed

				e1 = e2.getMessage();

			} finally {
				if (testCaseFlag) {

					continueNext(sheetName, test, rowNumber, e1, log, colName, methodName, fileName);
				}
			}
		}
	}
	
	
	
	}
	

