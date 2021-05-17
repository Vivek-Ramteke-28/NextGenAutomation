package nexgen.automation.framework.connectionRepo;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
//import com.fasterxml.jackson.databind.exc.InvalidFormatException;

//import nexgen.automation.pageclasses.pages.LoginPage;
//import views.html.ac.aui.message;
import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.util.BaseClassUtil;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;

public class ConnectionUtil extends PageUtil {

	public WebDriver driver;

	public ConnectionUtil(WebDriver driver) {

		this.driver = driver;
	}
	//protected NewConnections connectiontab = new NewConnections(driver);
	
	protected By Mysqlconnection = getElementLocator(prop.getProperty("ConnectionB.Mysql"));
	protected By Oracleconnection=getElementLocator(prop.getProperty("ConnectionB.Oracle"));
	protected By Postgresconnection = getElementLocator(prop.getProperty("ConnectionB.Postgres"));
	protected By Teradataconnection = getElementLocator(prop.getProperty("ConnectionB.Teradata"));
	protected By Netezzaconnection = getElementLocator(prop.getProperty("ConnectionB.Netezza"));
	protected By Sybaseconnection = getElementLocator(prop.getProperty("ConnectionB.Sybase"));
	protected By Redshiftconnection = getElementLocator(prop.getProperty("ConnectionB.Redshift"));
	protected By Greenplumconnection = getElementLocator(prop.getProperty("ConnectionB.Greenplum"));
	protected By HPVerticaconnection = getElementLocator(prop.getProperty("ConnectionB.HPVertica"));
	protected By DB2connection = getElementLocator(prop.getProperty("ConnectionB.DB2"));
	protected By ConnectionName=getElementLocator(prop.getProperty("ConnectionB.connectionName"));
	protected By selectWorkspace=getElementLocator(prop.getProperty("ConnectionB.Selectworkspace"));
	By selectDriver=getElementLocator(prop.getProperty("ConnectionB.Selectdriver"));
	protected By clickonNewConnectionButton = getElementLocator(prop.getProperty("Connection.newConnection"));
	By clickonConnectionMenu = getElementLocator(prop.getProperty("Connection.connections"));
	protected By selectworkspace = getElementLocator(prop.getProperty("ConnectionB.SearchWorkspace"));
	String clickonSearchWorkspace = prop.getProperty("ConnectionB.ClickonWorkspace");
	protected By connectionHost = getElementLocator(prop.getProperty("ConnectionB.ClickonConnectionHost"));
	protected By connectionPort = getElementLocator(prop.getProperty("ConnectionB.ClickonConnectionPort"));
	protected By connectionDBName = getElementLocator(prop.getProperty("ConnectionB.ClickonDatabase"));
	protected By connectionFullUrl = getElementLocator(prop.getProperty("ConnectionB.EnterFullUrl"));
	By connectionTypeUser = getElementLocator(prop.getProperty("ConnectionB.SelectType"));
	protected By connectionUsername = getElementLocator(prop.getProperty("ConnectionB.EnterUsername"));
	protected By connectionPassword = getElementLocator(prop.getProperty("ConnectionB.EnterPassword"));
	protected By clickonToggleButton = getElementLocator(prop.getProperty("ConnectionB.ClickonToggleButton"));
	protected By connectionTestButton = getElementLocator(prop.getProperty("ConnectionB.ClickTestButton"));
	String successToastMsg = prop.getProperty("ConnectionB.TestconnectionToast");
	By commonToast = getElementLocator(prop.getProperty("ConnectionB.CommonToast"));
	protected By testToastmsg= getElementLocator(prop.getProperty("ConnectionB.TestconnectionToast"));
	protected By connectionSaveButton= getElementLocator(prop.getProperty("ConnectionB.SaveButton"));
	By saveToastmsg = getElementLocator(prop.getProperty("ConnectionB.SaveConnection"));
	By dropdownIconClick = getElementLocator(prop.getProperty("ConnectionB.DropdownIconClick"));
	By selectUserType = getElementLocator(prop.getProperty("ConnectionB.UserType"));
	By clickOnDiscardButton = getElementLocator(prop.getProperty("ConnectionB.DiscardConnection"));
	 By searchBar = getElementLocator(prop.getProperty("Connection.SearchBox"));
	 By searchBclick = getElementLocator(prop.getProperty("Connection.SearchButton"));
	 String clickonSearchConnection = prop.getProperty("Connection.SearchConnection");
	By duplicateConnectionMess = getElementLocator(prop.getProperty("ConnectionB.DuplicateConnectionMess"));
	
