package nexgen.automation.framework.connectionRepo;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;

public class ConnectionHome extends PageUtil 
{
	WebDriver driver;
	
	public ConnectionHome(WebDriver driver)
	{
		this.driver= driver;
	}
	XLUtils xlReader = new XLUtils();
	SoftAssert soft = new SoftAssert();
	
	By ClickonDataConnection = getElementLocator(prop.getProperty("Connection.connectionLabel"));
	By pagelabel = getElementLocator(prop.getProperty("Connection.PageLabel"));
	
	By clickonNewConnection = getElementLocator(prop.getProperty("Connection.newConnection"));
	By clickonConnectionMenu = getElementLocator(prop.getProperty("Connection.connections"));
	By SelectAllcheckboxes = getElementLocator(prop.getProperty("Connection.allCheckbox"));
	By nameLable = getElementLocator(prop.getProperty("Connection.connectionNameLable"));
	By clickonRefresh = getElementLocator(prop.getProperty("Connection.refresh"));
	By clickonDisable = getElementLocator(prop.getProperty("Connection.disable"));
	By clickonDisableNo = getElementLocator(prop.getProperty("Connection.disableNo"));
	
	By searchBar = getElementLocator(prop.getProperty("Connection.SearchBox"));
	By searchBclick = getElementLocator(prop.getProperty("Connection.SearchButton"));
	String clickonSearchConnection = prop.getProperty("Connection.SearchConnection");
	
	By sideBarclick = getElementLocator(prop.getProperty("Connection.SideBarIcon"));
	By sideBarUser = getElementLocator(prop.getProperty("Connection.UserConnections"));
	
	By clickonHomeLink = getElementLocator(prop.getProperty("Connection.HomeLink"));
	
	By NumberofConnections = getElementLocator(prop.getProperty("Connection.NumberofConnections"));
	By PaginationCount = getElementLocator(prop.getProperty("Connection.Pagination"));
	
		public void ConnectionRepo()
		{
			try
			{
				isDisplayedInLoop(driver, 5, pagelabel);
				if(isDisplayed(driver, pagelabel))
			{
				click(driver, ClickonDataConnection);
				getWindowHandler(driver);
				waitForElement(driver, clickonConnectionMenu);
				BaseSuite.reportLog("clicked on Data Connections tab");
			}
			
			else
			{
				BaseSuite.reportLog("Not able to click on the Data Connections tab");
			}
			}
			
			catch(Exception e)
			{
				throw new AssertionError("User not able to navigate on Administration page", e);
			}
		}
		
		public void ValidateButtons() 
		{
			try
			{
				isDisplayedInLoop(driver, 3, clickonConnectionMenu);
				click(driver,clickonConnectionMenu);
				if(isEnabled(driver,clickonNewConnection))
				{
					Thread.sleep(3000);
					click(driver,clickonNewConnection);
					click(driver,clickonConnectionMenu);
					BaseSuite.validationReportLog("Button is enabled and user able to click on the new connection button");
				}
				else {
					BaseSuite.reportLog("Button is disabled hence user not able to click on the new connection button");
				}
				
				if(isEnabled(driver,clickonRefresh))
				{
					click(driver, SelectAllcheckboxes);
					click(driver,clickonRefresh);
					
					List<WebElement> listcheck = driver.findElements(By.xpath("//input[@type='checkbox']"));
					int count = listcheck.size();				
					BaseSuite.validationReportLog("Number of connections are:" + count);		
					if(!isSelected(driver, SelectAllcheckboxes)&&listcheck.size()==count)
					{
						BaseSuite.validationReportLog("Refresh button is clickable and working according to the function");
					}
				}
				else {
					BaseSuite.reportLog("Refresh button is not clickable and not working according to the function ");
				}
				
				if(!isEnabled(driver,clickonDisable))
				{
					BaseSuite.validationReportLog("Disable button is not clickable before the selection of connection ");
				}
				else
				{
					BaseSuite.reportLog("Disable button should not be enable without any selection of group");
				}
				
				List<WebElement> listcheck1 = driver.findElements(By.xpath("//span[@class='e-frame e-icons']"));
				for (int i = 0; i <= listcheck1.size()-4; i++) {
						listcheck1.get(i).click();
					if(isEnabled(driver, clickonDisable))
					{
						click(driver, clickonDisable);
						click(driver,clickonDisableNo);	
						BaseSuite.validationReportLog("Disable button is enabled and working according to the function");
						break;
					}
				}
			}
			
			catch(Exception ex)
			{
				throw new AssertionError("All buttons are disabled", ex);
			}
			
		}
		
