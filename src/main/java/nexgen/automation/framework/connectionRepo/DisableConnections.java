package nexgen.automation.framework.connectionRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;

public class DisableConnections extends PageUtil{

	
WebDriver driver;
	
	public DisableConnections(WebDriver driver)
	{
		this.driver= driver;
	}
	XLUtils xlReader = new XLUtils();
	SoftAssert soft = new SoftAssert();
	
	By clickonNewConnection = getElementLocator(prop.getProperty("Connection.newConnection"));
	By clickonConnectionMenu = getElementLocator(prop.getProperty("Connection.connections"));
	By searchBar = getElementLocator(prop.getProperty("Connection.SearchBox"));
	By searchBclick = getElementLocator(prop.getProperty("Connection.SearchButton"));
	String clickonSearchConnection = prop.getProperty("Connection.SearchConnection");
	By clickonDisable = getElementLocator(prop.getProperty("Connection.disable"));
	By clickonDisableYes = getElementLocator(prop.getProperty("Connection.disableYes"));
	
	
	public void ClickonConnectionsMenu() 
	{
		isDisplayedInLoop(driver ,40 , clickonConnectionMenu);
		//click(driver,clickonConnectionMenu);
		
		javascript(driver, "arguments[0].click();", clickonConnectionMenu);
	}
	
	public void DisableExistingConnection(String Connection_search) throws Exception
	{
			ClickonConnectionsMenu();		
						
			BaseSuite.reportLog("Searching for Connection:" + Connection_search);
			isDisplayedInLoop(driver, 10, searchBar);
			
			javascript(driver, "arguments[0].click();", searchBar);
			//click(driver, searchBar);
			clear(driver, searchBar);

			isDisplayedInLoop(driver, 4, searchBar);
			BaseSuite.reportLog("Search Connection");
			sendKeys(driver, searchBar, Connection_search);
			BaseSuite.reportLog("Click On searched");

			isDisplayedInLoop(driver, 3, searchBclick);
			//Thread.sleep(3000);
			javascript(driver, "arguments[0].click();", searchBclick);
			//click(driver, searchBclick);

			try {

				isDisplayedInLoop(driver, 4, searchBclick);
				if (Connection_search.contains(Connection_search)) {

					click(driver, returnElement(clickonSearchConnection, "$Connection", Connection_search));
					BaseSuite.reportLog("Clicked on Connection: " + Connection_search);
					BaseSuite
							.reportLog("Connection Details retrieved successfully for connection " + Connection_search);

					if (isEnabled(driver, clickonDisable)) {
						click(driver, clickonDisable);
						click(driver, clickonDisableYes);
						BaseSuite.validationReportLog("Connection disabled successfully");
					}
				} else {
					BaseSuite.reportLog("Searched connection is not available in the list:" + Connection_search);
				}
				List<WebElement> listcheck1 = driver.findElements(By.xpath("//span[@class='e-frame e-icons']"));
				BaseSuite.validationReportLog("Number of connections are:" + listcheck1.size());

				for (int i = 0; i <= listcheck1.size() - 7; i++) {
					listcheck1.get(i).click();
				}
				click(driver, clickonDisable);
				click(driver, clickonDisableYes);
				BaseSuite.validationReportLog("Multiple existing connections disabled successfully");

			} catch (Exception e) {
				throw new Exception("User_search " + searchBclick + " not found", e);
			}
		}
	}
