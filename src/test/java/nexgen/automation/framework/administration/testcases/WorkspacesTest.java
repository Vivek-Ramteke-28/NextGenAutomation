package nexgen.automation.framework.administration.testcases;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
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
public class WorkspacesTest extends BaseSuite {

	XLUtils xl = new XLUtils();
	PageUtil page = new PageUtil();
	ReadConfig mailconfig = new ReadConfig();
	SoftAssert softAssert = new SoftAssert();
	String workspace = System.getProperty("user.dir") + "/src/main/resources/testdata/Workspace/workspace.xlsx";
	String roles = System.getProperty("user.dir") + "/src/main/resources/testdata/Roles/roles.xlsx";
	String addUserGroupToWorkspace = System.getProperty("user.dir") + "/src/main/resources/testdata/ApplicationTestData/AssignUserGroupToWorkspace.xlsx";

	@Test(groups = { "Workspace Section" })

	public void verifyWorkspaceLandingPageDetails() {

		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyWorkspaceLandingPageDetails_NG21-861");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-861");
			ExecutionResult.issueKey = "NG21-861";

			Workspaces w = new Workspaces(driver);
			w.clickOnWorkspaceMenu();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}

	@Test(groups = { "Workspace Section" })
	public void verifyWorkspaceNameShouldNotAcceptSpecialChar() {
		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyWorkspaceNameShouldNotAcceptSpecialChar_NG21-707");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-707");
			ExecutionResult.issueKey = "NG21-707";
			int rowNumber = 0;

			String users = System.getProperty("user.dir")
					+ "\\src\\main\\resources\\testdata\\logindetails\\FieldsValidationCheck.xlsx";
			int rowCount = xl.getRowCount(users, "NegativeData");

			Workspaces w = new Workspaces(driver);
			w.clickOnWorkspaceMenu();
			w.clickOnNewWorkspaceButton();

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

		BaseSuite.validationReportLog("Workspace Name is not accepting the special characters...");
	}

	@Test(groups = { "Workspace Section" })
	public void verifyWorkspaceNameShouldAcceptSpecialChar() {
		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyWorkspaceNameShouldAcceptSpecialChar-NG21-710");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-710");
			ExecutionResult.issueKey = "NG21-710";
			int rowNumber = 0;

			String users = System.getProperty("user.dir")
					+ "\\src\\main\\resources\\testdata\\logindetails\\FieldsValidationCheck.xlsx";
			int rowCount = xl.getRowCount(users, "PositiveData");

			Workspaces w = new Workspaces(driver);
			w.clickOnWorkspaceMenu();
			w.clickOnNewWorkspaceButton();

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {
				rowNumber = rowNum + 1;
				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

				List<String> inputs = page.getColumnNamesUsingSheet(users, "PositiveData");

				List<String> output = xl.getDetails(inputs, rowNumber, "PositiveData", xl, users);

				w.workspaceNameValidate(output.get(1), output.get(2), w.WorkspaceName, w.workspaceNameMandatoryVal,
						output.get(0), "WorkspaceName", w.workspaceNameSpecialCharError, w.workspaceNameMandatoryText,
						w.workspaceNameSpecialCharVal);

			}

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

		BaseSuite.validationReportLog("Workspace Name is accepting only hyphen(-), underscore(_), period(.)");
	}

	@Test(groups = { "Workspace Section" })
	public void verifyWorkspaceNameShouldNotAcceptMoreThan50Char() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyWorkspaceNameShouldNotAcceptMoreThan50Char_NG21-708");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-708");
			ExecutionResult.issueKey = "NG21-708";

			Workspaces w = new Workspaces(driver);
			w.clickOnWorkspaceMenu();
			w.clickOnNewWorkspaceButton();
			w.workspaceNameWithMoreThan50Char(w.ExceedCharactersTextDetails, w.ExceedCharValMsg, "WorkspaceName",
					w.NameExceedCharErrorMsgText, soft);
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test( groups = { "Workspace Section" })
	public void verifyWorkspaceDescriptionShouldNotAcceptMoreThan250Char() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyWorkspaceDescriptionShouldNotAcceptMoreThan250Char_NG21-713");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-713");
			ExecutionResult.issueKey = "NG21-713";

			Workspaces w = new Workspaces(driver);
			w.clickOnWorkspaceMenu();
			w.clickOnNewWorkspaceButton();
			w.workspaceDescriptionWithMoreThan250Char(w.ExceedDescriptionTextDetails, w.DescriptionExceedCharValMsg,
					"WorkspaceDescription", w.DescriptionExceedCharErrorMsgText, soft);
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Workspace Section" })
	public void verifyWorkspaceNameShouldValidateToEnterDetails() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyWorkspaceNameShouldValidateToEnterDetails_NG21-715");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-715");
			ExecutionResult.issueKey = "NG21-715";

			Workspaces w = new Workspaces(driver);
			w.clickOnWorkspaceMenu();
			w.clickOnNewWorkspaceButton();
			w.workspaceNameWithBlankData(w.WorkspaceName, w.workspaceNameMandatoryVal, "WorkspaceNameDetails", soft,
					"WorkspaceName", w.workspaceNameMandatoryText);
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test( groups = { "Workspace Section" })
	public void verifyWorkspaceSearchFromListOfWorkspaces() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyWorkspaceSearchFromListOfWorkspaces_NG21-705");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-705");
			ExecutionResult.issueKey = "NG21-705";

			Workspaces w = new Workspaces(driver);
			w.clickOnWorkspaceMenu();
			w.workspaceSearchFromListOfWorkspaces(w.workspaceName);

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test( groups = { "Workspace Section" })
	public void verifyRoleAssignmentWindows() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyRoleAssignmentWindows_NG21-862");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-862");
			ExecutionResult.issueKey = "NG21-862";

			Workspaces w = new Workspaces(driver);
			w.clickOnWorkspaceMenu();
			w.workspaceSearchFromListOfWorkspaces(w.workspaceName);

			Accounts a = new Accounts(driver);
			a.verifyRoleAssignmentWindow();
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(groups = { "Workspace Section" })
	public void verifyWorkspaceShouldNotBeCreatedWithSameWorkspaceName() {

		SoftAssert soft = new SoftAssert();
		try {

			test = extent.createTest("verifyWorkspaceShouldNotBeCreatedWithSameWorkspaceName_NG21-883");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-883");
			ExecutionResult.issueKey = "NG21-883";

			Workspaces w = new Workspaces(driver);
			w.clickOnWorkspaceMenu();
			w.validateDuplicateWorkspaceCreation(w.workspaceAccountName, w.workspaceName, w.workspaceDescription,
					w.workspaceType);

			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	
	//***********************Neha's test cases*******************************************
	
	//NG21-690 Verify admin can refresh workspace listing

	@Test(groups= { "Workspace Section"})
	public void verifyRefreshFunctionalityOnWorkspaceLandingpage()
	{
		SoftAssert softAssert = new SoftAssert();
		 ReadConfig mailconfig = new ReadConfig();
		 try
		 {
		 
		 test = extent.createTest("verifyRefreshFunctionalityOnWorkspaceLandingpage-NG21-690");
		 test.log(Status.INFO, "X-ray Test Case URL");
		 test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-690");
		 ExecutionResult.issueKey="NG21-690";
		 Workspaces wksObj = new Workspaces(driver);
		 wksObj.refresh_Workspace_Tab_Listing(softAssert);
		 softAssert.assertAll();
		 }catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	//NG21-702-Verify New Workspace Button button should be enabled and Delete Workspace button should be disabled on the Workspace listing page.
	@Test(groups= { "Workspace Section"})
	public void verifyButtonVisiblityOnWorkspaceLandingpage()
	{
		SoftAssert softAssert = new SoftAssert();
		 ReadConfig mailconfig = new ReadConfig();
		 try
		 {
		 
			 test = extent.createTest("verifyButtonVisiblityOnWorkspaceLandingpage-NG21-702");
	         test.log(Status.INFO, "X-ray Test Case URL");
	         test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-702");
	         ExecutionResult.issueKey="NG21-702";
		 Workspaces wksObj = new Workspaces(driver);
		 wksObj.Verify_Buttons_Visiblity_WKSLandingpage(softAssert);
		 softAssert.assertAll();
		 }
		 catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	//==========AK Code================
	@Test(groups = { "Workspace Section" })
	public void verifyDiscardDetailsInNewWorkspace()

	{

		try {

			test = extent.createTest("verifyDiscardDetailsInNewWorkspace_NG21-718");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-718");
			ExecutionResult.issueKey = "NG21-718";

			{

				Workspaces work = new Workspaces(driver);
				work.discardDetailsInNewWorkspace(work.DiscardworkspaceName, work.Description, work.DiscardalertYes,work. ExistingAccount);
			}

			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}

	@Test(groups = { "Workspace Section" })
	public void verifyDiscardDetailsInExistingWorksapce()

	{

		try {

			test = extent.createTest("verifyDiscardDetailsInExistingWorksapce_NG21-720");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-720");
			ExecutionResult.issueKey = "NG21-720";

			{
				Workspaces work = new Workspaces(driver);
				work.discardDetailsInExistingWorkspace(work.DiscardworkspaceName, work.Description, work.DiscardalertYes, work.Workspace_search);
			}

			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}
	@Test(groups = { "Workspace Section" })
	public void verifySaveButtonEnabledOrNot()

	{

		try {

			test = extent.createTest("verifysaveButtonEnabledOrNot_NG21-717");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-717");
			ExecutionResult.issueKey = "NG21-717";

			{
				Workspaces work = new Workspaces(driver);
				work.saveButtonEnabledOrNot(work.DiscardworkspaceName, work.Description, work.ExistingAccount);
			}

			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}
	
	@Test(groups = { "Workspace Section" })
	public void verifycreateWorkspace()

	{

		try {

			test = extent.createTest("verifycreateWorkspace_NG21-677");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-677");
			ExecutionResult.issueKey = "NG21-677";

			{
				Workspaces work = new Workspaces(driver);
				work.createWorkspace(work.DiscardworkspaceName, work.Description, work.ExistingAccount);
			}

			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}
	
	@Test(groups = { "Workspace Section" })
	public void verifyNewWorkspaceDisplayInList()

	{

		try {

			test = extent.createTest("verifyNewWorkspaceDisplayInList_NG21-692");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-692");
			ExecutionResult.issueKey = "NG21-692";

			{
				Workspaces work = new Workspaces(driver);
				work.newWorkspaceDisplayInList(work.DiscardworkspaceName);
			}

			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}
	
	@Test(groups = { "Workspace Section" })
	public void verifyupdateDetailsInExistingWorkspace()

	{

		try {

			test = extent.createTest("verifyupdateDetailsInExistingWorkspace_NG21-680");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-680");
			ExecutionResult.issueKey = "NG21-680";

			{
				Workspaces work = new Workspaces(driver);
				work.updateDetailsInExistingWorkspace(work.UpdatedWorkspaceName, work.UpdatedDescription, work.SearchWorkspaceForUpdate);
			}

			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}
	
	@Test(groups = { "Workspace Section" })
	public void verifyRoleAssignWindowWithoutRoleSelectionInWorkspace()

	{

		try {

			test = extent.createTest("verifyRoleAssignWindowWithoutRoleSelectionInWorkspace_NG21-863");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-863");
			ExecutionResult.issueKey = "NG21-863";

			{
				Workspaces work = new Workspaces(driver);
				work.roleAssignWindowWithoutRoleSelectionInWorkspace(work.Workspace_search, work.AssignUserInWorkspace);
			}

			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}
	
	@Test(groups = { "Workspace Section" })
	public void verifyRoleAssignWindowWithoutUserGroupSelectionInWorkspace()

	{

		try {

			test = extent.createTest("verifyRoleAssignWindowWithoutUserGroupSelectionInWorkspace_NG21-864");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-864");
			ExecutionResult.issueKey = "NG21-864";

			{
				Workspaces work = new Workspaces(driver);
				work.roleAssignWindowWithoutUserGroupSelectionInWorkspace(work.Workspace_search, work.AssignRoleInWorkspace);
			}

			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}
	
	@Test(groups = { "Workspace Section" })
	public void verifyWorkspaceSearchWithPagination()

	{

		try {

			test = extent.createTest("verifyWorkspaceSearchWithPagination_NG21-694");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-694");
			ExecutionResult.issueKey = "NG21-694";
			Workspaces work = new Workspaces(driver);
			
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

					work.workspaceSearchWithPagination(output.get(0));

					xl.writeToExcel("Pass", Users, sheetName, rowNumber, columnName);
			}
			softAssert.assertAll();
		} catch (Exception e) {

			reportLog("Error observed while running the test case" + e.getMessage());

		}

	}
	
	//========Dhawal's code================//
	
	@Test(groups = { "Workspace Section" })
	public void verifyadminCanAddUserWithRolesInUserGroupOnWorkspaceSection() {

		try {
			test = extent.createTest("verifyadminCanAddUserWithRolesInUserGroupOnWorkspaceSection_NG21-688");
			ExecutionResult.issueKey = "NG21-688";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-688");
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
	
	@Test(groups = { "Workspace Section" })
	public void verifyUserDetailsShouldDisplayedCorrectlyAfterUserHasBeenAddedToWorkspace() {

		try {
			test = extent.createTest("verifyUserDetailsShouldDisplayedCorrectlyAfterUserHasBeenAddedToWorkspace_NG21-898");
			ExecutionResult.issueKey = "NG21-898";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-898");
			SoftAssert soft = new SoftAssert();
			Workspaces ws = new Workspaces(driver);
			int rowNumber = 0;
			int rowCount = xl.getRowCount(workspace, "Sheet4");
			PageUtil pageUtil = new PageUtil();
			
			for (int rowNum = 0; rowNum < rowCount; rowNum++) {

				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

				List<String> inputs = pageUtil.getColumnNamesUsingSheet(workspace, "Sheet4");

				List<String> output = xl.getDetails(inputs, rowNumber, "Sheet4", xl, workspace);

				ws.UserDetailsShouldDisplayedCorrectlyAfterUserHasBeenAddedToWorkspace(output.get(0), output.get(1), output.get(2));
				
			}
			soft.assertAll();
			
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Section" })
	public void verifygroupDetailsShouldDisplayedCorrectlyAfterGroupHasBeenAddedToWorkspace() {

		try {
			test = extent.createTest("verifygroupDetailsShouldDisplayedCorrectlyAfterGroupHasBeenAddedToWorkspace_NG21-901");
			ExecutionResult.issueKey = "NG21-901";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-901");
			SoftAssert soft = new SoftAssert();
			Workspaces ws = new Workspaces(driver);
			int rowNumber = 0;
			int rowCount = xl.getRowCount(workspace, "Sheet5");
			PageUtil pageUtil = new PageUtil();
			
			for (int rowNum = 0; rowNum < rowCount; rowNum++) {

				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

				List<String> inputs = pageUtil.getColumnNamesUsingSheet(workspace, "Sheet5");

				List<String> output = xl.getDetails(inputs, rowNumber, "Sheet5", xl, workspace);

				ws.groupDetailsShouldDisplayedCorrectlyAfterGroupHasBeenAddedToWorkspace(output.get(0), output.get(1), output.get(2));
				
			}
			soft.assertAll();
			
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Workspace Section" })
	public void verifyadminCanRemoveRolesFromUserGroupOnWorkspaceSection() {

		try {
			test = extent.createTest("verifyadminCanRemoveRolesFromUserGroupOnWorkspaceSection_NG21-698");
			ExecutionResult.issueKey = "NG21-698";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-698");
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
	
	@Test(groups = { "Workspace Section" })
	public void verifyUserDetailsShouldBeDisplayedCorrectlyAfterUserHasBeenRemovedFromWorkspace() {

		try {
			test = extent.createTest("verifyUserDetailsShouldBeDisplayedCorrectlyAfterUserHasBeenRemovedFromWorkspace_NG21-458");
			ExecutionResult.issueKey = "NG21-458";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-458");
			SoftAssert soft = new SoftAssert();
			Workspaces ws = new Workspaces(driver);
			ws.userDetailsShouldBeDisplayedCorrectlyAfterUserHasBeenRemovedFromWorkspace(ws.searchNameUser, ws.workspaceSearchName);
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Section" })
	public void verifyGroupDetailsShouldBeDisplayedCorrectlyAfterRoleHasBeenRemovedFromWorkspace() {

		try {
			test = extent.createTest("verifyGroupDetailsShouldBeDisplayedCorrectlyAfterRoleHasBeenRemovedFromWorkspace_NG21-644");
			ExecutionResult.issueKey = "NG21-644";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-644");
			SoftAssert soft = new SoftAssert();
			Workspaces ws = new Workspaces(driver);
			ws.groupDetailsShouldBeDisplayedCorrectlyAfterRoleHasBeenRemovedFromWorkspace(ws.SearchNameGroup, ws.workspaceSearchName);
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Section" })
	public void verifyToastMessageReceivedWhenUserSelectWorkspace() {

		try {
			test = extent.createTest("verifyToastMessageReceivedWhenUserSelectWorkspace_NG21-695");
			ExecutionResult.issueKey = "NG21-695";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-695");
			SoftAssert soft = new SoftAssert();
			Workspaces ws = new Workspaces(driver);
			ws.toastMessageReceivedWhenUserSelectWorkspace(ws.workspaceSearchName);
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	

	
	
	@Test(groups = { "Workspace Section" })
	public void verifyAdminAssignMutipleRolesToUserGroupOnWorkspaceHighestPreceedingOneShouldBeDisplayed() {

		try {
			test = extent.createTest("verifyAdminAssignMutipleRolesToUserGroupOnWorkspaceHighestPreceedingOneShouldBeDisplayed_NG21-878");
			ExecutionResult.issueKey = "NG21-878";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-878");
			SoftAssert soft = new SoftAssert();
			Workspaces ws = new Workspaces(driver);
			int rowNumber = 0;
			int rowCount = xl.getRowCount(workspace, "Sheet3");
			PageUtil pageUtil = new PageUtil();
			
			for (int rowNum = 0; rowNum < rowCount; rowNum++) {

				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

				List<String> inputs = pageUtil.getColumnNamesUsingSheet(workspace, "Sheet3");

				List<String> output = xl.getDetails(inputs, rowNumber, "Sheet3", xl, workspace);

				ws.adminAssignMutipleRolesToUserGroupOnWorkspaceHighestPreceedingOneShouldBeDisplayed(rowNum, output.get(0), output.get(1), output.get(2), output.get(3));

			}
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Section" })
	public void verifyallUIComponentsOfNewWorkspaceScreen() {

		try {
			test = extent.createTest("verifyallUIComponentsOfNewWorkspaceScreen_NG21-697");
			ExecutionResult.issueKey = "NG21-697";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-697");
			SoftAssert soft = new SoftAssert();
			Workspaces ws = new Workspaces(driver);
			ws.allUIComponentsOfNewWorkspaceScreen();
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Section" })
	public void verifySequenceOfRoleWhileRemovingMultipleRolesFromUserGroupOnWorkspace() {

		try {
			test = extent.createTest("verifySequenceOfRoleWhileRemovingMultipleRolesFromUserGroupOnWorkspace_NG21-879");
			ExecutionResult.issueKey = "NG21-879";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-879");
			SoftAssert soft = new SoftAssert();
			Workspaces ws = new Workspaces(driver);
			int rowNumber = 0;
			int rowCount = xl.getRowCount(workspace, "Sheet3");
			PageUtil pageUtil = new PageUtil();
			
			for (int rowNum = 0; rowNum < rowCount; rowNum++) {

				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

				List<String> inputs = pageUtil.getColumnNamesUsingSheet(workspace, "Sheet3");

				List<String> output = xl.getDetails(inputs, rowNumber, "Sheet3", xl, workspace);
				
				ws.sequenceOfRoleWhileRemovingMultipleRolesFromUserGroupOnWorkspace(rowNum,  output.get(0), output.get(3),  output.get(1));
			}
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	//*********** Workspace Owner ********
	
	
	@Test(groups = { "Workspace Owner" })

	public void verifyWorkspaceOwnerShouldAbleToAddGroupToWorkspace() {

		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyWorkspaceOwnerShouldAbleToAddGroupToWorkspace_NG21-800");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-800");
			ExecutionResult.issueKey = "NG21-800";

			Workspaces w = new Workspaces(driver);
			Accounts a = new Accounts(driver);
			w.workspaceOwnerShouldAbleToAddGroupToWorkspace(w.WorkspaceDetails, a.role, a.groupAssign, a.accessToGroup);

			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Owner" })

	public void verifyWorkspaceOwnerShouldAbleToAddUserToWorkspace() {

		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyWorkspaceOwnerShouldAbleToAddUserToWorkspace_NG21-799");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-799");
			ExecutionResult.issueKey = "NG21-799";

			Workspaces w = new Workspaces(driver);
			Accounts a = new Accounts(driver);
			w.workspaceOwnerShouldAbleToAddGroupToWorkspace(w.WorkspaceDetails, a.role, a.userAssign, a.addUserInWorkspace);

			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}

	
	//Test case failing due to validation message
	@Test(groups = { "Workspace Owner" })
	public void verifyWorkspaceOwnerShouldNotUpdateExistingWorkspace() {
		try {
			test = extent.createTest("verifyWorkspaceOwnerShouldNotUpdateExistingWorkspace_NG21-792");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-792");
			ExecutionResult.issueKey = "NG21-792";
			{
				Accounts a = new Accounts(driver);
				Workspaces w = new Workspaces(driver);
				a.accountReaderShouldNotUpdateExistingWorkspace(w.OwnerWorkspaceDetails, a.NextGenWorkspaceName, a.NextGenWorkspaceDesc);
				driver.navigate().refresh();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Owner" })
	public void verifyWorkspaceOwnerShouldNotCreateWorkspaceFromWorkspaceSection() {
		try {
			test = extent.createTest("verifyWorkspaceOwnerShouldNotCreateWorkspaceFromWorkspaceSection_NG21-789");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-789");
			ExecutionResult.issueKey = "NG21-789";
			{
				Workspaces w = new Workspaces(driver);
				Accounts a = new Accounts(driver);
				driver.navigate().refresh();
				w.clickOnWorkspaceMenu();
				w.clickOnNewWorkspaceButton();
				a.accountReaderShouldNotCreateWorkspaceFromWorkspaceSection(a.WorkspaceAccount, a.NextGenWorkspaceName, a.NextGenWorkspaceDesc, a.privateTypeDetails);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Owner" })
	public void verifyWorkspaceOwnerAccessOnListOfWorkspaces() {
		try {
			test = extent.createTest("verifyWorkspaceOwnerAccessOnListOfWorkspaces_NG21-788");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-788");
			ExecutionResult.issueKey = "NG21-788";
			{
				Workspaces w = new Workspaces(driver);
				w.workspaceOwnerAccessOnListOfWorkspaces();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Owner" })
	public void verifyWorkspaceOwnerAccessOnListOfAccounts() {

		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyWorkspaceOwnerAccessOnListOfAccounts_NG21-786");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-786");
			ExecutionResult.issueKey = "NG21-786";

			Accounts a = new Accounts(driver);
			a.accountReaderAccessOnListOfAccounts();
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Owner" })
	public void verifyWorkspaceOwnerShouldNotAbleToUpdateExistingAccount() {
		try {
			test = extent.createTest("verifyWorkspaceOwnerShouldNotAbleToUpdateExistingAccount_NG21-784");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-784");
			ExecutionResult.issueKey = "NG21-784";
			{
				Accounts a = new Accounts(driver);
				a.accountReaderShouldNotAbleToUpdateExistingAccount(a.WorkspaceAccount, a.updatedAccountName, a.updatedAccountDescription);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Owner" })
	public void verifyWorkspaceOwnerShouldNotAbleToCreateAccount() {
		try {
			test = extent.createTest("verifyWorkspaceOwnerShouldNotAbleToCreateAccount_NG21-782");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-782");
			ExecutionResult.issueKey = "NG21-782";
			{
				Accounts a = new Accounts(driver);
				a.accountReaderShouldNotAbleToCreateAccount(a.NextGenAccountName, a.NextGenAccountDesc);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Owner" })
	public void verifyWorkspaceOwnerAccessOnListOfWorkspacesAndClick() {
		try {
			test = extent.createTest("verifyWorkspaceOwnerAccessOnListOfWorkspacesAndClick_NG21-779");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-779");
			ExecutionResult.issueKey = "NG21-779";
			{
				Workspaces w = new Workspaces(driver);
				w.workspaceOwnerAccessOnListOfWorkspacesAndClick(w.OwnerWorkspaceDetails);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Workspace Owner" })
	public void verifyWorkspaceOwnerAccessListOfRoles() {

		try {
			test = extent.createTest("verifyWorkspaceOwnerAccessListOfRoles_NG21-776");
			ExecutionResult.issueKey = "NG21-776";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-776");
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
	
	
	@Test(groups = { "Workspace Owner" })
	public void verifyWorkspaceOwnerAccessOnAssignWorkspaces() {
		try {
			test = extent.createTest("verifyWorkspaceOwnerAccessOnAssignWorkspaces_NG21-773");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-773");
			ExecutionResult.issueKey = "NG21-773";
			{
				Accounts a = new Accounts(driver);
				Workspaces w = new Workspaces(driver);
				a.accountReaderAccessOnListOfWorkspacesAndClick(w.OwnerWorkspaceDetails);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Owner" })
	public void verifyAccountSearchByWorkspaceOwner() {
		try {
			test = extent.createTest("verifyAccountSearchByWorkspaceOwner_NG21-771");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-771");
			ExecutionResult.issueKey = "NG21-771";
			{
				Accounts a = new Accounts(driver);
				a.accountSearchByAccountReader(a.WorkspaceAccount);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Owner" })
	public void verifyWorkspaceOwnerShouldNotAccessUserSection() {
		try {
			test = extent.createTest("verifyWorkspaceOwnerShouldNotAccessUserSection_NG21-756");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-756");
			ExecutionResult.issueKey = "NG21-756";
			{

				Accounts a = new Accounts(driver);
				a.accountExecutorShouldNotAccessUserSection();

			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}

	@Test(groups = { "Workspace Owner" })
	public void verifyWorkspaceOwnerShouldNotAccessGroupSection() {
		try {
			test = extent.createTest("verifyWorkspaceOwnerShouldNotAccessGroupSection_NG21-764");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-764");
			ExecutionResult.issueKey = "NG21-764";
			{
				Accounts a = new Accounts(driver);
				a.accountExecutorShouldNotAccessGroupSection();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Owner" })
	public void verifyDoCheckLoginUsingWorkspaceOwner() {
		try {
			test = extent.createTest("verifyDoCheckLoginUsingWorkspaceOwner_NG21-749");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-749");
			ExecutionResult.issueKey = "NG21-749";
			{
				Workspaces a = new Workspaces(driver);
				a.doCheckLoginUsingUser(username, password);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Owner" })
	public void verifyWorkspaceOwnerCanAddUserGroupInWorkspaceSection() {

		try {
			test = extent.createTest("verifyWorkspaceOwnerCanAddUserGroupInWorkspaceSection_NG21-796");
			ExecutionResult.issueKey = "NG21-796";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-796");
			SoftAssert soft = new SoftAssert();
			Workspaces ws = new Workspaces(driver);
			int rowNumber = 0;
			int rowCount = xl.getRowCount(workspace, "Sheet6");
			PageUtil pageUtil = new PageUtil();
			
			for (int rowNum = 0; rowNum < rowCount; rowNum++) {

				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

				List<String> inputs = pageUtil.getColumnNamesUsingSheet(workspace, "Sheet6");

				List<String> output = xl.getDetails(inputs, rowNumber, "Sheet6", xl, workspace);

				ws.adminCanAddUserWithRolesInUserGroupOnWorkspaceSection(output.get(0), output.get(1), output.get(2), output.get(3), output.get(4));
			}
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Owner" })
	public void verifyWorkspaceOwnerCanRemoveRolesFromUserGroupOnWorkspaceSection() {

		try {
			test = extent.createTest("verifyWorkspaceOwnerCanRemoveRolesFromUserGroupOnWorkspaceSection_NG21-507");
			ExecutionResult.issueKey = "NG21-507";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-507");
			SoftAssert soft = new SoftAssert();
			Workspaces ws = new Workspaces(driver);
			int rowNumber = 0;
			int rowCount = xl.getRowCount(workspace, "Sheet7");
			PageUtil pageUtil = new PageUtil();
		
			for (int rowNum = 0; rowNum < rowCount; rowNum++) {

				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

				List<String> inputs = pageUtil.getColumnNamesUsingSheet(workspace, "Sheet7");

				List<String> output = xl.getDetails(inputs, rowNumber, "Sheet7", xl, workspace);

				ws.adminCanRemoveRolesFromUserGroupOnWorkspaceSection(rowNum,output.get(0), output.get(1));
			}
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Owner" })

	public void verifySearchAddedUserGroupInsideWorkspace() {

		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifySearchAddedUserGroupInsideWorkspace_NG21-510");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-510");
			ExecutionResult.issueKey = "NG21-510";

			Workspaces w = new Workspaces(driver);
			Accounts a = new Accounts(driver);
			w.searchAddedUserGroupInsideWorkspace(w.WorkspaceDetails, w.OwnerWorkspaceDetails);
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Workspace Owner" })

	public void verifyRefreshBtnShouldUpdateDetailsInAddedListOfUserGroup() {

		SoftAssert soft = new SoftAssert();

		try {

			test = extent.createTest("verifyRefreshBtnShouldUpdateDetailsInAddedListOfUserGroup_NG21-508");

			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-508");
			ExecutionResult.issueKey = "NG21-508";

			Workspaces w = new Workspaces(driver);
			Accounts a = new Accounts(driver);
			w.refreshBtnShouldUpdateDetailsInAddedListOfUserGroup(w.OwnerWorkspaceDetails, a.role, a.accessto,a.addUserInWorkspace, a.addUserInWorkspace);
			driver.navigate().refresh();

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	
	//*********** Workspace Contributor ********
	
	
	@Test(groups = { "Workspace Contributor" })
	public void verifyWorkspaceContributorShouldNotAccessUserSection() {
		try {
			test = extent.createTest("verifyWorkspaceContributorShouldNotAccessUserSection_NG21-513");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-513");
			ExecutionResult.issueKey = "NG21-513";
			{
				Users u  = new Users(driver);
				u.holdsAfterLogin();
				u.clickOnUserMenuForNonAdminUser();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}

	@Test(groups = { "Workspace Contributor" })
	public void verifyWorkspaceContributorShouldNotAccessGroupSection() {
		try {
			test = extent.createTest("verifyWorkspaceContributorShouldNotAccessGroupSection_NG21-515");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-515");
			ExecutionResult.issueKey = "NG21-515";
			{
				Accounts a = new Accounts(driver);
				a.accountExecutorShouldNotAccessGroupSection();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Contributor" })
	public void verifyWorkspaceContributorAccessListOfRoles() {

		try {
			test = extent.createTest("verifyWorkspaceContributorAccessListOfRoles_NG21-516");
			ExecutionResult.issueKey = "NG21-516";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-516");
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
	
	
	
	
	@Test(groups = { "Workspace Contributor" })
	public void verifyWorkspaceContributorUserShouldNotAbleToCreateUser() {
		try {
			test = extent.createTest("verifyWorkspaceContributorUserShouldNotAbleToCreateUser_NG21-520");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-520");
			ExecutionResult.issueKey = "NG21-520";
			{
				Workspaces w = new Workspaces(driver);
				w.nonAdminUserShouldNotAbleToCreateUser();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Contributor" })
	public void verifyBlockDeleteBtnShouldBeDisabledForWorkspaceContributor() {
		try {
			test = extent.createTest("verifyBlockDeleteBtnShouldBeDisabledForWorkspaceContributor_NG21-524");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-524");
			ExecutionResult.issueKey = "NG21-524";
			{

				Workspaces w = new Workspaces(driver);
				w.BlockDeleteBtnShouldBeDisabledForNonAdminUserForUserMenu();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Contributor" })
	public void verifyNoUserShouldBePopulatedForWorkspaceContributorInUserListing() {
		try {
			test = extent.createTest("verifyNoUserShouldBePopulatedForWorkspaceContributorInUserListing_NG21-525");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-525");
			ExecutionResult.issueKey = "NG21-525";
			{

				Workspaces w = new Workspaces(driver);
				w.NoUserShouldBePopulatedForNonAdminUser();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Contributor" })
	public void verifyWorkspaceContributorShouldNotAccessGroup() {
		try {
			test = extent.createTest("verifyWorkspaceContributorShouldNotAccessGroup_NG21-526");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-526");
			ExecutionResult.issueKey = "NG21-526";
			{
				Groups group = new Groups(driver);
				Users u  = new Users(driver);
				u.holdsAfterLogin();
				group.clickOnGroupMenuForNonAdminUser();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Contributor" })
	public void verifyWorkspaceContributorUserShouldNotAbleToCreateGroup() {
		try {
			test = extent.createTest("verifyWorkspaceContributorUserShouldNotAbleToCreateGroup_NG21-527");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-527");
			ExecutionResult.issueKey = "NG21-527";
			{
				Workspaces w = new Workspaces(driver);
				w.nonAdminUserShouldNotAbleToCreateGroup();
				driver.navigate().refresh();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Contributor" })
	public void verifyWorkspaceContributorUserShouldAbleToDiscardUnsavedGroupChanges() {
		try {
			test = extent.createTest("verifyWorkspaceContributorUserShouldAbleToDiscardUnsavedGroupChanges_NG21-528");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-528");
			ExecutionResult.issueKey = "NG21-528";
			{
				
				Workspaces w = new Workspaces(driver);
				w.nonAdminUserShouldAbleToDiscardUnsavedGroupChanges();
				driver.navigate().refresh();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	
	@Test(groups = { "Workspace Contributor" })
	public void verifyNoGroupShouldBePopulatedForWorkspaceContributorInGroupListing() {
		try {
			test = extent.createTest("verifyNoGroupShouldBePopulatedForWorkspaceContributorInGroupListing_NG21-529");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-529");
			ExecutionResult.issueKey = "NG21-529";
			{

				Workspaces w = new Workspaces(driver);
				w.NoGroupShouldBePopulatedForNonAdminUser();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Workspace Contributor" })
	public void verifyDeleteBtnShouldBeDisabledForWorkspaceContributorInGroupMenu() {
		try {
			test = extent.createTest("verifyDeleteBtnShouldBeDisabledForWorkspaceContributorInGroupMenu_NG21-530");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-530");
			ExecutionResult.issueKey = "NG21-530";
			{

				Workspaces w = new Workspaces(driver);
				boolean b = w.DeleteBtnShouldBeDisabledForNonAdminUserForGroupMenu();
				Assert.assertTrue(b);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Workspace Contributor" })
	public void verifyWorkspaceContributorShouldAbleToAccessRoleList() {
		try {
			test = extent.createTest("verifyWorkspaceContributorShouldAbleToAccessRoleList_NG21-531");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-531");
			ExecutionResult.issueKey = "NG21-531";
			{

				Workspaces w = new Workspaces(driver);
				w.roleListForNonAdminUser();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Contributor" })
	public void verifyWorkspaceContributorAccessOnListOfWorkspacesAndClick() {
		try {
			test = extent.createTest("verifyWorkspaceContributorAccessOnListOfWorkspacesAndClick_NG21-532");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-532");
			ExecutionResult.issueKey = "NG21-532";
			{
				
				Workspaces w = new Workspaces(driver);
				w.workspaceContributorAccessOnListOfWorkspacesAndClick(w.ContributorWorkspaceDetails);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	//Test case failing due to validation message
	@Test(groups = { "Workspace Contributor" })
	public void verifyWorkspaceContributorShouldNotUpdateExistingWorkspace() {
		try {
			test = extent.createTest("verifyWorkspaceContributorShouldNotUpdateExistingWorkspace_NG21-547");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-547");
			ExecutionResult.issueKey = "NG21-547";
			{
				Accounts a = new Accounts(driver);
				Workspaces w = new Workspaces(driver);
				a.accountReaderShouldNotUpdateExistingWorkspace(w.ContributorWorkspaceDetails, a.NextGenWorkspaceName, a.NextGenWorkspaceDesc);
				driver.navigate().refresh();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Contributor" })
	public void verifyWorkspaceContributorUserShouldAbleToDiscardUnsavedWorkspaceChanges() {
		try {
			test = extent.createTest("verifyWorkspaceContributorUserShouldAbleToDiscardUnsavedWorkspaceChanges_NG21-548");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-548");
			ExecutionResult.issueKey = "NG21-548";
			{
				
				Workspaces w = new Workspaces(driver);
				driver.navigate().refresh();
				w.nonAdminUserShouldAbleToDiscardUnsavedWorkspaceChanges(w.ContributorWorkspaceDetails);
				driver.navigate().refresh();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Workspace Contributor" })
	public void verifyAccountAndTypeSelectionShouldBeDisableOnClickExistingWorkspace() {
		try {
			test = extent.createTest("verifyAccountAndTypeSelectionShouldBeDisableOnClickExistingWorkspace_NG21-549");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-549");
			ExecutionResult.issueKey = "NG21-549";
			{
				
				Workspaces w = new Workspaces(driver);
				boolean b = w.accountAndTypeSelectionShouldBeDisableOnClickExistingWorkspace(w.ContributorWorkspaceDetails);
				Assert.assertTrue(b);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Contributor" })
	public void verifyWorkspaceContributorShouldNotAbleToAddUserInWorkspace() {
		try {
			test = extent.createTest("verifyWorkspaceContributorShouldNotAbleToAddUserInWorkspace_NG21-550");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-550");
			ExecutionResult.issueKey = "NG21-550";
			{
				Workspaces w = new Workspaces(driver);
				boolean b= w.workspaceContriShouldNotAbleToAddUserGroupInWorkspace(w.ContributorWorkspaceDetails, w.role, w.accessto, w.addUserInAccount);
				Assert.assertTrue(b);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Contributor" })
	public void verifyDiscardRoleAssignWindowDetailsForWorkspaceContributor()
	{
		try {
			test = extent.createTest("verifyDiscardRoleAssignWindowDetailsForWorkspaceContributor_NG21-552");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-552");
			ExecutionResult.issueKey = "NG21-552";
			{
				
				Workspaces w = new Workspaces(driver);
				boolean b = w.discardClickOnRoleAssignementWindow(w.ContributorWorkspaceDetails);
				Assert.assertTrue(b);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Contributor" })
	public void verifyWorkspaceContributorShouldNotAbleToAddGroupInWorkspace() {
		try {
			test = extent.createTest("verifyWorkspaceContributorShouldNotAbleToAddGroupInWorkspace_NG21-554");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-554");
			ExecutionResult.issueKey = "NG21-554";
			{
				Workspaces w = new Workspaces(driver);
				boolean b= w.workspaceContriShouldNotAbleToAddUserGroupInWorkspace(w.ContributorWorkspaceDetails, w.roleWorkspace, w.accesstoGroup, w.accessToGroup_Workspace);
				Assert.assertTrue(b);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Contributor" })
	public void verifyRoleAssignWindowDetailsOfWorkspaceForWorkspaceContributor()
	{
		try {
			test = extent.createTest("verifyRoleAssignWindowDetailsOfWorkspaceForWorkspaceContributor_NG21-556");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-556");
			ExecutionResult.issueKey = "NG21-556";
			{
				Accounts a = new Accounts(driver);
				Workspaces w = new Workspaces(driver);
				w.clickOnWorkspaceMenu();
				w.searchWorkspaceAndClick(w.ContributorWorkspaceDetails);
				a.roleAssignWindowDetailsForWorkspace();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Contributor" })
	public void verifyWorkspaceContributorShouldNotAbleToRemoveRoleFromTheWorkspace() {
		try {
			test = extent.createTest("verifyWorkspaceContributorShouldNotAbleToRemoveRoleFromTheWorkspace_NG21-557");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-557");
			ExecutionResult.issueKey = "NG21-557";
			{
				Workspaces w = new Workspaces(driver);
				w.userShouldNotAbleToRemoveUserFromTheWorkspace(w.ContributorWorkspaceDetails);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Workspace Contributor" })
	public void verifyWorkspaceContributorShouldNotAbleSelectMultipleUsersToRemove() {
		try {
			test = extent.createTest("verifyWorkspaceContributorShouldNotAbleToRemoveRoleFromTheWorkspace_NG21-559");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-559");
			ExecutionResult.issueKey = "NG21-559";
			{
				Workspaces w = new Workspaces(driver);
				w.clickOnWorkspaceMenu();
				w.searchWorkspaceAndClick(w.ContributorWorkspaceDetails);
				w.shouldNotSelectMultipleUsers();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Contributor" })
	public void verifyWorkspaceContributorShouldNotAbleToRemoveRole() {
		try {
			test = extent.createTest("verifyWorkspaceContributorShouldNotAbleToRemoveRole_NG21-562");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-562");
			ExecutionResult.issueKey = "NG21-562";
			{
				Workspaces w = new Workspaces(driver);
				w.clickOnWorkspaceMenu();
				w.userShouldNotAbleToRemoveUserFromTheWorkspace(w.ContributorWorkspaceDetails);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Contributor" })
	public void verifyWorkspaceContributorShouldAbleToRefreshUserListInsideWorkspace() {
		try {
			test = extent.createTest("verifyWorkspaceContributorShouldAbleToRefreshUserListInsideWorkspace_NG21-563");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-563");
			ExecutionResult.issueKey = "NG21-563";
			{
				Workspaces w = new Workspaces(driver);
				w.clickOnWorkspaceMenu();
				w.refreshUserGroupListInsideWorkspace(w.ContributorWorkspaceDetails);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Contributor" })
	public void verifyWorkspaceContributorShouldNotAbleToCreateAccount() {
		try {
			test = extent.createTest("verifyWorkspaceContributorShouldNotAbleToCreateAccount_NG21-568");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-568");
			ExecutionResult.issueKey = "NG21-568";
			{
				Accounts a = new Accounts(driver);
				a.accountReaderShouldNotAbleToCreateAccount(a.NextGenAccountName, a.NextGenAccountDesc);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Workspace Contributor" })
	public void verifyWorkspaceContributorShouldAbleToDiscardUnsavedDataOfAccount() {
		try {
			test = extent.createTest("vverifyWorkspaceContributorShouldAbleToDiscardUnsavedDataOfAccount_NG21-570");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-570");
			ExecutionResult.issueKey = "NG21-570";
			{
				Workspaces w = new Workspaces(driver);
				boolean b =w.nonAdminUserShouldAbleToDiscardUnsavedDataOfAccount(w.NextGenAccountName, w.NextGenAccountDesc);
				Assert.assertTrue(b);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Contributor" })
	public void verifyWorkspaceContributorUserShouldAbleToDiscardUnsavedDataOfGroup() {
		try {
			test = extent.createTest("verifyWorkspaceContributorUserShouldAbleToDiscardUnsavedDataOfGroup_NG21-806");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-806");
			ExecutionResult.issueKey = "NG21-806";
			{
				
				Workspaces w = new Workspaces(driver);
				w.nonAdminUserShouldAbleToDiscardUnsavedGroupChanges();
				driver.navigate().refresh();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	//*********** Workspace Executor ********
	
	

	@Test(groups = { "Workspace Executor" })
	public void verifyWorkspaceExecutorShouldNotAccessUserSection() {
		try {
			test = extent.createTest("verifyWorkspaceExecutorShouldNotAccessUserSection_NG21-573");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-573");
			ExecutionResult.issueKey = "NG21-573";
			{

				Accounts a = new Accounts(driver);
				a.accountExecutorShouldNotAccessUserSection();

			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}

	@Test(groups = { "Workspace Executor" })
	public void verifyWorkspaceExecutorShouldNotAccessGroupSection() {
		try {
			test = extent.createTest("verifyWorkspaceExecutorShouldNotAccessGroupSection_NG21-574");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-574");
			ExecutionResult.issueKey = "NG21-574";
			{
				Accounts a = new Accounts(driver);
				a.accountExecutorShouldNotAccessGroupSection();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Executor" })
	public void verifyWorkspaceExecutorAccessListOfRoles() {

		try {
			test = extent.createTest("verifyWorkspaceExecutorAccessListOfRoles_NG21-577");
			ExecutionResult.issueKey = "NG21-577";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-577");
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
	
	
	@Test(groups = { "Workspace Executor" })
	public void verifyWorkspaceExecutorShouldNotAbleToCreateAccount() {
		try {
			test = extent.createTest("verifyWorkspaceExecutorShouldNotAbleToCreateAccount_NG21-580");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-580");
			ExecutionResult.issueKey = "NG21-580";
			{
				Accounts a = new Accounts(driver);
				a.accountReaderShouldNotAbleToCreateAccount(a.NextGenAccountName, a.NextGenAccountDesc);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Workspace Executor" })
	public void verifyWorkspaceExecutorShouldAbleToDiscardUnsavedDataOfAccount() {
		try {
			test = extent.createTest("verifyWorkspaceExecutorShouldAbleToDiscardUnsavedDataOfAccount_NG21-582");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-582");
			ExecutionResult.issueKey = "NG21-582";
			{
				Workspaces w = new Workspaces(driver);
				boolean b =w.nonAdminUserShouldAbleToDiscardUnsavedDataOfAccount(w.NextGenAccountName, w.NextGenAccountDesc);
				Assert.assertTrue(b);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Executor" })
	public void verifyWorkspaceExecutorAccessOnListOfWorkspacesAndClick() {
		try {
			test = extent.createTest("verifyWorkspaceExecutorAccessOnListOfWorkspacesAndClick_NG21-584");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-584");
			ExecutionResult.issueKey = "NG21-584";
			{
				
				Workspaces w = new Workspaces(driver);
				w.workspaceContributorAccessOnListOfWorkspacesAndClick(w.ExecutorWorkspaceDetails);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	//Test case failing due to validation message
	@Test(groups = { "Workspace Executor" })
	public void verifyWorkspaceExecutorShouldNotUpdateExistingWorkspace() {
		try {
			test = extent.createTest("verifyWorkspaceExecutorShouldNotUpdateExistingWorkspace_NG21-587");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-587");
			ExecutionResult.issueKey = "NG21-587";
			{
				Accounts a = new Accounts(driver);
				Workspaces w = new Workspaces(driver);
				a.accountReaderShouldNotUpdateExistingWorkspace(w.ExecutorWorkspaceDetails, a.NextGenWorkspaceName, a.NextGenWorkspaceDesc);
				driver.navigate().refresh();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Workspace Executor" })
	public void verifyWorkspaceExecutorUserShouldAbleToDiscardUnsavedWorkspaceChanges() {
		try {
			test = extent.createTest("verifyWorkspaceExecutorUserShouldAbleToDiscardUnsavedWorkspaceChanges_NG21-590");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-590");
			ExecutionResult.issueKey = "NG21-590";
			{
				
				Workspaces w = new Workspaces(driver);
				driver.navigate().refresh();
				w.nonAdminUserShouldAbleToDiscardUnsavedWorkspaceChanges(w.ExecutorWorkspaceDetails);
				driver.navigate().refresh();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Executor" })
	public void verifyAccountAndTypeSelectionShouldBeDisableForWorkspaceExecutor() {
		try {
			test = extent.createTest("verifyAccountAndTypeSelectionShouldBeDisableForWorkspaceExecutor_NG21-593");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-593");
			ExecutionResult.issueKey = "NG21-593";
			{
				
				Workspaces w = new Workspaces(driver);
				boolean b = w.accountAndTypeSelectionShouldBeDisableOnClickExistingWorkspace(w.ExecutorWorkspaceDetails);
				Assert.assertTrue(b);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Executor" })
	public void verifyWorkspaceExecutorShouldNotAbleToAddUserInWorkspace() {
		try {
			test = extent.createTest("verifyWorkspaceExecutorShouldNotAbleToAddUserInWorkspace_NG21-604");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-604");
			ExecutionResult.issueKey = "NG21-604";
			{
				Workspaces w = new Workspaces(driver);
				boolean b= w.workspaceContriShouldNotAbleToAddUserGroupInWorkspace(w.ExecutorWorkspaceDetails, w.role, w.accessto, w.addUserInAccount);
				Assert.assertTrue(b);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Executor" })
	public void verifyDiscardRoleAssignWindowDetailsForWorkspaceExecutor()
	{
		try {
			test = extent.createTest("verifyDiscardRoleAssignWindowDetailsForWorkspaceExecutor_NG21-606");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-606");
			ExecutionResult.issueKey = "NG21-606";
			{
				
				Workspaces w = new Workspaces(driver);
				boolean b = w.discardClickOnRoleAssignementWindow(w.ExecutorWorkspaceDetails);
				Assert.assertTrue(b);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Executor" })
	public void verifyWorkspaceExecutorShouldNotAbleToAddGroupInWorkspace() {
		try {
			test = extent.createTest("verifyWorkspaceExecutorShouldNotAbleToAddGroupInWorkspace_NG21-608");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-608");
			ExecutionResult.issueKey = "NG21-608";
			{
				Workspaces w = new Workspaces(driver);
				boolean b= w.workspaceContriShouldNotAbleToAddUserGroupInWorkspace(w.ExecutorWorkspaceDetails, w.roleWorkspace, w.accesstoGroup, w.accessToGroup_Workspace);
				Assert.assertTrue(b);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Executor" })
	public void verifyRoleAssignWindowDetailsOfWorkspaceForWorkspaceExecutor()
	{
		try {
			test = extent.createTest("verifyRoleAssignWindowDetailsOfWorkspaceForWorkspaceExecutor_NG21-610");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-610");
			ExecutionResult.issueKey = "NG21-610";
			{
				Accounts a = new Accounts(driver);
				Workspaces w = new Workspaces(driver);
				w.clickOnWorkspaceMenu();
				w.searchWorkspaceAndClick(w.ExecutorWorkspaceDetails);
				a.roleAssignWindowDetailsForWorkspace();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Executor" })
	public void verifyWorkspaceExecutorShouldNotAbleToRemoveRoleFromTheWorkspace() {
		try {
			test = extent.createTest("verifyWorkspaceExecutorShouldNotAbleToRemoveRoleFromTheWorkspace_NG21-614");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-614");
			ExecutionResult.issueKey = "NG21-614";
			{
				Workspaces w = new Workspaces(driver);
				w.userShouldNotAbleToRemoveUserFromTheWorkspace(w.ExecutorWorkspaceDetails);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Executor" })
	public void verifyWorkspaceExecutorShouldNotAbleSelectMultipleUsersToRemove() {
		try {
			test = extent.createTest("verifyWorkspaceExecutorShouldNotAbleSelectMultipleUsersToRemove_NG21-616");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-616");
			ExecutionResult.issueKey = "NG21-616";
			{
				Workspaces w = new Workspaces(driver);
				w.clickOnWorkspaceMenu();
				w.searchWorkspaceAndClick(w.ExecutorWorkspaceDetails);
				w.shouldNotSelectMultipleUsers();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Executor" })
	public void verifyWorkspaceExecutorShouldNotAbleToRemoveRole() {
		try {
			test = extent.createTest("verifyWorkspaceExecutorShouldNotAbleToRemoveRole_NG21-619");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-619");
			ExecutionResult.issueKey = "NG21-619";
			{
				Workspaces w = new Workspaces(driver);
				w.clickOnWorkspaceMenu();
				w.userShouldNotAbleToRemoveUserFromTheWorkspace(w.ExecutorWorkspaceDetails);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Executor" })
	public void verifyWorkspaceExecutorShouldAbleToRefreshUserListInsideWorkspace() {
		try {
			test = extent.createTest("verifyWorkspaceExecutorShouldAbleToRefreshUserListInsideWorkspace_NG21-622");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-622");
			ExecutionResult.issueKey = "NG21-622";
			{
				Workspaces w = new Workspaces(driver);
				w.clickOnWorkspaceMenu();
				w.refreshUserGroupListInsideWorkspace(w.ExecutorWorkspaceDetails);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Executor" })
	public void verifyWorkspaceExecutorUserShouldNotAbleToCreateUser() {
		try {
			test = extent.createTest("verifyWorkspaceExecutorUserShouldNotAbleToCreateUser_NG21-630");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-630");
			ExecutionResult.issueKey = "NG21-630";
			{
				Workspaces w = new Workspaces(driver);
				w.nonAdminUserShouldNotAbleToCreateUser();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Executor" })
	public void verifyBlockDeleteBtnShouldBeDisabledForWorkspaceExecutor() {
		try {
			test = extent.createTest("verifyBlockDeleteBtnShouldBeDisabledForWorkspaceExecutor_NG21-632");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-632");
			ExecutionResult.issueKey = "NG21-632";
			{

				Workspaces w = new Workspaces(driver);
				w.BlockDeleteBtnShouldBeDisabledForNonAdminUserForUserMenu();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Executor" })
	public void verifyNoUserShouldBePopulatedForWorkspaceExecutorInUserListing() {
		try {
			test = extent.createTest("verifyNoUserShouldBePopulatedForWorkspaceExecutorInUserListing_NG21-634");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-634");
			ExecutionResult.issueKey = "NG21-634";
			{

				Workspaces w = new Workspaces(driver);
				w.NoUserShouldBePopulatedForNonAdminUser();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	@Test(groups = { "Workspace Executor" })
	public void verifyWorkspaceExecutorShouldNotAccessGroup() {
		try {
			test = extent.createTest("verifyWorkspaceExecutorShouldNotAccessGroup_NG21-635");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-635");
			ExecutionResult.issueKey = "NG21-635";
			{
				Groups group = new Groups(driver);
				Users u  = new Users(driver);
				u.holdsAfterLogin();
				group.clickOnGroupMenuForNonAdminUser();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Executor" })
	public void verifyWorkspaceExecutorUserShouldNotAbleToCreateGroup() {
		try {
			test = extent.createTest("verifyWorkspaceExecutorUserShouldNotAbleToCreateGroup_NG21-637");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-637");
			ExecutionResult.issueKey = "NG21-637";
			{
				Workspaces w = new Workspaces(driver);
				w.nonAdminUserShouldNotAbleToCreateGroup();
				driver.navigate().refresh();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Executor" })
	public void verifyWorkspaceExecutorUserShouldAbleToDiscardUnsavedGroupChanges() {
		try {
			test = extent.createTest("verifyWorkspaceExecutorUserShouldAbleToDiscardUnsavedGroupChanges_NG21-640");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-640");
			ExecutionResult.issueKey = "NG21-640";
			{
				
				Workspaces w = new Workspaces(driver);
				w.nonAdminUserShouldAbleToDiscardUnsavedGroupChanges();
				driver.navigate().refresh();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Executor" })
	public void verifyWorkspaceExecutorUserShouldAbleToDiscardUnsavedDataOfGroup() {
		try {
			test = extent.createTest("verifyWorkspaceExecutorUserShouldAbleToDiscardUnsavedDataOfGroup_NG21-643");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-643");
			ExecutionResult.issueKey = "NG21-643";
			{
				
				Workspaces w = new Workspaces(driver);
				w.nonAdminUserShouldAbleToDiscardUnsavedGroupChanges();
				driver.navigate().refresh();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Executor" })
	public void verifyNoGroupShouldBePopulatedForWorkspaceExecutorInGroupListing() {
		try {
			test = extent.createTest("verifyNoGroupShouldBePopulatedForWorkspaceExecutorInGroupListing_NG21-645");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-645");
			ExecutionResult.issueKey = "NG21-645";
			{

				Workspaces w = new Workspaces(driver);
				w.NoGroupShouldBePopulatedForNonAdminUser();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Executor" })
	public void verifyDeleteBtnShouldBeDisabledForWorkspaceExecutorInGroupMenu() {
		try {
			test = extent.createTest("verifyDeleteBtnShouldBeDisabledForWorkspaceExecutorInGroupMenu_NG21-648");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-648");
			ExecutionResult.issueKey = "NG21-648";
			{

				Workspaces w = new Workspaces(driver);
				boolean b = w.DeleteBtnShouldBeDisabledForNonAdminUserForGroupMenu();
				Assert.assertTrue(b);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Executor" })
	public void verifyWorkspaceExecutorShouldAbleToAccessRoleList() {
		try {
			test = extent.createTest("verifyWorkspaceExecutorShouldAbleToAccessRoleList_NG21-650");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-650");
			ExecutionResult.issueKey = "NG21-650";
			{

				Workspaces w = new Workspaces(driver);
				w.roleListForNonAdminUser();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	//*********** Workspace Reader ********
	
	
	
	
	
	@Test(groups = { "Workspace Reader" })
	public void verifyWorkspaceReaderShouldNotAccessUserSection() {
		try {
			test = extent.createTest("verifyWorkspaceReaderShouldNotAccessUserSection_NG21-654");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-654");
			ExecutionResult.issueKey = "NG21-654";
			{

				Accounts a = new Accounts(driver);
				a.accountExecutorShouldNotAccessUserSection();

			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}

	@Test(groups = { "Workspace Reader" })
	public void verifyWorkspaceReaderShouldNotAccessGroupSection() {
		try {
			test = extent.createTest("verifyWorkspaceReaderShouldNotAccessGroupSection_NG21-655");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-655");
			ExecutionResult.issueKey = "NG21-655";
			{
				Accounts a = new Accounts(driver);
				a.accountExecutorShouldNotAccessGroupSection();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Reader" })
	public void verifyWorkspaceReaderAccessListOfRoles() {

		try {
			test = extent.createTest("verifyWorkspaceReaderAccessListOfRoles_NG21-658");
			ExecutionResult.issueKey = "NG21-658";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-658");
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
	
	
	@Test(groups = { "Workspace Reader" })
	public void verifyWorkspaceReaderUserShouldNotAbleToCreateUser() {
		try {
			test = extent.createTest("verifyWorkspaceReaderUserShouldNotAbleToCreateUser_NG21-661");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-661");
			ExecutionResult.issueKey = "NG21-661";
			{
				Workspaces w = new Workspaces(driver);
				w.nonAdminUserShouldNotAbleToCreateUser();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Reader" })
	public void verifyBlockDeleteBtnShouldBeDisabledForWorkspaceReader() {
		try {
			test = extent.createTest("verifyBlockDeleteBtnShouldBeDisabledForWorkspaceReader_NG21-662");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-662");
			ExecutionResult.issueKey = "NG21-662";
			{

				Workspaces w = new Workspaces(driver);
				w.BlockDeleteBtnShouldBeDisabledForNonAdminUserForUserMenu();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Reader" })
	public void verifyNoUserShouldBePopulatedForWorkspaceReaderInUserListing() {
		try {
			test = extent.createTest("verifyNoUserShouldBePopulatedForWorkspaceReaderInUserListing_NG21-665");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-665");
			ExecutionResult.issueKey = "NG21-665";
			{

				Workspaces w = new Workspaces(driver);
				w.NoUserShouldBePopulatedForNonAdminUser();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Reader" })
	public void verifyWorkspaceReaderShouldNotAccessGroups() {
		try {
			test = extent.createTest("verifyWorkspaceReaderShouldNotAccessGroups_NG21-667");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-667");
			ExecutionResult.issueKey = "NG21-667";
			{
				Accounts a = new Accounts(driver);
				a.accountExecutorShouldNotAccessGroupSection();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Reader" })
	public void verifyWorkspaceReaderUserShouldNotAbleToCreateGroup() {
		try {
			test = extent.createTest("verifyWorkspaceReaderUserShouldNotAbleToCreateGroup_NG21-670");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-670");
			ExecutionResult.issueKey = "NG21-670";
			{
				Workspaces w = new Workspaces(driver);
				w.nonAdminUserShouldNotAbleToCreateGroup();
				driver.navigate().refresh();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Reader" })
	public void verifyWorkspaceReaderUserShouldNotAbleToDiscardUnsavedChangesOfUser() {
		try {
			test = extent.createTest("verifyWorkspaceReaderUserShouldNotAbleToDiscardUnsavedChangesOfUser_NG21-678");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-678");
			ExecutionResult.issueKey = "NG21-678";
			{
				Workspaces w = new Workspaces(driver);
				w.nonAdminUserShouldAbleToDiscardUnsavedDataOfUser();
				driver.navigate().refresh();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Reader" })
	public void verifyWorkspaceReaderUserShouldAbleToDiscardUnsavedGroupChanges() {
		try {
			test = extent.createTest("verifyWorkspaceReaderUserShouldAbleToDiscardUnsavedGroupChanges_NG21-685");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-685");
			ExecutionResult.issueKey = "NG21-685";
			{
				
				Workspaces w = new Workspaces(driver);
				w.nonAdminUserShouldAbleToDiscardUnsavedGroupChanges();
				driver.navigate().refresh();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Reader" })
	public void verifyNoGroupShouldBePopulatedForWorkspaceReaderInGroupListing() {
		try {
			test = extent.createTest("vverifyNoGroupShouldBePopulatedForWorkspaceReaderInGroupListing_NG21-687");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-687");
			ExecutionResult.issueKey = "NG21-687";
			{

				Workspaces w = new Workspaces(driver);
				w.NoGroupShouldBePopulatedForNonAdminUser();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Reader" })
	public void verifyDeleteBtnShouldBeDisabledForWorkspaceReaderInGroupMenu() {
		try {
			test = extent.createTest("verifyDeleteBtnShouldBeDisabledForWorkspaceReaderInGroupMenu_NG21-689");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-689");
			ExecutionResult.issueKey = "NG21-689";
			{

				Workspaces w = new Workspaces(driver);
				boolean b = w.DeleteBtnShouldBeDisabledForNonAdminUserForGroupMenu();
				Assert.assertTrue(b);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Reader" })
	public void verifyWorkspaceReaderShouldNotAbleToCreateAccount() {
		try {
			test = extent.createTest("verifyWorkspaceReaderShouldNotAbleToCreateAccount_NG21-693");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-693");
			ExecutionResult.issueKey = "NG21-693";
			{
				Accounts a = new Accounts(driver);
				a.accountReaderShouldNotAbleToCreateAccount(a.NextGenAccountName, a.NextGenAccountDesc);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	
	@Test(groups = { "Workspace Reader" })
	public void verifyWorkspaceReaderShouldAbleToDiscardUnsavedDataOfAccount() {
		try {
			test = extent.createTest("verifyWorkspaceReaderShouldAbleToDiscardUnsavedDataOfAccount_NG21-696");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-696");
			ExecutionResult.issueKey = "NG21-696";
			{
				Workspaces w = new Workspaces(driver);
				boolean b =w.nonAdminUserShouldAbleToDiscardUnsavedDataOfAccount(w.NextGenAccountName, w.NextGenAccountDesc);
				Assert.assertTrue(b);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Reader" })
	public void verifyWorkspaceReaderAccessOnListOfWorkspacesAndClick() {
		try {
			test = extent.createTest("verifyWorkspaceReaderAccessOnListOfWorkspacesAndClick_NG21-699");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-699");
			ExecutionResult.issueKey = "NG21-699";
			{
				
				Workspaces w = new Workspaces(driver);
				w.workspaceContributorAccessOnListOfWorkspacesAndClick(w.ReaderWorkspaceDetails);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	//Test case failing due to validation message
	@Test(groups = { "Workspace Reader" })
	public void verifyWorkspaceReaderShouldNotUpdateExistingWorkspace() {
		try {
			test = extent.createTest("verifyWorkspaceReaderShouldNotUpdateExistingWorkspace_NG21-700");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-700");
			ExecutionResult.issueKey = "NG21-700";
			{
				Accounts a = new Accounts(driver);
				Workspaces w = new Workspaces(driver);
				a.accountReaderShouldNotUpdateExistingWorkspace(w.ReaderWorkspaceDetails, a.NextGenWorkspaceName, a.NextGenWorkspaceDesc);
				driver.navigate().refresh();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Reader" })
	public void verifyWorkspaceReaderUserShouldAbleToDiscardUnsavedWorkspaceChanges() {
		try {
			test = extent.createTest("verifyWorkspaceReaderUserShouldAbleToDiscardUnsavedWorkspaceChanges_NG21-703");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-703");
			ExecutionResult.issueKey = "NG21-703";
			{
				
				Workspaces w = new Workspaces(driver);
				driver.navigate().refresh();
				w.nonAdminUserShouldAbleToDiscardUnsavedWorkspaceChanges(w.ReaderWorkspaceDetails);
				driver.navigate().refresh();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Reader" })
	public void verifyAccountAndTypeSelectionShouldBeDisableForWorkspaceReader() {
		try {
			test = extent.createTest("verifyAccountAndTypeSelectionShouldBeDisableForWorkspaceReader_NG21-704");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-704");
			ExecutionResult.issueKey = "NG21-704";
			{

				Workspaces w = new Workspaces(driver);
				boolean b = w.accountAndTypeSelectionShouldBeDisableOnClickExistingWorkspace(w.ReaderWorkspaceDetails);
				Assert.assertTrue(b);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Reader" })
	public void verifyWorkspaceReaderShouldNotAbleToAddUserInWorkspace() {
		try {
			test = extent.createTest("verifyWorkspaceReaderShouldNotAbleToAddUserInWorkspace_NG21-706");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-706");
			ExecutionResult.issueKey = "NG21-706";
			{
				Workspaces w = new Workspaces(driver);
				boolean b = w.workspaceContriShouldNotAbleToAddUserGroupInWorkspace(w.ReaderWorkspaceDetails, w.role,
						w.accessto, w.addUserInAccount);
				Assert.assertTrue(b);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Reader" })
	public void verifyDiscardRoleAssignWindowDetailsForWorkspaceReader()
	{
		try {
			test = extent.createTest("vverifyDiscardRoleAssignWindowDetailsForWorkspaceReader_NG21-711");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-711");
			ExecutionResult.issueKey = "NG21-711";
			{
				
				Workspaces w = new Workspaces(driver);
				boolean b = w.discardClickOnRoleAssignementWindow(w.ReaderWorkspaceDetails);
				Assert.assertTrue(b);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Reader" })
	public void verifyWorkspaceReaderShouldNotAbleToAddGroupInWorkspace() {
		try {
			test = extent.createTest("verifyWorkspaceReaderShouldNotAbleToAddGroupInWorkspace_NG21-719");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-719");
			ExecutionResult.issueKey = "NG21-719";
			{
				Workspaces w = new Workspaces(driver);
				boolean b= w.workspaceContriShouldNotAbleToAddUserGroupInWorkspace(w.ReaderWorkspaceDetails, w.roleWorkspace, w.accesstoGroup, w.accessToGroup_Workspace);
				Assert.assertTrue(b);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Reader" })
	public void verifyRoleAssignWindowDetailsOfWorkspaceForWorkspaceReader()
	{
		try {
			test = extent.createTest("verifyRoleAssignWindowDetailsOfWorkspaceForWorkspaceReader_NG21-721");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-721");
			ExecutionResult.issueKey = "NG21-721";
			{
				Accounts a = new Accounts(driver);
				Workspaces w = new Workspaces(driver);
				w.clickOnWorkspaceMenu();
				w.searchWorkspaceAndClick(w.ReaderWorkspaceDetails);
				a.roleAssignWindowDetailsForWorkspace();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Workspace Reader" })
	public void verifyWorkspaceReaderShouldNotAbleToRemoveRoleFromTheWorkspace() {
		try {
			test = extent.createTest("verifyWorkspaceReaderShouldNotAbleToRemoveRoleFromTheWorkspace_NG21-724");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-724");
			ExecutionResult.issueKey = "NG21-724";
			{
				Workspaces w = new Workspaces(driver);
				w.userShouldNotAbleToRemoveUserFromTheWorkspace(w.ReaderWorkspaceDetails);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Reader" })
	public void verifyWorkspaceReaderShouldNotAbleSelectMultipleUsersToRemove() {
		try {
			test = extent.createTest("verifyWorkspaceReaderShouldNotAbleSelectMultipleUsersToRemove_NG21-728");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-728");
			ExecutionResult.issueKey = "NG21-728";
			{
				Workspaces w = new Workspaces(driver);
				w.clickOnWorkspaceMenu();
				w.searchWorkspaceAndClick(w.ReaderWorkspaceDetails);
				w.shouldNotSelectMultipleUsers();
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Reader" })
	public void verifyWorkspaceReaderShouldNotAbleToRemoveRole() {
		try {
			test = extent.createTest("verifyWorkspaceReaderShouldNotAbleToRemoveRole_NG21-731");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-731");
			ExecutionResult.issueKey = "NG21-731";
			{
				Workspaces w = new Workspaces(driver);
				w.clickOnWorkspaceMenu();
				w.userShouldNotAbleToRemoveUserFromTheWorkspace(w.ReaderWorkspaceDetails);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Workspace Reader" })
	public void verifyWorkspaceReaderShouldAbleToRefreshUserListInsideWorkspace() {
		try {
			test = extent.createTest("verifyWorkspaceReaderShouldAbleToRefreshUserListInsideWorkspace_NG21-734");
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-734");
			ExecutionResult.issueKey = "NG21-734";
			{
				Workspaces w = new Workspaces(driver);
				w.clickOnWorkspaceMenu();
				w.refreshUserGroupListInsideWorkspace(w.ReaderWorkspaceDetails);
			}
			softAssert.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
	//************************************* Test Data
	@Test(groups = { "Workspace Section" })

	public void verifyCreateWorkspacesTestDatForTesting()

	{
		SoftAssert softAssert = new SoftAssert();
		test = extent.createTest("verifyCreateWorkspacesTestDatForTesting");
		test.log(Status.INFO, "X-ray Test Case URL");
		

		try

		{
			Groups group = new Groups(driver);

			int testCaseStatus = 1;

			String columnName = "Status";

			boolean Teststatus = false;

			String e1 = null;

			int rowNumber = 0;

			String sheetName = "WorkspaceName";

			reportLog("Launching browser");

			XLUtils xl = new XLUtils();

			String Users = System.getProperty("user.dir") + "/src/main/resources/testdata/ApplicationTestData/Workspaces.xlsx";

			int rowCount = xl.getRowCount(Users, "WorkspaceName");

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {

				try {

					rowNumber = rowNum + 1;
					BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");
					@SuppressWarnings("serial")
					List<String> inputs = new ArrayList<String>() {
						{
							add("Name");
							add("Desc");
							add("AccountName");

						}
					};

					List<String> output = xl.getDetails(inputs, rowNumber, sheetName, xl, Users);

					//group.createValidGroups(output.get(0), output.get(1), output.get(2));
					
//					Accounts account = new Accounts(driver);
//					account.createValidAccount(output.get(0), output.get(1), output.get(2));
//					
					Workspaces work = new Workspaces(driver);
					work.createWorkspace(output.get(0), output.get(1), output.get(2));

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
	
	
	@Test(groups = { "Workspace Section" })
	public void verifyAssignUserGroupToWorkspace() {

		try {
			test = extent.createTest("verifyAssignUserGroupToWorkspace");
	
			SoftAssert soft = new SoftAssert();
			Workspaces ws = new Workspaces(driver);
			int rowNumber = 0;
			int rowCount = xl.getRowCount(addUserGroupToWorkspace, "Sheet1");
			PageUtil pageUtil = new PageUtil();
			
			for (int rowNum = 0; rowNum < rowCount; rowNum++) {

				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

				List<String> inputs = pageUtil.getColumnNamesUsingSheet(addUserGroupToWorkspace, "Sheet1");

				List<String> output = xl.getDetails(inputs, rowNumber, "Sheet1", xl, addUserGroupToWorkspace);

				ws.adminCanAddUserWithRolesInUserGroupOnWorkspaceSection(output.get(0), output.get(1), output.get(2), output.get(3), output.get(4));
			}
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	
}
