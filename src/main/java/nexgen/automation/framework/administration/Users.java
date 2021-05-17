package nexgen.automation.framework.administration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.server.handler.SendKeys;

import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentTest;
//import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.util.BaseClassUtil;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.util.XLUtils;

public class Users extends PageUtil {
	WebDriver driver;

	public Users(WebDriver driver) {

		this.driver = driver;

	}

	static final Logger log = Logger.getLogger(Users.class);

	By AdministrationLabel = getElementLocator(prop.getProperty("LandingPage.AdministrationLabel"));
	By HomeLink = getElementLocator(prop.getProperty("Users.HomeLink"));
	By UsersLink = getElementLocator(prop.getProperty("Users.UserLink"));
	By AccountName = getElementLocator(prop.getProperty("Users.AccountName"));
	By Sidebar = getElementLocator(prop.getProperty("Users.Sidebar"));

	By UsersMenu = getElementLocator(prop.getProperty("Users.UserMenu"));
	By NewUsersHeader = getElementLocator(prop.getProperty("Users.NewUsersHeader"));
	By RefreshHeader = getElementLocator(prop.getProperty("Users.RefreshHeader"));
	By BlockUserHeader = getElementLocator(prop.getProperty("Users.BlockUserHeader"));
	By DeleteUserHeader = getElementLocator(prop.getProperty("Users.DeleteUserHeader"));
	By DeleteUserHeaderYes = getElementLocator(prop.getProperty("Users.DeleteUserHeaderYes"));
	By SearchUser = getElementLocator(prop.getProperty("Users.SearchUsers"));

	By BlockUserDisabled = getElementLocator(prop.getProperty("Users.BlockUserDisabled"));

	By GridDetailsFullName = getElementLocator(prop.getProperty("Users.GridDetails.FullName"));
	By GridDetailsUserName = getElementLocator(prop.getProperty("Users.GridDetails.UserName"));
	By GridDetailsStatus = getElementLocator(prop.getProperty("Users.GridDetails.Status"));
	By GridDetailsEmail = getElementLocator(prop.getProperty("Users.GridDetails.Email"));
	By GridDetailsSynced = getElementLocator(prop.getProperty("Users.GridDetails.Synced"));
	By GridDetailsIdentity = getElementLocator(prop.getProperty("Users.GridDetails.Identity"));
	By GridDetailsLastModified = getElementLocator(prop.getProperty("Users.GridDetails.LastModified"));

	By SidebarUsers = getElementLocator(prop.getProperty("Users.SideBar.User"));
	By SidebarGroups = getElementLocator(prop.getProperty("Users.SideBar.Groups"));
	By SidebarRoles = getElementLocator(prop.getProperty("Users.SideBar.Roles"));
	By SidebarAccounts = getElementLocator(prop.getProperty("Users.SideBar.Accounts"));
	By SidebarWorkspace = getElementLocator(prop.getProperty("Users.SideBar.Workspace"));
	By tempPassWord = getElementLocator(prop.getProperty("User.TempPassWord"));
	By statusToggle = getElementLocator(prop.getProperty("User.Status"));
	By toolbarAccounts = getElementLocator(prop.getProperty("Users.Toolbar.Accounts"));
	By toolbarGroups = getElementLocator(prop.getProperty("Users.Toolbar.Groups"));
	By toolbarWorkspace = getElementLocator(prop.getProperty("Users.Toolbar.Workspace"));
	By toolbarText = getElementLocator(prop.getProperty("Users.Toolbar.text"));

	// User's Creation
	By pagelabel = getElementLocator(prop.getProperty("Admin.PageLabel"));
	By ClickonAdmin = getElementLocator(prop.getProperty("Admin.Administration"));
	By ClickonCreateuser = getElementLocator(prop.getProperty("Admin.CreateUserButton"));
	By ClickonDiscard = getElementLocator(prop.getProperty("Admin.Discard"));
	public By username = getElementLocator(prop.getProperty("Admin.Username"));
	public By email = getElementLocator(prop.getProperty("Admin.Email"));
	public By firstname = getElementLocator(prop.getProperty("Admin.FirstName"));
	public By lastname = getElementLocator(prop.getProperty("Admin.Lastname"));
	public By password = getElementLocator(prop.getProperty("Admin.Password"));
	public By confirmpassword = getElementLocator(prop.getProperty("Admin.ConfirmPassword"));
	By clickonsave = getElementLocator(prop.getProperty("Admin.SaveUser"));
	By DiscardUser = getElementLocator(prop.getProperty("Admin.DiscardUser"));

	By toggle1 = getElementLocator(prop.getProperty("Admin.ActiveTogglekey"));
	// By userCreatedMsg = getElementLocator(prop.getProperty("UserCreatedMsg"));
	// String userCreateText = prop.getProperty("UserCreateText");
	String userBlockText = prop.getProperty("UserBlockText");
	String toastRetriveMsg = prop.getProperty("ToastRetriveMsg");
	String toastUpdateMsg = prop.getProperty("UserUpdatedText");
	public String toastDeleteAzureADMsg = prop.getProperty("DeleteAzureAdUser");
	public String toastDeleteLocaluser = prop.getProperty("DeleteLocaluser");

	By CommonToastMsg = getElementLocator(prop.getProperty("ToastMsgGet"));
	By toastMsgClosedBtn1 = getElementLocator(prop.getProperty("ToastMsgClosedBtn1"));

	String actualTitle;
	String expectedTitle;

	// Search
	By SearchBar = getElementLocator(prop.getProperty("Admin.searchBar"));
	By SearchClick = getElementLocator(prop.getProperty("Admin.searchBarClick"));
	String searchList1 = prop.getProperty("Admin.searchData");
	String searchList = prop.getProperty("Admin.searchData");

	By searchListed = getElementLocator(prop.getProperty("Admin.searchData"));

	// Pagination search
	By PaginationNext = getElementLocator(prop.getProperty("Users.pagination"));
	By PaginationPre = getElementLocator(prop.getProperty("Users.Paginationpre"));
	By PaginationNumNext = getElementLocator(prop.getProperty("Users.PagninationnumNext"));
	By PaginationNumPre = getElementLocator(prop.getProperty("Users.PaginationnumPre"));
	By PaginationPageNext = getElementLocator(prop.getProperty("Users.PaginationpageNext"));
	By PaginationPageLast = getElementLocator(prop.getProperty("Users.PaginationpageLast"));

	By NumberOfUsers = getElementLocator(prop.getProperty("Users.NumberOfUsers"));
	By Pagination = getElementLocator(prop.getProperty("Users.pagination"));

	// Assigning Group

	By UserGroupTab = getElementLocator(prop.getProperty("Users.GroupTab"));
	By UserAssignBtn = getElementLocator(prop.getProperty("Users.AssignBtn"));
	By UserAssignGroupsLabel = getElementLocator(prop.getProperty("Users.AssignGroupsLabel"));
	By AddGroupTextBox = getElementLocator(prop.getProperty("Users.AddGroupTextbox"));

	By UsersAssignGroupBtn = getElementLocator(prop.getProperty("Users.AssignGroupBtn"));
	By UsersDiscardGroupBtn = getElementLocator(prop.getProperty("Users.DiscardGroupBtn"));

	By AddedGroupDetails = getElementLocator(prop.getProperty("Users.AddedGroupDetails"));

	// Group Search for User

	By GrpSearchTextboxForUser = getElementLocator(prop.getProperty("Users.GrpSearchTextboxForUser"));
	By GrpSearchTextboxClickForUser = getElementLocator(prop.getProperty("Users.GrpSearchTextboxButtonForUser"));

	String GroupSearchData = prop.getProperty("User.GroupSearchData");
	public String SrUser=prop.getProperty("Group.GroupUser");
	public String SrUserGrp=prop.getProperty("Group.SearchGroup");

	By GroupSearchData1 = getElementLocator(prop.getProperty("Users.AddedGroupDetails"));

	// Delete user

	By GrpCheckbox = getElementLocator(prop.getProperty("User.GrpCheckbox"));
	By GrpRemoveBtnClick = getElementLocator(prop.getProperty("User.GrpRemoveBtnClick"));
	By GrpRemoveBtnClickYes = getElementLocator(prop.getProperty("User.GrpRemoveBtnClickYes"));
	By GrpRemoveBtnClickNo = getElementLocator(prop.getProperty("User.GrpRemoveBtnClickNo"));
	By GroupRemoveText = getElementLocator(prop.getProperty("GroupRemoveText"));
	String GroupRemovePopUp = prop.getProperty("SearchUserDetails");

	// Admin User page object

	By secureAdvanceButton = getElementLocator(prop.getProperty("secure.AdvanceButton"));
	By secureProceedtounsafe = getElementLocator(prop.getProperty("secure.Proceedtounsafe"));

	By DiscardAlert = getElementLocator(prop.getProperty("Admin.alertwindow"));
	By Toggle = getElementLocator(prop.getProperty("Admin.togglebutton"));
	By Toggle1 = getElementLocator(prop.getProperty("Admin.togglebutton1"));
	By Loadingtoast = getElementLocator(prop.getProperty("login.LoadingIcon"));
	By Usersclick = getElementLocator(prop.getProperty("Admin.UsersTab"));

	By namelable = getElementLocator(prop.getProperty("Admin.NameLable"));
	By deletebutton = getElementLocator(prop.getProperty("Admin.DeleteTab"));
	By searchbar = getElementLocator(prop.getProperty("Admin.searchBar"));
	By searchclick = getElementLocator(prop.getProperty("Admin.searchBarClick"));
	By deleteT = getElementLocator(prop.getProperty("Admin.DeleteTab"));
	By clickonpopup = getElementLocator(prop.getProperty("Admin.DeletePopup"));
	By Welcometitle = getElementLocator(prop.getProperty("Landingpage.Welcome"));
	By numberOfCount = getElementLocator(prop.getProperty("User.NumberOfCount"));

	By Blocklabel = getElementLocator(prop.getProperty("Users.BlockLabel"));
	By SelectCheckboxes = getElementLocator(prop.getProperty("Users.Checkboxes"));
	By BlockYes = getElementLocator(prop.getProperty("Users.Blockyes"));
	By SelectAllCheckboxes = getElementLocator(prop.getProperty("Users.CheckAllUser"));
	By DeleteAzureADButton = getElementLocator(prop.getProperty("Users.DeleteAzureADButton"));
	By ClickTempPass = getElementLocator(prop.getProperty("User.TempPassWord_No"));
	By SaveUserButton = getElementLocator(prop.getProperty("User.SaveuserButton"));
	By UpdateToastMess = getElementLocator(prop.getProperty("User.UpdateToastMess"));
	By DeleteUserToastMess = getElementLocator(prop.getProperty("User.DeleteUserToastMess"));
	By StatusToggleButton = getElementLocator(prop.getProperty("User.StatusActiveButton"));
	By StatusBlockTogButton = getElementLocator(prop.getProperty("User.StatusBlockedButton"));
	By StatusBlockedBtn= getElementLocator(prop.getProperty("User.StatusBlockedBtnBlock"));
	String searchdataclick = prop.getProperty("Admin.searchdata");
	By TempPassWord_No = getElementLocator(prop.getProperty("User.TempPassWord_No"));
	By TempPassWord_Yes = getElementLocator(prop.getProperty("User.TempPassWord_Yes"));
	By DiscardButton = getElementLocator(prop.getProperty("User.DiscardButton"));
	By DiscardAlertYes = getElementLocator(prop.getProperty("User.DiscardYesAlert"));
	By DiscardAlertNo = getElementLocator(prop.getProperty("User.DiscardNoAlert"));
	By DiscardMsg = getElementLocator(prop.getProperty("User.DiscardMsg"));
	By RetriverMsg = getElementLocator(prop.getProperty("User.UserDetailsRetriveMsg"));
	By WorkspaceLabel = getElementLocator(prop.getProperty("User.WorkspaceLabel"));
	By WorkspaceNameLabel = getElementLocator(prop.getProperty("User.WorkspaceNameLabel"));
	By WorkspaceRoleLabel = getElementLocator(prop.getProperty("User.WorkspaceRoleLabel"));
	By WorkspaceTypeLabel = getElementLocator(prop.getProperty("User.WorkspaceTypeLabel"));
	By WorkspaceAccountLabel = getElementLocator(prop.getProperty("User.WorkspaceAccountLabel"));
	By WorkspaceScopeLabel = getElementLocator(prop.getProperty("User.WorkspaceScopeLabel"));
	By WorkspaceNameList = getElementLocator(prop.getProperty("User.AssignedWorkspacesList"));
	By W_SearchBar = getElementLocator(prop.getProperty("W_SearchBar"));
	By W_SearchClick = getElementLocator(prop.getProperty("W_SearchiconButton"));

	By AccountLabel = getElementLocator(prop.getProperty("User.AccountLabel"));
	By AccountNameLabel = getElementLocator(prop.getProperty("User.AccountNameLabel"));
	By AccountRoleLabel = getElementLocator(prop.getProperty("User.AccountRoleLabel"));
	By AccountScopeLabel = getElementLocator(prop.getProperty("User.AccountScopeLabel"));
	By AccountNameList = getElementLocator(prop.getProperty("User.AssignedAccountList"));

	By GroupLabel = getElementLocator(prop.getProperty("User.GroupLabel"));
	By GroupNameLabel = getElementLocator(prop.getProperty("User.GroupNameLabel"));
	By GroupPathLabel = getElementLocator(prop.getProperty("User.GroupPathLabel"));
	By GroupNameList = getElementLocator(prop.getProperty("User.AssignedGroupList"));
	By G_SearchBar = getElementLocator(prop.getProperty("G_SearchBar"));
	By G_SearchClick = getElementLocator(prop.getProperty("G_SearchiconButton"));

	// Nehas locator

	By BtnSave_newUser = getElementLocator(prop.getProperty("User.Savebtn"));
	By UserUsername = getElementLocator(prop.getProperty("User.Username"));
	By UserEmail = getElementLocator(prop.getProperty("User.Email"));
	By UFirstname = getElementLocator(prop.getProperty("User.Firstname"));
	By ULastname = getElementLocator(prop.getProperty("User.LastName"));
	By UPassword = getElementLocator(prop.getProperty("User.Password"));
	By UCPassword = getElementLocator(prop.getProperty("User.CPassword"));
	By UDiscardBtn = getElementLocator(prop.getProperty("User.DiscardBtn"));
	By UDiscardYesOpt = getElementLocator(prop.getProperty("User.DiscardYesOpt"));
	By UBlockBtn = getElementLocator(prop.getProperty("User.BlockBtn"));
	By USelectChk = getElementLocator(prop.getProperty("User.SelectionChk"));
	By UCountOfPages = getElementLocator(prop.getProperty("User.CountOfPages"));
	By UDeleteBtn = getElementLocator(prop.getProperty("User.DeleteBtn"));
	By UpaginationLastBtn = getElementLocator(prop.getProperty("User.PagLastBtn"));
	By UpaginationNextBtn = getElementLocator(prop.getProperty("User.PagNextLbtn"));
	By UpaginationPreBtn = getElementLocator(prop.getProperty("User.PagPreBtn"));
	By UpaginationFirstBtn = getElementLocator(prop.getProperty("User.PagFirstbtn"));
	By UselectAllChk = getElementLocator(prop.getProperty("User.SelectAll"));
	By UCheckBoxToSelect = getElementLocator(prop.getProperty("User.CheckboxGrid"));
	By UselectAllChkF = getElementLocator(prop.getProperty("User.SelectAllFocus"));
	By UlabelPages = getElementLocator(prop.getProperty("User.LabelNoPages"));
	By UlabelTUser = getElementLocator(prop.getProperty("User.LabelTotalUser"));
	By selectAllCheckbox = getElementLocator(prop.getProperty("Roles.SelectAllCheckbox"));
	By singleCheckbox = getElementLocator(prop.getProperty("User.SingleCheckbox"));

	// Discard User details
	public String Username = prop.getProperty("User.D_Username");
	public String Email11 = prop.getProperty("User.D_Email");
	public String FirstName = prop.getProperty("User.D_Firstname");
	public String LastName = prop.getProperty("User.D_Lastname");
	public String Password11 = prop.getProperty("User.D_Password");
	public String ConfirmPassword11 = prop.getProperty("User.D_ConfirmPass");
	public String TemporaryPass = prop.getProperty("User.D_TempPass");
	public String DiscaralertYes = prop.getProperty("User.D_DiscardAlert");
	public String User_search = prop.getProperty("User.D_SearchExistingUser");
	public String Workspace_search = prop.getProperty("W_SearchWorkspace");
	public String Account_search = prop.getProperty("A_SearchAccount");
	public String Group_search = prop.getProperty("G_SearchGroup");
	public String RetriveDetailsMsg = prop.getProperty("RetriveUserDetails");

