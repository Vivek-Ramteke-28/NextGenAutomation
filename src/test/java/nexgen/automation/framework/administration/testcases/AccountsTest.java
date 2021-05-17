package nexgen.automation.framework.administration.testcases;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;


import nexgen.automation.framework.administration.Accounts;
import nexgen.automation.framework.administration.Groups;
import nexgen.automation.framework.administration.Roles;
import nexgen.automation.framework.administration.Users;
import nexgen.automation.framework.administration.Workspaces;
import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.config.ReadConfig;
import nexgen.automation.framework.constant.ExecutionResult;
import nexgen.automation.framework.reports.ListenerTest;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;

@Listeners(ListenerTest.class)
public class AccountsTest extends BaseSuite {

	SoftAssert softAssert = new SoftAssert();
	XLUtils xl = new XLUtils();
	PageUtil page = new PageUtil();
	ReadConfig mailconfig = new ReadConfig();

	String account = System.getProperty("user.dir") + "/src/main/resources/testdata/Account/account.xlsx";
	String workspace = System.getProperty("user.dir") + "/src/main/resources/testdata/Workspace/workspaceOwner.xlsx";
	String roles = System.getProperty("user.dir") + "/src/main/resources/testdata/Roles/roles.xlsx";
	String addUserGroupToAccount = System.getProperty("user.dir") + "/src/main/resources/testdata/ApplicationTestData/AssignUserGroupToAccount.xlsx";

	@Test(groups = { "Accounts Section" })

	public void verifyAccountLandingPageAndNewAccountPageDetails() {

		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyAccountLandingPageAndNewAccountPageDetails_NG21-837");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-837");
			ExecutionResult.issueKey = "NG21-837";

			Accounts a = new Accounts(driver);

