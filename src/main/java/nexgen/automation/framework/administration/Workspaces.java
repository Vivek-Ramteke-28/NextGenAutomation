package nexgen.automation.framework.administration;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElements;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.util.PageUtil;

public class Workspaces extends PageUtil {

	WebDriver driver;

	public Workspaces(WebDriver driver) {

		this.driver = driver;

	}

	By WorkspaceMenu = getElementLocator(prop.getProperty("Workspaces.WorkspaceSideBar"));

	static final Logger log = Logger.getLogger(Accounts.class);

	By WorkspaceSideBar = getElementLocator(prop.getProperty("Workspaces.WorkspaceSideBar"));
	By WorkspaceNameCol = getElementLocator(prop.getProperty("Workspaces.WorkspaceNameCol"));
	By WorkspaceDescriptionCol = getElementLocator(prop.getProperty("Workspaces.WorkspaceDescriptionCol"));
	By AccountCol = getElementLocator(prop.getProperty("Workspaces.AccountCol"));
	By LastModifiedCol = getElementLocator(prop.getProperty("Workspaces.LastModifiedCol"));
	By WorkspaceSearchBar = getElementLocator(prop.getProperty("Workspaces.WorkspaceSearchBar"));
	By WorkspaceSearchClick = getElementLocator(prop.getProperty("Workspaces.WorkspaceSearchClick"));
	By WorkspaceSearchList1 = getElementLocator(prop.getProperty("Workspaces.WorkspaceSearchList"));
	By WorkspaceSearchDataDetails = getElementLocator(prop.getProperty("Workspaces.WorkspaceSearchDataDetails"));
	By NumberOfWorkspace = getElementLocator(prop.getProperty("Workspaces.NumberOfWorkspace"));
	By NewWorkspaceBtn = getElementLocator(prop.getProperty("Workspaces.NewWorkspaceBtn"));
	By RefreshWorkspaceBtn = getElementLocator(prop.getProperty("Workspaces.RefreshWorkspaceBtn"));
	By DeleteWorkspaceBtn = getElementLocator(prop.getProperty("Workspaces.DeleteWorkspaceBtn"));
	By AccountDropdown = getElementLocator(prop.getProperty("Workspaces.AccountDropdown"));
	By select_Account = getElementLocator(prop.getProperty("Workspaces.select_Account"));
	By WorkspaceSaveBtn = getElementLocator(prop.getProperty("Workspaces.WorkspaceSaveBtn"));
	By WorkspaceDiscardBtn = getElementLocator(prop.getProperty("Workspaces.WorkspaceDiscardBtn"));
	By WorkspaceDiscardBtnYes = getElementLocator(prop.getProperty("Workspaces.WorkspaceDiscardBtnYes"));
	By WorkspaceDiscardBtnNo = getElementLocator(prop.getProperty("Workspaces.WorkspaceDiscardBtnNo"));
	public By WorkspaceName = getElementLocator(prop.getProperty("Workspaces.WorkspaceName"));
	public By WorkspaceDescription = getElementLocator(prop.getProperty("Workspaces.WorkspaceDescription"));
	By Workspacetype = getElementLocator(prop.getProperty("Workspaces.type"));
	By User_GroupTab = getElementLocator(prop.getProperty("Workspaces.User_GroupTab"));
	By AddUser_GroupBtn = getElementLocator(prop.getProperty("Workspaces.AddUser_GroupBtn"));
	By RoleAssignmentLabel = getElementLocator(prop.getProperty("Workspaces.RoleAssignmentLabel"));
	By RoleDropDown = getElementLocator(prop.getProperty("Workspaces.RoleDropDown"));
	By AddRole = getElementLocator(prop.getProperty("Workspaces.AddRole"));
	By AccessTo = getElementLocator(prop.getProperty("Workspaces.AccessTo"));
	By AddRoleBtn = getElementLocator(prop.getProperty("Workspaces.AddRoleBtn"));
	By AssignmentOfUser_Group = getElementLocator(prop.getProperty("Workspaces.AssignmentOfUser_Group"));
	By UserSearchTextbox = getElementLocator(prop.getProperty("Workspaces.UserSearchTextbox"));
	By UserSearchTextboxButton = getElementLocator(prop.getProperty("Workspaces.UserSearchTextboxButton"));
	By UserCheckbox = getElementLocator(prop.getProperty("Workspaces.UserCheckbox"));
	By RemoveAddedUserBtn = getElementLocator(prop.getProperty("Workspaces.RemoveAddedUserBtn"));
	By UserRemoveBtnClickYes = getElementLocator(prop.getProperty("Workspaces.UserRemoveBtnClickYes"));
	By Spinner = getElementLocator(prop.getProperty("Spinner"));

	// Updated
	By WksSelectAll_wkschk = getElementLocator(prop.getProperty("Wks.SelectAllWks"));
	By Wks_Checkbox = getElementLocator(prop.getProperty("Wks.SelectWksCheckboxTD"));
	By Wks_NewWorkspacebtn = getElementLocator(prop.getProperty("wks.NewWksButton"));
	By Wks_Refeshbtn = getElementLocator(prop.getProperty("wks.RefreshButton"));
	By Wks_Deletebtn = getElementLocator(prop.getProperty("wks.DeleteButton"));


	// ********Updated******//
	By HomeLink = getElementLocator(prop.getProperty("Users.HomeLink"));
	By NewWorkspaceInput = getElementLocator(prop.getProperty("NewWorkspaceInput"));
	By NewWorkspaceButtons = getElementLocator(prop.getProperty("NewWorkspaceButtons"));

	By workspaceAccountNameLabel = getElementLocator(prop.getProperty("workspaceAccountNameLabel"));
	By workspaceLabel = getElementLocator(prop.getProperty("workspaceLabel"));
	By workspaceDescLabel = getElementLocator(prop.getProperty("workspaceDescLabel"));
	By workspaceTypeLabel = getElementLocator(prop.getProperty("workspaceTypeLabel"));

	String workspaceCreatedText = prop.getProperty("workspaceCreatedText");
	By workspaceCreatedMsg = getElementLocator(prop.getProperty("workspaceCreatedMsg"));
	By toastMsgClosedBtn = getElementLocator(prop.getProperty("ToastMsgClosedBtn"));

	String workspaceRetrievedText = prop.getProperty("workspaceRetrievedText");
	By workspaceRetrievedMsg = getElementLocator(prop.getProperty("workspaceRetrievedMsg"));

	public By workspaceNameMandatoryVal = getElementLocator(prop.getProperty("workspaceNameMandatoryVal"));
	public By workspaceNameSpecialCharVal = getElementLocator(prop.getProperty("workspaceNameSpecialCharVal"));
	public String workspaceNameSpecialCharError = prop.getProperty("workspaceNameSpecialCharError");
	public String workspaceNameMandatoryText = prop.getProperty("workspaceNameMandatoryText");

	public By ExceedCharValMsg = getElementLocator(prop.getProperty("workspace.ExceedCharValMsg"));
	public String ExceedCharactersTextDetails = prop.getProperty("ExceedCharactersTextDetails");
	public String NameExceedCharErrorMsgText = prop.getProperty("NameExceedCharErrorMsgText");

	public String ExceedDescriptionTextDetails = prop.getProperty("ExceedDescriptionTextDetails");
	public By DescriptionExceedCharValMsg = getElementLocator(prop.getProperty("DescriptionExceedCharValMsg"));
	public String DescriptionExceedCharErrorMsgText = prop.getProperty("DescriptionExceedCharErrorMsgText");

	public String workspaceName = prop.getProperty("workspaceName");
	public String workspaceAccountName = prop.getProperty("workspaceAccountName");
	public String workspaceDescription = prop.getProperty("workspaceDescription");
	public String workspaceType = prop.getProperty("workspaceType");

	String duplicateWorkspaceValidationText = prop.getProperty("duplicateWorkspaceValidationText");
	By duplicateWorkspaceValidationMsg = getElementLocator(prop.getProperty("duplicateWorkspaceValidationMsg"));

	// New details
	// Search Account
	By WorkSearchTextbox = getElementLocator(prop.getProperty("Workspaces.UserSearchTextbox"));
	By WorkSearchTextboxButton = getElementLocator(prop.getProperty("Workspaces.UserSearchTextboxButton"));
	By WorkSearchList1 = getElementLocator(prop.getProperty("Workspaces.listsearchtest"));
	String WorkSearchList = prop.getProperty("Workspaces.WorkspaceSearchList");
	// Search Assign Users/groups in account
	By UG_SearchBar = getElementLocator(prop.getProperty("Account.UserSearchTextbox"));
	By UG_SearchClick = getElementLocator(prop.getProperty("Account.UserSearchTextboxButton"));
	By UG_SearchData = getElementLocator(prop.getProperty("Account.UserSearchData"));
	By AddedGroupDetails = getElementLocator(prop.getProperty("Users.AddedGroupDetails"));
	// Search Assigned workspaces in account
	By WS_SearchBar = getElementLocator(prop.getProperty("Account.WorkspaceTextbox"));
	By WS_SearchClick = getElementLocator(prop.getProperty("Account.WorkspaceTextboxButton"));
	By WS_SearchData = getElementLocator(prop.getProperty("Account.WorkspaceSearchData"));
	// Toast Messages
	public String workspaceCreateText = prop.getProperty("WorkspaceCreatedText");
	By groupCreatedMsg = getElementLocator(prop.getProperty("GroupCreatedMsg"));
	// By toastMsgClosedBtn =
	// getElementLocator(prop.getProperty("ToastMsgClosedBtn"));
	By accountRetriveMsg = getElementLocator(prop.getProperty("AccountRetrivedMsg"));
	String groupDeleteToastMsg = prop.getProperty("GroupDeleteText");
	By commonToastMsg = getElementLocator(prop.getProperty("Commontoastmsg"));
	// Discard new/existing Workspace details
	// By AccountDropdown =
	// getElementLocator(prop.getProperty("Workspaces.AccountDropdown"));
	By existingAccoutName = getElementLocator(prop.getProperty("Work.D_ExistAccountName"));
	By accountTextbox = getElementLocator(prop.getProperty("Word.selectAccount"));
	public String ExistingAccount = prop.getProperty("ExistingAccount");
	public String DiscardworkspaceName = prop.getProperty("Work.D_Workname");
	public String Description = prop.getProperty("Work.D_Desc");
	public String DiscardalertYes = prop.getProperty("Work.D_DiscardAlert");
	public String Workspace_search = prop.getProperty("Work.D_SearchExistingWorkspace");
	public String RetriveDetailsMsg = prop.getProperty("WorkDetailMsg");
	By DiscardButton = getElementLocator(prop.getProperty("Workspaces.WorkspaceDiscardBtn"));
	By DiscardAlertYes = getElementLocator(prop.getProperty("Workspaces.WorkspaceDiscardBtnYes"));
	By DiscardAlertNo = getElementLocator(prop.getProperty("Workspaces.WorkspaceDiscardBtnNo"));
	By DiscardMsg = getElementLocator(prop.getProperty("Work.DiscardMsg"));
	// Create new Workspace
	By selectAccount = getElementLocator(prop.getProperty("Workspaces.AccountDropdown"));
	By newWorkspaceName = getElementLocator(prop.getProperty("Workspaces.WorkspaceName"));
	By workspaceDescdetails = getElementLocator(prop.getProperty("Workspaces.WorkspaceDescription"));
	By selectWorkspaceType = getElementLocator(prop.getProperty("Workspaces.type"));
	// By Workspacetype = getElementLocator(prop.getProperty("Workspaces.type"));
	// Assign Window without Role selection in workspace
	By Labelusergroup = getElementLocator(prop.getProperty("Work.userGroupTab"));
	By addBtn = getElementLocator(prop.getProperty("Work.AddBtn"));
	By assignRoleLabel = getElementLocator(prop.getProperty("Work.AssignRoleLabel"));
	By roleDropLabel = getElementLocator(prop.getProperty("Work.AW_role"));
	By accessDropLabel = getElementLocator(prop.getProperty("Work.AW_assign"));
	By selectDropLabel = getElementLocator(prop.getProperty("Work.AW_select"));
	By blankrole = getElementLocator(prop.getProperty("Work.blankrole"));
	By userTextBox = getElementLocator(prop.getProperty("Work.usertextbox"));
	public String AssignUserInWorkspace = prop.getProperty("WorkAssignuser");
	By assignBtnLabel = getElementLocator(prop.getProperty("Work.addBtnLabel"));
	public String validationToast = prop.getProperty("WorkValidationTxt");
	// Assign Window without user/group selection
	public String AssignRoleInWorkspace = prop.getProperty("Assignrole");
	By roleTextbox = getElementLocator(prop.getProperty("Work.roleTextBox"));
	public String UserGroupvalidationToast = prop.getProperty("UserGroupvalidationTxt");
	By roleDroptxtbox = getElementLocator(prop.getProperty("Work.roleDroptxtBox"));
	// Update Workspace
	public String UpdatedWorkspaceName = prop.getProperty("Work.Up_Workspacename");
	public String UpdatedDescription = prop.getProperty("Work.Up_Desc");
	public String SearchWorkspaceForUpdate = prop.getProperty("Work.D_Workname");
	// Remove Group role Check In Group section
	public String removedGroupSearch = prop.getProperty("Account.RemovedgroupSearch");
	By groupSelectCheck = getElementLocator(prop.getProperty("Accounts.UserCheckbox"));
	By removedBtn = getElementLocator(prop.getProperty("Accounts.RemoveAddedUserBtn"));
	By removeBtnYes = getElementLocator(prop.getProperty("Account.removeBtnYes"));
	public String revoRemoveToastMsg = prop.getProperty("removeRevoToastMsg");
	public String existingGroupSearch = prop.getProperty("searchExistingGroup");
	By labelAccouttab = getElementLocator(prop.getProperty("labelAccoutTab"));
	// Spinner
	By spinner = getElementLocator(prop.getProperty("Spinner"));
	

	By workspaceSearchBar = getElementLocator(prop.getProperty("Workspaces.WorkspaceSearchBar"));
	By workspaceSearchClick = getElementLocator(prop.getProperty("Workspaces.WorkspaceSearchClick"));
	By workspaceRetrivedMsg = getElementLocator(prop.getProperty("WorkspaceRetrivedMsg"));
	By workspaceAccessTo = getElementLocator(prop.getProperty("Workspace.AccessTo"));
	By userToolbarWorkspace = getElementLocator(prop.getProperty("Users.Toolbar.Workspace"));
	By userWorkspaceSearchbar = getElementLocator(prop.getProperty("Workspace.UserWorkspaceSearchbar"));
	By userWorkspaceSearchClick = getElementLocator(prop.getProperty("Workspace.UserWorkspaceSearchClick"));
	By userWorkspaceRecord = getElementLocator(prop.getProperty("Workspace.UserWorkspaceRecord"));
	By workspaceNameLabel = getElementLocator(prop.getProperty("User.WorkspaceNameLabel"));
	By workspaceRoleLabel = getElementLocator(prop.getProperty("User.WorkspaceRoleLabel"));
	By userWorkspaceTypeLabel = getElementLocator(prop.getProperty("User.WorkspaceTypeLabel"));
	By workspaceAccountLabel = getElementLocator(prop.getProperty("User.WorkspaceAccountLabel"));
	By workspaceScopeLabel = getElementLocator(prop.getProperty("User.WorkspaceScopeLabel"));
	By groupWorkspaceSearchbar = getElementLocator(prop.getProperty("Workspace.GroupWorkspaceSearchbar"));
	By groupWorkspaceSearchClick = getElementLocator(prop.getProperty("Workspace.GroupWorkspaceSearchClick"));
	By groupWorkspaceRecord = getElementLocator(prop.getProperty("Workspace.groupWorkspaceRecord"));
	By headerTextName = getElementLocator(prop.getProperty("Accounts.HeaderTextName"));
	By headerTextType = getElementLocator(prop.getProperty("Accounts.HeaderTextType"));
	By headerTextScope = getElementLocator(prop.getProperty("Accounts.HeaderTextScope"));
	By headerTextRole = getElementLocator(prop.getProperty("Accounts.HeaderTextRole"));
	By assignDropDown = getElementLocator(prop.getProperty("Accounts.AssignDropDown"));
	By selectUserName = getElementLocator(prop.getProperty("Accounts.SelectUserName"));
	By addRoleBtn = getElementLocator(prop.getProperty("Accounts.AddRoleBtn"));
	By userGroupAddMess = getElementLocator(prop.getProperty("Accounts.UserGroupAddMess"));
	By addUser_GroupBtn = getElementLocator(prop.getProperty("Accounts.AddUser_GroupBtn"));
	By refreshAccountsBtn = getElementLocator(prop.getProperty("Accounts.RefreshAccountsBtn"));
	By removeAddedUserBtn = getElementLocator(prop.getProperty("Accounts.RemoveAddedUserBtn"));
	By accountUserGroupSearchBar = getElementLocator(prop.getProperty("Accounts.AccountUserGroupSearchBar"));
	By accountUserGroupSearchClick = getElementLocator(prop.getProperty("Accounts.AccountUserGroupSearchClick"));
	By accountUserGroupSingleCheckbox = getElementLocator(prop.getProperty("Accounts.AccountUserGroupSingleCheckbox"));
	By removeDiscardYesButton = getElementLocator(prop.getProperty("Accounts.RemoveDiscardYesButton"));
	By userGroupRemoveMess = getElementLocator(prop.getProperty("Accounts.UserGroupRemoveMess"));

	
	By workspaceSearchListDetailRow = getElementLocator(prop.getProperty("workspaceSearchListDetailRow"));
	
