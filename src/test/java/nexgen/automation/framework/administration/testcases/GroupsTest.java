package nexgen.automation.framework.administration.testcases;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import nexgen.automation.framework.administration.Groups;
import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.config.ReadConfig;

import nexgen.automation.framework.constant.ExecutionResult;
import nexgen.automation.framework.reports.ListenerTest;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;

@Listeners(ListenerTest.class)
public class GroupsTest extends BaseSuite {
	XLUtils xl = new XLUtils();
	PageUtil page = new PageUtil();
	ReadConfig mailconfig = new ReadConfig();
	SoftAssert softAssert = new SoftAssert();

	@Test( groups = { "Groups Section" })

	public void verifyGroupLandingPageDetails() {

		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyGroupLandingPageDetails_NG21-310");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-310");
			ExecutionResult.issueKey = "NG21-310";

			Groups g = new Groups(driver);
			g.clickOnGroupsMenu();
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}

	@Test(groups = { "Groups Section" })

	public void verifyCreateGroupUIElements() {

		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyCreateGroupUIElements_NG21-105");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-105");
			ExecutionResult.issueKey = "NG21-105";

			Groups g = new Groups(driver);
			g.clickOnGroupsMenu();
			g.clickOnNewGroupButton();
			g.createGroupUIElements(g.groupNameDetails, soft);
			driver.navigate().refresh();
			g.clickOnGroupsMenu();
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}

	@Test(groups = {  "Groups Section" })
	public void verifyGroupNameShouldNotAcceptSpecialChar() {
		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyGroupNameShouldNotAcceptSpecialChar_NG21-569");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-569");
			ExecutionResult.issueKey = "NG21-569";
			int rowNumber = 0;

			String users = System.getProperty("user.dir")
					+ "\\src\\main\\resources\\testdata\\logindetails\\FieldsValidationCheck.xlsx";
			int rowCount = xl.getRowCount(users, "NegativeData");

			Groups g = new Groups(driver);
			g.clickOnGroupsMenu();
			g.clickOnNewGroupButton();

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {
				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");
				List<String> inputs = page.getColumnNamesUsingSheet(users, "NegativeData");

				List<String> output = xl.getDetails(inputs, rowNumber, "NegativeData", xl, users);

				g.groupNameValidate(output.get(1), output.get(2), g.GroupName, g.GroupNameMandatoryVal, output.get(0),
						"GroupName", g.GroupNameSpecialCharError, g.GroupNameMandatoryText, g.GroupNameSpecialCharVal);

			}
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Groups Section" })
	public void verifyGroupNameShouldAcceptSpecialChar() {
		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyGroupNameShouldAcceptSpecialChar_NG21-572");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-572");
			ExecutionResult.issueKey = "NG21-572";
			int rowNumber = 0;

			String users = System.getProperty("user.dir")
					+ "\\src\\main\\resources\\testdata\\logindetails\\FieldsValidationCheck.xlsx";
			int rowCount = xl.getRowCount(users, "PositiveData");

			Groups g = new Groups(driver);
			g.clickOnGroupsMenu();
			g.clickOnNewGroupButton();

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {
				rowNumber = rowNum + 1;
				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

				List<String> inputs = page.getColumnNamesUsingSheet(users, "PositiveData");

				List<String> output = xl.getDetails(inputs, rowNumber, "PositiveData", xl, users);

				g.groupNameValidate(output.get(1), output.get(2), g.GroupName, g.GroupNameMandatoryVal, output.get(0),
						"GroupName", g.GroupNameSpecialCharError, g.GroupNameMandatoryText, g.GroupNameSpecialCharVal);

			}

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Groups Section" })
	public void verifyGroupNameShouldNotAcceptMoreThan50Char() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyGroupNameShouldNotAcceptMoreThan50Char_NG21-571");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-571");
			ExecutionResult.issueKey = "NG21-571";

			Groups g = new Groups(driver);
			g.clickOnGroupsMenu();
			g.clickOnNewGroupButton();
			g.groupNameWithMoreThan50Char(g.ExceedCharactersTextDetails, g.ExceedCharValMsg, "GroupName",
					g.NameExceedCharErrorMsgText, soft);
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Groups Section" })
	public void verifyGroupDescriptionShouldNotAcceptMoreThan250Char() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyGroupDescriptionShouldNotAcceptMoreThan250Char_NG21-575");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-575");
			ExecutionResult.issueKey = "NG21-575";

			Groups g = new Groups(driver);
			g.clickOnGroupsMenu();
			g.clickOnNewGroupButton();
			g.groupDescriptionWithMoreThan250Char(g.ExceedDescriptionTextDetails, g.DescriptionExceedCharValMsg,
					"GroupDescription", g.DescriptionExceedCharErrorMsgText, soft);
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test( groups = { "Groups Section" })
	public void verifyGroupNameShouldValidateToEnterDetails() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyFirstNameWithBlankData_NG21-576");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-576");
			ExecutionResult.issueKey = "NG21-576";

			Groups g = new Groups(driver);
			g.clickOnGroupsMenu();
			g.clickOnNewGroupButton();
			g.groupNameWithBlankData(g.GroupName, g.GroupNameMandatoryVal, "GroupNameDetails", soft, "GroupName",
					g.GroupNameMandatoryText);
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Groups Section" })
	public void verifyAssignUserToNewGroup() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyAssignUserToNewGroup_NG21-809");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-809");
			ExecutionResult.issueKey = "NG21-809";

			Groups g = new Groups(driver);
			g.clickOnGroupsMenu();
			g.clickOnNewGroupButton();
			g.assignUserToNewGroup(g.groupCreateDetails, g.assignUserName);
			driver.navigate().refresh();
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}
	

	@Test( groups = { "Groups Section" })
	public void verifyUserDetailsAfterUserAddedToGroup() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyUserDetailsAfterUserAddedToGroup_NG21-899");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-899");
			ExecutionResult.issueKey = "NG21-899";

			Groups g = new Groups(driver);
			g.clickOnGroupsMenu();
			g.verifyUserDetailsAfterUserAddedToGroup(g.assignUserName, g.groupCreateDetails);
			driver.navigate().refresh();
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}
	

	@Test(groups = { "Groups Section" })
	public void verifyRemoveUserFromExistingGroup() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyRemoveUserFromExistingGroup_NG21-304");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-304");
			ExecutionResult.issueKey = "NG21-304";

			Groups g = new Groups(driver);
			g.clickOnGroupsMenu();

			g.removeUserFromExistingGroup(g.GroupSearchDetails, g.groupCreateDetails, g.assignUserName,g.searchUserDetails, soft);
			g.deleteGroup();
			driver.navigate().refresh();
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	// AK updated code
	@Test(groups = { "Groups Section" })
	public void verifyDiscardDetailsInExistingGroup()

	{

		try {

			test = extent.createTest("verifyDiscardDetailsInExistingGroup_NG21-586");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-586");
			ExecutionResult.issueKey = "NG21-586";

			{
				Groups group = new Groups(driver);
				group.discardDetailsInExistingGroup(group.GroupNamestring, group.Description, group.DiscardalertYes,
						group.Group_search);
			}

			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}

	@Test(groups = { "Groups Section" })

	public void verifyDiscardDetailsInNewGroup()

	{

		try {

			test = extent.createTest("verifyDiscardDetailsInNewGroup_NG21-583");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-583");
			ExecutionResult.issueKey = "NG21-583";

			{
				Groups group = new Groups(driver);
				group.discardDetailsInNewGroup(group.GroupNamestring, group.Description, group.DiscardalertYes);
			}

			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}

	@Test(groups = { "Groups Section" })

	public void verifyDeleteButtonEnabled()

	{

		try {

			test = extent.createTest("verifyDeleteButtonEnabled_NG21-581");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-581");
			ExecutionResult.issueKey = "NG21-581";

			{
				Groups group = new Groups(driver);
				group.deleteButtonEnabled(group.GroupNamestring, group.Description);
			}

			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}

	@Test( groups = { "Groups Section" })

	public void verifySaveButtonEnabled()

	{
		try {
			test = extent.createTest("verifySaveButtonEnabled_NG21-578");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-578");
			ExecutionResult.issueKey = "NG21-578";
			{
				Groups group = new Groups(driver);
				group.saveButtonEnabled(group.GroupNamestring, group.Description);
			}
			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}

	@Test(groups = { "Groups Section" })

	public void verifyDeleteMultipleGroups()

	{
		try {
			test = extent.createTest("verifyDeleteMultipleGroups_NG21-808");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-808");
			ExecutionResult.issueKey = "NG21-808";
			{
				Groups group = new Groups(driver);
				group.deleteMultipleGroups();
			}
			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}

	@Test(groups = { "Groups Section" })

	public void verifyCreateValidGroups()

	{
		SoftAssert softAssert = new SoftAssert();
		test = extent.createTest("verifyCreateValidGroups_NG21-302");
		test.log(Status.INFO, "X-ray Test Case URL");
		test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-302");
		ExecutionResult.issueKey = "NG21-302";

		try

		{
			Groups group = new Groups(driver);

			int testCaseStatus = 1;

			String columnName = "Status";

			boolean Teststatus = false;

			String e1 = null;

			int rowNumber = 0;

			String sheetName = "GroupName";

			reportLog("Launching browser");

			XLUtils xl = new XLUtils();

			String Users = System.getProperty("user.dir") + "/src/main/resources/testdata/logindetails/AbhiUser1.xlsx";

			int rowCount = xl.getRowCount(Users, "GroupName");

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {

				try {

					rowNumber = rowNum + 1;
					BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");
					@SuppressWarnings("serial")
					List<String> inputs = new ArrayList<String>() {
						{
							add("Name");
							add("Desc");
							add("NewGroupName");

						}
					};

					List<String> output = xl.getDetails(inputs, rowNumber, sheetName, xl, Users);

					group.createValidGroups(output.get(0), output.get(1), output.get(2));

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

	@Test(groups = { "Groups Section" })

	public void verifyAddDiscardUserInExistingGroup()

	{
		try {
			test = extent.createTest("verifyAddDiscardUserInExistingGroup_NG21-303");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-303");
			ExecutionResult.issueKey = "NG21-303";
			{
				Groups group = new Groups(driver);
				group.addDiscardUserInExistingGroup(group.Group_search, group.AssignUserName);
				
			}
			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}

	@Test(groups = { "Groups Section" })

	public void verifyDeletedGroup()

	{
		try {
			test = extent.createTest("verifyDeletedGroup_NG21-309");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-309");
			ExecutionResult.issueKey = "NG21-309";
			{
				Groups group = new Groups(driver);
				group.deletedGroupVerify(group.deletedGroup);
				
			}
			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}
	
	@Test(groups = { "Groups Section" })
	public void verifyGroupSearchWithPagination()

	{

		try {

			test = extent.createTest("verifyGroupSearchWithPagination_NG21-888");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-888");
			ExecutionResult.issueKey = "NG21-888";
			Groups work = new Groups(driver);
			
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

					work.groupSearchWithPagination(output.get(0));

					xl.writeToExcel("Pass", Users, sheetName, rowNumber, columnName);
			}
			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}
	

	// NG21-804 -verify by default delete button should be disabled
	@Test(groups = { "Groups Section" })
	public void verifyDeleteButtonDisabledByDefault() {
		SoftAssert softAssert = new SoftAssert();
		ReadConfig mailconfig = new ReadConfig();

		try {
			test = extent.createTest("verifyDeleteButtonDisabledByDefault_NG21-804");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-804");
			ExecutionResult.issueKey = "NG21-804";
			Groups grp = new Groups(driver);
			grp.DeleteButtonDisabledByDefault(softAssert);
			softAssert.assertAll();

		} catch (Exception e) {
			// e.printStackTrace();
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	// NG21-561-Verify admin is able to refresh group listing using refresh button

	@Test( groups = { "Groups Section" })
	public void verifyUsingRefreshbtnListingGetRefreshed() {
		SoftAssert softAssert = new SoftAssert();
		ReadConfig mailconfig = new ReadConfig();
		try {
			test = extent.createTest("verifyRefreshButtonCanRefreshGroupListing_NG21-561");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-561");
			ExecutionResult.issueKey = "NG21-561";
			Groups grp = new Groups(driver);
			grp.RefreshButtonRefreshinggroupdata(softAssert);
			softAssert.assertAll();

		} catch (Exception e) {
			// e.printStackTrace();
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	// NG21-308-Verify group should be searched from the List of group.
	@Test( groups = { "Groups Section" })
	public void verifyGroupShouldBeSearchedFromGroupListing() {
		SoftAssert softAssert = new SoftAssert();
		ReadConfig mailconfig = new ReadConfig();
		Groups grp = new Groups(driver);
		
		
		try {
			test = extent.createTest("verifyGroupShouldBeSearchedFromGroupListing_NG21-308");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-308");
			ExecutionResult.issueKey = "NG21-308";
			
			grp.SearchGroupInGroupListing(softAssert);
			softAssert.assertAll();

		} catch (Exception e) {
			// e.printStackTrace();
			reportLog("Error observed while running the test case" + e.getMessage());
		}
		

	}

	
	// NG21-565-Group details should be displayed correctly after user has been removed from group

	@Test(groups = { "Groups Section" })
	public void verifyGroupDetailsWhenUserisRemovedFromGroup() {
		SoftAssert softAssert = new SoftAssert();
		ReadConfig mailconfig = new ReadConfig();
		Groups grp = new Groups(driver);
		
		try {
			test = extent.createTest("verifyGroupDetailsWhenUserisRemovedFromGroup_NG-565");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-565");
			ExecutionResult.issueKey = "NG21-565";
			
			grp.GroupDetails_RemoveUserFromGroup(grp.groupNamen, softAssert);
			
			softAssert.assertAll();

		} catch (Exception e) {
			// e.printStackTrace();
			reportLog("Error observed while running the test case" + e.getMessage());
		}
		

	}
	// User details should be displayed correctly after user has been removed from group.
	
		//,dependsOnMethods = {"verifyGroupDetailsWhenUserisRemovedFromGroup"}
		@Test (groups = { "Groups Section" })
		public void verifyUserdetails_WhenUserRemovedFromGroup() {
			SoftAssert softAssert = new SoftAssert();
			Groups grp = new Groups(driver);
			
			try {
				test = extent.createTest("verifyUserdetails_WhenUserRemovedFromGroup_NG21-456 ");
				test.log(Status.INFO, "X-ray Test Case URL");
				test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-456");
				ExecutionResult.issueKey = "NG21-456";
				
				grp.User_Details_verified_When_User_Removed_Frm_Grp(softAssert);
				softAssert.assertAll();
				
			}

			catch (Exception e) {
				reportLog("Error observed while running the test case" + e.getMessage());
			}

		}
		
		// NG21-567-Verify Delete group button should be enabled if one of group(s)
		// checkbox is selected, and able to delete group.

		@Test(groups = { "Groups Section" })
		public void verifyDeleteButtonIsEnabledAfterselectingGroup() {
			SoftAssert softAssert = new SoftAssert();
			ReadConfig mailconfig = new ReadConfig();
			Groups grp = new Groups(driver);
			;
			
			try {
				test = extent.createTest("verifyDeleteButtonIsEnabledAfterselectingGroup&SameGrpIsDeleted_NG21-567");
				test.log(Status.INFO, "X-ray Test Case URL");
				test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-567");
				ExecutionResult.issueKey = "NG21-567";
				grp.DeleteButtonIsEnabledAfterselectingGroup(softAssert);
				driver.navigate().refresh();
				softAssert.assertAll();

			} catch (Exception e) {
				// e.printStackTrace();
				reportLog("Error observed while running the test case" + e.getMessage());
			}
			

		}

	
	
	@Test(groups = { "Groups Section" })
	public void verifyGroupShouldNotBeCreatedWithSameGroupName() {
		SoftAssert softAssert = new SoftAssert();
		ReadConfig mailconfig = new ReadConfig();
		try {
			test = extent.createTest("verifyGroupShouldNotBeCreatedWithSameGroupName_NG21-874");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-874");
			ExecutionResult.issueKey = "NG21-874";
			Groups grp = new Groups(driver);
			grp.createGroup(grp.duplicateGroupName, grp.duplicateGroupDescr);
			grp.validateDuplicateGroupCreation(grp.duplicateGroupName, grp.duplicateGroupDescr);
			softAssert.assertAll();
			

		} catch (Exception e) {
			// e.printStackTrace();
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}
	
	
	
//************************************* Test Data
	@Test(groups = { "Groups Section" })

	public void verifyCreateGroupsTestDatForTesting()

	{
		SoftAssert softAssert = new SoftAssert();
		test = extent.createTest("verifyCreateGroupsTestDatForTesting");
		test.log(Status.INFO, "X-ray Test Case URL");
		

		try

		{
			Groups group = new Groups(driver);

			int testCaseStatus = 1;

			String columnName = "Status";

			boolean Teststatus = false;

			String e1 = null;

			int rowNumber = 0;

			String sheetName = "GroupName";

			reportLog("Launching browser");

			XLUtils xl = new XLUtils();

			String Users = System.getProperty("user.dir") + "/src/main/resources/testdata/ApplicationTestData/Groups.xlsx";

			int rowCount = xl.getRowCount(Users, "GroupName");

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {

				try {

					rowNumber = rowNum + 1;
					BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");
					@SuppressWarnings("serial")
					List<String> inputs = new ArrayList<String>() {
						{
							add("Name");
							add("Desc");
							add("NewGroupName");

						}
					};

					List<String> output = xl.getDetails(inputs, rowNumber, sheetName, xl, Users);

					group.createValidGroups(output.get(0), output.get(1), output.get(2));

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


}