	//Mandatory Label
	protected By workspaceLabel = getElementLocator(prop.getProperty("ConnectionB.Mandatory.WorkspaceLabel"));
	protected By connectionLabel = getElementLocator(prop.getProperty("ConnectionB.Mandatory.ConnectionLabel"));
	protected By driverLabel = getElementLocator(prop.getProperty("ConnectionB.Mandatory.DriverLable"));
	protected By authenticationLabel = getElementLocator(prop.getProperty("ConnectionB.Mandatory.AuthenticationLabel"));
	protected By customJDBCLabel = getElementLocator(prop.getProperty("ConnectionB.Mandatory.CustomJdbcLable"));
	protected By hostLabel = getElementLocator(prop.getProperty("ConnectionB.Mandatory.HostLable"));
	protected By portLabel = getElementLocator(prop.getProperty("ConnectionB.Mandatory.PortLable"));
	protected By databaseLabel = getElementLocator(prop.getProperty("ConnectionB.Mandatory.DatabaseLable"));
	protected By typeLabel = getElementLocator(prop.getProperty("ConnectionB.Mandatory.TypeLable"));
	protected By usernameLabel = getElementLocator(prop.getProperty("ConnectionB.Mandatory.UsernameLabel"));
	protected By passwordLabel = getElementLocator(prop.getProperty("ConnectionB.Mandatory.PasswordLabel"));
	protected By connPropertyNameLabel = getElementLocator(prop.getProperty("ConnectionB.Mandatory.PropertyNameLabel"));
	protected By connPropertyValueLabel = getElementLocator(prop.getProperty("ConnectionB.Mandatory.PropertyValueLabel"));
	protected By connPropertyTypeLabel = getElementLocator(prop.getProperty("ConnectionB.Mandatory.PropertyTypeLabel"));
	protected By connectionNameErrorMsg = getElementLocator(prop.getProperty("ConnectionB.Mandatory.ConnectionNameErrorMsg"));
	String connErrorMessage = prop.getProperty("ConnectionB.Mandatory.ConnErrorMsg");
	
	public void clickSelectedConnections(By locator, String connectionName) throws Exception {
		//click(driver, locator);
		isDisplayedInLoop(driver, 40, locator);
		javascript(driver, "arguments[0].click();", locator);
		BaseSuite.reportLog("Clicked On " + connectionName + " Connection");
	}
	
	public void ClickonConnectionsMenu() throws Exception 
	{
		isDisplayedInLoop(driver ,40 , clickonConnectionMenu);
		//click(driver,clickonConnectionMenu);
		javascript(driver, "arguments[0].click();", clickonConnectionMenu);
	}
	
	public void displayAndClick(By locator) {

		try {
		
			isDisplayedInLoop(driver, 60, locator);
			//click(driver, locator);
			javascript(driver, "arguments[0].click();", locator);
		} catch (Exception e) {

			e.getMessage();
		}
	}
	
	//This method use to click on connection name
	public void clickOnConnectionName(String connectionType) throws Exception {

		switch (connectionType) {

		case "MySql":
			clickSelectedConnections(Mysqlconnection, "MySql");
			break;
		case "Oracle":
			clickSelectedConnections(Oracleconnection, "Oracle");
			break;
		case "Postgres":
			clickSelectedConnections(Postgresconnection,"Postgres");
			break;
		case "Netezza":
			clickSelectedConnections(Netezzaconnection,"Netezza");
			break;
		case "Redshift":
			clickSelectedConnections(Redshiftconnection,"Redshift");
			break;	
		case "Sybase":
			clickSelectedConnections(Sybaseconnection,"Sybase");
			break;
		case "Teradata":
			clickSelectedConnections(Teradataconnection,"Teradata");
			break;	
		case "Greenplum":
			clickSelectedConnections(Greenplumconnection,"Greenplum");
			break;
		case "HPVertica":
			clickSelectedConnections(HPVerticaconnection,"HPVertica");
			break;
		case "DB2":
			clickSelectedConnections(DB2connection,"DB2");
			break;
			default:
			break;
		}
	}	
	
	public void selectDriverName(String DriverName)
	{
		switch(DriverName)
		{
		case "Cassendra Native":
			selectByVisibleText(driver,selectDriver ,"Cassendra Native");
			break;
			default:
			break;
		}
	}
	