		public void SearchConnection(String Connection_search) throws Exception
		{
			
				isDisplayed(driver, clickonConnectionMenu);
				click(driver, clickonConnectionMenu);
				
				BaseSuite.reportLog("Searching for Connection:" + Connection_search);
				isDisplayedInLoop(driver, 10, searchBar);
				Thread.sleep(3000);
				click(driver, searchBar);
				clear(driver, searchBar);

				isDisplayedInLoop(driver, 4, searchBar);
				BaseSuite.reportLog("Search Connection");
				sendKeys(driver, searchBar, Connection_search);
				BaseSuite.reportLog("Click On searched");

				isDisplayedInLoop(driver, 3, searchBclick);
				click(driver, searchBclick);

				try {

					isDisplayedInLoop(driver, 4, searchBclick);

					BaseSuite.reportLog("Click on Searched User");

					click(driver, returnElement(clickonSearchConnection, "$Connection", Connection_search));
					BaseSuite.reportLog("Clicked on User: " + Connection_search);
					BaseSuite.reportLog("User Details retrieved successfully for user " + Connection_search);

				} catch (Exception e) {
					throw new Exception("User_search " + searchBclick + " not found");
				}
			}
		
		public boolean ConnectionRowsAndColumns() {

			isDisplayed(driver, clickonConnectionMenu);
			click(driver, clickonConnectionMenu);

			// No.of Columns
			List col = driver.findElements(By.xpath("//span[@class='e-headertext']"));

			System.out.println("No of cols are : " + col.size());

			// No.of rows
			List rows = driver.findElements(By.xpath("//tr//span[@class='e-frame e-icons']"));

			System.out.println("No of rows are : " + rows.size());

			return true;

		}
		
		public void ConnectionSideBar() {
			isDisplayed(driver, sideBarclick);
			click(driver, sideBarclick);
			BaseSuite.reportLog("Click on the side bar to close the side bar!");
			if ((isDisplayed(driver, clickonConnectionMenu)) && (isDisplayed(driver, sideBarUser)))
			{
				BaseSuite.reportLog("Side bar details are displayed properly in the Connection Page!");
				click(driver, sideBarclick);
				BaseSuite.reportLog("Click on the side bar to open the side bar!");

				if ((isDisplayed(driver, clickonConnectionMenu)) && (isDisplayed(driver, sideBarUser))) {
					BaseSuite.validationReportLog("Side Bar of user page!");
					BaseSuite.reportLog("Opening and closing of side bar is working and displaying the Users/Groups/Roles/Accounts/Workspace Menus!");
				}

			} else {
				BaseSuite.reportFailLog("Side bar details are not displayed properly in the User Page!", "ConnectionSideBar");
			}
		}
		
		public void ConnectionHomeLink() {
			isDisplayed(driver, clickonConnectionMenu);
			click(driver, clickonConnectionMenu);

			if (isDisplayed(driver, clickonHomeLink)) {
				click(driver, clickonHomeLink);
				//isDisplayedInLoop(driver, 10, AdministrationLabel);
				//click(driver, AdministrationLabel);
				BaseSuite.reportLog("Home Link is displayed and clickable--Navigation to Home link from connection is working");
			} else {
				BaseSuite.reportFailLog("Home Link is not displayed and clickable", "ConnectionHomeLink");
			}
		}

		public void numberOfConnectionsAndPagination() throws InterruptedException
		{
			isDisplayed(driver, clickonConnectionMenu);
			click(driver, clickonConnectionMenu);
			
			isDisplayedInLoop(driver, 10, NumberofConnections);
			Thread.sleep(3000);
			String numbers = getText(driver, NumberofConnections);
			
			System.out.println("Number of connections in the list are "+numbers);
			BaseSuite.validationReportLog("Number of connections are displaying in the User Page!");
			BaseSuite.reportLog("Available connections " +numbers );
			
			paginationInsearchfield(driver, PaginationCount);
			
			
		}
		
		
	}