			a.clickOnAccountsMenu();
			a.clickOnNewAccountButton();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}

	@Test(groups = { "Accounts Section" })
	public void verifyAccountNameShouldNotAcceptSpecialChar() {
		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyAccountNameShouldNotAcceptSpecialChar_NG21-605");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-605");
			ExecutionResult.issueKey = "NG21-605";
			int rowNumber = 0;

			String users = System.getProperty("user.dir")
					+ "\\src\\main\\resources\\testdata\\logindetails\\FieldsValidationCheck.xlsx";
			int rowCount = xl.getRowCount(users, "NegativeData");

			Accounts a = new Accounts(driver);
			a.clickOnAccountsMenu();
			a.clickOnNewAccountButton();

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {
				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");
				List<String> inputs = page.getColumnNamesUsingSheet(users, "NegativeData");

				List<String> output = xl.getDetails(inputs, rowNumber, "NegativeData", xl, users);

				a.accountNameValidate(output.get(1), output.get(2), a.AccountName, a.AccountNameMandatoryVal,
						output.get(0), "AccountName", a.AccountNameSpecialCharError, a.AccountNameMandatoryText,
						a.AccountNameSpecialCharVal);

			}
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

		BaseSuite.validationReportLog("Account Name is not accepting the special characters...");
	}

	@Test(groups = { "Accounts Section" })
	public void verifyAccountNameShouldAcceptSpecialChar() {
		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyAccountNameShouldAcceptSpecialChar_NG21-663");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-663");
			ExecutionResult.issueKey = "NG21-663";
			int rowNumber = 0;

			String users = System.getProperty("user.dir")
					+ "\\src\\main\\resources\\testdata\\logindetails\\FieldsValidationCheck.xlsx";
			int rowCount = xl.getRowCount(users, "PositiveData");

			Accounts a = new Accounts(driver);
			a.clickOnAccountsMenu();
			a.clickOnNewAccountButton();

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {
				rowNumber = rowNum + 1;
				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

				List<String> inputs = page.getColumnNamesUsingSheet(users, "PositiveData");

				List<String> output = xl.getDetails(inputs, rowNumber, "PositiveData", xl, users);

				a.accountNameValidate(output.get(1), output.get(2), a.AccountName, a.AccountNameMandatoryVal,
						output.get(0), "AccountName", a.AccountNameSpecialCharError, a.AccountNameMandatoryText,
						a.AccountNameSpecialCharVal);

			}

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

		BaseSuite.validationReportLog("Account Name is accepting only hyphen(-), underscore(_), period(.)");
	}

	@Test( groups = { "Accounts Section" })
	public void verifyAccountNameShouldNotAcceptMoreThan50Char() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyAccountNameShouldNotAcceptMoreThan50Char_NG21-660");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-660");
			ExecutionResult.issueKey = "NG21-660";

			Accounts a = new Accounts(driver);
			a.clickOnAccountsMenu();
			a.clickOnNewAccountButton();
			a.accountNameWithMoreThan50Char(a.ExceedCharactersTextDetails, a.ExceedCharValMsg, "AccountName",
					a.NameExceedCharErrorMsgText, soft);
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test( groups = { "Accounts Section" })
	public void verifyAccountDescriptionShouldNotAcceptMoreThan250Char() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyAccountDescriptionShouldNotAcceptMoreThan250Char_NG21-666");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-666");
			ExecutionResult.issueKey = "NG21-666";

			Accounts a = new Accounts(driver);
			a.clickOnAccountsMenu();
			a.clickOnNewAccountButton();
			a.accountDescriptionWithMoreThan250Char(a.ExceedDescriptionTextDetails, a.DescriptionExceedCharValMsg,
					"AccountDescription", a.DescriptionExceedCharErrorMsgText, soft);
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Accounts Section" })
	public void verifyAccountNameShouldValidateToEnterDetails() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyAccountNameShouldValidateToEnterDetails_NG21-668");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-668");
			ExecutionResult.issueKey = "NG21-668";

			Accounts a = new Accounts(driver);
			a.clickOnAccountsMenu();
			a.clickOnNewAccountButton();
			a.accountNameWithBlankData(a.AccountName, a.AccountNameMandatoryVal, "AccountNameDetails", soft,
					"AccountName", a.AccountNameMandatoryText);
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test( groups = { "Accounts Section" })
	public void verifyRoleAssignmentWindows() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyRoleAssignmentWindows_NG21-850");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-850");
			ExecutionResult.issueKey = "NG21-850";

			Accounts a = new Accounts(driver);
			a.clickOnAccountsMenu();
			a.accountSearchFromListOfAccounts(a.accountName);
			a.verifyRoleAssignmentWindow();
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Accounts Section" })
	public void verifyWorkspaceAssignmentWindows() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyWorkspaceAssignmentWindows_NG21-851");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-851");
			ExecutionResult.issueKey = "NG21-851";

			Accounts a = new Accounts(driver);
			a.clickOnAccountsMenu();
			a.accountSearchFromListOfAccounts(a.accountName);
			a.verifyWorkspaceAssignmentWindow();
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Accounts Section" })
	public void verifyroleAssignmentToGroup() {

		try {
			test = extent.createTest("verifyroleAssignmentToGroup_NG21-624");
			ExecutionResult.issueKey = "NG21-624";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-624");
			int rowNumber = 0;
			String roles = System.getProperty("user.dir") + "/src/main/resources/testdata/Roles/roleAssignment.xlsx";
			int rowCount = xl.getRowCount(roles, "Sheet1");
			SoftAssert soft = new SoftAssert();
			Accounts a = new Accounts(driver);
			a.clickOnAccountsMenu();
			a.accountSearchFromListOfAccounts(a.accountSearch);

			PageUtil pageUtil = new PageUtil();

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {

				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

				List<String> inputs = pageUtil.getColumnNamesUsingSheet(roles, "Sheet1");

				List<String> output = xl.getDetails(inputs, rowNumber, "Sheet1", xl, roles);

				a.roleAssignmentToGroup(output.get(0), output.get(1), output.get(2));

			}

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Section" })
	public void verifyAccountShouldNotBeCreatedWithSameAccountName() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyAccountShouldNotBeCreatedWithSameAccountName_NG21-882");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-882");
			ExecutionResult.issueKey = "NG21-882";

			Accounts a = new Accounts(driver);
			a.clickOnAccountsMenu();
			a.validateDuplicateAccountCreation(a.accountName, a.accountDescriptionDetails);
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}
	

	// NG21-672 - Verify that save button should be enabled when user enter all
	// details.
	@Test( groups = { "Accounts Section" })
	public void verifySaveButtonIsEnabledAfterEnteringData() {
		SoftAssert softAssert = new SoftAssert();
		ReadConfig mailconfig = new ReadConfig();
		try {
			test = extent.createTest("verifyGroupDetailsWhenUserisRemovedFromGroup_NG21-672");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-672");
			ExecutionResult.issueKey = "NG21-672";
			Accounts accObj = new Accounts(driver);
			accObj.enableSaveButtonAfterEnteringAllData(softAssert);
			softAssert.assertAll();

		} catch (Exception e) {
			// e.printStackTrace();
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test( groups = { "Accounts Section" })
	public void verifyDiscardDetailsInNewAccount()

	{

		try {

			test = extent.createTest("verifyDiscardDetailsInNewAccount_NG21-673");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-673");
			ExecutionResult.issueKey = "NG21-673";

			{
				Accounts account = new Accounts(driver);
				account.discardDetailsInNewAccount(account.DiscardaccountName, account.Description,
						account.DiscardalertYes);
			}

			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}

	@Test( groups = { "Accounts Section" })
	public void verifyDiscardDetailsInExistingAccount()

	{

		try {

			test = extent.createTest("verifyDiscardDetailsInExistingAccount_NG21-675");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-675");
			ExecutionResult.issueKey = "NG21-675";

			{
				Accounts account = new Accounts(driver);
				account.discardDetailsInExistingAccount(account.DiscardaccountName, account.Description,
						account.DiscardalertYes, account.Account_search);
			}

			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}

	@Test(groups = { "Accounts Section" })
	public void verifyCreateValidAccount()

	{

		try {

			test = extent.createTest("verifyCreateValidAccount_NG21-603");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-603");
			ExecutionResult.issueKey = "NG21-603";

			{
				Accounts account = new Accounts(driver);
				account.createValidAccount(account.DiscardaccountName, account.Description, account.NewAccountName);
			}

			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}

	@Test( groups = { "Accounts Section" })
	public void verifyUpdateDetailsInExistingAccountCreatedByAdmin()

	{

		try {

			test = extent.createTest("verifyUpdateDetailsInExistingAccountCreatedByAdmin_NG21-612");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-612");
			ExecutionResult.issueKey = "NG21-612";

			{
				Accounts account = new Accounts(driver);
				account.verifyUpdateDetailsInExistingAccountCreatedByAdmin(account.UpdatedAccountName,
						account.UpdatedDescription, account.NewAccountName);
			}

			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}

	@Test(groups = { "Accounts Section" })
	public void verifySearchUserInUserGroupTabAccount()

	{

		try {

			test = extent.createTest("verifySearchUserInUserGroupTabAccount_NG21-846");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-846");
			ExecutionResult.issueKey = "NG21-846";

			{
				Accounts account = new Accounts(driver);
				account.searchUserInUserGroupTabAccount(account.Account_search, account.userGroupSearch);
			}

			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}

	@Test( groups = { "Accounts Section" })
	public void verifySearchWorkspaceInWorkspaceTabAccount()

	{

		try {

			test = extent.createTest("verifySearchWorkspaceInWorkspaceTabAccount_NG21-847");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-847");
			ExecutionResult.issueKey = "NG21-847";

			{
				Accounts account = new Accounts(driver);
				account.searchWorkspaceInWorkspaceTabAccount(account.Account_search, account.workspaceSearch);
			}

			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}

	@Test(groups = { "Accounts Section" })
	public void verifyRoleAssignWindowWithoutRoleSelection()

	{

		try {

			test = extent.createTest("verifyRoleAssignWindowWithoutRoleSelection_NG21-857");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-857");
			ExecutionResult.issueKey = "NG21-857";

			{
				Accounts account = new Accounts(driver);
				account.roleAssignWindowWithoutRoleSelection(account.Account_search, account.AssignUserInAccount);
			}

			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}

	@Test(groups = { "Accounts Section" })
	public void verifyRoleAssignWindowWithoutUserGroupSelection()

	{

		try {

			test = extent.createTest("verifyRoleAssignWindowWithoutUserGroupSelection_NG21-858");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-858");
			ExecutionResult.issueKey = "NG21-858";

			{
				Accounts account = new Accounts(driver);
				account.roleAssignWindowWithoutUserGroupSelection(account.Account_search, account.AssignRoleInAccount);
			}

			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}

	@Test(groups = { "Accounts Section" })
	public void verifyRemoveRoleCheckInGroup()

	{

		try {

			test = extent.createTest("verifyRemoveRoleCheckInGroup_NG21-641");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-641");
			ExecutionResult.issueKey = "NG21-641";

			{
				Accounts account = new Accounts(driver);
				account.removeRoleCheckInGroup(account.Account_search, account.removedGroupSearch, account.existingGroupSearch, account.roleAssign, account.groupAssign);
			}

			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}
	
	@Test(groups = { "Accounts Section" })
	public void verifyAccountSearchWithPagination()

	{

		try {

			test = extent.createTest("verifyAccountSearchWithPagination_NG21-889");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-889");
			ExecutionResult.issueKey = "NG21-889";
			Accounts work = new Accounts(driver);
			
			String columnName = "Status";
			
			int rowNumber = 0;

			String sheetName = "Pagination";
			
			XLUtils xl = new XLUtils();

			String Users = System.getProperty("user.dir") + "/src/main/resources/testdata/logindetails/AbhiUser1.xlsx";

			int rowCount = xl.getRowCount(Users, "Pagination");

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {
				rowNumber = rowNum + 1;
			
				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");
				
				List<String> inputs = page.getColumnNamesUsingSheet(Users, "Pagination");
				
					List<String> output = xl.getDetails(inputs, rowNumber, sheetName, xl, Users);

					work.accountSearchWithPagination(output.get(0));

					xl.writeToExcel("Pass", Users, sheetName, rowNumber, columnName);
			}
			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}
	
	
	

	// ==========Dhawal's Code===================//

	@Test(groups = { "Accounts Section" })
	public void verifyAdminCanRefreshUserGroupListUsingRefreshButton() {

		try {
			test = extent.createTest("verifyAdminCanRefreshUserGroupListUsingRefreshButton_NG21-647");
			ExecutionResult.issueKey = "NG21-647";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-647");
			SoftAssert soft = new SoftAssert();
			Accounts account = new Accounts(driver);
			account.adminCanRefreshUserGroupListUsingRefreshButton(account.searchAccount, account.accHeaderName,
					account.accHeaderType, account.accHeaderRole);
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}

	@Test(groups = { "Accounts Section" })
	public void verifyAdminCanAddNewWorkspaceFromWorkspaceTab() {

		try {
			test = extent.createTest("verifyAdminCanAddNewWorkspaceFromWorkspaceTab_NG21-633");
			ExecutionResult.issueKey = "NG21-633";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-633");
			SoftAssert soft = new SoftAssert();
			Accounts account = new Accounts(driver);
			account.adminCanAddNewWorkspaceFromWorkspaceTab(account.searchAccount, account.workspaceAddName,
					account.workspaceAddDescription);

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}

	@Test(groups = { "Accounts Section" })
	public void verifyAdminUserShouldNotAbleToRemoveWorkspaceFromWorkspaceTab() {

		try {
			test = extent.createTest("verifyAdminUserShouldNotAbleToRemoveWorkspaceFromWorkspaceTab_NG21-631");
			ExecutionResult.issueKey = "NG21-631";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-631");
			SoftAssert soft = new SoftAssert();
			Accounts account = new Accounts(driver);
			account.adminUserShouldNotAbleToRemoveWorkspaceFromWorkspaceTab(account.searchAccount);
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}


	@Test(groups = { "Accounts Section" })
	public void verifyAdminCanAssignRolesToUserOnAccountCreatedByAdmin() {
		try {
			test = extent.createTest("verifyAdminCanAssignRolesToUserOnAccountCreatedByAdmin_NG21-618");
			ExecutionResult.issueKey = "NG21-618";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-618");
			SoftAssert soft = new SoftAssert();
			Accounts acc = new Accounts(driver);
			int rowNumber = 0;
			int rowCount = xl.getRowCount(account, "Sheet1");
			PageUtil pageUtil = new PageUtil();

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {

				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

				List<String> inputs = pageUtil.getColumnNamesUsingSheet(account, "Sheet1");

				List<String> output = xl.getDetails(inputs, rowNumber, "Sheet1", xl, account);

				acc.adminCanAssignRolesToUserOnAccountCreatedByAdmin(output.get(0), output.get(1), output.get(2),
						output.get(3), output.get(4));

			}
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Accounts Section" })
	public void verifyuserDetailsShouldDisplayedCorrectlyAfterUserHasBeenAddedByAdminOnAccount() {

		try {
			test = extent.createTest("verifyuserDetailsShouldDisplayedCorrectlyAfterUserHasBeenAddedByAdminOnAccount_NG21-897");
			ExecutionResult.issueKey = "NG21-897";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-897");
			SoftAssert soft = new SoftAssert();
			Accounts acc = new Accounts(driver);
			int rowNumber = 0;
			int rowCount = xl.getRowCount(account, "Sheet2");
			PageUtil pageUtil = new PageUtil();

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {

				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

				List<String> inputs = pageUtil.getColumnNamesUsingSheet(account, "Sheet2");

				List<String> output = xl.getDetails(inputs, rowNumber, "Sheet2", xl, account);

				acc.userDetailsShouldDisplayedCorrectlyAfterUserHasBeenAddedByAdminOnAccount(output.get(1), output.get(0), output.get(2));
				

			}
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Accounts Section" })
	public void verifyGroupDetailsShouldDisplayedCorrectlyAfterGroupHasBeenAddedByAdminOnAccount() {

		try {
			test = extent.createTest("verifyGroupDetailsShouldDisplayedCorrectlyAfterGroupHasBeenAddedByAdminOnAccount_NG21-900");
			ExecutionResult.issueKey = "NG21-900";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-900");
			SoftAssert soft = new SoftAssert();
			Accounts acc = new Accounts(driver);
			int rowNumber = 0;
			int rowCount = xl.getRowCount(account, "Sheet4");
			PageUtil pageUtil = new PageUtil();

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {

				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

				List<String> inputs = pageUtil.getColumnNamesUsingSheet(account, "Sheet4");

				List<String> output = xl.getDetails(inputs, rowNumber, "Sheet4", xl, account);

				acc.groupDetailsShouldDisplayedCorrectlyAfterGroupHasBeenAddedByAdminOnAccount(output.get(1), output.get(0), output.get(2));
				

			}
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Accounts Section" })
	public void verifyAdminCanRemoveGroupFromAccountWhereAccountIsCreatedByAdmin() {

		try {
			test = extent.createTest("verifyAdminCanRemoveGroupFromAccountWhereAccountIsCreatedByAdmin_NG21-627");
			ExecutionResult.issueKey = "NG21-627";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-627");
			SoftAssert soft = new SoftAssert();
			Accounts acc = new Accounts(driver);
			int rowNumber = 0;
			int rowCount = xl.getRowCount(account, "Sheet5");
			PageUtil pageUtil = new PageUtil();

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {

				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

				List<String> inputs = pageUtil.getColumnNamesUsingSheet(account, "Sheet5");

				List<String> output = xl.getDetails(inputs, rowNumber, "Sheet5", xl, account);

				acc.adminCanRemoveGroupFromAccountWhereAccountIsCreatedByAdmin(rowNum,output.get(0), output.get(1));

			}
			
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}


	@Test( groups = { "Accounts Section" })
	public void verifyAccountDetailsShouldBeDisplayedCorrectlyWhenUserIsRemovedFromAccount() {

		try {
			test = extent
					.createTest("verifyAccountDetailsShouldBeDisplayedCorrectlyWhenUserIsRemovedFromAccount_NG21-629");
			ExecutionResult.issueKey = "NG21-629";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-629");
			SoftAssert soft = new SoftAssert();
			Accounts acc = new Accounts(driver);
			int rowNumber = 0;
			int rowCount = xl.getRowCount(account, "Sheet2");
			PageUtil pageUtil = new PageUtil();

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {

				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

				List<String> inputs = pageUtil.getColumnNamesUsingSheet(account, "Sheet2");

				List<String> output = xl.getDetails(inputs, rowNumber, "Sheet2", xl, account);

				acc.accountDetailsShouldBeDisplayedCorrectlyWhenUserIsRemovedFromAccount(output.get(0), output.get(1));

			}
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}

	@Test(groups = { "Accounts Section" })
	public void verifyUserDetailsShouldBeDisplayedCorrectlyAfterUserHasBeenRemovedFromAccount() {

		try {
			test = extent.createTest(
					"verifyUserDetailsShouldBeDisplayedCorrectlyAfterUserHasBeenRemovedFromAccount_NG21-457");
			ExecutionResult.issueKey = "NG21-457";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-457");
			SoftAssert soft = new SoftAssert();
			Accounts acc = new Accounts(driver);
			acc.userDetailsShouldBeDisplayedCorrectlyAfterUserHasBeenRemovedFromAccount(acc.userSearchName,
					acc.searchAccount);
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}

	@Test(groups = { "Accounts Section" })
	public void verifyAdminAssignMutipleRolesToUserGroupOnAccountHighestPreceedingOneShouldBeDisplayed() {

		try {
			test = extent.createTest(
					"verifyAdminAssignMutipleRolesToUserGroupOnAccountHighestPreceedingOneShouldBeDisplayed_NG21-848");
			ExecutionResult.issueKey = "NG21-848";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-848");
			SoftAssert soft = new SoftAssert();
			Accounts acc = new Accounts(driver);
			int rowNumber = 0;
			int rowCount = xl.getRowCount(account, "Sheet3");
			PageUtil pageUtil = new PageUtil();

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {

				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

				List<String> inputs = pageUtil.getColumnNamesUsingSheet(account, "Sheet3");

				List<String> output = xl.getDetails(inputs, rowNumber, "Sheet3", xl, account);

				acc.adminAssignMutipleRolesToUserGroupOnAccountHighestPreceedingOneShouldBeDisplayed(rowNum,
						output.get(0), output.get(1), output.get(2), output.get(3));

			}
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}

	@Test( groups = { "Accounts Section" })
	public void verifySequenceOfRoleWhileRemovingMultipleRolesFromUserGroupOnAccount() {

		try {
			test = extent.createTest("verifySequenceOfRoleWhileRemovingMultipleRolesFromUserGroupOnAccount_NG21-849");
			ExecutionResult.issueKey = "NG21-849";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-849");
			SoftAssert soft = new SoftAssert();
			Accounts acc = new Accounts(driver);
			int rowNumber = 0;
			int rowCount = xl.getRowCount(account, "Sheet3");
			PageUtil pageUtil = new PageUtil();

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {

				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

				List<String> inputs = pageUtil.getColumnNamesUsingSheet(account, "Sheet3");

				List<String> output = xl.getDetails(inputs, rowNumber, "Sheet3", xl, account);

				acc.sequenceOfRoleWhileRemovingMultipleRolesFromUserGroupOnAccount(rowNum, output.get(0), output.get(3),
						output.get(1));
			}
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}

	// -------Neha's code---------
	// NG21-672 - Verify that save button should be enabled when user enter all
	// details.
	@Test(groups = { "Accounts Section" })
	public void verifySaveButtonIsEnabledAfterEnteringDataInAccount() {
		SoftAssert softAssert = new SoftAssert();
		ReadConfig mailconfig = new ReadConfig();
		try {
			test = extent.createTest("verifySaveButtonIsEnabledAfterEnteringData_NG21-672");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-672");
			ExecutionResult.issueKey = "NG21-672";
			Accounts acc = new Accounts(driver);
			acc.enableSaveButtonAfterEnteringAllData(softAssert);
			softAssert.assertAll();

		} catch (Exception e) {
			// e.printStackTrace();
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

//NG21-653-Verify Account should be searched from the List of Account. 
	@Test(groups = { "Accounts Section" })
	public void verifyAccounntShouldBeSearchedFromList() {
		SoftAssert softAssert = new SoftAssert();
		ReadConfig mailconfig = new ReadConfig();
		try {
			test = extent.createTest("verifyAccounntShouldBeSearchedFromList_NG21-653");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-653");
			ExecutionResult.issueKey = "NG21-653";
			Accounts acc = new Accounts(driver);
			acc.Acc_SearchfromAccountlisting(acc.Acc_namesearch, softAssert);
			softAssert.assertAll();

		} catch (Exception e) {
			// e.printStackTrace();
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

//NG21-652-Verify New Account Button button should be enabled and Delete Account button should be disabled on the Account listing page.
	@Test(groups = { "Accounts Section" })
	public void verifyNewAccountShouldBeEnabledDeleteShouldbeDisabled() {
		SoftAssert softAssert = new SoftAssert();
		ReadConfig mailconfig = new ReadConfig();
		try {
			test = extent.createTest("verifyNewAccountShouldBeEnabledDeleteShouldbeDisabled_NG21-652");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-652");
			ExecutionResult.issueKey = "NG21-652";
			Accounts acc = new Accounts(driver);
			acc.VerifyButtonsVisiblity(softAssert);
			softAssert.assertAll();

		} catch (Exception e) {
			// e.printStackTrace();
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

//NG21-649-Verify admin can refresh workspace list using refresh button
	@Test(groups = { "Accounts Section" })
	public void verifyAdminCanRefreshWorkspaceListInWksTab() {
		SoftAssert softAssert = new SoftAssert();
		ReadConfig mailconfig = new ReadConfig();
		try {
			test = extent.createTest("verifyAdminCanRefreshWorkspaceListInWksTab_NG21-649");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-649");
			ExecutionResult.issueKey = "NG21-649";
			Accounts acc = new Accounts(driver);
			acc.refreshWorkspaceButton(acc.Acc_namesearch, softAssert);
			softAssert.assertAll();

		} catch (Exception e) {
			// e.printStackTrace();
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	// NG21-872: Verify refresh button functionality at account listing page
	@Test(groups = { "Accounts Section" })
	public void verifyRefreshButtonFunctionalityOnAcountsPage() {
		SoftAssert softAssert = new SoftAssert();
		ReadConfig mailconfig = new ReadConfig();
		try {
			test = extent.createTest("verifyRefreshButtonFunctionalityOnAcountsPage-NG21-872");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-872");
			ExecutionResult.issueKey = "NG21-872";
			Accounts acc = new Accounts(driver);
			acc.RefreshAccountListingPage(softAssert);
			softAssert.assertAll();

		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	
	
	
	//*********** Account Owner ********
	
	
	
	@Test(groups = { "Accounts Owner" })

	public void verifyAccountDropDownShouldShowListOfAccounts() {

		try {

			test = extent.createTest("verifyAccountDropDownShouldShowListOfAccounts_NG21-504");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-504");
			ExecutionResult.issueKey = "NG21-504";
			{
			Accounts a = new Accounts(driver);
			a.accountDropDownShouldShowListOfAccounts(a.selectedAccountName1, a.selectedAccountName2);
			}

			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	
	@Test(groups = { "Accounts Owner" })

	public void verifyCreatePrivateWorkspaceFromWorkspaceSectionByAccountOwner() {

		try {

			test = extent.createTest("verifyCreatePrivateWorkspaceFromWorkspaceSectionByAccountOwner_NG21-505");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-505");
			ExecutionResult.issueKey = "NG21-505";
			{
			Accounts a = new Accounts(driver);
			a.createPrivateWorkspaceFromWorkspaceSectionByAccountOwner(a.accountName, a.iCEDQ_Workspace, a.iCEDQ_WorkspaceDesc, a.privateTypeDetails);
			driver.navigate().refresh();
			}
			
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Accounts Owner" })

	public void verifyCreateSharedWorkspaceFromWorkspaceSectionByAccountOwner() {

		

		try {

			test = extent.createTest("verifyCreateSharedWorkspaceFromWorkspaceSectionByAccountOwner_NG21-506");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-506");
			ExecutionResult.issueKey = "NG21-506";
			{
			Accounts a = new Accounts(driver);
			a.createPrivateWorkspaceFromWorkspaceSectionByAccountOwner(a.accountName, a.iCEDQ_Workspace, a.iCEDQ_WorkspaceDesc, a.sharedTypeDetails);
			driver.navigate().refresh();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Accounts Owner" })

	public void verifyAccountAndTypeShouldNotChangeAfterSavingOrRevisitingWorkspace() {

			try {

			test = extent.createTest("verifyAccountAndTypeShouldNotChangeAfterSavingOrRevisitingWorkspace_NG21-509");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-509");
			ExecutionResult.issueKey = "NG21-509";

			Accounts a = new Accounts(driver);
			a.accountAndTypeAfterSavingOrRevisitingWorkspace(a.constantWorkspaceName);
			
			driver.navigate().refresh();
			
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	
	@Test(groups = { "Accounts Owner" })
	public void verifyAccountOwnerCanAddUserInWorkspaceSection() {

		try {
			test = extent.createTest("verifyAccountOwnerCanAddUserInWorkspaceSection_NG21-511");
			ExecutionResult.issueKey = "NG21-511";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-511");
			SoftAssert soft = new SoftAssert();
			Workspaces ws = new Workspaces(driver);
			int rowNumber = 0;
			int rowCount = xl.getRowCount(workspace, "Sheet1");
			PageUtil pageUtil = new PageUtil();
			
			for (int rowNum = 0; rowNum < rowCount; rowNum++) {

				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

				List<String> inputs = pageUtil.getColumnNamesUsingSheet(workspace, "Sheet1");

				List<String> output = xl.getDetails(inputs, rowNumber, "Sheet1", xl, workspace);

				ws.adminCanAddUserWithRolesInUserGroupOnWorkspaceSection(output.get(0), output.get(1), output.get(2), output.get(3), output.get(4));
			}
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Accounts Owner" })
	public void verifyAccountOwnerCanAddGroupsInWorkspaceSection() {

		try {
			test = extent.createTest("verifyAccountOwnerCanAddGroupsInWorkspaceSection_NG21-512");
			ExecutionResult.issueKey = "NG21-512";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-512");
			SoftAssert soft = new SoftAssert();
			Workspaces ws = new Workspaces(driver);
			int rowNumber = 0;
			int rowCount = xl.getRowCount(workspace, "Sheet1");
			PageUtil pageUtil = new PageUtil();
			
			for (int rowNum = 0; rowNum < rowCount; rowNum++) {

				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

				List<String> inputs = pageUtil.getColumnNamesUsingSheet(workspace, "Sheet1");

				List<String> output = xl.getDetails(inputs, rowNumber, "Sheet1", xl, workspace);

				ws.adminCanAddUserWithRolesInUserGroupOnWorkspaceSection(output.get(0), output.get(1), output.get(2), output.get(3), output.get(4));
			}
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Accounts Owner" })
	public void verifyAccountOwnerCanRemoveRolesFromUserGroupOnWorkspaceSection() {

		try {
			test = extent.createTest("verifyAccountOwnerCanRemoveRolesFromUserGroupOnWorkspaceSection_NG21-514");
			ExecutionResult.issueKey = "NG21-514";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-514");
			SoftAssert soft = new SoftAssert();
			Workspaces ws = new Workspaces(driver);
			int rowNumber = 0;
			int rowCount = xl.getRowCount(workspace, "Sheet2");
			PageUtil pageUtil = new PageUtil();
		
			for (int rowNum = 0; rowNum < rowCount; rowNum++) {

				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

				List<String> inputs = pageUtil.getColumnNamesUsingSheet(workspace, "Sheet2");

				List<String> output = xl.getDetails(inputs, rowNumber, "Sheet2", xl, workspace);

				ws.adminCanRemoveRolesFromUserGroupOnWorkspaceSection(rowNum,output.get(0), output.get(1));
			}
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	
	@Test(groups = { "Accounts Owner" })

	public void verifyWorkspaceShouldShowRoleInheritedWhenUserAddFromAccountSection() {

		try {

			test = extent.createTest("verifyWorkspaceShouldShowRoleInheritedWhenUserAddFromAccountSection_NG21-519");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-519");
			ExecutionResult.issueKey = "NG21-519";
			{
			Accounts a = new Accounts(driver);
			a.workspaceShouldShowRoleInheritedWhenUserAddFromAccountSection(a.selectedAccountName2, a.role, a.accessto, a.addUserInAccount, a.inheritedWorkspaceDetails, a.inheritedRoleDetailsText);
			driver.navigate().refresh();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Accounts Owner" })

	public void verifyWorkspaceShouldShowRoleOwnerWhenUserAddFromWorkspaceSection() {

		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyWorkspaceShouldShowRoleOwnerWhenUserAddFromWorkspaceSection_NG21-521");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-521");
			ExecutionResult.issueKey = "NG21-521";

			Accounts a = new Accounts(driver);
			a.workspaceShouldShowRoleOwnerWhenUserAddFromWorkspaceSection(a.ownerWorkspaceDetails, a.role, a.accessto, a.addUserInWorkspace);
			driver.navigate().refresh();
			
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Owner" })

	public void verifyNumberOfWorkspacesShouldShowForUserAccountOwner() {

		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyNumberOfWorkspacesShouldShowForUserAccountOwner_NG21-522");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-522");
			ExecutionResult.issueKey = "NG21-522";

			Accounts a = new Accounts(driver);
			a.numberOfWorkspacesForAccountOwner();
			driver.navigate().refresh();
			
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Owner" })

	public void verifyAccountOwnerShouldNotAccessUserGroupSection() {

		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyAccountOwnerShouldNotAccessUserGroupSection_NG21-747");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-747");
			ExecutionResult.issueKey = "NG21-747";

			Accounts a = new Accounts(driver);
			a.accountOwnerShouldNotAccessUserGroupSection();
			driver.navigate().refresh();
			
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Accounts Owner" })

	public void verifyAccountOwnerAccessOnListOfAccounts() {

		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyAccountOwnerAccessOnListOfAccounts_NG21-748");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-748");
			ExecutionResult.issueKey = "NG21-748";

			Accounts a = new Accounts(driver);
			a.accountOwnerAccessOnListOfAccounts();
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Accounts Owner" })

	public void verifyAccountOwnerAccessOnListOfWorkspaces() {

		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyAccountOwnerAccessOnListOfWorkspaces_NG21-750");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-750");
			ExecutionResult.issueKey = "NG21-750";

			Accounts a = new Accounts(driver);
			a.accountOwnerAccessOnListOfWorkspaces();
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	
	
	@Test(groups = { "Accounts Owner" })
	public void verifyAccountOwnerAccessOnListOfRoles() {
		SoftAssert soft = new SoftAssert();

		try {
			test = extent.createTest("verifyAccountOwnerAccessOnListOfRoles_NG21-752");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-752");
			ExecutionResult.issueKey = "NG21-752";

			Accounts a = new Accounts(driver);
			a.accountOwnerAccessOnListOfRoles();
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Accounts Owner" })
	public void verifyAccountSearchByAccountOwner() {
		SoftAssert soft = new SoftAssert();

		try {
			test = extent.createTest("verifyAccountSearchByAccountOwner_NG21-755");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-755");
			ExecutionResult.issueKey = "NG21-755";

			Accounts a = new Accounts(driver);
			a.accountSearchByAccountOwner(a.accountName);
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Owner" })
	public void verifyAccountOwnerShouldNotAbleToCreateNewAccount() {
		SoftAssert soft = new SoftAssert();

		try {
			test = extent.createTest("verifyAccountOwnerShouldNotAbleToCreateNewAccount_NG21-758");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-758");
			ExecutionResult.issueKey = "NG21-758";

			Accounts a = new Accounts(driver);
			a.accountOwnerShouldNotAbleToCreateNewAccount(a.accountName, a.accountDescriptionDetails);
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Owner" })
	public void verifyAccountOwnerShouldNotAbleToUpdateExistingAccount() {
		SoftAssert soft = new SoftAssert();

		try {
			test = extent.createTest("verifyAccountOwnerShouldNotAbleToUpdateExistingAccount_NG21-760");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-760");
			ExecutionResult.issueKey = "NG21-760";

			Accounts a = new Accounts(driver);
			a.accountOwnerShouldNotAbleToUpdateExistingAccount(a.accountName, a.updatedAccountName,
					a.updatedAccountDescription);
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Accounts Owner" })

	public void verifyAccountOwnerViewAndAccessTheAccount() {

		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyAccountOwnerViewAndAccessTheAccount_NG21-762");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-762");
			ExecutionResult.issueKey = "NG21-762";

			Accounts a = new Accounts(driver);
			a.verifyAccountOwnerViewAndAccessTheAccount(a.accountName);
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Owner" })

	public void verifyAccountOwnerShouldReadAllListedUserGroupsAndWorkspaceInsideTheAccount() {

		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyAccountOwnerShouldReadAllListedUserGroupsAndWorkspaceInsideTheAccount_NG21-763");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-763");
			ExecutionResult.issueKey = "NG21-763";

			Accounts a = new Accounts(driver);
			a.accountOwnerShouldReadAllListedUserGroupsAndWorkspaceInsideTheAccount(a.accountName);
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Owner" })

	public void verifyAccountOwnerShouldAbleToAddUserToAccount() {

		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyAccountOwnerShouldAbleToAddUserToAccount_NG21-770");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-770");
			ExecutionResult.issueKey = "NG21-770";

			Accounts a = new Accounts(driver);
			a.accountOwnerShouldAbleToAddUserToAccount(a.accountName, a.role, a.accessto, a.addUserInAccount);
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Owner" })

	public void verifyAccountOwnerShouldAbleToAddGroupToAccount() {

		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyAccountOwnerShouldAbleToAddGroupToAccount_NG21-772");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-772");
			ExecutionResult.issueKey = "NG21-772";

			Accounts a = new Accounts(driver);
			a.accountOwnerShouldAbleToAddGroupToAccount(a.accountName, a.role, a.groupAssign, a.accessToGroup);
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Owner" })

	public void verifyAccountOwnerShouldAbleToAddUserAndGroupTogether() {

		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyAccountOwnerShouldAbleToAddUserAndGroupTogether_NG21-775");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-775");
			ExecutionResult.issueKey = "NG21-775";

			Accounts a = new Accounts(driver);
			a.accountOwnerShouldAbleToAddUserAndGroup(a.accountName, a.role,a.accessto, a.addUserInAccount, a.groupAssign, a.accessToGroup);
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	
	@Test(groups = { "Accounts Owner" })

	public void verifyRefreshBtnShouldUpdateDetailsInAddedListOfUserGroup() {

		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyRefreshBtnShouldUpdateDetailsInAddedListOfUserGroup_NG21-777");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-777");
			ExecutionResult.issueKey = "NG21-777";

			Accounts a = new Accounts(driver);
			a.refreshBtnShouldUpdateDetailsInAddedListOfUserGroup(a.accountName, a.role, a.accessto, a.addUserInWorkspace);
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	
	@Test(groups = { "Accounts Owner" })

	public void verifyUserGroupTabShouldShowColumnNames() {

		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyUserGroupTabShouldShowColumnNames_NG21-780");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-780");
			ExecutionResult.issueKey = "NG21-780";

			Accounts a = new Accounts(driver);
			a.userGroupTabShouldShowColumnNames(a.accountName);
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Owner" })

	public void verifyAccountOwnerShouldAbleToRemoveTheUserGroupFromAccount() {

		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyAccountOwnerShouldAbleToRemoveTheUserGroupFromAccount_NG21-781");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-781");
			ExecutionResult.issueKey = "NG21-781";

			Accounts a = new Accounts(driver);
			a.accountOwnerShouldAbleToRemoveTheUserGroupFromAccount(a.accountName, a.addUserInWorkspace);
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Accounts Owner" })
	public void verifyAccountOwnerCanAddNewWorkspaceFromWorkspaceTab() {

		try {
			test = extent.createTest("verifyAdminCanAddNewWorkspaceFromWorkspaceTab_NG21-783");
			ExecutionResult.issueKey = "NG21-783";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-783");
			SoftAssert soft = new SoftAssert();
			Accounts account = new Accounts(driver);
			account.accountOwnerCanAddNewWorkspaceFromWorkspaceTab(account.accountName, account.constantWorkspaceName,
					account.constantWorkspaceDesc);
			driver.navigate().refresh();
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	
	@Test(groups = { "Accounts Owner" })
	public void verifyCreatedWorkspaceFromAccountSectionShouldListedInTheWorkspaceMenu() {

		try {
			test = extent.createTest("verifyCreatedWorkspaceFromAccountSectionShouldListedInTheWorkspaceMenu_NG21-785");
			ExecutionResult.issueKey = "NG21-785";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-785");
			SoftAssert soft = new SoftAssert();
			Accounts account = new Accounts(driver);
			account.createdWorkspaceFromAccountSectionShouldListedInTheWorkspaceMenu(account.accountName, account.constantWorkspaceName,
					account.constantWorkspaceDesc);
			driver.navigate().refresh();
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Accounts Owner" })
	public void verifyAcountOwnerShouldAbleToAddPrivateWorskspaceInAccount() {

		try {
			test = extent.createTest("verifyAcountOwnerShouldAbleToAddPrivateWorskspaceInAccount_NG21-790");
			ExecutionResult.issueKey = "NG21-790";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-790");
			SoftAssert soft = new SoftAssert();
			Accounts a = new Accounts(driver);
			//a.acountOwnerShouldAbleToAddWorskspaceInAccount(a.accountName, a.NextGenWorkspaceName, a.NextGenWorkspaceDesc, a.privateTypeDetails);
			a.acountOwnerShouldAbleToAddWorskspaceInAccount(a.accountName, a.constantWorkspaceName, a.constantWorkspaceDesc, a.privateTypeDetails);
			driver.navigate().refresh();
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Accounts Owner" })
	public void verifyAcountOwnerShouldAbleToAddSharedWorskspaceInAccount() {

		try {
			test = extent.createTest("verifyAcountOwnerShouldAbleToAddSharedWorskspaceInAccount_NG21-791");
			ExecutionResult.issueKey = "NG21-791";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-791");
			SoftAssert soft = new SoftAssert();
			Accounts a = new Accounts(driver);
			//a.acountOwnerShouldAbleToAddWorskspaceInAccount(a.accountName, a.NextGenWorkspaceName, a.NextGenWorkspaceDesc, a.sharedTypeDetails);
			a.acountOwnerShouldAbleToAddWorskspaceInAccount(a.accountName, a.constantWorkspaceName, a.constantWorkspaceDesc, a.sharedTypeDetails);
			driver.navigate().refresh();
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Owner" })
	public void verifyWorkapceDetailsShouldBeDiscardedByAddingOnClickDiscardBtn() {

		try {
			test = extent.createTest("verifyWorkapceDetailsShouldBeDiscardedByAddingOnClickDiscardBtn_NG21-793");
			ExecutionResult.issueKey = "NG21-793";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-793");
			SoftAssert soft = new SoftAssert();
			Accounts a = new Accounts(driver);
			//a.workapceDetailsShouldBeDiscardOnClickDiscardBtn(a.accountName, a.NextGenWorkspaceName, a.NextGenWorkspaceDesc, a.privateTypeDetails);
			a.workapceDetailsShouldBeDiscardOnClickDiscardBtn(a.accountName, a.constantWorkspaceName, a.constantWorkspaceDesc, a.privateTypeDetails);
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Accounts Owner" })
	public void verifyAccountOwnerShouldAbleToViewListOfWorkspacesAndClickOnAssignWorkspace() {

		try {
			test = extent.createTest("verifyAccountOwnerShouldAbleToViewListOfWorkspacesAndClickOnAssignWorkspace_NG21-795");
			ExecutionResult.issueKey = "NG21-795";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-795");
			SoftAssert soft = new SoftAssert();
			Accounts a = new Accounts(driver);
			//a.accountOwnerShouldAbleToViewListOfWorkspacesAndClickOnAssignWorkspace(a.NextGenWorkspaceName);
			a.accountOwnerShouldAbleToViewListOfWorkspacesAndClickOnAssignWorkspace(a.constantWorkspaceName);
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Owner" })
	public void verifyAccountOwnerShouldAbleToCreateWorkspace() {

		try {
			test = extent.createTest("verifyAccountOwnerShouldAbleToCreateWorkspace_NG21-798");
			ExecutionResult.issueKey = "NG21-798";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-798");
			SoftAssert soft = new SoftAssert();
			Accounts a = new Accounts(driver);
			//a.accountOwnerShouldAbleToCreateAndUpdateWorkspaceDetails(a.NextGenAccountName, a.workspaceUpdatedNameDetails, a.workspaceUpdatedDescDetails, a.privateTypeDetails);
			a.accountOwnerShouldAbleToCreateAndUpdateWorkspaceDetails(a.accountName, a.workspaceUpdatedNameDetails, a.workspaceUpdatedDescDetails, a.privateTypeDetails);
			driver.navigate().refresh();
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Owner" })
	public void verifyAccountOwnerShouldAbleToUpdateWorkspaceDetails() {

		try {
			test = extent.createTest("verifyAccountOwnerShouldAbleToUpdateWorkspaceDetails_NG21-797");
			ExecutionResult.issueKey = "NG21-797";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-797");
			SoftAssert soft = new SoftAssert();
			Accounts a = new Accounts(driver);
			//a.accountOwnerShouldAbleToCreateAndUpdateWorkspaceDetails(a.NextGenAccountName, a.workspaceUpdatedNameDetails, a.workspaceUpdatedDescDetails, a.privateTypeDetails);
			a.accountOwnerShouldAbleToCreateAndUpdateWorkspaceDetails(a.accountName, a.workspaceUpdatedNameDetails, a.workspaceUpdatedDescDetails, a.privateTypeDetails);
			driver.navigate().refresh();
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Accounts Owner" })
	public void verifyWorkspaceWithSameInSameAccountShouldNotBeCreated() {

		try {
			test = extent.createTest("verifyWorkspaceWithSameInSameAccountShouldNotBeCreated_NG21-787");
			ExecutionResult.issueKey = "NG21-787";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-787");
			SoftAssert soft = new SoftAssert();
			Accounts a = new Accounts(driver);
		//	a.workspaceWithSameInSameAccountShouldNotBeCreated(a.NextGenAccountName, a.NextGenWorkspaceName, a.NextGenWorkspaceDesc);
			a.workspaceWithSameInSameAccountShouldNotBeCreated(a.accountName, a.constantWorkspaceName, a.constantWorkspaceName);
			driver.navigate().refresh();
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Owner" })
	public void verifyCreateWorkspaceWithSameNameHavingDifferentAccountSelection() {

		try {
			test = extent.createTest("verifyCreateWorkspaceWithSameNameHavingDifferentAccountSelection_NG21-517");
			ExecutionResult.issueKey = "NG21-517";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-517");
			SoftAssert soft = new SoftAssert();
			Accounts a = new Accounts(driver);
			a.createWorkspaceWithSameNameHavingDifferentAccountSelection(a.selectedAccountName1, a.sameWorkspaceName, a.sameWorkspaceDesc, a.privateTypeDetails, a.selectedAccountName2);
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Owner" })
	public void verifyAccountOwnerShouldAbleToLookForAccountUsingPaginationTab()

	{

		try {

			test = extent.createTest("verifyAccountOwnerShouldAbleToLookForAccountUsingPaginationTab_NG21-794");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-794");
			ExecutionResult.issueKey = "NG21-794";
			Accounts work = new Accounts(driver);

			String columnName = "Status";

			int rowNumber = 0;

			String sheetName = "Pagination";

			XLUtils xl = new XLUtils();

			String Users = System.getProperty("user.dir") + "/src/main/resources/testdata/logindetails/AbhiUser1.xlsx";

			int rowCount = xl.getRowCount(Users, "Pagination");

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {
				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

				List<String> inputs = page.getColumnNamesUsingSheet(Users, "Pagination");

				List<String> output = xl.getDetails(inputs, rowNumber, sheetName, xl, Users);

				work.accountSearchWithPagination(output.get(0));

				xl.writeToExcel("Pass", Users, sheetName, rowNumber, columnName);
			}
			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}
	
	
	
	// ******************** Account Contributor ********************
	
	@Test(groups = { "Accounts Contributor" })
	public void verifyAccountContributorShouldNotAccessUserSection() {
		SoftAssert soft = new SoftAssert();
		try {
			test = extent.createTest("verifyAccountContributorShouldNotAccessUserSection_NG21-533");
			ExecutionResult.issueKey = "NG21-533";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-533");
			Accounts a = new Accounts(driver);
			a.accountContributorShouldNotAccessUserSection();
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
			soft.fail();

		}
	}

	@Test(groups = { "Accounts Contributor" })
	public void verifyAccountContributorShouldNotAccessGroupSection() {
		SoftAssert soft = new SoftAssert();
		try {
			test = extent.createTest("verifyAccountContributorShouldNotAccessGroupSection_NG21-534");
			ExecutionResult.issueKey = "NG21-534";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-534");
			Accounts a = new Accounts(driver);
			a.accountContributorShouldNotAccessGroupSection();
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
			soft.fail();

		}
	}

	@Test(groups = { "Accounts Contributor" })
	public void verifyAccountContributorAccessOnListOfAccounts() {

		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyAccountContributorAccessOnListOfAccounts_NG21-535");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-535");
			ExecutionResult.issueKey = "NG21-535";

			Accounts a = new Accounts(driver);
			a.accountContributorAccessOnListOfAccounts();
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}

	@Test(groups = { "Accounts Contributor" })
	public void verifyAccountsContributorCanRefreshUserGroupListUsingRefreshButton() {

		try {
			test = extent.createTest("verifyAccountsContributorCanRefreshUserGroupListUsingRefreshButton_NG21-536");
			ExecutionResult.issueKey = "NG21-536";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-536");
			SoftAssert soft = new SoftAssert();
			Accounts account = new Accounts(driver);
			account.RefreshAccountListingPage(soft);
			account.numberOfAccounts();
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}

	@Test(groups = { "Accounts Contributor" })
	public void verifyAccountSearchByAccountContributor() {
		SoftAssert soft = new SoftAssert();

		try {
			test = extent.createTest("verifyAccountSearchByAccountContributor_NG21-537");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-537");
			ExecutionResult.issueKey = "NG21-537";

			Accounts a = new Accounts(driver);
			//a.accountSearchByAccountContributor(a.NextGenAccountName);
			a.accountSearchByAccountContributor(a.ContributorAccount);
			
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Accounts Contributor" })
	public void verifyDiscardDetailsInExistingAccountByAccountContributor()

	{		try {
			test = extent.createTest("verifyDiscardDetailsInExistingAccountByAccountContributor_NG21-538");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-538");
			ExecutionResult.issueKey = "NG21-538";

			{	Accounts account = new Accounts(driver);
				account.discardDetailsInExistingAccount(account.DiscardaccountName, account.Description,account.DiscardalertYes, account.ContributorAccount);

				driver.navigate().refresh();
			}

			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Accounts Contributor" })
	public void verifyAcountContributorShouldAbleToAddWorskspaceInAccount() {

		try {
			test = extent.createTest("verifyAcountContributorShouldAbleToAddWorskspaceInAccount_NG21-539");
			ExecutionResult.issueKey = "NG21-539";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-539");
			SoftAssert soft = new SoftAssert();
			Accounts a = new Accounts(driver);
			//a.acountContributorShouldAbleToAddWorskspaceInAccount(a.NextGenAccountName, a.NextGenWorkspaceName, a.NextGenWorkspaceDesc, a.privateTypeDetails);
			a.acountContributorShouldAbleToAddWorskspaceInAccount(a.ContributorAccount, a.NextGenWorkspaceName, a.NextGenWorkspaceDesc, a.privateTypeDetails);
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Contributor" })
	public void verifyAccountContributorShouldNotAbleToAddUserGroupInAccount() {

		try {
			test = extent.createTest("verifyAccountContributorShouldNotAbleToAddUserGroupInAccount_NG21-540");
			ExecutionResult.issueKey = "NG21-540";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-540");
			SoftAssert soft = new SoftAssert();
			Accounts a = new Accounts(driver);
			a.accountContributorShouldNotAbleToAddUserGroupInAccount(a.ContributorAccount, a.role, a.accessto,a.addUserInAccount);

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Accounts Contributor" })
	public void verifyAccountContributorShouldNotAbleToAddUserGroupInWorkspace() {

		try {
			test = extent.createTest("verifyAccountContributorShouldNotAbleToAddUserGroupInWorkspace_NG21-541");
			ExecutionResult.issueKey = "NG21-541";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-541");

			Accounts a = new Accounts(driver);

			//a.accountContributorShouldNotAbleToAddUserGroupInWorkspace(a.searchNextGenWorkspaceName, a.role, a.accessto,a.addUserInAccount);
			//a.accountContributorShouldNotAbleToAddUserGroupInWorkspace(a.searchNextGenWorkspaceName, a.role, a.accessto,a.addUserInAccount);
			a.accountContributorShouldNotAbleToAddUserGroupInWorkspace(a.ContributorWorkspace, a.role, a.accessto, a.addUserInAccount);
			softAssert.assertAll();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@Test(groups = { "Accounts Contributor" })
	public void verifyAccountContributorShouldNotAbleToAddUserGroupInWorkspaceCreatedByOtherUser() {

		try {
			test = extent.createTest(
					"verifyAccountContributorShouldNotAbleToAddUserGroupInWorkspaceCreatedByOtherUser_NG21-542");
			ExecutionResult.issueKey = "NG21-542";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-542");

			Accounts a = new Accounts(driver);

			//a.accountContributorShouldNotAbleToAddUserGroupInWorkspace(a.constantWorkspaceName, a.role, a.accessto,a.addUserInAccount);
			a.accountContributorShouldNotAbleToAddUserGroupInWorkspace(a.ContributorWorkspace, a.role, a.accessto,a.addUserInAccount);
			softAssert.assertAll();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test(groups = { "Accounts Contributor" })
	public void verifyAccountContributorShouldAbleToViewWorkspacePageAndListOfWorkspaces() {

		try {
			test = extent.createTest(
					"verifyAccountContributorShouldAbleToViewWorkspacePageAndListOfWorkspaces_NG21-543");
			ExecutionResult.issueKey = "NG21-543";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-543");

			Accounts a = new Accounts(driver);

			a.accountContributorShouldAbleToViewWorkspacePageAndListOfWorkspaces();
			softAssert.assertAll();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	
	@Test(groups = { "Accounts Contributor" })
	public void verifyAccountContAbleToRefreshWorkspaceList() {

		try {
			test = extent.createTest("verifyAccountContAbleToRefreshWorkspaceList_NG21-544");
			ExecutionResult.issueKey = "NG21-544";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-544");
			SoftAssert soft = new SoftAssert();
			Accounts a = new Accounts(driver);

			a.accountContAbleToRefreshWorkspaceList(soft);
			softAssert.assertAll();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	@Test(groups = { "Accounts Contributor" })
	public void verifyAccountContShouldAbleToCreateAndUpdateWorkspace() {

		try {
			test = extent.createTest("verifyAccountContShouldAbleToCreateAndUpdateWorkspace_NG21-545");
			ExecutionResult.issueKey = "NG21-545";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-545");
			SoftAssert soft = new SoftAssert();
			Accounts a = new Accounts(driver);
			//a.accountOwnerShouldAbleToCreateAndUpdateWorkspaceDetails(a.NextGenAccountName, a.updateAccContrWS, a.updateAccContrWS, a.privateTypeDetails);
			a.accountOwnerShouldAbleToCreateAndUpdateWorkspaceDetails(a.ContributorAccount, a.updateAccContrWS, a.updateAccContrWS, a.privateTypeDetails);
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Contributor" })
	public void verifyAccountContShouldUpdateWorkspace() {

		try {
			test = extent.createTest("verifyAccountContShouldUpdateWorkspace_NG21-546");
			ExecutionResult.issueKey = "NG21-546";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-546");
			SoftAssert soft = new SoftAssert();
			Accounts a = new Accounts(driver);
			//a.accountOwnerShouldAbleToCreateAndUpdateWorkspaceDetails(a.NextGenAccountName, a.updateAccContrWS, a.updateAccContrWS, a.privateTypeDetails);
			a.accountOwnerShouldAbleToCreateAndUpdateWorkspaceDetails(a.ContributorAccount, a.updateAccContrWS, a.updateAccContrWS, a.privateTypeDetails);
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Accounts Contributor" })
	public void verifyAccountContShouldDiscardUnSavedChangesInExistingWorksapce()
	{
		try {
			test = extent.createTest("verifyAccountContShouldDiscardDetailsInExistingWorksapce_NG21-551");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-551");
			ExecutionResult.issueKey = "NG21-551";
			{
				
				Accounts a = new Accounts(driver);
				
				a.accountContShouldDiscardUnSavedChangesInExistingWorksapce(a.ContributorWorkspace);
				//w.searchWorkspaceAndClick(a.searchNextGenWorkspaceName);
				//work.discardDetailsInExistingWorkspace(work.DiscardworkspaceName, work.Description, work.DiscardalertYes, a.searchNextGenWorkspaceName);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Contributor" })
	public void verifyRoleAssignWindowDetailsForWorkspace()
	{
		try {
			test = extent.createTest("verifyRoleAssignWindowDetailsForWorkspace_NG21-555");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-555");
			ExecutionResult.issueKey = "NG21-555";
			{
				Accounts a = new Accounts(driver);
				Workspaces w = new Workspaces(driver);
				w.clickOnWorkspaceMenu();
				w.searchWorkspaceAndClick(a.ContributorWorkspace);
				a.roleAssignWindowDetailsForWorkspace();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Accounts Contributor" })
	public void verifyWorkspaceNameShouldNotAcceptInvalidData() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyWorkspaceNameShouldNotAcceptInvalidData_NG21-553");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-553");
			ExecutionResult.issueKey = "NG21-553";

			Workspaces w = new Workspaces(driver);
			Accounts a = new Accounts(driver);
			w.clickOnWorkspaceMenu();
			w.clickOnNewWorkspaceButton();
			a.workspaceNameShouldNotAcceptInvalidData(soft);
			
			int rowNumber = 0;

			String users = System.getProperty("user.dir")
					+ "\\src\\main\\resources\\testdata\\logindetails\\FieldsValidationCheck.xlsx";
			int rowCount = xl.getRowCount(users, "NegativeData");

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {
				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");
				List<String> inputs = page.getColumnNamesUsingSheet(users, "NegativeData");

				List<String> output = xl.getDetails(inputs, rowNumber, "NegativeData", xl, users);

				w.workspaceNameValidate(output.get(1), output.get(2), w.WorkspaceName, w.workspaceNameMandatoryVal,
						output.get(0), "WorkspaceName", w.workspaceNameSpecialCharError, w.workspaceNameMandatoryText,
						w.workspaceNameSpecialCharVal);

			}

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}
	
	@Test(groups = { "Accounts Contributor" })
	public void verifyAccountContShouldAbleToAddWorkspaceFromWorkspaceSection()
	{
		try {
			test = extent.createTest("verifyAccountContShouldAbleToAddWorkspaceFromWorkspaceSection_NG21-956");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-956");
			ExecutionResult.issueKey = "NG21-956";
			{
				
				Accounts a = new Accounts(driver);
				//a.accountContributorShouldAbleToAddWorkspaceFromWorkspaceSection(a.NextGenAccountName,a.Workspace, a.Workspace, a.privateTypeDetails);
				//a.accountContributorShouldAbleToAddWorkspaceFromWorkspaceSection(a.ContributorAccount,a.Workspace, a.Workspace, a.privateTypeDetails);
				a.accountContributorShouldAbleToAddWorkspaceFromWorkspaceSection(a.ContributorAccount,a.updateAccContrWS, a.updateAccContrWS, a.privateTypeDetails);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Contributor" })
	public void verifyAccountContShouldNotAbleToRemoveUserFromTheAccount() {
		try {
			test = extent.createTest("verifyAccountContShouldNotAbleToRemoveUserFromTheAccount_NG21-957");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-957");
			ExecutionResult.issueKey = "NG21-957";
			{

				Accounts a = new Accounts(driver);
				//a.accountContributorShouldNotAbleToRemoveUserFromTheAccount(a.NextGenAccountName);
				a.accountContributorShouldNotAbleToRemoveUserFromTheAccount(a.ContributorAccount);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Contributor" })
	public void verifyAccountContShouldNotAbleToRemoveUserFromTheWorkspace() {
		try {
			test = extent.createTest("verifyAccountContShouldNotAbleToRemoveUserFromTheWorkspace_NG21-958");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-958");
			ExecutionResult.issueKey = "NG21-958";
			{

				Accounts a = new Accounts(driver);
				a.accountContributorShouldNotAbleToRemoveUserFromTheWorkspace(a.ContributorWorkspace);
				driver.navigate().refresh();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Accounts Contributor" })
	public void verifyAccountContributorShouldNotAbleToCreateAccount() {
		try {
			test = extent.createTest("verifyAccountContributorShouldNotAbleToCreateAccount_NG21-959");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-959");
			ExecutionResult.issueKey = "NG21-959";
			{

				Accounts a = new Accounts(driver);
				//a.accountContributorShouldNotAbleToCreateAccount(a.NextGenAccountName, a.NextGenAccountDesc);
				a.accountContributorShouldNotAbleToCreateAccount(a.NextGenAccountName, a.NextGenAccountDesc);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Contributor" })
	public void verifyAccountContributorShouldNotAbleToUpdateExistingAccount()
	{
		try {
			test = extent.createTest("verifyAccountContShouldDiscardDetailsInExistingWorksapce_NG21-960");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-960");
			ExecutionResult.issueKey = "NG21-960";
			{
			
				Accounts a = new Accounts(driver);
				//a.accountContributorShouldNotAbleToUpdateExistingAccount(a.NextGenAccountName, a.updatedAccountName, a.updatedAccountDescription);
	
				a.accountContributorShouldNotAbleToUpdateExistingAccount(a.ContributorAccount, a.updatedAccountName, a.updatedAccountDescription);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	// ******************** Account Executor ********************
	
	
	@Test(groups = { "Accounts Executor" })
	public void verifyAccountExecutorShouldNotAccessUserSection() {
		try {
			test = extent.createTest("verifyAccountExecutorShouldNotAccessUserSection_NG21-558");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-558");
			ExecutionResult.issueKey = "NG21-558";
			{

				Accounts a = new Accounts(driver);
				a.accountExecutorShouldNotAccessUserSection();

			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Accounts Executor" })
	public void verifyAccountExecutorShouldNotAccessGroupSection() {
		try {
			test = extent.createTest("verifyAccountExecutorShouldNotAccessGroupSection_NG21-560");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-560");
			ExecutionResult.issueKey = "NG21-560";
			{

				Accounts a = new Accounts(driver);
				a.accountExecutorShouldNotAccessGroupSection();

			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Accounts Executor" })
	public void verifyAccountExecutorAccessOnListOfAccounts() {
		try {
			test = extent.createTest("verifyAccountExecutorAccessOnListOfAccounts_NG21-585");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-585");
			ExecutionResult.issueKey = "NG21-585";
			{

				Accounts a = new Accounts(driver);
				a.accountExecutorAccessOnListOfAccounts();

			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Executor" })
	public void verifyAccountExecutorCanRefreshAccountListingPage() {
		try {
			test = extent.createTest("verifyAccountExecutorCanRefreshAccountListingPage_NG21-588");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-588");
			ExecutionResult.issueKey = "NG21-588";
			{
				Accounts a = new Accounts(driver);
				a.accountExecutorCanRefreshAccountListingPage();
				a.numberOfAccounts();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Accounts Executor" })
	public void verifyAccountSearchByAccountExecutor() {
		try {
			test = extent.createTest("verifyAccountSearchByAccountExecutor_NG21-589");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-589");
			ExecutionResult.issueKey = "NG21-589";
			{
				Accounts a = new Accounts(driver);
				a.accountSearchByAccountExecutor(a.ExecutorAccount);
				
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Executor" })
	public void verifyAccountExecutorAbleToDiscardUnsavedChangesInAccount() {
		try {
			test = extent.createTest("verifyAccountExecutorAbleToDiscardUnsavedChangesInAccount_NG21-592");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-592");
			ExecutionResult.issueKey = "NG21-592";
			{
				Accounts account = new Accounts(driver);
				account.accountExecutorAbleToDiscardUnsavedChangesInAccount(account.NextGenWorkspaceName, account.NextGenWorkspaceDesc,account.DiscardalertYes, account.ExecutorAccount);
				driver.navigate().refresh();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Executor" })
	public void verifyAccountExecutorAccessListOfRoles() {

		try {
			test = extent.createTest("verifyAccountExecutorAccessListOfRoles_NG21-596");
			ExecutionResult.issueKey = "NG21-596";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-596");
			int rowNumber = 0;
			int rowCount = xl.getRowCount(roles, "Sheet3");
			SoftAssert soft = new SoftAssert();
			Roles role = new Roles(driver);
			PageUtil pageUtil = new PageUtil();
			role.clickOnRolesMenu();

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {

				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

				List<String> inputs = pageUtil.getColumnNamesUsingSheet(roles, "Sheet3");

				List<String> output = xl.getDetails(inputs, rowNumber, "Sheet3", xl, roles);

				role.rolesShouldSearchedFromListOfRoles(output.get(0), output.get(1));

			}
			role.navigateToRoles();
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Accounts Executor" })
	public void verifyAccountExecutorAbleToReadAccountDetails() {
		try {
			test = extent.createTest("verifyAccountExecutorAbleToReadAccountDetails_NG21-599");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-599");
			ExecutionResult.issueKey = "NG21-599";
			{
				Accounts a = new Accounts(driver);
				a.accountExecutorAbleToReadAccountDetails(a.ExecutorAccount);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Accounts Executor" })
	public void verifyAccountExecutorShouldNotAbleToUpdateExistingAccount() {
		try {
			test = extent.createTest("verifyAccountExecutorShouldNotAbleToUpdateExistingAccount_NG21-601");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-601");
			ExecutionResult.issueKey = "NG21-601";
			{
				Accounts a = new Accounts(driver);
				a.accountExecutorShouldNotAbleToUpdateExistingAccount(a.ExecutorAccount, a.updatedAccountName, a.updatedAccountDescription);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Executor" })
	public void verifyAccountExecutorShouldNotAbleToAddUserGroupInAccount() {
		try {
			test = extent.createTest("verifyAccountExecutorShouldNotAbleToAddUserGroupInAccount_NG21-602");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-602");
			ExecutionResult.issueKey = "NG21-602";
			{
				Accounts a = new Accounts(driver);
				a.accountExecutorShouldNotAbleToAddUserGroupInAccount(a.ExecutorAccount, a.role, a.accessto,a.addUserInAccount);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Executor" })
	public void verifyRoleAssignWindowDetailsInsideAccountForAccountExecutor()
	{
		try {
			test = extent.createTest("verifyRoleAssignWindowDetailsInsideAccountForAccountExecutor_NG21-607");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-607");
			ExecutionResult.issueKey = "NG21-607";
			{
				Accounts a = new Accounts(driver);
				a.clickOnAccountsMenu();
				a.searchAccountAndClick(a.ExecutorAccount);
				a.roleAssignWindowDetailsForWorkspace();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Accounts Executor" })
	public void verifyAccountExecutorCanRefreshUserListUnderUserGroupTabInAccount()
	{
		try {
			test = extent.createTest("verifyAccountExecutorCanRefreshUserListUnderUserGroupTabInAccount_NG21-609");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-609");
			ExecutionResult.issueKey = "NG21-609";
			{
				Accounts a = new Accounts(driver);
				a.accountExecutorCanRefreshUserListUnderUserGroupTabInAccount(a.ExecutorAccount);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Executor" })
	public void verifyAccountExecutorShouldNotAbleToRemoveUserFromTheAccount() {
		try {
			test = extent.createTest("verifyAccountExecutorShouldNotAbleToRemoveUserFromTheAccount_NG21-611");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-611");
			ExecutionResult.issueKey = "NG21-611";
			{
				Accounts a = new Accounts(driver);
				a.accountExecutorShouldNotAbleToRemoveUserFromTheAccount(a.ExecutorAccount);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Accounts Executor" })
	public void verifyAccountExecutorShouldReadAllListedUserGroupsAndWorkspaceInsideTheAccount() {
		try {
			test = extent.createTest("verifyAccountExecutorShouldReadAllListedUserGroupsAndWorkspaceInsideTheAccount_NG21-615");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-615");
			ExecutionResult.issueKey = "NG21-615";
			{
				Accounts a = new Accounts(driver);
				a.accountExecutorShouldReadAllListedWorkspaceInsideTheAccount(a.ExecutorAccount);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Accounts Executor" })
	public void verifyAccountExecutorShouldNotAbleToCreateWorkspaceFromAccountSection() {
		try {
			test = extent.createTest("verifyAccountExecutorShouldNotAbleToCreateWorkspaceFromAccountSection_NG21-617");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-617");
			ExecutionResult.issueKey = "NG21-617";
			{
				Accounts a = new Accounts(driver);
				a.accountExecutorShouldNotAbleToCreateWorkspaceFromAccountSection(a.ExecutorAccount, a.NextGenWorkspaceName, a.NextGenWorkspaceDesc, a.privateTypeDetails);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Accounts Executor" })
	public void verifyAccountExecutorCanRefreshUserListUnderWorkspaceTabInAccount() {
		try {
			test = extent.createTest("verifyAccountExecutorCanRefreshUserListUnderWorkspaceTabInAccount_NG21-620");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-620");
			ExecutionResult.issueKey = "NG21-620";
			{
				Accounts a = new Accounts(driver);
				a.accountExecutorCanRefreshUserListUnderWorkspaceTabInAccount(a.ExecutorAccount);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Accounts Executor" })
	public void verifyAccountExecutorAccessOnListOfWorkspaces() {
		try {
			test = extent.createTest("verifyAccountExecutorAccessOnListOfWorkspaces_NG21-623");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-623");
			ExecutionResult.issueKey = "NG21-623";
			{
				Accounts a = new Accounts(driver);
				a.accountExecutorAccessOnListOfWorkspaces();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Accounts Executor" })
	public void verifyAccountExecutorWithInheritedWorkspacesList() {
		try {
			test = extent.createTest("verifyAccountExecutorAccessOnListOfWorkspaces_NG21-625");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-625");
			ExecutionResult.issueKey = "NG21-625";
			{
				Accounts a = new Accounts(driver);
				a.accountExecutorWithInheritedWorkspacesList(a.ExecutorAccount);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Executor" })
	public void verifyAccountExecutorShouldNotCreateWorkspaceFromWorkspaceSection() {
		try {
			test = extent.createTest("verifyAccountExecutorShouldNotAbleToCreateWorkspaceFromWorkspaceSection_NG21-628");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-628");
			ExecutionResult.issueKey = "NG21-628";
			{
				Workspaces w = new Workspaces(driver);
				Accounts a = new Accounts(driver);
				w.clickOnWorkspaceMenu();
				w.clickOnNewWorkspaceButton();
				a.accountExecutorShouldNotCreateWorkspaceFromWorkspaceSection(a.ExecutorAccount, a.NextGenWorkspaceName, a.NextGenWorkspaceDesc, a.privateTypeDetails);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Accounts Executor" })
	public void verifyAccountExecutorShouldNotUpdateExistingWorkspace() {
		try {
			test = extent.createTest("verifyAccountExecutorShouldNotUpdateExistingWorkspace_NG21-638");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-638");
			ExecutionResult.issueKey = "NG21-638";
			{
				Accounts a = new Accounts(driver);
				a.accountExecutorShouldNotUpdateExistingWorkspace(a.ExecutorWS, a.NextGenWorkspaceName, a.NextGenWorkspaceDesc);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Executor" })
	public void verifyAccountExecutorShouldNotAbleToAddUserGroupInWorkspace() {
		try {
			test = extent.createTest("verifyAccountExecutorShouldNotAbleToAddUserGroupInWorkspace_NG21-642");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-642");
			ExecutionResult.issueKey = "NG21-642";
			{
				Accounts a = new Accounts(driver);
				a.accountExecutorShouldNotAbleToAddUserGroupInWorkspace(a.ExecutorWS, a.role, a.accessto, a.addUserInAccount);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	

	
	@Test(groups = { "Accounts Executor" })
	public void verifyRoleAssignWindowDetailsInsideWorkspaceForAccountExecutor()
	{
		try {
			test = extent.createTest("verifyRoleAssignWindowDetailsInsideWorkspaceForAccountExecutor_NG21-646");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-646");
			ExecutionResult.issueKey = "NG21-646";
			{
				Accounts a = new Accounts(driver);
				Workspaces w = new Workspaces(driver);
				w.clickOnWorkspaceMenu();
				w.searchWorkspaceAndClick(a.ExecutorWS);
				a.roleAssignWindowDetailsForWorkspace();
				driver.navigate().refresh();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Accounts Executor" })
	public void verifyAccountExecutorShouldNotAbleToRemoveUserFromTheWorkspace() {
		try {
			test = extent.createTest("verifyAccountExecutorShouldNotAbleToRemoveUserFromTheWorkspace_NG21-651");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-651");
			ExecutionResult.issueKey = "NG21-651";
			{

				Accounts a = new Accounts(driver);
				a.accountContributorShouldNotAbleToRemoveUserFromTheWorkspace(a.ExecutorWS);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Accounts Executor" })
	public void verifyAccountExecutorCanRefreshUserList()
	{
		try {
			test = extent.createTest("verifyAccountExecutorCanRefreshUserList_NG21-656");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-656");
			ExecutionResult.issueKey = "NG21-656";
			{
				Accounts a = new Accounts(driver);
				a.accountExecutorCanRefreshUserListUnderUserGroupTabInAccount(a.ExecutorAccount);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Accounts Executor" })
	public void verifyAccountExecutorCanAccessAccountWhenRoleAssignedAtGrouplevel()
	{
		try {
			test = extent.createTest("verifyAccountExecutorCanAccessAccountWhenRoleAssignedAtGrouplevel_NG21-659");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-659");
			ExecutionResult.issueKey = "NG21-659";
			{
				Accounts a = new Accounts(driver);
				a.accountExecutorCanAccessAccountWhenRoleAssignedAtGrouplevel(a.ExecutorAccount, a.groupDetailsForAccExe, "Group");
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	// ******************** Account Reader ********************

	
	
	@Test(groups = { "Accounts Reader" })
	public void verifyAccountReaderShouldNotAccessUserSection() {
		try {
			test = extent.createTest("verifyAccountReaderShouldNotAccessUserSection_NG21-664");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-664");
			ExecutionResult.issueKey = "NG21-664";
			{

				Accounts a = new Accounts(driver);
				a.accountExecutorShouldNotAccessUserSection();

			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}

	@Test(groups = { "Accounts Reader" })
	public void verifyAccountReaderShouldNotAccessGroupSection() {
		try {
			test = extent.createTest("verifyAccountReaderShouldNotAccessGroupSection_NG21-669");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-669");
			ExecutionResult.issueKey = "NG21-669";
			{
				Accounts a = new Accounts(driver);
				a.accountExecutorShouldNotAccessGroupSection();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Reader" })
	public void verifyReaderContributorAccessOnListOfAccounts() {

		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyAccountContributorAccessOnListOfAccounts_NG21-674");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-674");
			ExecutionResult.issueKey = "NG21-674";

			Accounts a = new Accounts(driver);
			a.accountReaderAccessOnListOfAccounts();
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Accounts Reader" })
	public void verifyAccountReaderAccessListOfRoles() {

		try {
			test = extent.createTest("verifyAccountReaderAccessListOfRoles_NG21-676");
			ExecutionResult.issueKey = "NG21-676";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-676");
			int rowNumber = 0;
			int rowCount = xl.getRowCount(roles, "Sheet3");
			SoftAssert soft = new SoftAssert();
			Roles role = new Roles(driver);
			PageUtil pageUtil = new PageUtil();
			role.clickOnRolesMenu();

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {

				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

				List<String> inputs = pageUtil.getColumnNamesUsingSheet(roles, "Sheet3");

				List<String> output = xl.getDetails(inputs, rowNumber, "Sheet3", xl, roles);

				role.rolesShouldSearchedFromListOfRoles(output.get(0), output.get(1));

			}
			role.navigateToRoles();
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Reader" })
	public void verifyAccountReaderAccessOnListOfWorkspaces() {
		try {
			test = extent.createTest("verifyAccountReaderAccessOnListOfWorkspaces_NG21-681");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-681");
			ExecutionResult.issueKey = "NG21-681";
			{
				Accounts a = new Accounts(driver);
				a.accountReaderAccessOnListOfWorkspaces();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Reader" })
	public void verifyAccountReaderAccessOnListOfRoles() {
		try {
			test = extent.createTest("verifyAccountReaderAccessOnListOfRoles_NG21-682");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-682");
			ExecutionResult.issueKey = "NG21-682";
			{
				Accounts a = new Accounts(driver);
				a.accountReaderAccessOnListOfRoles();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Reader" })
	public void verifyAccountSearchByAccountReader() {
		try {
			test = extent.createTest("verifyAccountSearchByAccountReader_NG21-683");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-683");
			ExecutionResult.issueKey = "NG21-683";
			{
				Accounts a = new Accounts(driver);
				a.accountSearchByAccountReader(a.ReaderAccount);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Reader" })
	public void verifyAccountReaderShouldNotAbleToCreateAccount() {
		try {
			test = extent.createTest("verifyAccountReaderShouldNotAbleToCreateAccount_NG21-684");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-684");
			ExecutionResult.issueKey = "NG21-684";
			{
				Accounts a = new Accounts(driver);
				a.accountReaderShouldNotAbleToCreateAccount(a.NextGenAccountName, a.NextGenAccountDesc);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Accounts Reader" })
	public void verifyAccountReaderShouldNotAbleToUpdateExistingAccount() {
		try {
			test = extent.createTest("verifyAccountReaderShouldNotAbleToUpdateExistingAccount_NG21-686");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-686");
			ExecutionResult.issueKey = "NG21-686";
			{
				Accounts a = new Accounts(driver);
				a.accountReaderShouldNotAbleToUpdateExistingAccount(a.ReaderAccount, a.updatedAccountName, a.updatedAccountDescription);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Accounts Reader" })
	public void verifyAccountReaderAbleToReadAccountDetails() {
		try {
			test = extent.createTest("verifyAccountReaderAbleToReadAccountDetails_NG21-701");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-701");
			ExecutionResult.issueKey = "NG21-701";
			{
				Accounts a = new Accounts(driver);
				a.accountReaderAbleToReadAccountDetails(a.ReaderAccount);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Reader" })
	public void verifyAccountReaderShouldReadAllListedUserGroupsAndWorkspaceInsideTheAccount() {
		try {
			test = extent.createTest("verifyAccountReaderShouldReadAllListedUserGroupsAndWorkspaceInsideTheAccount_NG21-709");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-709");
			ExecutionResult.issueKey = "NG21-709";
			{
				Accounts a = new Accounts(driver);
				a.accountExecutorShouldReadAllListedWorkspaceInsideTheAccount(a.ReaderAccount);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Accounts Reader" })
	public void verifyAccountReaderShouldNotAbleToAddUserGroupInAccount() {
		try {
			test = extent.createTest("verifyAccountReaderShouldNotAbleToAddUserGroupInAccount_NG21-712");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-712");
			ExecutionResult.issueKey = "NG21-712";
			{
				Accounts a = new Accounts(driver);
				a.accountReaderShouldNotAbleToAddUserGroupInAccount(a.ReaderAccount, a.role, a.accessto, a.addUserInAccount);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Accounts Reader" })
	public void verifyAccountReaderShouldNotAbleToRemoveUserFromTheAccount() {
		try {
			test = extent.createTest("verifyAccountReaderShouldNotAbleToRemoveUserFromTheAccount_NG21-716");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-716");
			ExecutionResult.issueKey = "NG21-716";
			{
				Accounts a = new Accounts(driver);
				a.accountReaderShouldNotAbleToRemoveUserFromTheAccount(a.ReaderAccount);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Reader" })
	public void verifyAccountReaderShouldNotAbleToCreateWorkspaceFromAccountSection() {
		try {
			test = extent.createTest("verifyAccountReaderShouldNotAbleToCreateWorkspaceFromAccountSection_NG21-722");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-722");
			ExecutionResult.issueKey = "NG21-722";
			{
				Accounts a = new Accounts(driver);
				a.accountReaderShouldNotAbleToCreateWorkspaceFromAccountSection(a.ReaderAccount, a.NextGenWorkspaceName, a.NextGenWorkspaceDesc, a.privateTypeDetails);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Reader" })
	public void verifyAccountReaderAccessOnListOfWorkspacesAndClick() {
		try {
			test = extent.createTest("verifyAccountReaderAccessOnListOfWorkspacesAndClick_NG21-723");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-723");
			ExecutionResult.issueKey = "NG21-723";
			{
				Accounts a = new Accounts(driver);
				a.accountReaderAccessOnListOfWorkspacesAndClick(a.AccReaderWorkspaceDetails);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Accounts Reader" })
	public void verifyAccountReaderShouldNotUpdateExistingWorkspace() {
		try {
			test = extent.createTest("verifyAccountReaderShouldNotUpdateExistingWorkspace_NG21-725");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-725");
			ExecutionResult.issueKey = "NG21-725";
			{
				Accounts a = new Accounts(driver);
				a.accountReaderShouldNotUpdateExistingWorkspace(a.AccReaderWorkspaceDetails, a.NextGenWorkspaceName, a.NextGenWorkspaceDesc);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Accounts Reader" })
	public void verifyAccountReaderShouldNotCreateWorkspaceFromWorkspaceSection() {
		try {
			test = extent.createTest("verifyAccountReaderShouldNotCreateWorkspaceFromWorkspaceSection_NG21-726");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-726");
			ExecutionResult.issueKey = "NG21-726";
			{
				Workspaces w = new Workspaces(driver);
				Accounts a = new Accounts(driver);
				w.clickOnWorkspaceMenu();
				w.clickOnNewWorkspaceButton();
				a.accountReaderShouldNotCreateWorkspaceFromWorkspaceSection(a.ReaderAccount, a.NextGenWorkspaceName, a.NextGenWorkspaceDesc, a.privateTypeDetails);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Accounts Reader" })
	public void verifyAccountReaderShouldNotAbleToAddUserGroupInWorkspace() {
		try {
			test = extent.createTest("verifyAccountReaderShouldNotAbleToAddUserGroupInWorkspace_NG21-727");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-727");
			ExecutionResult.issueKey = "NG21-727";
			{
				Accounts a = new Accounts(driver);
				a.accountReaderShouldNotAbleToAddUserGroupInWorkspace(a.AccReaderWorkspaceDetails, a.role, a.accessto, a.addUserInAccount);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Accounts Reader" })
	public void verifyAccountReaderShouldNotAbleToRemoveUserFromTheWorkspace() {
		try {
			test = extent.createTest("verifyAccountReaderShouldNotAbleToRemoveUserFromTheWorkspace_NG21-729");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-729");
			ExecutionResult.issueKey = "NG21-729";
			{
				Accounts a = new Accounts(driver);
				a.accountReaderShouldNotAbleToRemoveUserFromTheWorkspace(a.AccReaderWorkspaceDetails);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Accounts Reader" })
	public void verifyAccountReaderAbleToDiscardUnsavedChangesInAccount() {
		try {
			test = extent.createTest("verifyAccountReaderAbleToDiscardUnsavedChangesInAccount_NG21-730");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-730");
			ExecutionResult.issueKey = "NG21-730";
			{
				Accounts account = new Accounts(driver);
				account.accountExecutorAbleToDiscardUnsavedChangesInAccount(account.NextGenWorkspaceName, account.NextGenWorkspaceDesc,account.DiscardalertYes, account.ReaderAccount);
				driver.navigate().refresh();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Accounts Reader" })
	public void verifyRoleAssignWindowDetailsInsideAccountForAccountReader()
	{
		try {
			test = extent.createTest("verifyRoleAssignWindowDetailsInsideAccountForAccountReader_NG21-732");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-732");
			ExecutionResult.issueKey = "NG21-732";
			{
				Accounts a = new Accounts(driver);
				a.clickOnAccountsMenu();
				a.searchAccountAndClick(a.ReaderAccount);
				a.roleAssignWindowDetailsForWorkspace();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Accounts Reader" })
	public void verifyAccountReaderCanRefreshUserListUnderUserGroupTabInAccount()
	{
		try {
			test = extent.createTest("verifyAccountReaderCanRefreshUserListUnderUserGroupTabInAccount_NG21-733");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-733");
			ExecutionResult.issueKey = "NG21-733";
			{
				Accounts a = new Accounts(driver);
				a.accountExecutorCanRefreshUserListUnderUserGroupTabInAccount(a.ReaderAccount);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Reader" })
	public void verifyAccountReaderCanRefreshUserListUnderWorkspaceTabInAccount() {
		try {
			test = extent.createTest("verifyAccountReaderCanRefreshUserListUnderWorkspaceTabInAccount_NG21-735");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-735");
			ExecutionResult.issueKey = "NG21-735";
			{
				Accounts a = new Accounts(driver);
				a.accountExecutorCanRefreshUserListUnderWorkspaceTabInAccount(a.ReaderAccount);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Reader" })
	public void verifyAccountReaderWithInheritedWorkspacesList() {
		try {
			test = extent.createTest("verifyAccountReaderWithInheritedWorkspacesList_NG21-737");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-737");
			ExecutionResult.issueKey = "NG21-737";
			{
				Accounts a = new Accounts(driver);
				a.accountReaderWithInheritedWorkspacesList(a.ReaderAccount);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Reader" })
	public void verifyAccountReaderShouldNotCreateWorkspace() {
		try {
			test = extent.createTest("verifyAccountReaderShouldNotCreateWorkspace_NG21-738");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-738");
			ExecutionResult.issueKey = "NG21-738";
			{
				Workspaces w = new Workspaces(driver);
				Accounts a = new Accounts(driver);
				w.clickOnWorkspaceMenu();
				w.clickOnNewWorkspaceButton();
				a.accountReaderShouldNotCreateWorkspaceFromWorkspaceSection(a.ReaderAccount, a.NextGenWorkspaceName, a.NextGenWorkspaceDesc, a.privateTypeDetails);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Reader" })
	public void verifyRoleAssignWindowDetailsForWorkspaceForAccountReader()
	{
		try {
			test = extent.createTest("verifyRoleAssignWindowDetailsForWorkspaceForAccountReader_NG21-740");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-740");
			ExecutionResult.issueKey = "NG21-740";
			{
				Accounts a = new Accounts(driver);
				Workspaces w = new Workspaces(driver);
				w.clickOnWorkspaceMenu();
				w.searchWorkspaceAndClick(a.AccReaderWorkspaceDetails);
				a.roleAssignWindowDetailsForWorkspace();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Accounts Reader" })
	public void verifyAccountReaderAbleToRefreshWorkspaceList() {

		try {
			test = extent.createTest("verifyAccountReaderAbleToRefreshWorkspaceList_NG21-742");
			ExecutionResult.issueKey = "NG21-742";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-742");
			SoftAssert soft = new SoftAssert();
			Accounts a = new Accounts(driver);
			a.accountContAbleToRefreshWorkspaceList(soft);
			softAssert.assertAll();
		}

		catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}
	
	
	@Test(groups = { "Accounts Reader" })
	public void verifyAccountReaderCanAccessAccountWhenRoleAssignedAtGrouplevel()
	{
		try {
			test = extent.createTest("verifyAccountReaderCanAccessAccountWhenRoleAssignedAtGrouplevel_NG21-746");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-746");
			ExecutionResult.issueKey = "NG21-746";
			{
				Accounts a = new Accounts(driver);
				a.accountReaderCanAccessAccountWhenRoleAssignedAtGrouplevel(a.ReaderAccount, a.groupDetailsForAccReader, "Group", a.AccReaderWorkspaceDetails);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	//************************************* Test Data
		@Test(groups = { "Account Section" })

		public void verifyCreateAccountsTestDatForTesting()

		{
			SoftAssert softAssert = new SoftAssert();
			test = extent.createTest("verifyCreateAccountsTestDatForTesting");
			test.log(Status.INFO, "X-ray Test Case URL");
			

			try

			{
				Groups group = new Groups(driver);

				int testCaseStatus = 1;

				String columnName = "Status";

				boolean Teststatus = false;

				String e1 = null;

				int rowNumber = 0;

				String sheetName = "AccountName";

				reportLog("Launching browser");

				XLUtils xl = new XLUtils();

				String Users = System.getProperty("user.dir") + "/src/main/resources/testdata/ApplicationTestData/Accounts.xlsx";

				int rowCount = xl.getRowCount(Users, "AccountName");

				for (int rowNum = 0; rowNum < rowCount; rowNum++) {

					try {

						rowNumber = rowNum + 1;
						BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");
						@SuppressWarnings("serial")
						List<String> inputs = new ArrayList<String>() {
							{
								add("Name");
								add("Desc");
								add("NewAccountName");

							}
						};

						List<String> output = xl.getDetails(inputs, rowNumber, sheetName, xl, Users);
						
						Accounts account = new Accounts(driver);
						account.createValidAccount(output.get(0), output.get(1), output.get(2));

						xl.writeToExcel("Pass", Users, sheetName, rowNumber, columnName);

						Teststatus = false;

						softAssert.assertAll();

					} catch (Exception e2) {

						Teststatus = true;

						testCaseStatus++;

						// e1 = e2.getMessage();
					} finally {
						if (Teststatus) {

							group.continueNext(Users, sheetName, "user", test, rowNumber, e1, log, columnName,
									"VerifyuserSearchWithPagination");
						}
					}

				}
				softAssert.assertAll();

				group.testCaseStatus(testCaseStatus, log);
			} catch (Exception e)

			{
				reportLog("Error observed while running the test case" + e.getMessage());
			}
		}

	
	
		@Test(groups = { "Accounts Section" })
		public void verifyAssignUserGroupToAccount() {
			try {
				test = extent.createTest("verifyAssignUserGroupToAccount");
				
				SoftAssert soft = new SoftAssert();
				Accounts acc = new Accounts(driver);
				int rowNumber = 0;
				int rowCount = xl.getRowCount(addUserGroupToAccount, "Sheet1");
				PageUtil pageUtil = new PageUtil();

				for (int rowNum = 0; rowNum < rowCount; rowNum++) {

					rowNumber = rowNum + 1;

					BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

					List<String> inputs = pageUtil.getColumnNamesUsingSheet(addUserGroupToAccount, "Sheet1");

					List<String> output = xl.getDetails(inputs, rowNumber, "Sheet1", xl, addUserGroupToAccount);

					acc.adminCanAssignRolesToUserOnAccountCreatedByAdmin(output.get(0), output.get(1), output.get(2),
							output.get(3), output.get(4));

				}
				soft.assertAll();
			} catch (Exception e) {
				reportLog("Error observed while running the test case" + e.getMessage());
			}
		}
	
	
}
