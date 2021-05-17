package nexgen.automation.pageclasses.pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;


import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.util.BaseClassUtil;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;

public class AdminUserPage extends PageUtil
{
	WebDriver driver;
	public AdminUserPage(WebDriver driver)
	{

		this.driver = driver;

	}

	String userDetails = System.getProperty("user.dir") + Constant.LOGINDETAILS;

	XLUtils xlReader = new XLUtils();
	SoftAssert soft = new SoftAssert();
	
	By secureAdvanceButton = getElementLocator(prop.getProperty("secure.AdvanceButton"));
	By secureProceedtounsafe = getElementLocator(prop.getProperty("secure.Proceedtounsafe"));
	By pagelabel = getElementLocator(prop.getProperty("Admin.PageLabel"));
	By ClickonAdmin = getElementLocator(prop.getProperty("Admin.ClickAdmin"));
	By ClickonCreateuser = getElementLocator(prop.getProperty("Admin.CreateUserButton"));
	By ClickonDiscard = getElementLocator(prop.getProperty("Admin.Discard"));
	By username = getElementLocator(prop.getProperty("Admin.Username"));
	By email = getElementLocator(prop.getProperty("Admin.Email"));
	By firstname = getElementLocator(prop.getProperty("Admin.FirstName"));
	By lastname = getElementLocator(prop.getProperty("Admin.Lastname"));
	By password = getElementLocator(prop.getProperty("Admin.Password"));
	By confirmpassword = getElementLocator(prop.getProperty("Admin.ConfirmPassword"));
	By clickonsave = getElementLocator(prop.getProperty("Admin.SaveUser"));	
	By DiscardAlert=getElementLocator(prop.getProperty("Admin.alertwindow"));
	By Toggle = getElementLocator(prop.getProperty("Admin.togglebutton"));
	By Toggle1= getElementLocator(prop.getProperty("Admin.togglebutton1"));
	By Loadingtoast = getElementLocator(prop.getProperty("login.LoadingIcon"));
	By UsersTabClick = getElementLocator(prop.getProperty("Admin.UsersTab"));
	
	By namelable = getElementLocator(prop.getProperty("Admin.NameLable"));
	By deletebutton = getElementLocator(prop.getProperty("Admin.DeleteTab"));
	By searchbar = getElementLocator(prop.getProperty("Admin.searchBar"));
	By searchclick = getElementLocator(prop.getProperty("Admin.searchBarClick"));
	By deleteT = getElementLocator(prop.getProperty("Admin.DeleteTab"));
	By clickonpopup = getElementLocator(prop.getProperty("Admin.DeletePopup"));
	By Welcometitle = getElementLocator(prop.getProperty("Landingpage.Welcome"));
	
	String searchdataclick = prop.getProperty("Admin.searchdata");	
	String actualTitle;
	String expectedTitle;
	
