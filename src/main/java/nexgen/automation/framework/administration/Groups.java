package nexgen.automation.framework.administration;

import static org.testng.Assert.assertFalse;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
//import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.util.BaseClassUtil;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;

public class Groups extends PageUtil {

	WebDriver driver;

	public Groups(WebDriver driver) {

		this.driver = driver;

	}

	static final Logger log = Logger.getLogger(Groups.class);

	// ######################################Web element for group
	// page#######################################

	// web elements
	By USelectChk = getElementLocator(prop.getProperty("User.SelectionChk"));
	By GroupsSideBarMenu = getElementLocator(prop.getProperty("Groups.GroupsSideBar"));
	By GroupDeleteBtnn = getElementLocator(prop.getProperty("Groups.grpDeleteBtn"));
	By GroupSelectAllCheckBox = getElementLocator(prop.getProperty("Groups.grpselectAllchk"));
	By GroupAllCheckboxes = getElementLocator(prop.getProperty("Group.ChkOfGrpsGrid"));
	By GroupRefreshBtn = getElementLocator(prop.getProperty("Group.RefreshBtn"));
	By GlabelTotalusers = getElementLocator(prop.getProperty("Group.LabelOfTotalGroups"));
	By GsearchTxtbox = getElementLocator(prop.getProperty("Groups.SearchBar"));
	By Gsearchbtn = getElementLocator(prop.getProperty("Groups.SearchClick"));
	By GNewGrpBtn = getElementLocator(prop.getProperty("Group.NewGroup"));
	By Groupnametxt = getElementLocator(prop.getProperty("Groups.GroupName"));
	By GrpDescTxt = getElementLocator(prop.getProperty("Groups.GroupDescription"));
	By NGrpSavebtn = getElementLocator(prop.getProperty("Groups.saveNewGrp"));
	By GcreationToastMsg = getElementLocator(prop.getProperty("GroupCreatationMsg"));
	By GDeletionToastMsg = getElementLocator(prop.getProperty("GroupDeletednMsg"));
	By GrpCloseIconToast = getElementLocator(prop.getProperty("GToastMsgClosedBtn"));
	By GrpSearchResult = getElementLocator(prop.getProperty("Grp.selectSresult"));
	By GroupDeleteYes = getElementLocator(prop.getProperty("Grp.DeleteYesbtn"));
	By GroupAddUser = getElementLocator(prop.getProperty("Grp.addUserToGroup"));
	By GroupSelectUserDropdown = getElementLocator(prop.getProperty("Grp.addUserDropdown"));
	By GroupAssignUserbtn = getElementLocator(prop.getProperty("Grp.assinUserBtn"));
	By GroupSelectUserToAssign = getElementLocator(prop.getProperty("Grp.selectUserToAssign"));
	By GrpUserAssignedmsg = getElementLocator(prop.getProperty("GroupAddedUserSuccMsg"));
	By grpUserRemovedMsg = getElementLocator(prop.getProperty("GroupUserRemovedSuccMsg"));
	By GrpRemoveUserChk = getElementLocator(prop.getProperty("Groups.UserCheckbox"));

	// Variables

	public String groupNameToSearch = prop.getProperty("Group.SearchGroup");
	public String groupSearchList = prop.getProperty("Groups.SearchList");
	public String groupNamen = prop.getProperty("Group.GroupName");
	public String groupDesc = prop.getProperty("Group.GroupDesc");
	public String toastmsg = prop.getProperty("GroupCreatedText");
	public String selectedgrp = prop.getProperty("Group.ChkOfGrpsGrid");
	public String chkGroupsearched = prop.getProperty("Groups.selectSearchedGroupchk");
	public String user = prop.getProperty("Group.AssignUser");
	public String userassignedText = prop.getProperty("GroupUserassigned");
	public String groupDeletedText = prop.getProperty("Group1DeletedText");
	public String chkAssigneduser = prop.getProperty("GrpRemoveUserChk");
	public String userremovedtoastMsg = prop.getProperty("GroupUserRemoved");

	By GroupSearchDataDetails = getElementLocator(prop.getProperty("Groups.SearchDataDetails"));
	By GroupsMenu = getElementLocator(prop.getProperty("Groups.GroupsSideBar"));
	By NumberOfGroups = getElementLocator(prop.getProperty("Groups.NumberOfGroups"));
	By Pagination = getElementLocator(prop.getProperty("Groups.pagination"));
	// Inside group -tabs

	By UsersTab = getElementLocator(prop.getProperty("Groups.UsersTab"));
	By AccountsTab = getElementLocator(prop.getProperty("Groups.AccountsTab"));
	By WorkspaceTab = getElementLocator(prop.getProperty("Groups.WorkspaceTab"));
	By UsersAddBtn = getElementLocator(prop.getProperty("Groups.UsersAddBtn"));
	By UsersAddSearchLabel = getElementLocator(prop.getProperty("Groups.UsersAddSearchLabel"));
	By AddUsersTextBox = getElementLocator(prop.getProperty("Groups.AddUsersTextBox"));
	By AssignUserBtn = getElementLocator(prop.getProperty("Groups.AssignBtn"));
	By DiscarGroupBtn = getElementLocator(prop.getProperty("Groups.DiscardBtn"));

	By AddedUsersDetails = getElementLocator(prop.getProperty("Groups.AddedUsersDetails"));

	// Search Users inside the Group

	By UserSearchTextbox = getElementLocator(prop.getProperty("Groups.UserSearchTextbox"));
	By UserSearchTextboxButton = getElementLocator(prop.getProperty("Groups.UserSearchTextboxButton"));
	By UserSearchData = getElementLocator(prop.getProperty("Groups.UserSearchData"));

	// Remove User
	By UserCheckbox = getElementLocator(prop.getProperty("Groups.UserCheckbox"));
	By RemoveAddedUserBtn = getElementLocator(prop.getProperty("Groups.RemoveAddedUserBtn"));
	By UserRemoveBtnClickYes = getElementLocator(prop.getProperty("Groups.UserRemoveBtnClickYes"));
	By UserRemoveBtnClickNo = getElementLocator(prop.getProperty("Groups.UserRemoveBtnClickNo"));

	// Create Group

	By NewGroupBtn = getElementLocator(prop.getProperty("Groups.NewGroupBtn"));
	By RefreshBtn = getElementLocator(prop.getProperty("Groups.RefreshBtn"));
	By DeleteBtn = getElementLocator(prop.getProperty("Groups.DeleteBtn"));

	public By GroupName = getElementLocator(prop.getProperty("Groups.GroupName"));
	public By GroupDescription = getElementLocator(prop.getProperty("Groups.GroupDescription"));
	By GroupSaveBtn = getElementLocator(prop.getProperty("Groups.GroupSaveBtn"));
	By GroupDeleteBtn = getElementLocator(prop.getProperty("Groups.GroupDeleteBtn"));

	// Group page object

	By clickGroups = getElementLocator(prop.getProperty("Group.groups"));
	By checkboxes = getElementLocator(prop.getProperty("Group.rowcount"));
	By nextclick = getElementLocator(prop.getProperty("Group.nextbutton"));
	By groupclick = getElementLocator(prop.getProperty("Group.newgroup"));
	By saveclick = getElementLocator(prop.getProperty("Group.save"));
	By entername = getElementLocator(prop.getProperty("Group.name"));
	By enterdescription = getElementLocator(prop.getProperty("Group.description"));
	By discardclick = getElementLocator(prop.getProperty("Group.discard"));
	By deleteclick = getElementLocator(prop.getProperty("Group.delete"));
	By discardYesclick = getElementLocator(prop.getProperty("Group.discardyes"));
	By selectcheckbox = getElementLocator(prop.getProperty("Group.checked"));
	By GroupDeleteBtnYes = getElementLocator(prop.getProperty("Group.deleteyes"));
	By getName = getElementLocator(prop.getProperty("Group.get"));
	By groupDelete = getElementLocator(prop.getProperty("Group.deletegroup"));
	By groupYes = getElementLocator(prop.getProperty("Group.deletegroupyes"));

	// Updated code
	By HomeLink = getElementLocator(prop.getProperty("Users.HomeLink"));
	By groupLink = getElementLocator(prop.getProperty("Groups.groupLink"));

	By groupNameCol = getElementLocator(prop.getProperty("Groups.groupNameCol"));
	By groupDescriptionCol = getElementLocator(prop.getProperty("Group.groupDescriptionCol"));
	By NewGroupInput = getElementLocator(prop.getProperty("NewGroupInput"));
	By NewGroupButtons = getElementLocator(prop.getProperty("NewGroupButtons"));
	By GroupNameLabel = getElementLocator(prop.getProperty("GroupNameLabel"));
	By GroupDescLabel = getElementLocator(prop.getProperty("GroupDescLabel"));

	String groupCreateText = prop.getProperty("GroupCreatedText");

	By groupCreatedMsg = getElementLocator(prop.getProperty("GroupCreatedMsg"));
	By toastMsgClosedBtn = getElementLocator(prop.getProperty("ToastMsgClosedBtn")); // close button

	public String groupNameDetails = prop.getProperty("groupNameDetails");

	public By GroupNameMandatoryVal = getElementLocator(prop.getProperty("Group.GroupNameMandatoryVal"));
	public By GroupNameSpecialCharVal = getElementLocator(prop.getProperty("Group.GroupNameSpecialCharVal"));
	public String GroupNameSpecialCharError = prop.getProperty("GroupNameSpecialCharError");
	public String GroupNameMandatoryText = prop.getProperty("GroupNameMandatoryText");

	public String ExceedCharactersTextDetails = prop.getProperty("ExceedCharactersTextDetails");
	public By ExceedCharValMsg = getElementLocator(prop.getProperty("Group.ExceedCharValMsg"));
	public String NameExceedCharErrorMsgText = prop.getProperty("NameExceedCharErrorMsgText");

	public String ExceedDescriptionTextDetails = prop.getProperty("ExceedDescriptionTextDetails");
	public By DescriptionExceedCharValMsg = getElementLocator(prop.getProperty("DescriptionExceedCharValMsg"));
	public String DescriptionExceedCharErrorMsgText = prop.getProperty("DescriptionExceedCharErrorMsgText");

	String GroupDeletedFromUserText = prop.getProperty("GroupDeletedFromUserText");
	By GroupDeletedFromUserMsg = getElementLocator(prop.getProperty("GroupDeletedFromUserMsg"));
	public String groupCreateDetails = prop.getProperty("groupCreateDetails");
	public String assignUserName = prop.getProperty("assignUserName");
	public String searchUserDetails = prop.getProperty("searchUserDetails");
	By GrpSearchTextboxForUser = getElementLocator(prop.getProperty("Users.GrpSearchTextboxForUser"));
	By GrpSearchTextboxClickForUser = getElementLocator(prop.getProperty("Users.GrpSearchTextboxButtonForUser"));

	String AssignUserToGroupText = prop.getProperty("AssignUserToGroupText");
	By AssignUserToGroupTextMsg = getElementLocator(prop.getProperty("AssignUserToGroupTextMsg"));

	String GroupDetailsRetrievedText = prop.getProperty("GroupDetailsRetrievedText");
	By GroupDetailsRetrievedMsg = getElementLocator(prop.getProperty("GroupDetailsRetrievedMsg"));
	By toolbarText = getElementLocator(prop.getProperty("Users.Toolbar.text"));
	By toolbarText_grp=getElementLocator(prop.getProperty("grp.NoUserText"));

