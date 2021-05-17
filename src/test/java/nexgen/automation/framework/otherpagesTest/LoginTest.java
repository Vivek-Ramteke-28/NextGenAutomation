package nexgen.automation.framework.otherpagesTest;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.reports.ListenerTest;
import nexgen.automation.framework.util.XLUtils;
import nexgen.automation.pageclasses.otherpages.LoginPage;

@Listeners(ListenerTest.class)
public class LoginTest extends BaseSuite {

	SoftAssert soft = new SoftAssert();

	@Test(priority = 1, groups = { "DepthFirst", "LoginTestCases" })
	public void verifyloginIntoApplication() {

		try {

			test = extent.createTest("verifyloginIntoApplication");
			reportLog("Launching browser");
			LoginPage login1 = new LoginPage(driver);
			reportLog("Entering login details");

			if (!login1.login(username, password))

				soft.fail("Failed to login into application. Aborting test execution");
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
		soft.assertAll();
	}

	@Test(priority = 2, groups = { "DepthFirst", "LoginTestCases" })
	public void verifyLoginLogoutFunctionality() {

		try {

			test = extent.createTest("verifyLoginLogoutFunctionality");
			reportLog("Launching browser");
			LoginPage login1 = new LoginPage(driver);

			reportLog("Entering login details");

			if (!login1.login(username, password))
				soft.fail("Failed to login into application. Aborting test execution");

			if (!login1.logOut())
				soft.fail("Failed to logged out from the application. Aborting test execution");

		}

		catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
		soft.assertAll();
	}

	@Test(priority = 3, groups = { "DepthFirst", "LoginTestCases" })
	public void verifyLoginWithInvalidUserData() throws Exception {
		
		test = extent.createTest("verifyLoginWithInvalidUserData");
		reportLog("Launching browser");
		

		LoginPage logs = new LoginPage(driver);
		
		logs.redirectToApp();
		
		

		int testCaseStatus = 1;

		Constant.components = "";



		String columnName = "Status";

		boolean Teststatus = false;

		String e1 = null;

		int rowNumber = 0;

		String sheetName = "Sheet1";

		Constant.issueKey = "";

		reportLog("Launching browser");

		SoftAssert softAssert = new SoftAssert();
		XLUtils xl = new XLUtils();

		String user = System.getProperty("user.dir")
				+ "/src/main/resources/testdata/logindetails/LoginWithInvalidUsersData.xlsx";

		int rowCount = xl.getRowCount(user, sheetName);

		for (int rowNum = 0; rowNum < rowCount; rowNum++) {

			try {

				rowNumber = rowNum + 1;

				@SuppressWarnings("serial")
				List<String> inputs = new ArrayList<String>() {
					{
						add("User");
						add("Password");
						add("loginInvalid");
					}
				};

				List<String> output = xl.getDetails(inputs, rowNumber, sheetName, xl, user);

				logs.loginWithInvalidUserData(output.get(0), output.get(1), output.get(2));


				xl.writeToExcel("Pass", user, sheetName, rowNumber, columnName);

				Teststatus = false;

				softAssert.assertAll();

			} catch (Exception e2) {

				Teststatus = true;

				testCaseStatus++;

				e1 = e2.getMessage();
			} finally {
				if (Teststatus) {

					logs.continueNext(user, sheetName, "user", test, rowNumber, e1, log, columnName, "verifyLoginWithInvalidData");

				}

			}

		}

		BaseSuite.validationReportLog("Invalid user's are not able to login to application!" );

		softAssert.assertAll();

		logs.testCaseStatus(testCaseStatus, log);

	}

	@Test(priority = 4, groups = { "DepthFirst", "LoginTestCases" })
	public void verifyforgotPasswordLink_BackToLogin() {
		try {

			
			test = extent.createTest("verifyforgotPasswordLink_BackToLogin");
			reportLog("Launching browser");
			LoginPage login1 = new LoginPage(driver);
			reportLog("Clicking on forgot password");

			login1.verifyforgotPasswordLink();

		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
		BaseSuite.validationReportLog("Forget Password link is working as expected!");
		soft.assertAll();
	}

	@Test(priority = 5, groups = { "DepthFirst", "LoginTestCases" })
	public void verifyForgetPasswordWithValid_InvalidData() throws Exception {

		LoginPage logs = new LoginPage(driver);

		Constant.components = "";

		test = extent.createTest("verifyForgetPasswordWithValid_InvalidData");
		reportLog("Launching browser");
		reportLog("Clicking on forgot password");

		Constant.issueKey = "";

		int testCaseStatus = 1;

		String columnName = "Status";

		boolean Teststatus = false;

		String e1 = null;

		int rowNumber = 0;

		String sheetName = "Sheet1";

		reportLog("Launching browser");
		SoftAssert softAssert = new SoftAssert();

		XLUtils xl = new XLUtils();

		String email1 = System.getProperty("user.dir")
				+ "/src/main/resources/testdata/logindetails/ForgetPasswordValidInvalidlData.xlsx";

		int rowCount = xl.getRowCount(email1, "sheet1");

		for (int rowNum = 0; rowNum < rowCount; rowNum++) {

			try {

				rowNumber = rowNum + 1;

				@SuppressWarnings("serial")
				List<String> inputs = new ArrayList<String>() {
					{
						add("email/username");

					}
				};

				List<String> output = xl.getDetails(inputs, rowNumber, sheetName, xl, email1);

				
				logs.ForgetPasswordWithValid_InvalidData(softAssert, output.get(0));

				xl.writeToExcel("Pass", email1, sheetName, rowNumber, columnName);

				Teststatus = false;

				softAssert.assertAll();

			} catch (Exception e2) {

				Teststatus = true;

				testCaseStatus++;

				// e1 = e2.getMessage();
			} finally {
				if (Teststatus) {

					logs.continueNext(email1, sheetName, "user", test, rowNumber, e1, log, columnName,
							"ForgotPassword1");

				}

			}

		}

		//softAssert.assertAll();

		logs.testCaseStatus(testCaseStatus, log);
	}

	
	@Test(priority = 6, groups = { "DepthFirst", "LoginTestCases" })
	public void verifyLoginWithValidUserData() throws Exception {


		test = extent.createTest("verifyvalidDetails");
		reportLog("Launching browser");
		LoginPage logs1 = new LoginPage(driver);
		logs1.secure();
		
		int testCaseStatus = 1;

		Constant.components = "";

		test = extent.createTest("verifyLoginWithValidUserData");
		reportLog("Launching browser");
		
		
		LoginPage logs = new LoginPage(driver);
		
		logs.redirectToApp();
		
		String columnName = "Status";

		boolean Teststatus = false;

		String e1 = null;

		int rowNumber = 0;

		String sheetName = "Sheet1";

		Constant.issueKey = "";

		reportLog("Launching browser");
		

		SoftAssert softAssert = new SoftAssert();
		XLUtils xl = new XLUtils();

		String user = System.getProperty("user.dir")
				+ "/src/main/resources/testdata/logindetails/LoginWithValidUserData.xlsx";

		int rowCount = xl.getRowCount(user, sheetName);

		for (int rowNum = 0; rowNum < rowCount; rowNum++) {

			try {

				rowNumber = rowNum + 1;

				@SuppressWarnings("serial")
				List<String> inputs = new ArrayList<String>() {
					{
						add("User");
						add("Password");

						add("loginvalid");

						add("LoginValid");

					}
				};

				List<String> output = xl.getDetails(inputs, rowNumber, sheetName, xl, user);

				if(!output.get(2).isEmpty()) {
				logs1.loginWithValidUsers(output.get(0), output.get(1), output.get(2));

				// logs.logout(output.get(0), output.get(1));


				if(!output.get(2).isEmpty())
				{
					
				logs.LoginWithValidUserData(output.get(0), output.get(1), output.get(2));


				xl.writeToExcel("Pass", user, sheetName, rowNumber, columnName);
									
				Teststatus = false;
				
				softAssert.assertAll();
				}

				else
				{

					break;
				}
				}
			}	
			 catch (Exception e2) {

				Teststatus = true;

				testCaseStatus++;
				
				//e1 = e2.getMessage();
			}
			finally {
				if (Teststatus) {

					logs1.continueNext(user, sheetName, "user", test, rowNumber, e1, log, columnName, "verifyvalidDetails");
								
				}

			}

		}
		
		softAssert.assertAll();

		logs1.testCaseStatus(testCaseStatus, log);

	}

	@Test(priority = 7, groups = { "DepthFirst", "LoginTestCases" })
	public void SignInAzureAD1st() {
		try {

			test = extent.createTest("SignInAzureAD1st");
			reportLog("Launching browser");
			LoginPage login1 = new LoginPage(driver);
			reportLog("Clicking on Sign in with AzureAD");

			login1.verifyAzureADfunction1st();

		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
		soft.assertAll();
	}
	
	
	@Test(priority=8,groups = { "DepthFirst", "SignInAzureAD1st" })
	public void SignInAzureAD2nd() throws Exception
	{
		LoginPage logs = new LoginPage(driver);

		Constant.components = "";

		test = extent.createTest("SignInAzureAD2nd");
		reportLog("Launching browser");
		LoginPage Azure = new LoginPage(driver);
		reportLog("Clicked on AzureADSignIn button");
		
		Azure.verifyAzureADfunction1st();
		
		Constant.issueKey = "";

		int testCaseStatus = 1;

		String columnName = "Status";

		boolean Teststatus = false;

		String e1 = null;

		int rowNumber = 0;

		String sheetName = "Sheet1";

		reportLog("Launching browser");
		SoftAssert softAssert = new SoftAssert();	

		XLUtils xl = new XLUtils();

		String ADSignIn = System.getProperty("user.dir") + "/src/main/resources/testdata/logindetails/AzureADdetails.xlsx";

		int rowCount = xl.getRowCount(ADSignIn, "sheet1");

		for (int rowNum = 0; rowNum < rowCount; rowNum++) {

			try {

				rowNumber = rowNum + 1;

				@SuppressWarnings("serial")
				List<String> inputs = new ArrayList<String>() {
					{
						add("Username");
						add("Email");
						add("FirstName");
						add("LastName");
					}
				};

				List<String> output = xl.getDetails(inputs, rowNumber, sheetName, xl, ADSignIn);
								
				logs.verifyAzureADfunction2nd(softAssert,output.get(0),output.get(1),output.get(2),output.get(3));

				xl.writeToExcel("Pass", ADSignIn, sheetName, rowNumber, columnName);

				Teststatus = false;

				softAssert.assertAll();

			} catch (Exception e2) {

				Teststatus = true;

				testCaseStatus++;

				//e1 = e2.getMessage();
			}
			finally {
				if (Teststatus) {

					logs.continueNext(ADSignIn, sheetName, "user", test, rowNumber, e1, log, columnName, "AzureADSignIn");
				}
			}
		
		}

		softAssert.assertAll();

		logs.testCaseStatus(testCaseStatus, log);
	}
	
	
}