	/*
	 * public boolean navigatetoAppPage() { boolean flag = false; try {
	 * 
	 * isDisplayedInLoop(driver, 5, secureAdvanceButton); if (isDisplayed(driver,
	 * secureAdvanceButton)) { click(driver, secureAdvanceButton);
	 * BaseSuite.reportLog("Successfully clicked on the Advanced button ");
	 * isDisplayedInLoop(driver, 5, secureProceedtounsafe); Thread.sleep(10000); if
	 * (isDisplayed(driver, secureProceedtounsafe)) { flag = true; click(driver,
	 * secureProceedtounsafe);
	 * BaseSuite.reportLog("Successfully clicked on the procced button ");
	 * //driver.get(baseURL); } else
	 * BaseSuite.reportLog("Unable to click on the procced button"); } else
	 * BaseSuite.reportLog("Unable to click on the procced button");
	 * 
	 * } catch (Exception Ex) { throw new
	 * AssertionError("Unable to login to the application!", Ex); } return flag;
	 * 
	 * }
	 */
	
	
	public void Admin()
	{
		try
		{
			isDisplayedInLoop(driver, 5, pagelabel);
			if(isDisplayed(driver, pagelabel))
			{
				//waitForElement(driver,ClickonAdmin);
				click(driver, ClickonAdmin);
				getWindowHandler(driver);
				BaseSuite.reportLog("User able to click on Administration tab");
			}
			
			else
			{
				BaseSuite.reportLog("Not able to click on the Administration tab");
			}
		}
		catch(Exception e)
		{
			throw new AssertionError("User not able to navigate on Administration page", e);
		}
	}
	
	
	public boolean Createuser(SoftAssert softAssert,String Username, String Email, String FirstName, String LastName, String Password, String ConfirmPassword, String Scenario, String TemporaryPass, String Status)
	{
		
		  boolean flag = false; 
		
		
				try
				{
					isDisplayedInLoop(driver,5,UsersTabClick);
					click(driver,UsersTabClick);
						isDisplayedInLoop(driver,5, ClickonCreateuser);
						
					if(!Scenario.isEmpty())
					{
						javascript(driver, "arguments[0].click();", ClickonCreateuser);
						//click(driver, ClickonCreateuser);
						BaseSuite.reportLog("User clicked on the create new user tab");
						
						actualTitle = driver.getTitle();
						expectedTitle = "Nextgenicedq";
						assertEquals(expectedTitle, actualTitle);
						Thread.sleep(5000);
						isDisplayedInLoop(driver, 2, username);
						clear_Click_SendKeys(driver, 2, username, Username);
						clear_Click_SendKeys(driver, 2, email, Email);
						clear_Click_SendKeys(driver, 2, firstname, FirstName);
						clear_Click_SendKeys(driver, 2, lastname, LastName);
						clear_Click_SendKeys(driver, 2, password, Password);
						clear_Click_SendKeys(driver, 2, confirmpassword, ConfirmPassword);
											
						
						if (Scenario.equalsIgnoreCase("Valid")) {

							if (!TemporaryPass.isEmpty()) {
								String gettext = getText(driver, Toggle);
								gettext = gettext.trim();

								if (!TemporaryPass.equalsIgnoreCase(gettext)) {
									click(driver, Toggle);

									BaseSuite.reportLog("Temporary password is selected");
								}
							}
							 
							if (!Status.isEmpty()) {

								String gettext = getText(driver, Toggle1);
								gettext = gettext.trim();

								if (!Status.equalsIgnoreCase(gettext)) {
									click(driver, Toggle1);

									BaseSuite.reportLog("Status is selected");
								}
							}

							isDisplayedInLoop(driver, 5, clickonsave);
							if (isDisplayed(driver, clickonsave)) {
								Thread.sleep(3000);
								javascript(driver, "arguments[0].click();", clickonsave);
								//click(driver, clickonsave);
								BaseSuite.reportLog("Clicked on Save button");
								isDisplayedInLoop(driver, 3, Welcometitle);
								isDisplayed(driver, Welcometitle);
								BaseSuite.validationReportLog("New user created successfully");
								Thread.sleep(3000);
								isDisplayedInLoop(driver, 5, UsersTabClick);
								javascript(driver, "arguments[0].click();", UsersTabClick);
								//click(driver, UsersTabClick);
							}
								
						}

						else {
				
							isDisplayedInLoop(driver,5,ClickonDiscard);
							Thread.sleep(3000);
							//javascript(driver, "arguments[0].click();", ClickonDiscard);
							click(driver, ClickonDiscard);
							//String subwindow = driver.getWindowHandle();
							//driver.switchTo().window(subwindow);
							Thread.sleep(3000);
							javascript(driver, "arguments[0].click();", DiscardAlert);
							//click(driver, DiscardAlert);
							BaseSuite.validationReportLog("User clicked on the discard button successfully");
						}
					} else {
						BaseSuite.reportLog("Not able to click on the the button for empty row");
					}

				}

				catch (Exception ex) {
					throw new AssertionError("User not able to navigate on the create new user page", ex);

				}
				return flag;
			}
	