	By spinner = getElementLocator(prop.getProperty("Spinner"));

	// AK updated locators
	// Search Group

	By GroupsSideBar = getElementLocator(prop.getProperty("Groups.GroupsSideBar"));
	By GroupSearchBar = getElementLocator(prop.getProperty("Groups.SearchBar"));
	By GroupSearchClick = getElementLocator(prop.getProperty("Groups.SearchClick"));
	By GroupSearchList1 = getElementLocator(prop.getProperty("Groups.SearchLost"));
	String GroupSearchList = prop.getProperty("Groups.SearchList");

	// Create Group
	By groupName = getElementLocator(prop.getProperty("Groups.GroupName"));
	By groupDescription = getElementLocator(prop.getProperty("Groups.GroupDescription"));

	
	
	String duplicateGroupValidationText = prop.getProperty("duplicateGroupValidationText");
	By duplicateGroupValidationMsg = getElementLocator(prop.getProperty("duplicateGroupValidationMsg"));
	
	public String duplicateGroupName = prop.getProperty("duplicateGroupName");
	public String duplicateGroupDescr = prop.getProperty("duplicateGroupDescr");
	
	public String GroupSearchDetails = prop.getProperty("GroupSearchDetails");
		
	// NewGroupButton and Save Button
	//By HomeLink = getElementLocator(prop.getProperty("Group.homeLink"));
    //By groupLink = getElementLocator(prop.getProperty("Groups.groupLink"));
   
	/*
	 * By groupNameCol = getElementLocator(prop.getProperty("Groups.groupNameCol"));
	 * By groupDescriptionCol =
	 * getElementLocator(prop.getProperty("Group.groupDescriptionCol")); By
	 * NewGroupInput = getElementLocator(prop.getProperty("NewGroupInput")); By
	 * NewGroupButtons = getElementLocator(prop.getProperty("NewGroupButtons")); By
	 * GroupNameLabel = getElementLocator(prop.getProperty("GroupNameLabel")); By
	 * GroupDescLabel = getElementLocator(prop.getProperty("GroupDescLabel")); By
	 * NewGroupBtn = getElementLocator(prop.getProperty("Groups.NewGroupBtn")); By
	 * GroupSaveBtn = getElementLocator(prop.getProperty("Groups.GroupSaveBtn"));
	 */
    //Toast Messages
   // String groupCreateText = prop.getProperty("GroupCreatedText");
    //By groupCreatedMsg = getElementLocator(prop.getProperty("GroupCreatedMsg"));
    //By toastMsgClosedBtn = getElementLocator(prop.getProperty("ToastMsgClosedBtn"));

	By groupRetriveMsg = getElementLocator(prop.getProperty("GroupRetrivedMsg"));

	

	// Assigning Users in Existing Group

	By userAddBtn = getElementLocator(prop.getProperty("Groups.UsersAddBtn"));

	By UserAssignLabel = getElementLocator(prop.getProperty("Groups.UsersAddSearchLabel"));

	By addUserTextBox = getElementLocator(prop.getProperty("Groups.AddUsersTextBox"));

	By usersAssignBtn = getElementLocator(prop.getProperty("Groups.AssignBtn"));

	By usersDiscardBtn = getElementLocator(prop.getProperty("Groups.DiscardBtn"));

	public String userAssignTxt = prop.getProperty("UserAssignTxt");
	String groupDeleteToastMsg = prop.getProperty("GroupDeleteText");
	public String AssignUserName = prop.getProperty("UsernameAssigned");

	// Search Assign Users
	By U_SearchBar = getElementLocator(prop.getProperty("Groups.UserSearchTextbox"));
	By U_SearchClick = getElementLocator(prop.getProperty("Groups.UserSearchBtn"));
	By U_SearchData = getElementLocator(prop.getProperty("Groups.UserSearchData"));

	// Search Assign Account
	// Search Assign Users
	By AC_SearchBar = getElementLocator(prop.getProperty("Groups.AccountSearchtbox"));
	By AC_SearchClick = getElementLocator(prop.getProperty("Groups.AccountsearchBtn"));
	By AC_SearchData = getElementLocator(prop.getProperty("Groups.Accountsearchaata"));

	By AddedGroupDetails = getElementLocator(prop.getProperty("Users.AddedGroupDetails"));

	// Discard Group details
	public String GroupNamestring = prop.getProperty("Group.D_Groupname");
	public String Description = prop.getProperty("Group.D_Desc");

	public String DiscardalertYes = prop.getProperty("Group.D_DiscardAlert");
	public String Group_search = prop.getProperty("Group.D_SearchExistingGroup");
	public String RetriveDetailsMsg = prop.getProperty("GroupDetailMsg");

	By DiscardButton = getElementLocator(prop.getProperty("Group.DiscardButton"));
	By DiscardAlertYes = getElementLocator(prop.getProperty("Group.DiscardYesAlert"));
	By DiscardAlertNo = getElementLocator(prop.getProperty("Group.DiscardNoAlert"));
	By DiscardMsg = getElementLocator(prop.getProperty("Group.DiscardMsg"));

	// Delete Button Enabled
	By EnabledDeleteBtn = getElementLocator(prop.getProperty("Groups.DeleteBtn"));
	By DeleteYesBtn = getElementLocator(prop.getProperty("Groups.DeleteYesBtn"));

	// Delete Multiple Group
	By selectGroups = getElementLocator(prop.getProperty("Groups.SelectCheckboxes"));
	String toastDeleteMultipleGroupMsg = prop.getProperty("");

	// Delete and verify group
	public String deletedGroup = prop.getProperty("Group.deletedgroup");
	public String singleGroupDelToastTxt = prop.getProperty("SingleDeleteText");

	// Create new groups
	By usersTab = getElementLocator(prop.getProperty("Groups.UsersTab"));


		
		
		
		
		//Added User details to the group
		By clickOnAddedGroupToUser = getElementLocator(prop.getProperty("clickOnAddedGroupToUser"));
		By groupDetailsInsideUser = getElementLocator(prop.getProperty("groupDetailsInsideUser"));
		By groupTabInUser = getElementLocator(prop.getProperty("groupTabInUser"));
		
		By commonToastMsg = getElementLocator(prop.getProperty("Commontoastmsg"));
		String nonAdminValidationText = prop.getProperty("nonAdminValidationText");
		
			
		

	public void defaultGroupPageVerification() {

		BaseSuite.reportLog("Verifying New Button in the Group page");

		boolean newGroupButton = isEnabled(driver, NewGroupBtn);

		if (newGroupButton) {
			BaseSuite.validationReportLog("New Group creation button is enabled");
		} else {
			BaseSuite.reportFailLog("New Group creation button is disabled", "defaultGroupPageVerification");
		}

		BaseSuite.reportLog("Verifying Refresh Button in the Group page");

		boolean refreshButton = isEnabled(driver, RefreshBtn);

		if (refreshButton) {
			BaseSuite.validationReportLog("Refresh button is enabled");

		} else {

			BaseSuite.reportFailLog("Refresh button is disabled", "defaultGroupPageVerification");
		}

		BaseSuite.reportLog("Verifying Delete button in the Group Page");

		boolean deleteGroup = isDisplayed(driver, DeleteBtn);

		if (deleteGroup) {

			BaseSuite.validationReportLog("Delete Group button is disabled ");

		} else {

			BaseSuite.reportFailLog("Delete Group button is enabled", "defaultGroupPageVerification");
		}

	}

	public void numberOfGroups() throws InterruptedException {
		clickOnGroupsMenu();
		isDisplayedInLoop(driver, 20, NumberOfGroups);
		Thread.sleep(3000);
		String numbers = getText(driver, NumberOfGroups);

		System.out.println("Number of groups in the list are " + numbers);
		BaseSuite.validationReportLog("Number of Groups  are displaying in the Groups Page!");
		BaseSuite.reportLog("Available Groups " + numbers);

		// paginationInsearchfield(driver, Pagination);

	}

	public void GroupSearch(String GroupSearchDetails) throws Exception {

		BaseSuite.reportLog("Checking group search bar");
		isDisplayedInLoop(driver, 30, GroupSearchBar);
		BaseSuite.reportLog("Searching for Group: " + GroupSearchDetails);

		javascript(driver, "arguments[0].click();", GroupSearchBar);
		BaseSuite.reportLog("Clicked on the Group search bar");
		clear(driver, GroupSearchBar);

		isDisplayedInLoop(driver, 30, GroupSearchBar);
		BaseSuite.reportLog("Entrering the group details...");
		sendKeys(driver, GroupSearchBar, GroupSearchDetails);
		BaseSuite.reportLog("Entered details of " + GroupSearchDetails);
		BaseSuite.validationReportLog("Entered group " + GroupSearchDetails);

		isDisplayedInLoop(driver, 30, GroupSearchClick);
		javascript(driver, "arguments[0].click();", GroupSearchClick);
		BaseSuite.reportLog("Clicking on the group search button");
		javascript(driver, "arguments[0].click();", GroupSearchClick);

		BaseSuite.validationReportLog("Clicked on the search button to search the Group");
		Thread.sleep(3000);
		try {

			BaseSuite.reportLog("Checking the search list");
			isDisplayedInLoop(driver, 30, GroupSearchList1);
			javascript(driver, "arguments[0].click();", returnElement(GroupSearchList, "$User", GroupSearchDetails));
			BaseSuite.validationReportLog("Group is available and clicked on Group: " + GroupSearchDetails);
			captureToastMsg(driver, GroupDetailsRetrievedMsg, toastMsgClosedBtn, GroupDetailsRetrievedText,"Group Retrived");

			BaseSuite.reportLog("Group Details retrieved successfully for  " + GroupSearchDetails);

			Thread.sleep(3000);
			String getValue = getAttribute(driver, GroupSearchDataDetails, "value");

			System.out.println(getValue);

			if (getValue.equalsIgnoreCase(GroupSearchDetails)) {
				System.out.println("Searched Group is  " + GroupSearchDetails);
				BaseSuite.validationReportLog("Searched Group is  " + GroupSearchDetails);
			}

			else {
				System.out.println("Searched Group is not proper " + GroupSearchDataDetails);
			}

		} catch (Exception e) {
			throw new Exception("Group_search " + GroupSearchClick + " not found");
		}
	}
	
	
	

	public void addUserToExistingGroup(String assignUserName) throws Exception {
		GroupSearch("AutomationTesting");
		BaseSuite.reportLog("Adding User(s) to the Group!!");
		addUserInsideGroup(assignUserName);
		BaseSuite.reportLog("Added user inside the Group!!");

	}