	// Blocked user as status Blocked without temp pass
	public String SearchBlockedUserTemp = prop.getProperty("BlockedUser");
	public String Username1 = prop.getProperty("User.B_Username");
	public String BlockEmail = prop.getProperty("User.B_Email");
	public String BlockFirstName = prop.getProperty("User.B_Firstname");
	public String BlockLastName = prop.getProperty("User.B_Lastname");
	public String BlockPassword = prop.getProperty("User.B_Password");
	public String BlockConfirmPassword = prop.getProperty("User.B_ConfirmPass");
	public String TemporaryPass1 = prop.getProperty("User.B_TempPass");
	public String BlockedStatus = prop.getProperty("User.B_StatusBlocked");
	public String Search_user1 = prop.getProperty("User.B_SearchNewUser");

	// Blocked user as status Blocked with temp pass
	public String SearchBlockedUserTemp2 = prop.getProperty("BlockedUser");
	public String Username2 = prop.getProperty("User.BWTP_Username");
	public String Email2 = prop.getProperty("User.BWTP_Email");
	public String FirstName2 = prop.getProperty("User.BWTP_Firstname");
	public String LastName2 = prop.getProperty("User.BWTP_Lastname");
	public String Password2 = prop.getProperty("User.BWTP_Password");
	public String ConfirmPassword2 = prop.getProperty("User.BWTP_ConfirmPass");
	public String TemporaryPass2 = prop.getProperty("User.BWTP_TempPass");
	public String BlockedStatus2 = prop.getProperty("User.BWTP_StatusBlocked");
	public String Search_user2 = prop.getProperty("User.BWTP_SearchNewUser");

	// Search Created User
	public String User_search1 = prop.getProperty("User.BWTP_SearchNewUser");

	// AzureAD User
	public String AzureADUser = prop.getProperty("User.D_SearchExistingAzureADUser");
	public String DeleteAzureADUser = prop.getProperty("User.deleteAzureADUser");
	String updateAzureADMsg = prop.getProperty("UpdateAzureADMsg");

	// Local User
	public String DeleteLocalUser = prop.getProperty("LocalUser");

	// Block Multiple User
	public String Block_users = prop.getProperty("User.Blockusers");

	// String searchdataclick = prop.getProperty("Admin.searchdata");
	String SearchUserDetails = prop.getProperty("SearchUserDetails");

	String SelectGroupsToAssignText = prop.getProperty("SelectGroupsToAssignText");
	By SelectGroupsToAssignMsg = getElementLocator(prop.getProperty("SelectGroupsToAssignMsg"));

	String UserDetailsRetrivedText = prop.getProperty("UserDetailsRetrivedText");
	By UserRetrivedMsg = getElementLocator(prop.getProperty("UserRetrivedMsg"));

	String UserDeletedFromGroupText = prop.getProperty("UserDeletedFromGroupText");
	By UserDeletedFromGroupMsg = getElementLocator(prop.getProperty("UserDeletedFromGroupMsg"));

	public By UserNameSpecialCharVal = getElementLocator(prop.getProperty("User.UserNameSpecialCharVal"));
	public By UserNameMandatoryVal = getElementLocator(prop.getProperty("User.UserNameMandatoryVal"));
	public By ExceedCharValMsg = getElementLocator(prop.getProperty("User.ExceedCharValMsg"));
	public By EmailSpecialCharVal = getElementLocator(prop.getProperty("User.EmailSpecialCharVal"));
	public By EmailMandatoryVal = getElementLocator(prop.getProperty("User.EmailMandatoryVal"));
	public By FirstNameMandatoryVal = getElementLocator(prop.getProperty("User.FirstNameMandatoryVal"));
	public By LastNameMandatoryVal = getElementLocator(prop.getProperty("User.LastNameMandatoryVal"));
	public By PasswordNameMandatoryVal = getElementLocator(prop.getProperty("User.PasswordNameMandatoryVal"));
	public By ConfPasswordNameMandatoryVal = getElementLocator(prop.getProperty("User.ConfPasswordNameMandatoryVal"));
	public By UserNameLabel = getElementLocator(prop.getProperty("User.UserNameLabel"));
	public By EmailLabel = getElementLocator(prop.getProperty("User.EmailLabel"));
	public By FirstNameLabel = getElementLocator(prop.getProperty("User.FirstNameLabel"));
	public By LastNameLabel = getElementLocator(prop.getProperty("User.LastNameLabel"));
	public By PasswordLabel = getElementLocator(prop.getProperty("User.PasswordLabel"));
	public By ConfirmPasswordLabel = getElementLocator(prop.getProperty("User.ConfirmPasswordLabel"));

	public String UsernameSpecialCharError = prop.getProperty("UsernameSpecialCharError");
	public String EmailSpecialCharError = prop.getProperty("EmailSpecialCharError");
	public String UserNameMandatoryText = prop.getProperty("UserNameMandatoryText");
	public String EmailMandatoryText = prop.getProperty("EmailMandatoryText");
	public String FirstnameMandatoryText = prop.getProperty("FirstnameMandatoryText");
	public String LastnameMandatoryText = prop.getProperty("LastnameMandatoryText");
	public String PasswordMandatoryText = prop.getProperty("PasswordMandatoryText");
	public String ConfirmPasswordeMandatoryText = prop.getProperty("ConfirmPasswordeMandatoryText");

	public String NameExceedCharErrorMsgText = prop.getProperty("NameExceedCharErrorMsgText");
	public String ExceedCharactersTextDetails = prop.getProperty("ExceedCharactersTextDetails");

	public String EmailDetails = prop.getProperty("Email");
	public String FirstNameSpecialChar = prop.getProperty("FirstNameSpecialChar");
	public String LastNameSpecialChar = prop.getProperty("LastNameSpecialChar");

	String userCreateText = prop.getProperty("UserCreateText");
	By userCreatedMsg = getElementLocator(prop.getProperty("UserCreatedMsg"));
	By toastMsgClosedBtn = getElementLocator(prop.getProperty("ToastMsgClosedBtn"));

	String UserAddedToGroupText = prop.getProperty("UserAddedToGroupText");
	By UserAddedToGroupMsg = getElementLocator(prop.getProperty("UserAddedToGroupMsg"));

	// UserCreation Details from config file

	public String UsernameDetails = prop.getProperty("Users.userNameDetails");
	public String Email = prop.getProperty("User.email");
	public String UserFirstName = prop.getProperty("Users.firstName");
	public String UserLastName = prop.getProperty("Users.lastName");
	public String Password = prop.getProperty("Users.password");
	public String ConfirmPassword = prop.getProperty("Users.confirmPassword");

	public String UsernameDetails1 = prop.getProperty("Users.userNameDetails1");
	public String Email1 = prop.getProperty("User.email1");
	public String FirstName1 = prop.getProperty("Users.firstName1");
	public String LastName1 = prop.getProperty("Users.lastName1");
	public String Password1 = prop.getProperty("Users.password1");
	public String ConfirmPassword1 = prop.getProperty("Users.confirmPassword1");

	public String userName = prop.getProperty("userName");
	public String assignGroupName = prop.getProperty("assignGroupName");

	public String userSearch = prop.getProperty("userSearch");
	public String groupSearch = prop.getProperty("groupSearch");

	public String updatedemail = prop.getProperty("Updatedemail");
	public String updatedfirstname = prop.getProperty("Updatedfirstname");
	public String updatedlastname = prop.getProperty("Updatedlastname");
	public String updatedpassword = prop.getProperty("Updatedpassword");
	public String updatedconfirmpassword = prop.getProperty("Updatedconfirmpassword");
	public String tempPass = prop.getProperty("tempPass");
	public String status = prop.getProperty("status");
	public String LocalUser_search = prop.getProperty("LocalUser_search");

	By NewUserInput = getElementLocator(prop.getProperty("NewUserInput"));
	By NewUserButtons = getElementLocator(prop.getProperty("NewUserButtons"));

	
	String duplicateUserValidationText = prop.getProperty("duplicateUserValidationText");
	By duplicateUserValidationMsg = getElementLocator(prop.getProperty("duplicateUserValidationMsg"));
	
	By deleteUserBtn = getElementLocator(prop.getProperty("deleteUserBtn"));
	By deleteUserYes = getElementLocator(prop.getProperty("deleteUserYes"));

	
	// Group Menu click
	By GroupsMenu = getElementLocator(prop.getProperty("Groups.GroupsSideBar"));

	By spinner = getElementLocator(prop.getProperty("Spinner"));

	public String searchUser = prop.getProperty("SearchUser");
	
	By commonToastMsg = getElementLocator(prop.getProperty("Commontoastmsg"));
	String nonAdminValidationText = prop.getProperty("nonAdminValidationText");

	
	
	
	
	
	
	
	
	
	
//**************** Methods *************
	public void clickOnGroupsMenu() {
		isDisplayedInLoop(driver, 60, GroupsMenu);
		click(driver, GroupsMenu);

		BaseSuite.reportLog(" Clicked on the Group menu!");
	}

	public void userPageUIDetails() throws InterruptedException {

		BaseSuite.reportLog("Checking the User Page UI details.....");

		String userPageDetails = "Home Link/User Link/Users Menu/New User Option/Refresh Button/Block User/Delete Button/Search User";

		/*
		 * if ((isDisplayed(driver, HomeLink)) && (isDisplayed(driver, UsersLink)) &&
		 * (isDisplayed(driver, UsersMenu)) && (isDisplayed(driver, NewUsersHeader)) &&
		 * (isDisplayed(driver, RefreshHeader)) && (isDisplayed(driver,
		 * BlockUserHeader)) && (isDisplayed(driver, DeleteUserHeader)) &&
		 * (isDisplayed(driver, SearchUser))) {
		 * BaseSuite.validationReportLog("Links, Menus and Buttons are dispayed!");
		 * BaseSuite.reportLog(userPageDetails +
		 * " details of Users page are displayed!");
		 * 
		 * } else { BaseSuite.reportFailLog(userPageDetails +
		 * " are not displaying in the page", "userPageUIDetails"); }
		 */

		if ((isDisplayed(driver, HomeLink)) && (isDisplayed(driver, UsersLink)) && (isDisplayed(driver, UsersMenu))
				&& (isDisplayed(driver, NewUsersHeader)) && (isDisplayed(driver, RefreshHeader))
				&& (isDisplayed(driver, BlockUserHeader)) && (isDisplayed(driver, DeleteUserHeader))
				&& (isDisplayed(driver, SearchUser))) {
			BaseSuite.reportLog(userPageDetails + " details of Users page are displayed!");
			BaseSuite.validationReportLog("Links, Menus and Buttons are dispayed!");

		} else {
			BaseSuite.reportFailLog(userPageDetails + " are not displaying in the page", "userPageUIDetails");
		}

	}

	public void homeLinkClickFromUserPage() throws InterruptedException {
		clickOnUsersMenu();

		if (isDisplayed(driver, HomeLink)) {
			click(driver, HomeLink);
			isDisplayedInLoop(driver, 10, AdministrationLabel);
			click(driver, AdministrationLabel);
			BaseSuite.reportLog("Home Link is displayed and clickable--Navigation to Home link from user is working");
		} else {
			BaseSuite.reportFailLog("Home Link is not displayed and clickable", "homeLinkClickFromUserPage");
		}
	}

	public void userPageGridDetailsInfo() throws InterruptedException {

		String gridDetails = "FullName/Username/Status/Email/Synced/Identity/LastModified grid details";

		BaseSuite.reportLog("Checking grid columns in the User Page!");

		if ((isDisplayed(driver, GridDetailsFullName)) && (isDisplayed(driver, GridDetailsUserName))
				&& (isDisplayed(driver, GridDetailsStatus)) && (isDisplayed(driver, GridDetailsEmail))
				&& (isDisplayed(driver, GridDetailsSynced)) && (isDisplayed(driver, GridDetailsIdentity))
				&& (isDisplayed(driver, GridDetailsLastModified))) {

			BaseSuite.validationReportLog(gridDetails + " columns are displayed properly in the User Page!");

		} else {
			BaseSuite.reportFailLog(gridDetails + " some columns are missing from the Users Page",
					"userPageGridDetailsInfo");
		}

	}

	public void checkSideBarMenus() {
		isDisplayed(driver, Sidebar);
		click(driver, Sidebar);
		BaseSuite.reportLog("Click on the side bar!");
		if ((isDisplayed(driver, SidebarUsers)) && (isDisplayed(driver, SidebarGroups))
				&& (isDisplayed(driver, SidebarRoles)) && (isDisplayed(driver, SidebarAccounts))
				&& (isDisplayed(driver, SidebarWorkspace))) {

			BaseSuite.reportLog("Side bar details are displayed properly in the User Page!");
			click(driver, Sidebar);
			BaseSuite.reportLog("Click on the side bar to open the side bar!");

			if ((isDisplayed(driver, SidebarUsers)) && (isDisplayed(driver, SidebarGroups))
					&& (isDisplayed(driver, SidebarRoles)) && (isDisplayed(driver, SidebarAccounts))
					&& (isDisplayed(driver, SidebarWorkspace))) {
				BaseSuite.reportLog(
						"Opening and closing of side bar is working and displaying the Users/Groups/Roles/Accounts/Workspace Menus!");
			}

		} else {
			BaseSuite.reportFailLog("Side bar details are not displayed properly in the User Page!",
					"checkSideBarMenus");
		}
	}

	public boolean checkBlockUserDisabled() {
		boolean flag = false;

		if (isDisplayed(driver, BlockUserDisabled)) {
			BaseSuite.reportLog("Block user button is disabled");
			flag = true;
		} else {
			BaseSuite.reportLog("Block user button is enabled");
		}
		return flag;
	}

	public boolean Createuser1(SoftAssert softAssert, String Username, String Email, String FirstName, String LastName,
			String Password, String ConfirmPassword, String InvalidDetails, String ValidDetails) {
		boolean flag = false;
		// boolean AzureLabel = isDisplayed(driver, username);
		// softAssert.assertTrue(AzureLabel);
		try {

			/*
			 * String browserInfo = BaseSuite.browserName.toLowerCase();
			 *
			 * if ((browserInfo != null) && (!browserInfo.contains("head"))) {
			 * navigatetoAppPage(); }
			 */
			isDisplayedInLoop(driver, 5, pagelabel);
			if (isDisplayed(driver, ClickonAdmin)) {
				flag = true;
				click(driver, ClickonAdmin);
				BaseSuite.reportLog("User able to click on Administration tab");

				isDisplayedInLoop(driver, 5, ClickonCreateuser);
				click(driver, ClickonCreateuser);
				BaseSuite.reportLog("User clicked on the create new user tab");
			}

			if (actualTitle == expectedTitle) {
				flag = true;
				actualTitle = driver.getTitle();
				expectedTitle = "Nextgenicedq";
				assertEquals(expectedTitle, actualTitle);

				isDisplayedInLoop(driver, 2, username);
				clear_Click_SendKeys(driver, 2, username, Username);
				clear_Click_SendKeys(driver, 2, email, Email);
				clear_Click_SendKeys(driver, 2, firstname, FirstName);
				clear_Click_SendKeys(driver, 2, lastname, LastName);
				clear_Click_SendKeys(driver, 2, password, Password);
				clear_Click_SendKeys(driver, 2, confirmpassword, ConfirmPassword);

				if (InvalidDetails.equalsIgnoreCase("Invalid")) {
					flag = true;
					click(driver, ClickonDiscard);
					isDisplayedInLoop(driver, 2, ClickonCreateuser);
					click(driver, ClickonCreateuser);
					BaseSuite.reportLog("User clicked on the create new user tab");

					if (ValidDetails.equalsIgnoreCase("Valid")) {
						flag = true;
						List<WebElement> togg = driver.findElements(toggle1);
						for (WebElement tag : togg) {
							if (tag.isEnabled()) {
								tag.click();
							} else if (!tag.isEnabled()) {
								tag.click();
							}
						}

						click(driver, clickonsave);

					} else {
						BaseSuite.reportLog("User not able to create a new user");
					}
				}

			}
		} catch (Exception ex) {
			throw new AssertionError("User not able to navigate on the create new user page", ex);
		}
		return flag;
	}

	/*
	 * public void continueNext(String aDSignIn, String sheetName, String string,
	 * ExtentTest test, int rowNumber, String e1, Logger log, String columnName,
	 * String string2) { // TODO Auto-generated method stub
	 * 
	 * }
	 */