	public void SearchConnection(String connectionName) throws Exception
	{
		
			isDisplayed(driver, clickonConnectionMenu);
			click(driver, clickonConnectionMenu);
			
			BaseSuite.reportLog("Searching for Connection:" + connectionName);
			isDisplayedInLoop(driver, 10, searchBar);
			Thread.sleep(3000);
			click(driver, searchBar);
			clear(driver, searchBar);

			isDisplayedInLoop(driver, 4, searchBar);
			BaseSuite.reportLog("Search Connection");
			sendKeys(driver, searchBar, connectionName);
			BaseSuite.reportLog("Click On searched");

			isDisplayedInLoop(driver, 3, searchBclick);
			click(driver, searchBclick);

			try {

				isDisplayedInLoop(driver, 4, searchBclick);

				BaseSuite.reportLog("Click on Searched User");

				click(driver, returnElement(clickonSearchConnection, "$Connection", connectionName));
				BaseSuite.reportLog("Clicked on connection: " + connectionName);
				BaseSuite.reportLog("Connection Details retrieved successfully for connection " + connectionName);

			} catch (Exception e) {
				throw new Exception("Connection_search " + searchBclick + " not found");
			}
		}
		
	
	
	// This method create connections for 
	// APACHEDRILL, DB2, GREENPLUM, HP VERTICA,MYSQL, NETEZZA, OPENDGE, ORACLE, POSTGRESQL, REDSHIFT, SYBASE,TERADATA
	public void CreateConnection(WebDriver driver, String connectionName,String host,String port,String serviceDBName,String JDBCUrl,
			String fullurl,String userName, String password,String connType,SoftAssert soft,String JDBCUrlTog) throws Exception
	{
		
		//SearchWorkspace("Auto");
		BaseSuite.reportLog("Searching for Workspace");
				
		displayAndClick(selectworkspace);
		Thread.sleep(2000);
		sendKeys(driver, selectworkspace, "ConnectionRepo");
		BaseSuite.validationReportLog("Selected the workspace which assigned to the user");
		displayAndClick(ConnectionName);
		sendKeys(driver, ConnectionName, connectionName);
		BaseSuite.reportLog("Entering Connection Name In Connection Name Field");
		//selectDriverName("Mysql JDBC");
		
		
		if (JDBCUrlTog.contains("No")) {
			
			displayAndClick(connectionHost);

			BaseSuite.reportLog("Clicking on Connection Host Field");

			sendKeys(driver, connectionHost, host);

			BaseSuite.reportLog("Entering Connection Host In Host Field");

			displayAndClick(connectionPort);

			BaseSuite.reportLog("Clicking on Connection Port Field");

			sendKeys(driver, connectionPort, port);

			BaseSuite.reportLog("Entering Connection Port In Port Field");

			displayAndClick(connectionDBName);

			BaseSuite.reportLog("Clicking on Connection DB Field");

			sendKeys(driver, connectionDBName, serviceDBName);

			BaseSuite.reportLog("Entering Connection DB Name In DB Field");
			BaseSuite.validationReportLog("Entered host, port and database details");

		} else {
			
			click(driver, clickonToggleButton);
			BaseSuite.validationReportLog("User entered the custom JDBC url details");
			isDisplayed(driver, connectionFullUrl);

			// click(driver, ConnectionFullUrl);

			clear_Click_SendKeys(driver, 5, connectionFullUrl, fullurl);

			BaseSuite.reportLog("Clicking on Connection Full Url Field");

			// sendKeys(driver, ConnectionFullUrl, fullUrl);

			BaseSuite.reportLog("Entering Connection Full Url In Full Url Field");

		}
		

		if (connType.equals("System")) {

			BaseSuite.validationReportLog("Selected System Connection");
			isDisplayedInLoop(driver, 10,connectionUsername);
			clear_SendKeys(driver, connectionUsername, userName);

			BaseSuite.reportLog("Entering Connection User Name In UserName Field");

			clear_SendKeys(driver, connectionPassword, password);

			BaseSuite.reportLog("Entering Connection Password In Password Field");
		}
		if (connType.equals("User")) {
			
			isDisplayedInLoop(driver, 10,dropdownIconClick);
			click(driver,dropdownIconClick);
			Select client = new Select(driver.findElement(selectUserType));
			client.selectByIndex(1);
			
			//displayAndClick(dropdownIconClick);
			
			/*
			 * click(driver,dropdownIconClick);
			 * 
			 * WebElement ele = driver.findElement(dropdownIconClick);
			 * ele.sendKeys(Keys.TAB); ele.sendKeys(Keys.ARROW_DOWN);
			 * ele.sendKeys(Keys.ENTER);
			 */
			//sendKeys(driver,dropdownIconClick, "ele");
			/*
			 * click(driver,dropdownIconClick); WebElement ele =
			 * driver.findElement(dropdownIconClick); ele.sendKeys("User");
			 */
			
			//javascript(driver, "arguments[0].click();", selectUserType);
			//click(driver,selectUserType);
			
			//click(driver,connectionTypeUser);
			
			displayAndClick(connectionUsername);
			clear_SendKeys(driver, connectionUsername, userName);

			BaseSuite.reportLog("Entering Connection User Name In UserName Field");

			displayAndClick(connectionPassword);
			clear_SendKeys(driver, connectionPassword, password);

			BaseSuite.reportLog("Entering Connection Password In Password Field");
			
		}
	}	
	
