package nexgen.automation.framework.administration.testcases;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import nexgen.automation.framework.constant.ExecutionResult;
import nexgen.automation.framework.administration.Users;
import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.config.ReadConfig;
import nexgen.automation.framework.reports.ListenerTest;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;

@Listeners(ListenerTest.class)
public class UsersTest extends BaseSuite {

	XLUtils xl = new XLUtils();
	PageUtil page = new PageUtil();
	ReadConfig mailconfig = new ReadConfig();

	@Test(groups = { "Users Section" })

	public void verifyCreateUserWithTempPassword() {
		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyCreateUserWithTempPassword_NG21-329");
			ExecutionResult.issueKey = "NG21-329";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-329");
			{

				Users u = new Users(driver);
				u.createUser_TempPassword(u.UsernameDetails, u.Email, u.UserFirstName, u.UserLastName, u.Password,
						u.ConfirmPassword, "Yes");

			}

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Users Section" })
	public void verifyCreateUserWithoutTempPassword() {
		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyCreateUserWithoutTempPassword_NG21-389");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-389");
			ExecutionResult.issueKey = "NG21-389";

			{

				Users u = new Users(driver);
				u.createUser_TempPassword(u.UsernameDetails1, u.Email1, u.FirstName1, u.LastName1, u.Password1,
						u.ConfirmPassword1, "No");
				

			}

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Users Section" })
	public void verifyRefreshUserListing() {
		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyRefreshUserListing_NG21-424");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-424");
			ExecutionResult.issueKey = "NG21-424";

			{

				Users u = new Users(driver);
				// u.refreshUserListing();

				u.usersRefreshFunctionality();
			}
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Users Section" })
	public void verifyUserNameShouldNotAcceptSpecialChar() {
		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyUserNameShouldNotAcceptSpecialChar_NG21-426");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-426");
			ExecutionResult.issueKey = "NG21-426";
			int rowNumber = 0;

			String users = System.getProperty("user.dir")
					+ "\\src\\main\\resources\\testdata\\logindetails\\FieldsValidationCheck.xlsx";
			int rowCount = xl.getRowCount(users, "NegativeData");

			Users u = new Users(driver);
			u.clickOnUsersMenu();
			u.clickOnNewButton();

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {
				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");
				List<String> inputs = page.getColumnNamesUsingSheet(users, "NegativeData");

				List<String> output = xl.getDetails(inputs, rowNumber, "NegativeData", xl, users);

				u.userNameValidate(output.get(1), output.get(2), u.username, u.UserNameMandatoryVal, output.get(0),
						"UserName", u.UsernameSpecialCharError, u.UserNameMandatoryText, u.UserNameSpecialCharVal);
				
				
				
				

			}
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Users Section" })
	public void verifyUserNameShouldAcceptSpecialChar() {
		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyUserNameShouldAcceptSpecialChar_NG21-429");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-429");
			ExecutionResult.issueKey = "NG21-429";
			int rowNumber = 0;

			String users = System.getProperty("user.dir")
					+ "\\src\\main\\resources\\testdata\\logindetails\\FieldsValidationCheck.xlsx";
			int rowCount = xl.getRowCount(users, "PositiveData");

			Users u = new Users(driver);
			u.clickOnUsersMenu();
			u.clickOnNewButton();

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {
				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");
				List<String> inputs = page.getColumnNamesUsingSheet(users, "PositiveData");

				List<String> output = xl.getDetails(inputs, rowNumber, "PositiveData", xl, users);

				u.userNameValidate(output.get(1), output.get(2), u.username, u.UserNameMandatoryVal, output.get(0),
						"UserName", u.UsernameSpecialCharError, u.UserNameMandatoryText, u.UserNameSpecialCharVal);

				BaseSuite.validationReportLog("User name accepting only hyphen(-), underscore(_), period(.)");

			}
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Users Section" })
	public void verifyuserNameShouldNotAcceptMoreThan50Char() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyuserNameShouldNotAcceptMoreThan50Char_NG21-427");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-427");
			ExecutionResult.issueKey = "NG21-427";

