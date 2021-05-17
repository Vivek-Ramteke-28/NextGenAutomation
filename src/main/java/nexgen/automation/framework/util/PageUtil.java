package nexgen.automation.framework.util;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;

public class PageUtil {

	public static WebDriverWait wait;

	protected static final Properties prop = new Properties();

	public static String splitArea1 = "";

	public static String splitArea2 = "";

	public static String splitArea3 = "";
	SoftAssert softAssert = new SoftAssert();

	static final Logger log = Logger.getLogger(PageUtil.class);

	public static void beforesuite() {

		File folder = new File(System.getProperty("user.dir") + "/src/main/resources/locator/");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				log.info("File " + listOfFiles[i].getName());

				Properties prop2 = new Properties();

				File src = new File(
						System.getProperty("user.dir") + "/src/main/resources/locator/" + listOfFiles[i].getName());

				try {
					FileInputStream fis = new FileInputStream(src);
					prop2.load(fis);

					prop.putAll(prop2);
				} catch (Exception e) {
					log.info("Exception is " + e.getMessage());

				}

			} else if (listOfFiles[i].isDirectory()) {
				log.info("Directory " + listOfFiles[i].getName());
			}
		}

		splitArea1 = prop.getProperty("SplitArea1");

		splitArea2 = prop.getProperty("SplitArea2");

		splitArea3 = prop.getProperty("SplitArea3");

	}

	public String readConfig(String key) {
		return prop.getProperty(key);
	}

	public By getElementLocator(String locator) {

		By element = null;

		try {
			String[] result = locator.split("~~");

			String locatortype = result[0];

			String locatorValue = result[1];

			switch (locatortype.toLowerCase()) {
			case "xpath":

				element = By.xpath(locatorValue);

				break;

			case "id":

				element = By.id(locatorValue);

				break;

			case "css":

				element = By.cssSelector(locatorValue);

				break;

			case "name":

				element = By.name(locatorValue);

				break;

			case "classname":

				element = By.className(locatorValue);
				break;

			case "linktext":

				element = By.linkText(locatorValue);
				break;

			case "partiallinktext":

				element = By.partialLinkText(locatorValue);
				break;

			case "tagname":

				element = By.tagName(locatorValue);
				break;
			default:
				break;
			}
		} catch (Exception e) {

			log.error(e.getMessage());
		}

		return element;

	}

	public By concate(String locator1, String locator2) {

		try {
			String[] result1 = locator1.split("~~");

			String locatorValue1 = result1[1];

			String[] result2 = locator2.split("~~");

			String locatorValue2 = result2[1];

			String finalLocator = locatorValue1 + locatorValue2;

			By locator = By.xpath(finalLocator);

			return locator;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new IllegalArgumentException("Failed in concate()");
		}

	}

	public boolean isDisplayed(WebDriver driver, By locator) {

		try {
			wait = waitMethod(driver);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator)).isDisplayed();
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}
	}

	public boolean isEnabled(WebDriver driver, By locator) {

		try {
			wait = waitMethod(driver);
			return wait.until(ExpectedConditions.elementToBeClickable(locator)).isEnabled();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in isEnabled() for locator" + locator);
		}
	}

	public boolean isSelected(WebDriver driver, By locator) {

		try {
			wait = waitMethod(driver);
			return wait.until(ExpectedConditions.elementToBeClickable(locator)).isSelected();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in isSelected() for locator" + locator);
		}
	}

	public void click(WebDriver driver, By locator) {

		try {
			wait = waitMethod(driver);
			wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in click() for locator " + locator);
		}
	}

	public String getText(WebDriver driver, By locator) {

		try {
			String resulttring = null;
			wait = waitMethod(driver);
			resulttring = wait.until(ExpectedConditions.elementToBeClickable(locator)).getText();
			return resulttring;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in getText() for locator " + locator);
		}

	}

	public void clear(WebDriver driver, By locator) {

		try {
			wait = waitMethod(driver);
			wait.until(ExpectedConditions.elementToBeClickable(locator)).clear();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in clear() for locator " + locator);
		}
	}

	public void visible(WebDriver driver, By locator) {

		try {
			wait = waitMethod(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ElementNotVisibleException("Failed in visible() for locator " + locator);
		}

	}
	
	public void clear_SendKeys(WebDriver driver, By locator, String keysToSend) {

		try {

			isDisplayed(driver, locator);

			clear(driver, locator);

			isDisplayed(driver, locator);

			sendKeys(driver, locator, keysToSend);

		} catch (Exception e) {
			BaseSuite.log.error(e.getMessage());
			// BaseSuite.reportLog(e.getMessage());
			throw new NoSuchElementException("Failed in sendkeys() for locator " + locator);
		}

	}

	public void visible(WebDriver driver, By locator, int time) {

		WebDriverWait ewait = new WebDriverWait(driver, time);
		ewait.ignoring(NoSuchElementException.class);
		ewait.ignoring(StaleElementReferenceException.class);
		ewait.ignoring(ElementClickInterceptedException.class);

		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ElementNotVisibleException("Failed in visible() for locator " + locator);
		}
	}

	public void inVisible(WebDriver driver, By locator) {

		try {
			wait = waitMethod(driver);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in inVisible() for locator " + locator);
		}
	}

	public void inVisible(WebDriver driver, By locator, int time) {

		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(ElementClickInterceptedException.class);

		try {

			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in inVisible() for locator " + locator);
		}
	}

	public void sendKeys(WebDriver driver, By locator, String keysToSend) {
		try {
			wait = waitMethod(driver);

			wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(keysToSend);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in sendkeys() for locator " + locator);
		}
	}

	public void selectByVisibleText(WebDriver driver, By locator, String text) {

		try {
			wait = new WebDriverWait(driver, Constant.LONGW);
			Select select = new Select(wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator))));
			select.selectByVisibleText(text);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in selectByVisibleText() for locator" + locator);
		}

	}

	public void selectByValue(WebDriver driver, WebElement locator, String text) {

		try {
			wait = new WebDriverWait(driver, Constant.LONGW);
			Select select = new Select(wait.until(ExpectedConditions.visibilityOf(locator)));
			select.selectByValue(text);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in selectByValue() for locator" + locator);
		}

	}

	public WebDriverWait waitMethod(WebDriver driver) {

		wait = new WebDriverWait(driver, Constant.SHOTW);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(ElementClickInterceptedException.class);

		return wait;

	}

	public void dragAndDrop(WebDriver driver, String sourceObjectValue, String destinationObjectValue) {

		try {
			By sourceObject = getElementLocator(sourceObjectValue);

			By destinationObject = getElementLocator(destinationObjectValue);

			WebElement sourceElement = wait.until(ExpectedConditions.elementToBeClickable(sourceObject));
			WebElement destinationElement = wait.until(ExpectedConditions.elementToBeClickable(destinationObject));

			((JavascriptExecutor) driver).executeScript(
					getJsDndHelper() + "simulateDragDrop(arguments[0], arguments[1])", sourceElement,
					destinationElement);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in dragAndDrop() for sourceObjectValue" + sourceObjectValue);

		}
	}

	private String getJsDndHelper() {

		String script = "function simulateDragDrop(sourceNode, destinationNode) {\r\n" + "var EVENT_TYPES = {\r\n"
				+ "DRAG_END: 'dragend',\r\n" + "DRAG_START: 'dragstart',\r\n" + "DROP: 'drop'\r\n" + "}\r\n" + " \r\n"
				+ "function createCustomEvent(type) {\r\n" + "var event = new CustomEvent(\"CustomEvent\")\r\n"
				+ "event.initCustomEvent(type, true, true, null)\r\n" + "event.dataTransfer = {\r\n" + "data: {\r\n"
				+ "},\r\n" + "setData: function(type, val) {\r\n" + "this.data[type] = val\r\n" + "},\r\n"
				+ "getData: function(type) {\r\n" + "return this.data[type]\r\n" + "}\r\n" + "}\r\n"
				+ "return event\r\n" + "}\r\n" + " \r\n" + "function dispatchEvent(node, type, event) {\r\n"
				+ "if (node.dispatchEvent) {\r\n" + "return node.dispatchEvent(event)\r\n" + "}\r\n"
				+ "if (node.fireEvent) {\r\n" + "return node.fireEvent(\"on\" + type, event)\r\n" + "}\r\n" + "}\r\n"
				+ " \r\n" + "var event = createCustomEvent(EVENT_TYPES.DRAG_START)\r\n"
				+ "dispatchEvent(sourceNode, EVENT_TYPES.DRAG_START, event)\r\n" + " \r\n"
				+ "var dropEvent = createCustomEvent(EVENT_TYPES.DROP)\r\n"
				+ "dropEvent.dataTransfer = event.dataTransfer\r\n"
				+ "dispatchEvent(destinationNode, EVENT_TYPES.DROP, dropEvent)\r\n" + " \r\n"
				+ "var dragEndEvent = createCustomEvent(EVENT_TYPES.DRAG_END)\r\n"
				+ "dragEndEvent.dataTransfer = event.dataTransfer\r\n"
				+ "dispatchEvent(sourceNode, EVENT_TYPES.DRAG_END, dragEndEvent)\r\n" + "}";
		return script;

	}

	public By returnElement(String dynamiclocator, String stringToBeReplaced, String dynamicValue) {

		try {
			String[] dynamiclocatorloca = dynamiclocator.split("~~");

			String locator = dynamiclocatorloca[1];

			return By.xpath(locator.replace(stringToBeReplaced, dynamicValue));

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in returnElement()");
		}
	}

	public String returnScript(String dynamiclocator, String stringToBeReplaced, String dynamicValue) {

		try {
			return dynamiclocator.replace(stringToBeReplaced, dynamicValue);

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in returnScript()");
		}
	}

	public void javascript(WebDriver driver, String script) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(script);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in javascript()");
		}

	}

	public void javascript(WebDriver driver, String script, By Locator) {

		try {
			WebElement elem = driver.findElement(Locator);

			((JavascriptExecutor) driver).executeScript(script, elem);
			
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in javascriptScroll()");

		}

	}

	public By concateAndReplace(String dynamiclocator1, String dynamiclocator2, String stringToBeReplaced,
			String dynamicValue) {
		try {

			String[] result1 = dynamiclocator1.split("~~");

			String locatorValue1 = result1[1];

			String[] result2 = dynamiclocator2.split("~~");

			String locatorValue2 = result2[1];

			String finalLocator = locatorValue1 + locatorValue2;

			By elem = By.xpath(finalLocator.replace(stringToBeReplaced, dynamicValue));

			return elem;

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in concateAndReplace()");
		}
	}

	public void moveToElement(WebDriver driver, By locator) {

		Actions action = new Actions(driver);

		WebElement elem = driver.findElement(locator);

		action.moveToElement((elem)).build().perform();
	}

	public void moveToElementBackSpace(WebDriver driver, By locator) {

		wait = waitMethod(driver);

		Actions action = new Actions(driver);

		WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));

		action.moveToElement((elem)).sendKeys(Keys.BACK_SPACE).build().perform();
	}

	/**
	 * getcount
	 * 
	 * get count of the splitters
	 * 
	 * @param string
	 * @param type
	 * 
	 */
	public int getcount(String string, char type) {
		int commas = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == type)
				commas++;
		}

		return commas;

	}

	/*
	 * testCaseStatus
	 * 
	 * This method should be called for every rule script to check the test case
	 * status flag and it will also mark the script as failed if flag is greater
	 * than one
	 * 
	 * @param testCaseStatus
	 * 
	 * @param log
	 * 
	 */
	public void testCaseStatus(int testCaseStatus, Logger log) {

		if (testCaseStatus > 1) {// if the testCaseStatus flag is greater than one then it will mark the test
									// case as failed with a message.

			boolean testCaseFail = true;

			Assert.assertFalse(testCaseFail, "---Script failed due to some data creation/updation failed---");

			log.info("Script failed due to some data creation/updation failed");

		}

	}

	public void slider(WebDriver driver, By locator, Keys keys) {

		wait = waitMethod(driver);

		Actions action = new Actions(driver);

		action.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator))))
				.sendKeys(keys).build().perform();

	}

	public void verifyText(WebDriver driver, By verifyMsgLocator, String msgToBeVerified) {
		String msgText = getText(driver, verifyMsgLocator);

		if (!msgText.isEmpty()) {
			softAssert.assertEquals(msgText, msgToBeVerified, "Messages did'nt match");

			BaseSuite.reportLog("verified the message " + msgToBeVerified);
		}
	}

	public void isDisplayedInLoop(WebDriver driver, int count, By locator) {

		for (int i = 0; i <= count; i++) {

			if ((isDisplayed(driver, locator)) || (i == count))
				break;
		}
	}

	public void isDisplayedInPage(WebDriver driver, String message) {
		try {
			while (isAvailableInPage(driver, message)) {
				Thread.sleep(200);
			}
		} catch (Exception e) {
		}

	}

	public boolean isAvailableInPage(WebDriver driver, String message) {
		boolean flag = false;
		try {
			flag = driver.getPageSource().contains(message);
		} catch (Exception e) {
		}

		return flag;
	}

	public void javaScriptClick(WebDriver driver, By locator) {

		try {
			WebElement elem = driver.findElement(locator);

			((JavascriptExecutor) driver).executeScript("arguments[0]).click();", elem);

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in javascriptGetText()");
		}
	}

	public String getBrowserName(WebDriver driver) {
		String browserName = null;
		try {
			WrapsDriver wrapperAccess = (WrapsDriver) driver;
			WebDriver edriver = wrapperAccess.getWrappedDriver();
			Capabilities cap = ((RemoteWebDriver) edriver).getCapabilities();
			browserName = cap.getBrowserName().toLowerCase();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return browserName;
	}

	public void getColumnNames(String filename) {
		try (FileInputStream fis = new FileInputStream(new File(filename));
				XSSFWorkbook workbook = new XSSFWorkbook(fis);) {
			XSSFSheet spreadsheet = workbook.getSheetAt(0);

			int lastcell = spreadsheet.getRow(0).getLastCellNum();

			for (int i = 0; i <= lastcell; i++) {

				log.info(spreadsheet.getRow(0).getCell(i).getRichStringCellValue().toString());

			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	public String getAttribute(WebDriver driver, By locator, String attribute) {

		try {
			String resulttring = null;
			wait = waitMethod(driver);
			resulttring = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getAttribute(attribute);
			return resulttring;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in getAttribute() for locator " + locator);
		}

	}

	public String javaScriptGetText(WebDriver driver, String script) {

		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;

			String text = (String) js.executeScript(script);

			return text;

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in javaScriptGetText()");

		}

	}

	public void waitForElement(WebDriver driver, By locator) {

		try {
			wait = new WebDriverWait(driver, Constant.LONGW);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in waitForElement() for locator " + locator);
		}

	}

	public List<WebElement> getElements(WebDriver driver, By locator) {
		List<WebElement> results = null;
		try {
			results = driver.findElements(locator);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NoSuchElementException("Failed in getElements() for locator " + locator);
		}
		return results;

	}

	public WebElement getElement(WebDriver driver, By locator) {
		WebElement results = null;
		try {

			wait = new WebDriverWait(driver, Constant.LONGW);

			results = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));

		} catch (Exception e) {

			log.error(e.getMessage() + "Failed in getElement() for locator " + locator);

		}
		return results;

	}

	public void clear_Click_SendKeys(WebDriver driver, int count, By locator, String keysToSend) {

		try {

			isDisplayedInLoop(driver, count, locator);

			clear(driver, locator);

			isDisplayedInLoop(driver, count, locator);

			click(driver, locator);

			isDisplayedInLoop(driver, count, locator);

			sendKeys(driver, locator, keysToSend);

		} catch (Exception e) {
			BaseSuite.log.error(e.getMessage());
			// BaseSuite.reportLog(e.getMessage());
			throw new NoSuchElementException("Failed in sendkeys() for locator " + locator);
		}

	}

	public void paginationInsearchfield(WebDriver driver, By locator) {

		try {

			List<WebElement> p = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(locator)));
// checkif pagination link exists 

			System.out.println(p.size());

			if (p.size() > 0) {
				System.out.println("pagination exists");

// click on pagination link 

				for (int i = 0; i < p.size(); i++) {

					System.out.println(p.get(i));
					p.get(i).click();
				}
			} else {
				System.out.println("pagination not exists");
			}

		} catch (Exception e) {
			throw new NoSuchElementException("Failed in pagination");
		}

	}
	
	public void paginationAllSymbol(WebDriver driver, By locator1, By locator2)
	{
		try {
			
			List<WebElement> p = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(locator1)));
		
		System.out.println(p.size());
		
		if (p.size() > 0) {
			System.out.println("pagination exists");

			for (int i = 0; i < p.size(); i++) {

				System.out.println(p.get(i));
				Thread.sleep(2000);
				BaseSuite.reportLog("Try to click on pagination icon");
				p.get(i).click();
			}
		}
		
		List<WebElement> q = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(locator2)));
		System.out.println(q.size());
			 if(q.size() >0)
			 {
					System.out.println("pagination exists");
				for (int j = 0; j < q.size(); j++) {

					System.out.println(q.get(j));
					Thread.sleep(2000);
					
					q.get(j).click();
				}
			}
		 	}
		 catch (Exception e) {
				throw new NoSuchElementException("Failed in pagination");
			}
	}

	public void searchData(WebDriver driver, By locator1, By locator2, String keysToSend, int count,
			String Dynamiclocator, String StringToBeReplaced, String DynamicValue) {

		try {
			wait = waitMethod(driver);

			clear_Click_SendKeys(driver, count, locator1, keysToSend);

			isDisplayedInLoop(driver, count, locator2);

			click(driver, locator2);

			isDisplayedInLoop(driver, count, locator2);

			BaseSuite.reportLog("Select Searched Folder Group");

			click(driver, returnElement(Dynamiclocator, StringToBeReplaced, DynamicValue));


		} catch (Exception e) {
			throw new NoSuchElementException("Failed in sendkeys() for locator " + Dynamiclocator);
		}

	}

	public void getWindowHandler(WebDriver driver) throws InterruptedException
	{
	// It will return the parent window name as a String
		String mainWindow = driver.getWindowHandle();
	// It returns no. of windows opened by WebDriver and will return Set of Strings
		Set<String> set = driver.getWindowHandles();
	// Using Iterator to iterate with in windows
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
	// Compare whether the main windows is not equal to child window. If not equal,
	// we will close.
			if (!mainWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
			
				System.out.println(driver.switchTo().window(childWindow).getTitle());
	// driver.close();
	}
	}
	// This is to switch to the main window
	// driver.switchTo().window(mainWindow);

	}



	public String javascriptGetText(WebDriver driver, By Locator) {

		try {
			WebElement elem = driver.findElement(Locator);
			Thread.sleep(1000);
			return (String) ((JavascriptExecutor) driver).executeScript("return jQuery(arguments[0]).text();", elem);
			
						
		} catch (Exception e) {
			BaseSuite.log.error(e.getMessage());
		// BaseSuite.reportLog(e.getMessage());
			throw new NoSuchElementException("Failed in javascriptGetText()");

		}
		
	}

	

	public void displayAndClick(WebDriver driver,By locator) {

		try {
			isDisplayedInLoop(driver, 30, locator);

			click(driver, locator);

		} catch (Exception e) {

			e.getMessage();
		}
	}