	public void CreateCassendraConnection(WebDriver driver,String connectionName,String driverName,String host,String port,String serviceDBName,String JDBCUrl,
			String fullurl,String userName, String password,String connType,SoftAssert soft,String JDBCUrlTog) throws Exception
	{
		
		//SearchWorkspace("Auto");
		BaseSuite.reportLog("Searching for Workspace");
				
		displayAndClick(selectworkspace);
		Thread.sleep(2000);
		sendKeys(driver, selectworkspace, "ConnectionRepo");
		BaseSuite.validationReportLog("Selected the workspace which assigned to the user");
		displayAndClick(ConnectionName);
		sendKeys(driver, ConnectionName, connectionName);
		BaseSuite.reportLog("Entering Connection Name In Connection Name Field");
		//selectDriverName("Mysql JDBC");
		
		if(driverName.contains("Cassendra JDBC"))
		{
			if (JDBCUrlTog.contains("No")) {
			
			displayAndClick(connectionHost);

			BaseSuite.reportLog("Clicking on Connection Host Field");

			sendKeys(driver, connectionHost, host);

			BaseSuite.reportLog("Entering Connection Host In Host Field");

			displayAndClick(connectionPort);

			BaseSuite.reportLog("Clicking on Connection Port Field");

			sendKeys(driver, connectionPort, port);

			BaseSuite.reportLog("Entering Connection Port In Port Field");

			displayAndClick(connectionDBName);

			BaseSuite.reportLog("Clicking on Connection DB Field");

			sendKeys(driver, connectionDBName, serviceDBName);

			BaseSuite.reportLog("Entering Connection DB Name In DB Field");
			BaseSuite.validationReportLog("Entered host, port and database details");

		} else {
			
			click(driver, clickonToggleButton);
			BaseSuite.validationReportLog("User entered the custom JDBC url details");
			isDisplayed(driver, connectionFullUrl);

			// click(driver, ConnectionFullUrl);

			clear_Click_SendKeys(driver, 5, connectionFullUrl, fullurl);

			BaseSuite.reportLog("Clicking on Connection Full Url Field");

			// sendKeys(driver, ConnectionFullUrl, fullUrl);

			BaseSuite.reportLog("Entering Connection Full Url In Full Url Field");
		}
		}
			else
			{
			selectDriverName(driverName);
			if (JDBCUrlTog.contains("No")) {
				
				displayAndClick(connectionHost);

				BaseSuite.reportLog("Clicking on Connection Host Field");

				sendKeys(driver, connectionHost, host);

				BaseSuite.reportLog("Entering Connection Host In Host Field");

				displayAndClick(connectionPort);

				BaseSuite.reportLog("Clicking on Connection Port Field");

				sendKeys(driver, connectionPort, port);

				BaseSuite.reportLog("Entering Connection Port In Port Field");

				displayAndClick(connectionDBName);

				BaseSuite.reportLog("Clicking on Connection DB Field");

				sendKeys(driver, connectionDBName, serviceDBName);

				BaseSuite.reportLog("Entering Connection DB Name In DB Field");
				BaseSuite.validationReportLog("Entered host, port and database details");

			} else {
				
				click(driver, clickonToggleButton);
				BaseSuite.validationReportLog("User entered the custom JDBC url details");
				isDisplayed(driver, connectionFullUrl);

				// click(driver, ConnectionFullUrl);

				clear_Click_SendKeys(driver, 5, connectionFullUrl, fullurl);

				BaseSuite.reportLog("Clicking on Connection Full Url Field");

				// sendKeys(driver, ConnectionFullUrl, fullUrl);

				BaseSuite.reportLog("Entering Connection Full Url In Full Url Field");
			}
			}
		if (connType.equals("System")) {

			BaseSuite.validationReportLog("Selected System Connection");
			isDisplayedInLoop(driver, 10,connectionUsername);
			clear_SendKeys(driver, connectionUsername, userName);

			BaseSuite.reportLog("Entering Connection User Name In UserName Field");

			clear_SendKeys(driver, connectionPassword, password);

			BaseSuite.reportLog("Entering Connection Password In Password Field");
		}
		if (connType.equals("User")) {
			
			isDisplayedInLoop(driver, 10,dropdownIconClick);
			click(driver,dropdownIconClick);
			Select client = new Select(driver.findElement(selectUserType));
			client.selectByIndex(1);
			
			//displayAndClick(dropdownIconClick);
			
			/*
			 * click(driver,dropdownIconClick);
			 * 
			 * WebElement ele = driver.findElement(dropdownIconClick);
			 * ele.sendKeys(Keys.TAB); ele.sendKeys(Keys.ARROW_DOWN);
			 * ele.sendKeys(Keys.ENTER);
			 */
			//sendKeys(driver,dropdownIconClick, "ele");
			/*
			 * click(driver,dropdownIconClick); WebElement ele =
			 * driver.findElement(dropdownIconClick); ele.sendKeys("User");
			 */
			
			//javascript(driver, "arguments[0].click();", selectUserType);
			//click(driver,selectUserType);
			
			//click(driver,connectionTypeUser);
			
			displayAndClick(connectionUsername);
			clear_SendKeys(driver, connectionUsername, userName);

			BaseSuite.reportLog("Entering Connection User Name In UserName Field");

			displayAndClick(connectionPassword);
			clear_SendKeys(driver, connectionPassword, password);

			BaseSuite.reportLog("Entering Connection Password In Password Field");
			
		}
	}	
	
	
	public void TestConnection(WebDriver driver, SoftAssert soft,String connectionTestMess, String connectionStatus) throws Exception
	{
		try {
			if(connectionStatus.equalsIgnoreCase("Yes"))
			{
				waitForElement(driver,ConnectionName);
				
				javascript(driver, "arguments[0].click();", connectionTestButton);
				//waitForElement(driver, testToastmsg);
				
				Thread.sleep(3000);
				String message =driver.findElement(By.className("e-toast-content")).getText();
				System.out.println(message);
				
				
				//String testStatus = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(testToastmsg)).getText();
				    if (message.contains("Fail to connect to server")) {
				        System.out.println("Test Failed: " + message);
				    } else {
				    	BaseSuite.validationReportLog("Test Success:" + message);
				    }
								
				//verifyToastMessage(driver, commonToast, connectionTestMess,soft);
			}
			
		}
		catch(Exception ex)
		{
			throw new Exception();
		}
	}
	