		public void deleteuser(String User_search) throws Exception
		{
			
					isDisplayed(driver, UsersTabClick);
					click(driver, UsersTabClick);
					Thread.sleep(5000);
					BaseSuite.reportLog("Searching for User:" + User_search);
					isDisplayedInLoop(driver, 10, searchbar);
					click(driver, searchbar);
					clear(driver, searchbar);

					isDisplayedInLoop(driver, 4, searchbar);
					BaseSuite.reportLog("Search Name");
					sendKeys(driver, searchbar, User_search);
					BaseSuite.reportLog("Click On searched");
					if(!User_search.isEmpty())
					{
						isDisplayedInLoop(driver, 3, searchclick);
						click(driver, searchclick);
					}
					else
					{
						BaseSuite.reportLog("Created user not available in the list");
					}

					try {

						isDisplayedInLoop(driver, 4, searchclick);

						BaseSuite.reportLog("Click on Searched User");

						click(driver, returnElement(searchdataclick, "$User", User_search));
						BaseSuite.reportLog("Clicked on User: " + User_search);
						BaseSuite.reportLog("User Details retrieved successfully for user " + User_search);
						
						isDisplayedInLoop(driver,5,deleteT);
						if(isDisplayed(driver, deleteT))
						{
							click(driver,deleteT);
							isDisplayedInLoop(driver, 5,clickonpopup);
							Thread.sleep(3000);
							click(driver,clickonpopup);
							Thread.sleep(5000);
							BaseSuite.reportLog("Created user deleted successfully");
						}
						else
						{
							BaseSuite.reportLog("Created user not able to delete");
						}
					} 
					catch (Exception e)
					{
						throw new Exception("deleteuser " + searchdataclick + " not found");
					}
			}
				
		
				
				
											
				/*isDisplayedInLoop(driver, 2, pagelabel);
				if(isDisplayed(driver, ClickonAdmin))
				{
					
					click(driver, ClickonAdmin);
					BaseSuite.reportLog("User able to click on Administration tab");
					
				BaseSuite.reportLog("User able to click on Administration tab");
						
				Thread.sleep(5000);						
				isDisplayedInLoop(driver,2, namelable);
								
				List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
				int size = checkbox.size();
				
				System.out.println("Quantity of checkboxes are:"+ size);
				for(WebElement ele : checkbox)
				{
					if(ele.isSelected())
					{
						ele.click();
					}
				}
				
				/*for(int i=0; i<size; i++)
				{
					String val= checkbox.get(i).getAttribute("Icedq Test");
					if(val.equalsIgnoreCase("e-frame e-icons e-uncheck"))
					{
						checkbox.get(i).click();
					}
				}
				}
			}	
			
			catch(Exception ex)
			{
				BaseSuite.reportLog("User not able to delete the selected user");
			}*/
			
			
		
		
	
	
	public void continueNext(String FileName, String SheetName, String userNameCol, ExtentTest test, int userNumber,
            String errorMsg, org.apache.log4j.Logger log, String columnName, String methodName)
            throws IOException, EncryptedDocumentException, InvalidFormatException,
            org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        BaseClassUtil util = new BaseClassUtil(); 

        XLUtils xl = new XLUtils(); 

        String ruleName = xl.readUsingColName(FileName, SheetName, userNumber, userNameCol);// get the rule name from
                                                                                            // excel
        // sheet 

        try { 

            xl.writeToExcel("Fail", FileName, SheetName, userNumber, columnName);// write the excel as fail into the
                                                                                    // status
                                                                                    // column

        } catch (Exception e) { 

            e.getStackTrace();

         } 

        test.error("User Name " + userNameCol + " with User number " + userNumber + " failed");// log the error in
                                                                                                // extent
                                                                                                // report 
        test.error(errorMsg);// Log the exception in extent report 

        String screenshotPath = util.takeScreenshotAtEndOfTest(methodName, driver);// pass the class name as screen shot
                                                                                    // name 

        test.addScreenCaptureFromBase64String(screenshotPath);// log the screen shot in extent report 

        log.debug(errorMsg);// also log this error into application log 

    }
	
}