	String WorkspaceSearchList = prop.getProperty("Workspaces.WorkspaceSearchList");
	String workDetailMsg = prop.getProperty("WorkDetailMsg");
	String userGroupAddText = prop.getProperty("Accounts.UserGroupAddText");
	String userGroupTypeRole = prop.getProperty("Accounts.UserGroupTypeRole");
	String userGroupName = prop.getProperty("Accounts.UserGroupName");
	String userGroupRemoveText = prop.getProperty("Accounts.UserGroupRemoveText");
	
	public String searchNameUser = prop.getProperty("Workspace.UserSearchName");
	public String SearchNameGroup = prop.getProperty("Workspace.GroupSearchName");
	public String workspaceSearchName = prop.getProperty("Workspace.WorkspaceSearchName");
	
	
	//===============================Role Based===========================================//
	public String WorkspaceDetails = prop.getProperty("WorkspaceDetails");
	public String roleWorkspace = prop.getProperty("roleWorkspace");
	public String accesstoGroup = prop.getProperty("accesstoGroup");
	public String accessToGroup_Workspace = prop.getProperty("accessToGroup_Workspace");
	public String OwnerWorkspaceDetails = prop.getProperty("OwnerWorkspaceDetails");
	public String ContributorWorkspaceDetails = prop.getProperty("ContributorWorkspaceDetails");
	public String ExecutorWorkspaceDetails = prop.getProperty("ExecutorWorkspaceDetails");
	public String ReaderWorkspaceDetails = prop.getProperty("ReaderWorkspaceDetails");
	
	By welcomeSectionClick = getElementLocator(prop.getProperty("welcomeSectionClick"));
	By clickOnProfileOption = getElementLocator(prop.getProperty("clickOnProfileOption"));
	By ProfileUserName = getElementLocator(prop.getProperty("ProfileUserName"));
	By homeLink = getElementLocator(prop.getProperty("homeLink"));
	By RefreshAccountsBtn = getElementLocator(prop.getProperty("Accounts.RefreshAccountsBtn"));
	public By workspaceRetrivedMsgDetails = getElementLocator(prop.getProperty("workspaceRetrivedMsg"));
	String WorkspaceDetailsRetrivedText = prop.getProperty("WorkspaceDetailsRetrivedText");
	String nonAdminValidationText = prop.getProperty("nonAdminValidationText");
	By NewUsersHeader = getElementLocator(prop.getProperty("Users.NewUsersHeader"));
	By BlankUserList = getElementLocator(prop.getProperty("BlankUserList"));
	String BlankUserListText = prop.getProperty("BlankUserListText");
	
	
	//Account properties reuse
	public String role = prop.getProperty("role");
	public String accessto = prop.getProperty("accessto");
	public String accessToGroup = prop.getProperty("accessToGroup");
	public String addUserInAccount = prop.getProperty("addUserInAccount");
	public String NextGenAccountName = prop.getProperty("NextGenAccountName");
	public String NextGenAccountDesc = prop.getProperty("NextGenAccountDesc");
	
	By roleAssignDiscardBtn = getElementLocator(prop.getProperty("roleAssignDiscardBtn"));
	By listOfAssignUsersGroupsToWS = getElementLocator(prop.getProperty("listOfAssignUsersGroupsToWS"));
	By selectCheckboxOfUserGroup = getElementLocator(prop.getProperty("selectCheckboxOfUserGroup"));
	By singleSelectedCheckbox = getElementLocator(prop.getProperty("singleSelectedCheckbox"));
	
	
	
	
	
	
	//===============================Methods===========================================//
	
	public void clickOnWorkspaceMenu() throws InterruptedException {

		isDisplayedInLoop(driver, 30, WorkspaceMenu);
		click(driver, WorkspaceMenu);
		BaseSuite.validationReportLog("Clicked on the Workspace Menu");
		Thread.sleep(3000);
		BaseSuite.reportLog(":::::::: Verifying workspace landing page details :::::::: ");
		defaultWorkspacePageVerification();
		workspacePageGridDetails();
		numberOfWorkspaces();
	}
	
	public void clickWSMenu() throws InterruptedException {

		isDisplayedInLoop(driver, 30, WorkspaceMenu);
		click(driver, WorkspaceMenu);
		BaseSuite.validationReportLog("Clicked on the Workspace Menu");
		Thread.sleep(3000);
	}

	public void workspacePageGridDetails() throws InterruptedException {
		String userPageDetails = "Name/Description/Account/Last Modified";

		if ((isDisplayed(driver, WorkspaceNameCol)) && (isDisplayed(driver, WorkspaceDescriptionCol))
				&& (isDisplayed(driver, AccountCol)) && (isDisplayed(driver, LastModifiedCol))) {
			BaseSuite.reportLog("Checking Columns in the Grid details of Workspace page!");
			BaseSuite.validationReportLog(userPageDetails + " labels are displayed properly in the Workspace Page!");
			BaseSuite.validationReportLog("Columns in the Workspace page are displaying properly!");

		} else {
			BaseSuite.reportFailLog(userPageDetails + " are not displaying in the page", "workspacePageGridDetails");
		}
	}

	public void defaultWorkspacePageVerification() throws InterruptedException {

		BaseSuite.reportLog("Verifying New Button in the Workspace page");

		boolean newWorkspaceButton = isEnabled(driver, NewWorkspaceBtn);

		if (newWorkspaceButton) {
			BaseSuite.validationReportLog("New Workspace creation button is enabled");
		} else {
			BaseSuite.reportFailLog("New Workspace creation button is disabled", "defaultWorkspacePage");
		}

		BaseSuite.reportLog("Verifying Refresh Button in the Workspace page");

		boolean refreshButton = isEnabled(driver, RefreshWorkspaceBtn);

		if (refreshButton) {
			BaseSuite.validationReportLog("Refresh button is enabled");

		} else {

			BaseSuite.reportFailLog("Refresh button is disabled", "defaultWorkspacePage");
		}

		BaseSuite.reportLog("Verifying Delete button in the Workspace Page");

		boolean deleteWorkspace = isDisplayed(driver, DeleteWorkspaceBtn);

		if (deleteWorkspace) {

			BaseSuite.validationReportLog("Delete workspace button is disabled");

		} else {

			BaseSuite.reportFailLog("Delete user button is enabled", "defaultWorkspacePage");
		}

	}

	public void numberOfWorkspaces() throws InterruptedException {
		isDisplayedInLoop(driver, 20, NumberOfWorkspace);
		Thread.sleep(3000);
		BaseSuite.reportLog("Verifying the total number of workspaces");
		String numbers = getText(driver, NumberOfWorkspace);
		if(!numbers.isEmpty()) {
		BaseSuite.validationReportLog("Number of workspaces are available for the login user");
		BaseSuite.reportLog("Available Workspaces " + numbers);
		BaseSuite.validationReportLog(numbers + " number of Workspaces  are displaying in the Workspace Page!!!");

		}
		else
		{
			BaseSuite.reportFailLog("Number of workspaces are not displaying in the workspace page!", "numberOfWorkspaces");

		}
		
	}

	public void clickOnNewWorkspaceButton() {

		isDisplayedInLoop(driver, 30, NewWorkspaceBtn);
		click(driver, NewWorkspaceBtn);
		BaseSuite.validationReportLog(" Clicked on the New Workspace button!");

		validateInputFields(driver, NewWorkspaceInput, 1);
		validateButtons(driver, NewWorkspaceButtons, 2);
		verifyIndividualLabel(driver, workspaceAccountNameLabel, "Account Name");
		verifyIndividualLabel(driver, workspaceLabel, "Workspace Name");
		verifyIndividualLabel(driver, workspaceDescLabel, "Workspace Description");
		verifyIndividualLabel(driver, workspaceTypeLabel, "Workspace Type");
		isClickable(driver, HomeLink, "Home", true);
		getAllLinkAndVerifyLinkText(driver, HomeLink, "Home");
		verifyNewWorkspacePage();
	}

	public void clickOnSaveWorkspaceBtn() throws InterruptedException {

		BaseSuite.reportLog("Clicking on the Save button..");
		isDisplayedInLoop(driver, 40, WorkspaceSaveBtn);
		click(driver, WorkspaceSaveBtn);
		BaseSuite.validationReportLog("Save button clicked successfully..");

		try {
			captureToastMsg(driver, workspaceCreatedMsg, toastMsgClosedBtn, workspaceCreatedText, "Workspace Created");
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		Thread.sleep(3000);
		validateInputFields(driver, NewWorkspaceInput, 1);
		validateButtons(driver, NewWorkspaceButtons, 2);

	}

	public void workspaceNameValidate(String specialCharacter, String specialCharacterKey, By locator1, By locator2,
			String backSpaceKey, String lable, String specialCharErrorMsg, String backSpaceErrorMsg, By locator3)
			throws InterruptedException {

		mandatoryFieldValidation(specialCharacter, specialCharacterKey, locator1, locator2, backSpaceKey, lable,
				specialCharErrorMsg, backSpaceErrorMsg, locator3);

		driver.navigate().refresh();
		Thread.sleep(3000);
		visible(driver, WorkspaceName, Constant.ruleWait);
	}

	public void mandatoryFieldValidation(String specialCharacter, String specialCharacterKey, By locator1, By locator2,
			String backSpaceKey, String lable, String specialCharErrorMsg, String backSpaceErrorMsg, By locator3) {

		SoftAssert soft = new SoftAssert();

		if (specialCharacter.equalsIgnoreCase("Yes") && !specialCharacterKey.isEmpty()) {

			specialCharaMandatoryField(driver, locator1, locator3, specialCharacterKey, soft, lable,
					specialCharErrorMsg);
		} else {

			if (!(backSpaceKey.equalsIgnoreCase("Yes"))) {
				otherMandatoryField(driver, locator1, locator2, backSpaceKey, soft, lable, backSpaceErrorMsg);

			}

		}
	}

	public boolean workspaceNameWithMoreThan50Char(String exceedWorkspaceName, By locator2, String lable,
			String errorMess, SoftAssert soft) throws InterruptedException {

		BaseSuite.reportLog("Entering the details of the Workspace Name with more than 50 characters:::");

		clear_Click_SendKeys(driver, 30, WorkspaceName, exceedWorkspaceName);
		BaseSuite.reportLog("Entered Workspace name: " + exceedWorkspaceName);

		String workspaceNameErrmsg = getText(driver, locator2).trim();
		BaseSuite.validationReportLog("Retrived Message for " + lable + " field is :" + workspaceNameErrmsg);
		BaseSuite.validationReportLog("Expected Message for " + lable + " field is :" + errorMess);

		boolean status = false;
		if (!workspaceNameErrmsg.isEmpty()) {
			soft.assertEquals(workspaceNameErrmsg.trim(), errorMess.trim());
			status = true;
			BaseSuite.validationReportLog(lable + "Field Error Message Successfully Matched");
		} else {
			BaseSuite.reportFailLog(lable + "Field Error Message not Matched", "userNameWithMoreThan50Char");
			status = false;
		}
		return status;

	}

	public boolean workspaceDescriptionWithMoreThan250Char(String exceedWorkspaceDescription, By locator2, String lable,
			String errorMess, SoftAssert soft) throws InterruptedException {

		BaseSuite.reportLog("Entering the details of the Workspace Description with more than 250 characters:::");

		clear_Click_SendKeys(driver, 30, WorkspaceDescription, exceedWorkspaceDescription);
		BaseSuite.reportLog("Entered Workspace description: " + exceedWorkspaceDescription);

		String workspaceDescriptionErrmsg = getText(driver, locator2).trim();
		BaseSuite.validationReportLog("Retrived Message for " + lable + " field is :" + workspaceDescriptionErrmsg);
		BaseSuite.validationReportLog("Expected Message for " + lable + " field is :" + errorMess);

		boolean status = false;
		if (!workspaceDescriptionErrmsg.isEmpty()) {
			soft.assertEquals(workspaceDescriptionErrmsg.trim(), errorMess.trim());
			status = true;
			BaseSuite.validationReportLog(lable + "Field Error Message Successfully Matched");
		} else {
			BaseSuite.reportFailLog(lable + "Field Error Message not Matched", "userNameWithMoreThan50Char");
			status = false;
		}
		return status;
	}

	public void workspaceNameWithBlankData(By locator1, By locator2, String keysToSend, SoftAssert soft, String lable,
			String errorMess) {
		BaseSuite.reportLog("Checking validation message for Workspace Name textbox with blank data");
		otherMandatoryField(driver, locator1, locator2, keysToSend, soft, lable, errorMess);
		BaseSuite.validationReportLog("Workspace Name textbox is showing proper validation message ");
	}

	public void workspaceSearchFromListOfWorkspaces(String Workspace_search) throws Exception {

		BaseSuite.reportLog("Searching for Workspace: " + Workspace_search);
		isDisplayedInLoop(driver, 30, WorkspaceSearchBar);

		javascript(driver, "arguments[0].click();", WorkspaceSearchBar);
		clear(driver, WorkspaceSearchBar);

		isDisplayedInLoop(driver, 30, WorkspaceSearchBar);
		BaseSuite.validationReportLog("Entering the workspace name to search the workspace");
		sendKeys(driver, WorkspaceSearchBar, Workspace_search);

		isDisplayedInLoop(driver, 30, WorkspaceSearchClick);

		javascript(driver, "arguments[0].click();", WorkspaceSearchClick);

		BaseSuite.reportLog("Clicked on the search for the Workspace button");
		Thread.sleep(3000);
		try {

			BaseSuite.validationReportLog("Clicking on Searched Workspace");

			displayAndClick(driver, workspaceSearchListDetailRow);


			//javascript(driver, "arguments[0].click();", returnElement(WorkspaceSearchList, "$User", Workspace_search));
			
			//displayAndClick(driver, returnElement(WorkspaceSearchList, "$User", Workspace_search));
		//	javascript(driver, "arguments[0].click();", returnElement(WorkspaceSearchList, "$User", Workspace_search));

			BaseSuite.reportLog("Clicked on Workspace: " + Workspace_search);
			
		//	captureToastMsg(driver, workspaceRetrievedMsg, toastMsgClosedBtn, workspaceRetrievedText, "Workspace retrieved");
			 
			BaseSuite.validationReportLog("Workspace Details retrieved successfully for workspace " + Workspace_search);

			Thread.sleep(3000);
			String getValue = getAttribute(driver, WorkspaceSearchDataDetails, "value");

			BaseSuite.reportLog("Checking the workspace details in the workspace page");

			System.out.println(getValue);

			if (getValue.equalsIgnoreCase(Workspace_search)) {
				System.out.println("Searched Workspace is  " + Workspace_search);
				BaseSuite.reportLog("Searched Workspace is  " + Workspace_search);

				BaseSuite.validationReportLog("Searched Workspace ::::: " + Workspace_search);
			}

			else {
				System.out.println("Searched Workspace is not proper " + WorkspaceSearchDataDetails);
			}

		} catch (Exception e) {
			throw new Exception("Workspace_search " + WorkspaceSearchClick + " not found");
		}

	}

	public void createWorkspace(String account, String workspaceName, String workspaceDesc, String type)
			throws InterruptedException

	{
		clickOnWorkspaceMenu();
		Thread.sleep(3000);
		BaseSuite.reportLog("Checking the New Workspace button");
		isDisplayedInLoop(driver, 30, NewWorkspaceBtn);
		click(driver, NewWorkspaceBtn);
		BaseSuite.validationReportLog("Clicked on the New Workspace button");

		verifyNewWorkspacePage();

		BaseSuite.reportLog("Selecting the Account:::: " + account);
		isDisplayedInLoop(driver, 30, AccountDropdown);
		click(driver, AccountDropdown);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Select Account']")).sendKeys(account);
		Thread.sleep(2000);

		BaseSuite.reportLog("Entering the Workspace Name:::: " + workspaceName);
		isDisplayed(driver, WorkspaceName);
		sendKeys(driver, WorkspaceName, workspaceName);

		BaseSuite.reportLog("Entering the Workspace Description:::: " + workspaceDesc);
		isDisplayed(driver, WorkspaceDescription);
		sendKeys(driver, WorkspaceDescription, workspaceDesc);

		BaseSuite.reportLog("Selecting the Workspace type:::: " + type);
		isDisplayed(driver, Workspacetype);

		click(driver, Workspacetype);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"ddlelement\"]/span/input[@placeholder='Select Type']")).sendKeys(type);
		Thread.sleep(3000);

		BaseSuite.reportLog("Verifying Save button");

		boolean saveWorkspace = isDisplayed(driver, WorkspaceSaveBtn);