	public void TestInvalidConnection(WebDriver driver, SoftAssert soft,String connectionStatus, String connectionTestMess) throws Exception
	{
		try {
			if(connectionStatus.equalsIgnoreCase("Yes"))
			{
				waitForElement(driver,ConnectionName);
				javascript(driver, "arguments[0].click();", connectionTestButton);
				
				if(successToastMsg==connectionTestMess)
				{
					BaseSuite.reportFailLog("Invalid connection getting tested", "TestInvalidConnection");
				}
				else
				{
					BaseSuite.validationReportLog("Invalid connection not getting tested");
					
				}
			}
		}
		catch(Exception ex)
		{
			throw new Exception();
		}
		
	}
	
	public void verifyToastMessage(WebDriver driver, By hoverLocator, String mess, SoftAssert soft) {

		//waitForElement(driver, hoverLocator);

		//waitForElement(driver, hoverText);
		
		String message =driver.findElement(hoverLocator).getText().trim();
		System.out.println(message);
				

		// click(driver, concate(splitAreaLocator, hoverText));

		//String validMess = javascriptGetText(driver, hoverText).trim();

		BaseSuite.validationReportLog("Retrived Message for Created/Tested connection is :" + message);

		BaseSuite.validationReportLog("Expected Message for Created/Tested connection is :" + mess.trim());

		if (!message.isEmpty()) {

			soft.assertEquals(message, mess.trim());

			BaseSuite.validationReportLog("Created/Tested connection Message Successfully Matched");

		}

		else {
			BaseSuite.reportFailLog("Created/Tested connection Messages didn't match", "verifyToastMessage");
		}

	}
	
	public void verifyDuplicateConnection(WebDriver driver, String connectionSaveMess, SoftAssert soft) {
		
		waitForElement(driver,duplicateConnectionMess);
		String validMessage = javascriptGetText(driver,duplicateConnectionMess);
		
		if(validMessage!=connectionSaveMess) {
			soft.assertNotEquals(validMessage, connectionSaveMess.trim());
			BaseSuite.validationReportLog("Connection with same name already available");
		
		}
		else {
			BaseSuite.validationReportLog("Connection saved successfully");
		}
		}
	
	
		public void saveConnection(WebDriver driver,String connectionSavetMess, SoftAssert soft) throws Exception {

		waitForElement(driver,connectionSaveButton);
				
		if(isEnabled(driver, connectionSaveButton))
		{

			javascript(driver, "arguments[0].click();", connectionSaveButton);
		
		}
		else
		{
			 throw new Exception();
		}

		BaseSuite.reportLog("Clicking On Connection Save Button");
		BaseSuite.reportLog("Verifying The Connection Save Message");
		//verifyToastMessage(driver, commonToast, connectionSavetMess,soft);
		
		
		BaseSuite.validationReportLog("Connection saved successfully");

	}
		