	public boolean verifyNumberOfRowsAndColumns() {

		isDisplayed(driver, UsersMenu);
		click(driver, UsersMenu);

		// No.of Columns
		List col = driver.findElements(By.xpath(".//span[@class='e-headertext']"));

		System.out.println("No of cols are : " + col.size());

		// No.of rows
		List rows = driver.findElements(By.xpath("//tr//span[@class='e-frame e-icons']"));

		System.out.println("No of rows are : " + rows.size());

		return true;

	}

	
	public void holdsAfterLogin() throws InterruptedException
	{
		Thread.sleep(5000);
	}
	
	public void searchUser(String User_search) throws Exception {

		BaseSuite.reportLog("Searching for User: " + User_search);
		isDisplayedInLoop(driver, 30, SearchBar);
		javascript(driver, "arguments[0].click();", SearchBar);
		clear(driver, SearchBar);

		isDisplayedInLoop(driver, 30, SearchBar);
		BaseSuite.reportLog("Entering the user details....");
		sendKeys(driver, SearchBar, User_search);
		BaseSuite.reportLog("Click On searched");

		isDisplayedInLoop(driver, 30, SearchClick);
		javascript(driver, "arguments[0].click();", SearchClick);

		Thread.sleep(3000);
		try {

			isDisplayedInLoop(driver, 30, SearchClick);

			BaseSuite.reportLog("Click on Searched User");
			click(driver, returnElement(searchList, "$User", User_search));
			BaseSuite.validationReportLog("Clicked on User: " + User_search);
			BaseSuite.reportLog("User Details retrieved successfully for user " + User_search);
			waitForElement(driver, toastMsgClosedBtn);
			captureToastMsg(driver, UserRetrivedMsg, toastMsgClosedBtn, UserDetailsRetrivedText,
					"User detail retrieved");

		} catch (Exception e) {
			throw new Exception("User_search " + SearchClick + " not found");
		}
	}

	public void numberOfUsersAndPagination() throws InterruptedException {

		clickOnUsersMenu();

		BaseSuite.reportLog("Checking number of available users ");
		isDisplayedInLoop(driver, 10, NumberOfUsers);
		Thread.sleep(3000);
		String numbers = getText(driver, NumberOfUsers);

		System.out.println("Number of users in the list are " + numbers);
		BaseSuite.reportLog("Available Users " + numbers);

		paginationInsearchfield(driver, Pagination);

	}

	public void defaultUserPageVerification() {

		BaseSuite.reportLog("Verifying New Button in the User page");

		boolean newUserButton = isEnabled(driver, NewUsersHeader);

		if (newUserButton) {
			BaseSuite.validationReportLog("New User creation button is enabled");
		} else {
			BaseSuite.reportFailLog("New User creation button is disabled", "defaultUserPageVerification");
		}

		BaseSuite.reportLog("Verifying Refresh Button in the User page");

		boolean refreshButton = isEnabled(driver, RefreshHeader);

		if (refreshButton) {
			BaseSuite.validationReportLog("Refresh button is enabled");

		} else {

			BaseSuite.reportFailLog("Refresh button is disabled", "defaultUserPageVerification");
		}

		BaseSuite.reportLog("Verifying Block user Button in the User page");

		boolean yes = isDisplayed(driver, BlockUserHeader);

		if (yes) {
			BaseSuite.validationReportLog("Block user button is disabled");
		} else {

			BaseSuite.reportFailLog("Block user button is enabled", "defaultUserPageVerification");
		}

		BaseSuite.reportLog("Verifying Delete button in the User Page");

		boolean deleteUser = isDisplayed(driver, DeleteUserHeader);

		if (deleteUser) {

			BaseSuite.validationReportLog("Delete user button is disabled ");

		} else {

			BaseSuite.reportFailLog("Delete user button is enabled", "defaultUserPageVerification");
		}

	}

	public void displayAndClick(By locator) {

		try {

			isDisplayedInLoop(driver, 20, locator);

			click(driver, locator);

		} catch (Exception e) {

			e.getMessage();
		}
	}

	public void searchAssignGroup(String assignGroupName) {

		clear(driver, AddGroupTextBox);

		isDisplayedInLoop(driver, 14, AddGroupTextBox);

		clear_Click_SendKeys(driver, 2, AddGroupTextBox, assignGroupName);

		displayAndClick(AddGroupTextBox);

	}