		if (saveWorkspace) {

			BaseSuite.validationReportLog("Save Workspace button is enabled");
			isDisplayedInLoop(driver, 30, WorkspaceSaveBtn);

			waitForElement(driver, WorkspaceSaveBtn);
			BaseSuite.reportLog("Clicking the workspace save button...");
			click(driver, WorkspaceSaveBtn);
			Thread.sleep(5000);
			BaseSuite.validationReportLog("Workspace saved successfully");
			BaseSuite.validationReportLog("New "+type +" Workspace created successfully--" + workspaceName);
			System.out.println("New Workspace created successfully--" + workspaceName);

		} else {

			BaseSuite.reportFailLog("Save Workspace button is disabled", "createWorkspace");
		}

	}

	public void CreateAccountWithValidInvalidData(SoftAssert softAssert, String account, String workspaceName,
			String workspaceDesc, String type, String Scenario) {
		try {
			clickOnWorkspaceMenu();
			Thread.sleep(3000);
			BaseSuite.reportLog("Checking the New Workspace button");
			isDisplayedInLoop(driver, 30, NewWorkspaceBtn);
			javascript(driver, "arguments[0].click();", NewWorkspaceBtn);
			BaseSuite.validationReportLog("Clicked on the New Workspace button");

			verifyNewWorkspacePage();

			BaseSuite.reportLog("Selecting the Account:::: " + account);
			isDisplayedInLoop(driver, 30, AccountDropdown);
			click(driver, AccountDropdown);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Select Account']")).sendKeys(account);
			Thread.sleep(2000);

			BaseSuite.reportLog("Entering the Workspace Name:::: " + workspaceName);
			isDisplayed(driver, WorkspaceName);
			sendKeys(driver, WorkspaceName, workspaceName);

			BaseSuite.reportLog("Entering the Workspace Description:::: " + workspaceDesc);
			isDisplayed(driver, WorkspaceDescription);
			sendKeys(driver, WorkspaceDescription, workspaceDesc);

			BaseSuite.reportLog("Selecting the Workspace type:::: " + type);
			isDisplayed(driver, Workspacetype);

			click(driver, Workspacetype);
			click(driver, Workspacetype);
			Thread.sleep(3000);

			BaseSuite.reportLog("Verifying Save button");

			if (isDisplayed(driver, WorkspaceSaveBtn) && Scenario.equalsIgnoreCase("Valid")) {
				click(driver, WorkspaceSaveBtn);
				BaseSuite.reportLog("New Workspace created successfully: Account Workspace is " + workspaceName);
				BaseSuite.validationReportLog("New Workspace created successfully");
				System.out.println("New Workspace created successfully");

				Thread.sleep(3000);
				clickOnWorkspaceMenu();

			} else if (isDisplayed(driver, WorkspaceDiscardBtn) && Scenario.equalsIgnoreCase("Invalid")) {

				isDisplayedInLoop(driver, 40, WorkspaceDiscardBtn);
				click(driver, WorkspaceDiscardBtn);
				Thread.sleep(3000);
				isDisplayedInLoop(driver, 40, WorkspaceDiscardBtnYes);
				javascript(driver, "arguments[0].click();", WorkspaceDiscardBtnYes);

				isDisplayedInLoop(driver, 30, NewWorkspaceBtn);

				BaseSuite.reportLog("Workspace creation has been discarded " + workspaceName);
				BaseSuite.reportErrorLog("Entered data is invalid");

				System.out.println("Workspace creation has been discarded " + workspaceName);
				BaseSuite.validationReportLog("Workspace creation has been discarded successfully");
			}

			else if (isDisplayed(driver, WorkspaceSaveBtn) && isDisplayed(driver, WorkspaceDiscardBtn)
					&& Scenario.equalsIgnoreCase("Duplicate")) {

				click(driver, WorkspaceSaveBtn);
				BaseSuite.reportLog("Clicked on the save button");

				if (isEnabled(driver, WorkspaceDiscardBtn)) {
					BaseSuite.reportLog(
							"Failed to save Workspace :: Error: Workspace with same name already present in system "
									+ workspaceName);

					isDisplayedInLoop(driver, 40, WorkspaceDiscardBtn);
					javascript(driver, "arguments[0].click();", WorkspaceDiscardBtn);
					Thread.sleep(3000);

					isDisplayedInLoop(driver, 40, WorkspaceDiscardBtnYes);
					javascript(driver, "arguments[0].click();", WorkspaceDiscardBtnYes);
					isDisplayedInLoop(driver, 30, NewWorkspaceBtn);
				} else {
					BaseSuite.reportErrorLog("Able to create Workspace with same:: Workspace name:  " + workspaceName);
				}

				BaseSuite.reportLog("Workspace creation has been discarded for the duplicate account ");
			}

			else {
				BaseSuite.reportLog("Not able to create the Workspace");
			}

		}

		catch (Exception ex) {
			throw new AssertionError("User not able to create new Workspace", ex);
		}
	}

	public void verifyNewWorkspacePage() {

		BaseSuite.reportLog(":::::::: Verifying the New Workspace Creation Page ::::::::");

		BaseSuite.reportLog("Verifying Save button in the New Workspace Page");

		boolean saveWorkspace = isDisplayed(driver, WorkspaceSaveBtn);

		if (saveWorkspace) {

			BaseSuite.validationReportLog("Save Workspace button is disabled");

		} else {

			BaseSuite.reportFailLog("Save Workspace button is enabled", "verifyNewWorkspacePage");
		}

		BaseSuite.reportLog("Verifying Discard button in the New Workspace Page");

		boolean discardWorkspace = isDisplayed(driver, WorkspaceDiscardBtn);

		if (discardWorkspace) {

			BaseSuite.validationReportLog("Discard Workspace button is disabled");

		} else {

			BaseSuite.reportFailLog("Discard Workspace button is enabled", "verifyNewWorkspacePage");
		}

		BaseSuite.reportLog("Verifying Select Account dropdown option in the New Workspace Page");
		boolean selectAccount = isDisplayed(driver, select_Account);

		if (selectAccount) {

			BaseSuite.validationReportLog("Select Account dropdown option is enabled");

		} else {

			BaseSuite.reportFailLog("Select Account dropdown option is disabled", "verifyNewWorkspacePage");
		}

		BaseSuite.reportLog("Verifying Workspace Name textbox in the New Workspace Page");
		boolean workspaceName = isDisplayed(driver, WorkspaceName);

		if (workspaceName) {

			BaseSuite.validationReportLog("Workspace Name textbox is enabled");

		} else {

			BaseSuite.reportFailLog("Workspace Name textbox is disabled", "verifyNewWorkspacePage");
		}

		BaseSuite.reportLog("Verifying Workspace Description textbox in the New Workspace Page");
		boolean workspaceDescription = isDisplayed(driver, WorkspaceDescription);

		if (workspaceDescription) {

			BaseSuite.validationReportLog("Workspace Description textbox is enabled");

		} else {

			BaseSuite.reportFailLog("Workspace Description textbox is disabled", "verifyNewWorkspacePage");
		}

		BaseSuite.reportLog("Verifying Select Workspacetype dropdown option in the New Workspace Page");
		boolean workspacetype = isDisplayed(driver, Workspacetype);

		if (workspacetype) {

			BaseSuite.validationReportLog("Select Workspacetype dropdown option is enabled");

		} else {

			BaseSuite.reportFailLog("Select Type dropdown option is disabled", "verifyNewWorkspacePage");
		}

	}

	public void roleAssignment(String role, String accessTo, String selectDetails) throws Exception {

		isDisplayed(driver, User_GroupTab);
		BaseSuite.reportLog("Clicking on the User/Group tab ");
		javascript(driver, "arguments[0].click();", User_GroupTab);
		BaseSuite.validationReportLog("Clicked on the User/Group tab");

		isDisplayedInLoop(driver, 30, AddUser_GroupBtn);
		BaseSuite.reportLog("Clicking on the Add User/Group button ");
		javascript(driver, "arguments[0].click();", AddUser_GroupBtn);
		BaseSuite.validationReportLog("Clicked on the Add User/Group button");

		if (isDisplayed(driver, RoleAssignmentLabel)) {
			BaseSuite.reportLog("Role Assignment window is opened to add roles to the User/Group");

			isDisplayedInLoop(driver, 30, RoleDropDown);
			javascript(driver, "arguments[0].click();", RoleDropDown);
			BaseSuite.reportLog("Clicked on the Role dropdown");
			sendKeys(driver, RoleDropDown, role);
			BaseSuite.validationReportLog("Added Role is--" + role);

			isDisplayedInLoop(driver, 30, AccessTo);
			Thread.sleep(3000);
			click(driver, AccessTo);
			Thread.sleep(2000);
			sendKeys(driver, AssignmentOfUser_Group, accessTo);
			BaseSuite.reportLog("Clicked on Access Assign to");
			BaseSuite.validationReportLog("Role Assign to --" + accessTo);

			BaseSuite.reportLog("Selecting the details of User/Group -- ");
			click(driver, AddRole);
			Thread.sleep(2000);
			sendKeys(driver, AddRole, selectDetails);
			driver.findElement(By.xpath("//input[@class='e-dropdownbase']")).sendKeys(Keys.ENTER);
			BaseSuite.validationReportLog("Selected User/Group details is --" + selectDetails);

			isDisplayedInLoop(driver, 30, AddRoleBtn);
			click(driver, AddRoleBtn);
			BaseSuite.reportLog("Clicked on the Add button for the role assignment");
			Thread.sleep(2000);
			BaseSuite.reportLog("Roles assignment successfully done for the User/Group");
			BaseSuite.validationReportLog("Roles assignment successfully!!!");

		} else {
			BaseSuite.reportErrorLog("Unable to load the Role Assignment window");
		}

	}

	public void deleteUser_GroupFromExistingWorkspace(String user_search) throws Exception {

		isDisplayedInLoop(driver, 30, User_GroupTab);
		BaseSuite.reportLog("Clicking on the User_GroupTab");
		javascript(driver, "arguments[0].click();", User_GroupTab);
		BaseSuite.validationReportLog("Clicked on the User_GroupTab ");

		BaseSuite.reportLog("Searching for User/Group:" + user_search);
		isDisplayedInLoop(driver, 30, UserSearchTextbox);

		// --------Search already added user and delete accordingly-----
		BaseSuite.reportLog("Clicking on the user/group search text box");
		click(driver, UserSearchTextbox);
		clear(driver, UserSearchTextbox);
		BaseSuite.reportLog("Entering the details of User/Group");
		sendKeys(driver, UserSearchTextbox, user_search);
		BaseSuite.reportLog("Searching Name.......");
		BaseSuite.reportLog("Entered Details ::::" + user_search);
		BaseSuite.validationReportLog("Entered Details ::::" + user_search);

		BaseSuite.reportLog("Click on search button");
		isDisplayedInLoop(driver, 30, UserSearchTextboxButton);
		javascript(driver, "arguments[0].click();", UserSearchTextboxButton);
		BaseSuite.reportLog("Clicked on the User/Group Search Textbox Button");
		BaseSuite.validationReportLog("User/Group searched successfully");

		Thread.sleep(2000);

		BaseSuite.reportLog("Clicking on the searched user/group check box");
		javascript(driver, "arguments[0].click();", UserCheckbox);
		BaseSuite.reportLog("User/Group checkbox is selected");

		BaseSuite.reportLog("Clicking on the remove button");
		javascript(driver, "arguments[0].click();", RemoveAddedUserBtn);
		BaseSuite.validationReportLog("Clicked on Removed button for the selected User/Group");
		BaseSuite.reportLog("Clicking on the remove button:::::::: Yes");
		javascript(driver, "arguments[0].click();", UserRemoveBtnClickYes);
		BaseSuite.reportLog("Clicked on removed button - Yes");
		Thread.sleep(3000);
		BaseSuite.reportLog("Deleted user/group from the workspace is " + user_search);
		BaseSuite.validationReportLog("Role Revocation Successfully!!!");

		System.out.println("Deleted user/group from the workspace is " + user_search);

	}

	public void updateExistingWorkspace(String workspaceName, String workspaceUpdate) throws Exception {
		workspaceSearchFromListOfWorkspaces(workspaceName);
		isDisplayed(driver, WorkspaceName);
		click(driver, WorkspaceName);
		BaseSuite.reportLog("Clicked on the Workspace Name");
		BaseSuite.reportLog("Updating the Workspace Name");
		sendKeys(driver, WorkspaceName, workspaceUpdate);
		BaseSuite.validationReportLog("Entered the workspace name with details :::::" + workspaceUpdate);

		BaseSuite.reportLog("Clicked on the Workspace Description");
		BaseSuite.reportLog("Updating the Workspace Description");
		sendKeys(driver, WorkspaceDescription, workspaceUpdate);
		BaseSuite.validationReportLog("Entered the workspace description with details :::::" + workspaceUpdate);

		waitForElement(driver, WorkspaceSaveBtn);
		BaseSuite.reportLog("Clicking the workspace save button...");
		click(driver, WorkspaceSaveBtn);
		Thread.sleep(3000);

		BaseSuite.reportLog("Workspace saved successfully");
		BaseSuite.validationReportLog(workspaceName + " Workspace updated");

		BaseSuite.reportLog("Searching for the workspace after updating the workspace");
		workspaceSearchFromListOfWorkspaces(workspaceName + workspaceUpdate);
		BaseSuite.reportLog("Existing workspace updated successfully!!");
		BaseSuite.validationReportLog("Updated workspace name is :::::" + workspaceName + workspaceUpdate);

	}

	public void validateDuplicateWorkspaceCreation(String account, String workspaceName, String workspaceDesc,
			String type) throws InterruptedException {

		BaseSuite.reportLog("Checking the New Workspace button");
		isDisplayedInLoop(driver, 30, NewWorkspaceBtn);
		javascript(driver, "arguments[0].click();", NewWorkspaceBtn);
		BaseSuite.validationReportLog("Clicked on the New Workspace button");

		BaseSuite.reportLog("Selecting the Account:::: " + account);
		isDisplayedInLoop(driver, 30, AccountDropdown);
		click(driver, AccountDropdown);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Select Account']")).sendKeys(account);
		Thread.sleep(2000);

		BaseSuite.reportLog("Entering the Workspace Name:::: " + workspaceName);
		isDisplayed(driver, WorkspaceName);
		sendKeys(driver, WorkspaceName, workspaceName);
		BaseSuite.validationReportLog("Entered Workspace Name :::::::" + workspaceName);

		BaseSuite.reportLog("Entering the Workspace Description:::: " + workspaceDesc);
		isDisplayed(driver, WorkspaceDescription);
		sendKeys(driver, WorkspaceDescription, workspaceDesc);
		BaseSuite.validationReportLog("Entered Workspace Description :::::::" + workspaceDesc);

		BaseSuite.reportLog("Selecting the Workspace type:::: " + type);
		isDisplayed(driver, Workspacetype);

		click(driver, Workspacetype);
		click(driver, Workspacetype);

		Thread.sleep(3000);

		BaseSuite.reportLog("Verifying Save button");

		isDisplayed(driver, WorkspaceSaveBtn);

		BaseSuite.validationReportLog("Save Workspace button is enabled");
		isDisplayedInLoop(driver, 30, WorkspaceSaveBtn);

		waitForElement(driver, WorkspaceSaveBtn);
		BaseSuite.reportLog("Clicking the workspace save button...");
		click(driver, WorkspaceSaveBtn);
		waitForElement(driver, duplicateWorkspaceValidationMsg);
		BaseSuite.validationReportLog("Clicked on the Save button");
		try {
			captureToastMsg(driver, duplicateWorkspaceValidationMsg, toastMsgClosedBtn, duplicateWorkspaceValidationText,
					"Workspace name already exist");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		Thread.sleep(3000);

	}

	// Neha's code

	// NG21-702-Verify New Workspace Button button should be enabled and Delete
	// Workspace button should be disabled on the Workspace listing page.

	public void Verify_Buttons_Visiblity_WKSLandingpage(SoftAssert softAssert) {
		isDisplayedInLoop(driver, 30, WorkspaceSideBar);
		click(driver, WorkspaceSideBar);
		BaseSuite.reportLog(" Clicked on the workspace menu!");

		// check visibility of new account
		BaseSuite.reportLog("Verifying New workspace Button in the workspace page");
		boolean New_Wks_btn = isEnabled(driver, Wks_NewWorkspacebtn);
		if (New_Wks_btn) {
			assertTrue(New_Wks_btn);
			BaseSuite.validationReportLog("New workspace creation button is enabled");
		} else {
			assertTrue(New_Wks_btn);
			BaseSuite.reportFailLog("New workspace creation button is disabled",
					"Verify_Buttons_Visiblity_WKSLandingpage");
		}
		// check visibility of Refresh Button
		BaseSuite.reportLog("Verifying Refresh Button in the workspace page");
		boolean Wks_refresh_Btn = isEnabled(driver, Wks_Refeshbtn);

		if (Wks_refresh_Btn) {
			BaseSuite.validationReportLog("Refresh button is enabled");

		} else {

			BaseSuite.reportFailLog("Refresh button is disabled", "Verify_Buttons_Visiblity_WKSLandingpage");
		}

		boolean Wks_delete_btn = isEnabled(driver, Wks_Deletebtn);
		BaseSuite.reportLog("Verifying delete button in the workspace page");

		if (Wks_delete_btn) {

			assertTrue(Wks_delete_btn);
			BaseSuite.validationReportLog("Delete workspace button is disabled by default");

		} else {

			BaseSuite.reportFailLog("Delete workspace button is enabled", "Verify_Buttons_Visiblity_WKSLandingpage");
		}

	}

	// NG21-690 Verify admin can refresh workspace listing
	public void refresh_Workspace_Tab_Listing(SoftAssert soft) throws InterruptedException {
		int totalUncheckedWks, totalCheckedWks;
		String NoWksBefore, NoWksAfter, message;
		String[] stritems;

		Groups grpObj = new Groups(driver);

		isDisplayedInLoop(driver, 30, WorkspaceSideBar);
		click(driver, WorkspaceSideBar);
		BaseSuite.reportLog("Workspace menu option displayed & clicked.");

		isDisplayedInLoop(driver, 30, RefreshWorkspaceBtn);
		boolean flagR = isEnabled(driver, RefreshWorkspaceBtn);

		isDisplayedInLoop(driver, 30, WksSelectAll_wkschk);
		click(driver, WksSelectAll_wkschk);

		WebElement label = driver.findElement(By.xpath("//span[@class='e-pagecountmsg']"));
		message = label.getText();
		log.info(message);
		// getText(driver, GlabelTotalusers);
		stritems = message.substring(1).split(" ");
		BaseSuite.validationReportLog("Total workspaces available before refresh :: " + stritems[0]);

		totalCheckedWks = grpObj.getCheckboxSelectionCount(driver, Wks_Checkbox);
		Thread.sleep(2000);
		BaseSuite.validationReportLog("Total workspace checkboxes checked before refresh :: " + totalCheckedWks);
		System.out.println("Total check boxes checked :: " + totalCheckedWks);

		if (flagR) {
			assertTrue(flagR);
			click(driver, RefreshWorkspaceBtn);
			BaseSuite.validationReportLog("Clicked on refresh button.");
			// boolean flagS= ;

			/*
			 * if(isDisplayed(driver, Spinner)) {
			 * BaseSuite.validationReportLog("Spinner is displayed.");
			 * 
			 * } else { BaseSuite.reportLog("Spinner is not displayed"); }
			 */

			message = label.getText();
			log.info(message);
			// getText(driver, GlabelTotalusers);
			stritems = message.substring(1).split(" ");
			BaseSuite.validationReportLog("Total workspaces available after refresh :: " + stritems[0]);
			Thread.sleep(3000);
			totalUncheckedWks = grpObj.getCheckboxUnSelectionCount(driver, Wks_Checkbox);
			Thread.sleep(1000);
			BaseSuite
					.validationReportLog("Total workspaces checkboxes unchecked after refresh :: " + totalUncheckedWks);
			System.out.println("Total check boxes unchecked :: " + totalUncheckedWks);

		} else {
			assertTrue(flagR);
			BaseSuite.reportFailLog("Refresh button is disabled by default", "refresh_Workspace_Tab_Listing");
		}

	}

//=================== AK Updated Code ===========================

	public void searchWorkspace(String Workspace_search) throws Exception {

		BaseSuite.validationReportLog("Searching for Workspace: " + Workspace_search);
		isDisplayedInLoop(driver, 30, WorkSearchTextbox);
		javascript(driver, "arguments[0].click();", WorkSearchTextbox);
		clear(driver, WorkSearchTextbox);

		isDisplayedInLoop(driver, 30, WorkSearchTextbox);
		BaseSuite.reportLog("Search Name");
		sendKeys(driver, WorkSearchTextbox, Workspace_search);
		BaseSuite.reportLog("Click On searched");

		isDisplayedInLoop(driver, 30, WorkSearchTextboxButton);
		//javascript(driver, "arguments[0].click();", WorkSearchTextboxButton);
		displayAndClick(driver, WorkSearchTextboxButton);
		BaseSuite.validationReportLog("Searched workspace displayed successfully and name is :" + Workspace_search);

	}

	public void searchWorkspaceAndClick(String Workspace_search) throws Exception {
		try {
		BaseSuite.validationReportLog("Searching for workspace: " + Workspace_search);
		isDisplayedInLoop(driver, 30, WorkSearchTextbox);
		javascript(driver, "arguments[0].click();", WorkSearchTextbox);
		clear(driver, WorkSearchTextbox);

		isDisplayedInLoop(driver, 30, WorkSearchTextbox);
		BaseSuite.reportLog("Search Name");
		sendKeys(driver, WorkSearchTextbox, Workspace_search);
		BaseSuite.reportLog("Clicked on search");
		Thread.sleep(2000);
		isDisplayedInLoop(driver, 30, WorkSearchTextboxButton);
		displayAndClick(driver, WorkSearchTextboxButton);

		

			isDisplayedInLoop(driver, 30, WorkSearchTextboxButton);

			BaseSuite.reportLog("Clicking on Searched workspace");
			displayAndClick(driver, returnElement(WorkSearchList, "$User", Workspace_search));
			BaseSuite.validationReportLog("Clicked on workspace: " + Workspace_search);
			waitForElement(driver, toastMsgClosedBtn);
			captureToastMsg(driver, workspaceRetrivedMsg, toastMsgClosedBtn, workDetailMsg, "Workspace detail retrieved");

			BaseSuite.validationReportLog("Workspace Details retrieved successfully for workspace " + Workspace_search);

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void searchUserGroupAssignInAccount(String UserGroup_search) throws Exception {

		BaseSuite.reportLog("Searching for user/group/workspace: " + UserGroup_search);
		isDisplayedInLoop(driver, 30, UG_SearchBar);
		javascript(driver, "arguments[0].click();", UG_SearchBar);
		clear(driver, UG_SearchBar);

		isDisplayedInLoop(driver, 30, UG_SearchBar);
		BaseSuite.reportLog("Search Name");
		sendKeys(driver, UG_SearchBar, UserGroup_search);
		BaseSuite.reportLog("Click on searched");

		isDisplayedInLoop(driver, 30, UG_SearchClick);
		javascript(driver, "arguments[0].click();", UG_SearchClick);
	}

	public void searchWorkspaceAssignInAccount(String Workspace_search) throws Exception {

		BaseSuite.reportLog("Searching for user/group/workspace: " + Workspace_search);
		isDisplayedInLoop(driver, 30, WS_SearchBar);
		javascript(driver, "arguments[0].click();", WS_SearchBar);
		clear(driver, WS_SearchBar);

		isDisplayedInLoop(driver, 30, WS_SearchBar);
		BaseSuite.reportLog("Search Name");
		sendKeys(driver, WS_SearchBar, Workspace_search);
		BaseSuite.reportLog("Click on searched");

		isDisplayedInLoop(driver, 30, WS_SearchClick);
		javascript(driver, "arguments[0].click();", WS_SearchClick);
	}

	public void discardDetailsInExistingWorkspace(String DiscardworkspaceName, String Description,
			String DiscardalertYes, String Workspace_search) throws Exception {
		clickOnWorkspaceMenu();

		try {

			BaseSuite.reportLog("Searching the existing workspace using search bar");
			searchWorkspaceAndClick(Workspace_search);
			Thread.sleep(3000);
			waitForElement(driver,toastMsgClosedBtn);

			captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, RetriveDetailsMsg, "Details retrive");
			BaseSuite.validationReportLog("existing workspace page is opened");

			BaseSuite.reportLog(":::Entering the details of the worksapce:::");
			boolean flag = isEnabled(driver, existingAccoutName);
			if (flag) {
				BaseSuite.validationReportLog("Select account field is disabled as per the existing functionality");
			} else {
				BaseSuite.reportFailLog("Select account field is enabled so bug occured",
						"discardDetailsInExistingWorkspace");
			}
			if (isEditable(driver, newWorkspaceName, "DiscardworkspaceName")) {
				Thread.sleep(2000);
				clear(driver, newWorkspaceName);
				clear_Click_SendKeys(driver, 20, newWorkspaceName, DiscardworkspaceName);
				BaseSuite.validationReportLog("Entered worspace name: " + DiscardworkspaceName);
				waitForElement(driver, workspaceDescdetails);
				clear(driver, workspaceDescdetails);
				clear_Click_SendKeys(driver, 20, workspaceDescdetails, Description);
				BaseSuite.validationReportLog("Entered workspace Description: " + Description);

				if (isEnabled(driver, DiscardButton)) {
					BaseSuite.reportLog("Clicking on the discard button");
					waitForElement(driver, DiscardButton);

					isDisplayedInLoop(driver, 30, DiscardButton);
					javascript(driver, "arguments[0].click();", DiscardButton);
					// displayAndClick(DiscardButton);

					String discardmsg = getText(driver, DiscardMsg);
					BaseSuite.validationReportLog("Alert message displaying successfully:" + discardmsg);
					if (DiscardalertYes.contains("Yes")) {
						BaseSuite.validationReportLog("Discarding workspace details with option 'Yes' ");
						isDisplayedInLoop(driver, 30, DiscardAlertYes);
						// javascript(driver, "arguments[0].click();", DiscardAlertYes);
						click(driver, DiscardAlertYes);

					} else {
						BaseSuite.validationReportLog("User not discarding existing workspace details with option 'No");
						javascript(driver, "arguments[0].click();", DiscardAlertNo);
					}

					BaseSuite.validationReportLog("Existing workspace details discarded successfully");
				} else {
					BaseSuite.reportFailLog("Discard button not enabled", "discardDetailsInExistingAccount");
				}
			}
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void discardDetailsInNewWorkspace(String DiscardworkspaceName, String Description, String DiscardalertYes,
			String ExistingAccount) throws Exception {

		clickOnWorkspaceMenu();

		try {
			clickOnNewWorkspaceButton();

			BaseSuite.reportLog(":::Entering the details in the workspace:::");
			if (isEditable(driver, newWorkspaceName, "DiscardworkspaceName")) {

				BaseSuite.reportLog("Selecting the Account:::: " + ExistingAccount);
				isDisplayedInLoop(driver, 30, AccountDropdown);
				click(driver, AccountDropdown);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@placeholder='Select Account']")).sendKeys(ExistingAccount);

				isDisplayedInLoop(driver, 20, newWorkspaceName);
				clear_Click_SendKeys(driver, 30, newWorkspaceName, DiscardworkspaceName);
				BaseSuite.validationReportLog("Entered Users account name: " + DiscardworkspaceName);

				clear_Click_SendKeys(driver, 30, workspaceDescdetails, Description);
				BaseSuite.reportLog("Entered account Description: " + Description);
				waitForElement(driver, WorkspaceSaveBtn);
				if (isEnabled(driver, WorkspaceSaveBtn)) {
					BaseSuite.validationReportLog("To create new account save button is enabled");
					if (isEnabled(driver, DiscardButton)) {
						isDisplayedInLoop(driver, 30, DiscardButton);
						BaseSuite.reportLog("Clicking on the discard button");
						click(driver, DiscardButton);

						String discardmsg = getText(driver, DiscardMsg);
						BaseSuite.validationReportLog("Alert message displaying successfully:" + discardmsg);
						if (DiscardalertYes.contains("Yes")) {
							BaseSuite.validationReportLog("Discarding workspace details with option 'Yes' ");
							waitForElement(driver, DiscardAlertYes);
							isDisplayedInLoop(driver, 30, DiscardAlertYes);
							click(driver, DiscardAlertYes);

						} else {
							BaseSuite.validationReportLog(
									"Not able to discard existing workspace details with option 'No");
							waitForElement(driver, DiscardAlertNo);
							javascript(driver, "arguments[0].click();", DiscardAlertNo);
						}

						BaseSuite.validationReportLog("New workspace details discarded successfully");
					} else {
						BaseSuite.reportFailLog("Discard button not enabled", "discardDetailsInNewWorkspace");
					}
				} else {
					BaseSuite.reportFailLog("Save button is not enabled", "discardDetailsInNewWorkspace");
				}
			}
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void saveButtonEnabledOrNot(String DiscardworkspaceName, String Description, String ExistingAccount)
			throws Exception {
		clickOnWorkspaceMenu();
		try {

			clickOnNewWorkspaceButton();
			BaseSuite.reportLog(":::Entering the details in the Workspace:::");

			BaseSuite.reportLog(":::Entering the details in the workspace:::");
			if (isEditable(driver, newWorkspaceName, "DiscardworkspaceName")) {

				BaseSuite.reportLog("Selecting the Account:::: " + ExistingAccount);
				isDisplayedInLoop(driver, 30, AccountDropdown);
				click(driver, AccountDropdown);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@placeholder='Select Account']")).sendKeys(ExistingAccount);
				Thread.sleep(2000);
				BaseSuite.validationReportLog("Selected existing account name is: " + ExistingAccount);
				BaseSuite.reportLog("Entering the Workspace Name:::: " + DiscardworkspaceName);
				isDisplayedInLoop(driver, 30, newWorkspaceName);
				clear_Click_SendKeys(driver, 30, newWorkspaceName, DiscardworkspaceName);
				BaseSuite.validationReportLog("Entered Users account name: " + DiscardworkspaceName);

				BaseSuite.reportLog("Entering the Workspace Description:::: " + Description);
				isDisplayedInLoop(driver, 20, workspaceDescdetails);
				clear_Click_SendKeys(driver, 30, workspaceDescdetails, Description);

				BaseSuite.validationReportLog("Entered account Description: " + Description);
				waitForElement(driver, WorkspaceSaveBtn);

				BaseSuite.reportLog("Selecting the Workspace type:::: ");
				isDisplayed(driver, Workspacetype);
				/*
				 * Thread.sleep(2000); Select type = new
				 * Select(driver.findElement(By.name("ddlelement")));
				 * type.selectByVisibleText("Shared");
				 */

				click(driver, Workspacetype);

				// driver.findElement(Workspacetype).sendKeys(Keys.ARROW_DOWN);

				// driver.findElement(Workspacetype).sendKeys(Keys.ENTER);

				BaseSuite.reportLog("Checking for save button is enabled or not after entering all the details");
				boolean flag = isEnabled(driver, WorkspaceSaveBtn);
				if (flag) {
					BaseSuite.validationReportLog("Save button is enabled and user can create new workspace");

				} else {
					BaseSuite.reportFailLog("Save button is disabled after entering all the details: Test case failed",
							"enableSaveButtonOrNot");
				}

			} else {
				BaseSuite.reportFailLog("New workspace fields are not editable.", "enableSaveButtonOrNot");
			}
			driver.navigate().refresh();
			Thread.sleep(2000);
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void createWorkspace(String DiscardworkspaceName, String Description, String ExistingAccount)
			throws Exception {
		clickOnWorkspaceMenu();
		try {

			clickOnNewWorkspaceButton();

			BaseSuite.reportLog(":::Entering the details in the workspace:::");
			if (isEditable(driver, newWorkspaceName, "WorkspaceName")) {

				BaseSuite.reportLog("Selecting the Account:::: " + ExistingAccount);
				Thread.sleep(2000);
				isDisplayedInLoop(driver, 50, AccountDropdown);
				click(driver, AccountDropdown);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@placeholder='Select Account']")).sendKeys(ExistingAccount);

				BaseSuite.validationReportLog("Selected existing account name is: " + ExistingAccount);
				BaseSuite.reportLog("Entering the Workspace Name:::: " + DiscardworkspaceName);
				isDisplayedInLoop(driver, 30, newWorkspaceName);
				clear_Click_SendKeys(driver, 30, newWorkspaceName, DiscardworkspaceName);
				BaseSuite.validationReportLog("Entered Users account name: " + DiscardworkspaceName);

				BaseSuite.reportLog("Entering the Workspace Description:::: " + Description);
				isDisplayedInLoop(driver, 20, workspaceDescdetails);
				clear_Click_SendKeys(driver, 30, workspaceDescdetails, Description);

				BaseSuite.validationReportLog("Entered account Description: " + Description);
				waitForElement(driver, WorkspaceSaveBtn);

				BaseSuite.reportLog("Selecting the Workspace type:::: ");
				isDisplayed(driver, Workspacetype);
				/*
				 * Thread.sleep(2000); Select type = new
				 * Select(driver.findElement(By.name("ddlelement")));
				 * type.selectByVisibleText("Shared");
				 */

				click(driver, Workspacetype);
				click(driver, Workspacetype);
				// driver.findElement(Workspacetype).sendKeys(Keys.ARROW_DOWN);

				// driver.findElement(Workspacetype).sendKeys(Keys.ENTER);

				BaseSuite.reportLog("Checking for save button is enabled or not after entering all the details");
				boolean flag = isEnabled(driver, WorkspaceSaveBtn);
				if (flag) {
					BaseSuite.validationReportLog("Save button is enabled and user can create new workspace");

					isDisplayedInLoop(driver, 30, WorkspaceSaveBtn);
					BaseSuite.reportLog("Clicking on the Save button..");
					javascript(driver, "arguments[0].click();", WorkspaceSaveBtn);
					Thread.sleep(2000);
					String msg = getText(driver, commonToastMsg);
					BaseSuite.reportLog("Verifying save message for new workspace");
					if (msg.contains(workspaceCreateText)) {
						captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, workspaceCreateText,
								"Workspace Created");
						BaseSuite.validationReportLog(
								"Toast message maches so it is confirmed that new workspace created successfully");

					} else {
						BaseSuite.reportFailLog(
								"Captured toast message is not matching with the save workspace toast message",
								"createWorkspace");
					}

				} else {
					BaseSuite.reportFailLog("Save button is disabled after entering all the details: Test case failed",
							"enableSaveButtonOrNot");
				}

			} else {
				BaseSuite.reportFailLog("New workspace fields are not editable.", "enableSaveButtonOrNot");
			}
			driver.navigate().refresh();
			Thread.sleep(2000);
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void newWorkspaceDisplayInList(String DiscardworkspaceName) throws Exception {
		clickOnWorkspaceMenu();
		try {
			Thread.sleep(2000);
			BaseSuite.reportLog("Searching for newly created workspace");
			searchWorkspace(DiscardworkspaceName);
			isDisplayedInLoop(driver, 30, WorkSearchList1);
			String NewWorkspace = getText(driver, WorkSearchList1);
			BaseSuite.validationReportLog(
					"Created workspace found in the list and the name of created workspace is : " + NewWorkspace);
			if (getText(driver, WorkSearchList1).contains(NewWorkspace)) {
				BaseSuite.validationReportLog(
						"New workspace listed in the workspace list so it is confirmed that workspace created successfully and workspace name is :"
								+ NewWorkspace);
			} else {
				BaseSuite.reportFailLog("New workspace not listed in the workspace list", "newWorkspaceDisplayInList");
			}
			isDisplayedInLoop(driver, 30, HomeLink);
			javascript(driver, "arguments[0].click();", HomeLink);

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);

		}
	}

	public void updateDetailsInExistingWorkspace(String UpdatedWorkspaceName, String UpdatedDescription,
			String SearchWorkspaceForUpdate) throws Exception {
		clickOnWorkspaceMenu();

		try {
			Thread.sleep(2000);
			BaseSuite.reportLog("Searching for existing workspace to update new details");
			searchWorkspaceAndClick(SearchWorkspaceForUpdate);
			waitForElement(driver,toastMsgClosedBtn);
			captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, RetriveDetailsMsg, "Details retrive");
			BaseSuite.validationReportLog("existing workspace page is opened");

			BaseSuite.reportLog(":::Entering the details of the worksapce:::");
			boolean flag = isEnabled(driver, existingAccoutName);
			if (flag) {
				BaseSuite.validationReportLog(
						"Select account field is disabled as per the existing functionality so user not able to update account name");
			} else {
				BaseSuite.reportFailLog("Select account field is enabled so bug occured",
						"discardDetailsInExistingWorkspace");
			}
			BaseSuite.reportLog(":::Entering the details in the workspace:::");
			if (isEditable(driver, newWorkspaceName, "UpdatedWorkspaceName")) {
				Date d = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("M.d.yyyy_hhmm");
				BaseSuite.reportLog("Entering the Workspace Name:::: " + UpdatedWorkspaceName + sdf.format(d));
				isDisplayedInLoop(driver, 20, newWorkspaceName);
						
				clear_Click_SendKeys(driver, 30, newWorkspaceName, UpdatedWorkspaceName + sdf.format(d));
				BaseSuite.validationReportLog("Entered Users account name: " + UpdatedWorkspaceName + sdf.format(d));

				BaseSuite.reportLog("Entering the Workspace Description:::: " + UpdatedDescription);
				isDisplayedInLoop(driver, 20, workspaceDescdetails);
				clear_Click_SendKeys(driver, 30, workspaceDescdetails, UpdatedDescription);

				BaseSuite.validationReportLog("Entered account Description: " + UpdatedDescription);

				BaseSuite.reportLog("Selecting the Workspace type:: ");
				isDisplayed(driver, Workspacetype);

				boolean type = isEnabled(driver, Workspacetype);
				if (type) {
					BaseSuite.validationReportLog(
							"Select type field is disabled as per the existing functionality so user not able to update type");
				} else {
					BaseSuite.reportFailLog("Select type field is enabled so bug occured",
							"updateDetailsInExistingWorkspace");
				}
				isDisplayedInLoop(driver, 30, WorkspaceSaveBtn);
				BaseSuite.reportLog("Clicking on the Save button..");

				javascript(driver, "arguments[0].click();", WorkspaceSaveBtn);
				Thread.sleep(2000);
				String msg = getText(driver, commonToastMsg);
				BaseSuite.reportLog("Verifying save message for new workspace");
				if (msg.contains(workspaceCreateText)) {
					captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, workspaceCreateText,
							"Workspace Created");
					BaseSuite.validationReportLog(
							"Toast message maches so it is confirmed that workspace updated successfully");
					driver.navigate().refresh();
					waitForElement(driver,WorkspaceMenu);
				} else {
					BaseSuite.reportFailLog(
							"Captured toast message is not matching with the updated workspace toast message",
							"updateDetailsInExistingWorkspace");
				}

			} else {
				BaseSuite.reportFailLog("Existing workspace fields are not editable.",
						"updateDetailsInExistingWorkspace");
			}
			clickOnWorkspaceMenu();
			Thread.sleep(2000);
			BaseSuite.reportLog("Searching for updated workspace");
			searchWorkspace(UpdatedWorkspaceName);
			String UpdatedWorkspace = getText(driver, WorkSearchList1);
			BaseSuite.validationReportLog("updated workspace found in the list and the name of updated workspace is : " + UpdatedWorkspace);
			if (getText(driver, WorkSearchList1).contains(UpdatedWorkspace)) {
				BaseSuite.validationReportLog(
						"Updated workspace listed in the workspace list so it is confirmed that workspace updated successfully and workspace name is :"
								+ UpdatedWorkspace);
			} else {
				BaseSuite.reportFailLog("Updated workspace not listed in the workspace list",
						"updateDetailsInExistingWorkspace");
			}
			isDisplayedInLoop(driver, 30, HomeLink);
			javascript(driver, "arguments[0].click();", HomeLink);
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void roleAssignWindowWithoutRoleSelectionInWorkspace(String Workspace_search, String AssignUserInWorkspace)
			throws Exception {
		clickOnWorkspaceMenu();
		try {
			Thread.sleep(2000);
			BaseSuite.reportLog("Searching the existing workspace using search bar");
			searchWorkspaceAndClick(Workspace_search);
			waitForElement(driver,toastMsgClosedBtn);
			captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, RetriveDetailsMsg, "Details retrive");
			BaseSuite.validationReportLog("existing workspace page is opened");
			isDisplayedInLoop(driver, 30, Labelusergroup);
			BaseSuite.reportLog("Clicking on userGroup label");
			click(driver, Labelusergroup);

			if (isEnabled(driver, addBtn)) {
				BaseSuite.reportLog("Clicking on add button..");
				click(driver, addBtn);
				isDisplayedInLoop(driver, 20, assignRoleLabel);
				String windowname = getText(driver, assignRoleLabel);
				if (windowname.contains("Role Assignment")) {
					BaseSuite.validationReportLog(
							"Role assign window opened successfully and name of window is :" + windowname);

					BaseSuite.reportLog("Role assign pannel displaying..");
					String dropdownLables = "Role / Assign access to / Select ";
					if ((isDisplayed(driver, roleDropLabel)) && (isDisplayed(driver, accessDropLabel))
							&& (isDisplayed(driver, selectDropLabel))) {
						BaseSuite.validationReportLog(
								"On role assign window all the 3 dropdown fields displaying successfully : "
										+ dropdownLables);
					}
					String rolename = getText(driver, blankrole);
					if (rolename.isEmpty()) {
						isDisplayedInLoop(driver, 30, accessDropLabel);
						BaseSuite.validationReportLog("User assign access by default selected");
						isDisplayedInLoop(driver, 30, selectDropLabel);
						isDisplayedInLoop(driver, 20, userTextBox);
						clear_Click_SendKeys(driver, 30, userTextBox, AssignUserInWorkspace);
						// sendKeys(driver, addUserTextBox, AssignUserName);
						Thread.sleep(3000);
						BaseSuite.reportLog("Selecting user name to assign");
						driver.findElement(userTextBox).sendKeys(Keys.ENTER);
						isDisplayedInLoop(driver, 30, assignBtnLabel);
						BaseSuite.reportLog("Click on add button");
						javascript(driver, "arguments[0].click();", assignBtnLabel);
						// click(driver, assignBtnLabel);
						// Thread.sleep(2000);
						BaseSuite.reportLog("Validation message should be display for select role field ");
						waitForElement(driver, commonToastMsg);
						captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, validationToast,
								"Select role field");

						BaseSuite.validationReportLog(
								"Correct validation alert message getting displayed for select role field");

					} else {
						BaseSuite.reportFailLog(
								"User able to add the user without selection of role or role name selected by default",
								"roleAssignWindowWithoutRoleSelectionInWorkspace");
					}

				} else {
					BaseSuite.reportFailLog("Role assign window not getting opened",
							"roleAssignWindowWithoutRoleSelectionInWorkspace");
				}
			}

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void roleAssignWindowWithoutUserGroupSelectionInWorkspace(String Workspace_search,
			String AssignRoleInWorkspace) throws Exception {
		clickOnWorkspaceMenu();
		try {
			Thread.sleep(2000);
			BaseSuite.reportLog("Searching the existing workspace using search bar");
			searchWorkspaceAndClick(Workspace_search);			
			waitForElement(driver, commonToastMsg);
			captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, RetriveDetailsMsg, "Details retrive");
			BaseSuite.validationReportLog("existing workspace page is opened");
			isDisplayedInLoop(driver, 30, Labelusergroup);
			BaseSuite.reportLog("Clicking on userGroup label");
			click(driver, Labelusergroup);

			if (isEnabled(driver, addBtn)) {
				BaseSuite.reportLog("Clicking on add button..");
				click(driver, addBtn);
				isDisplayedInLoop(driver, 20, assignRoleLabel);
				String windowname = getText(driver, assignRoleLabel);
				if (windowname.contains("Role Assignment")) {
					BaseSuite.validationReportLog(
							"Role assign window opened successfully and name of window is :" + windowname);

					BaseSuite.reportLog("Role assign pannel displaying..");
					String dropdownLables = "Role / Assign access to / Select ";
					if ((isDisplayed(driver, roleDropLabel)) && (isDisplayed(driver, accessDropLabel))
							&& (isDisplayed(driver, selectDropLabel))) {
						BaseSuite.validationReportLog(
								"On role assign window all the 3 dropdown fields displaying successfully : "
										+ dropdownLables);
					}
					String usergroupname = getText(driver, userTextBox);
					if (usergroupname.isEmpty()) {
						isDisplayedInLoop(driver, 30, accessDropLabel);
						BaseSuite.validationReportLog("User assign access by default selected");
						isDisplayedInLoop(driver, 30, selectDropLabel);
						isDisplayedInLoop(driver, 20, roleTextbox);

						isDisplayedInLoop(driver, 20, roleTextbox);
						waitForElement(driver, roleTextbox);
						javascript(driver, "arguments[0].click();", roleTextbox);
						// click(driver,roleTextbox);
						BaseSuite.reportLog("Selecting role from role field");
						sendKeys(driver, roleTextbox, AssignRoleInWorkspace);
						BaseSuite.validationReportLog("User selected the role : " + AssignRoleInWorkspace);
						Thread.sleep(2000);
						isDisplayedInLoop(driver, 30, assignBtnLabel);
						BaseSuite.reportLog("Click on add button without user/group selection");
						javascript(driver, "arguments[0].click();", assignBtnLabel);
						// click(driver, assignBtnLabel);
						// Thread.sleep(2000);
						BaseSuite.reportLog("Validation message should be display for select user/group field ");
						waitForElement(driver, commonToastMsg);
						captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, UserGroupvalidationToast,
								"Select role field");

						BaseSuite.validationReportLog(
								"Correct validation alert message getting displayed for user/group role field");

					} else {
						BaseSuite.reportFailLog(
								"User able to add the user without selection of role or role name selected by default",
								"roleAssignWindowWithoutUserGroupSelectionInWorkspace");
					}

				} else {
					BaseSuite.reportFailLog("Role assign window not getting opened",
							"roleAssignWindowWithoutUserGroupSelectionInWorkspace");
				}
			}

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void workspaceSearchWithPagination(String PaginationPoint) throws Exception {
		clickOnWorkspaceMenu();
		try {
			Users pagination = new Users(driver);
			pagination.userSearchWithPagination(PaginationPoint);
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	//================Dhawal's code====================//
	
	 public void assigRoles(String role, String accessto) throws InterruptedException {
		 

			isDisplayed(driver, User_GroupTab);
			javascript(driver, "arguments[0].click();", User_GroupTab);
			BaseSuite.validationReportLog("Clicked on the User/Group tab");

			isDisplayedInLoop(driver, 30, AddUser_GroupBtn);
			BaseSuite.reportLog("Clicking on the Add User/Group button ");
			click(driver, AddUser_GroupBtn);
			BaseSuite.validationReportLog("Clicked on the Add User/Group button");
			Thread.sleep(2000);
	        BaseSuite.reportLog("Checking the Role dropdown");
	        isDisplayedInLoop(driver, 30, RoleDropDown);
	        BaseSuite.reportLog("Entering the Role details");
	        sendKeys(driver, RoleDropDown, role);
	        Thread.sleep(2000);
	        BaseSuite.validationReportLog("Added Role is--" + role);

	        BaseSuite.reportLog("Checking the AccessTo");
	        isDisplayedInLoop(driver, 30, workspaceAccessTo);
	        click(driver, workspaceAccessTo);
	        Thread.sleep(2000);
	        BaseSuite.reportLog("Entering the AccessTo details");
	        sendKeys(driver, assignDropDown, accessto);
	        click(driver, workspaceAccessTo);
	        BaseSuite.reportLog("Clicked on Access Assign to");
	        BaseSuite.validationReportLog("Role Assign to --" + accessto);
	       
	 }
	 
		public void assignSingleUserGroup(String selectUserGroup) {

			try {
				BaseSuite.reportLog("Selecting the details of Group/User");
				isDisplayedInLoop(driver, 30, selectUserName);
				driver.findElement(selectUserName).sendKeys(selectUserGroup);
				Thread.sleep(2000);
				driver.findElement(selectUserName).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				BaseSuite.validationReportLog("Selected Group/User details is --" + selectUserGroup);
			} catch (Exception e) {
				e.getMessage();
				
			}

		}
	 
	 public void assignMultipleUserGroup(String colName)
	 {
		 try {
			int count = getcount(colName, ',');

				String[] result = colName.split(",");

				for (int colNum = 0; colNum <= count; colNum++) {

					String addUserGroup = result[colNum];

					String[] add = addUserGroup.split(":");

			    BaseSuite.reportLog("Selecting the details of Group/User");
			    isDisplayedInLoop(driver, 30, selectUserName);
			    driver.findElement(selectUserName).sendKeys(add);
			    Thread.sleep(2000);
			    driver.findElement(selectUserName).sendKeys(Keys.ENTER);
			    Thread.sleep(2000);
			    BaseSuite.validationReportLog("Selected Group/User details");
				}
		} catch (Exception e) {
			e.getMessage();
		}
		 
	 }
	 
		public void searchUserGroup(String userGroupSearchName) {

			BaseSuite.reportLog("Searching for User/Group:" + userGroupSearchName);
			isDisplayedInLoop(driver, 30, accountUserGroupSearchBar);

			javascript(driver, "arguments[0].click();", accountUserGroupSearchBar);
			clear(driver, accountUserGroupSearchBar);

			isDisplayedInLoop(driver, 30, accountUserGroupSearchBar);
			BaseSuite.reportLog("Entering search Name in search bar");
			sendKeys(driver, accountUserGroupSearchBar, userGroupSearchName);
			BaseSuite.reportLog("searched name entered successfuly");

			isDisplayedInLoop(driver, 30, accountUserGroupSearchClick);

			javascript(driver, "arguments[0].click();", accountUserGroupSearchClick);

			BaseSuite.validationReportLog("Clicked on the search for the User/Group");

		}
	 

		public void userGroupTab()
		{
			boolean add = isEnabled(driver, addUser_GroupBtn);
			if(add)
			{
				BaseSuite.validationReportLog("Add is displaying in the page");
				
			}
			else
			{
				BaseSuite.reportFailLog("Add is not displaying in the page","worspaceTab");
			}
			
			boolean refresh = isEnabled(driver, refreshAccountsBtn);
			if(refresh)
			{
				BaseSuite.validationReportLog("Refresh is displaying in the page");
				
			}
			else
			{
				BaseSuite.reportFailLog("Refresh is not displaying in the page","worspaceTab");
			}
			
			boolean remove = isDisplayed(driver, removeAddedUserBtn);
			
			if(remove)
			{
				BaseSuite.validationReportLog("Remove is not displaying in the page");
			}
			else
			{
				BaseSuite.reportFailLog("Remove is displaying in the page","worspaceTab");
			}
		}
	 
	 
	public void addRoleAssignButton() {
		BaseSuite.reportLog("Checking the Add role button");
		isDisplayedInLoop(driver, 30, addRoleBtn);
		BaseSuite.reportLog("Clicking on the Add role button");
		displayAndClick(driver, addRoleBtn);
		//inVisible(driver, spinner, Constant.ruleWait);
		try {
			captureToastMsg(driver, userGroupAddMess, toastMsgClosedBtn, userGroupAddText, "Role Assignment");
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}
	
	public void workspaceSearchFromList(String WorkspaceSearch) throws Exception {
		BaseSuite.reportLog("Searching for Workspace: " + WorkspaceSearch);
		isDisplayedInLoop(driver, 30, workspaceSearchBar);
		displayAndClick(driver, workspaceSearchBar);
		clear(driver, workspaceSearchBar);
		isDisplayedInLoop(driver, 30, workspaceSearchBar);
		BaseSuite.validationReportLog("Entering the workspace name to search the workspace");
		sendKeys(driver, workspaceSearchBar, WorkspaceSearch);
		isDisplayedInLoop(driver, 30, workspaceSearchClick);
		displayAndClick(driver, workspaceSearchClick);
		BaseSuite.reportLog("Clicked on the search for the Workspace button");
		isDisplayedInLoop(driver, 30, returnElement(WorkspaceSearchList, "$User", WorkspaceSearch));
		try {

			BaseSuite.validationReportLog("Clicking on Searched Workspace");
			//javascript(driver, "arguments[0].click();", returnElement(WorkspaceSearchList, "$User", WorkspaceSearch));
			displayAndClick(driver, returnElement(WorkspaceSearchList, "$User", WorkspaceSearch));
			BaseSuite.reportLog("Clicked on Workspace: " + WorkspaceSearch);
			
			//inVisible(driver, spinner, Constant.ruleWait);
			
			Thread.sleep(2000);
			
			captureToastMsg(driver, workspaceRetrivedMsg, toastMsgClosedBtn, workDetailMsg, "Workspace detail retrieved");

		} catch (Exception e) {
			throw new Exception("Workspace_search not found");
		}

	}
	
	public void workspaceInsideUserGroupPageGridDetails() {

		String userPageDetails = "Name/Type/Role/Scope";

		if ((isDisplayed(driver, headerTextName)) && (isDisplayed(driver, headerTextType))
				&& (isDisplayed(driver, headerTextRole)) && (isDisplayed(driver, headerTextScope))) {
			BaseSuite.reportLog("Checking Columns in the Grid details of Workspace Inside page!");
			BaseSuite.reportLog(userPageDetails + " labels are displayed properly in the Workspace Inside Page!");
			BaseSuite.validationReportLog("Columns Inside Workspace page are displaying properly!");

		} else {
			BaseSuite.reportFailLog(userPageDetails + " are not displaying in the page",
					"accountInsidePageGridDetails");
		}
		
		userGroupTab();
	}
	
	public void adminCanAddUserWithRolesInUserGroupOnWorkspaceSection(String WorkspaceSearch, String role,
			String accessto, String selectDetails,String userGroupSearchName)	 {
		 try {
			
			 clickOnWorkspaceMenu();
			 workspaceSearchFromList(WorkspaceSearch);
			 workspaceInsideUserGroupPageGridDetails();
			 assigRoles(role, accessto);
				assignMultipleUserGroup(selectDetails);
				addRoleAssignButton();
				
				  int count = getcount(userGroupSearchName, ';');

					String[] result = userGroupSearchName.split(";");

					for (int colNum = 0; colNum <= count; colNum++) {

						String addUserGroup = result[colNum];

						String[] add = addUserGroup.split(",");
						
						String name = add[0];

						String type = add[1];
						
						String roleVale = add[2];
						
						searchUserGroup(name);
						 
						String nameUserGroupValue = getText(driver, returnElement(userGroupName, "$User", name)).trim();

						if (nameUserGroupValue.equalsIgnoreCase(name.trim())) {
							BaseSuite.validationReportLog("User/Group Name in Workspace detailed page matched successfully : " + name);
						} else {
							BaseSuite.reportFailLog("User/Group Name in Workspace detailed page not matched", "adminCanAddUserWithRolesInUserGroupOnWorkspaceSection");

						}
						
						String typeUserGroupValue = getText(driver, returnElement(userGroupTypeRole, "$User", type)).trim();

						if (typeUserGroupValue.equalsIgnoreCase(type.trim())) {
							BaseSuite.validationReportLog("User/Group Type in Workspace detailed page matched successfully : " + type);
						} else {
							BaseSuite.reportFailLog("User/Group Type in Workspace detailed page not matched", "adminCanAddUserWithRolesInUserGroupOnWorkspaceSection");

						}
						
						String roleUserGroupValue = getText(driver,  returnElement(userGroupTypeRole, "$User", roleVale)).trim();

						if (roleUserGroupValue.equalsIgnoreCase(roleVale.trim())) {
							BaseSuite.validationReportLog("User/Group Role in Workspace detailed page matched successfully : " + roleVale);
						} else {
							BaseSuite.reportFailLog("User/Group Role in Workspace detailed page not matched", "adminCanAddUserWithRolesInUserGroupOnWorkspaceSection");

						}
						
					}

		} catch (Exception e) {
			e.getMessage();
		}
		 
	 }
	
	public void  adminCanRemoveRolesFromUserGroupOnWorkspaceSection(int rowNum,String workspaceSearch,String userGroupSearchName)
	{
		try {
			if(rowNum<=0)
			{
				
				clickOnWorkspaceMenu();
				 workspaceSearchFromList(workspaceSearch);
				workspaceInsideUserGroupPageGridDetails();
			}
			searchUserGroup(userGroupSearchName);
			BaseSuite.reportLog("Clicking on checkbox for removing User/Group");
			displayAndClick(driver, accountUserGroupSingleCheckbox);
			BaseSuite.reportLog("Checkbox clicked successfully for removing User/Group");
			BaseSuite.reportLog("Clicking on Remove buttton for removing User/Group");
			displayAndClick(driver, removeAddedUserBtn);
			BaseSuite.validationReportLog("Remove buttton clicked successfully for removing User/Group");
			visible(driver, removeDiscardYesButton, Constant.ruleWait);
			boolean flag = isDisplayed(driver, removeDiscardYesButton);
			if (flag) {
				BaseSuite.validationReportLog(
						"User/Group remove discard pop up is dispalyed in the page after clickog on Remove button");
				displayAndClick(driver, removeDiscardYesButton);
				BaseSuite.validationReportLog("User/Group remove conformation message accept successfully");
			} else {
				BaseSuite.reportFailLog(
						"User/Group remove discard pop up is not dispalyed in the page after clickog on Remove button",
						"adminCanRemoveRolesFromUserGroupOnWorkspaceSection");
			}

			//inVisible(driver, spinner, Constant.ruleWait);

			captureToastMsg(driver, userGroupRemoveMess, toastMsgClosedBtn, userGroupRemoveText, "Remove User/Group");
		} catch (Exception e) {
			e.getMessage();
		}

		
	}
	
	public void adminAssignMutipleRolesToUserGroupOnWorkspaceHighestPreceedingOneShouldBeDisplayed(int rowNum,String workspaceSearch,String role,String accessto,String selectUserGroup)
	{
		try {
			
			if(rowNum<=0)
			{
				
				clickOnWorkspaceMenu();
				 workspaceSearchFromList(workspaceSearch);
				workspaceInsideUserGroupPageGridDetails();
			}
			assigRoles(role, accessto);
			assignSingleUserGroup(selectUserGroup);
			addRoleAssignButton();
			
			searchUserGroup(selectUserGroup);
			
			BaseSuite.reportLog("Verifying mutiple roles to user/group on Workspace highest preceeding one should be displayed");
			
			String nameUserGroupValue = getText(driver, returnElement(userGroupName, "$User", selectUserGroup)).trim();
			if (nameUserGroupValue.equalsIgnoreCase(selectUserGroup.trim())) {
				BaseSuite.validationReportLog("User/Group Name in Workspace detailed page matched successfully : " + selectUserGroup);
			} else {
				BaseSuite.reportFailLog("User/Group Name in Workspace detailed page not matched", "adminAssignMutipleRolesToUserGroupOnWorkspaceHighestPreceedingOneShouldBeDisplayed");

			}
			
			String typeUserGroupValue = getText(driver, returnElement(userGroupTypeRole, "$User", accessto)).trim();

			if (typeUserGroupValue.equalsIgnoreCase(accessto.trim())) {
				BaseSuite.validationReportLog("User/Group Type in Workspace detailed page matched successfully : " + accessto);
			} else {
				BaseSuite.reportFailLog("User/Group Type in Workspace detailed page not matched", "adminAssignMutipleRolesToUserGroupOnWorkspaceHighestPreceedingOneShouldBeDisplayed");

			}
			
			String roleUserGroupValue = getText(driver,  returnElement(userGroupTypeRole, "$User", "Owner")).trim();

			if (roleUserGroupValue.equalsIgnoreCase("Owner")) {
				BaseSuite.validationReportLog("User/Group assign multiple Roles in Workspace detailed page showing preciding one : " + roleUserGroupValue);
			} else {
				BaseSuite.reportFailLog("User/Group assign multiple Roles in Workspace detailed page not showing preciding one", "adminAssignMutipleRolesToUserGroupOnWorkspaceHighestPreceedingOneShouldBeDisplayed");

			}
		} catch (Exception e) {
			e.getMessage();
		}
		
		
	}
	
	public void  sequenceOfRoleWhileRemovingMultipleRolesFromUserGroupOnWorkspace(int rowNum,String workspaceSearch,String userGroupSearchName,String role)
	{
		try {
			if (rowNum <= 0) {
				
				clickOnWorkspaceMenu();
				workspaceSearchFromList(workspaceSearch);
				workspaceInsideUserGroupPageGridDetails();
			}
			
			searchUserGroup(userGroupSearchName);
			
			String roleUserGroupValue = getText(driver,  returnElement(userGroupTypeRole, "$User", role)).trim();
			
			if(roleUserGroupValue.equalsIgnoreCase(role))
			{
				BaseSuite.validationReportLog("Verifying the Sequence of Role while removing multiple Roles from User/Group");
				
				BaseSuite.reportLog("Clicking on checkbox for removing User/Group");
				displayAndClick(driver, accountUserGroupSingleCheckbox);
				BaseSuite.reportLog("Checkbox clicked successfully for removing User/Group");
				BaseSuite.reportLog("Clicking on Remove buttton for removing User/Group");
				displayAndClick(driver, removeAddedUserBtn);
				BaseSuite.validationReportLog("Remove buttton clicked successfully for removing User/Group");
				visible(driver, removeDiscardYesButton, Constant.ruleWait);
				boolean flag = isDisplayed(driver, removeDiscardYesButton);
				if(flag)
				{
					BaseSuite.validationReportLog("User/Group remove discard pop up is dispalyed in the page after clickog on Remove button");
					displayAndClick(driver, removeDiscardYesButton);
					BaseSuite.validationReportLog("User/Group remove conformation message accept successfully");
				}
				else
				{
					BaseSuite.reportFailLog("User/Group remove discard pop up is not dispalyed in the page after clickog on Remove button","accountDetailsShouldBeDisplayedCorrectlyWhenUserIsRemovedFromAccount");
				}
				
				//inVisible(driver, spinner, Constant.ruleWait);
				
				captureToastMsg(driver, userGroupRemoveMess, toastMsgClosedBtn, userGroupRemoveText, "Remove User/Group");
				
				BaseSuite.validationReportLog("Sequence of Role while removing multiple Roles from User/Group is matched : "+ roleUserGroupValue);
			}
			else
			{
				BaseSuite.reportFailLog("Sequence of Role while removing multiple Roles from User/Group is not matched","sequenceOfRoleWhileRemovingMultipleRolesFromUserGroupOnAccount");
				
			}
		} catch (Exception e) {
			e.getMessage();
		
	}
	
}
	
	public void userDetailsShouldBeDisplayedCorrectlyAfterUserHasBeenRemovedFromWorkspace(String usersearch,String workspacesearch) {
		
		try {
			
			BaseSuite.validationReportLog("Revisiting in User Tab to check the removal of Account details");
			Users user = new Users(driver);
			user.clickOnUsersMenu();
			user.searchUser(usersearch);
			isDisplayedInLoop(driver, 20, userToolbarWorkspace);
			BaseSuite.reportLog("Clicking on account label");
			displayAndClick(driver, userToolbarWorkspace);
			inVisible(driver, spinner, Constant.ruleWait);
			BaseSuite.validationReportLog("Workspac tab clicked successfully");
			String WorkspaceLabelsColumns = "Name /Role /Type /Account /Scope";
			if ((isDisplayed(driver, workspaceNameLabel)) && (isDisplayed(driver, workspaceRoleLabel))
					&& (isDisplayed(driver, userWorkspaceTypeLabel)) && (isDisplayed(driver, workspaceAccountLabel))
					&& (isDisplayed(driver, workspaceScopeLabel))) {
				BaseSuite.validationReportLog(
						"In workspace section all the workspace labels name displaying successfully:"
								+ WorkspaceLabelsColumns);
			} else {
				BaseSuite.reportFailLog("Workspace labels are not available", "workspaceAssignDetails");
			}
			BaseSuite.reportLog("Searching for assigned Workspace");
			javascript(driver, "window.scrollTo(0, document.body.scrollHeight)");
			BaseSuite.reportLog("Searching for workspace/account/group: ");
			isDisplayedInLoop(driver, 30, userWorkspaceSearchbar);
			javascript(driver, "arguments[0].click();", userWorkspaceSearchbar);
			clear(driver, userWorkspaceSearchbar);

			isDisplayedInLoop(driver, 30, userWorkspaceSearchbar);
			BaseSuite.reportLog("Search Name");
			sendKeys(driver, userWorkspaceSearchbar, workspacesearch);
			BaseSuite.reportLog("Click on searched");

			isDisplayedInLoop(driver, 30, userWorkspaceSearchClick);
			javascript(driver, "arguments[0].click();", userWorkspaceSearchClick);
			boolean flag = isDisplayed(driver, userWorkspaceRecord); 
			if(flag)
			{
				BaseSuite.validationReportLog("Workspace removed successfully from User tab when it removing from Workspace tab");
				
			}
			else
			{
				BaseSuite.reportFailLog("Workspace is not removed successfully from User tab when it removing from Workspace tab","userDetailsShouldBeDisplayedCorrectlyAfterUserHasBeenRemovedFromWorkspace");
			}
			
			
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	
public void groupDetailsShouldBeDisplayedCorrectlyAfterRoleHasBeenRemovedFromWorkspace(String groupsearch,String workspacesearch) {
		
		try {
			
			BaseSuite.validationReportLog("Revisiting in Group Tab to check the removal of Account details");
			Groups grp = new Groups(driver);
			grp.clickOnGroupsMenu();
			grp.searchGroupAndClick(groupsearch);
			isDisplayedInLoop(driver, 20, userToolbarWorkspace);
			BaseSuite.reportLog("Clicking on account label");
			displayAndClick(driver, userToolbarWorkspace);
			inVisible(driver, spinner, Constant.ruleWait);
			BaseSuite.validationReportLog("Workspac tab clicked successfully");
			String WorkspaceLabelsColumns = "Name /Role /Type /Account /Scope";
			if ((isDisplayed(driver, workspaceNameLabel)) && (isDisplayed(driver, workspaceRoleLabel))
					&& (isDisplayed(driver, userWorkspaceTypeLabel)) && (isDisplayed(driver, workspaceAccountLabel))
					&& (isDisplayed(driver, workspaceScopeLabel))) {
				BaseSuite.validationReportLog(
						"In workspace section all the workspace labels name displaying successfully:"
								+ WorkspaceLabelsColumns);
			} else {
				BaseSuite.reportFailLog("Workspace labels are not available", "workspaceAssignDetails");
			}
			BaseSuite.reportLog("Searching for assigned Workspace");
			javascript(driver, "window.scrollTo(0, document.body.scrollHeight)");
			BaseSuite.reportLog("Searching for workspace/account/group: ");
			isDisplayedInLoop(driver, 30, groupWorkspaceSearchbar);
			javascript(driver, "arguments[0].click();", groupWorkspaceSearchbar);
			clear(driver, groupWorkspaceSearchbar);

			isDisplayedInLoop(driver, 30, groupWorkspaceSearchbar);
			BaseSuite.reportLog("Search Name");
			sendKeys(driver, groupWorkspaceSearchbar, workspacesearch);
			BaseSuite.reportLog("Click on searched");

			isDisplayedInLoop(driver, 30, groupWorkspaceSearchClick);
			javascript(driver, "arguments[0].click();", groupWorkspaceSearchClick);
			boolean flag = isDisplayed(driver, groupWorkspaceRecord); 
			if(flag)
			{
				BaseSuite.validationReportLog("Workspace removed successfully from Group tab when it removing from Workspace tab");
				
			}
			else
			{
				BaseSuite.reportFailLog("Workspace is not removed successfully from Group tab when it removing from Workspace tab","groupDetailsShouldBeDisplayedCorrectlyAfterRoleHasBeenRemovedFromWorkspace");
			}
			
			
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

	public void toastMessageReceivedWhenUserSelectWorkspace(String workspaceSearch)
	{
		try {
			
			clickOnWorkspaceMenu();
			BaseSuite.validationReportLog("Verifying the Workspace details retrieve message when click on Workspace name");
			workspaceSearchFromList(workspaceSearch);
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	public void allUIComponentsOfNewWorkspaceScreen()
	{
		try {
			BaseSuite.reportLog("Verify all UI components of new workspace screen");
			clickOnWorkspaceMenu();
			clickOnNewWorkspaceButton();
			BaseSuite.validationReportLog("All UI components of new workspace screen are verified");
			
		} catch (Exception e) {
			e.getMessage();
		}
	
	}
	
	public void UserDetailsShouldDisplayedCorrectlyAfterUserHasBeenAddedToWorkspace(String usersearch,String workspacesearch,String roleType)
	{

		try {
			
			BaseSuite.validationReportLog("Revisiting in User Tab to check the addition of Workspace details");
			Users user = new Users(driver);
			user.clickOnUsersMenu();
			user.searchUser(usersearch);
			isDisplayedInLoop(driver, 20, userToolbarWorkspace);
			BaseSuite.reportLog("Clicking on Workspace label");
			displayAndClick(driver, userToolbarWorkspace);
			inVisible(driver, spinner, Constant.ruleWait);
			BaseSuite.validationReportLog("Workspac tab clicked successfully");
			String WorkspaceLabelsColumns = "Name /Role /Type /Account /Scope";
			if ((isDisplayed(driver, workspaceNameLabel)) && (isDisplayed(driver, workspaceRoleLabel))
					&& (isDisplayed(driver, userWorkspaceTypeLabel)) && (isDisplayed(driver, workspaceAccountLabel))
					&& (isDisplayed(driver, workspaceScopeLabel))) {
				BaseSuite.validationReportLog(
						"In workspace section all the workspace labels name displaying successfully:"
								+ WorkspaceLabelsColumns);
			} else {
				BaseSuite.reportFailLog("Workspace labels are not available", "workspaceAssignDetails");
			}
			BaseSuite.reportLog("Searching for assigned Workspace");
			javascript(driver, "window.scrollTo(0, document.body.scrollHeight)");
			BaseSuite.reportLog("Searching for workspace/account/group: ");
			isDisplayedInLoop(driver, 30, userWorkspaceSearchbar);
			javascript(driver, "arguments[0].click();", userWorkspaceSearchbar);
			clear(driver, userWorkspaceSearchbar);

			isDisplayedInLoop(driver, 30, userWorkspaceSearchbar);
			BaseSuite.reportLog("Search Name");
			sendKeys(driver, userWorkspaceSearchbar, workspacesearch);
			BaseSuite.reportLog("Click on searched");

			isDisplayedInLoop(driver, 30, userWorkspaceSearchClick);
			javascript(driver, "arguments[0].click();", userWorkspaceSearchClick);
			
			BaseSuite.reportLog("Verifying Workspace datials after User has been added to Workspace");
			
			String nameUserGroupValue = getText(driver, returnElement(userGroupName, "$User", workspacesearch)).trim();
			if (nameUserGroupValue.equalsIgnoreCase(workspacesearch.trim())) {
				BaseSuite.validationReportLog("Workspace Name detailed in User page matched successfully : " + workspacesearch);
			} else {
				BaseSuite.reportFailLog("Workspace Name detailed in User page not matched", "UserDetailsShouldDisplayedCorrectlyAfterUserHasBeenAddedToWorkspace");

			}
			
			
			String roleUserGroupValue = getText(driver,  returnElement(userGroupTypeRole, "$User", roleType)).trim();

			if (roleUserGroupValue.equalsIgnoreCase(roleType.trim())) {
				BaseSuite.validationReportLog("Workspace Role detailed in User page matched successfully : " + roleType);
			} else {
				BaseSuite.reportFailLog("Workspace Role detailed in User page not matched", "UserDetailsShouldDisplayedCorrectlyAfterUserHasBeenAddedToWorkspace");

			}
	}catch (Exception e) {
		e.getMessage();
	}

	}
	
	public void groupDetailsShouldDisplayedCorrectlyAfterGroupHasBeenAddedToWorkspace(String groupsearch,String workspacesearch,String roleType)
	{

		try {
			
			BaseSuite.validationReportLog("Revisiting in Group Tab to check the addition of Workspace details");
			Groups grp = new Groups(driver);
			grp.clickOnGroupsMenu();
			grp.searchGroupAndClick(groupsearch);
			isDisplayedInLoop(driver, 20, userToolbarWorkspace);
			BaseSuite.reportLog("Clicking on Workspace label");
			displayAndClick(driver, userToolbarWorkspace);
			inVisible(driver, spinner, Constant.ruleWait);
			BaseSuite.validationReportLog("Workspac tab clicked successfully");
			String WorkspaceLabelsColumns = "Name /Role /Type /Account /Scope";
			if ((isDisplayed(driver, workspaceNameLabel)) && (isDisplayed(driver, workspaceRoleLabel))
					&& (isDisplayed(driver, userWorkspaceTypeLabel)) && (isDisplayed(driver, workspaceAccountLabel))
					&& (isDisplayed(driver, workspaceScopeLabel))) {
				BaseSuite.validationReportLog(
						"In workspace section all the workspace labels name displaying successfully:"
								+ WorkspaceLabelsColumns);
			} else {
				BaseSuite.reportFailLog("Workspace labels are not available", "workspaceAssignDetails");
			}
			BaseSuite.reportLog("Searching for assigned Workspace");
			javascript(driver, "window.scrollTo(0, document.body.scrollHeight)");
			BaseSuite.reportLog("Searching for workspace/account/group: ");
			isDisplayedInLoop(driver, 30, groupWorkspaceSearchbar);
			javascript(driver, "arguments[0].click();", groupWorkspaceSearchbar);
			clear(driver, groupWorkspaceSearchbar);

			isDisplayedInLoop(driver, 30, groupWorkspaceSearchbar);
			BaseSuite.reportLog("Search Name");
			sendKeys(driver, groupWorkspaceSearchbar, workspacesearch);
			BaseSuite.reportLog("Click on searched");

			isDisplayedInLoop(driver, 30, groupWorkspaceSearchClick);
			javascript(driver, "arguments[0].click();", groupWorkspaceSearchClick);
			
			BaseSuite.reportLog("Verifying Workspace datials after Group has been added to Workspace");
			
			String nameUserGroupValue = getText(driver, returnElement(userGroupName, "$User", workspacesearch)).trim();
			if (nameUserGroupValue.equalsIgnoreCase(workspacesearch.trim())) {
				BaseSuite.validationReportLog("Workspace Name detailed in Group page matched successfully : " + workspacesearch);
			} else {
				BaseSuite.reportFailLog("Workspace Name detailed in Group page not matched", "groupDetailsShouldDisplayedCorrectlyAfterGroupHasBeenAddedToWorkspace");

			}
			
			
			String roleUserGroupValue = getText(driver,  returnElement(userGroupTypeRole, "$User", roleType)).trim();

			if (roleUserGroupValue.equalsIgnoreCase(roleType.trim())) {
				BaseSuite.validationReportLog("Workspace Role detailed in Group page matched successfully : " + roleType);
			} else {
				BaseSuite.reportFailLog("Workspace Role detailed in Group page not matched", "groupDetailsShouldDisplayedCorrectlyAfterGroupHasBeenAddedToWorkspace");

			}
	}catch (Exception e) {
		e.getMessage();
	}

	}

	
	
	//*********** Workspace Owner ********
	
	public void workspaceOwnerShouldAbleToAddGroupToWorkspace(String workspaceName, String role, String accessto,
			String selectUserGroup) throws Exception {
		try {
			clickOnWorkspaceMenu();
			searchWorkspaceAndClick(workspaceName);
			assigRoles(role, accessto);
			assignSingleUserGroup(selectUserGroup);
			addRoleAssignButton();
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void workspaceOwnerAccessOnListOfWorkspaces() throws Exception {
		try {
			Workspaces w = new Workspaces(driver);
			w.clickOnWorkspaceMenu();
			w.numberOfWorkspaces();
			BaseSuite.validationReportLog("Workspace Owner is able to access on the listed Workspaces!");
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	@Parameters({"userName", "password"})
	public void doCheckLoginUsingUser(String userName, String passWord)
	{
		try {
		BaseSuite.reportLog("Entered UserName: " + userName);
		BaseSuite.reportLog("Entered Password: " + passWord);
		BaseSuite.validationReportLog("Logged in User is :::: " + userName);
		
		BaseSuite.reportLog("Verifying the Welcome User section");
		isDisplayedInLoop(driver, 30, welcomeSectionClick);
		BaseSuite.reportLog("Welcome section is displayed");
		BaseSuite.reportLog("Clicking on the the Welcome User");
		Thread.sleep(3000);
		click(driver, welcomeSectionClick);
		BaseSuite.validationReportLog("Clicked on the Welcome User!!!");

		BaseSuite.reportLog("Verifying the profile option");
		isDisplayedInLoop(driver, 30, clickOnProfileOption);
		click(driver, clickOnProfileOption);
		BaseSuite.validationReportLog("Clicked on the Profile Option!!!");


		BaseSuite.reportLog("Verifying UserName in the profile section");
		isDisplayedInLoop(driver, 30, ProfileUserName);

		String userNameDetails = getAttribute(driver, ProfileUserName, "value");
		if(userName.equals(userNameDetails))
		{
			BaseSuite.validationReportLog(":::::: Profile Section is showing correct user name ::::::");

		}
		else
		{
			BaseSuite.reportFailLog("Profile Section is not showing improper user name", "doCheckLoginUsingUser");
		}
		
		BaseSuite.reportLog("Verifying Home link option in the profile section!!");

		isDisplayedInLoop(driver, 30, homeLink);
		click(driver, homeLink);
		BaseSuite.reportLog("Clicekd on the Home Link");
		BaseSuite.validationReportLog("User is able to login as :::::::" + userName);
		

		}
		catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	
	public void refreshBtnShouldUpdateDetailsInAddedListOfUserGroup(String workspaceName,String role, String accessto,String selectUserGroup, String userGroupSearchName) throws Exception
	{
		try {
		clickOnWorkspaceMenu();
		searchWorkspaceAndClick(workspaceName);
		BaseSuite.validationReportLog("Verifying number of users/groups added in the Workspace "+ workspaceName);
		
		isDisplayedInLoop(driver, 20, NumberOfWorkspace);
		Thread.sleep(3000);
		BaseSuite.reportLog("::: Verifying the total number of User/Groups before addding the User/Groups :::");
		String numbers = getText(driver, NumberOfWorkspace);
		if(!numbers.isEmpty())
		{
		BaseSuite.validationReportLog("Number of User/Groups are available for the login user");
		BaseSuite.reportLog("Available User/Groups " + numbers);
		BaseSuite.validationReportLog(numbers + " number of User/Groups are displaying in the Page!!!");
		}
		else
		{
			BaseSuite.reportFailLog("Number of User/Groups are not displaying in the page!", "refreshBtnShouldUpdateDetailsInAddedListOfUserGroup");

		}
		
		
		assigRoles(role, accessto);
		assignSingleUserGroup(selectUserGroup);
		addRoleAssignButton();
		
		BaseSuite.reportLog("::: Verifying the total number of User/Groups after addding the User/Groups :::");

		BaseSuite.reportLog("Verifying the Refresh button");
		isDisplayedInLoop(driver, 30, RefreshAccountsBtn);
		BaseSuite.reportLog("Refresh button is Displayed");
		click(driver, RefreshAccountsBtn);
		BaseSuite.validationReportLog("Clicked on the Refresh button...");
		waitForElement(driver, toastMsgClosedBtn);
		captureToastMsg(driver, workspaceRetrivedMsgDetails, toastMsgClosedBtn, WorkspaceDetailsRetrivedText,	"Workspace detail retrieved");
		
		isDisplayedInLoop(driver, 30, NumberOfWorkspace);
		Thread.sleep(3000);
		BaseSuite.reportLog("::: Verifying the total number of User/Groups before addding the User/Groups :::");
		String numbers1 = getText(driver, NumberOfWorkspace);
		BaseSuite.reportLog("Available User/Groups " + numbers1);
		BaseSuite.validationReportLog(numbers1 + " number of User/Groups are displaying in the Page!!!");
		
		BaseSuite.reportLog("Comparing the number of users/groups before adding and after adding to the account");
		 if(!numbers.equals(numbers1))
		 {
				BaseSuite.validationReportLog("Refresh button is updating the details in the added list user/group by Account Owner.!!");
			 
		 }
		 else
		 {
			 BaseSuite.reportFailLog("Refresh button is not updating the details", "refreshBtnShouldUpdateDetailsInAddedListOfUserGroup");
		 }
		
		
		
		searchUserGroup(userGroupSearchName);
		BaseSuite.reportLog("Clicking on checkbox for removing User/Group");
		displayAndClick(driver, accountUserGroupSingleCheckbox);
		BaseSuite.reportLog("Checkbox clicked successfully for removing User/Group");
		BaseSuite.reportLog("Clicking on Remove buttton for removing User/Group");
		displayAndClick(driver, removeAddedUserBtn);
		BaseSuite.validationReportLog("Remove buttton clicked successfully for removing User/Group");
		visible(driver, removeDiscardYesButton, Constant.ruleWait);
		boolean flag = isDisplayed(driver, removeDiscardYesButton);
		if (flag) {
			BaseSuite.validationReportLog(
					"User/Group remove discard pop up is dispalyed in the page after clickog on Remove button");
			displayAndClick(driver, removeDiscardYesButton);
			BaseSuite.validationReportLog("User/Group remove conformation message accept successfully");
		} else {
			BaseSuite.reportFailLog(
					"User/Group remove discard pop up is not dispalyed in the page after clickog on Remove button",
					"adminCanRemoveRolesFromUserGroupOnWorkspaceSection");
		}
		captureToastMsg(driver, userGroupRemoveMess, toastMsgClosedBtn, userGroupRemoveText, "Remove User/Group");
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	public void searchAddedUserGroupInsideWorkspace(String workspaceName, String userGroupSearchName) {
		try {
			clickOnWorkspaceMenu();
			searchWorkspaceAndClick(workspaceName);
			searchUserGroup(userGroupSearchName);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssertionError("Error occured in this method", e);
		}

	}
	
	
	//*********** Workspace Contributor ********
	
	
	public void nonAdminUserShouldNotAbleToCreateUser() {
		try {
			Users user = new Users(driver);
			Thread.sleep(5000);
			user.clickOnUserMenuForNonAdminUser();
			BaseSuite.reportLog("Checking the New User button");
			isDisplayedInLoop(driver, 25, NewUsersHeader);
			click(driver, NewUsersHeader);
			BaseSuite.validationReportLog("Clicked on the New User button by non admin user...");
			waitForElement(driver, toastMsgClosedBtn);
			captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, nonAdminValidationText,
					"Insufficient privileges");

			BaseSuite.reportLog("Entering the details of User");
			clear_Click_SendKeys(driver, 30, user.username, "NonAdminUser");
			BaseSuite.reportLog("Entered Username is ::: NonAdminUser");

			clear_Click_SendKeys(driver, 30, user.email, "NonAdminUser@gmail.com");
			BaseSuite.reportLog("Entered Email is ::: NonAdminUser@gmail.com");

			clear_Click_SendKeys(driver, 30, user.firstname, "NonAdminUser");
			BaseSuite.reportLog("Entered First Name is ::: NonAdminUser");

			clear_Click_SendKeys(driver, 30, user.lastname, "Test");
			BaseSuite.reportLog("Entered Last Name is ::: Test");

			clear_Click_SendKeys(driver, 30, user.password, "123");
			BaseSuite.reportLog("Entered Password Name is ::: 123");

			clear_Click_SendKeys(driver, 30, user.confirmpassword, "123");
			BaseSuite.reportLog("Entered Confirm Password Name is ::: 123");

			isDisplayed(driver, user.clickonsave);
			click(driver, user.clickonsave);
			BaseSuite.reportLog("Clicked on the Save button");

			waitForElement(driver, toastMsgClosedBtn);
			captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, nonAdminValidationText,
					"Insufficient privileges");
			driver.navigate().refresh();
			Thread.sleep(3000);
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);

		}
	}
	
	
	
	public void BlockDeleteBtnShouldBeDisabledForNonAdminUserForUserMenu() {
		try {
			Users u = new Users(driver);
			isDisplayedInLoop(driver, 30, u.HomeLink);
			click(driver, u.HomeLink);
			
			driver.navigate().refresh();
			Thread.sleep(6000);
			u.clickOnUserMenuForNonAdminUser();
			u.defaultUserPageVerification();

			String blankText = getText(driver, BlankUserList);
			if (blankText.equals(BlankUserListText)) {
				BaseSuite.reportLog("Checking the User listing");
				BaseSuite.validationReportLog("No user is populated in user listing page....");

			} else {
				BaseSuite.reportFailLog("Showing users in the user listing page....",
						"BlockDeleteBtnShouldBeDisabledForNonAdminUser");
			}

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	public boolean DeleteBtnShouldBeDisabledForNonAdminUserForGroupMenu() {
		try {
			
			driver.navigate().refresh();
			Groups group = new Groups(driver);
			group.clickOnGroupMenuForNonAdminUser();
			group.defaultGroupPageVerification();

			String blankText = getText(driver, BlankUserList);
			if (blankText.equals(BlankUserListText)) {
				BaseSuite.reportLog("Checking the Group listing");
				BaseSuite.validationReportLog("No Group is populated in Group listing page....");

			} else {
				BaseSuite.reportFailLog("Showing Group in the Group listing page....",
						"BlockDeleteBtnShouldBeDisabledForNonAdminUserForGroupMenu");
			}

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
		
		return true;
	}
	
	public void nonAdminUserShouldNotAbleToCreateGroup() {
		try {
			Groups group = new Groups(driver);
			group.clickOnGroupMenuForNonAdminUser();
			Thread.sleep(5000);
			BaseSuite.reportLog("Checking the New Group button");
			isDisplayedInLoop(driver, 25, group.NewGroupBtn);
			click(driver, group.NewGroupBtn);
			BaseSuite.validationReportLog("Clicked on the New Group button by non admin user...");
			waitForElement(driver, toastMsgClosedBtn);
			captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, nonAdminValidationText,"Insufficient privileges");
			BaseSuite.reportLog("Entering the details of Group");
			
		
			isDisplayedInLoop(driver, 30, group.GroupName);
			BaseSuite.reportLog("Entering the group name");
			sendKeys(driver, group.GroupName, "NonAdminGroup");
			
			BaseSuite.validationReportLog("Entered Group Name :::::: NonAdminGroup");
			
			isDisplayedInLoop(driver, 30, group.GroupDescription);
			click(driver, group.GroupDescription);
			BaseSuite.reportLog("Entering the group description");
			sendKeys(driver, group.GroupDescription, "NonAdminGroup");
			BaseSuite.validationReportLog("Entered Group Description :::::: NonAdminGroup");
			
			isDisplayedInLoop(driver, 30, group.GroupSaveBtn);
			Thread.sleep(3000);
			click(driver, group.GroupSaveBtn);
			BaseSuite.validationReportLog("Clicked on the save button");

			waitForElement(driver, toastMsgClosedBtn);
			captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, nonAdminValidationText,"Insufficient privileges");


		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);

		}
	}
	
	
	public void nonAdminUserShouldAbleToDiscardUnsavedGroupChanges() {
		try {
			
			nonAdminUserShouldNotAbleToCreateGroup();
			Thread.sleep(3000);
			Groups group = new Groups(driver);
			click(driver, group.DiscardButton);
			String discardmsg = getText(driver, group.DiscardMsg);
			BaseSuite.validationReportLog("Alert message displaying successfully:" + discardmsg);
			if (DiscardalertYes.contains("Yes")) {
				BaseSuite.validationReportLog("Discarding Group details with option 'Yes' ");
				click(driver, group.DiscardAlertYes);
				String blankText = getText(driver, BlankUserList);
				if (blankText.equals(BlankUserListText)) {
					BaseSuite.reportLog("Checking the User listing");
					BaseSuite.validationReportLog("No Group is populated in Group listing page....");

					BaseSuite.validationReportLog("Group details discarded successfully....");
				} else {
					BaseSuite.reportFailLog("Showing Group in the Group listing page....",
							"nonAdminUserShouldAbleToDiscardUnsavedGroupChanges");
				}
			} else {
				BaseSuite.reportFailLog("Not able to discard the group details...",
						"nonAdminUserShouldAbleToDiscardUnsavedGroupChanges");
			}
	
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}

	}
	
	
	public void NoGroupShouldBePopulatedForNonAdminUser() {
		Accounts a = new Accounts(driver);
		try {
			a.accountExecutorShouldNotAccessGroupSection();
			Groups g = new Groups(driver);
			g.defaultGroupPageVerification();

			String blankText = getText(driver, BlankUserList);
			if (blankText.equals(BlankUserListText)) {
				BaseSuite.reportLog("Checking the Group listing");
				BaseSuite.validationReportLog("No Group is populated in Group listing page....");

			} else {
				BaseSuite.reportFailLog("Showing Group in the Group listing page....",
						"NoGroupShouldBePopulatedForNonAdminUser");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void NoUserShouldBePopulatedForNonAdminUser() {
		
		Users u = new Users(driver);
		try {

			u.holdsAfterLogin();
			u.clickOnUserMenuForNonAdminUser();
			u.defaultUserPageVerification();

			String blankText = getText(driver, BlankUserList);
			if (blankText.equals(BlankUserListText)) {
				BaseSuite.reportLog("Checking the User listing");
				BaseSuite.validationReportLog("No User is populated in User listing page....");

			} else {
				BaseSuite.reportFailLog("Showing Users in the Users listing page....","NoUserShouldBePopulatedForNonAdminUser");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void roleListForNonAdminUser()
	{
		try {
		Roles r=  new Roles(driver);
		r.clickOnRolesMenu();
		r.verifyDefaultRolesPage();
		r.verifyRolesPageDetails();
		r.verifyRolesGridDetailsInfo();
		r.verifynumberOfRoles(5);
		}
		catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	public void workspaceSearchAndClickOnWorkspace(String workspaceName) {
		try {
			clickOnWorkspaceMenu();
			numberOfWorkspaces();
			searchWorkspaceAndClick(workspaceName);
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void workspaceContributorAccessOnListOfWorkspacesAndClick(String workspaceName) throws InterruptedException {
		try {
			workspaceSearchAndClickOnWorkspace(workspaceName);
			BaseSuite
					.validationReportLog("Workspace Contributor is able to access and click on the listed Workspaces!");
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void workspaceOwnerAccessOnListOfWorkspacesAndClick(String workspaceName) throws InterruptedException {
		try {
			workspaceSearchAndClickOnWorkspace(workspaceName);
			BaseSuite.validationReportLog("Workspace Owner is able to access and click on the listed Workspaces!");
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	
	public void nonAdminUserShouldAbleToDiscardUnsavedWorkspaceChanges(String workspaceName) {
		try {
			workspaceSearchAndClickOnWorkspace(workspaceName);
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String WSname = workspaceName + timeStamp;
			String WSDesc = workspaceName + timeStamp;

			clear_Click_SendKeys(driver, 30, newWorkspaceName, WSname);
			BaseSuite.validationReportLog("Entered Workspace name: " + WSname);

			BaseSuite.reportLog("Entering the Workspace Description:::: " + WSDesc);
			isDisplayedInLoop(driver, 20, workspaceDescdetails);
			clear_Click_SendKeys(driver, 30, workspaceDescdetails, WSDesc);

			BaseSuite.validationReportLog("Entered account Description: " + WSDesc);
			waitForElement(driver, WorkspaceSaveBtn);

			Thread.sleep(2000);
			BaseSuite.reportLog("Checking for save button is enabled or not after entering all the details");
			boolean flag = isEnabled(driver, WorkspaceSaveBtn);
			if (flag) {
				BaseSuite.validationReportLog("Save button is enabled");
				isDisplayedInLoop(driver, 30, WorkspaceSaveBtn);
				BaseSuite.reportLog("Checking the discard button..");
				
				if (isEnabled(driver, DiscardButton)) {
					BaseSuite.reportLog("Clicking on the discard button");
					waitForElement(driver, DiscardButton);
					isDisplayedInLoop(driver, 30, DiscardButton);
					javascript(driver, "arguments[0].click();", DiscardButton);

					String discardmsg = getText(driver, DiscardMsg);
					BaseSuite.validationReportLog("Alert message displaying successfully:" + discardmsg);
					if (DiscardalertYes.contains("Yes")) {
						BaseSuite.validationReportLog("Discarding workspace details with option 'Yes' ");
						isDisplayedInLoop(driver, 30, DiscardAlertYes);
						click(driver, DiscardAlertYes);

					} else {
						BaseSuite.validationReportLog("User not discarding existing workspace details with option 'No");
						javascript(driver, "arguments[0].click();", DiscardAlertNo);
					}

					BaseSuite.validationReportLog("Existing workspace details discarded successfully");
				} else {
					BaseSuite.reportFailLog("Discard button not enabled", "nonAdminUserShouldAbleToDiscardUnsavedWorkspaceChanges");
				}
				Thread.sleep(3000);
			} else {
				BaseSuite.reportFailLog("Unable to discard the Workspace after updating the details",
						"nonAdminUserShouldAbleToDiscardUnsavedWorkspaceChanges");
			}

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	
	
	public boolean accountAndTypeSelectionShouldBeDisableOnClickExistingWorkspace(String workspaceName)
	{
		try {
		workspaceSearchAndClickOnWorkspace(workspaceName);
		BaseSuite.reportLog(":::Checking the account list dropdown:::");
		boolean flag = isEnabled(driver, existingAccoutName);
		if (flag) {
			BaseSuite.validationReportLog("Select account field is disabled as per the existing functionality so user not able to update account name");
		} else {
			BaseSuite.reportFailLog("Select account field is enabled so bug occured","accountAndTypeSelectionShouldBeDisableOnClickExistingWorkspace");
		}
		BaseSuite.reportLog(":::Checking the workspace type dropdown::: ");
		isDisplayed(driver, Workspacetype);

		boolean type = isEnabled(driver, Workspacetype);
		if (type) {
			BaseSuite.validationReportLog("Select type field is disabled as per the existing functionality so user not able to update type");
		} else {
			BaseSuite.reportFailLog("Select type field is enabled so bug occured","accountAndTypeSelectionShouldBeDisableOnClickExistingWorkspace");
		}
		}
		catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
		
		return true;
	}
	
	
	
	public boolean workspaceContriShouldNotAbleToAddUserGroupInWorkspace(String workspaceName, String role, String accessto, String selectUserGroup) throws Exception
	{
	try {
		
	
			clickOnWorkspaceMenu();
			searchWorkspaceAndClick(workspaceName);
			assigRoles(role, accessto);
			assignSingleUserGroup(selectUserGroup);
			Thread.sleep(3000);
			BaseSuite.reportLog("Checking the Add role button");
			isDisplayedInLoop(driver, 30, addRoleBtn);
			BaseSuite.reportLog("Clicking on the Add role button");
			displayAndClick(driver, addRoleBtn);
			waitForElement(driver, toastMsgClosedBtn);
			captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, nonAdminValidationText, "Insufficient privileges");
			driver.navigate().refresh();
	} catch (Exception e) {
		throw new AssertionError("Error occured in this method", e);
	}
	
	return true;
	}
	
	
	
	public boolean discardClickOnRoleAssignementWindow(String workspaceName) {
		try {
			Accounts a = new Accounts(driver);
			clickOnWorkspaceMenu();
			searchWorkspaceAndClick(workspaceName);
			a.roleAssignWindowDetailsForWorkspace();
			BaseSuite.reportLog("Checking discard button");
			isDisplayedInLoop(driver, 30, roleAssignDiscardBtn);
			BaseSuite.reportLog("Verifying discard button is enable or not");
			boolean b = isDisplayed(driver, roleAssignDiscardBtn);
			if (b) {
				BaseSuite.reportLog("Discard button is enabled");
				click(driver, roleAssignDiscardBtn);
				BaseSuite.validationReportLog("Clicked on the Discard button successfully");
				return true;
			} else {
				BaseSuite.reportLog("Discard button is disabled");
				BaseSuite.reportFailLog("Discard button is disabled", "discardClickOnRoleAssignementWindow");
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new AssertionError("Error occured in this method", e);
		}

	}
	
	
	public void userShouldNotAbleToRemoveUserFromTheWorkspace(String workspaceName) {
		try {
			Accounts a = new Accounts(driver);
			clickOnWorkspaceMenu();
			searchWorkspaceAndClick(workspaceName);
			Thread.sleep(3000);
			a.removeUserGroupForNonAdminUser();
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	
	
	public void shouldNotSelectMultipleUsers() {
		try {
			List<WebElement> listOfUsers = getElements(driver, listOfAssignUsersGroupsToWS);

			System.out.println(listOfUsers.size());
			BaseSuite.reportLog("Number of Added Users/Grroups are ::: " + listOfUsers.size());
			for (WebElement e : listOfUsers) {
				click(driver, selectCheckboxOfUserGroup);
			}
			
			
			List<WebElement> selectedUsers = getElements(driver, singleSelectedCheckbox);
			System.out.println(selectedUsers.size());
			BaseSuite.reportLog("Selected Users/Grroups are ::: " + selectedUsers.size());
			
			BaseSuite.validationReportLog("User is able to select users/groups are :::::" + selectedUsers.size());
			
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}

	}
	
	
	public void refreshUserGroupListInsideWorkspace(String workspaceName) {
		try {
			searchWorkspaceAndClick(workspaceName);
			isDisplayedInLoop(driver, 30, User_GroupTab);
			BaseSuite.reportLog("Checking the User/Group tab");
			click(driver, User_GroupTab);
			BaseSuite.validationReportLog("Clicked on the User/Group tab");

			BaseSuite.reportLog("Before refresh::::::::::::::::::");
			String number1 = getText(driver, NumberOfWorkspace);

			BaseSuite.reportLog("Checking the Refresh button");
			isDisplayedInLoop(driver, 30, Wks_Refeshbtn);
			click(driver, Wks_Refeshbtn);
			BaseSuite.validationReportLog("Clicked on the Refresh button");

			BaseSuite.reportLog("After refresh::::::::::::::::::");
			String number2 = getText(driver, NumberOfWorkspace);

			if (number1.equals(number2)) {
				BaseSuite.validationReportLog("User/Group list in the workspace is refreshed...");
				BaseSuite.validationReportLog("No User/Group is added in the Workspace:::::::");

			} else {
				BaseSuite.validationReportLog("User/Group list in the workspace is refreshed...");
				BaseSuite.validationReportLog("User/Group is added in the Workspace:::::::");
			}

			Thread.sleep(5000);
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	
	public boolean nonAdminUserShouldAbleToDiscardUnsavedDataOfAccount(String name, String description) {
		try {
			Accounts a = new Accounts(driver);
			a.clickOnAccountsMenu();

			Thread.sleep(3000);
			isDisplayedInLoop(driver, 30, a.NewAccountsBtn);
			click(driver, a.NewAccountsBtn);
			BaseSuite.validationReportLog("Clicked on the New Accounts button...");
			
			isDisplayedInLoop(driver, 30, a.AccountName);
			click(driver, a.AccountName);
			BaseSuite.reportLog("Clicked on Account Name");
			sendKeys(driver, a.AccountName, name);
			BaseSuite.validationReportLog("Entered Account Name :::: " + name);

			isDisplayedInLoop(driver, 30, a.AccountDescription);
			click(driver, a.AccountDescription);
			BaseSuite.reportLog("Clicked on Account Description");
			sendKeys(driver, a.AccountDescription, description);
			BaseSuite.validationReportLog("Entered Account Description :::: " + description);

			BaseSuite.reportLog("Checking account discard button");
			isDisplayedInLoop(driver, 40, a.AccountDiscardBtn);
			click(driver, a.AccountDiscardBtn);
			BaseSuite.reportLog("Clicked on the Account Discard Button ::::::::::::");
			Thread.sleep(3000);
			isDisplayedInLoop(driver, 40, a.AccountDiscardBtnYes);
			javascript(driver, "arguments[0].click();", a.AccountDiscardBtnYes);
			BaseSuite.reportLog("Clicked on the YES button to discard all unsaved data");
			isDisplayedInLoop(driver, 30, a.NewAccountsBtn);

			BaseSuite.validationReportLog("Account creation has been discarded " + name);

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
		return true;
	}
	
	
	
	
	public void nonAdminUserShouldAbleToDiscardUnsavedDataOfUser() {
		try {
			Users user = new Users(driver);
			Thread.sleep(5000);
			user.clickOnUserMenuForNonAdminUser();
			BaseSuite.reportLog("Checking the New User button");
			isDisplayedInLoop(driver, 25, NewUsersHeader);
			click(driver, NewUsersHeader);
			BaseSuite.validationReportLog("Clicked on the New User button by non admin user...");
			waitForElement(driver, toastMsgClosedBtn);
			captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, nonAdminValidationText,
					"Insufficient privileges");

			BaseSuite.reportLog("Entering the details of User");
			clear_Click_SendKeys(driver, 30, user.username, "NonAdminUser");
			BaseSuite.reportLog("Entered Username is ::: NonAdminUser");

			clear_Click_SendKeys(driver, 30, user.email, "NonAdminUser@gmail.com");
			BaseSuite.reportLog("Entered Email is ::: NonAdminUser@gmail.com");

			clear_Click_SendKeys(driver, 30, user.firstname, "NonAdminUser");
			BaseSuite.reportLog("Entered First Name is ::: NonAdminUser");

			clear_Click_SendKeys(driver, 30, user.lastname, "Test");
			BaseSuite.reportLog("Entered Last Name is ::: Test");

			clear_Click_SendKeys(driver, 30, user.password, "123");
			BaseSuite.reportLog("Entered Password Name is ::: 123");

			clear_Click_SendKeys(driver, 30, user.confirmpassword, "123");
			BaseSuite.reportLog("Entered Confirm Password Name is ::: 123");

			Users users = new Users(driver);
			click(driver, users.DiscardButton);
			String discardmsg = getText(driver, users.DiscardMsg);
			BaseSuite.validationReportLog("Alert message displaying successfully:" + discardmsg);
			if (DiscardalertYes.contains("Yes")) {
				BaseSuite.validationReportLog("Discarding user details with option 'Yes' ");
				click(driver, users.DiscardAlertYes);
				String blankText = getText(driver, BlankUserList);
				if (blankText.equals(BlankUserListText)) {
					BaseSuite.reportLog("Checking the User listing");
					BaseSuite.validationReportLog("No user is populated in user listing page....");

					BaseSuite.validationReportLog("User details discarded successfully....");
				} else {
					BaseSuite.reportFailLog("Showing users in the user listing page....",
							"nonAdminUserShouldAbleToDiscardUnsavedGroupChanges");
				}
			} else {
				BaseSuite.reportFailLog("Not able to discard the group details...",
						"nonAdminUserShouldAbleToDiscardUnsavedGroupChanges");
			}

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	
	
	
}
	
	
	
	
	