		public void discardConnection(WebDriver driver)
		{
			try
			{
				isDisplayedInLoop(driver, 40, clickOnDiscardButton);
				
				javascript(driver, "arguments[0].click();", clickOnDiscardButton);
				BaseSuite.validationReportLog("Connection discarded successfully");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		
		
		public void updateConnection(String updatedConnectionName, String fullUrl, String host, String port,
				String serviceDBName, String userName, String password, String connType, SoftAssert soft,String JDBCUrlTog) {
			
			displayAndClick(ConnectionName);
			clear(driver,ConnectionName);
			sendKeys(driver, ConnectionName, updatedConnectionName);
			BaseSuite.reportLog("Entering Connection Name In Connection Name Field");

			if (fullUrl.isEmpty()) {

				isDisplayed(driver, connectionHost);

				click(driver, connectionHost);

				clear(driver, connectionHost);

				sendKeys(driver, connectionHost, host);

				isDisplayed(driver, connectionPort);

				click(driver, connectionPort);

				clear(driver, connectionPort);

				sendKeys(driver, connectionPort, port);

				isDisplayed(driver, connectionDBName);

				click(driver, connectionDBName);

				clear(driver, connectionDBName);

				sendKeys(driver, connectionDBName, serviceDBName);

			} else {
				
				click(driver, clickonToggleButton);
				isDisplayed(driver, connectionFullUrl);

				click(driver, connectionFullUrl);

				clear(driver, connectionFullUrl);

				sendKeys(driver, connectionFullUrl, fullUrl);

			}
			if (connType.equals("System"))
			{
			isDisplayed(driver, connectionUsername);

			clear(driver, connectionUsername);

			click(driver, connectionUsername);

			sendKeys(driver, connectionUsername, userName);

			isDisplayed(driver, connectionPassword);

			clear(driver, connectionPassword);

			click(driver, connectionPassword);

			sendKeys(driver, connectionPassword, password);
			}
			else if (connType.equals("User")) {
				
				//displayAndClick(dropdownIconClick);
				isDisplayedInLoop(driver, 10,dropdownIconClick);
				click(driver,dropdownIconClick);
				//javascript(driver, "arguments[0].click();", selectUserType);
				click(driver,selectUserType);
				//SendKeys(driver,3, connectionTypeUser, "User");
				//click(driver,connectionTypeUser);
				//isDisplayedInLoop(driver, 10,connectionUsername);
				//click(driver,connectionUsername);
				displayAndClick(connectionUsername);
				clear_SendKeys(driver, connectionUsername, userName);

				BaseSuite.reportLog("Entering Connection User Name In UserName Field");

				displayAndClick(connectionPassword);
				clear_SendKeys(driver, connectionPassword, password);

				BaseSuite.reportLog("Entering Connection Password In Password Field");
			}
			
			
			/*if (!connProp.isEmpty()) {
				isDisplayed(driver, ConnectionConnProperties);

				clear(driver, ConnectionConnProperties);

				click(driver, ConnectionConnProperties);

				sendKeys(driver, ConnectionConnProperties, connProp);
			}
*/
			

			//displayAndClick(ConnectionName);

			/*if (connType.equals("User Connection") || connType.equals("User")) {

				isDisplayed(driver, ConnectionUserName);

				clear(driver, ConnectionUserName);

				click(driver, ConnectionUserName);

				sendKeys(driver, ConnectionUserName, userName);

				isDisplayed(driver, ConnectionPassword);

				clear(driver, ConnectionPassword);

				click(driver, ConnectionPassword);

				sendKeys(driver, ConnectionPassword, password);

			}
*/
		}
		
		public void continueNext(String SheetName,ExtentTest test, int ruleNumber,
				String errorMsg, Logger log, String columnName, String methodName,String fileName)
				 {

			try {
				BaseClassUtil util = new BaseClassUtil();
				
				XLUtils xl = new XLUtils();
				
				//LoginPage login = new LoginPage(driver);

				//String ruleName = xl.ReadUsingColName(fileName, SheetName, ruleNumber, connNameCol);// get the rule name from excel
				
				xl.writeToExcel("Fail", fileName, SheetName, ruleNumber, columnName);// write the excel as fail into the status
				
				//test.error("Connection Name " + ruleName + " with Connection number " + ruleNumber + " failed");// log the error in extent
																									// report

				test.error(errorMsg);// Log the exception in extent report

				String screenshotPath = util.takeScreenshotAtEndOfTest(methodName, driver);// pass the class name as screen shot

				//test.addScreenCaptureFromBase64String(screenshotPath);// log the screen shot in extent report
				
				test.log(Status.FAIL,methodName, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());

				log.debug(errorMsg);// also log this error into application log

				
				/*
				 * adminPage.clickOnConnectionTab(driver);// click on rule side panel
				 * 
				 * if(isDisplayed(driver, ConnectionDiscardYesButton)) {
				 * 
				 * displayAndClick(ConnectionDiscardYesButton);// we have to click on yes button
				 * to discard changed if this message appears
				 * 
				 * }
				 * 
				 * login.logout();
				 * 
				 * log.debug("Rule number " + ruleNumber + " failed");// log the rule number
				 * into log
				 */
				 			} catch (Exception e) {
				
				e.getMessage();
				
			}

		}

		public void mandatoryField(SoftAssert soft,String connectionType,String connFormat,String SpecialChar,String connectionName,
				String host,String port,String serviceDBName,String fullUrl,String userName,String password,String connProp,String connType,String portdata) throws Exception {
				
			BaseSuite.reportLog("Check Workspace Name field Label");
			isDisplayed(driver, workspaceLabel);
			BaseSuite.reportLog("Workspace field Label displayed successfully");

			BaseSuite.reportLog("Check connection Name field Label");
			isDisplayed(driver, connectionLabel);
			BaseSuite.reportLog("connection field Label displayed successfully");
			
			BaseSuite.reportLog("Check driver Name field Label");
			isDisplayed(driver, driverLabel);
			BaseSuite.reportLog("Driver field Label displayed successfully");
			
			BaseSuite.reportLog("Check authentication Name field Label");
			isDisplayed(driver, authenticationLabel);
			BaseSuite.reportLog("Authentication field Label displayed successfully");
			
			BaseSuite.reportLog("Check CustomJDBC url Name field Label");
			isDisplayed(driver, customJDBCLabel);
			BaseSuite.reportLog("CustomJDBC url field Label displayed successfully");
			
			BaseSuite.reportLog("Check Host field Label");
			isDisplayed(driver, hostLabel);
			BaseSuite.reportLog("Host field Label displayed successfully");
			
			BaseSuite.reportLog("Check Port field Label");
			isDisplayed(driver, portLabel);
			BaseSuite.reportLog("port field Label displayed successfully");

			BaseSuite.reportLog("Check ServiceDBName field Label");
			isDisplayed(driver, databaseLabel);
			BaseSuite.reportLog("ServiceDBName field Label displayed successfully");

			BaseSuite.reportLog("Check type field Label");
			isDisplayed(driver, typeLabel);
			BaseSuite.reportLog("Type field Label displayed successfully");

			BaseSuite.reportLog("Check UserName field Label");
			isDisplayed(driver, usernameLabel);
			BaseSuite.reportLog("UserName field Label displayed successfully");

			BaseSuite.reportLog("Check Password field Label");
			isDisplayed(driver, passwordLabel);
			BaseSuite.reportLog("Password field Label displayed successfully");

			BaseSuite.reportLog("Check connection name property field Label");
			isDisplayed(driver, connPropertyNameLabel);
			BaseSuite.reportLog("Connection name property field Label displayed successfully");

			BaseSuite.reportLog("Check connection property value field Label");
			isDisplayed(driver, connPropertyValueLabel);
			BaseSuite.reportLog("connection property value field Label display successfully");

			BaseSuite.reportLog("Check connection property type field Label");
			isDisplayed(driver, connPropertyTypeLabel);
			BaseSuite.reportLog("connection property type field Label display successfully");

			
			if (!connectionName.isEmpty()) {

				if (SpecialChar.equalsIgnoreCase("Yes")) {

					BaseSuite.reportLog("Clicking on connection name ");

					displayAndClick(ConnectionName);

					BaseSuite.reportLog("Entering Connection Name In Connection Name Field");

					sendKeys(driver, ConnectionName, connectionName);

					BaseSuite.reportLog("Check Error message with invalid Connection name ");

					String ConnectionNameErrmsg = getText(driver, connectionNameErrorMsg).trim();

					soft.assertEquals(ConnectionNameErrmsg, connErrorMessage,
							"Failed at to connection name field error message");

				}

				else {

					BaseSuite.reportLog("Clicking on connection name ");
					displayAndClick(ConnectionName);

					BaseSuite.reportLog("Entering Connection Name In Connection Name Field");

					sendKeys(driver, ConnectionName, connectionName);

					BaseSuite.reportLog("Connection Name added successfully");

				}

			}

			if (!host.isEmpty()) {

				BaseSuite.reportLog("Clicking on Connection Host Field");

				displayAndClick(connectionHost);

				BaseSuite.reportLog("Entering Connection Host In Host Field");

				sendKeys(driver, connectionHost, host);

			}

			if (!port.isEmpty()) {

				if (portdata.contains("number")) {

					BaseSuite.reportLog("Clicking on Connection Port Field");
					displayAndClick(connectionPort);

					BaseSuite.reportLog("Entering Connection Port In Port Field");

					sendKeys(driver, connectionPort, port);

				} else if (!port.isEmpty()) {

					BaseSuite.reportLog("Entering Connection Port In Port Field");

					sendKeys(driver, connectionPort, port);

					BaseSuite.reportLog("Check Error message with invalid port");

					//String Errmsg = getText(driver, portErrmsg).trim();

					//soft.assertEquals(Errmsg, portErrorMsg, "Failed to validate Port field error message");

				}

			}

			if (!serviceDBName.isEmpty()) {

				BaseSuite.reportLog("Clicking on Connection DB Field");
				displayAndClick(connectionDBName);

				BaseSuite.reportLog("Entering Connection DB Name In DB Field");

				sendKeys(driver, connectionDBName, serviceDBName);

			}
				
				if (!fullUrl.isEmpty()) {

					if (host.isEmpty() && port.isEmpty() && serviceDBName.isEmpty()) {
						
						click(driver, clickonToggleButton);
						
						isDisplayed(driver, connectionFullUrl);

						// click(driver, ConnectionFullUrl);

						clear_Click_SendKeys(driver, 5, connectionFullUrl, fullUrl);

						BaseSuite.reportLog("Clicking on Connection Full Url Field");

						// sendKeys(driver, ConnectionFullUrl, fullUrl);

						BaseSuite.reportLog("Entering Connection Full Url In Full Url Field");

					}

					else {
						BaseSuite.validationReportLog("Custom JDBC url option is disabled");

					}

				}
				
				if (!connType.equals("System")) {

					visible(driver, dropdownIconClick);
					//displayAndClick(dropdownIconClick);
					isDisplayedInLoop(driver, 10,dropdownIconClick);
					click(driver,dropdownIconClick);
					//javascript(driver, "arguments[0].click();", selectUserType);
					click(driver,selectUserType);
					BaseSuite.reportLog("Clicking on Connection User option");
				}
				
				if (connType.equals("User Connection") || connType.equals("User")) {

					BaseSuite.reportLog("Entering Connection User Name In UserName Field");

					clear_SendKeys(driver, connectionUsername, userName);

					BaseSuite.reportLog("Entering Connection Password In Password Field");

					clear_SendKeys(driver, connectionPassword, password);
				}
				
				if (!userName.isEmpty()) {
					BaseSuite.reportLog("Clicking on Connection User Name Field");
					displayAndClick(connectionUsername);
					BaseSuite.reportLog("Entering Connection User Name In User Name Field");
					sendKeys(driver, connectionUsername, userName);

				}

				if (!password.isEmpty()) {

					BaseSuite.reportLog("Clicking on Connection Password Field");
					displayAndClick(connectionPassword);
					BaseSuite.reportLog("Entering Connection Password In Password Field");
					sendKeys(driver, connectionPassword, password);
				}
				
				/*
				 * if (!connProp.isEmpty()) {
				 * 
				 * BaseSuite.reportLog("Clicking on Connection Properties Field");
				 * displayAndClick(ConnectionConnProperties);
				 * BaseSuite.reportLog("Entering Connection Properties In Conn Properties Field"
				 * ); sendKeys(driver, ConnectionConnProperties, connProp); }
				 */

				// conn type remaining
	

				

				/*
				 * ClickonConnectionsMenu();
				 * 
				 * BaseSuite.reportLog("Verify discard Message");
				 * 
				 * String discardmsg1 = getText(driver, discardmsg).trim();
				 * 
				 * soft.assertEquals(discardmsg1, DiscardMsgVerify.trim());
				 * 
				 * isDisplayed(driver, yesbtn);
				 * 
				 * BaseSuite.reportLog("Clicking on Yes button");
				 * 
				 * isDisplayedInLoop(driver, 20, yesbtn);
				 * 
				 * click(driver, yesbtn);
				 */
			}

		}
	

