package nexgen.automation.pageclasses.otherpages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import static org.testng.Assert.assertEquals;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentTest;
//import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.aventstack.extentreports.Status;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.config.ReadConfig;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ExecutionResult;
import nexgen.automation.framework.util.BaseClassUtil;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;

public class LoginPage extends PageUtil {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;

	}

	String userDetails = System.getProperty("user.dir") + Constant.LOGINDETAILS;

	XLUtils xlReader = new XLUtils();
	SoftAssert soft = new SoftAssert();

	By secureAdvanceButton = getElementLocator(prop.getProperty("secure.AdvanceButton"));
	By secureProceedtounsafe = getElementLocator(prop.getProperty("secure.Proceedtounsafe"));
	By userName = getElementLocator(prop.getProperty("Login.UserName"));
	By passWord = getElementLocator(prop.getProperty("Login.Password"));
	By signin = getElementLocator(prop.getProperty("Login.SubmitButton"));
	By welcomeText = getElementLocator(prop.getProperty("LandingPage.WelcomeText"));
	By landingPageUserOptions = getElementLocator(prop.getProperty("LandingPage.UserOptions"));
	By signOut = getElementLocator(prop.getProperty("LandingPage.Logout"));
	By signoutConfirmOption = getElementLocator(prop.getProperty("LandingPage.LogoutConfirmOption"));
	By loginLoadingIcon = getElementLocator(prop.getProperty("login.LoadingIcon"));
	By landingPageSuccessLoginMessage = getElementLocator(prop.getProperty("LandingPage.SuccessLoginMessage"));
	By forgotLink = getElementLocator(prop.getProperty("forgotpassword.forgotlink"));
	By Enteremailforgotpassword = getElementLocator(prop.getProperty("Enteremailforgotpassword.enteremail"));
	By submit = getElementLocator(prop.getProperty("Enteremailforgotpassword.submitButton"));
	By ForgetBacktoLogin = getElementLocator(prop.getProperty("forgotpassword.backtologin"));
	By loginHeader = getElementLocator(prop.getProperty("login.LoginHeader"));
	By welcome = getElementLocator(prop.getProperty("Landingpage.Welcome"));
	By hoverdownWait = getElementLocator(prop.getProperty("login.hoverdownWait"));
	By AzureAD = getElementLocator(prop.getProperty("verifyAzureADfunction.signin"));
	By ForgotpageLabel = getElementLocator(prop.getProperty("verifymandatoryfields.label"));
	By AzureADsubmit = getElementLocator(prop.getProperty("verifyAzureADfunction.submit"));
	By AzureADLabel = getElementLocator(prop.getProperty("verifyAzureADfunction.label"));
	By Microsoftsignin = getElementLocator(prop.getProperty("verifyAzureADfunction.microsoftlogin"));
	By Microsoftnext = getElementLocator(prop.getProperty("verifyAzureADfunction.microsoftemailnext"));
	By Loginheader = getElementLocator(prop.getProperty("verifyAzureADfunction.loginheader1"));
	By Micropass = getElementLocator(prop.getProperty("verifyAzureADfunction.micropass"));
	By Micronext = getElementLocator(prop.getProperty("verifyAzureADfunction.microbuttonnext"));
	By AzureUpdatepage = getElementLocator(prop.getProperty("verifyAzureADfunction.updateAzureAD"));
	By StaySignIn = getElementLocator(prop.getProperty("verifyAzureADfunction.staysignin"));
	By LableAzureAD = getElementLocator(prop.getProperty("verifyAzureADfunction2nd.ADpageLabel"));
	By ADUsername = getElementLocator(prop.getProperty("verifyAzureADfunction2nd.AzureUsername"));
	By ADemail = getElementLocator(prop.getProperty("verifyAzureADfunction2nd.AzureEmail"));
	By ADfirstname = getElementLocator(prop.getProperty("verifyAzureADfunction2nd.AzureFirstName"));
	By ADlastname = getElementLocator(prop.getProperty("verifyAzureADfunction2nd.AzureLastName"));
	By ADSubmit = getElementLocator(prop.getProperty("verifyAzureADfunction2nd.AzureSubmit"));

	public By AdministrationLabel = getElementLocator(prop.getProperty("LandingPage.AdministrationLabel"));

	By LoggedInMsg = getElementLocator(prop.getProperty("Login.LoggedInMsg"));
	By ToastMsgClosedBtn = getElementLocator(prop.getProperty("ToastMsgClosedBtn"));
	String logeedInText = prop.getProperty("LogeedInText");

	String invalidLoginMsg = prop.getProperty("InvalidLoginMsg");
	String Epass = prop.getProperty("verifyAzureADfunction.emailpass");
	String actualTitle;
	String expectedTitle;

	By iCEDQ = getElementLocator(prop.getProperty("Landingpage.iCEDQ"));

	By forgotPasswordLabel = getElementLocator(prop.getProperty("forgotpassword.label"));
	By forgotPasswordUserName = getElementLocator(prop.getProperty("forgotpassword.username"));
	By forgotPasswordSubmitBtn = getElementLocator(prop.getProperty("forgotpassword.submitBtn"));
	By forgotPasswordBackToLogin = getElementLocator(prop.getProperty("forgotpassword.BackToLogin"));

	By signInWithAzureAD = getElementLocator(prop.getProperty("login.signInWithAzureAD"));
	By AzureADSignIn = getElementLocator(prop.getProperty("login.signInWithAzureAD.signIn"));
	By AzureADSubmit = getElementLocator(prop.getProperty("login.signInWithAzureAD.submit"));
	By AzureADPassword = getElementLocator(prop.getProperty("login.signInWithAzureAD.password"));

	String userDetails1 = prop.getProperty("login.User");

	public boolean navigatetoAppPage() {
		boolean flag = false;
		try {

			isDisplayedInLoop(driver, 5, secureAdvanceButton);
			if (isDisplayed(driver, secureAdvanceButton)) {
				click(driver, secureAdvanceButton);
				// BaseSuite.reportLog("Successfully clicked on the Advanced button ");
				isDisplayedInLoop(driver, 5, secureProceedtounsafe);
				Thread.sleep(7000);
				if (isDisplayed(driver, secureProceedtounsafe)) {
					flag = true;
					click(driver, secureProceedtounsafe);
					// BaseSuite.reportLog("Successfully clicked on the procced button ");

				} else
					// BaseSuite.reportLog("Unable to click on the procced button");
					System.out.println("");
			} else
				// BaseSuite.reportLog("Unable to click on the procced button");
				System.out.println("");

		} catch (Exception Ex) {
			throw new AssertionError("Unable to login to the application!", Ex);
		}
		return flag;

	}

	public void verifyTitleOfPage() {
		// boolean flag = false;
		String title = driver.getTitle();
		System.out.println("Page title: " + title);

		// Check point
		if (title.equals("Nextgenicedq")) {
			System.out.println("Correct title");
		} else {
			System.out.println("Incorrect title");
		}

	}

	public boolean login(String username, String password) {

		boolean flag = false;
		try {

			BaseSuite bs = new BaseSuite();
			bs.test = bs.extent.createTest("verifyLoginToApplication_503");
			ReadConfig mailconfig = new ReadConfig();
			
			bs.test.log(Status.INFO, "X-ray Test Case URL");
			bs.test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-503");
			ExecutionResult.issueKey = "NG21-503";
			
			BaseSuite.reportLog("Launching browser!!!!");
			BaseSuite.validationReportLog("Launching browser successfully!!!");

			String browserInfo = BaseSuite.browserName.toLowerCase();

			if ((browserInfo != null) && (!browserInfo.contains("head"))) {
				navigatetoAppPage();
			}

			if (isDisplayed(driver, loginHeader)) {
				flag = true;

				BaseSuite.validationReportLog("You are on the Login Page!");
			} else {
				BaseSuite.reportLog("Login Page is not loaded!");
			}

			isDisplayedInLoop(driver, 5, userName);
			clear_Click_SendKeys(driver, 2, userName, username);

			BaseSuite.validationReportLog("Entered owner previledge UserName: " + username);
			clear_Click_SendKeys(driver, 2, passWord, password);

			BaseSuite.reportLog("Entered Password: " + password);
			isDisplayedInLoop(driver, 5, signin);
			click(driver, signin);
			BaseSuite.reportLog("Clicked on Login button");


				BaseSuite.reportLog("Login header is displaying properly..");
				BaseSuite.validationReportLog("You are on the Login Page!!");
				Thread.sleep(3000);					
				captureToastMsg(driver, LoggedInMsg, ToastMsgClosedBtn, logeedInText, "LoggedIn");

			BaseSuite.reportLog("Login header is displaying properly..");
			BaseSuite.validationReportLog("You are on the Login Page!!");

			// captureToastMsg(driver, LoggedInMsg, ToastMsgClosedBtn, LogeedInText,
			// "LoggedIn");

			isDisplayedInLoop(driver, 30, welcome);
			if (isDisplayed(driver, welcome)) {
				flag = true;
				BaseSuite.validationReportLog("Welcome User label in the profile section is showing properly");
				BaseSuite.reportLog("Login User is :::: " + username);
				BaseSuite.validationReportLog("User Login successfully in the application!!");

				BaseSuite.reportLog("Getting Started with NextGen serivces");

			}


			HomePage hp = new HomePage(driver);
			hp.administration();

		} catch (Exception ex) {
			throw new AssertionError("Unable to login to the application!", ex);
		}
		return flag;

	}

	public boolean logOut() {
		boolean flag = false;

		try {

			isDisplayedInLoop(driver, 20, landingPageUserOptions);
			click(driver, landingPageUserOptions);
			isDisplayedInLoop(driver, 20, signOut);
			click(driver, signOut);
			BaseSuite.reportLog("Clicked on logout button");

////			BaseSuite.reportLog("Waiting for the logout confirm option");
////			isDisplayedInLoop(driver, 3, signoutConfirmOption);
//			if (isDisplayed(driver, signoutConfirmOption)) {
//				click(driver, signoutConfirmOption);
//				BaseSuite.reportLog("Clicked on Logout Confirm Option");
//				if (isDisplayed(driver, signin)) {
//					flag = true;
//					BaseSuite.reportLog("User Logout is successful");
//				}
//			}

			if (isDisplayed(driver, signin)) {
				flag = true;
				BaseSuite.reportLog("User Logout is successful");
				BaseSuite.validationReportLog("User Logout successfully from the application!!");

			}
			BaseSuite.validationReportLog("User Logout successfully from the application!!");
		} catch (Exception ex) {
			throw new AssertionError("Unable to logged out from the application!", ex);
		}

		return flag;

	}

	public boolean loginWithInvalidUserData(String username, String password, String loginInvalid) {

		boolean flag = false;
		try {

			if (isDisplayed(driver, loginHeader)) {
				flag = true;
				BaseSuite.reportLog("You are on the Login Page!");
			} else {
				BaseSuite.reportLog("Login Page is not loaded!");
			}

			isDisplayedInLoop(driver, 5, userName);
			clear_Click_SendKeys(driver, 2, userName, username);
			BaseSuite.reportLog("Entered UserName: " + username);

			clear_Click_SendKeys(driver, 2, passWord, password);
			BaseSuite.reportLog("Entered Password: " + password);

			isDisplayedInLoop(driver, 5, signin);
			click(driver, signin);
			BaseSuite.reportLog("Clicked on Login button");

			if (loginInvalid.equalsIgnoreCase("Invalid")) {
				flag = true;
				BaseSuite.validationReportLog("Entered Username/Password is invalid");
			}

			else if (loginInvalid.equalsIgnoreCase("space")) {
				BaseSuite.validationReportLog(
						"Entered Username/Password is blank and not able to login into application!");
			} else if (loginInvalid.equalsIgnoreCase("specialChar")) {
				BaseSuite.validationReportLog(
						"Entered Username/Password having special character, hence not able to login into application!");
			}

			else {

				BaseSuite.validationReportLog("User is able to login with the invalid data");
			}

		} catch (Exception ex) {
			throw new AssertionError("Unable to login to the application!", ex);
		}
		return flag;

	}

	public void redirectToApp() {
		String browserInfo = BaseSuite.browserName.toLowerCase();

		if ((browserInfo != null) && (!browserInfo.contains("head"))) {
			navigatetoAppPage();
		}
	}

	public boolean LoginWithValidUserData(String username, String password, String loginValid) {

		boolean flag = false;
		try {

			if (isDisplayed(driver, loginHeader)) {
				flag = true;
				BaseSuite.reportLog("You are on the Login Page!");
			} else {
				BaseSuite.reportLog("Login Page is not loaded!");
			}

			isDisplayedInLoop(driver, 5, userName);
			clear_Click_SendKeys(driver, 2, userName, username);
			BaseSuite.reportLog("Entered UserName: " + username);

			clear_Click_SendKeys(driver, 2, passWord, password);
			BaseSuite.reportLog("Entered Password: " + password);

			isDisplayedInLoop(driver, 5, signin);
			click(driver, signin);
			BaseSuite.reportLog("Clicked on Login button");
			Thread.sleep(5000);

			if (isDisplayed(driver, welcome)) {

				flag = true;
				BaseSuite.validationReportLog("User Login successfully: " + username);
				isDisplayedInLoop(driver, 20, landingPageUserOptions);
				click(driver, landingPageUserOptions);
				isDisplayedInLoop(driver, 10, signOut);
				click(driver, signOut);
				BaseSuite.reportLog("Clicked on logout button");
				BaseSuite.validationReportLog("User Logout successfully: " + username);

			} else {

				BaseSuite.reportFailLog("User is unable to login into application with specified details!",
						"LoginWithValidUserData");
			}

		} catch (Exception ex) {
			throw new AssertionError("Unable to login to the application!", ex);
		}
		return flag;

	}

	public boolean verifyforgotPasswordlink() {
		boolean flag = false;
		try {

			String browserInfo = BaseSuite.browserName.toLowerCase();

			if ((browserInfo != null) && (!browserInfo.contains("head"))) {
				navigatetoAppPage();
			}
			// isDisplayedInPage(driver, "Forgot Password");
			isDisplayedInLoop(driver, 3, forgotLink);

			if (isDisplayed(driver, forgotLink)) {
				flag = true;
				click(driver, forgotLink);
				BaseSuite.reportLog("User clicked in forgot password link");
			}

			/*
			 * if(isDisplayed(driver,ForgetBacktoLogin)) { flag =true; click(driver,
			 * submit); BaseSuite.reportLog("Clicked on Submit button"); Thread.sleep(3000);
			 * click(driver, ForgetBacktoLogin);
			 * BaseSuite.reportLog("Clicked on Back to login button");
			 * 
			 * }
			 */

		} catch (Exception ex) {
			throw new AssertionError("Unable to click on link!", ex);
		}
		return flag;
	}

	public boolean verifyforgotPasswordLink() {
		SoftAssert softAssert = new SoftAssert();
		boolean flag = false;
		try {

			String browserInfo = BaseSuite.browserName.toLowerCase();

			if ((browserInfo != null) && (!browserInfo.contains("head"))) {
				navigatetoAppPage();
			}

			isDisplayedInLoop(driver, 3, forgotLink);

			if (isDisplayed(driver, forgotLink)) {
				flag = true;
				click(driver, forgotLink);
				BaseSuite.reportLog("User clicked in forgot password link");

				if (isDisplayed(driver, forgotPasswordBackToLogin)) {
					click(driver, forgotPasswordBackToLogin);

					isDisplayedInLoop(driver, 3, signin);
					if (isDisplayed(driver, signin)) {
						flag = true;
						BaseSuite.reportLog("Back to Login Page");
					}
				} else {
					assertEqual(softAssert, forgotPasswordBackToLogin, "Unable to click Back to login link");

				}

			}

		} catch (Exception ex) {
			throw new AssertionError("Unable to click on link!", ex);
		}
		return flag;
	}
	/*
	 * public boolean Enterforgotpasswordemail(String email) { boolean flag=false;
	 * try { String browserInfo = BaseSuite.browserName.toLowerCase();
	 * 
	 * if ((browserInfo != null) && (!browserInfo.contains("head"))) {
	 * navigatetoAppPage(); } //String actualTitle = driver.getTitle(); //String
	 * expectedTitle = "Log in to Development Environment";
	 * //assertEquals(expectedTitle, actualTitle); isDisplayedInPage(driver,
	 * "Forgot Your Password?"); isDisplayedInLoop(driver, 3,
	 * Enteremailforgotpassword );
	 * 
	 * if(isDisplayed(driver, Enteremailforgotpassword)) { flag =true;
	 * //click(driver, Enteremailforgotpassword); sendKeys(driver,
	 * Enteremailforgotpassword, email); BaseSuite.reportLog("Entered email" +
	 * email); click(driver, submit);
	 * BaseSuite.reportLog("Clicked on Submit button");
	 * 
	 * }
	 * 
	 * } catch (Exception ex) { throw new AssertionError("Unable to enter email",
	 * ex); } return flag; }
	 */