	public void addUserInsideGroup(String assignUserName) throws InterruptedException {
		isDisplayedInLoop(driver, 30, UsersTab);
		javascript(driver, "arguments[0].click();", UsersTab);
		BaseSuite.reportLog("Clicked on the User tab ");

		isDisplayedInLoop(driver, 30, UsersAddBtn);
		javascript(driver, "arguments[0].click();", UsersAddBtn);
		BaseSuite.reportLog("Clicked on the User Add button ");

		isDisplayedInLoop(driver, 30, UsersAddSearchLabel);

		isDisplayedInLoop(driver, 30, AddUsersTextBox);
		// displayAndClick(AddUsersTextBox);

		click(driver, AddUsersTextBox);
		BaseSuite.reportLog("Clicked on the Add Users TextBox ");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@class='e-dropdownbase']")).sendKeys(assignUserName);

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='e-dropdownbase']")).sendKeys(Keys.ENTER);

		javascript(driver, "arguments[0].click();", AssignUserBtn);

		Thread.sleep(2000);

		if (getText(driver, AddedUsersDetails).equals(assignUserName)) {
			System.out.println("Added User is " + assignUserName);
			BaseSuite.reportLog("Added User is " + assignUserName);
		}

		else {
			System.out.println("Added User is not proper " + assignUserName);
		}
	}

	public void discardUserForGroup(String discardUserName) throws Exception {

		GroupSearch("AutomationTesting");
		isDisplayedInLoop(driver, 20, UsersTab);
		click(driver, UsersTab);

		isDisplayedInLoop(driver, 20, UsersAddBtn);
		click(driver, UsersAddBtn);

		isDisplayedInLoop(driver, 20, UsersAddSearchLabel);

		isDisplayedInLoop(driver, 20, AddUsersTextBox);
		// displayAndClick(AddUsersTextBox);
		javascript(driver, "arguments[0].click();", AddUsersTextBox);

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@class='e-dropdownbase']")).sendKeys(discardUserName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='e-dropdownbase']")).sendKeys(Keys.ENTER);

		click(driver, DiscarGroupBtn);
		BaseSuite.validationReportLog(discardUserName + " User is successfully discarded from adding");

	}

	public void deleteUserFromExistingGroup(String user_search) throws Exception {

		GroupSearch("AutomationTesting");

		isDisplayedInLoop(driver, 30, UsersTab);
		javascript(driver, "arguments[0].click();", UsersTab);

		BaseSuite.reportLog("Searching for User:" + user_search);
		isDisplayedInLoop(driver, 30, UserSearchTextbox);

		// --------Search already added user and delete accordingly-----
		click(driver, UserSearchTextbox);
		clear(driver, UserSearchTextbox);
		BaseSuite.reportLog("Searching Name");
		sendKeys(driver, UserSearchTextbox, user_search);

		BaseSuite.reportLog("Click nn search button");
		isDisplayedInLoop(driver, 30, UserSearchTextboxButton);
		javascript(driver, "arguments[0].click();", UserSearchTextboxButton);

		BaseSuite.reportLog("User searched successfully!");

		Thread.sleep(2000);

		javascript(driver, "arguments[0].click();", UserCheckbox);
		javascript(driver, "arguments[0].click();", RemoveAddedUserBtn);
		BaseSuite.reportLog("Clicked on Removed");

		javascript(driver, "arguments[0].click();", UserRemoveBtnClickYes);
		BaseSuite.reportLog("Clicked on removed button - Yes");
		Thread.sleep(3000);
		BaseSuite.reportLog("Deleted user from the group is " + user_search);
		System.out.println("Deleted user from the group is " + user_search);

	}

	public void addUserToNewGroup(String assignUserName) throws InterruptedException {

		addUserInsideGroup(assignUserName);
	}

	public void createGroup(String groupName, String groupDescription) throws InterruptedException {
		clickOnGroupsMenu();
		isDisplayedInLoop(driver, 30, NewGroupBtn);
		javascript(driver, "arguments[0].click();", NewGroupBtn);
		isDisplayedInLoop(driver, 30, GroupName);
		BaseSuite.reportLog("Entering the group name");
		sendKeys(driver, GroupName, groupName);
		BaseSuite.validationReportLog("Entered Group Name ::::::" + groupName);
		System.out.println("Added Group Name is " + groupName);
		isDisplayedInLoop(driver, 30, GroupDescription);
		click(driver, GroupDescription);
		BaseSuite.reportLog("Entering the group description");
		sendKeys(driver, GroupDescription, groupDescription);
		BaseSuite.validationReportLog("Entered Group Description ::::::" + groupDescription);
		System.out.println("Added Group Description is " + groupDescription);
		Thread.sleep(3000);
		isDisplayedInLoop(driver, 30, GroupSaveBtn);
		click(driver, GroupSaveBtn);
		BaseSuite.validationReportLog("Clicked on the save button");
		Thread.sleep(2000);
	}
	
	public void validateDuplicateGroupCreation(String groupName, String groupDescription) throws Exception {

		createGroup(groupName, groupDescription);
		captureToastMsg(driver, duplicateGroupValidationMsg, toastMsgClosedBtn, duplicateGroupValidationText,"Group already exist");
		driver.navigate().refresh();
		clickOnGroupsMenu();
		searchGrp(groupName);
		BaseSuite.reportLog("Group search successfully..");

		isDisplayedInLoop(driver, 30, DeleteBtn);
		click(driver, DeleteBtn);
		BaseSuite.reportLog("Clicked on the Delete button");
		Thread.sleep(2000);
		isDisplayedInLoop(driver, 30, DeleteYesBtn);
		BaseSuite.reportLog("Checking group delete YES button");
		click(driver, DeleteYesBtn);
		BaseSuite.reportLog("Clicked on YES button");
		Thread.sleep(5000);
		BaseSuite.reportLog("Duplicate group deleted successfully..");
	}
	

	public void CreateGroupWithValidInvalidData(SoftAssert softAssert, String name, String description,
			String Scenario) {
		try {

			clickOnGroupsMenu();

			Thread.sleep(3000);
			isDisplayedInLoop(driver, 30, NewGroupBtn);
			click(driver, NewGroupBtn);

			isDisplayedInLoop(driver, 30, GroupName);

			click(driver, GroupName);
			sendKeys(driver, GroupName, name);
			isDisplayed(driver, GroupDescription);
			click(driver, GroupDescription);
			sendKeys(driver, GroupDescription, description);

			if (isEnabled(driver, GroupSaveBtn) && Scenario.equalsIgnoreCase("Valid")) {
				click(driver, GroupSaveBtn);

				BaseSuite.reportLog("Group created successfully: Group Name is  " + name);
				BaseSuite.validationReportLog("New group created successfully");
				System.out.println("New group created successfully");
				Thread.sleep(3000);
				clickOnGroupsMenu();
			} else if (isEnabled(driver, discardclick) && Scenario.equalsIgnoreCase("SpecialChar")) {
				isDisplayedInLoop(driver, 40, discardclick);
				click(driver, discardclick);

				isDisplayedInLoop(driver, 40, discardYesclick);
				click(driver, discardYesclick);
				BaseSuite.reportLog("Group creation has been discarded " + name);
				BaseSuite.reportErrorLog("Entered data is invalid");
				System.out.println("Group creation has been discarded " + name);
				BaseSuite.validationReportLog("Group creation has been discarded successfully");
			}

			else {
				BaseSuite.reportLog("Not able to created the Group");
			}

		}

		catch (Exception ex) {
			throw new AssertionError("User not able to create new group", ex);
		}
	}

	public void deleteNewFGroupAndDelExistingMutipleGroups(SoftAssert softAssert, String name, String description) {
		try {

			clickOnGroupsMenu();
			Thread.sleep(3000);
			isDisplayedInLoop(driver, 3, NewGroupBtn);
			click(driver, NewGroupBtn);
			BaseSuite.reportLog("Click on the New Group");

			isDisplayedInLoop(driver, 5, GroupName);
			clear_Click_SendKeys(driver, 5, GroupName, name);

			isDisplayed(driver, GroupDescription);
			click(driver, GroupDescription);
			sendKeys(driver, GroupDescription, description);
			isDisplayed(driver, GroupSaveBtn);

			if (isEnabled(driver, GroupSaveBtn)) {
				click(driver, GroupSaveBtn);
				BaseSuite.reportLog("Group created successfully!");

				Thread.sleep(3000);
				click(driver, GroupDeleteBtn);
				click(driver, GroupDeleteBtnYes);
				BaseSuite.validationReportLog("Group deleted successfully");
			} else {
				click(driver, GroupDeleteBtn);
				BaseSuite.reportErrorLog("Delete button should not be enable without saving the group details.");
			}

			Thread.sleep(3000);
			isDisplayedInLoop(driver, 30, NewGroupBtn);

			clickOnGroupsMenu();

			List<WebElement> checkList = driver.findElements(selectcheckbox);
			BaseSuite.validationReportLog("Total count of Groups on 1st page is:" + checkList.size());
			for (int i = 0; i <= checkList.size() - 13; i++) {
				checkList.get(i).click();
				Thread.sleep(3000);
			}
			click(driver, groupDelete);
			click(driver, groupYes);
			BaseSuite.validationReportLog("Multiple existing group deleted successfully.");
		}

		catch (Exception ex) {
			throw new AssertionError("User not able to delete new group", ex);
		}

	}

	public void deleteGroup(String deletingGroupName) throws InterruptedException {
		isDisplayedInLoop(driver, 30, GroupDeleteBtn);
		click(driver, GroupDeleteBtn);
		click(driver, GroupDeleteBtnYes);
		Thread.sleep(3000);
		BaseSuite.reportLog(deletingGroupName + " Group deleted successfully");
	}

	public void continueNext(String FileName, String SheetName, String userNameCol, ExtentTest test, int userNumber,
			String errorMsg, org.apache.log4j.Logger log, String columnName, String methodName)
			throws IOException, EncryptedDocumentException, InvalidFormatException,
			org.apache.poi.openxml4j.exceptions.InvalidFormatException {

		BaseClassUtil util = new BaseClassUtil();

		XLUtils xl = new XLUtils();

		String ruleName = xl.readUsingColName(FileName, SheetName, userNumber, userNameCol);// get the rule name
																							// from
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

		String screenshotPath = util.takeScreenshotAtEndOfTest(methodName, driver);// pass the class name as screen
																					// shot
																					// name

		test.addScreenCaptureFromBase64String(screenshotPath);// log the screen shot in extent report

		log.debug(errorMsg);// also log this error into application log

	}

	// Updated code as per the JIRA test cases

	public void clickOnGroupsMenu() throws InterruptedException {
		isDisplayedInLoop(driver, 30, GroupsMenu);
		click(driver, GroupsMenu);
		BaseSuite.validationReportLog("Clicked on the Group Menu");
		BaseSuite.reportLog("Verifying group landing page details ");
		defaultGroupPageVerification();
		groupPageUIDetails();
		groupPageGridDetailsInfo();
	}

	public void clickOnGroupMenuForNonAdminUser() throws InterruptedException
	{
		try {
			Thread.sleep(5000);
		BaseSuite.reportLog("Checking Group Menu");
		isDisplayedInLoop(driver, 30, GroupsMenu);
		BaseSuite.reportLog("Group Menu is displayed!!");
		click(driver, GroupsMenu);
		BaseSuite.validationReportLog("Clicked on the Group Menu!!");
		BaseSuite.reportLog("Verifying validation message for the non admin user on Group Menu");
		inVisible(driver, spinner, Constant.ruleWait);
		waitForElement(driver,toastMsgClosedBtn);
		captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, nonAdminValidationText, "Insufficient privileges");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public void clickOnNewGroupButton() {
		isDisplayedInLoop(driver, 30, NewGroupBtn);
		click(driver, NewGroupBtn);
		BaseSuite.validationReportLog(" Clicked on the New Group button!");

		validateInputFields(driver, NewGroupInput, 1);
		validateButtons(driver, NewGroupButtons, 3);
		verifyIndividualLabel(driver, GroupNameLabel, "Group Name");
		verifyIndividualLabel(driver, GroupDescLabel, "Group Description");
		isClickable(driver, HomeLink, "Home", true);
		getAllLinkAndVerifyLinkText(driver, HomeLink, "Home");
	}

	public void clickOnSaveGroupBtn() throws InterruptedException {
		try {
		BaseSuite.reportLog("Clicking on the Save button..");
		isDisplayedInLoop(driver, 40, GroupSaveBtn);
		click(driver, GroupSaveBtn);
		BaseSuite.validationReportLog("Save button clicked successfully..");
		inVisible(driver, spinner, Constant.ruleWait);
	
			captureToastMsg(driver, groupCreatedMsg, toastMsgClosedBtn, groupCreateText, "Group Created");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validateInputFields(driver, NewGroupInput, 1);
		validateButtons(driver, NewGroupButtons, 3);

	}

	public void createGroupUIElements(String groupNameDetails, SoftAssert soft) throws InterruptedException {

		BaseSuite.reportLog("Validating save button with blank data.");
		boolean a = isEnabled(driver, GroupSaveBtn);
		if (a) {
			BaseSuite.validationReportLog("Group Save button is disabled");

		} else {
			BaseSuite.reportFailLog("Group Save button is enabled", "createGroupUIElements");
		}
		BaseSuite.reportLog("Entering the details in the GroupName field");
		sendKeys(driver, GroupName, groupNameDetails);
		Thread.sleep(3000);
		BaseSuite.validationReportLog("Entered Group Name :::" + groupNameDetails);
		BaseSuite.reportLog("Checking the save button field");
		boolean b = isDisplayed(driver, GroupSaveBtn);
		boolean c = isDisplayed(driver, DiscarGroupBtn);

		if (b) {
			BaseSuite.validationReportLog("Group Save button is enabled");
			if (c) {
				BaseSuite.validationReportLog("Discard button is enabled");
			}

		} else {
			BaseSuite.reportFailLog("Group Save button is disabled", "createGroupUIElements");
		}
		driver.navigate().refresh();
	}

	public void groupPageUIDetails() throws InterruptedException {

		BaseSuite.reportLog("Checking the Group Page UI details.....");

		String groupPageDetails = "Home Link/Group Link/Group Menu/New Group Option/Refresh Button/Delete Button/Number of Groups";

		if ((isDisplayed(driver, HomeLink)) && (isDisplayed(driver, groupLink)) && (isDisplayed(driver, GroupsMenu))
				&& (isDisplayed(driver, NewGroupBtn)) && (isDisplayed(driver, RefreshBtn))
				&& (isDisplayed(driver, DeleteBtn)) && (isDisplayed(driver, NumberOfGroups))) {
			BaseSuite.reportLog(groupPageDetails + " details of Group page are displayed!");
			BaseSuite.validationReportLog("Links, Menus and Buttons are dispayed!");

		} else {
			BaseSuite.reportFailLog(groupPageDetails + " are not displaying in the page", "groupPageUIDetails");
		}

	}

	public void groupPageGridDetailsInfo() throws InterruptedException {

		String gridDetails = "Name/Description";

		BaseSuite.reportLog("Checking grid columns in the Group Page!");

		if ((isDisplayed(driver, groupNameCol)) && (isDisplayed(driver, groupDescriptionCol))) {

			BaseSuite.validationReportLog(gridDetails + " columns are displayed properly in the Group Page!");

		} else {
			BaseSuite.reportFailLog(gridDetails + " some columns are missing from the Group Page",
					"groupPageGridDetailsInfo");
		}

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

	public void groupNameValidate(String specialCharacter, String specialCharacterKey, By locator1, By locator2,
			String backSpaceKey, String lable, String specialCharErrorMsg, String backSpaceErrorMsg, By locator3)
			throws InterruptedException {

		mandatoryFieldValidation(specialCharacter, specialCharacterKey, locator1, locator2, backSpaceKey, lable,
				specialCharErrorMsg, backSpaceErrorMsg, locator3);

		driver.navigate().refresh();
		Thread.sleep(3000);
		visible(driver, GroupName, Constant.ruleWait);
	}

	public boolean groupNameWithMoreThan50Char(String exceedGroupName, By locator2, String lable, String errorMess,
			SoftAssert soft) throws InterruptedException {

		BaseSuite.reportLog("Entering the details of the Group Name with more than 50 characters:::");

		clear_Click_SendKeys(driver, 30, GroupName, exceedGroupName);
		BaseSuite.reportLog("Entered Group name: " + exceedGroupName);

		String groupNameErrmsg = getText(driver, locator2).trim();
		BaseSuite.validationReportLog("Retrived Message for " + lable + " field is :" + groupNameErrmsg);
		BaseSuite.validationReportLog("Expected Message for " + lable + " field is :" + errorMess);

		boolean status = false;
		if (!groupNameErrmsg.isEmpty()) {
			soft.assertEquals(groupNameErrmsg.trim(), errorMess.trim());
			status = true;
			BaseSuite.validationReportLog(lable + "Field Error Message Successfully Matched");
		} else {
			BaseSuite.reportFailLog(lable + "Field Error Message not Matched", "userNameWithMoreThan50Char");
			status = false;
		}
		return status;

	}

	public boolean groupDescriptionWithMoreThan250Char(String exceedGroupDescription, By locator2, String lable,
			String errorMess, SoftAssert soft) throws InterruptedException {

		BaseSuite.reportLog("Entering the details of the Group Description with more than 250 characters:::");

		clear_Click_SendKeys(driver, 30, GroupDescription, exceedGroupDescription);
		BaseSuite.reportLog("Entered Group description: " + exceedGroupDescription);

		String groupDescriptionErrmsg = getText(driver, locator2).trim();
		BaseSuite.validationReportLog("Retrived Message for " + lable + " field is :" + groupDescriptionErrmsg);
		BaseSuite.validationReportLog("Expected Message for " + lable + " field is :" + errorMess);

		boolean status = false;
		if (!groupDescriptionErrmsg.isEmpty()) {
			soft.assertEquals(groupDescriptionErrmsg.trim(), errorMess.trim());
			status = true;
			BaseSuite.validationReportLog(lable + "Field Error Message Successfully Matched");
		} else {
			BaseSuite.reportFailLog(lable + "Field Error Message not Matched", "userNameWithMoreThan50Char");
			status = false;
		}
		return status;
	}

	public void groupNameWithBlankData(By locator1, By locator2, String keysToSend, SoftAssert soft, String lable,
			String errorMess) {
		BaseSuite.reportLog("Checking validation message for GroupName textbox with blank data");
		otherMandatoryField(driver, locator1, locator2, keysToSend, soft, lable, errorMess);
		BaseSuite.validationReportLog("Group Name textbox is showing proper validation message ");
	}

	public void removeUserFromExistingGroup(String GroupSearchDetails, String groupCreateDetails, String assignUserName,
			String searchUserDetails, SoftAssert soft) throws Exception {

		searchGrp(GroupSearchDetails);

		// --------Search already added user and delete accordingly-----
		click(driver, UserSearchTextbox);
		clear(driver, UserSearchTextbox);
		BaseSuite.reportLog("Searching User Name");
		sendKeys(driver, UserSearchTextbox, assignUserName);
		BaseSuite.reportLog("Entering the user details in the search field..");

		BaseSuite.reportLog("Click on search button");
		isDisplayedInLoop(driver, 30, UserSearchTextboxButton);
		click(driver, UserSearchTextboxButton);
		BaseSuite.validationReportLog("Click on searched user");
		Thread.sleep(2000);
		BaseSuite.reportLog("Searched user is " + assignUserName);

		BaseSuite.reportLog("Selecting the User checkbox");
		click(driver, UserCheckbox);
		BaseSuite.validationReportLog(assignUserName + " user is selected");

		BaseSuite.reportLog("Clicking on the Remove Button");
		click(driver, RemoveAddedUserBtn);
		Thread.sleep(2000);
		BaseSuite.validationReportLog("Clicked on the Remove Button");

		BaseSuite.reportLog("Clicking on the Remove Button---Yes");
		click(driver, UserRemoveBtnClickYes);
		BaseSuite.validationReportLog("Clicked on the Remove Button---Yes");
		Thread.sleep(2000);
		captureToastMsg(driver, GroupDeletedFromUserMsg, toastMsgClosedBtn, GroupDeletedFromUserText,
				"User successfully removed from group");

		BaseSuite.validationReportLog(assignUserName + " User is deleted from the existing group.");

		isDisplayedInLoop(driver, 30, DeleteBtn);

	}

	public void deleteGroup() throws InterruptedException {
		BaseSuite.reportLog("Clicking on Delete Group Button");
		click(driver, DeleteBtn);
		BaseSuite.reportLog("Clicked onn Delete Group Button");
		isDisplayedInLoop(driver, 30, GroupDeleteBtnYes);

		BaseSuite.reportLog("Clicking on Delete Group Button--Yes");
		click(driver, GroupDeleteBtnYes);
		Thread.sleep(3000);
		BaseSuite.reportLog("Clicked on the  Delete Group");
		isDisplayedInLoop(driver, 30, NewGroupBtn);

		BaseSuite.validationReportLog("Created Group deleted successfully");
	}

	public void assignUserToNewGroup(String groupCreateDetails, String assignUserName) throws InterruptedException {
		try {
		Thread.sleep(5000);
		BaseSuite.validationReportLog("Creating the New Group");
		isDisplayedInLoop(driver, 30, GroupName);
		BaseSuite.reportLog("Entering the Group Name details--- ");
		clear_Click_SendKeys(driver, 30, GroupName, groupCreateDetails);
		BaseSuite.reportLog("Entered Group Details::::: " + groupCreateDetails);

		BaseSuite.reportLog("Entering the Group Description details--- ");
		clear_Click_SendKeys(driver, 30, GroupDescription, groupCreateDetails);
		BaseSuite.reportLog("Entered Group Description::::: " + groupCreateDetails);

		BaseSuite.reportLog("Clicking on the Save button..");
		isDisplayedInLoop(driver, 40, GroupSaveBtn);
		click(driver, GroupSaveBtn);
		BaseSuite.validationReportLog("Save button clicked successfully..");
		Thread.sleep(1000);

		//captureToastMsg(driver, groupCreatedMsg, toastMsgClosedBtn, groupCreateText, "Group Created");

		BaseSuite.reportLog("Created Group is " + groupCreateDetails);
		BaseSuite.validationReportLog("New Created Group Successfully!!");
		Thread.sleep(3000);

		BaseSuite.reportLog("Checking the Users tab");
		isDisplayedInLoop(driver, 30, UsersTab);
		BaseSuite.reportLog("Clicking on the User tab");
		click(driver, UsersTab);
		BaseSuite.validationReportLog("Clicked on the User tab ");

		BaseSuite.reportLog("Checking the User Add button");
		isDisplayedInLoop(driver, 30, UsersAddBtn);
		BaseSuite.reportLog("Clicking on the User Add button");
		click(driver, UsersAddBtn);
		BaseSuite.validationReportLog("Clicked on the User Add button ");

		BaseSuite.reportLog("Verifying the Add users pane");
		isDisplayedInLoop(driver, 30, UsersAddSearchLabel);
		BaseSuite.validationReportLog("Add users pane is opened and displayed");

		isDisplayedInLoop(driver, 30, AddUsersTextBox);
		click(driver, AddUsersTextBox);
		BaseSuite.reportLog("Clicked on the Add Users TextBox ");

		BaseSuite.reportLog("Entering the details of user");
		sendKeys(driver, AddUsersTextBox, assignUserName);
		BaseSuite.reportLog("Entered user details...");
		BaseSuite.validationReportLog("Entered User is " + assignUserName);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='e-dropdownbase']")).sendKeys(Keys.ENTER);

		BaseSuite.reportLog("Verifying the Assign user button");
		isDisplayedInLoop(driver, 30, AssignUserBtn);
		BaseSuite.reportLog("Clicking on the Assign button");
		click(driver, AssignUserBtn);
		BaseSuite.validationReportLog("Clicked on Assign User");

		
			captureToastMsg(driver, AssignUserToGroupTextMsg, toastMsgClosedBtn, AssignUserToGroupText,"AssignUserToGroup");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread.sleep(3000);
		BaseSuite.validationReportLog("Assign User To New Group is working properly");
		driver.navigate().refresh();
	}

	// AK Updated code as per the JIRA test cases

	public void searchGroup(String Group_search) throws Exception {

		BaseSuite.reportLog("Searching for User: " + Group_search);
		Thread.sleep(2000);
		isDisplayedInLoop(driver, 50, GroupSearchBar);
		javascript(driver, "arguments[0].click();", GroupSearchBar);
		clear(driver, GroupSearchBar);

		isDisplayedInLoop(driver, 30, GroupSearchBar);
		BaseSuite.reportLog("Search Name");
		sendKeys(driver, GroupSearchBar, Group_search);
		BaseSuite.reportLog("Click On searched");

		isDisplayedInLoop(driver, 30, GroupSearchClick);
		javascript(driver, "arguments[0].click();", GroupSearchClick);
		Thread.sleep(2000);

	}

	public void searchGroupAndClick(String Group_search) throws Exception {

		BaseSuite.reportLog("Searching for User: " + Group_search);
		inVisible(driver, spinner, Constant.ruleWait);
		isDisplayedInLoop(driver, 30, GroupSearchBar);
		javascript(driver, "arguments[0].click();", GroupSearchBar);
		clear(driver, GroupSearchBar);

		isDisplayedInLoop(driver, 30, GroupSearchBar);
		BaseSuite.reportLog("Search Name");
		sendKeys(driver, GroupSearchBar, Group_search);
		BaseSuite.reportLog("Click On searched");
		Thread.sleep(2000);
		isDisplayedInLoop(driver, 30, GroupSearchClick);
		javascript(driver, "arguments[0].click();", GroupSearchClick);

		try {

			isDisplayedInLoop(driver, 30, GroupSearchClick);

			BaseSuite.reportLog("Click on Searched User");
			click(driver, returnElement(GroupSearchList, "$User", Group_search));
			BaseSuite.reportLog("Clicked on User: " + Group_search);
			
					} catch (Exception e) {
			throw new Exception("User_search " + GroupSearchClick + " not found");
		}
	}

	
	
	public void searchGrp(String Group_search) throws Exception {

		Thread.sleep(3000);
		BaseSuite.reportLog("Searching for User: " + Group_search);
		inVisible(driver, spinner, Constant.ruleWait);
		isDisplayedInLoop(driver, 30, GroupSearchBar);
		javascript(driver, "arguments[0].click();", GroupSearchBar);
		clear(driver, GroupSearchBar);

		isDisplayedInLoop(driver, 30, GroupSearchBar);
		BaseSuite.reportLog("Search Name");
		sendKeys(driver, GroupSearchBar, Group_search);
		BaseSuite.reportLog("Click On searched");
		Thread.sleep(2000);
		isDisplayedInLoop(driver, 30, GroupSearchClick);
		javascript(driver, "arguments[0].click();", GroupSearchClick);

		try {

			isDisplayedInLoop(driver, 30, GroupSearchClick);

			BaseSuite.reportLog("Click on Searched User");
			click(driver, returnElement(GroupSearchList, "$User", Group_search));
			BaseSuite.reportLog("Clicked on User: " + Group_search);
			Thread.sleep(3000);
		} catch (Exception e) {
			throw new Exception("User_search " + GroupSearchClick + " not found");
		}
	}
		
	
	public void searchUserAssignInGroup(String User_search) throws Exception {

		BaseSuite.reportLog("Searching for workspace/account/group: " + User_search);
		isDisplayedInLoop(driver, 30, U_SearchBar);
		javascript(driver, "arguments[0].click();", U_SearchBar);
		clear(driver, U_SearchBar);

		isDisplayedInLoop(driver, 30, U_SearchBar);
		BaseSuite.reportLog("Search Name");
		sendKeys(driver, U_SearchBar, User_search);
		BaseSuite.reportLog("Click on searched");

		isDisplayedInLoop(driver, 30, U_SearchClick);
		javascript(driver, "arguments[0].click();", U_SearchClick);
	}

	public void searchAccountAssignInGroup(String User_search) throws Exception {

		BaseSuite.reportLog("Searching for workspace/account/group: " + User_search);
		isDisplayedInLoop(driver, 50, AC_SearchBar);

		javascript(driver, "arguments[0].click();", AC_SearchBar);
		clear(driver, AC_SearchBar);

		isDisplayedInLoop(driver, 40, AC_SearchBar);
		BaseSuite.reportLog("Search Name");
		waitForElement(driver, AC_SearchBar);
		sendKeys(driver, AC_SearchBar, User_search);
		BaseSuite.reportLog("Click on searched");

		isDisplayedInLoop(driver, 30, AC_SearchClick);
		javascript(driver, "arguments[0].click();", AC_SearchClick);
	}

	public void discardDetailsInExistingGroup(String GroupNamestring, String Description, String DiscardalertYes,
			String Group_search) throws Exception {
		clickOnGroupsMenu();
		try {

			waitForElement(driver, GroupSearchBar);

			inVisible(driver, spinner, Constant.ruleWait);
			BaseSuite.reportLog("Searching the existing group using search bar");

			searchGroupAndClick(Group_search);
			Thread.sleep(3000);
			isDisplayedInLoop(driver, 30, groupName);
			
			BaseSuite.validationReportLog("existing group page is opened");

			BaseSuite.reportLog(":::Entering the details of the group:::");
			if (isEditable(driver, groupName, "GroupNamestring")) {

				clear_Click_SendKeys(driver, 30, groupName, GroupNamestring);
				BaseSuite.validationReportLog("Entered Users group name: " + GroupNamestring);

				clear_Click_SendKeys(driver, 30, groupDescription, Description);
				BaseSuite.reportLog("Entered Groups Description: " + Description);

				if (isEnabled(driver, DiscardButton)) {
					isDisplayedInLoop(driver, 30, DiscardButton);
					BaseSuite.reportLog("Clicking on the discard button");
					click(driver, DiscardButton);
					String discardmsg = getText(driver, DiscardMsg);
					BaseSuite.validationReportLog("Alert message displaying successfully:" + discardmsg);
					if (DiscardalertYes.contains("Yes")) {
						BaseSuite.validationReportLog("Discarding user details with option 'Yes' ");
						click(driver, DiscardAlertYes);

					} else {
						BaseSuite.validationReportLog("User not discarding existing user details with option 'No");
						javascript(driver, "arguments[0].click();", DiscardAlertNo);
					}

					BaseSuite.validationReportLog("Existing group details discarded successfully");
				} else {
					BaseSuite.reportFailLog("Discard button not enabled", "discardNewUser");
				}
			}
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void discardDetailsInNewGroup(String GroupNamestring, String Description, String DiscardalertYes)
			throws Exception {
		clickOnGroupsMenu();
		try {
			inVisible(driver, spinner, Constant.ruleWait);

			clickOnNewGroupButton();
			BaseSuite.reportLog(":::Entering the details in the group:::");
			if (isEditable(driver, groupName, "GroupNamestring")) {

				clear_Click_SendKeys(driver, 30, groupName, GroupNamestring);
				BaseSuite.validationReportLog("Entered Users group name: " + GroupNamestring);

				clear_Click_SendKeys(driver, 30, groupDescription, Description);
				BaseSuite.reportLog("Entered Groups Description: " + Description);

				if (isEnabled(driver, GroupSaveBtn)) {
					BaseSuite.validationReportLog("To create new group save button is enabled");
					if (isEnabled(driver, DiscardButton)) {
						isDisplayedInLoop(driver, 30, DiscardButton);
						BaseSuite.reportLog("Clicking on the discard button");
						click(driver, DiscardButton);

						String discardmsg = getText(driver, DiscardMsg);
						BaseSuite.validationReportLog("Alert message displaying successfully:" + discardmsg);
						if (DiscardalertYes.contains("Yes")) {
							BaseSuite.validationReportLog("Discarding user details with option 'Yes' ");
							click(driver, DiscardAlertYes);

						} else {
							BaseSuite.validationReportLog("User not discarding existing user details with option 'No");
							javascript(driver, "arguments[0].click();", DiscardAlertNo);
						}

						BaseSuite.validationReportLog("New group details discarded successfully");
					} else {
						BaseSuite.reportFailLog("Discard button not enabled", "discardNewUser");
					}
				} else {
					BaseSuite.reportFailLog("Save button is not enabled", "discardDetailsInNewGroup");
				}
			}
			Thread.sleep(3000);
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void deleteButtonEnabled(String GroupNamestring, String Description) throws Exception {
		clickOnGroupsMenu();
		try {
			inVisible(driver, spinner, Constant.ruleWait);
			Thread.sleep(2000);
			clickOnNewGroupButton();
			BaseSuite.reportLog(":::Entering the details in the group:::");
			if (isEditable(driver, groupName, "GroupNamestring")) {

				clear_Click_SendKeys(driver, 30, groupName, GroupNamestring);
				BaseSuite.validationReportLog("Entered Users group name: " + GroupNamestring);

				clear_Click_SendKeys(driver, 30, groupDescription, Description);
				BaseSuite.reportLog("Entered Groups Description: " + Description);

				BaseSuite.reportLog("Clicking on the Save button..");
				isDisplayedInLoop(driver, 40, GroupSaveBtn);
				click(driver, GroupSaveBtn);
				BaseSuite.validationReportLog("Save button clicked successfully..");

				inVisible(driver, spinner, Constant.ruleWait);

				waitForElement(driver, toastMsgClosedBtn);

				captureToastMsg(driver, groupCreatedMsg, toastMsgClosedBtn, groupCreateText, "Group Created");

				if (isEnabled(driver, EnabledDeleteBtn)) {
					BaseSuite.reportLog("Checking delete button is enabled or not");
					isDisplayedInLoop(driver, 30, EnabledDeleteBtn);
					BaseSuite.validationReportLog("Delete button is enabled after creating the new group");
					javascript(driver, "arguments[0].click();", EnabledDeleteBtn);
					// click(driver,EnabledDeleteBtn);
					isDisplayedInLoop(driver, 40, DeleteYesBtn);
					waitForElement(driver, DeleteYesBtn);
					javascript(driver, "arguments[0].click();", DeleteYesBtn);
					inVisible(driver, spinner, Constant.ruleWait);

					waitForElement(driver, NewGroupBtn);

					BaseSuite.validationReportLog("Created group deleted successfully");

				} else {
					BaseSuite.reportFailLog(
							"Delete button is not enabled after creating the new group: Test case failed",
							"deleteButtonEnabled");
				}

			} else {
				BaseSuite.reportFailLog("New group fields are not editable.", "deleteButtonEnabled");
			}

			Thread.sleep(2000);

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void saveButtonEnabled(String GroupNamestring, String Description) throws Exception {
		clickOnGroupsMenu();
		try {
			inVisible(driver, spinner, Constant.ruleWait);
			Thread.sleep(2000);
			clickOnNewGroupButton();
			BaseSuite.reportLog(":::Entering the details in the group:::");
			if (isEditable(driver, groupName, "GroupNamestring")) {

				clear_Click_SendKeys(driver, 30, groupName, GroupNamestring);
				BaseSuite.validationReportLog("Entered Users group name: " + GroupNamestring);

				clear_Click_SendKeys(driver, 30, groupDescription, Description);
				BaseSuite.reportLog("Entered Groups Description: " + Description);

				if (isEnabled(driver, GroupSaveBtn)) {
					BaseSuite.reportLog("Checking for Save button is enabled or not");
					isDisplayedInLoop(driver, 30, GroupSaveBtn);
					BaseSuite.validationReportLog(
							"Save button is enabled and user can click on the save button to create new group");
					BaseSuite.reportLog("Clicking on the Save button..");
					isDisplayedInLoop(driver, 40, GroupSaveBtn);
					click(driver, GroupSaveBtn);
					BaseSuite.validationReportLog("Save button clicked successfully..");
					inVisible(driver, spinner, Constant.ruleWait);
					captureToastMsg(driver, groupCreatedMsg, toastMsgClosedBtn, groupCreateText, "Group Created");
				}

				else {
					BaseSuite.reportFailLog(
							"Save button is not enabled so user not able to create new group: Test case failed",
							"saveButtonEnabled");
				}

			} else {
				BaseSuite.reportFailLog("New group fields are not editable.", "saveButtonEnabled");
			}
			Thread.sleep(2000);
			driver.navigate().refresh();
			

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void deleteMultipleGroups() throws Exception {
		clickOnGroupsMenu();

		try {
			inVisible(driver, spinner, Constant.ruleWait);
			Thread.sleep(3000);	
			isDisplayedInLoop(driver, 30, selectGroups);
			List<WebElement> GroupList = driver.findElements(selectGroups);
			int count = GroupList.size();
			BaseSuite.validationReportLog("Total number of groups in list before deletion of groups are: " + count);

			for (int i = 0; i <= 1; i++) {
				isDisplayedInLoop(driver, 30, selectGroups);
				GroupList.get(i).click();

			}
			BaseSuite.validationReportLog("Multiple groups selected successfully ");

			if (isEnabled(driver, EnabledDeleteBtn)) 
			{
				isDisplayedInLoop(driver, 20, EnabledDeleteBtn);
				javascript(driver, "arguments[0].click();", EnabledDeleteBtn);
				isDisplayedInLoop(driver, 20, DeleteYesBtn);
				javascript(driver, "arguments[0].click();", DeleteYesBtn);
				waitForElement(driver, toastMsgClosedBtn);
				captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, groupDeleteToastMsg,	"Delete multiple groups");

				BaseSuite.validationReportLog("Multiple groups deleted successfully.");
			}

			else {
				BaseSuite.reportFailLog(" Multiple groups not deleted", "deleteMultipleGroups");
			}
			List<WebElement> GroupList1 = driver.findElements(selectGroups);
			int count1 = GroupList1.size();
			if (count1 == GroupList1.size()) {
				BaseSuite.validationReportLog(
						"Groups deleted successfully and count of groups in list after deletion are: " + count1);
			} else 
			{
				BaseSuite.reportFailLog("Groups not deleted from the list", "deleteMultipleGroups");
			}
			Thread.sleep(2000);
		} 
		catch (Exception e) 
		{		

			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void createValidGroups(String Name, String Desc, String NewGroupName) throws Exception
	{
		clickOnGroupsMenu();
		try {
			inVisible(driver, spinner, Constant.ruleWait);
			Thread.sleep(3000);
			clickOnNewGroupButton();
			BaseSuite.reportLog(":::Entering the details in the group:::");
			if (isEditable(driver, groupName, "GroupName")) {

				clear_Click_SendKeys(driver, 30, groupName, Name);
				BaseSuite.validationReportLog("Entered Users group name: " + Name);

				clear_Click_SendKeys(driver, 30, groupDescription, Desc);
				BaseSuite.reportLog("Entered Groups Description: " + Desc);

				if (isEnabled(driver, GroupSaveBtn))
				{
					BaseSuite.reportLog("Checking for Save button is enabled or not");

					isDisplayedInLoop(driver, 30, GroupSaveBtn);
					BaseSuite.validationReportLog("New groups created successfully");
					
				BaseSuite.reportLog("Clicking on the Save button..");
				isDisplayedInLoop(driver, 40, GroupSaveBtn);
				//javascript(driver, "arguments[0].click();", GroupSaveBtn);
				click(driver,GroupSaveBtn);
				BaseSuite.validationReportLog("Save button clicked successfully..");
				inVisible(driver, spinner, Constant.ruleWait);
				waitForElement(driver,groupCreatedMsg);
				captureToastMsg(driver, groupCreatedMsg, toastMsgClosedBtn, groupCreateText, "Group Created");
				driver.navigate().refresh();
				Thread.sleep(3000);
				/*
				 * if(isDisplayed(driver,DiscardAlertYes)) { javascript(driver,
				 * "arguments[0].click();", DiscardAlertYes); }
				 */
				}
				else {
					BaseSuite.reportFailLog("New groups not created successfully: Test case failed",
							"saveButtonEnabled");
				}

			} 
		else {
				BaseSuite.reportFailLog("New group fields are not editable.", "saveButtonEnabled");
			}
		
			clickOnGroupsMenu();
			inVisible(driver, spinner, Constant.ruleWait);
			searchGroup(NewGroupName);
			String Newgroup = getText(driver, GroupSearchList1);
			if (getText(driver, GroupSearchList1).contains(Newgroup)) 
			{
				BaseSuite.validationReportLog(
						"New groups listed in the group list so it is confirmed that groups created successfully:"
								+ Newgroup);
			} else {
				BaseSuite.reportFailLog("New group not listed in the group list", "createValidGroups");
			}
			isDisplayedInLoop(driver, 30, HomeLink);
			javascript(driver, "arguments[0].click();", HomeLink);
			Thread.sleep(3000);

		}catch(Exception e)
			{
				throw new AssertionError("Error occured in this method", e);
			}
	}

	/*
	 * public void continueNext(String users, String sheetName, String string,
	 * ExtentTest test, int rowNumber, String e1, Logger log, String columnName,
	 * String string2) { // TODO Auto-generated method stub
	 * 
	 * }
	 */
	public void addDiscardUserInExistingGroup(String Group_search, String AssignUserName) throws Exception {
		clickOnGroupsMenu();
		try {

			inVisible(driver, spinner, Constant.ruleWait);
			Thread.sleep(2000);
			BaseSuite.reportLog("Searching the existing group using search bar");
			waitForElement(driver,GroupSearchBar);
			searchGroupAndClick(Group_search);
			isDisplayedInLoop(driver, 40, groupName);
			inVisible(driver, spinner, Constant.ruleWait);
			waitForElement(driver,commonToastMsg);

			captureToastMsg(driver, groupRetriveMsg, toastMsgClosedBtn, RetriveDetailsMsg, "Details retrive");

			BaseSuite.validationReportLog("existing group page is opened");
			isDisplayedInLoop(driver, 30, usersTab);

			if (isEnabled(driver, userAddBtn)) {
				BaseSuite.reportLog("Clicking on add button..");
				click(driver, userAddBtn);
				isDisplayedInLoop(driver, 20, UserAssignLabel);
				BaseSuite.reportLog("User assign pannel displaying..");

				String pannelLabel = getText(driver, UserAssignLabel);
				BaseSuite.validationReportLog("User assign side pannel opened succussfully and name is :" + pannelLabel);						
							
				isDisplayedInLoop(driver,40,addUserTextBox);
				Thread.sleep(2000);
				clear_Click_SendKeys(driver, 30, addUserTextBox, AssignUserName);
				//sendKeys(driver, addUserTextBox, AssignUserName);
				Thread.sleep(2000);
				
				driver.findElement(addUserTextBox).sendKeys(Keys.ENTER);
				isDisplayedInLoop(driver,40,usersAssignBtn);
				click(driver, usersAssignBtn);
				
				inVisible(driver, spinner, Constant.ruleWait);
				waitForElement(driver,commonToastMsg);
				captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, userAssignTxt, "User Assign");
				Thread.sleep(2000);

				BaseSuite.reportLog("Searching for assingned user in the list");
				searchUserAssignInGroup(AssignUserName);
				waitForElement(driver, U_SearchData);
				String AssignUser = getText(driver, U_SearchData);

				if (AssignUser.contains(AssignUserName)) {
					BaseSuite.validationReportLog(
							"User assigned successfully in this group and assigned user is :" + AssignUser);
				} else {
					BaseSuite.reportFailLog("User not assigned in this group", "addDiscardUserInExistingGroup");
				}	
				
				isDisplayedInLoop(driver,30,GrpRemoveUserChk); 
				javascript(driver, "arguments[0].click();", GrpRemoveUserChk); 
				isDisplayedInLoop(driver,20,RemoveAddedUserBtn);
				BaseSuite.reportLog("Clicking on the remove button");
				javascript(driver, "arguments[0].click();", RemoveAddedUserBtn); 
				isDisplayedInLoop(driver,30,UserRemoveBtnClickYes);
				displayAndClick(driver, UserRemoveBtnClickYes);
				
				Thread.sleep(2000);
				isDisplayedInLoop(driver, 30, userAddBtn);
				BaseSuite.reportLog("Again click on add button to discard the user");
				click(driver, userAddBtn);
				isDisplayedInLoop(driver, 30, addUserTextBox);
				clear_Click_SendKeys(driver, 30, addUserTextBox, AssignUserName);
				// sendKeys(driver, addUserTextBox, AssignUserName);
				Thread.sleep(3000);
				driver.findElement(addUserTextBox).sendKeys(Keys.ENTER);
				if (isDisplayed(driver, usersDiscardBtn)) {
					BaseSuite.reportLog("Clicking on discard button..");

					click(driver, usersDiscardBtn);

					isDisplayedInLoop(driver,30,usersDiscardBtn);
					javascript(driver, "arguments[0].click();", usersDiscardBtn); 				

					BaseSuite.validationReportLog("Assign user discarded successfully");
				}
			}

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void deletedGroupVerify(String deletedGroup) throws Exception {
		clickOnGroupsMenu();

		try
		{
			inVisible(driver, spinner, Constant.ruleWait);
			Thread.sleep(3000);
			isDisplayedInLoop(driver, 30, selectGroups);
			List<WebElement> GroupList = driver.findElements(selectGroups);
			int count = GroupList.size();

			BaseSuite.validationReportLog("Total number of groups in list before deletion of groups are: " + count);
			searchGroup(deletedGroup);
			String Searchgroup = getText(driver, GroupSearchList1);
			if (getText(driver, GroupSearchList1).contains(Searchgroup)) 
			{
				BaseSuite.validationReportLog(
						"Searched group listed in the group list and the group name is :" + Searchgroup);
				BaseSuite.reportLog("Deleting the searched group");
				isDisplayedInLoop(driver, 30, selectGroups);
				Thread.sleep(2000);
				click(driver,selectGroups);
				//javascript(driver, "arguments[0].click();", selectGroups);

				isDisplayedInLoop(driver, 20, EnabledDeleteBtn);
				javascript(driver, "arguments[0].click();", EnabledDeleteBtn);
				javascript(driver, "arguments[0].click();", DeleteYesBtn);
				BaseSuite.validationReportLog("Searched Group deleted successfully");
				waitForElement(driver,toastMsgClosedBtn);
				captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, singleGroupDelToastTxt, "Delete group");			
				
			}		
			else
			{

				BaseSuite.reportFailLog("Searched group not listed in the group list", "createValidGroups");
			}
			BaseSuite.reportLog("Searching for the deleted group");
			
			searchGroup(deletedGroup);

			// if(!isDisplayed(driver,GroupSearchList1))
			if (!isAvailableInPage(driver, deletedGroup)) {
				BaseSuite.validationReportLog(
						"User not able to search the deleted group so its verified that group deleted from the list");
			} else {
				BaseSuite.reportFailLog("Group not deleted and it is available in the list", "deletedGroupVerify");
			}
			
			isDisplayedInLoop(driver,30,HomeLink);
			javascript(driver, "arguments[0].click();", HomeLink); 
			Thread.sleep(3000);

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	public void groupSearchWithPagination(String PaginationPoint) throws Exception
	{
		clickOnGroupsMenu();
		try
		{
			Users pagination = new Users(driver);
			pagination.userSearchWithPagination(PaginationPoint);
		}
		catch(Exception e)
		{
			throw new AssertionError("Error occured in this method", e);
		}
	}

	// NK

	// verify by default delete button should be disabled

	public void DeleteButtonDisabledByDefault(SoftAssert softAssert) {
		try {

			log.info(
					"***********************************Method: DeleteButtonDisabledByDefault execution started***********************************");

			/*
			 * isDisplayedInLoop(driver, 20, GroupsSideBarMenu);
			 * BaseSuite.reportLog("Group menu is displayed");
			 * javascript(driver,"arguments[0].click();", GroupsSideBarMenu);
			 * BaseSuite.reportLog("Group menu is clicked");
			 */

			clickOnGroupsMenu();

			// verify if delete button is disable by default
			BaseSuite.reportLog("Verifying delete button is enable or disable");

			if (isDisplayed(driver, GroupDeleteBtn)) {
				// softAssert.assertTrue(!isDisplayed(driver, GroupDeleteBtnn));
				BaseSuite.validationReportLog("Deleted button is disable by default");
			} else {
				softAssert.assertTrue(isDisplayed(driver, GroupDeleteBtnn));
				BaseSuite.reportFailLog("Deleted button is enabled by default", "DeleteButtonDisabledByDefault");
			}

			/*
			 * if (!BtnDelete.isEnabled()) { softAssert.assertTrue(!BtnDelete.isEnabled());
			 * BaseSuite.validationReportLog("Deleted button is disable by default"); } else
			 * if (BtnDelete.isEnabled()) { softAssert.assertFalse(BtnDelete.isEnabled());
			 * BaseSuite.reportFailLog("Deleted button is enabled by default",
			 * "DeleteButtonDisabledByDefault"); }
			 */

			log.info(
					"***********************************Method: DeleteButtonDisabledByDefault execution started***********************************");
		} catch (Exception e) {

		}
	}

	// Verify Delete group button should be enabled if one of group(s) checkbox is
	// selected, and able to delete group.

	public void DeleteButtonIsEnabledAfterselectingGroup(SoftAssert softAssert) {
		WebElement GDeleteBtn;
		boolean flagDeleteVisibility;

		try {
			
			clickOnGroupsMenu();
			isDisplayedInLoop(driver, 30, GsearchTxtbox);
			clear(driver, GsearchTxtbox);

			BaseSuite.reportLog("Verifying delete button is enable or disable");
			Thread.sleep(1000);

			boolean flagD= driver.findElement(GroupDeleteBtnn).isEnabled();
			//GDeleteBtn = driver.findElement(GroupDeleteBtnn);

			if (!flagD) {
				assertFalse(flagD);;
				BaseSuite.validationReportLog("Deleted button is disable by default");
			}

				
			
			Thread.sleep(1000);
			BaseSuite.reportLog("Verifying if search text is displayed.");
			isDisplayedInLoop(driver, 30, GsearchTxtbox);
			BaseSuite.reportLog("Clicking on search text & entering group name to search.");
			javascript(driver, "arguments[0].click();", GsearchTxtbox);
			clear(driver, GsearchTxtbox);

			isDisplayedInLoop(driver, 30, GsearchTxtbox);
			log.info("Searching for group names :: " + groupNamen);
			BaseSuite.reportLog("Searching for group names :: " + groupNamen);
			sendKeys(driver, GsearchTxtbox, groupNamen);

			BaseSuite.reportLog("Verifying if search icon is displayed.");
			isDisplayedInLoop(driver, 20, Gsearchbtn);
			BaseSuite.reportLog("Search icon is displayed.");
			javascript(driver, "arguments[0].click();", Gsearchbtn);
			BaseSuite.reportLog("Clicked on search icon.");
			// select the group

			isDisplayedInLoop(driver, 30, Gsearchbtn);
			// Thread.sleep(1000);
			click(driver, returnElement(chkGroupsearched, "$group", groupNamen));
			// isDisplayedInLoop(driver, GroupDeleteBtnn);
			visible(driver, GroupDeleteBtnn, Constant.ruleWait); // it will wait for visiblility of element
			// Thread.sleep(3000);
			flagDeleteVisibility= isEnabled(driver, GroupDeleteBtnn);
			if (flagDeleteVisibility)
			{
				softAssert.assertTrue(isDisplayed(driver, GroupDeleteBtnn));
				BaseSuite.validationReportLog("Delete button is enabled & now deleting the selected group");
				log.info("Delete button enabled");
				isDisplayed(driver, GroupDeleteBtnn);
				click(driver, GroupDeleteBtnn);
				isDisplayedInLoop(driver, 0, GroupDeleteYes);
				javascript(driver, "arguments[0].click();", GroupDeleteYes);
				waitForElement(driver, toastMsgClosedBtn);
				captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, singleGroupDelToastTxt, "Delete group");	
				BaseSuite.validationReportLog("Selected group ::" + groupNamen + " is deleted successfully");
				isDisplayedInLoop(driver, 30, GsearchTxtbox);
				clear(driver, GsearchTxtbox);

			} else {
				// softAssert.assertTrue(GDeleteBtn.isEnabled());
				BaseSuite.reportFailLog("Delete button is still disabled.", "DeleteButtonIsEnabledAfterselectingGroup");
			}
			
			isDisplayedInLoop(driver, 30, GroupsSideBarMenu);
			javascript(driver, "arguments[0].click();", GroupsSideBarMenu);

		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}

	// Verify admin is able to refresh group listing using refresh button
	public void RefreshButtonRefreshinggroupdata(SoftAssert softAssert) throws InterruptedException {
		int totalcountofCheckedchk = 0, totalcountofUnheckedchk;
		String message;
		log.info(
				"*********************************** Method: RefreshButtonRefreshinggroupdata execution started ***********************************");
		/*
		 * isDisplayedInLoop(driver, 20, GroupsSideBarMenu);
		 * BaseSuite.reportLog("Group menu is displayed"); javascript(driver,
		 * "arguments[0].click();", GroupsSideBarMenu);
		 * BaseSuite.reportLog("Group menu is clicked");
		 */
		clickOnGroupsMenu();
		isDisplayedInLoop(driver, 30, GsearchTxtbox);
		clear(driver, GsearchTxtbox);
		isDisplayedInLoop(driver, 30, GroupRefreshBtn);
		isDisplayedInLoop(driver, 30, GroupSelectAllCheckBox);
		if (isEnabled(driver, GroupRefreshBtn)) {
			log.info("Refresh button is enabled");
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			BaseSuite.reportLog("Refresh button is enabled");
			clear(driver, GsearchTxtbox);
			javascript(driver, "arguments[0].click();", Gsearchbtn);
			BaseSuite.reportLog("checking number of groups available ");
			Thread.sleep(3000);
			WebElement label = driver.findElement(By.xpath("//span[@class='e-pagecountmsg']"));
			message = label.getText();
			// getText(driver, GlabelTotalusers);
			String[] stritems = message.substring(1).split(" ");
			BaseSuite.reportLog("Number of groups available before refresh : " + stritems[0]);
			log.info("Number of groups available before refresh : " + stritems[0]);

			// Clicking checkbox
			isDisplayedInLoop(driver, 30, GroupSelectAllCheckBox);
			javascript(driver, "arguments[0].click()", GroupSelectAllCheckBox);
			BaseSuite.reportLog("Clicking select all group checkbox before refreshing");
			log.info("Clicking select all group checkbox before refreshing");

			totalcountofCheckedchk = getCheckboxSelectionCount(driver, GroupAllCheckboxes);
			BaseSuite.reportLog(
					"Total number of checkboxes which are checked before refresh : " + totalcountofCheckedchk);
			log.info("Number of checkboxes which are checked before refresh : " + totalcountofCheckedchk);

			isDisplayedInLoop(driver, 30, GroupRefreshBtn);
			// Clicking refresh button
			javascript(driver, "arguments[0].click();", GroupRefreshBtn);
			Thread.sleep(2000);
			// driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			totalcountofUnheckedchk = getCheckboxUnSelectionCount(driver, GroupAllCheckboxes);
			BaseSuite.reportLog("Number of checkboxes unchecked after refresh : " + totalcountofUnheckedchk);
			log.info("Number of checkboxes unchecked after refresh : " + totalcountofUnheckedchk);
			// message=getText(driver, GlabelTotalusers);
			stritems = message.substring(1).split(" ");
			BaseSuite.reportLog("Number of groups available after refresh : " + stritems[0]);
			log.info("Number of groups available after refresh : " + stritems[0]);

			softAssert.assertEquals(totalcountofCheckedchk, totalcountofUnheckedchk);

		} else {
			log.info("-Refresh button seems to be disabled, unable to click on refresh button-");
			BaseSuite.reportFailLog("Unable to click refresh button", "RefreshButtonRefreshinggroupdata");
		}

		log.info(
				"*********************************** Method: RefreshButtonRefreshinggroupdata execution ended ***********************************");

	}

	// Verify group should be searched from the List of group.
	public void SearchGroupInGroupListing(SoftAssert softAssert) {
		log.info(
				"***********************************Method: SearchGroupInGroupListing execution started***********************************");
		
		try {
			
			clickOnGroupsMenu();
			log.info("Verifying search functionality");
			createGroupnk(groupNamen, groupDesc);
			Thread.sleep(1000);
			
				searchGroupnk(groupNamen);
				Thread.sleep(1000);
				isDisplayedInLoop(driver, 30, GroupsSideBarMenu);
				javascript(driver, "arguments[0].click();", GroupsSideBarMenu);
				isDisplayedInLoop(driver, 30, GsearchTxtbox);
				clear(driver, GsearchTxtbox);
				
				
			
			

			log.info(
					"***********************************Method: SearchGroupInGroupListing execution Ended***********************************");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	
	// Group details should be displayed correctly after user has been removed from
	// group
	public void GroupDetails_RemoveUserFromGroup(String GroupName, SoftAssert softAssert) {
		
		try {
			// Click on group menu
			
			isDisplayedInLoop(driver, 30, GroupsMenu);
			click(driver, GroupsMenu);
			BaseSuite.validationReportLog("Clicked on the Group Menu");
			
			//search group
			
			searchGroupnk(GroupName);
			
			isDisplayedInLoop(driver, 30, Groupnametxt);
			
			// Assign user to group
			BaseSuite.reportLog("Checking the Users tab");
			isDisplayedInLoop(driver, 30, usersTab);
			BaseSuite.reportLog("Clicking on the User Add button");
			click(driver,UsersTab);
			
			BaseSuite.reportLog("Checking the User Add button");
			isDisplayedInLoop(driver, 30, UsersAddBtn);
			BaseSuite.validationReportLog("Clicked on the User Add button ");
			click(driver, UsersAddBtn);
			
			BaseSuite.reportLog("Verifying the Add users pane");
			isDisplayedInLoop(driver, 30, UsersAddSearchLabel);
			BaseSuite.validationReportLog("Add users pane is opened and displayed");
			
			isDisplayedInLoop(driver, 30, AddUsersTextBox);
			click(driver,AddUsersTextBox);
			BaseSuite.reportLog("Clicked on the Add Users TextBox ");
			
			BaseSuite.reportLog("Entering the details of user");
			driver.findElement(GroupSelectUserDropdown).sendKeys(user);
			driver.findElement(GroupSelectUserDropdown).sendKeys(Keys.ENTER);
			BaseSuite.validationReportLog("Entered User is " + user);
			
			BaseSuite.reportLog("Verifying the Assign user button");
			isDisplayedInLoop(driver, 30, AssignUserBtn);
			BaseSuite.reportLog("Clicking on the Assign button");
			click(driver, AssignUserBtn);
			BaseSuite.validationReportLog("Clicked on Assign User");
			//captureToastMsg(driver, AssignUserToGroupTextMsg, toastMsgClosedBtn,AssignUserToGroupText,"AssignUserToGroup");
			 BaseSuite.validationReportLog("Assigned "+user+" To Group :: " + GroupName);
			Thread.sleep(1000);
			
			// Remove User from group
			
			isDisplayedInLoop(driver, 30, UsersTab);
			click(driver,UsersTab);
			
			BaseSuite.reportLog("Searching for User:" + user);
			isDisplayedInLoop(driver,30, UserSearchTextbox);
			click(driver, UserSearchTextbox);
			clear(driver, UserSearchTextbox);
			
			BaseSuite.reportLog("Searching user to remove");
			sendKeys(driver,UserSearchTextbox, user);
			BaseSuite.reportLog("Click on search button");
			
			isDisplayedInLoop(driver, 30,UserSearchTextboxButton);
			click(driver, UserSearchTextboxButton);
			BaseSuite.reportLog("User searched successfully.");
			
			Thread.sleep(3000);
			
			javascript(driver, "arguments[0].click();", UserCheckbox);
			boolean flagRemovebtn = isEnabled(driver, RemoveAddedUserBtn);
			if(flagRemovebtn)
			{
				javascript(driver,"arguments[0].click();", RemoveAddedUserBtn);
				BaseSuite.reportLog("Clicked on Removed");
				javascript(driver, "arguments[0].click();", UserRemoveBtnClickYes);
				BaseSuite.reportLog("Clicked on removed button - Yes");
				//captureToastMsg(driver, GroupDeletedFromUserMsg, toastMsgClosedBtn,GroupDeletedFromUserText,"User successfully removed from group");
				Thread.sleep(3000);
				BaseSuite.reportLog("Deleted user from the group is " +user);
				System.out.println("**Deleted user from the group is " + user); 
				BaseSuite.validationReportLog(user + " User is removed from the group :: " +GroupName);	
				
			}
			else
			{
				BaseSuite.reportFailLog("Unable to click remove button as its disabled even after selecting user", "GroupDetailsRemoveUserFromGroup");
			}	
			
			BaseSuite.reportLog("Re-verifying that user is removed from group :: " + user);
			isDisplayedInLoop(driver,30, UserSearchTextbox);
			click(driver, UserSearchTextbox);
			BaseSuite.reportLog("Click on search box again.");
			clear(driver, UserSearchTextbox);
			sendKeys(driver,UserSearchTextbox, user);
			BaseSuite.reportLog("Searching for "+user+" again in user tab.");
			isDisplayedInLoop(driver, 30,UserSearchTextboxButton);
			click(driver, UserSearchTextboxButton);
			Thread.sleep(2000);
			isDisplayedInLoop(driver, 30, toolbarText_grp);
			if (isDisplayed(driver, toolbarText_grp)) 
			{
				BaseSuite.validationReportLog(user +" is not found.");
				BaseSuite.validationReportLog(user + ":: is removed from group, not displayed under user tab");

			} 
			
			
		} catch (Exception e)
		{
			 e.getMessage();
			
		}
		
		
	}

	// method for validaing user details page when user is removed from group
	public void User_Details_verified_When_User_Removed_Frm_Grp(SoftAssert soft) {

		
		try {

			Users userObj = new Users(driver);
			GroupDetails_RemoveUserFromGroup(groupNamen, soft);
			
				userObj.clickOnUsersMenu();
				userObj.searchUser(user);
				isDisplayedInLoop(driver, 30, GrpSearchTextboxForUser);
				sendKeys(driver, GrpSearchTextboxForUser, groupNameToSearch);
				isDisplayedInLoop(driver, 30, GrpSearchTextboxClickForUser);
				click(driver, GrpSearchTextboxClickForUser);
				Thread.sleep(2000);
				isDisplayedInLoop(driver, 30, toolbarText);
				if (isDisplayed(driver, toolbarText)) 
				{
					BaseSuite.validationReportLog(groupNameToSearch + ":: from which user is removed, not displayed in user/group tab");

				} 
				
						
			

		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	// Method to check if any checkbox is checked
	public int getCheckboxSelectionCount(WebDriver driver, By locator) {
		boolean selection = false;
		int i = 0, count = 0;
		List<WebElement> grpChk = getElements(driver, locator);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		for (i = 0; i < grpChk.size(); i++) {
			selection = grpChk.get(i).isSelected();
			if (selection == true) {
				count++;
			}

		}

		return count;
	}

	// method to get count of unchecked checkboxes
	public int getCheckboxUnSelectionCount(WebDriver driver, By locator) {
		boolean selection = false;
		int i = 0, count = 0, unchecked = 0;
		List<WebElement> grpChk = getElements(driver, locator);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		for (i = 0; i < grpChk.size(); i++) {
			selection = grpChk.get(i).isSelected();
			if (selection != true) {

				unchecked++;
			}

		}

		return unchecked;
	}

	// method for search group

	public void searchGroupnk(String groupName) {
		//String groupSelected;

		BaseSuite.reportLog("Verifying if search text is displayed.");
		isDisplayedInLoop(driver, 30, GsearchTxtbox);
		BaseSuite.reportLog("Clicking on search text & entering group name to search.");
		javascript(driver, "arguments[0].click();", GsearchTxtbox);
		clear(driver, GsearchTxtbox);

		isDisplayedInLoop(driver, 30, GsearchTxtbox);
		log.info("Searching for group names :: " + groupName);
		BaseSuite.reportLog("Searching for group names :: " + groupName);
		sendKeys(driver, GsearchTxtbox, groupName);

		BaseSuite.reportLog("Verifying if search icon is displayed.");
		isDisplayedInLoop(driver, 20, Gsearchbtn);
		BaseSuite.reportLog("Search icon is displayed.");
		javascript(driver, "arguments[0].click();", Gsearchbtn);
		BaseSuite.reportLog("Clicked on search icon.");

		try {
			isDisplayedInLoop(driver, 20, Gsearchbtn);
			click(driver, returnElement(groupSearchList, "$GroupName", groupName));
			captureToastMsg(driver, GroupDetailsRetrievedMsg, toastMsgClosedBtn, GroupDetailsRetrievedText,"Group Retrived");
			isDisplayedInLoop(driver, 30, Groupnametxt);
			BaseSuite.validationReportLog("Searched group :: " + groupName);
			log.info("Group searched:: " + groupName);
			// capture toast

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean createGroupnk(String grpName, String Gdesc) {

		boolean flagC=false;
		try {
			
			Thread.sleep(2000);
			// BaseSuite.reportLog("Verifying if new group button is displayed");
			isDisplayedInLoop(driver, 30, GNewGrpBtn);
			javascript(driver, "arguments[0].click();", GNewGrpBtn);
			// BaseSuite.reportLog("new group button is clicked");

			isDisplayedInLoop(driver, 30, Groupnametxt);
			clear(driver, Groupnametxt);
			sendKeys(driver, Groupnametxt, grpName);
			isDisplayedInLoop(driver, 30, GrpDescTxt);
			clear(driver, GrpDescTxt);
			sendKeys(driver, GrpDescTxt, Gdesc);

			isDisplayedInLoop(driver, 20, NGrpSavebtn);
			//isEnabled(driver, NGrpSavebtn);
			click(driver, NGrpSavebtn);
			//javascript(driver, "arguments[0].click();", NGrpSavebtn);
			
			boolean created=isDisplayed(driver, GcreationToastMsg);
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ :: "+created);
			flagC=true;
			captureToastMsg(driver, groupCreatedMsg, toastMsgClosedBtn, groupCreateText, "Group Created");	
			
			Thread.sleep(2000);
			isDisplayedInLoop(driver, 20, GroupsSideBarMenu);
			javascript(driver, "arguments[0].click();", GroupsSideBarMenu);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flagC;

	}

	public void deleteGroupnk(String grpName) {
		try {
			
			isDisplayedInLoop(driver, 20, GroupsSideBarMenu);
			javascript(driver, "arguments[0].click();", GroupsSideBarMenu);
			
			isDisplayedInLoop(driver, 30, GsearchTxtbox);
			javascript(driver, "arguments[0].click();", GsearchTxtbox);
			clear(driver, GsearchTxtbox);

			log.info("Searching for group names :: " + groupNamen);
			sendKeys(driver, GsearchTxtbox, groupNamen);
			isDisplayedInLoop(driver, 20, Gsearchbtn);
			javascript(driver, "arguments[0].click();", Gsearchbtn);
			
			isDisplayedInLoop(driver, 0, GrpSearchResult);
			click(driver,GrpSearchResult);
			Thread.sleep(3000);
			boolean flag = isEnabled(driver, GroupDeleteBtnn);
			log.info("************"+flag+"**************");
			if (flag) {
				javascript(driver, "arguments[0].click();", GroupDeleteBtnn);				
				isDisplayedInLoop(driver, 0, GroupDeleteYes);
				javascript(driver, "arguments[0].click();", GroupDeleteYes);

			} else {
				BaseSuite.reportErrorLog("Delete button is still disabled even after selecting group");
			}
			
		}catch (Exception e) {
			e.getMessage();
		}
		
	}


	
	
	public void verifyUserDetailsAfterUserAddedToGroup(String assignUserName, String groupCreateDetails) throws Exception
	{
		BaseSuite.reportLog("Verifying added user to the group in the list");
	
		searchGrp(groupCreateDetails);
		searchUserAssignInGroup(assignUserName);
		click(driver, U_SearchClick);
		Thread.sleep(3000);
		
		BaseSuite.reportLog("Verifying Added Group");
		isDisplayedInLoop(driver, 30, clickOnAddedGroupToUser);
		
		BaseSuite.reportLog("Clicking on the Added User inside the Group");
		click(driver, clickOnAddedGroupToUser);
		BaseSuite.validationReportLog("Clicked on the User!!");
		
		BaseSuite.reportLog("Verifying group details inside the user");
		isDisplayedInLoop(driver, 30, groupDetailsInsideUser);
		
		String grpName = getText(driver, groupDetailsInsideUser);
		if(grpName.equalsIgnoreCase(groupCreateDetails))
		{
			BaseSuite.validationReportLog("User details is displaying correctly after user has been added to group.!!!");
			
		}
		else
		{
			BaseSuite.reportFailLog("Details are not displaying properly", "verifyUserDetailsAfterUserAddedToGroup");
		}
	}
	
	
	

}
