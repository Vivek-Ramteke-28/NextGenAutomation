package nexgen.automation.framework.connectionRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;

public class UserConnectionsHome extends PageUtil {

WebDriver driver;
	
	public UserConnectionsHome(WebDriver driver)
	{
		this.driver= driver;
	}
	XLUtils xlReader = new XLUtils();
	SoftAssert soft = new SoftAssert();
	
	By clickonUConnection = getElementLocator(prop.getProperty("UConnection.userConnection"));
	By clickonURefresh = getElementLocator(prop.getProperty("UConnection.URefresh"));
	By selectUallCheckbox = getElementLocator(prop.getProperty("UConnection.UallCheckbox"));
	By UsearchBar = getElementLocator(prop.getProperty("UConnection.USearchBox"));
	By UsearchBclick = getElementLocator(prop.getProperty("UConnection.USearchButton"));
	String ClickUsearchConnection = prop.getProperty("UConnection.USearchConnection");
	By ClickUHomeLink = getElementLocator(prop.getProperty("UConnection.UHomeLink"));
	
	public void ValidateUButtons() {
		try {
			isDisplayedInLoop(driver, 3, clickonUConnection);

			if (isEnabled(driver, clickonUConnection)) {
				Thread.sleep(3000);
				click(driver, clickonUConnection);
				BaseSuite.validationReportLog("Tab is enabled and user able to click on the user connection tab");
			} else {
				BaseSuite.reportLog("Tab is disabled hence user not able to click on the user connection tab");
			}

			if (isEnabled(driver, clickonURefresh)) {
				click(driver, selectUallCheckbox);
				click(driver, clickonURefresh);

				List<WebElement> listcheck = driver.findElements(By.xpath("//input[@type='checkbox']"));
				int count = listcheck.size();
				BaseSuite.validationReportLog("Number of connections are:" + count);
				if (!isSelected(driver, selectUallCheckbox) && listcheck.size() == count) {
					BaseSuite.validationReportLog("Refresh button is clickable and working according to the function");
				}
				
			} else {
				BaseSuite.reportLog("Refresh button is not clickable and not working according to the function ");
			}
		} catch (Exception e) {
			throw new AssertionError("All buttons are disabled", e);
		}

	}
	
	public void SearchUConnection(String Connection_search) throws Exception
	{
		
			isDisplayed(driver, clickonUConnection);
			click(driver, clickonUConnection);
			
			BaseSuite.reportLog("Searching for Connection:" + Connection_search);
			isDisplayedInLoop(driver, 10, UsearchBar);
			Thread.sleep(3000);
			click(driver, UsearchBar);
			clear(driver, UsearchBar);

			isDisplayedInLoop(driver, 4, UsearchBar);
			BaseSuite.reportLog("Search User Connection");
			sendKeys(driver, UsearchBar, Connection_search);
			BaseSuite.reportLog("Click On searched");

			isDisplayedInLoop(driver, 3, UsearchBclick);
			click(driver, UsearchBclick);

			try {

				isDisplayedInLoop(driver, 4, UsearchBclick);

				BaseSuite.reportLog("Click on Searched User");

				click(driver, returnElement(ClickUsearchConnection, "$Connection", Connection_search));
				BaseSuite.reportLog("Clicked on User: " + Connection_search);
				BaseSuite.reportLog("User Details retrieved successfully for user " + Connection_search);

			} catch (Exception e) {
				throw new Exception("User_search " + UsearchBclick + " not found");
			}
		}
	
	public boolean UConnectionRowsAndColumns() {

		isDisplayed(driver, clickonUConnection);
		click(driver, clickonUConnection);

		// No.of Columns
		List col = driver.findElements(By.xpath("//span[@class='e-headertext']"));

		System.out.println("No of cols are : " + col.size());

		// No.of rows
		List rows = driver.findElements(By.xpath("//tr//span[@class='e-frame e-icons']"));

		System.out.println("No of rows are : " + rows.size());

		return true;

	}
	
	public void UConnectionHomeLink() {
		isDisplayed(driver, clickonUConnection);
		click(driver, clickonUConnection);

		if (isDisplayed(driver, ClickUHomeLink)) {
			click(driver, ClickUHomeLink);
			//isDisplayedInLoop(driver, 10, AdministrationLabel);
			//click(driver, AdministrationLabel);
			BaseSuite.reportLog("Home Link is displayed and clickable--Navigation to Home link from connection is working");
		} else {
			BaseSuite.reportFailLog("Home Link is not displayed and clickable", "ConnectionHomeLink");
		}
	}

}