	public void addGroupToNewUser(String assignGrpName) throws Exception {

		isDisplayedInLoop(driver, 20, UserGroupTab);
		click(driver, UserGroupTab);

		isDisplayedInLoop(driver, 20, UserAssignBtn);
		click(driver, UserAssignBtn);

		isDisplayedInLoop(driver, 20, UserAssignGroupsLabel);

		isDisplayedInLoop(driver, 20, AddGroupTextBox);
		displayAndClick(AddGroupTextBox);

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@class='e-dropdownbase']")).sendKeys(assignGrpName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='e-dropdownbase']")).sendKeys(Keys.ENTER);

		click(driver, UsersAssignGroupBtn);
		Thread.sleep(2000);

		if (getText(driver, AddedGroupDetails).equals(assignGrpName)) {
			System.out.println("Added Group is " + assignGrpName);
		}

		else {
			System.out.println("Added group is not proper " + assignGrpName);
		}
	}

	public void createUser() throws InterruptedException {
		clickOnUsersMenu();
		isDisplayedInLoop(driver, 25, NewUsersHeader);
		
		click(driver, NewUsersHeader);
		Thread.sleep(3000);
		

		clear_Click_SendKeys(driver, 30, username, "DuplicateUserTest");
		clear_Click_SendKeys(driver, 30, email, "DuplicateUserTest@gmail.com");
		clear_Click_SendKeys(driver, 30, firstname, "DuplicateUser");
		clear_Click_SendKeys(driver, 30, lastname, "Test");
		clear_Click_SendKeys(driver, 30, password, "123");
		clear_Click_SendKeys(driver, 30, confirmpassword, "123");

		isDisplayed(driver, clickonsave);
		click(driver, clickonsave);
		Thread.sleep(2000);
	}
	
	public void validateDuplicateUserCreation() throws Exception
	{
		createUser();
		captureToastMsg(driver, duplicateUserValidationMsg, toastMsgClosedBtn, duplicateUserValidationText, "Username already exist");
		driver.navigate().refresh();
		clickOnUsersMenu();
		searchUserAndClick("DuplicateUserTest");
		
		isDisplayedInLoop(driver, 30, deleteUserBtn);
		click(driver, deleteUserBtn);
		Thread.sleep(2000);
		isDisplayedInLoop(driver, 30, deleteUserYes);
		click(driver, deleteUserYes);
		Thread.sleep(5000);
		
	}

	public void userAssignToGroup(String userName, String assignGrpName, SoftAssert soft) throws Exception {

		searchUser(userName);

		Thread.sleep(3000);

		BaseSuite.reportLog("Checking the Group tab");
		isDisplayedInLoop(driver, 30, UserGroupTab);
		click(driver, UserGroupTab);
		BaseSuite.validationReportLog("Clicked on the Group tab");

		BaseSuite.reportLog("Checking the Assign button");
		isDisplayedInLoop(driver, 30, UserAssignBtn);
		click(driver, UserAssignBtn);
		BaseSuite.validationReportLog("Clicked on the Assign button");

		BaseSuite.reportLog("Checking the Assign Grooup pane");
		isDisplayedInLoop(driver, 30, UserAssignGroupsLabel);

		BaseSuite.reportLog("Checking the Add Group TextBox");
		isDisplayedInLoop(driver, 30, AddGroupTextBox);
		displayAndClick(AddGroupTextBox);
		BaseSuite.validationReportLog("Clicked on the Add Group Textbox");

		Thread.sleep(2000);

		BaseSuite.reportLog("Entering the group name details..");
		sendKeys(driver, AddGroupTextBox, assignGrpName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='e-dropdownbase']")).sendKeys(Keys.ENTER);

		BaseSuite.reportLog("Entered group is:::" + assignGrpName);
		BaseSuite.validationReportLog("Group name details are entered");

		isDisplayedInLoop(driver, 30, UsersAssignGroupBtn);
		click(driver, UsersAssignGroupBtn);
		BaseSuite.reportLog("Clicked on the Assign button");
		Thread.sleep(2000);

		captureToastMsg(driver, UserAddedToGroupMsg, toastMsgClosedBtn, UserAddedToGroupText, "User added to group");
	}

	public void discardAddingOfGroupForUser(String assignGrpName) throws Exception {
		searchUser("Vivek Ramteke");
		isDisplayedInLoop(driver, 30, UserGroupTab);
		click(driver, UserGroupTab);

		isDisplayedInLoop(driver, 30, UserAssignBtn);
		click(driver, UserAssignBtn);

		isDisplayedInLoop(driver, 30, UserAssignGroupsLabel);

		isDisplayedInLoop(driver, 30, AddGroupTextBox);
		displayAndClick(AddGroupTextBox);

		Thread.sleep(2000);

		BaseSuite.reportLog("Clicked on the group search bar");

		driver.findElement(By.xpath("//input[@class='e-dropdownbase']")).sendKeys(assignGrpName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='e-dropdownbase']")).sendKeys(Keys.ENTER);

		BaseSuite.reportLog("Added group is " + assignGrpName);

		click(driver, UsersDiscardGroupBtn);

		BaseSuite.reportLog("Group adding for user has been discarded");

	}

	public void searchAssignGroupForUserAndClick(String Grp_search) throws Exception {

		searchUser("Vivek Ramteke");

		isDisplayedInLoop(driver, 14, UserGroupTab);
		click(driver, UserGroupTab);

		BaseSuite.reportLog("Searching for Group: " + Grp_search);
		isDisplayedInLoop(driver, 30, GrpSearchTextboxForUser);
		click(driver, GrpSearchTextboxForUser);
		clear(driver, GrpSearchTextboxForUser);

		isDisplayedInLoop(driver, 30, GrpSearchTextboxForUser);
		BaseSuite.reportLog("Search Group Name");
		sendKeys(driver, GrpSearchTextboxForUser, Grp_search);

		BaseSuite.reportLog("Searched Group is " + Grp_search);

		isDisplayedInLoop(driver, 30, GrpSearchTextboxClickForUser);
		click(driver, GrpSearchTextboxClickForUser);
		BaseSuite.reportLog("Clicking on Searched Group which assigned to User");

		try {

			click(driver, returnElement(GroupSearchData, "$Group", Grp_search));

			Thread.sleep(3000);
			BaseSuite.reportLog("Clicked on Group: " + Grp_search);
			BaseSuite.reportLog("Group Details retrieved successfully for user " + Grp_search);

		} catch (Exception e) {
			throw new Exception("Group_search " + GrpSearchTextboxClickForUser + " not found");
		}
	}

	public void removeGroupFromExistingUser(String searchUserDetails, String GroupDetails, SoftAssert soft)
			throws Exception {

		searchUser(searchUserDetails);

		BaseSuite.reportLog("Checking the Group tab");
		isDisplayedInLoop(driver, 30, UserGroupTab);
		click(driver, UserGroupTab);
		BaseSuite.validationReportLog("Clicked on the Group tab");

		BaseSuite.reportLog("Searching for Assigned Group: " + GroupDetails);
		isDisplayedInLoop(driver, 30, GrpSearchTextboxForUser);
		click(driver, GrpSearchTextboxForUser);
		BaseSuite.reportLog("Checked on serach user text box");
		clear(driver, GrpSearchTextboxForUser);

		isDisplayedInLoop(driver, 30, GrpSearchTextboxForUser);
		BaseSuite.reportLog("Searching Group Name");
		sendKeys(driver, GrpSearchTextboxForUser, GroupDetails);
		BaseSuite.reportLog("Entering the group details in the search field..");

		isDisplayedInLoop(driver, 30, GrpSearchTextboxClickForUser);
		click(driver, GrpSearchTextboxClickForUser);
		BaseSuite.validationReportLog("Click on searched group");

		BaseSuite.reportLog("Searched group is " + GroupDetails);

		Thread.sleep(3000);
		BaseSuite.reportLog("Selecting the Group checkbox");
		click(driver, GrpCheckbox);
		BaseSuite.validationReportLog("Group is selected");

		BaseSuite.reportLog("Clicking on the Remove Button");
		click(driver, GrpRemoveBtnClick);
		Thread.sleep(3000);
		BaseSuite.validationReportLog("Clicked on the Remove Button");

		BaseSuite.reportLog("Clicking on the Remove Button---Yes");
		click(driver, GrpRemoveBtnClickYes);
		BaseSuite.validationReportLog("Clicked on the Remove Button---Yes");

		captureToastMsg(driver, UserDeletedFromGroupMsg, toastMsgClosedBtn, UserDeletedFromGroupText,
				"User Deleted From Group");

	}

	public void Admin() {
		try {
			isDisplayedInLoop(driver, 5, pagelabel);
			if (isDisplayed(driver, pagelabel)) {
				click(driver, ClickonAdmin);
				BaseSuite.reportLog("User able to click on Administration tab");
			}

			else {
				BaseSuite.reportLog("Not able to click on the Administration tab");
			}
		} catch (Exception e) {
			throw new AssertionError("User not able to navigate on Administration page", e);
		}
	}

	/*
	 * public boolean CreateValidInvalidUser(SoftAssert softAssert, String Username,
	 * String Email, String FirstName, String LastName, String Password, String
	 * ConfirmPassword, String Scenario, String TemporaryPass, String Status) {
	 * 
	 * boolean flag = false;
	 * 
	 * try {
	 * 
	 * clickOnUsersMenu(); isDisplayedInLoop(driver, 30, NewUsersHeader);
	 * 
	 * if (!Scenario.isEmpty()) { isDisplayedInLoop(driver, 30, NewUsersHeader);
	 * click(driver, NewUsersHeader); Thread.sleep(3000);
	 * BaseSuite.reportLog("User clicked on the create new user tab");
	 * 
	 * actualTitle = driver.getTitle(); expectedTitle = "Nextgenicedq";
	 * assertEquals(expectedTitle, actualTitle);
	 * 
	 * isDisplayedInLoop(driver, 20, username); clear_Click_SendKeys(driver, 20,
	 * username, Username); clear_Click_SendKeys(driver, 20, email, Email);
	 * clear_Click_SendKeys(driver, 20, firstname, FirstName);
	 * //clear_Click_SendKeys(driver, 20, lastname, LastName);
	 * 
	 * javascript(driver, "arguments[0].click();", lastname); sendKeys(driver,
	 * lastname, LastName);
	 * 
	 * javascript(driver, "arguments[0].click();", password); sendKeys(driver,
	 * password, Password);
	 * 
	 * // clear_Click_SendKeys(driver, 20, password, Password); //
	 * clear_Click_SendKeys(driver, 20, confirmpassword, ConfirmPassword);
	 * 
	 * javascript(driver, "arguments[0].click();", confirmpassword);
	 * sendKeys(driver, confirmpassword, ConfirmPassword);
	 * 
	 * if (Scenario.equalsIgnoreCase("Valid")) {
	 * 
	 * if (!TemporaryPass.isEmpty()) { String gettext = getText(driver, Toggle);
	 * gettext = gettext.trim();
	 * 
	 * if (!TemporaryPass.equalsIgnoreCase(gettext)) {
	 * 
	 * javascript(driver, "arguments[0].click();", Toggle);
	 * 
	 * BaseSuite.reportLog("Temporary password is selected"); } }
	 * 
	 * isDisplayedInLoop(driver, 30, clickonsave); if (isDisplayed(driver,
	 * clickonsave)) { Thread.sleep(3000); javascript(driver,
	 * "arguments[0].click();", clickonsave);
	 * BaseSuite.reportLog("Clicked on Save button");
	 * 
	 * } }
	 * 
	 * else {
	 * 
	 * click(driver, ClickonDiscard);
	 * 
	 * String subwindow = driver.getWindowHandle();
	 * driver.switchTo().window(subwindow); javascript(driver,
	 * "arguments[0].click();", DiscardAlert);
	 * 
	 * BaseSuite.reportLog("Clicked on the discard button"); } } else {
	 * BaseSuite.reportLog("Not able to click on the the button for empty row"); }
	 * 
	 * }
	 * 
	 * catch (Exception ex) { throw new
	 * AssertionError("User not able to navigate on the create new user page", ex);
	 * 
	 * } return flag; }
	 */

	public boolean createUserWithValid_InvalidData(SoftAssert softAssert, String Username, String Email,
			String FirstName, String LastName, String Password, String ConfirmPassword, String Scenario,
			String TemporaryPass, String Status) {

		boolean flag = false;

		try {
			clickOnUsersMenu();
			isDisplayedInLoop(driver, 25, NewUsersHeader);

			if (!Scenario.isEmpty()) {
				javascript(driver, "arguments[0].click();", NewUsersHeader);
				BaseSuite.reportLog("User clicked on the create new user tab");

				actualTitle = driver.getTitle();
				expectedTitle = "Nextgenicedq";
				assertEquals(expectedTitle, actualTitle);
				Thread.sleep(5000);
				isDisplayedInLoop(driver, 3, username);
				clear_Click_SendKeys(driver, 3, username, Username);
				clear_Click_SendKeys(driver, 3, email, Email);
				// clear_Click_SendKeys(driver, 3, firstname, FirstName);
				click(driver, lastname);
				sendKeys(driver, lastname, LastName);
				clear_Click_SendKeys(driver, 3, lastname, LastName);
				clear_Click_SendKeys(driver, 3, password, Password);
				clear_Click_SendKeys(driver, 3, confirmpassword, ConfirmPassword);

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

					isDisplayedInLoop(driver, 3, clickonsave);
					if (isDisplayed(driver, clickonsave)) {
						Thread.sleep(3000);
						javascript(driver, "arguments[0].click();", clickonsave);

						BaseSuite.reportLog("Clicked on Save button");
						isDisplayedInLoop(driver, 3, Welcometitle);
						isDisplayed(driver, Welcometitle);
						BaseSuite.validationReportLog("New user created successfully");
						Thread.sleep(3000);
						clickOnUsersMenu();

					}

				}

				else {

					isDisplayedInLoop(driver, 5, ClickonDiscard);
					Thread.sleep(3000);

					click(driver, ClickonDiscard);

					Thread.sleep(3000);
					javascript(driver, "arguments[0].click();", DiscardAlert);

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

	public void deleteuser(String User_search) throws Exception {

		clickOnUsersMenu();
		Thread.sleep(3000);
		BaseSuite.reportLog("Searching for User:" + User_search);
		isDisplayedInLoop(driver, 30, searchbar);
		click(driver, searchbar);
		clear(driver, searchbar);

		isDisplayedInLoop(driver, 30, searchbar);
		BaseSuite.reportLog("Search Name");
		sendKeys(driver, searchbar, User_search);
		BaseSuite.reportLog("Click On searched");
		if (!User_search.isEmpty()) {
			isDisplayedInLoop(driver, 30, searchclick);
			click(driver, searchclick);
		} else {
			BaseSuite.reportLog("Created user not available in the list");
		}

		try {

			isDisplayedInLoop(driver, 30, searchclick);

			BaseSuite.reportLog("Click on Searched User");

			click(driver, returnElement(searchdataclick, "$User", User_search));
			BaseSuite.reportLog("Clicked on User: " + User_search);
			BaseSuite.reportLog("User Details retrieved successfully for user " + User_search);

			isDisplayedInLoop(driver, 30, deleteT);
			if (isDisplayed(driver, deleteT)) {
				click(driver, deleteT);
				isDisplayedInLoop(driver, 30, clickonpopup);
				Thread.sleep(3000);
				click(driver, clickonpopup);
				Thread.sleep(5000);
				BaseSuite.validationReportLog("Created user deleted successfully");
			} else {
				BaseSuite.reportLog("Created user not able to delete");
			}
		} catch (Exception e) {
			throw new Exception("deleteuser " + searchdataclick + " not found");
		}
	}

	/*
	 * isDisplayedInLoop(driver, 2, pagelabel); if(isDisplayed(driver,
	 * ClickonAdmin)) {
	 * 
	 * click(driver, ClickonAdmin);
	 * BaseSuite.reportLog("User able to click on Administration tab");
	 * 
	 * BaseSuite.reportLog("User able to click on Administration tab");
	 * 
	 * Thread.sleep(5000); isDisplayedInLoop(driver,2, namelable);
	 * 
	 * List<WebElement> checkbox =
	 * driver.findElements(By.xpath("//input[@type='checkbox']")); int size =
	 * checkbox.size();
	 * 
	 * System.out.println("Quantity of checkboxes are:"+ size); for(WebElement ele :
	 * checkbox) { if(ele.isSelected()) { ele.click(); } }
	 * 
	 * /*for(int i=0; i<size; i++) { String val=
	 * checkbox.get(i).getAttribute("Icedq Test");
	 * if(val.equalsIgnoreCase("e-frame e-icons e-uncheck")) {
	 * checkbox.get(i).click(); } } } }
	 * 
	 * catch(Exception ex) {
	 * BaseSuite.reportLog("User not able to delete the selected user"); }
	 */

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

	// Test code from Vivek_Page

	public void clickOnNewButton() {
		isDisplayedInLoop(driver, 30, NewUsersHeader);
		click(driver, NewUsersHeader);
		BaseSuite.reportLog(" Clicked on the New Users button!");
		validateInputFields(driver, NewUserInput, 8);
		validateButtons(driver, NewUserButtons, 3);
		verifyIndividualLabel(driver, UserNameLabel, "User Name");
		verifyIndividualLabel(driver, EmailLabel, "Email");
		verifyIndividualLabel(driver, FirstNameLabel, "First Name");
		verifyIndividualLabel(driver, LastNameLabel, "Last Name");
		verifyIndividualLabel(driver, PasswordLabel, "Password");
		verifyIndividualLabel(driver, ConfirmPasswordLabel, "Confirm Password");
		isClickable(driver, HomeLink, "Home", true);
		getAllLinkAndVerifyLinkText(driver, HomeLink, "Home");


	}

	public void clickOnUsersMenu() throws InterruptedException {
		isDisplayedInLoop(driver, 30, UsersMenu);
		click(driver, UsersMenu);
		BaseSuite.validationReportLog("Clicked on the User Menu");
		Thread.sleep(3000);
		BaseSuite.reportLog(" Clicked on the Users menu!");
		defaultUserPageVerification();
		userPageUIDetails();
		userPageGridDetailsInfo();
	}
	
	
	public void clickOnUserMenuForNonAdminUser() throws Exception {
		try {
			Thread.sleep(5000);
		BaseSuite.reportLog("Checking User Menu");
		isDisplayedInLoop(driver, 30, UsersMenu);
		BaseSuite.reportLog("User Menu is displayed!!");
		isDisplayedInLoop(driver, 30, UsersMenu);
		click(driver, UsersMenu);
		BaseSuite.validationReportLog("Clicked on the User Menu!!");
		BaseSuite.reportLog("Verifying validation message for the non admin user on User Menu");
		inVisible(driver, spinner, Constant.ruleWait);
		waitForElement(driver, toastMsgClosedBtn);
		captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, nonAdminValidationText, "Insufficient privileges");
		}
		catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception();
		}
	}
	
	

	public void clickOnSaveUserBtn() throws Exception {

		BaseSuite.reportLog("Clicking on the Save button..");
		isDisplayedInLoop(driver, 40, clickonsave);
		click(driver, clickonsave);
		BaseSuite.validationReportLog("Save button clicked successfully..");
		inVisible(driver, spinner, Constant.ruleWait);
		waitForElement(driver,toastMsgClosedBtn);
		captureToastMsg(driver, userCreatedMsg, toastMsgClosedBtn, userCreateText, "User Created");
		validateInputFields(driver, NewUserInput, 8);
		validateButtons(driver, NewUserButtons, 3);

	}

	public void createUser_TempPassword(String Username, String Email, String FirstName, String LastName,
			String Password, String ConfirmPassword, String TemporaryPass) throws InterruptedException {
		clickOnUsersMenu();
		Thread.sleep(2000);
		BaseSuite.reportLog("Checking the New user button ");
		clickOnNewButton();
		BaseSuite.validationReportLog("New user page is opened");

		BaseSuite.reportLog(":::Entering the details of the User:::");

		clear_Click_SendKeys(driver, 30, username, Username);
		BaseSuite.reportLog("Entered Users name: " + Username);

		clear_Click_SendKeys(driver, 30, email, Email);
		BaseSuite.reportLog("Entered Users Email: " + Email);

		clear_Click_SendKeys(driver, 30, firstname, FirstName);
		BaseSuite.reportLog("Entered Users FirstName: " + FirstName);

		clear_Click_SendKeys(driver, 30, lastname, LastName);
		BaseSuite.reportLog("Entered Users LastName: " + LastName);

		clear_Click_SendKeys(driver, 30, password, Password);
		BaseSuite.reportLog("Entered Users Password: " + Password);

		clear_Click_SendKeys(driver, 30, confirmpassword, ConfirmPassword);
		BaseSuite.reportLog("Entered Users ConfirmPassword: " + ConfirmPassword);

		if (TemporaryPass.equals("Yes")) {
			BaseSuite.reportLog("Temporary password is selected...");
			BaseSuite.validationReportLog("Creating user with the Temporary password :::::::::::");

		} else if (TemporaryPass.equals("No")) {
			click(driver, TempPassWord_No);
			BaseSuite.reportLog("Clicked on Temporary password--No");
			BaseSuite.reportLog("Temporary password is not selected...");
			BaseSuite.validationReportLog("Creating user without the Temporary password:::::::::::");
		} else {
			BaseSuite.reportLog("Unable to click on the Temporary password toggle button");
		}

		isDisplayedInLoop(driver, 30, clickonsave);
		BaseSuite.reportLog("Clicking on the user save button");
		click(driver, clickonsave);
		try {
			captureToastMsg(driver, userCreatedMsg, toastMsgClosedBtn, userCreateText, "User Created");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssertionError("Error occured in this method", e);
		}
		Thread.sleep(3000);
	}

	public void refreshUserListing() throws InterruptedException {
		clickOnUsersMenu();
		Thread.sleep(3000);

		BaseSuite.reportLog("Checking the Refresh button");
		isDisplayedInLoop(driver, 30, RefreshHeader);

		if (isEnabled(driver, RefreshHeader)) {
			BaseSuite.reportLog("Refresh button is enabled");
			BaseSuite.reportLog("Checking number of available users ");

			String numbers = getText(driver, NumberOfUsers);
			System.out.println("Number of users in the list are " + numbers);
			BaseSuite.reportLog("Available Users " + numbers);

			BaseSuite.reportLog("Click on the Refresh button");
			click(driver, RefreshHeader);
			BaseSuite.validationReportLog("Clicked on the Refresh button");

			String updatednumbers = getText(driver, NumberOfUsers);
			System.out.println("Number of users in the list are " + updatednumbers);
			BaseSuite.reportLog("Available Users " + updatednumbers);

			BaseSuite.validationReportLog("User listing refreshed");
		} else {
			BaseSuite.reportLog("Unable to click refresh button");
			BaseSuite.reportErrorLog("Unable to refresh the user listing");
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

	public void userNameValidate(String specialCharacter, String specialCharacterKey, By locator1, By locator2,
			String backSpaceKey, String lable, String specialCharErrorMsg, String backSpaceErrorMsg, By locator3)
			throws InterruptedException {

		mandatoryFieldValidation(specialCharacter, specialCharacterKey, locator1, locator2, backSpaceKey, lable,
				specialCharErrorMsg, backSpaceErrorMsg, locator3);

		driver.navigate().refresh();
		Thread.sleep(3000);
		visible(driver, username, Constant.ruleWait);
	}

	public void emailTextBoxWithInvalidDetails(String specialCharacter, String specialCharacterKey, By locator1,
			By locator2, String backSpaceKey, String lable, String specialCharErrorMsg, String backSpaceErrorMsg,
			By locator3) throws InterruptedException {

		mandatoryFieldValidation(specialCharacter, specialCharacterKey, locator1, locator2, backSpaceKey, lable,
				specialCharErrorMsg, backSpaceErrorMsg, locator3);

		driver.navigate().refresh();
		Thread.sleep(3000);
		visible(driver, username, Constant.ruleWait);
	}

	public void exceedNameValidate(String specialCharacter, String specialCharacterKey, By locator1, By locator2,
			String backSpaceKey, String lable, String specialCharErrorMsg, String backSpaceErrorMsg, By locator3)
			throws InterruptedException {

		mandatoryFieldValidation(specialCharacter, specialCharacterKey, locator1, locator2, backSpaceKey, lable,
				specialCharErrorMsg, backSpaceErrorMsg, locator3);

		driver.navigate().refresh();
		Thread.sleep(3000);
		visible(driver, username, Constant.ruleWait);
	}

	public boolean userNameWithMoreThan50Char(String exceedUserName, By locator2, String lable, String errorMess,
			SoftAssert soft) throws InterruptedException {

		BaseSuite.reportLog("Entering the details of the UserName with more than 50 characters:::");

		clear_Click_SendKeys(driver, 30, username, exceedUserName);
		BaseSuite.reportLog("Entered Users name: " + exceedUserName);

		String userNameErrmsg = getText(driver, locator2).trim();
		BaseSuite.validationReportLog("Retrived Message for " + lable + " field is :" + userNameErrmsg);
		BaseSuite.validationReportLog("Expected Message for " + lable + " field is :" + errorMess);

		boolean status = false;
		if (!userNameErrmsg.isEmpty()) {
			soft.assertEquals(userNameErrmsg.trim(), errorMess.trim());
			status = true;
			BaseSuite.validationReportLog(lable + "Field Error Message Successfully Matched");
		} else {
			BaseSuite.reportFailLog(lable + "Field Error Message not Matched", "userNameWithMoreThan50Char");
		}
		return status;

	}

	public boolean firstNameWithMoreThan50Char(String exceedFirstName, By locator2, String lable, String errorMess,
			SoftAssert soft) throws InterruptedException {

		BaseSuite.reportLog("Entering the details of the First Name with more than 50 characters:::");

		clear_Click_SendKeys(driver, 30, firstname, exceedFirstName);
		BaseSuite.reportLog("Entered First name: " + exceedFirstName);

		String firstNameErrmsg = getText(driver, locator2).trim();

		BaseSuite.validationReportLog("Retrived Message for " + lable + " field is :" + firstNameErrmsg);
		BaseSuite.validationReportLog("Expected Message for " + lable + " field is :" + errorMess);

		boolean status = false;
		if (!firstNameErrmsg.isEmpty()) {
			soft.assertEquals(firstNameErrmsg.trim(), errorMess.trim());
			status = true;
			BaseSuite.validationReportLog(lable + "Field Error Message Successfully Matched");
		} else {
			BaseSuite.reportFailLog(lable + "Field Error Message not Matched", "mandatoryField");
		}
		return status;

	}

	public boolean lastNameWithMoreThan50Char(String exceedLastName, By locator2, String lable, String errorMess,
			SoftAssert soft) throws InterruptedException {

		BaseSuite.reportLog("Entering the details of the First Name with more than 50 characters:::");

		clear_Click_SendKeys(driver, 30, lastname, exceedLastName);
		BaseSuite.reportLog("Entered Last name: " + exceedLastName);

		String lastNameErrmsg = getText(driver, locator2).trim();

		BaseSuite.validationReportLog("Retrived Message for " + lable + " field is :" + lastNameErrmsg);
		BaseSuite.validationReportLog("Expected Message for " + lable + " field is :" + errorMess);

		boolean status = false;
		if (!lastNameErrmsg.isEmpty()) {
			soft.assertEquals(lastNameErrmsg.trim(), errorMess.trim());
			status = true;
			BaseSuite.validationReportLog(lable + "Field Error Message Successfully Matched");
		} else {
			BaseSuite.reportFailLog(lable + "Field Error Message not Matched", "mandatoryField");
		}
		return status;

	}

	public void emailTextBoxWithValidDetails(String emailDetails) {
		BaseSuite.reportLog("Entering the details of the Email");

		clear_Click_SendKeys(driver, 30, email, emailDetails);
		BaseSuite.reportLog("Entered Email : " + emailDetails);

		if (isDisplayed(driver, EmailSpecialCharVal)) {
			BaseSuite.reportFailLog("Fetching invalid details", emailDetails);
		} else {
			BaseSuite.validationReportLog("Email text box field is accepting valid details");

		}
	}

	public void firstNameWithSpecialChar(String firstNameDetails) {
		BaseSuite.reportLog("Entering the details in the First name with different special characters");

		clear_Click_SendKeys(driver, 30, firstname, firstNameDetails);
		BaseSuite.reportLog("Entered special characters ::::   " + firstNameDetails);

		if (isDisplayed(driver, ExceedCharValMsg)) {
			BaseSuite.reportFailLog("Unable to entered the special characters or First Name textbox limit exceed",
					firstNameDetails);
		} else {
			BaseSuite.validationReportLog("First name text box field is accepting special characters");

		}
	}

	public void lastNameWithSpecialChar(String lastNameDetails) {
		BaseSuite.reportLog("Entering the details in the Last name with different special characters");

		clear_Click_SendKeys(driver, 30, lastname, lastNameDetails);
		BaseSuite.reportLog("Entered special characters ::::   " + lastNameDetails);

		if (isDisplayed(driver, ExceedCharValMsg)) {
			BaseSuite.reportFailLog("Unable to entered the special characters or Last Name textbox limit exceed",
					lastNameDetails);
		} else {
			BaseSuite.validationReportLog("Last name text box field is accepting special characters");

		}
	}

	public void firstNameWithBlankData(By locator1, By locator2, String keysToSend, SoftAssert soft, String lable,
			String errorMess) {
		BaseSuite.reportLog("Checking validation message for Firstname textbox with blank data");
		otherMandatoryField(driver, locator1, locator2, keysToSend, soft, lable, errorMess);
		BaseSuite.validationReportLog("First Name textbox is showing proper validation message ");
	}

	public void lastNameWithBlankData(By locator1, By locator2, String keysToSend, SoftAssert soft, String lable,
			String errorMess) {
		BaseSuite.reportLog("Checking validation message for LastName textbox with blank data");
		otherMandatoryField(driver, locator1, locator2, keysToSend, soft, lable, errorMess);
		BaseSuite.validationReportLog("Last Name textbox is showing proper validation message ");
	}

	public void userNameWithLowerCase(String userName, SoftAssert soft) throws Exception {
		searchUser(userName);

		BaseSuite.reportLog("Checking the user name from the non-editable text field");
		String value = driver.findElement(By.xpath("//input[@aria-disabled=\"true\"]")).getAttribute("value");

		if (value.equals(userName.toLowerCase())) {
			soft.assertTrue(true);
			BaseSuite.reportLog("User name is showing in the lower case::::" + value);
			BaseSuite.validationReportLog("Username is showing in the lower case after revisiting the user");

		} else {
			BaseSuite.reportLog("User name is not showing in the proper format" + value);
			BaseSuite.reportFailLog("Username is not showing as expected", "userNameWithLowerCase");
		}

	}

	public void userAssignWithoutGroupDetails(String userName, String assignGrpName, SoftAssert soft) throws Exception {

		searchUser(userName);

		BaseSuite.reportLog("Checking the Group tab");
		isDisplayedInLoop(driver, 30, UserGroupTab);
		click(driver, UserGroupTab);
		BaseSuite.validationReportLog("Clicked on the Group tab");

		BaseSuite.reportLog("Checking the Assign button");
		isDisplayedInLoop(driver, 30, UserAssignBtn);
		click(driver, UserAssignBtn);
		BaseSuite.validationReportLog("Clicked on the Assign button");

		BaseSuite.reportLog("Checking the Assign Grooup pane");
		isDisplayedInLoop(driver, 30, UserAssignGroupsLabel);

		BaseSuite.reportLog("Checking the Add Group TextBox");
		isDisplayedInLoop(driver, 30, AddGroupTextBox);

		BaseSuite.reportLog("Clicking assign group button without adding the group details");
		try {
			click(driver, UsersAssignGroupBtn);
			BaseSuite.validationReportLog("Clicked on the Assign Group button");
			Thread.sleep(2000);

			captureToastMsg(driver, SelectGroupsToAssignMsg, toastMsgClosedBtn, SelectGroupsToAssignText,
					"Select groups to assign.");
		} catch (Exception e) {
			throw new Exception("Unable to get validation message while assigning group without group details");
		}
	}

	// 2nd Code
	/*
	 * public void clickOnUsersMenu() {
	 * 
	 * isDisplayedInLoop(driver, 30, UsersMenu);
	 * 
	 * click(driver, UsersMenu);
	 * 
	 * BaseSuite.reportLog(" Clicked on the Users menu!");
	 * 
	 * }
	 */
	public void searchUser1(String User_search) throws Exception {

		Thread.sleep(2000);
		BaseSuite.reportLog("Searching for User: " + User_search);
		isDisplayedInLoop(driver, 30, SearchBar);
		javascript(driver, "arguments[0].click();", SearchBar);
		clear(driver, SearchBar);

		isDisplayedInLoop(driver, 30, SearchBar);
		BaseSuite.reportLog("Search Name");
		sendKeys(driver, SearchBar, User_search);
		BaseSuite.reportLog("Click On searched");

		isDisplayedInLoop(driver, 30, SearchClick);
		javascript(driver, "arguments[0].click();", SearchClick);

	}

	public void searchUserAndClick(String User_search) throws Exception {

		Thread.sleep(2000);
		BaseSuite.reportLog("Searching for User: " + User_search);
		isDisplayedInLoop(driver, 30, SearchBar);
		javascript(driver, "arguments[0].click();", SearchBar);
		clear(driver, SearchBar);

		isDisplayedInLoop(driver, 30, SearchBar);
		BaseSuite.reportLog("Search Name");
		sendKeys(driver, SearchBar, User_search);
		BaseSuite.reportLog("Click On searched");

		isDisplayedInLoop(driver, 30, SearchClick);
		javascript(driver, "arguments[0].click();", SearchClick);

		try {

			isDisplayedInLoop(driver, 30, SearchClick);

			BaseSuite.reportLog("Click on Searched User");
			click(driver, returnElement(searchList1, "$User", User_search));
			Thread.sleep(2000);
			BaseSuite.reportLog("Clicked on User: " + User_search);
			BaseSuite.reportLog("User Details retrieved successfully for user " + User_search);

		} catch (Exception e) {
			throw new Exception("User_search " + SearchClick + " not found");
		}
	}

	public void searchWorspaceAssignInUser(String User_search) throws Exception {

		Thread.sleep(2000);
		BaseSuite.reportLog("Searching for workspace/account/group: " + User_search);
		isDisplayedInLoop(driver, 30, W_SearchBar);
		javascript(driver, "arguments[0].click();", W_SearchBar);
		clear(driver, W_SearchBar);

		isDisplayedInLoop(driver, 30, W_SearchBar);
		BaseSuite.reportLog("Search Name");
		sendKeys(driver, W_SearchBar, User_search);
		BaseSuite.reportLog("Click on searched");

		isDisplayedInLoop(driver, 30, W_SearchClick);
		javascript(driver, "arguments[0].click();", W_SearchClick);
	}

	public void searchGroupAssignInUser(String User_search) throws Exception {

		Thread.sleep(2000);
		BaseSuite.reportLog("Searching for workspace/account/group: " + User_search);
		isDisplayedInLoop(driver, 30, G_SearchBar);
		javascript(driver, "arguments[0].click();", G_SearchBar);
		clear(driver, G_SearchBar);

		isDisplayedInLoop(driver, 30, G_SearchBar);
		BaseSuite.reportLog("Search Name");
		sendKeys(driver, G_SearchBar, User_search);
		BaseSuite.reportLog("Click on searched");

		isDisplayedInLoop(driver, 30, G_SearchClick);
		javascript(driver, "arguments[0].click();", G_SearchClick);
	}

	public void createBlockedUserWithoutTempPass(String Username1, String BlockEmail, String BlockFirstName,
			String BlockLastName, String BlockPassword, String BlockConfirmPassword, String TemporaryPass1,
			String BlockedStatus, String Search_user1) throws Exception

	{
		clickOnUsersMenu();
		try {

			BaseSuite.reportLog("Checking the New user button ");
			isDisplayedInLoop(driver, 30, NewUsersHeader);
			BaseSuite.reportLog("Click New user button ");
			clickOnNewButton();
			// javascript(driver, "arguments[0].click();", NewUsersHeader);
			// click(driver, NewUsersHeader);
			BaseSuite.validationReportLog("New user page is opened");

			BaseSuite.reportLog(":::Entering the details of the User:::");

			clear_Click_SendKeys(driver, 30, username, Username1);
			BaseSuite.reportLog("Entered Users name: " + Username1);

			clear_Click_SendKeys(driver, 30, email, BlockEmail);
			BaseSuite.reportLog("Entered Users Email: " + BlockEmail);

			clear_Click_SendKeys(driver, 30, firstname, BlockFirstName);
			BaseSuite.reportLog("Entered Users FirstName: " + BlockFirstName);

			clear_Click_SendKeys(driver, 30, lastname, BlockLastName);
			BaseSuite.reportLog("Entered Users LastName: " + BlockLastName);

			clear_Click_SendKeys(driver, 30, password, BlockPassword);
			BaseSuite.reportLog("Entered Users Password: " + BlockPassword);

			clear_Click_SendKeys(driver, 30, confirmpassword, BlockConfirmPassword);
			BaseSuite.reportLog("Entered Users ConfirmPassword: " + BlockConfirmPassword);

			if (TemporaryPass1.equals("Yes")) {
				BaseSuite.reportLog("Temporary password is selected");
				BaseSuite.validationReportLog("Creating user with the Temporary password");

			} else if (TemporaryPass1.equals("No")) {
				click(driver, TempPassWord_Yes);
				BaseSuite.reportLog("Clicked on Temporary password--No");
				BaseSuite.reportLog("Temporary password is not selected");
				BaseSuite.validationReportLog("Creating user without the Temporary password");
			} else {
				BaseSuite.reportLog("Unable to click on the Temporary password toggle button");
			}
			if (BlockedStatus.equals("No")) {
				BaseSuite.reportLog("Status as active is selected");
				BaseSuite.validationReportLog("Creating user with status as active");

			} else if (BlockedStatus.equals("Yes")) {
				click(driver, StatusBlockTogButton);
				BaseSuite.reportLog("Clicked on status as Blocked");
				BaseSuite.reportLog("Status as blocked has been selected");
				BaseSuite.validationReportLog("Creating user with status as Blocked");
			} else {
				BaseSuite.reportLog("Unable to click on the Status toggle button");
			}

			isDisplayedInLoop(driver, 30, clickonsave);
			BaseSuite.reportLog("Clicking on the user save button");
			clickOnSaveUserBtn();
			// click(driver, clickonsave);
			// waitForElement(driver,userCreatedMsg);

			// captureToastMsg(driver, CommonToastMsg, toastMsgClosedBtn1, userCreateText,
			// "User Created");
			BaseSuite.validationReportLog("New user created with status as Blocked and without temporary password.");
			clickOnUsersMenu();
			BaseSuite.reportLog("Searching for created user");
			searchUser1(Search_user1);
			isDisplayedInLoop(driver, 20, Blocklabel);
			String Status = getText(driver, Blocklabel);
			if (Status.contains("Blocked")) {
				BaseSuite.validationReportLog("New user created with status as Blocked and without temporary password:"
						+ Search_user1 + Status);
			} else {
				BaseSuite.validationReportLog(
						"New user not created with status as Blocked and without temporary password.");
			}
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void createBlockedUserWithTempPass(String Username2, String Email2, String FirstName2, String LastName2,
			String Password2, String ConfirmPassword2, String TemporaryPass2, String BlockedStatus2,
			String Search_user2) throws Exception

	{
		clickOnUsersMenu();
		try {

			BaseSuite.reportLog("Checking the New user button ");
			isDisplayedInLoop(driver, 30, NewUsersHeader);
			BaseSuite.reportLog("Click New user button ");
			clickOnNewButton();
		
			BaseSuite.validationReportLog("New user page is opened");

			BaseSuite.reportLog(":::Entering the details of the User:::");

			clear_Click_SendKeys(driver, 30, username, Username2);
			BaseSuite.reportLog("Entered Users name: " + Username2);

			clear_Click_SendKeys(driver, 30, email, Email2);
			BaseSuite.reportLog("Entered Users Email: " + Email2);

			clear_Click_SendKeys(driver, 30, firstname, FirstName2);
			BaseSuite.reportLog("Entered Users FirstName: " + FirstName2);

			clear_Click_SendKeys(driver, 30, lastname, LastName2);
			BaseSuite.reportLog("Entered Users LastName: " + LastName2);

			clear_Click_SendKeys(driver, 30, password, Password2);
			BaseSuite.reportLog("Entered Users Password: " + Password2);

			clear_Click_SendKeys(driver, 30, confirmpassword, ConfirmPassword2);
			BaseSuite.reportLog("Entered Users ConfirmPassword: " + ConfirmPassword2);

			if (TemporaryPass2.equals("Yes")) {

				BaseSuite.reportLog("Temporary password is already selected");
				BaseSuite.validationReportLog("Creating user with the Temporary password");

			} else if (TemporaryPass2.equals("No")) {
				click(driver, TempPassWord_Yes);
				BaseSuite.reportLog("Clicked on Temporary password--No");
				BaseSuite.reportLog("Temporary password is not selected");
				BaseSuite.validationReportLog("Creating user without the Temporary password");
			} else {
				BaseSuite.reportLog("Unable to click on the Temporary password toggle button");
			}
			if (BlockedStatus2.equals("No")) {
				BaseSuite.reportLog("Status as active is selected");
				BaseSuite.validationReportLog("Creating user with status as active");


		}
		else if(BlockedStatus2.equals("Yes"))
		{
			click(driver, StatusBlockTogButton);
			BaseSuite.reportLog("Clicked on status as Blocked");
			BaseSuite.reportLog("Status as blocked has been selected");
			BaseSuite.validationReportLog("Creating user with status as Blocked");
		}
		else
		{
			BaseSuite.reportLog("Unable to click on the Status toggle button");
		}
		
		isDisplayedInLoop(driver, 30, clickonsave);
		BaseSuite.reportLog("Clicking on the Save button..");
		isDisplayedInLoop(driver, 40, clickonsave);
		click(driver, clickonsave);
		BaseSuite.validationReportLog("Save button clicked successfully..");
		inVisible(driver, spinner, Constant.ruleWait);
		waitForElement(driver,userCreatedMsg);
		captureToastMsg(driver, userCreatedMsg, toastMsgClosedBtn1, userCreateText, "User Created");
		driver.navigate().refresh();
		Thread.sleep(2000);
		BaseSuite.validationReportLog("New user created with status as Blocked and without temporary password.");
		clickOnUsersMenu();
		
		BaseSuite.reportLog("Searching for created user");
		searchUser1(Search_user2);
		waitForElement(driver,Blocklabel);
		isDisplayedInLoop(driver,30,Blocklabel);
		String Status = getText(driver,Blocklabel);
		if(Status.contains("Blocked"))
		{
			BaseSuite.validationReportLog("New user created with status as Blocked and without temporary password:"   + Search_user2   + Status);
		}
		else
		{
			BaseSuite.validationReportLog("New user not created with status as Blocked and without temporary password.");
		}
		
		
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void searchCreatedUser(String User_search1) throws Exception {

		clickOnUsersMenu();

		BaseSuite.reportLog("Searching for User: " + User_search1);

		isDisplayedInLoop(driver, 30, SearchBar);

		javascript(driver, "arguments[0].click();", SearchBar);

		clear(driver, SearchBar);

		isDisplayedInLoop(driver, 30, SearchBar);

		BaseSuite.reportLog("Search Name");

		sendKeys(driver, SearchBar, User_search1);

		BaseSuite.reportLog("Click On searched");

		isDisplayedInLoop(driver, 30, SearchClick);

		javascript(driver, "arguments[0].click();", SearchClick);

		BaseSuite.validationReportLog("Found newly created user in the list");

		isDisplayedInLoop(driver, 60, SearchClick);

		String name = getText(driver, searchListed);

		BaseSuite.reportLog("Try to print the name of newly created user");
		// List<WebElement> Users =driver.findElements(searchList);

		// for (int i = 0; i < Users.size(); i++) {

		// get(i).getText();

		if (User_search1.equalsIgnoreCase(name)) {
			BaseSuite.validationReportLog("Created user searched successfully:" + name);
		} else

		{

			BaseSuite.reportFailLog("Created user not getting displayed in the list", "searchCreatedUser");
		}

		isDisplayedInLoop(driver, 30, SearchBar);
		clear(driver, SearchBar);
		isDisplayedInLoop(driver, 30, SearchClick);
		javascript(driver, "arguments[0].click();", SearchClick);
		Thread.sleep(2000);
		clickOnUsersMenu();
		
	}

	public void userSearchWithPagination(String PaginationPoint) throws Exception {
		
		try {
			Thread.sleep(2000);
			boolean flag = isDisplayed(driver,PaginationNext);
			if(flag)
			{
				BaseSuite.reportLog("Test");
			if (PaginationPoint.equalsIgnoreCase(">")) {
				isDisplayedInLoop(driver, 30, PaginationNext);
				paginationAllSymbol(driver, PaginationNext, PaginationPre);
				BaseSuite.validationReportLog("Clicked on the Angular '< >' pagination icons");
				BaseSuite.validationReportLog("Angular Symbol Pagination working successfully");
			} else if (PaginationPoint.equalsIgnoreCase("1")) {
				isDisplayedInLoop(driver, 20, PaginationNumNext);
				paginationAllSymbol(driver, PaginationNumNext, PaginationNumPre);
				BaseSuite.validationReportLog("Clicked on the Number '1 2' pagination icons");
				BaseSuite.validationReportLog("Number Symbol Pagination working successfully");
			}

			else if (PaginationPoint.equalsIgnoreCase(">|")) {
				isDisplayedInLoop(driver, 20, PaginationNumNext);
				paginationAllSymbol(driver, PaginationPageNext, PaginationPageLast);
				BaseSuite.validationReportLog("Clicked on the last and first page r '|< >|' pagination icons");
				BaseSuite.validationReportLog("Last and first page Symbol Pagination working successfully");
			}

			else {
				BaseSuite.reportErrorLog("Pagination not working");
			}
			}
			else
			{
				BaseSuite.validationReportLog("Pagination page is not available");
			}
		} catch (Exception e) {
			throw new NoSuchElementException("Failed in pagination");
		}

	}

	public void continueNext(String users, String sheetName, String string, ExtentTest test, int rowNumber, String e1,
			Logger log, String columnName, String string2) {
		

	}

	public void multipleUserBlock(String Block_users) throws Exception {
		clickOnUsersMenu();
		try {
			isDisplayedInLoop(driver, 30, SelectCheckboxes);
			List<WebElement> UserList = driver.findElements(SelectCheckboxes);
			for (int i = 1; i < UserList.size() - 13; i++) {
				UserList.get(i).click();
			}

			if (!isSelected(driver, SelectCheckboxes)) {
				BaseSuite.validationReportLog("Multiple users selected successfully");
			} else {
				BaseSuite.validationReportLog("Multiple users not selected");
			}

			if (isEnabled(driver, BlockUserHeader)) {
				javascript(driver, "arguments[0].click();", BlockUserHeader);
				BaseSuite.validationReportLog("Block user button is enabled and user able to click");
				javascript(driver, "arguments[0].click();", BlockYes);
				Thread.sleep(2000);
				captureToastMsg(driver, CommonToastMsg, toastMsgClosedBtn1, userBlockText, "Block users");
				BaseSuite.validationReportLog("Selected users has been blocked successfully");
			} else {
				BaseSuite.reportErrorLog("Block user button is disabled even after selection of users");
			}
			BaseSuite.reportLog("To check the status of block user serching for the current user.");

			searchUser1(Block_users);

			isDisplayedInLoop(driver, 40, searchListed);

			// String username = getText(driver,searchList);

			String blocklabel = getText(driver, Blocklabel);

			BaseSuite.reportLog("Try to print the status of newly blocked user");

			if (blocklabel.contains("Blocked")) {
				BaseSuite.validationReportLog(
						"User blocked successfully and status updated successfully as :" + blocklabel);
			} else

			{
				BaseSuite.reportFailLog("Created user not getting blocked and status in not updated in the list",
						"searchCreatedUser");
			}

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}

	}

	public void allUserSelect() throws Exception {
		clickOnUsersMenu();
		try {
			isDisplayedInLoop(driver, 30, SelectCheckboxes);
			List<WebElement> UserList = driver.findElements(SelectCheckboxes);
			int i = 0;
			UserList.get(i).click();
			BaseSuite.validationReportLog("Clicked on the select all user checkbox");

			isDisplayedInLoop(driver, 30, SelectAllCheckboxes);
			if (!UserList.get(i).isSelected()) {
				isDisplayedInLoop(driver, 30, SelectAllCheckboxes);
				List<WebElement> UserList1 = driver.findElements(SelectAllCheckboxes);
				int a = UserList1.size() - 1;
				BaseSuite.validationReportLog(
						"All the checkboxes has been selected successfully and total number of selected users on 1st page are:"
								+ a);

			} else {
				BaseSuite.reportErrorLog("User not able to select all the users using all user checkbox");
			}

		}

		catch (Exception e) {
			BaseSuite.reportErrorLog("Multiple user selection function not working");
		}
		clickOnGroupsMenu();
	}

	public void updateAzureADuser(String AzureADUser, String TemporaryPass2, String BlockedStatus2) throws Exception {
		clickOnUsersMenu();
		try {
			isDisplayedInLoop(driver, 20, DeleteAzureADButton);
			searchUserAndClick(AzureADUser);
			inVisible(driver, spinner, Constant.ruleWait);
			waitForElement(driver,CommonToastMsg);
			captureToastMsg(driver, CommonToastMsg, toastMsgClosedBtn1, RetriveDetailsMsg, "Save User");
			String fieldNames = "username/email/firstname/lastname/password/confirmpassword";

			if ((!isEditable(driver, username, "Username")) && (!isEditable(driver, email, "Email"))
					&& (!isEditable(driver, firstname, "FirstName")) && (!isEditable(driver, lastname, "LastName"))
					&& (!isEditable(driver, password, "Password"))
					&& (!isEditable(driver, confirmpassword, "ConfirmPassword"))) {
				BaseSuite.validationReportLog(
						"All fields are disabled and Admin user not able to enter any details in the fields:"
								+ fieldNames);
			} else {
				BaseSuite.reportFailLog("Fields are enabled and admin user can able to update details",
						"updateAzureADuser");
			}
			if (TemporaryPass2.equals("Yes")) {

				BaseSuite.reportLog("Temporary password is already selected");
				BaseSuite.validationReportLog("User with the Temporary password");

			} else if (TemporaryPass2.equals("No")) {
				click(driver, TempPassWord_Yes);
				BaseSuite.reportLog("Clicked on Temporary password--No");
				BaseSuite.reportLog("Temporary password is not selected");
				BaseSuite.validationReportLog("Updating user without the Temporary password");
			} else {
				BaseSuite.reportLog("Unable to click on the Temporary password toggle button");
			}
			if (BlockedStatus2.equals("No")) {
				BaseSuite.reportLog("Status as active is selected");
				BaseSuite.validationReportLog("Updating user with status as active");

			} else if (BlockedStatus2.equals("Yes")) {
				isDisplayedInLoop(driver, 20, StatusBlockTogButton);
				click(driver, StatusBlockTogButton);
				BaseSuite.reportLog("Clicked on status as Blocked");
				BaseSuite.reportLog("Status as blocked has been selected");
				BaseSuite.validationReportLog("Updating user with status as Blocked");
			} else {
				BaseSuite.reportLog("Unable to click on the Status toggle button");
			}
			isDisplayedInLoop(driver, 40, clickonsave);
			BaseSuite.reportLog("Clicking on the user save button");
			// clickOnSaveUserBtn();
			click(driver, clickonsave);
			inVisible(driver, spinner, Constant.ruleWait);
			waitForElement(driver,CommonToastMsg);
			captureToastMsg(driver, CommonToastMsg, toastMsgClosedBtn1, updateAzureADMsg, "Save User");
			BaseSuite.validationReportLog("User updated with status as Blocked and without temporary password.");
			clickOnUsersMenu();
			BaseSuite.reportLog("Searching for created user");
			searchUser1(AzureADUser);
			isDisplayedInLoop(driver, 20, Blocklabel);
			String Status = getText(driver, Blocklabel);
			if (Status.contains("Blocked")) {
				BaseSuite.validationReportLog(
						"AzureAD user only updated with status and temporary password: " + AzureADUser + Status);
			} else {
				BaseSuite.validationReportLog(
						"AzureAD user updated with status as Blocked and without temporary password.");
			}
			isDisplayedInLoop(driver, 40, SearchBar);			
			clear(driver, SearchBar);
			searchUserAndClick(AzureADUser);
			inVisible(driver, spinner, Constant.ruleWait);
			isDisplayedInLoop(driver, 30, StatusBlockedBtn);
			click(driver, StatusBlockedBtn);
			isDisplayedInLoop(driver,30,clickonsave);
			click(driver, clickonsave);		
			driver.navigate().refresh();
			Thread.sleep(2000);
			
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void updateUser(String updatedemail, String updatedfirstname, String updatedlastname, String updatedpassword,

			String updatedconfirmpassword, String tempPass, String status, String LocalUser_search) throws Exception {
		clickOnUsersMenu();
		try {
			isDisplayedInLoop(driver, 20, SearchBar);
			searchUserAndClick(LocalUser_search);
			inVisible(driver, spinner, Constant.ruleWait);
			captureToastMsg(driver, CommonToastMsg, toastMsgClosedBtn1, RetriveDetailsMsg, "Retrive details");
			
			isDisplayedInLoop(driver, 20, username);

			if (!isEditable(driver, username, "Username")) {
				BaseSuite.validationReportLog("Username field is disabled user not able to update username field.");
			} else {
				BaseSuite.reportFailLog("Username field is enabled so bug occured", "updateUser");
			}
			if (isEditable(driver, email, "Email")) {
				clear_Click_SendKeys(driver, 3, email, updatedemail);
				BaseSuite.validationReportLog("Updated email is: " + updatedemail);

				if (isEditable(driver, firstname, "FirstName")) {
					clear_Click_SendKeys(driver, 3, firstname, updatedfirstname);
					BaseSuite.validationReportLog("Updated firstname is: " + updatedfirstname);

					if (isEditable(driver, lastname, "LastName")) {
						clear_Click_SendKeys(driver, 3, lastname, updatedlastname);
						BaseSuite.validationReportLog("Updated lastname is: " + updatedlastname);

						if (isEditable(driver, password, "Password")) {
							clear_Click_SendKeys(driver, 3, password, updatedpassword);

							if (isEditable(driver, confirmpassword, "Confirm Password")) {
								clear_Click_SendKeys(driver, 3, confirmpassword, updatedconfirmpassword);

								BaseSuite.validationReportLog("All the user details has been updated ");

								if (tempPass.equalsIgnoreCase("No")) {
									click(driver, ClickTempPass);
									BaseSuite.validationReportLog("User created with temporary password");

								} else {
									BaseSuite.validationReportLog("User created without temporary password");
								}
								if (status.equalsIgnoreCase("Active")) {
									BaseSuite.reportLog(
											"User clicked on the toggle button to make the status as blocked");
									isDisplayedInLoop(driver, 20, StatusToggleButton);
									click(driver, StatusToggleButton);
									BaseSuite.validationReportLog("User status updated as 'Blocked'");
								} else {
									BaseSuite.validationReportLog("User status already is in 'Blocked' status");
								}
							}
						}
					}
				}
			}

			else {
				BaseSuite.reportFailLog("Admin not able to update the user details", "updateUser");
			}
			if (isEnabled(driver, SaveUserButton)) {
				isDisplayedInLoop(driver, 40, SaveUserButton);
				// clickOnSaveUserBtn();
				Thread.sleep(2000);
				click(driver, SaveUserButton);
				inVisible(driver, spinner, Constant.ruleWait);
				waitForElement(driver,toastMsgClosedBtn1);
				captureToastMsg(driver, CommonToastMsg, toastMsgClosedBtn1, toastUpdateMsg, "update user");
				BaseSuite.validationReportLog("User updated successfully");
				driver.navigate().refresh();
				Thread.sleep(2000);

			} else {
				BaseSuite.reportFailLog("Save button in not enabled hence user not updated", "updateUser");
			}
			
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void deleteAzureAdUser(String DeleteAzureADUser) throws Exception {
		clickOnUsersMenu();
		try {
			inVisible(driver, spinner, Constant.ruleWait);
			searchUser1(DeleteAzureADUser);
			isDisplayedInLoop(driver, 40, SelectCheckboxes);
			List<WebElement> UserList = driver.findElements(SelectCheckboxes);

			int i = 1;

			if (i <= 1) {
				isDisplayedInLoop(driver, 40, SearchBar);
				UserList.get(i).click();
				String Name = UserList.get(i).getText();
				BaseSuite.validationReportLog("AzureAd user selected successfully: " + Name);
				if (isEnabled(driver, DeleteUserHeader)) {
					isDisplayedInLoop(driver, 20, DeleteUserHeader);
					javascript(driver, "arguments[0].click();", DeleteUserHeader);
					javascript(driver, "arguments[0].click();", DeleteUserHeaderYes);
					inVisible(driver, spinner, Constant.ruleWait);
					Thread.sleep(2000);
					captureToastMsg(driver, CommonToastMsg, toastMsgClosedBtn1, toastDeleteAzureADMsg,
							"Delete AzureAD User");

					BaseSuite.validationReportLog("AzureADUser deleted successfully.");
				}
			} else {
				BaseSuite.reportFailLog("AzureAD user not deleted", "deleteAzureAdUser");
			}
			driver.navigate().refresh();
			Thread.sleep(2000);
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void deleteLocalUser(String DeleteLocalUser) throws Exception {
		clickOnUsersMenu();
		try {
			searchUser1(DeleteLocalUser);
			List<WebElement> UserList = driver.findElements(SelectCheckboxes);

		
			for(int i=1; i<=2; i++)
			//if (i <= 2) 
				{
				isDisplayedInLoop(driver, 40, SelectCheckboxes);
				UserList.get(i).click();
				String LocalUserName = UserList.get(i).getText();
				BaseSuite.validationReportLog("Local user selected successfully:" + LocalUserName);
				
				}
				
				if (isEnabled(driver, DeleteUserHeader)) {
					isDisplayedInLoop(driver, 20, DeleteUserHeader);
					javascript(driver, "arguments[0].click();", DeleteUserHeader);
					javascript(driver, "arguments[0].click();", DeleteUserHeaderYes);
					inVisible(driver, spinner, Constant.ruleWait);
					Thread.sleep(2000);
					captureToastMsg(driver, CommonToastMsg, toastMsgClosedBtn1, toastDeleteLocaluser, "Delete Local User");

					BaseSuite.validationReportLog("LocalUser deleted successfully.");
				}
			 else {
				BaseSuite.reportFailLog("Local user not deleted", "deleteLocalUser");
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void discardNewUser(String Username, String Email11, String FirstName, String LastName, String Password11,
			String ConfirmPassword11, String TemporaryPass, String DiscardalertYes) throws Exception {
		clickOnUsersMenu();
		try {
			inVisible(driver, spinner, Constant.ruleWait);
			BaseSuite.reportLog("Checking the New user button ");
			isDisplayedInLoop(driver, 30, NewUsersHeader);
			BaseSuite.reportLog("Click New user button ");
			// click(driver, NewUsersHeader);
			clickOnNewButton();
			// javascript(driver, "arguments[0].click();", NewUsersHeader);
			BaseSuite.validationReportLog("New user page is opened");

			BaseSuite.reportLog(":::Entering the details of the User:::");

			clear_Click_SendKeys(driver, 30, username, Username);
			BaseSuite.reportLog("Entered Users name: " + Username);

			clear_Click_SendKeys(driver, 30, email, Email11);
			BaseSuite.reportLog("Entered Users Email: " + Email11);

			clear_Click_SendKeys(driver, 30, firstname, FirstName);
			BaseSuite.reportLog("Entered Users FirstName: " + FirstName);

			clear_Click_SendKeys(driver, 30, lastname, LastName);
			BaseSuite.reportLog("Entered Users LastName: " + LastName);

			clear_Click_SendKeys(driver, 30, password, Password11);
			BaseSuite.reportLog("Entered Users Password: " + Password11);

			clear_Click_SendKeys(driver, 30, confirmpassword, ConfirmPassword11);
			BaseSuite.reportLog("Entered Users ConfirmPassword: " + ConfirmPassword11);

			if (TemporaryPass.equals("Yes")) {
				BaseSuite.reportLog("Temporary password is selected");
				BaseSuite.validationReportLog("Creating user with the Temporary password");

			} else if (TemporaryPass.equals("No")) {
				click(driver, TempPassWord_No);
				BaseSuite.reportLog("Clicked on Temporary password--No");
				BaseSuite.reportLog("Temporary password is not selected");
				BaseSuite.validationReportLog("Creating user without the Temporary password");
			} else {
				BaseSuite.reportLog("Unable to click on the Temporary password toggle button");
			}
			if (isEnabled(driver, DiscardButton)) {
				isDisplayedInLoop(driver, 30, DiscardButton);
				BaseSuite.reportLog("Clicking on the discard button");
				click(driver, DiscardButton);
				BaseSuite.validationReportLog("Discard alert message getting displayed");
				String discardmsg = getText(driver, DiscardMsg);
				if (DiscardalertYes.contains("Yes")) {
					BaseSuite.reportLog("Discarding user details with option 'Yes' ");
					click(driver, DiscardAlertYes);
					BaseSuite.validationReportLog("Alert message displaying successfully:" + discardmsg);
				} else {
					BaseSuite.reportLog("User not discarding new user details with option 'No");
					javascript(driver, "arguments[0].click();", DiscardAlertNo);
				}
				
				BaseSuite.validationReportLog("New user details discarded successfully");
			} else {
				BaseSuite.reportFailLog("Discard button not enabled", "discardNewUser");
			}
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void discardExistingUser(String Username, String Email, String FirstName, String LastName, String Password,
			String ConfirmPassword, String TemporaryPass, String DiscardalertYes, String User_search) throws Exception {
		clickOnUsersMenu();
		try {
			BaseSuite.reportLog("Searching the existing user using search bar");
			searchUserAndClick(User_search);
			inVisible(driver, spinner, Constant.ruleWait);
			isDisplayedInLoop(driver, 20, lastname);
			captureToastMsg(driver, RetriverMsg, lastname, RetriveDetailsMsg, "Details retrive msg");
			BaseSuite.validationReportLog("existing user page is opened");

			BaseSuite.reportLog(":::Entering the details of the User:::");
			if (!isEditable(driver, username, "Username")) {
				BaseSuite.reportLog("Username field is disabled and user not enter any details in the field.");
			} else {
				clear_Click_SendKeys(driver, 30, username, Username);
				BaseSuite.reportLog("Entered Users Username: " + Username);
				BaseSuite.reportFailLog("User able to enter the username details so test case should be failed",
						"discardExistingUser");
			}
			clear_Click_SendKeys(driver, 30, email, Email);
			BaseSuite.reportLog("Entered Users Email: " + Email);

			clear_Click_SendKeys(driver, 30, firstname, FirstName);
			BaseSuite.reportLog("Entered Users FirstName: " + FirstName);

			clear_Click_SendKeys(driver, 30, lastname, LastName);
			BaseSuite.reportLog("Entered Users LastName: " + LastName);

			clear_Click_SendKeys(driver, 30, password, Password);
			BaseSuite.reportLog("Entered Users Password: " + Password);

			clear_Click_SendKeys(driver, 30, confirmpassword, ConfirmPassword);
			BaseSuite.reportLog("Entered Users ConfirmPassword: " + ConfirmPassword);

			if (TemporaryPass.equals("Yes")) {
				BaseSuite.reportLog("Temporary password is selected");
				BaseSuite.validationReportLog("Creating user with the Temporary password");

			} else if (TemporaryPass.equals("No")) {
				click(driver, TempPassWord_No);
				BaseSuite.reportLog("Clicked on Temporary password--No");
				BaseSuite.reportLog("Temporary password is not selected");
				BaseSuite.validationReportLog("Creating user without the Temporary password");
			} else {
				BaseSuite.reportLog("Unable to click on the Temporary password toggle button");
			}
			if (isEnabled(driver, DiscardButton)) {
				isDisplayedInLoop(driver, 30, DiscardButton);
				BaseSuite.reportLog("Clicking on the discard button");
				click(driver, DiscardButton);
				// BaseSuite.validationReportLog("Discard alert message 'Are you sure, you want
				// to discard the changes?' message getting displayed");
				String discardmsg = getText(driver, DiscardMsg);
				BaseSuite.validationReportLog("Alert message displaying successfully:" + discardmsg);
				if (DiscardalertYes.contains("Yes")) {
					BaseSuite.reportLog("Discarding user details with option 'Yes' ");
					click(driver, DiscardAlertYes);

				} else {
					BaseSuite.reportLog("User not discarding existing user details with option 'No");
					javascript(driver, "arguments[0].click();", DiscardAlertNo);
				}

				// captureToastMsg(driver, userCreatedMsg, toastMsgClosedBtn, userCreateText,
				// "User Discared details");
				BaseSuite.validationReportLog("Existing user details discarded successfully");
			} else {
				BaseSuite.reportFailLog("Discard button not enabled", "discardNewUser");
			}
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void workspaceAssignDetails(String Workspace_search, String User_search) throws Exception {
		clickOnUsersMenu();
		try {
			searchUserAndClick(User_search);
			inVisible(driver, spinner, Constant.ruleWait);
			captureToastMsg(driver, CommonToastMsg, toastMsgClosedBtn1, toastRetriveMsg, "Existing user details");
			isDisplayedInLoop(driver, 20, WorkspaceLabel);
			BaseSuite.reportLog("Clicking on workspace label");
			click(driver, WorkspaceLabel);
			inVisible(driver, spinner, Constant.ruleWait);
			BaseSuite.validationReportLog("User able to see the list of assigned wokspaces");
			String WorkspaceLabelsColumns = "Name /Role /Type /Account /Scope";
			if ((isDisplayed(driver, WorkspaceNameLabel)) && (isDisplayed(driver, WorkspaceRoleLabel))
					&& (isDisplayed(driver, WorkspaceTypeLabel)) && (isDisplayed(driver, WorkspaceAccountLabel))
					&& (isDisplayed(driver, WorkspaceScopeLabel))) {
				BaseSuite.validationReportLog(
						"In workspace section all the workspace labels name displaying successfully:"
								+ WorkspaceLabelsColumns);
			} else {
				BaseSuite.reportFailLog("Workspace labels are not available", "workspaceAssignDetails");
			}
			isDisplayedInLoop(driver, 40, W_SearchBar);
			BaseSuite.reportLog("Searching for assigned workspace");
			searchWorspaceAssignInUser(Workspace_search);
			Thread.sleep(2000);
			if(isAvailableInPage(driver,Workspace_search))
			{
			isDisplayedInLoop(driver, 20, WorkspaceNameList);
			String Name = getText(driver, WorkspaceNameList);
			if (Name.equalsIgnoreCase(Workspace_search)) {
				
				BaseSuite
						.validationReportLog("In workspace section assigned workspace displaying successfully:" + Name);
			} else {
				BaseSuite.reportFailLog("Assigned workspace is not displaying in the under the workspace section","workspaceAssignDetails");
			}
			}
			else
			{
				BaseSuite.reportFailLog("Assigned workspace is not available in the list or page is not loading the workspace list", "workspaceAssignDetails");
			}
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void accountAssignDetails(String Account_search, String User_search) throws Exception {
		clickOnUsersMenu();
		try {
			searchUserAndClick(User_search);
			inVisible(driver, spinner, Constant.ruleWait);
			captureToastMsg(driver, CommonToastMsg, toastMsgClosedBtn1, toastRetriveMsg, "Existing user details");
			isDisplayedInLoop(driver, 20, AccountLabel);
			BaseSuite.reportLog("Clicking on account label");
			click(driver, AccountLabel);
			inVisible(driver, spinner, Constant.ruleWait);
			BaseSuite.validationReportLog("User able to see the list of assigned accounts");
			String AccountLabelsColumns = "Name /Role /Scope";
			if ((isDisplayed(driver, AccountNameLabel)) && (isDisplayed(driver, AccountRoleLabel))
					&& (isDisplayed(driver, AccountScopeLabel))) {
				BaseSuite.validationReportLog("In account section all the account labels name displaying successfully:"
						+ AccountLabelsColumns);
			} else {
				BaseSuite.reportFailLog("Account labels are not available", "accountAssignDetails");
			}
			isDisplayedInLoop(driver, 40, W_SearchBar);
			BaseSuite.reportLog("Searching for assigned accounts");
			searchWorspaceAssignInUser(Account_search);
			Thread.sleep(2000);
			if(isAvailableInPage(driver,Account_search))
			{			
			isDisplayedInLoop(driver, 20, AccountNameList);
			String Name = getText(driver, AccountNameList);
			if (Name.equalsIgnoreCase(Account_search)) {
				/*
				 * List<WebElement> WorkspaceListName = driver.findElements(WorkspaceNameList);
				 * 
				 * int i = 0; String Name = WorkspaceListName.get(i).getText();
				 */
				BaseSuite.validationReportLog("In account section assigned workspace displaying successfully:" + Name);
			} 
			}
			else {
				BaseSuite.reportFailLog("Assigned account is not available in the list under the account section or page is not loading the account list","accountAssignDetails");
			}
			Thread.sleep(3000);
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void groupAssignDetails(String Group_search, String User_search) throws Exception {
		clickOnUsersMenu();
		try {
			searchUserAndClick(User_search);
			inVisible(driver, spinner, Constant.ruleWait);
			captureToastMsg(driver, CommonToastMsg, toastMsgClosedBtn1, toastRetriveMsg, "Existing user details");
			isDisplayedInLoop(driver, 30, GroupLabel);
			BaseSuite.reportLog("Clicking on Group label");
			click(driver, GroupLabel);
			inVisible(driver, spinner, Constant.ruleWait);
			BaseSuite.validationReportLog("User able to see the list of assigned groups");
			String GroupLabelsColumns = "Name /Path";
			if ((isDisplayed(driver, GroupNameLabel)) && (isDisplayed(driver, GroupPathLabel))) {
				BaseSuite.validationReportLog(
						"In group section all the group labels name displaying successfully:" + GroupLabelsColumns);
			} else {
				BaseSuite.reportFailLog("Group labels are not available", "groupAssignDetails");
			}
			isDisplayedInLoop(driver, 40, G_SearchBar);
			BaseSuite.reportLog("Searching for assigned group");
			searchGroupAssignInUser(Group_search);
			if(isAvailableInPage(driver,Group_search))
			{
			waitForElement(driver, GroupNameList);
			isDisplayedInLoop(driver, 20, GroupNameList);
			String Name = getText(driver, GroupNameList);
			if (Name.equalsIgnoreCase(Group_search)) {
				/*
				 * List<WebElement> WorkspaceListName = driver.findElements(WorkspaceNameList);
				 * 
				 * int i = 0; String Name = WorkspaceListName.get(i).getText();
				 */
				BaseSuite.validationReportLog(
						"In group section assigned groups displaying successfully and assigned group is :" + Name);
			}
			}
			else {
				BaseSuite.reportFailLog("Assigned group is not available in the list under the user/group section or page is not loading the group/user list","groupAssignDetails");
			}
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	// Neha's code
	// Method for save button should be enabled when user enter all details.

	public void SaveButtonShouldBeEnabled(SoftAssert soft) {

		// Click on user menu option
		log.info(
				"***********************************Method: SaveButtonShouldBeEnabled execution started***********************************");

		isDisplayedInLoop(driver, 30, UsersMenu);
		BaseSuite.reportLog("User menu is displayed");
		javascript(driver, "arguments[0].click();", UsersMenu);
		BaseSuite.validationReportLog("Clicked on User menu.");
		// Check if new user button is displayed or not
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		isDisplayedInLoop(driver, 20, NewUsersHeader);
		BaseSuite.reportLog("New User button is displayed.");
		javascript(driver, "arguments[0].click();", NewUsersHeader);
		BaseSuite.validationReportLog("New User button is clicked.");
		// wait for element to be displayed - username
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		isDisplayedInLoop(driver, 30, UserUsername);
		BaseSuite.validationReportLog("New user details UI is displayed");
		log.info("--------------Username textbox is displayed---------------");
		soft.assertFalse(driver.findElement(BtnSave_newUser).isEnabled()); // To confirm that save button is disabled by
																			// default
		if (!driver.findElement(BtnSave_newUser).isEnabled()) {

			log.info("--------------Inside if condition---------------");
			BaseSuite.validationReportLog("Save button is disabled, entering the new user details");
			sendKeys(driver, UserUsername, "TestUsername");
			BaseSuite.reportLog("Username is entered");
			sendKeys(driver, UserEmail, "Test@Email.com");
			BaseSuite.reportLog("Email id is entered");
			sendKeys(driver, UFirstname, "Testfirstname");
			BaseSuite.reportLog("Firstname is entered");
			sendKeys(driver, ULastname, "Testlastname");
			BaseSuite.reportLog("Lastname is entered");
			sendKeys(driver, UPassword, "12345");
			BaseSuite.reportLog("Password is entered");
			sendKeys(driver, UCPassword, "12345");
			BaseSuite.reportLog("Confirm password is entered");

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			BaseSuite.reportLog("Verifying save button after entering all data.");

			if (driver.findElement(BtnSave_newUser).isEnabled()) {
				log.info("--------------SaveButtonIsenabled---------------");
				soft.assertTrue(driver.findElement(BtnSave_newUser).isEnabled()); // validating save button is enabled.
				BaseSuite.validationReportLog("Save button is enabled after entring data in all text boxes");
			} else {
				log.info("--------------SaveButtonIsStillDisabled---------------");
				soft.assertTrue(driver.findElement(BtnSave_newUser).isEnabled());// failing the case if save button is
																					// still disabled.
				BaseSuite.reportFailLog(
						"Save button is still disabled even after entering data in all textboxes hence testcase is failed ",
						"SaveButtonShouldBeEnabled");
			}

		} else {
			BaseSuite.reportFailLog("Save button is by default enabled hence this case failed ",
					"SaveButtonShouldBeEnabled");
		}
		// To discard new user page & go to user landing page.
		BaseSuite.reportLog("Discarding the changes made on user details page");
		if (isEnabled(driver, UDiscardBtn)) {
			isDisplayedInLoop(driver, 30, UDiscardBtn);
			javascript(driver, "arguments[0].click();", UDiscardBtn);
			// need to handle another pop-up options
			BaseSuite.reportLog("Discard activity successfull,navigating back to user page");
			isDisplayedInLoop(driver, 30, UDiscardYesOpt);
			javascript(driver, "arguments[0].click();", UDiscardYesOpt);

			isDisplayed(driver, UsersMenu);
			// BaseSuite.reportLog("On User page");

		} else {
			BaseSuite.reportFailLog("Another issue observed Discard button is not enabled",
					"SaveButtonShouldBeEnabled");
		}

		log.info(
				"***********************************Method: SaveButtonShouldBeEnabled execution Ended***********************************");
	}

	// Testcase:- Verify 'blocked' & 'Delete' buttons are enabled if user is
	// selected.

	public void BlockDeleteButtonEnabledifUserSelected(SoftAssert soft) throws InterruptedException

	{
		log.info(
				"***********************************Method: BlockDeleteButtonVisibilityAsPerUserSelection execution started***********************************");
		isDisplayedInLoop(driver, 30, UsersMenu);
		BaseSuite.reportLog("User menu is displayed.");
		javascript(driver, "arguments[0].click();", UsersMenu);
		BaseSuite.validationReportLog("Clicked on User menu option.");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		BaseSuite.reportLog("Verifying Block button is disabled or not.");
		WebElement UBlock = driver.findElement(UBlockBtn);
		isDisplayedInLoop(driver, 20, UBlockBtn);
		System.out.println("Block button is displayed.");

		WebElement UDelete = driver.findElement(UDeleteBtn);
		isDisplayedInLoop(driver, 20, UDeleteBtn);
		System.out.println("Delete button is displayed.");

		isDisplayedInLoop(driver, 30, UselectAllChk);

		// declaring variable required for loop
		int count = 0, countOfCheck = 0, selectchk = 0;

		Thread.sleep(3000);

		WebElement selectAllUser = driver.findElement(UselectAllChk);
		WebElement label = driver.findElement(UlabelTUser);
		WebElement pageNo = driver.findElement(UlabelPages);

		System.out.println("------" + pageNo.getText());

		String totalNoUser = label.getText();
		String[] userAvailable = totalNoUser.substring(1).split(" "); // total user available in nextgen app
		System.out.println("************* total user available = " + userAvailable[0]);
		int totalUser = Integer.parseInt(userAvailable[0]);

		// Check block & delete button visibility by default

		if (selectAllUser.isEnabled()) {
			log.info("---------------check select all checkbox -----------------");
			// click(driver, UselectAllChk);
			javascript(driver, "arguments[0].click()", UselectAllChk);

			if (selectAllUser.isSelected()) {
				log.info("---------------Verify select all check box is selected-----------------");
				// Verify block & delete button should be enabled
				if (UBlock.isEnabled() && UDelete.isEnabled()) {

					soft.assertTrue(UBlock.isEnabled() && UDelete.isEnabled());
					BaseSuite.validationReportLog(
							"Block and delete both buttons are enabled when select all checkbox is checked for all users.");
					log.info(
							"Block and delete both buttons are enabled when select all checkbox is checked for all users.");
					javascript(driver, "arguments[0].click()", UselectAllChkF);
					log.info("-------Unchecked select all checkbox--------");
				}
			} else {
				// Raise issue unable to check check box
				// soft.assertFalse(selectAllUser.isEnabled());
				log.info("---------------Unable to check select all check box its issue-----------------");
				BaseSuite.reportFailLog("Unable to check checkbox", "verufyBlockDeleteButtonEnabledifUserSelected");
			}
		}

		// Verifying for any user selected from user listing

		if ((!UBlock.isEnabled()) && (!UDelete.isEnabled())) {
			BaseSuite.reportLog("Block & delete button is disabled.");
			BaseSuite.reportLog("Selecting user check box from list.");
			List<WebElement> chkValues = getElements(driver, USelectChk);
			count = chkValues.size();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			// boolean checked = false;
			// Loop to check any user's check box is checked or not.
			for (int i = 0; i < count; i++)

			{
				chkValues.get(i).click();
				BaseSuite.reportLog(" user check box is checked from list.");
				// Selected first checkbox & now verifying buttons
				if (UBlock.isEnabled() && UDelete.isEnabled()) {
					soft.assertTrue(UBlock.isEnabled() && UDelete.isEnabled());
					BaseSuite.validationReportLog(
							"Block & delete buttons are enabled after selecting single user from user listing.");
					log.info("Block & delete button is enabled after selecting single user from user listing.");
					chkValues.get(i).click();
					break;
				}

			}

		} else {
			soft.assertFalse(UBlock.isEnabled() && UDelete.isEnabled());
			BaseSuite.reportFailLog("Block & delete buttons are enabled by default, need verification",
					"verifyBlockNDeleteButtonsAreEnabledWhenUserIsSelected");
		}

		log.info("Redirecting to user page");
		isDisplayedInLoop(driver, 30, UsersMenu);
		// javascript(driver, "arguments[0].click();", UsersMenu);
		click(driver, UsersMenu);
		// BaseSuite.reportLog("User menu is displayed.");
		log.info(
				"********************************************************Method-BlockDeleteButtonVisibilityAsPerUserSelection excution Ended********************************************************");
	}

	// Testcase:- Verify 'blocked' & 'Delete' buttons are disabled if none of the
	// user is selected.

	public void BlockDeleteButtonDisableifNoUserSelected(SoftAssert soft) throws InterruptedException

	{

		log.info(
				"********************************************************Method-VerifyDelete&BlockBtnIsDisabled excution Started********************************************************");
		isDisplayedInLoop(driver, 30, UsersMenu);
		BaseSuite.reportLog("User menu is displayed.");
		javascript(driver, "arguments[0].click();", UsersMenu);
		BaseSuite.validationReportLog("Clicked on User menu.");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement UBlock = driver.findElement(UBlockBtn);
		isDisplayedInLoop(driver, 20, UBlockBtn);
		System.out.println("Block button is displayed.");

		WebElement UDelete = driver.findElement(UDeleteBtn);
		isDisplayedInLoop(driver, 20, UDeleteBtn);
		System.out.println("Delete button is displayed.");

		isDisplayedInLoop(driver, 30, UselectAllChk);
		log.info("'Select all' user check box is diaplayed.");

		Thread.sleep(3000);
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);

		int count = 0;
		int countOfCheck = 0, selectchk = 0;

		// WebElement label= driver.findElement(By.cssSelector("span.e-pagecountmsg"));
		WebElement selectAllUser = driver.findElement(UselectAllChk);
		// WebElement userCheckBox =driver.findElement()
		WebElement label = driver.findElement(UlabelTUser);
		WebElement pageNo = driver.findElement(UlabelPages);
		String[] pages = pageNo.getText().split(" ");
		System.out.println(
				"My total pages in pagination of user listing are " + pages[2] + "this is my first page" + pages[0]);

		int startingpageNo = 0, endpageNo = 0;

		endpageNo = Integer.parseInt(pages[2]);
		startingpageNo = Integer.parseInt(pages[0]);

		System.out.println("------" + pageNo.getText());

		String totalNoUser = label.getText();
		String[] userAvailable = totalNoUser.substring(1).split(" "); // total user available in nextgen app
		System.out.println("************* total user available in application are " + userAvailable[0]);

		// coverting string in to integer

		int totalUser = Integer.parseInt(userAvailable[0]);
		// System.out.println("************* total user available = "+userA);
		BaseSuite.reportLog(
				"Verifying if 'select all' checkbox is checked, if yes then block & delete button should be enabled.");
		BaseSuite.reportLog("Verifying if 'select all' user checkbox is enabled to select.");
		if (selectAllUser.isEnabled()) {
			BaseSuite.reportLog("Checkbox is enabled & clicking 'select all' user checkbox");
			log.info("---------------Verify select all check box is selected-----------------");
			if (selectAllUser.isSelected()) {
				BaseSuite.reportLog("'Select all' user check box is checked.");
				// Verify block & delete button should be enabled
				if (UBlock.isEnabled() && UDelete.isEnabled()) {
					soft.assertTrue(UBlock.isEnabled() && UDelete.isEnabled());
					BaseSuite.validationReportLog(
							"Block and delete both buttons are enabled as, 'select all' checkbox is checked for all users.");
					log.info(
							"Block and delete both buttons are enabled as select all checkbox is checked for all users.");
				}
			} else {
				// Verify it should be disabled
				if ((!UBlock.isEnabled()) && (!UDelete.isEnabled())) {
					BaseSuite.validationReportLog("Select all check box is unchecked.");
					soft.assertFalse(UBlock.isEnabled() || UDelete.isEnabled());
					BaseSuite.validationReportLog("Block & Delete both buttons are disabled.");
					log.info("---------------Block & delete both button are disabled-----------------");
				}
			}
		}

		BaseSuite.reportLog("Verifying no user is selected from total available user in available user listing.");

		if (totalUser < 16)

		{
			// Single cycle

			if ((!UBlock.isEnabled()) && (!UDelete.isEnabled())) {
				soft.assertFalse(UBlock.isEnabled() || UDelete.isEnabled());
				log.info("---------------Block & delete both button are disabled-----------------");
				BaseSuite.validationReportLog("Block & Delete both buttons are disabled by default.");
				BaseSuite.validationReportLog("Verifying is there is any user is selected from list or Not.");
				log.info("---------------waiting for page label to appear----------------");
				isDisplayedInLoop(driver, 30, UCountOfPages);
				log.info("--------------- page label to appear displayed ----------------");
				List<WebElement> chkValues = getElements(driver, USelectChk); // getting checkbox webelement for all
																				// users
				boolean checked = false;
				count = chkValues.size();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

				// Loop to check any user's check box is checked or not.
				for (int i = 0; i < count; i++)

				{
					checked = chkValues.get(i).isSelected();
					log.info("Checkbox at" + i + "th row is selected =" + checked);
					log.info("size of array=" + count);

					if (checked == false) // Incremented if any user is not selected.
					{
						countOfCheck = countOfCheck + 1;

					}

				}

				log.info("None of the user is selected as count of User checkbox unchecked =" + countOfCheck
						+ " & web element array count =" + count);
				BaseSuite.validationReportLog("None of the user is selected as count of User checkboxs unchecked are"
						+ countOfCheck + " & Total User checkboxes available are" + count);

				if (count == countOfCheck) {
					soft.assertEquals(count, countOfCheck);
					BaseSuite.validationReportLog("Block & Delete button is disabled as no user is selected. ");
				}
			} else {
				if (UBlock.isEnabled()) {
					soft.assertFalse(UBlock.isEnabled());
					BaseSuite.reportFailLog(
							"Test case failed as block button is enabled even when user is not selected",
							"Verify block & delete button gets disable when no user selected");
				}
				if (UDelete.isEnabled()) {
					soft.assertFalse(UDelete.isEnabled());
					BaseSuite.reportFailLog(
							"Test case failed as delete button is enabled even when user is not selected",
							"Verify block & delete button gets disable when no user selected");
				}

			}
		}
		if (totalUser > 15) {
			// as more than one page data is available we need to check every page user's
			// check box

			WebElement pageNextBtn = driver.findElement(UpaginationNextBtn);
			WebElement pageLastBtn = driver.findElement(UpaginationLastBtn);
			int totalUserCheckboxs = 0, totalcount = 0, j = 0, k = 0;

			while (startingpageNo <= endpageNo) {
				if ((!UBlock.isEnabled()) && (!UDelete.isEnabled())) {
					soft.assertFalse(UBlock.isEnabled() || UDelete.isEnabled());
					j++;
					log.info("---------------Block & delete both button are disabled for page of " + j
							+ "-----------------");

					BaseSuite.validationReportLog("Block & delete both buttons are disabled by default.");
					BaseSuite.validationReportLog("Verifying in any user is selected from list or Not.");
					log.info("---------------waiting for page label to appear----------------");
					isDisplayedInLoop(driver, 30, UCountOfPages);
					log.info("--------------- page label to appear displayed ----------------");

					List<WebElement> chkValues = getElements(driver, USelectChk);
					count = chkValues.size();
					boolean checked = false;
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					for (int i = 0; i < count; i++)

					{
						checked = chkValues.get(i).isSelected();
						k++;
						log.info("Checkbox at" + i + "th row is selected =" + checked);
						log.info("size of array=" + count);

						if (checked == false) // Incremented if any user is not selected.
						{
							countOfCheck = countOfCheck + 1;

						}

					}

					log.info("count of User checkbox unchecked =" + countOfCheck + " & web element array count ="
							+ count + "for first page of pagination=" + j);
					totalUserCheckboxs = countOfCheck;
					log.info("total user count =" + k);
					// log.info("Checking if last button is enabled ="+isEnabled(driver,
					// UpaginationLastBtn));
					pages = pageNo.getText().split(" ");
					endpageNo = Integer.parseInt(pages[2]);
					startingpageNo = Integer.parseInt(pages[0]);

					log.info("Checking if last button is enabled =" + pageNextBtn.isEnabled());
					if (startingpageNo != endpageNo) {
						click(driver, UpaginationNextBtn);

					}
					if (startingpageNo == endpageNo) {
						log.info("None of the user is selected as count of user checkboxes unchecked are "
								+ totalUserCheckboxs + " Total User checkboxes available are " + totalUser);
						BaseSuite.validationReportLog(
								"None of the user is selected as count of user checkboxs unchecked are "
										+ totalUserCheckboxs + " Total User checkboxes available are " + totalUser);
						// soft.assertEquals(totalUser, totalUserCheckboxs);
						// BaseSuite.validationReportLog("Block & delete buttons are disabled, when none
						// of user is selected");
						break;
					}

					System.out.println("***inside ***My total pages in pagination are " + pages[2]
							+ "this is my first page" + pages[0]);
				} else {
					if (UBlock.isEnabled()) {
						soft.assertFalse(UBlock.isEnabled());
						BaseSuite.reportFailLog(
								"Test case failed as block button is enabled even when user is not selected",
								"Verify block & delete button gets disable when no user selected");
						log.info("Test case failed as block button is enabled even when user is not selected");
					}
					if (UDelete.isEnabled()) {
						soft.assertFalse(UDelete.isEnabled());
						BaseSuite.reportFailLog(
								"Test case failed as delete button is enabled even when user is not selected",
								"Verify block & delete button gets disable when no user selected");
						log.info("Test case failed as Delete button is enabled even when user is not selected");
					}
				}
			}

			if (totalUserCheckboxs == k) {
				soft.assertTrue((!UBlock.isEnabled()) && (!UDelete.isEnabled()));
				BaseSuite.validationReportLog("Block & delete buttons are disabled, when none of user is selected");
				log.info("As none of the user is selected block & delete button is disabled");
			}
			log.info("*******************redirecting to user page*************************");
			isDisplayedInLoop(driver, 10, UsersMenu);
			click(driver, UsersMenu);
			log.info(
					"********************************************************Method-VerifyDelete&BlockBtnIsDisabled excution ended********************************************************");
		}

		else { // Else condition if user count is failing for above two conditions
			log.info("*******************some issue observed kindly debug*************************");
		}
	}

	public boolean verifyVisibilityOfTemporaryPasswordToggleButtons(WebDriver driver, By locator, String buttonName,
			boolean expected) {
		SoftAssert soft = new SoftAssert();
		boolean status = false;
		BaseSuite.reportLog("Checking for button " + buttonName);
		waitForElement(driver, locator);
		String toggle = getText(driver, locator);

		if (toggle.equalsIgnoreCase("Yes")) {
			status = true;

			BaseSuite.validationReportLog(buttonName + " Toggle button is On in the page");
		} else {

			BaseSuite.validationReportLog(buttonName + " Toggle button is OFF in the page");
		}

		soft.assertEquals(status, expected);

		return status;
	}

	public boolean verifyVisibilityOfStatusToggleButtons(WebDriver driver, By locator, String buttonName,
			boolean expected) {
		SoftAssert soft = new SoftAssert();
		boolean status = false;
		BaseSuite.reportLog("Checking for button " + buttonName);
		waitForElement(driver, locator);
		String toggle = getText(driver, locator);

		if (toggle.equalsIgnoreCase("Active")) {
			status = true;

			BaseSuite.validationReportLog(buttonName + " Toggle button is Active in the page");
		} else {

			BaseSuite.validationReportLog(buttonName + " Toggle button is Blocked in the page");
		}

		soft.assertEquals(status, expected);

		return status;
	}

	public void allUiElementsInNewUserPageFromAdminModule() {
		try {
			clickOnUsersMenu();

			clickOnNewButton();

			verifyVisibilityOfTemporaryPasswordToggleButtons(driver, tempPassWord, "Temporary Password", true);

			verifyVisibilityOfStatusToggleButtons(driver, statusToggle, "Status", true);

			isClickable(driver, tempPassWord, "Temporary Password", true);

			isClickable(driver, statusToggle, "Status", true);

			BaseSuite.reportLog("Click on Account from new User page");

			displayAndClick(driver, toolbarAccounts);

			BaseSuite.validationReportLog("Account clicked successfully from new User page");

			BaseSuite.reportLog("Click on Workspace from new User page");

			displayAndClick(driver, toolbarWorkspace);

			BaseSuite.validationReportLog("Workspace clicked successfully from new User page");

			BaseSuite.reportLog("Click on Groups from new User page");

			displayAndClick(driver, toolbarGroups);

			BaseSuite.validationReportLog("Groups clicked successfully from new User page");

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void allUiElementsWhenUserDetailsAreGettingUpdated(String user) {
		try {

			clickOnUsersMenu();

			searchUser(user);

			isEditable(driver, username, "Username");

			isEditable(driver, email, "Email");

			isEditable(driver, firstname, "First Name");

			isEditable(driver, lastname, "Last Name");

			isEditable(driver, password, "Password");

			isEditable(driver, confirmpassword, "Confirm Password");

			isDisplayed(driver, TempPassWord_No);

			BaseSuite.validationReportLog("Temporary Password toggle button is displayed in the page");

			isDisplayed(driver, statusToggle);

			BaseSuite.validationReportLog("Status toggle button is displayed in the page");

			BaseSuite.reportLog("Click on Account from new User page");

			displayAndClick(driver, toolbarAccounts);

			BaseSuite.validationReportLog("Account clicked successfully from new User page");

			BaseSuite.reportLog("Click on Workspace from new User page");

			displayAndClick(driver, toolbarWorkspace);

			BaseSuite.validationReportLog("Workspace clicked successfully from new User page");

			BaseSuite.reportLog("Click on Groups from new User page");

			displayAndClick(driver, toolbarGroups);

			BaseSuite.validationReportLog("Groups clicked successfully from new User page");

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void allUiElementsOnUserListingPage() {

		try {
			clickOnUsersMenu();

			isClickable(driver, selectAllCheckbox, "SelectAll Check Box", true);

			isClickable(driver, singleCheckbox, "Single Select Check Box", true);

		} catch (InterruptedException e) {

			e.getMessage();
		}
	}

	public void usersRefreshFunctionality() {
		try {
			clickOnUsersMenu();

			displayAndClick(RefreshHeader);

			boolean flag = isDisplayed(driver, spinner);

			if (flag) {
				BaseSuite.validationReportLog("Referesh spinner is visible after clicking on Referesh button");
			} else {
				BaseSuite.reportFailLog("Referesh spinner is not visible after clicking on Referesh button",
						"rolesRefereshFunctionality");

			}

			displayAndClick(selectAllCheckbox);

			displayAndClick(RefreshHeader);

			inVisible(driver, spinner, Constant.ruleWait);

			boolean selectAllFlag = isSelected(driver, selectAllCheckbox);

			if (selectAllFlag) {
				BaseSuite.reportFailLog(
						"Select all functionality is not getting unselect after clicking on Referesh button",
						"rolesRefereshFunctionality");

			} else {
				BaseSuite.validationReportLog(
						"Select all functionality is getting unselect after clicking on Referesh button");
			}

			displayAndClick(singleCheckbox);

			displayAndClick(RefreshHeader);

			inVisible(driver, spinner, Constant.ruleWait);

			boolean singleSelectFlag = isSelected(driver, selectAllCheckbox);

			if (singleSelectFlag) {
				BaseSuite.reportFailLog(
						"Single Select functionality is not getting unselect after clicking on Referesh button",
						"rolesRefereshFunctionality");

			} else {
				BaseSuite.validationReportLog(
						"Single Select functionality is getting unselect after clicking on Referesh button");
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}
	
	

}