//	public boolean verifymandatoryfields(SoftAssert softAssert, String email){
//		
//		boolean loginLabel = isDisplayed(driver, ForgotpageLabel);
//		
//		softAssert.assertTrue(loginLabel);
//		
//		boolean flag=false;
//		try {
//			String browserInfo = BaseSuite.browserName.toLowerCase();
//
//			if ((browserInfo != null) && (!browserInfo.contains("head"))) 
//			{
//				navigatetoAppPage();
//			}
//			
//		//boolean verifyemail= isDisplayed(driver, ForgetBacktoLogin);
//			isDisplayedInLoop(driver, 3,ForgotpageLabel);
//			
//		if(isDisplayed(driver, ForgotpageLabel)) {
//			flag = true;
//			if (!email.isEmpty())
//			{
//				clear(driver, Enteremailforgotpassword);
//				sendKeys(driver, Enteremailforgotpassword, email);		
//				click(driver, submit);
//				BaseSuite.reportLog("Clicked on Submit button");
//				
//			}
//		}
//		
//	}
//		catch (Exception ex)
//		{
//			throw new AssertionError("Unable to enter email", ex);
//	}

	// Login Page assertion for valid and invalid details
	public void assertEqual(SoftAssert softAssert, By actual, String expectedResult) {

		String actualResult = getText(driver, actual);

		softAssert.assertEquals(actualResult, expectedResult, "Msg didn't match for " + expectedResult);

	}

	public void continueNext(String FileName, String SheetName, String userNameCol, ExtentTest test, int userNumber,
			String errorMsg, Logger log, String columnName, String methodName)
			throws IOException, EncryptedDocumentException, InvalidFormatException,
			org.apache.poi.openxml4j.exceptions.InvalidFormatException {

		BaseClassUtil util = new BaseClassUtil();

		XLUtils xl = new XLUtils();

		String ruleName = xl.ReadUsingColName(FileName, SheetName, userNumber, userNameCol);// get the rule name from
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

	public boolean verifyBackToLogin() {
		boolean flag = false;
		SoftAssert softAssert = new SoftAssert();
		try {
//            
//                String browserInfo = BaseSuite.browserName.toLowerCase();
//
// 
//
//                if ((browserInfo != null) && (!browserInfo.contains("head"))) {
//                    navigatetoAppPage();
//                }
//                
			if (isDisplayed(driver, forgotLink)) {
				click(driver, forgotLink);
				if (isDisplayed(driver, forgotPasswordBackToLogin)) {
					click(driver, forgotPasswordBackToLogin);

					if (isDisplayed(driver, signin)) {
						flag = true;
						BaseSuite.reportLog("Back to Login Page");
					}
				} else {
					assertEqual(softAssert, forgotPasswordBackToLogin, "Unable to click Back to login link");

				}
			}
		} catch (Exception ex) {
			throw new AssertionError("Unable to click on link!", ex);
		}
		return flag;
	}

	public boolean verifyForgetPasswordDetails() {
		SoftAssert softAssert = new SoftAssert();
		boolean flag = false;
		try {

			String browserInfo = BaseSuite.browserName.toLowerCase();

			if ((browserInfo != null) && (!browserInfo.contains("head"))) {
				navigatetoAppPage();
			}

			if (isDisplayed(driver, forgotLink)) {
				flag = true;
				click(driver, forgotLink);
				BaseSuite.reportLog("User clicked in forgot password link");
				if (isDisplayed(driver, forgotPasswordLabel)) {
					BaseSuite.reportLog("Forgot password label is displayed properly");
					clear_Click_SendKeys(driver, 2, forgotPasswordUserName, userDetails1);
					click(driver, forgotPasswordSubmitBtn);

				}

				else if (isDisplayed(driver, forgotPasswordBackToLogin)) {
					click(driver, forgotPasswordBackToLogin);

				} else {
					assertEqual(softAssert, forgotPasswordLabel, "Forgot password page not displayed");

				}
			}
		} catch (Exception ex) {
			throw new AssertionError("Unable to click on link!", ex);
		}
		return flag;
	}

	public boolean ForgetPasswordWithValid_InvalidData(SoftAssert softAssert, String email) {

		boolean loginLabel = isDisplayed(driver, forgotPasswordLabel);

		softAssert.assertTrue(loginLabel);

		boolean flag = false;
		try {
			String browserInfo = BaseSuite.browserName.toLowerCase();

			if ((browserInfo != null) && (!browserInfo.contains("head"))) {
				navigatetoAppPage();
			}

			if (isDisplayed(driver, forgotLink)) {
				flag = true;
				click(driver, forgotLink);
				BaseSuite.reportLog("User clicked in forgot password link");

				isDisplayedInLoop(driver, 3, forgotPasswordLabel);

				if (isDisplayed(driver, forgotPasswordLabel)) {
					flag = true;
					if (!email.isEmpty()) {
						clear(driver, forgotPasswordUserName);
						sendKeys(driver, forgotPasswordUserName, email);
						click(driver, forgotPasswordSubmitBtn);
						BaseSuite.reportLog("Clicked on Submit button");

					}
				}
			}
		} catch (Exception ex) {
			throw new AssertionError("Unable to enter email", ex);
		}
		return flag;
	}

	public void secure() {
		String browserInfo = BaseSuite.browserName.toLowerCase();

		if ((browserInfo != null) && (!browserInfo.contains("head"))) {
			navigatetoAppPage();
		}
	}

	public boolean loginWithValidUsers(String username, String password, String loginvalid) {

		boolean flag = false;
		try {
			/*
			 * String browserInfo = BaseSuite.browserName.toLowerCase();
			 * 
			 * 
			 * if ((browserInfo != null) && (!browserInfo.contains("head"))) {
			 * navigatetoAppPage(); }
			 */

			if (isDisplayed(driver, loginHeader)) {
				flag = true;
				BaseSuite.reportLog("You are on the Login Page!");
			} else {
				BaseSuite.reportLog("Login Page is not loaded!");
			}

			isDisplayedInLoop(driver, 5, userName);
			clear_Click_SendKeys(driver, 2, userName, username);
			BaseSuite.reportLog("Entered UserName" + username);

			clear_Click_SendKeys(driver, 2, passWord, password);
			BaseSuite.reportLog("Entered Password" + password);

			isDisplayedInLoop(driver, 5, signin);
			click(driver, signin);
			BaseSuite.reportLog("Clicked on Login button");
			Thread.sleep(5000);
			if (loginvalid.equalsIgnoreCase("Valid")) {
				if (isDisplayed(driver, welcome)) {

					flag = true;
					BaseSuite.reportLog("User Login is successful");
					isDisplayedInLoop(driver, 20, landingPageUserOptions);
					click(driver, landingPageUserOptions);
					isDisplayedInLoop(driver, 10, signOut);
					click(driver, signOut);
					BaseSuite.reportLog("Clicked on logout button");
				}
			} else {

				BaseSuite.reportErrorLog("User not able to login into the application");
			}

		} catch (Exception ex) {
			throw new AssertionError("Unable to login to the application!", ex);
		}
		return flag;

	}

	public boolean verifyAzureADfunction1st() {
		boolean flag = false;
		try {

			String browserInfo = BaseSuite.browserName.toLowerCase();

			if ((browserInfo != null) && (!browserInfo.contains("head"))) {
				navigatetoAppPage();
			}

			isDisplayedInLoop(driver, 3, AzureADLabel);
			if (isDisplayed(driver, AzureADLabel)) {
				flag = true;
				click(driver, AzureAD);
				// driver.get(key2);

				BaseSuite.reportLog("User clicked on Sign in With AzureAD button");
			} else {
				BaseSuite.reportLog("User not able to click on the AzureAd button");
			}

			if (actualTitle == expectedTitle) {
				flag = true;
				actualTitle = driver.getTitle();
				expectedTitle = "Sign in to your account";
				assertEquals(expectedTitle, actualTitle);
				// driver.getCurrentUrl();
				// driver.navigate().to("");
				// isDisplayedInLoop(driver,3, Microsoftsignin);
				click(driver, Microsoftsignin);
				sendKeys(driver, Microsoftsignin, "abhilesh.k@toranainc.com");
				Thread.sleep(3000);
				click(driver, Microsoftnext);
				isDisplayedInLoop(driver, 3, Loginheader);
				Thread.sleep(3000);
				click(driver, Micropass);
				sendKeys(driver, Micropass, Epass);
				click(driver, Micronext);
				actualTitle = driver.getTitle();
				expectedTitle = "Sign in to your account";
				assertEquals(expectedTitle, actualTitle);
				Thread.sleep(3000);
				click(driver, StaySignIn);
				Thread.sleep(3000);

			} else if (isDisplayed(driver, AzureUpdatepage)) {
				BaseSuite.reportLog("User redirected on the page AzureAD update accout information page ");
			}

			else {
				BaseSuite.reportLog("User redirected on the home page if already Sign in with AzureAD");
			}

		}

		catch (Exception ex) {
			throw new AssertionError("Unable to click on Button!", ex);
		}

		return flag;

	}

	public boolean verifyAzureADfunction2nd(SoftAssert softAssert, String USERNAME, String Email, String FirstName,
			String LastName) {
		boolean flag = false;
		boolean AzureLabel = isDisplayed(driver, LableAzureAD);
		softAssert.assertTrue(AzureLabel);
		try {
			String browserInfo = BaseSuite.browserName.toLowerCase();

			if ((browserInfo != null) && (!browserInfo.contains("head"))) {
				navigatetoAppPage();
			}

			isDisplayedInLoop(driver, 3, LableAzureAD);
			BaseSuite.reportLog("User is on the Update Account Information page");
			if (isDisplayed(driver, LableAzureAD) && (Email.isEmpty())) {
				flag = true;
				click(driver, ADSubmit);
				BaseSuite.reportLog("All the  mandatory field messages should be display");
			} else {
				BaseSuite.reportLog("Not able to see the all mandatory field messages");
			}

			if (isDisplayed(driver, ADUsername)) {
				flag = true;
				clear_Click_SendKeys(driver, 2, ADUsername, USERNAME);
				clear_Click_SendKeys(driver, 2, ADemail, Email);
				clear_Click_SendKeys(driver, 2, ADfirstname, FirstName);
				clear_Click_SendKeys(driver, 2, ADlastname, LastName);
				click(driver, ADSubmit);
				BaseSuite.reportLog("User clicked on Submit button");
				BaseSuite.reportLog("User not able to sign in with Invalid data");
			} else {
				BaseSuite.reportLog("User able to sign in with invalid data");
			}

			if (isDisplayed(driver, LableAzureAD)) {
				flag = true;
				clear_Click_SendKeys(driver, 2, ADUsername, USERNAME);
				clear_Click_SendKeys(driver, 2, ADemail, Email);
				clear_Click_SendKeys(driver, 2, ADfirstname, FirstName);
				clear_Click_SendKeys(driver, 2, ADlastname, LastName);
				click(driver, ADSubmit);
				BaseSuite.reportLog("User clicked on Submit button");
				BaseSuite.reportLog("User able to sign in with valid data");
			}

			else {
				BaseSuite.reportLog("User not able to sign in with valid data");
			}
		}

		catch (Exception ex) {
			throw new AssertionError("User not able to enter on the update account information page", ex);
		}
		return flag;

	}
}