//=======
//public void clear_Click_SendKeys(WebDriver driver, int count, By locator, String keysToSend) {	 
//
//    try {
//
//        isDisplayedInLoop(driver, count, locator); 
//
//        clear(driver, locator); 
//
//        isDisplayedInLoop(driver, count, locator); 
//
//        click(driver, locator); 
//
//        isDisplayedInLoop(driver, count, locator); 
//
//        sendKeys(driver, locator, keysToSend);
//
//    } catch (Exception e) {
//    	
//        BaseSuite.log.error(e.getMessage());
//        // BaseSuite.reportLog(e.getMessage());
//        
//        throw new NoSuchElementException("Failed in sendkeys() for locator " + locator);
//    }

	public void captureToastMsg(WebDriver driver, By locator1, By locator2, String mess, String label) throws Exception {
		SoftAssert soft = new SoftAssert();

		try {
		BaseSuite.reportLog("Verifying " + label + " Message");

		String validMess = getText(driver, locator1).trim();

		waitForElement(driver, locator2);

		click(driver, locator2);

		BaseSuite.validationReportLog("Retrived Message for " + label + " is :" + validMess);
		BaseSuite.validationReportLog("Expected Message for " + label + " is :" + mess.trim());

		if (!validMess.isEmpty() && validMess.equalsIgnoreCase(mess.trim())) {

			soft.assertEquals(validMess, mess.trim());

			BaseSuite.validationReportLog(label + " Message Successfully Matched");

		}

		else {
			BaseSuite.reportFailLog(label + " Messages didn't match", "captureToastMsg");

		}
		}
		catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception();
		}

	}


	public boolean isClickable(WebDriver driver, By locator, String linkName,boolean expected)
	{
		
		SoftAssert soft = new SoftAssert();
		boolean status = false;
		try {
			wait = waitMethod(driver);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			BaseSuite.validationReportLog(linkName + " link/button is Clickable");
			status = true;
			
		} catch (Exception e) {

			BaseSuite.reportFailLog(linkName + " link/button is not Clickable", "isClickable");

		}
		soft.assertEquals(status, expected);
		return status;
	}
	
	public boolean isEditable(WebDriver driver, By locator, String fieldName) {

		try {
			wait = waitMethod(driver);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			BaseSuite.validationReportLog(fieldName + " field is Editable");
			return true;
		} catch (Exception e) {

			BaseSuite.reportLog(fieldName + " field is not Editable");
			return false;
		}
	}

	public void getAllLinkAndVerifyLinkText(WebDriver driver, By locator, String linkText) {
		List<WebElement> allLinks = driver.findElements(locator);

		for (WebElement specificlink : allLinks) {

			if (specificlink.getText().trim().equalsIgnoreCase(linkText.trim())) {

				BaseSuite.validationReportLog(linkText + " link found and link Text is matched");

				break;

			} else {

				BaseSuite.reportFailLog(linkText + " link not found and link Text is not matched",
						"getAllLinkAndVerifyLinkText");

			}
		}
	}

	public boolean verifyIndividualLabel(WebDriver driver, By locator, String labelName) {

		boolean status = false;
		BaseSuite.reportLog("Checking for label " + labelName);
		waitForElement(driver, locator);
		if (isDisplayed(driver, locator)) {
			status = true;

			BaseSuite.validationReportLog(labelName + " is displaying in the page");
		} else {

			BaseSuite.reportFailLog(labelName + " is not displaying in the page", "verifyIndividualLabel");
		}

		return status;
	}

	public boolean verifyVisibilityOfButtons(WebDriver driver, By locator, String buttonName, boolean expected) {
		SoftAssert soft = new SoftAssert();
		boolean status = false;
		BaseSuite.reportLog("Checking for button " + buttonName);
		waitForElement(driver, locator);
		boolean b = isEnabled(driver, locator);
		if (b) {
			status = true;

			BaseSuite.validationReportLog(buttonName + " is displaying in the page");
		} else {

			BaseSuite.validationReportLog(buttonName + " is not displaying in the page");
		}

		soft.assertEquals(status, expected);

		return status;
	}

	public void validateButtons(WebDriver driver, By locator, int count) {

		Integer value = new Integer(count);

		if (!value.equals(0)) {

			BaseSuite.reportLog("Validating Buttons");

			List<WebElement> radioButton = getElements(driver, locator);

			int buttons = radioButton.size();

			BaseSuite.reportLog("Size of Buttons in page is " + buttons);

			if (buttons == count) {
				BaseSuite.validationReportLog("Buttons are Matched");

			} else {
				BaseSuite.reportFailLog("Failed due to some extra Buttons in Page", "validateButtons");
			}
		}

	}

	public void validateTextFields(WebDriver driver, By locator, int count) {

		Integer value = new Integer(count);

		if (!value.equals(0)) {
			BaseSuite.reportLog("Validating Text Fields");

			List<WebElement> list = getElements(driver, locator);

			int inputFieldCount = list.size();

			BaseSuite.reportLog("Size of Text Fields is " + inputFieldCount);

			if (inputFieldCount == count) {
				BaseSuite.validationReportLog("Text Fields are Matched");

			} else {
				BaseSuite.reportFailLog("Failed due to some extra Text Fields in Page", "validateTextFields");
			}
		}

	}

	public void validateInputFields(WebDriver driver, By locator, int count) {

		Integer value = new Integer(count);

		if (!value.equals(0)) {
			BaseSuite.reportLog("Validating Input Fields");

			List<WebElement> list = getElements(driver, locator);

			int inputFieldCount = list.size();

			BaseSuite.reportLog("Size of Input Fields is " + inputFieldCount);

			if (inputFieldCount == count) {
				BaseSuite.validationReportLog("Input Fields are Matched");

			} else {
				BaseSuite.reportFailLog("Failed due to some extra Input Fields in Page", "validateInputFields");
			}
		}

	}

	public boolean specialCharaMandatoryField(WebDriver driver, By locator1, By locator2, String keysToSend,
			SoftAssert soft, String lable, String errorMess) {
		boolean status = false;

		displayAndSendkey(driver, locator1, keysToSend, "Clicked on " + lable, "Entering " + lable, lable + " added successfully");

		BaseSuite.reportLog("Entering the details::::  " + keysToSend);
		String SystemGErrmsg = getText(driver, locator2).trim();

		BaseSuite.validationReportLog("Retrived Message for " + lable + " field is :" + SystemGErrmsg);
		BaseSuite.validationReportLog("Expected Message for " + lable + " field is :" + errorMess);

		if (!SystemGErrmsg.isEmpty()) {
			soft.assertEquals(SystemGErrmsg, errorMess);
			status = true;
			BaseSuite.validationReportLog(lable + "Field Error Message Successfully Matched");
		} else {
			BaseSuite.reportFailLog(lable + "Field Error Message not Matched", "specialCharaMandatoryField");
		}
		return status;

	}

	public boolean otherMandatoryField(WebDriver driver, By locator1, By locator2, String keysToSend, SoftAssert soft,
			String lable, String errorMess) {
		boolean status = false;
		displayAndSendkey(driver, locator1, keysToSend, "Clicked on " + lable, "Adding " + lable,
				lable + " added successfully");
		BaseSuite.reportLog("Entering the details::::  " + keysToSend);
		String selectAll = Keys.chord(Keys.CONTROL, "a");
		sendKeys(driver, locator1, selectAll);
		moveToElementBackSpace(driver, locator1);

		String connectionNameErrmsg = getText(driver, locator2).trim();
		BaseSuite.validationReportLog("Retrived Message for " + lable + " field is :" + connectionNameErrmsg);
		BaseSuite.validationReportLog("Expected Message for " + lable + " field is :" + errorMess);

		if (!connectionNameErrmsg.isEmpty()) {
			soft.assertEquals(connectionNameErrmsg, errorMess);
			status = true;
			BaseSuite.validationReportLog(lable + "Field Error Message Successfully Matched");
		} else {
			BaseSuite.reportFailLog(lable + "Field Error Message not Matched", "mandatoryField");
		}
		return status;
	}

	public void displayAndSendkey(WebDriver driver, By locator, String keysToSend, String labelName1, String labelName2,
			String labelName3) {
		BaseSuite.reportLog(labelName1);
		click(driver, locator);
		BaseSuite.reportLog(labelName2);
		sendKeys(driver, locator, keysToSend);
		BaseSuite.reportLog(labelName3);
	}



	public List<String> getColumnNamesUsingSheet(String excelPath, String sheetName) {
		List<String> colNames = new ArrayList<String>();
		try (FileInputStream fis = new FileInputStream(new File(excelPath));) {
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet spreadsheet = workbook.getSheet(sheetName);

			int lastcell = spreadsheet.getRow(0).getLastCellNum();
			// Non empty Last cell Number or index return

			for (int i = 0; i <= lastcell; i++) {

				if (spreadsheet.getRow(0).getCell(i).getRichStringCellValue().toString() != null
						|| !(spreadsheet.getRow(0).getCell(i).getRichStringCellValue().toString().isEmpty()))
					colNames.add(spreadsheet.getRow(0).getCell(i).getRichStringCellValue().toString());

			}

		} catch (Exception e) {

			e.getMessage();
		}

		return colNames;
	}
	
	public void continueNext(WebDriver driver,String methodName,By homeClickLocator,By discardPopUpLocator,ExtentTest test)
			 {

		try {
			BaseClassUtil util = new BaseClassUtil();

			String screenshotPath = util.takeScreenshotAtEndOfTest(methodName, driver);// pass the class name as screen shot

			test.log(Status.FAIL,methodName, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());

			waitForElement(driver, homeClickLocator);
			
			displayAndClick(driver,homeClickLocator);
				
			if(isDisplayed(driver, discardPopUpLocator))
			{

				displayAndClick(driver,discardPopUpLocator);// we have to click on yes button to discard changed if this message appears
				
			}
			
		} catch (Exception e) {
			
			e.getMessage();
			
		}

	}
	

	public boolean verifyRetrivedValues(WebDriver driver,By locator, String labelName, String attribute, String inputToCompare) {
		boolean status = false;
		BaseSuite.reportLog("retriving values for " + labelName);
		waitForElement(driver, locator);
		isDisplayedInLoop(driver, 40, locator);
		String retrivedValue = getAttribute(driver, locator, attribute);
		
		BaseSuite.validationReportLog("Retrived Message for " + labelName + " is :" + retrivedValue);
		BaseSuite.validationReportLog("Expected Message for " + labelName + " is :" + inputToCompare.trim());
		
		if (!retrivedValue.isEmpty()) {
			Assert.assertEquals(retrivedValue, inputToCompare);
			status = true;
			BaseSuite.validationReportLog(labelName +  " is matched & verified");

		} else {

			BaseSuite.reportFailLog(labelName +  " is not matching", "verifyRetrivedValues");
		}

		return status;
	}
	
	

}