			{

				Users u = new Users(driver);
				u.clickOnUsersMenu();
				u.clickOnNewButton();
				u.userNameWithMoreThan50Char(u.ExceedCharactersTextDetails, u.ExceedCharValMsg, "UserName",
						u.NameExceedCharErrorMsgText, soft);
				driver.navigate().refresh();

			}

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Users Section" })
	public void verifyEmailTextBoxAcceptValidDetails() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyEmailTextBoxAcceptValidDetails_NG21-431");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-431");
			ExecutionResult.issueKey = "NG21-431";

			{

				Users u = new Users(driver);
				u.clickOnUsersMenu();
				u.clickOnNewButton();
				u.emailTextBoxWithValidDetails(u.EmailDetails);
				driver.navigate().refresh();

			}

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Users Section" })
	public void verifyEmailTextBoxAcceptInvalidDetails() {
		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyEmailTextBoxAcceptInvalidDetails_NG21-432");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-432");
			ExecutionResult.issueKey = "NG21-432";
			int rowNumber = 0;

			String users = System.getProperty("user.dir")
					+ "\\src\\main\\resources\\testdata\\logindetails\\FieldsValidationCheck.xlsx";
			int rowCount = xl.getRowCount(users, "EmailValidate");

			Users u = new Users(driver);
			u.clickOnUsersMenu();
			u.clickOnNewButton();

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {
				rowNumber = rowNum + 1;
				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

				List<String> inputs = page.getColumnNamesUsingSheet(users, "EmailValidate");

				List<String> output = xl.getDetails(inputs, rowNumber, "EmailValidate", xl, users);

				u.emailTextBoxWithInvalidDetails(output.get(1), output.get(2), u.email, u.EmailMandatoryVal,
						output.get(0), "Email", u.EmailSpecialCharError, u.EmailMandatoryText, u.EmailSpecialCharVal);

			}

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Users Section" })
	public void verifyFirstNameShouldNotAcceptMoreThan50Char() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyFirstNameShouldNotAcceptMoreThan50Char_NG21-433");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-433");
			ExecutionResult.issueKey = "NG21-433";

			{

				Users u = new Users(driver);
				u.clickOnUsersMenu();
				u.clickOnNewButton();
				u.firstNameWithMoreThan50Char(u.ExceedCharactersTextDetails, u.ExceedCharValMsg, "FirstName",
						u.NameExceedCharErrorMsgText, soft);
				driver.navigate().refresh();

			}

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Users Section" })
	public void verifyFirstNameShouldAcceptSpecialChar() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyFirstNameShouldAcceptSpecialChar_NG21-434");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-434");
			ExecutionResult.issueKey = "NG21-434";

			{

				Users u = new Users(driver);
				u.clickOnUsersMenu();
				u.clickOnNewButton();
				u.firstNameWithSpecialChar(u.FirstNameSpecialChar);
				driver.navigate().refresh();
			}

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Users Section" })
	public void verifyFirstNameWithBlankData() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyFirstNameWithBlankData_NG21-435");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-435");
			ExecutionResult.issueKey = "NG21-435";

			{

				Users u = new Users(driver);
				u.clickOnUsersMenu();
				u.clickOnNewButton();
				u.firstNameWithBlankData(u.firstname, u.FirstNameMandatoryVal, "FirstNameDetails", soft, "FirstName",
						u.FirstnameMandatoryText);
				driver.navigate().refresh();
			}

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Users Section" })
	public void verifyLastNameShouldNotAcceptMoreThan50Char() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyLastNameShouldNotAcceptMoreThan50Char_NG21-436");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-436");
			ExecutionResult.issueKey = "NG21-436";

			{

				Users u = new Users(driver);
				u.clickOnUsersMenu();
				u.clickOnNewButton();
				u.lastNameWithMoreThan50Char(u.ExceedCharactersTextDetails, u.ExceedCharValMsg, "LastName",
						u.NameExceedCharErrorMsgText, soft);
				driver.navigate().refresh();

			}

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Users Section" })
	public void verifyLastNameShouldAcceptSpecialChar() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyLastNameShouldAcceptSpecialChar_NG21-437");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-437");
			ExecutionResult.issueKey = "NG21-437";

			{

				Users u = new Users(driver);
				u.clickOnUsersMenu();
				u.clickOnNewButton();
				u.lastNameWithSpecialChar(u.LastNameSpecialChar);
				driver.navigate().refresh();

			}

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Users Section" })
	public void verifyLastNameWithBlankData() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyLastNameWithBlankData_NG21-438");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-438");
			ExecutionResult.issueKey = "NG21-438";

			{

				Users u = new Users(driver);
				u.clickOnUsersMenu();
				u.clickOnNewButton();
				u.firstNameWithBlankData(u.lastname, u.LastNameMandatoryVal, "LastNameDetails", soft, "LastName",
						u.LastnameMandatoryText);
				driver.navigate().refresh();
			}

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Users Section" })
	public void verifySearchUserFromListOfUsers() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifySearchUserFromListOfUsers_NG21-452");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-452");
			ExecutionResult.issueKey = "NG21-452";

			{

				Users u = new Users(driver);
				u.clickOnUsersMenu();

				u.searchUser(u.UsernameDetails);
			}

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Users Section" })
	public void verifyUserAssignToGroup() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyUserAssignToGroup_NG21-451");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-451");
			ExecutionResult.issueKey = "NG21-451";

			{
				Users u = new Users(driver);
				u.clickOnUsersMenu();
				u.userAssignToGroup(u.userSearch, u.groupSearch, soft);
			}
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Users Section" })
	public void verifyRemoveGroupFromExistingUser() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyRemoveGroupFromExistingUser_NG21-497");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-497");
			ExecutionResult.issueKey = "NG21-497";

			{
				Users u = new Users(driver);
				u.clickOnUsersMenu();
				u.removeGroupFromExistingUser(u.userSearch, u.groupSearch, soft);
			}

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Users Section" })
	public void verifyUserNameShouldBeInLowerCaseOnRevisitingUser() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyUserNameShouldBeInLowerCaseOnRevisitingUser_NG21-430");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-430");
			ExecutionResult.issueKey = "NG21-430";

			{
				Users u = new Users(driver);
				u.clickOnUsersMenu();
				u.userNameWithLowerCase(u.userName, soft);
			}

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Users Section" })

	public void verifyUserAssignWithoutGroupDetails() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyUserAssignWithoutGroupDetails_NG21-495");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-495");
			ExecutionResult.issueKey = "NG21-495";

			{
				Users u = new Users(driver);
				u.clickOnUsersMenu();
				u.userAssignWithoutGroupDetails(u.userName, "", soft);
			}

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	// Verify that save button should be enabled when user enter all details.
	@Test(groups = { "Users Section" })
	public void verifySaveButtonShouldBeEnabledForAllUserData() {
		SoftAssert softAssert = new SoftAssert();
		try {
			test = extent.createTest("verifySaveButtonShouldBeEnabledWhenUserEnterdata_NG21-439");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-439");
			ExecutionResult.issueKey = "NG21-439";
			Users userN = new Users(driver);

			userN.SaveButtonShouldBeEnabled(softAssert);

		} catch (Exception e) {
			// e.printStackTrace();
			reportLog("Error observed while running the test case" + e.getMessage());

		}
		softAssert.assertAll();
	}

	@Test(groups = { "Users Section" })
	public void verifyBlockDeleteButtonVisibilityifUserNotSelected() {
		SoftAssert softAssert = new SoftAssert();
		try {
			test = extent.createTest("verifyBlock&DeleteButtonDisabledWhenNoUserSelected_NG21-440");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-440");
			ExecutionResult.issueKey = "NG21-440";

			Users userN = new Users(driver);
			userN.BlockDeleteButtonDisableifNoUserSelected(softAssert);

		} catch (Exception e) {

			e.printStackTrace();
			reportLog("Error observed while running the test case" + e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(groups = { "Users Section" })
	public void verifyBlockDeleteButtonVisibilityifUserisSelected() {
		SoftAssert softAssert = new SoftAssert();
		try {
			test = extent.createTest("verifyBlock&DeleteButtonEnabledWhenUserIsSelected_NG21-441");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-441");
			ExecutionResult.issueKey = "NG21-441";
			Users userN = new Users(driver);
			userN.BlockDeleteButtonEnabledifUserSelected(softAssert);

		} catch (Exception e) {
			e.printStackTrace();
			reportLog("Error observed while running the test case" + e.getMessage());
		}
		softAssert.assertAll();
	}

	// 2nd code
	@Test(groups = { "Users Section" })

	public void verifyCreateBlockedUserWithoutTempPass()

	{
		SoftAssert softAssert = new SoftAssert();
		try {

			test = extent.createTest("verifyCreateBlockedUserWithoutTempPass_NG21-390");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-390");
			ExecutionResult.issueKey = "NG21-390";

			{
				Users user = new Users(driver);

				user.createBlockedUserWithoutTempPass(user.Username1, user.BlockEmail, user.BlockFirstName,
						user.BlockLastName, user.BlockPassword, user.BlockConfirmPassword, user.TemporaryPass1,
						user.BlockedStatus, user.Search_user1);

			}

			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}

	@Test(groups = { "Users Section" })

	public void verifyCreateBlockedUserWithTempPass()

	{
		SoftAssert softAssert = new SoftAssert();

		try {

			test = extent.createTest("verifyCreateBlockedUserWithTempPass_NG21-391");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-391");
			ExecutionResult.issueKey = "NG21-391";

			{
				Users user = new Users(driver);

				user.createBlockedUserWithTempPass(user.Username2, user.Email2, user.FirstName2, user.LastName2,
						user.Password2, user.ConfirmPassword2, user.TemporaryPass2, user.BlockedStatus2,
						user.Search_user2);

			}

			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}

	@Test(groups = { "Users Section" })

	public void verifySearchCreatedUser()

	{
		SoftAssert softAssert = new SoftAssert();
		test = extent.createTest("verifySearchCreatedUser_NG21-392");
		test.log(Status.INFO, "X-ray Test Case URL");
		test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-392");
		ExecutionResult.issueKey = "NG21-392";

		try

		{
			Users user = new Users(driver);

			user.searchCreatedUser(user.User_search1);

			softAssert.assertAll();
		}

		catch (Exception e)

		{
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}

	@Test(groups = { "Users Section" })

	public void verifyUserSearchWithPagination()

	{
		SoftAssert softAssert = new SoftAssert();
		test = extent.createTest("verifyUserSearchWithPagination_NG21-393");
		test.log(Status.INFO, "X-ray Test Case URL");
		test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-393");

		ExecutionResult.issueKey = "NG21-393";

		try

		{
			Users user = new Users(driver);

			int testCaseStatus = 1;

			String columnName = "Status";

			boolean Teststatus = false;

			String e1 = null;

			int rowNumber = 0;

			String sheetName = "Pagination";

			reportLog("Launching browser");

			XLUtils xl = new XLUtils();

			String Users = System.getProperty("user.dir") + "/src/main/resources/testdata/logindetails/AbhiUser1.xlsx";

			int rowCount = xl.getRowCount(Users, "Pagination");

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {

				try {

					rowNumber = rowNum + 1;

					@SuppressWarnings("serial")
					List<String> inputs = new ArrayList<String>() {
						{
							add("PaginationPoint");

						}
					};

					List<String> output = xl.getDetails(inputs, rowNumber, sheetName, xl, Users);

					user.userSearchWithPagination(output.get(0));

					xl.writeToExcel("Pass", Users, sheetName, rowNumber, columnName);

					Teststatus = false;

					softAssert.assertAll();

				} catch (Exception e2) {

					Teststatus = true;

					testCaseStatus++;

					// e1 = e2.getMessage();
				} finally {
					if (Teststatus) {

						user.continueNext(Users, sheetName, "user", test, rowNumber, e1, log, columnName,
								"VerifyuserSearchWithPagination");
					}
				}

			}
			softAssert.assertAll();

			user.testCaseStatus(testCaseStatus, log);
		} catch (Exception e)

		{
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}

	@Test(groups = { "Users Section" })

	public void verifyMultipleUserBlock()

	{
		SoftAssert softAssert = new SoftAssert();

		test = extent.createTest("verifyMultipleUserBlock_NG21-442");
		test.log(Status.INFO, "X-ray Test Case URL");
		test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-442");
		ExecutionResult.issueKey = "NG21-442";

		try

		{
			Users user = new Users(driver);

			user.multipleUserBlock(user.Block_users);

			softAssert.assertAll();
		}

		catch (Exception e)

		{
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}

	@Test(groups = { "Users Section" })

	public void verifyAllUserSelect()

	{
		SoftAssert softAssert = new SoftAssert();

		test = extent.createTest("verifyAllUserSelect_NG21-444");
		test.log(Status.INFO, "X-ray Test Case URL");
		test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-444");
		ExecutionResult.issueKey = "NG21-444";

		try

		{

			Users user = new Users(driver);

			user.allUserSelect();
			;

			softAssert.assertAll();
		}

		catch (Exception e)

		{
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}

	@Test(groups = { "Users Section" })

	public void verifyUpdateAzureADuser()

	{
		SoftAssert softAssert = new SoftAssert();
		test = extent.createTest("verifyUpdateAzureADuser_NG21-445");
		test.log(Status.INFO, "X-ray Test Case URL");
		test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-445");
		ExecutionResult.issueKey = "NG21-445";

		try

		{

			Users user = new Users(driver);

			user.updateAzureADuser(user.AzureADUser, user.TemporaryPass2, user.BlockedStatus2);

			softAssert.assertAll();
		}

		catch (Exception e)

		{
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}

	@Test(groups = { "Users Section" })

	public void verifyUpdateLocalUser()

	{
		SoftAssert softAssert = new SoftAssert();
		test = extent.createTest("verifyUpdateLocalUser_NG21-446");
		test.log(Status.INFO, "X-ray Test Case URL");
		test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-446");
		ExecutionResult.issueKey = "NG21-446";
		try

		{

			Users user = new Users(driver);

			user.updateUser(user.updatedemail, user.updatedfirstname, user.updatedlastname, user.updatedpassword,
					user.updatedconfirmpassword, user.tempPass, user.status, user.LocalUser_search);

			softAssert.assertAll();
		}

		catch (Exception e)

		{
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}

	@Test(groups = { "Users Section" })

	public void verifyDeleteAzureAdUser()

	{
		SoftAssert softAssert = new SoftAssert();
		test = extent.createTest("verifyDeleteAzureAdUser_NG21-447");
		test.log(Status.INFO, "X-ray Test Case URL");
		test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-447");
		ExecutionResult.issueKey = "NG21-447";

		try

		{

			Users user = new Users(driver);

			user.deleteAzureAdUser(user.DeleteAzureADUser);

			softAssert.assertAll();
		}

		catch (Exception e)

		{
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}

	@Test(groups = { "Users Section" })

	public void verifyDeleteLocalUser()

	{
		SoftAssert softAssert = new SoftAssert();
		test = extent.createTest("verifyDeleteLocalUser_NG21-448");
		test.log(Status.INFO, "X-ray Test Case URL");
		test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-448");
		ExecutionResult.issueKey = "NG21-448";

		try

		{
			Users user = new Users(driver);

			user.deleteLocalUser(user.DeleteLocalUser);

			softAssert.assertAll();
		}

		catch (Exception e)

		{
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}

	@Test(groups = { "Users Section" })
	public void verifyDiscardNewUser() {
		SoftAssert softAssert = new SoftAssert();

		try {
			test = extent.createTest("verifyDiscardNewUser_NG21-449");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-449");
			ExecutionResult.issueKey = "NG21-449";
			Users user = new Users(driver);

			user.discardNewUser(user.Username, user.Email, user.FirstName, user.LastName, user.Password,
					user.ConfirmPassword, user.TemporaryPass, user.DiscaralertYes);

			softAssert.assertAll();
		}

		catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Users Section" })
	public void verifyDiscardExistingUserDetails() {
		SoftAssert softAssert = new SoftAssert();

		try {
			test = extent.createTest("verifyDiscardExistingUserDetails_NG21-450");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-450");

			ExecutionResult.issueKey = "NG21-450";
			Users user = new Users(driver);

			user.discardExistingUser(user.Username, user.Email, user.FirstName, user.LastName, user.Password,
					user.ConfirmPassword, user.TemporaryPass, user.DiscaralertYes, user.User_search);

			softAssert.assertAll();
		}

		catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Users Section" })
	public void verifyWorkspaceAssignDetails() {
		SoftAssert softAssert = new SoftAssert();

		try {
			test = extent.createTest("verifyWorkspaceAssignDetails_NG21-453");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-453");
			ExecutionResult.issueKey = "NG21-453";
			Users user = new Users(driver);

			user.workspaceAssignDetails(user.Workspace_search, user.User_search);

			softAssert.assertAll();
		}

		catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Users Section" })
	public void verifyAccountAssignDetails() {
		SoftAssert softAssert = new SoftAssert();

		try {
			test = extent.createTest("verifyAccountAssignDetails_NG21-454");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-454");
			ExecutionResult.issueKey = "NG21-454";
			Users user = new Users(driver);

			user.accountAssignDetails(user.Account_search, user.User_search);
			softAssert.assertAll();
		}

		catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Users Section" })
	public void verifyGroupAssignDetails() {
		SoftAssert softAssert = new SoftAssert();

		try {
			test = extent.createTest("verifyGroupAssignDetails_NG21-455");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-455");
			ExecutionResult.issueKey = "NG21-455";
			Users user = new Users(driver);

			user.groupAssignDetails(user.Group_search, user.User_search);
			softAssert.assertAll();
		}

		catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Users Section" })
	public void verifyAllUiElementsInNewUserPageFromAdminModule() {
		SoftAssert softAssert = new SoftAssert();

		try {
			test = extent.createTest("verifyAllUiElementsInNewUserPageFromAdminModule_NG21-417");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-417");
			ExecutionResult.issueKey = "NG21-417";
			Users user = new Users(driver);
			user.allUiElementsInNewUserPageFromAdminModule();
			softAssert.assertAll();
		}

		catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Users Section" })
	public void verifyAllUiElementsWhenUserDetailsAreGettingUpdated() {
		SoftAssert softAssert = new SoftAssert();

		try {
			test = extent.createTest("verifyAllUiElementsWhenUserDetailsAreGettingUpdated_NG21-418");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-418");
			ExecutionResult.issueKey = "NG21-418";
			Users user = new Users(driver);
			user.allUiElementsWhenUserDetailsAreGettingUpdated(user.searchUser);
			softAssert.assertAll();
		}

		catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Users Section" })
	public void verifyAllUiElementsOnUserListingPage() {
		SoftAssert softAssert = new SoftAssert();

		try {
			test = extent.createTest("verifyAllUiElementsOnUserListingPage_NG21-419");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-419");
			ExecutionResult.issueKey = "NG21-419";
			Users user = new Users(driver);
			user.allUiElementsOnUserListingPage();
			softAssert.assertAll();
		}

		catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Users Section" })
	public void verifyUserShouldNotBeCreatedWithSameUserName() {
		SoftAssert softAssert = new SoftAssert();

		try {
			test = extent.createTest("verifyUserShouldNotBeCreatedWithSameUserName_NG21-873");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-873");
			ExecutionResult.issueKey = "NG21-873";
			Users user = new Users(driver);
			user.createUser();
			user.validateDuplicateUserCreation();
			softAssert.assertAll();
		}

		catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}
	
	@Test(groups = { "Users Section" })
	public void cleanUpCreatedData() {

		try {
			
			Users u = new Users(driver);
			u.deleteuser(u.UsernameDetails);
			u.deleteuser(u.UsernameDetails1);
		}

		catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}
	
	
	
//****************************************  Test Data Creation for users
	
	@Test(groups = { "Users Section" })
	public void verifyCreateUsersTestDatForTesting() {
		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyCreateUsersTestDatForTesting");
			test.log(Status.INFO, "X-ray Test Case URL");

			int rowNumber = 0;

			String users = System.getProperty("user.dir")
					+ "/src/main/resources/testdata/ApplicationTestData/Users.xlsx";
			int rowCount = xl.getRowCount(users, "UserData");

			Users u = new Users(driver);

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {
				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");
				List<String> inputs = page.getColumnNamesUsingSheet(users, "UserData");

				List<String> output = xl.getDetails(inputs, rowNumber, "UserData", xl, users);

				
				u.createUser_TempPassword(output.get(0), output.get(1), output.get(2), output.get(3), output.get(4),
						output.get(5), "No");

			}
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}
	
	
	
	
	@Test(groups = { "Users Section" })
	public void verifyAssignGroupToUser() {
		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyAssignGroupToUser");
			test.log(Status.INFO, "X-ray Test Case URL");

			int rowNumber = 0;

			String users = System.getProperty("user.dir")
					+ "/src/main/resources/testdata/ApplicationTestData/AssignGroupToUser.xlsx";
			int rowCount = xl.getRowCount(users, "AssignGroup");

			Users u = new Users(driver);

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {
				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");
				List<String> inputs = page.getColumnNamesUsingSheet(users, "AssignGroup");

				List<String> output = xl.getDetails(inputs, rowNumber, "AssignGroup", xl, users);

				
//				u.createUser_TempPassword(output.get(0), output.get(1), output.get(2), output.get(3), output.get(4),
//						output.get(5), "No");
//

				u.clickOnUsersMenu();
				u.userAssignToGroup(output.get(0), output.get(1), soft);
			}
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	

}
