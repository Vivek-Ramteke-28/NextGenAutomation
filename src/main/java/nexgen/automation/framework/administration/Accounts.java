package nexgen.automation.framework.administration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.config.ReadConfig;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ExecutionResult;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.pageclasses.otherpages.HomePage;
import nexgen.automation.pageclasses.otherpages.LoginPage;

public class Accounts extends PageUtil {

	WebDriver driver;

	public Accounts(WebDriver driver) {

		this.driver = driver;

	}

	static final Logger log = Logger.getLogger(Accounts.class);

	public By AccountNameMandatoryVal = getElementLocator(prop.getProperty("Accounts.AccountNameMandatoryVal"));
	public By AccountNameSpecialCharVal = getElementLocator(prop.getProperty("Accounts.AccountNameSpecialCharVal"));
	public By DescriptionExceedCharValMsg = getElementLocator(prop.getProperty("DescriptionExceedCharValMsg"));
	public By ExceedCharValMsg = getElementLocator(prop.getProperty("Account.ExceedCharValMsg"));
	public By retrivedMsg = getElementLocator(prop.getProperty("retrivedMsg"));
	public By roleAssignmentRetrivedMsg = getElementLocator(prop.getProperty("roleAssignmentRetrivedMsg"));
	public By AccountName = getElementLocator(prop.getProperty("Accounts.AccountName"));
	public By AccountDescription = getElementLocator(prop.getProperty("Accounts.AccountDescription"));
	public By addUserTexBox = getElementLocator(prop.getProperty("addUserTexBox"));
	By AccountsMenu = getElementLocator(prop.getProperty("Accounts.AccountsSideBar"));
	By AccountNameCol = getElementLocator(prop.getProperty("Accounts.AccountNameCol"));
	By AccountDescriptionCol = getElementLocator(prop.getProperty("Accounts.AccountDescriptionCol"));
	By AccountCreatedByCol = getElementLocator(prop.getProperty("Accounts.AccountCreatedByCol"));
	By AccountLastModifiedCol = getElementLocator(prop.getProperty("Accounts.AccountLastModifiedCol"));
	By accountSearchList1 = getElementLocator(prop.getProperty("Accounts.AccountSearchList"));
	By AccountSearchDataDetails = getElementLocator(prop.getProperty("Accounts.AccountSearchDataDetails"));
	By NumberOfAccounts = getElementLocator(prop.getProperty("Accounts.NumberOfAccounts"));
	By NewAccountsBtn = getElementLocator(prop.getProperty("Accounts.NewAccountsBtn"));
	By RefreshAccountsBtn = getElementLocator(prop.getProperty("Accounts.RefreshAccountsBtn"));
	By DeleteAccountsBtn = getElementLocator(prop.getProperty("Accounts.DeleteAccountsBtn"));
	By AccountDiscardBtn = getElementLocator(prop.getProperty("Accounts.AccountDiscardBtn"));
	By AccountDiscardBtnYes = getElementLocator(prop.getProperty("Accounts.AccountDiscardBtnYes"));
	By AccountDiscardBtnNo = getElementLocator(prop.getProperty("Accounts.AccountDiscardBtnNo"));
	By AccountNameValidationMsg = getElementLocator(prop.getProperty("Accounts.AccountNameValidationMsg"));
	By UserSearchTextbox = getElementLocator(prop.getProperty("Accounts.UserSearchTextbox"));
	By UserSearchTextboxButton = getElementLocator(prop.getProperty("Accounts.UserSearchTextboxButton"));
	By UserCheckbox = getElementLocator(prop.getProperty("Accounts.UserCheckbox"));
	By RemoveAddedUserBtn = getElementLocator(prop.getProperty("Accounts.RemoveAddedUserBtn"));
	By UserRemoveBtnClickYes = getElementLocator(prop.getProperty("Accounts.UserRemoveBtnClickYes"));
	By UserRemoveBtnClickNo = getElementLocator(prop.getProperty("Accounts.UserRemoveBtnClickNo"));
	By RoleAssignmentLabel = getElementLocator(prop.getProperty("Accounts.RoleAssignmentLabel"));
	By AccessTo = getElementLocator(prop.getProperty("Accounts.AccessTo"));
	By SelectDetails = getElementLocator(prop.getProperty("Accounts.Select"));
	By AddRoleBtn = getElementLocator(prop.getProperty("Accounts.AddRoleBtn"));
	By DiscardRoleBtn = getElementLocator(prop.getProperty("Accounts.DiscardRoleBtn"));
	By Spinner = getElementLocator(prop.getProperty("Spinner"));
	

	// Updated
	By accountLink = getElementLocator(prop.getProperty("accountLink"));
	By NewAccountInput = getElementLocator(prop.getProperty("NewAccountInput"));
	By AccountDescLabel = getElementLocator(prop.getProperty("GroupDescLabel"));
	By accountCreatedMsg = getElementLocator(prop.getProperty("AccountCreatedMsg"));
	By roleAssignmentInputs = getElementLocator(prop.getProperty("roleAssignmentInputs"));
	By roleAssignmentButtons = getElementLocator(prop.getProperty("roleAssignmentButtons"));
	By roleAssignmentRoleLabel = getElementLocator(prop.getProperty("roleAssignmentRoleLabel"));
	By roleAssignmentAssignAccessToLabel = getElementLocator(prop.getProperty("roleAssignmentAssignAccessToLabel"));
	By roleAssignmentSelectLabel = getElementLocator(prop.getProperty("roleAssignmentSelectLabel"));

	//public String accountDetailsRetrivedText = prop.getProperty("accountDetailsRetrivedText");


	public String accountDescriptionDetails = prop.getProperty("accountDescriptionDetails");

	public String accountSearch = prop.getProperty("accountSearch");


	
	By addWorkspaceLabel = getElementLocator(prop.getProperty("addWorkspaceLabel"));
	By workspaceNameTextBox = getElementLocator(prop.getProperty("workspaceNameTextBox"));
	By workspaceDescriptionTextBox = getElementLocator(prop.getProperty("workspaceDescriptionTextBox"));
	By workspaceTypeDropdown = getElementLocator(prop.getProperty("workspaceTypeDropdown"));
	By addWorkspaceButton = getElementLocator(prop.getProperty("addWorkspaceButton"));
	By discardWorkspaceButton = getElementLocator(prop.getProperty("discardWorkspaceButton"));
	By workspaceNameLabel = getElementLocator(prop.getProperty("workspaceNameLabel"));
	By workspaceDescriptionLabel = getElementLocator(prop.getProperty("workspaceDescriptionLabel"));

	By workspaceTypeLabelInAccount = getElementLocator(prop.getProperty("workspaceTypeLabelInAccount"));

	By workspaceTypeLabel = getElementLocator(prop.getProperty("workspaceTypeLabel"));

	By workspaceAssignInput = getElementLocator(prop.getProperty("workspaceAssignInput"));
	By workspaceAssignButtons = getElementLocator(prop.getProperty("workspaceAssignButtons"));
	By privateTypeOption = getElementLocator(prop.getProperty("privateTypeOption"));
	By sharedTypeOption = getElementLocator(prop.getProperty("sharedTypeOption"));
	By userAssignAccessToOption = getElementLocator(prop.getProperty("userAssignAccessToOption"));
	By groupAssignAccessToOption = getElementLocator(prop.getProperty("groupAssignAccessToOption"));
	By workspaceAdd = getElementLocator(prop.getProperty("workspaceAdd"));

	
	String duplicateAccountValidationText = prop.getProperty("duplicateAccountValidationText");
	By duplicateAccountValidationMsg = getElementLocator(prop.getProperty("duplicateAccountValidationMsg"));
	

	By AccountSearchList1 = getElementLocator(prop.getProperty("Accounts.AccountSearchList"));
	By HomeLink = getElementLocator(prop.getProperty("Account.homeLink"));
	By groupLink = getElementLocator(prop.getProperty("Groups.groupLink"));
	By groupNameCol = getElementLocator(prop.getProperty("Groups.groupNameCol"));
	By groupDescriptionCol = getElementLocator(prop.getProperty("Group.groupDescriptionCol"));
	By NewGroupInput = getElementLocator(prop.getProperty("NewGroupInput"));
	By NewAccountButtons = getElementLocator(prop.getProperty("NewAccountButtons"));
	By GroupNameLabel = getElementLocator(prop.getProperty("GroupNameLabel"));
	By GroupDescLabel = getElementLocator(prop.getProperty("GroupDescLabel"));
	By NewAccountBtn = getElementLocator(prop.getProperty("Accounts.NewAccountsBtn"));
	By AccountSaveBtn = getElementLocator(prop.getProperty("Accounts.AccountSaveBtn"));
	By groupCreatedMsg = getElementLocator(prop.getProperty("GroupCreatedMsg"));
	By accountRetriveMsg = getElementLocator(prop.getProperty("AccountRetrivedMsg"));
	By commonToastMsg = getElementLocator(prop.getProperty("Commontoastmsg"));
	By UG_SearchBar = getElementLocator(prop.getProperty("Account.UserSearchTextbox"));
	By UG_SearchClick = getElementLocator(prop.getProperty("Account.UserSearchTextboxButton"));
	By UG_SearchData = getElementLocator(prop.getProperty("Account.UserSearchData"));
	By AddedGroupDetails = getElementLocator(prop.getProperty("Users.AddedGroupDetails"));
	By WS_SearchBar = getElementLocator(prop.getProperty("Account.WorkspaceTextbox"));
	By WS_SearchClick = getElementLocator(prop.getProperty("Account.WorkspaceTextboxButton"));
	By WS_SearchData = getElementLocator(prop.getProperty("Account.WorkspaceSearchData"));
	By secureAdvanceButton = getElementLocator(prop.getProperty("secure.AdvanceButton"));
	By secureProceedtounsafe = getElementLocator(prop.getProperty("secure.Proceedtounsafe"));
	By Welcometitle = getElementLocator(prop.getProperty("Landingpage.Welcome"));
	By Blocklabel = getElementLocator(prop.getProperty("Users.BlockLabel"));
	By RetriverMsg = getElementLocator(prop.getProperty("User.UserDetailsRetriveMsg"));
	By DiscardButton = getElementLocator(prop.getProperty("Accounts.AccountDiscardBtn"));
	By DiscardAlertYes = getElementLocator(prop.getProperty("Accounts.AccountDiscardBtnYes"));
	By DiscardAlertNo = getElementLocator(prop.getProperty("Accounts.AccountDiscardBtnNo"));
	By DiscardMsg = getElementLocator(prop.getProperty("Account.DiscardMsg"));
	By newaccountName = getElementLocator(prop.getProperty("Accounts.AccountName"));
	By accountDescription = getElementLocator(prop.getProperty("Accounts.AccountDescription"));
	By userGroupTab = getElementLocator(prop.getProperty("Accounts.User_GroupTab"));
	By nameLabel = getElementLocator(prop.getProperty("Account.AccountNameLabel"));
	By roleLabel = getElementLocator(prop.getProperty("Account.AccountRoleLabel"));
	By scopeLabel = getElementLocator(prop.getProperty("Account.AccountScopeLabel"));
	By typeLabel = getElementLocator(prop.getProperty("Account.AccountTypeLabel"));
	By workNameLabel = getElementLocator(prop.getProperty("Account.WorkspacetNameLabel"));
	By descLabel = getElementLocator(prop.getProperty("Account.WorkspaceDescLabel"));
	By accountLabel = getElementLocator(prop.getProperty("Account.WorkspaceAccountLabel"));
	By lastmodLabel = getElementLocator(prop.getProperty("Account.WorkspaceLastModLabel"));
	By addBtn = getElementLocator(prop.getProperty("Account.AddBtn"));
	By assignRoleLabel = getElementLocator(prop.getProperty("Account.AssignRoleLabel"));
	By roleDropLabel = getElementLocator(prop.getProperty("Account.AW_role"));
	By accessDropLabel = getElementLocator(prop.getProperty("Account.AW_assign"));
	By selectDropLabel = getElementLocator(prop.getProperty("Account.AW_select"));
	By blankrole = getElementLocator(prop.getProperty("Account.blankrole"));
	By userTextBox = getElementLocator(prop.getProperty("Account.usertextbox"));
	By assignBtnLabel = getElementLocator(prop.getProperty("Account.addBtnLabel"));
	By roleTextbox = getElementLocator(prop.getProperty("Account.roleTextBox"));
	By roleDroptxtbox = getElementLocator(prop.getProperty("Account.roleDroptxtBox"));
	By groupSelectCheck = getElementLocator(prop.getProperty("Accounts.UserCheckbox"));
	By removedBtn = getElementLocator(prop.getProperty("Accounts.RemoveAddedUserBtn"));
	By removeBtnYes = getElementLocator(prop.getProperty("Account.removeBtnYes"));
	By labelAccouttab = getElementLocator(prop.getProperty("labelAccoutTab"));
	By accountSearchBar = getElementLocator(prop.getProperty("Accounts.AccountSearchBar"));
	By accountSearchClick = getElementLocator(prop.getProperty("Accounts.AccountSearchClick"));
	By toastMsgClosedBtn = getElementLocator(prop.getProperty("ToastMsgClosedBtn1"));
	By refreshAccountsBtn = getElementLocator(prop.getProperty("Accounts.RefreshAccountsBtn"));
	By spinner = getElementLocator(prop.getProperty("Spinner"));
	By singleCheckbox = getElementLocator(prop.getProperty("Accounts.SingleCheckbox"));
	By headerTextName = getElementLocator(prop.getProperty("Accounts.HeaderTextName"));
	By headerDescription = getElementLocator(prop.getProperty("Accounts.HeaderDescription"));
	By headerAccount = getElementLocator(prop.getProperty("Accounts.HeaderAccount"));
	By headerLastModified = getElementLocator(prop.getProperty("Accounts.HeaderLastModified"));
	By headerTextType = getElementLocator(prop.getProperty("Accounts.HeaderTextType"));
	By headerTextScope = getElementLocator(prop.getProperty("Accounts.HeaderTextScope"));
	By headerTextRole = getElementLocator(prop.getProperty("Accounts.HeaderTextRole"));
	By headerUser_GroupName = getElementLocator(prop.getProperty("Accounts.HeaderUser/GroupName"));
	By headerUser_GroupType = getElementLocator(prop.getProperty("Accounts.HeaderUser/GroupType"));
	By headerUser_GroupRole = getElementLocator(prop.getProperty("Accounts.HeaderUser/GroupRole"));
	By workspaceTab = getElementLocator(prop.getProperty("Accounts.WorkspaceTab"));
	By addWorkspace = getElementLocator(prop.getProperty("Accounts.AddWorkspace"));
	By refreshWorkspace = getElementLocator(prop.getProperty("Accounts.RefreshWorkspace"));
	By removeWorkspace = getElementLocator(prop.getProperty("Accounts.RemoveWorkspace"));
	By addWorkspaceText = getElementLocator(prop.getProperty("Accounts.AddWorkspaceText"));
	By workspaceInputField = getElementLocator(prop.getProperty("Accounts.WorkspaceInputField"));
	By workspaceDescriptionInputField = getElementLocator(prop.getProperty("Accounts.WorkspaceDescriptionInputField"));
	By workspaceTypeInputField = getElementLocator(prop.getProperty("Accounts.WorkspaceTypeInputField"));
	By addRoleBtn = getElementLocator(prop.getProperty("Accounts.AddRoleBtn"));
	By discardRoleBtn = getElementLocator(prop.getProperty("Accounts.DiscardRoleBtn"));
	By addWorkspaceName = getElementLocator(prop.getProperty("Accounts.AddWorkspaceName"));
	By addWorkspaceDescription = getElementLocator(prop.getProperty("Accounts.AddWorkspaceDescription"));
	By workspaceAddMsg = getElementLocator(prop.getProperty("Account.WorkspaceAddMsg"));
	By workspaceSearchbar = getElementLocator(prop.getProperty("Accounts.WorkspaceSearchbar"));
	By workspaceSearchClick = getElementLocator(prop.getProperty("Accounts.WorkspaceSearchClick"));
	By workspaceSelectAllCheckbox = getElementLocator(prop.getProperty("Accounts.WorkspaceSelectAllCheckbox"));
	By workspaceSingleCheckbox = getElementLocator(prop.getProperty("Accounts.WorkspaceSingleCheckbox"));
	By addUser_GroupBtn = getElementLocator(prop.getProperty("Accounts.AddUser_GroupBtn"));
	By removeAddedUserBtn = getElementLocator(prop.getProperty("Accounts.RemoveAddedUserBtn"));
	By accountUserGroupSearchBar = getElementLocator(prop.getProperty("Accounts.AccountUserGroupSearchBar"));
	By accountUserGroupSearchClick = getElementLocator(prop.getProperty("Accounts.AccountUserGroupSearchClick"));
	By accountUserGroupSingleCheckbox = getElementLocator(prop.getProperty("Accounts.AccountUserGroupSingleCheckbox"));
	By removeDiscardYesButton = getElementLocator(prop.getProperty("Accounts.RemoveDiscardYesButton"));
	By userGroupRemoveMess = getElementLocator(prop.getProperty("Accounts.UserGroupRemoveMess"));
	By wrokspaceWindowTextField = getElementLocator(prop.getProperty("Accounts.WrokspaceWindowTextField"));
	By wrokspaceWindowInputField = getElementLocator(prop.getProperty("Accounts.WrokspaceWindowInputField"));
	By accessTo = getElementLocator(prop.getProperty("Accounts.AccessTo"));
	By assignDropDown = getElementLocator(prop.getProperty("Accounts.AssignDropDown"));
	By roleDropDown = getElementLocator(prop.getProperty("Accounts.RoleDropDown"));
	By selectUserName = getElementLocator(prop.getProperty("Accounts.SelectUserName"));
	// By addRoleBtn = getElementLocator(prop.getProperty("Accounts.AddRoleBtn"));
	By userGroupAddMess = getElementLocator(prop.getProperty("Accounts.UserGroupAddMess"));
	By User_GroupTab = getElementLocator(prop.getProperty("Accounts.User_GroupTab"));
	By AddUser_GroupBtn = getElementLocator(prop.getProperty("Accounts.AddUser_GroupBtn"));
	By AccountLabel = getElementLocator(prop.getProperty("User.AccountLabel"));
	By AccountNameLabel = getElementLocator(prop.getProperty("User.AccountNameLabel"));
	By AccountRoleLabel = getElementLocator(prop.getProperty("User.AccountRoleLabel"));
	By AccountScopeLabel = getElementLocator(prop.getProperty("User.AccountScopeLabel"));
	By W_SearchBar = getElementLocator(prop.getProperty("W_SearchBar"));
	By userAccountRecord = getElementLocator(prop.getProperty("Accounts.UserAccountRecord"));
	By userAccountSearchClick = getElementLocator(prop.getProperty("Accounts.UserAccountSearchClick"));
	By userAccountSearchbar = getElementLocator(prop.getProperty("Accounts.UserAccountSearchbar"));
	By userGroupRecord = getElementLocator(prop.getProperty("Accounts.UserGroupRecord"));
	By Acc_WksRefreshTab = getElementLocator(prop.getProperty("Accounts.RefreshBtnWksTab"));
	By Acc_SelectAllAccChk = getElementLocator(prop.getProperty("acc.SelectAllAcc"));
	By AccCheckbox = getElementLocator(prop.getProperty("Accounts.UserCheckbox_new"));
	By Acc_wkslist = getElementLocator(prop.getProperty("acc.WksListChk"));
	By Acc_wksSelectAll = getElementLocator(prop.getProperty("acc.WksselectAllchk"));
	By WorkspaceTab = getElementLocator(prop.getProperty("Accounts.WorkspaceTab"));
	By TotalWksInAcc = getElementLocator(prop.getProperty("acc.TotalWorkspace"));
	By AccountsSideBar = getElementLocator(prop.getProperty("Accounts.AccountsSideBar"));
	By NewAccountsB = getElementLocator(prop.getProperty("acc.NewAccountbtn"));
	By AccountNametxt = getElementLocator(prop.getProperty("acc.NameTxt"));
	By AccountDesctxtarea = getElementLocator(prop.getProperty("acc.Desctxtarea"));
	By Acc_SaceBtn = getElementLocator(prop.getProperty("acc.SaveButton"));
	By Acc_Searchtxt = getElementLocator(prop.getProperty("acc.SearchTxt"));
	By Acc_Searchbtn = getElementLocator(prop.getProperty("acc.Searchbtn"));
	By Acc_Searcheddatachk = getElementLocator(prop.getProperty("acc.rowdatachk"));
	By Acc_Searcheddatalbl = getElementLocator(prop.getProperty("acc.rowdataname"));
	By userToolbarWorkspace = getElementLocator(prop.getProperty("Users.Toolbar.Workspace"));
	By userWorkspaceSearchbar = getElementLocator(prop.getProperty("Workspace.UserWorkspaceSearchbar"));
	By userWorkspaceSearchClick = getElementLocator(prop.getProperty("Workspace.UserWorkspaceSearchClick"));
	By workspaceRoleLabel = getElementLocator(prop.getProperty("User.WorkspaceRoleLabel"));
	By workspaceAccountLabel = getElementLocator(prop.getProperty("User.WorkspaceAccountLabel"));
	By workspaceScopeLabel = getElementLocator(prop.getProperty("User.WorkspaceScopeLabel"));
	String userGroupName = prop.getProperty("Accounts.UserGroupName");
	String userGroupTypeRole = prop.getProperty("Accounts.UserGroupTypeRole");
	String userGroupAddText = prop.getProperty("Accounts.UserGroupAddText");
	String accountSearchList = prop.getProperty("Accounts.AccountSearchList");
	String accountDetailsRetrivedText = prop.getProperty("AccountDetailsRetrivedText");
	String workspaceAddText = prop.getProperty("Account.WorkspaceAddText");
	String workspaceAcc = prop.getProperty("Accounts.WorkspaceAcc");
	String nameWorkspace = prop.getProperty("Accounts.WorkspaceName");
	String userGroupRemoveText = prop.getProperty("Accounts.UserGroupRemoveText");
	String groupDeleteToastMsg = prop.getProperty("GroupDeleteText");
	String AccountSearchList = prop.getProperty("Accounts.AccountSearchList");
	String accountCreateText = prop.getProperty("AccountCreatedText");
	public String searchAccount = prop.getProperty("SearchAccount");
	//public String accountSearch = prop.getProperty("AccountSearch");
	public String userAccessTo = prop.getProperty("UserAccessTo");
	public String userSelectDetails = prop.getProperty("UserSelectDetails");
	public String userSearchName = prop.getProperty("UserSearchName");
	public String userRole = prop.getProperty("UserRole");
	public String groupSearchName = prop.getProperty("GroupSearchName");
	public String groupAccessTo = prop.getProperty("GroupAccessTo");
	public String groupRole = prop.getProperty("GroupRole");
	public String groupSelectDetails = prop.getProperty("GroupSelectDetails");
	public String accHeaderName = prop.getProperty("AccHeaderName");
	public String accHeaderType = prop.getProperty("AccHeaderType");
	public String accHeaderRole = prop.getProperty("AccHeaderRole");
	public String workspaceAddName = prop.getProperty("Account.WorkspaceAddName");
	public String workspaceAddDescription = prop.getProperty("Account.WorkspaceAddDescription");
	public String revoRemoveToastMsg = prop.getProperty("removeRevoToastMsg");
	public String existingGroupSearch = prop.getProperty("searchExistingGroup");
	public String removedGroupSearch = prop.getProperty("Account.RemovedgroupSearch");
	public String AssignRoleInAccount = prop.getProperty("Assignrole");
	public String UserGroupvalidationToast = prop.getProperty("UserGroupvalidationTxt");
	public String validationToast = prop.getProperty("ValidationTxt");
	public String AssignUserInAccount = prop.getProperty("Assignuser");
	public String workspaceSearch = prop.getProperty("Account.WorkspaceSearch");
	public String userGroupSearch = prop.getProperty("Account.userGroupSearch");
	public String NewAccountName = prop.getProperty("Account.newAccount");
	public String UpdatedAccountName = prop.getProperty("Account.Up_Accountname");
	public String UpdatedDescription = prop.getProperty("Account.Up_Desc");
	public String deletedGroup = prop.getProperty("Group.deletedgroup");
	public String singleGroupDelToastTxt = prop.getProperty("SingleDeleteText");
	public String DiscardaccountName = prop.getProperty("Account.D_Accountname");
	public String Description = prop.getProperty("Account.D_Desc");
	public String DiscardalertYes = prop.getProperty("Account.D_DiscardAlert");
	public String Account_search = prop.getProperty("Account.D_SearchExistingAccount");
	public String RetriveDetailsMsg = prop.getProperty("AccountDetailMsg");
	public String ExceedCharactersTextDetails = prop.getProperty("ExceedCharactersTextDetails");
	public String NameExceedCharErrorMsgText = prop.getProperty("NameExceedCharErrorMsgText");
	public String AccountNameSpecialCharError = prop.getProperty("AccountNameSpecialCharError");
	public String AccountNameMandatoryText = prop.getProperty("AccountNameMandatoryText");
	public String ExceedDescriptionTextDetails = prop.getProperty("ExceedDescriptionTextDetails");
	public String DescriptionExceedCharErrorMsgText = prop.getProperty("DescriptionExceedCharErrorMsgText");
	public String roleAssignmentRetrivedText = prop.getProperty("roleAssignmentRetrivedText");
	public String accountName = prop.getProperty("accountName");
	public String Acc_namesearch = prop.getProperty("acc.SearchAccName");
	public String Acc_descvar = prop.getProperty("acc.AccountDesc");
	public String Acc_searchedData_label = prop.getProperty("acc.rowdataname");
	public String roleAssign = prop.getProperty("Account.roleAssign");
	public String groupAssign = prop.getProperty("Account.groupAssign");
	public String userAssign = prop.getProperty("Account.userAssign");
	

	//****** Role based
	By AccountDropdown = getElementLocator(prop.getProperty("Workspaces.AccountDropdown"));
	By Workspacetype = getElementLocator(prop.getProperty("Workspaces.type"));
	By selectedAccount = getElementLocator(prop.getProperty("selectedAccount"));
	public String selectedAccountName1 = prop.getProperty("selectedAccountName1");
	public String selectedAccountName2 = prop.getProperty("selectedAccountName2");
	public String workspaceDescriptionDetails = prop.getProperty("workspaceDescriptionDetails");
	public String privateTypeDetails = prop.getProperty("privateTypeDetails");
	public String sharedTypeDetails = prop.getProperty("sharedTypeDetails");
	public By WorkspaceName = getElementLocator(prop.getProperty("Workspaces.WorkspaceName"));
	public By WorkspaceSaveBtn = getElementLocator(prop.getProperty("Workspaces.WorkspaceSaveBtn"));
	public String constantWorkspaceName = prop.getProperty("constantWorkspaceName");
	public String constantWorkspaceDesc = prop.getProperty("constantWorkspaceDesc");
	public String addUserInAccount = prop.getProperty("addUserInAccount");
	public String addUserInWorkspace = prop.getProperty("addUserInWorkspace");
	By NumberOfWorkspace = getElementLocator(prop.getProperty("Workspaces.NumberOfWorkspace"));
	
	public String role = prop.getProperty("role");
	public String accessto = prop.getProperty("accessto");
	public String accessToGroup = prop.getProperty("accessToGroup");
	
	public String inheritedWorkspaceDetails = prop.getProperty("inheritedWorkspaceDetails");
	public String ownerWorkspaceDetails = prop.getProperty("ownerWorkspaceDetails");
	
	By roleInheritedColumnDetails = getElementLocator(prop.getProperty("roleInheritedColumnDetails"));
	public String inheritedRoleDetailsText = prop.getProperty("inheritedRoleDetailsText");
	
	
	By roleOwnerColumnDetails = getElementLocator(prop.getProperty("roleOwnerColumnDetails"));
	public String ownerRoleDetailsText = prop.getProperty("ownerRoleDetailsText");
	
	String nonAdminValidationText = prop.getProperty("nonAdminValidationText");
	By nonAdminValidationRetrivedMsg = getElementLocator(prop.getProperty("nonAdminValidationRetrivedMsg"));
	
	
	String duplicateWorkspaceRetrivedText = prop.getProperty("duplicateWorkspaceRetrivedText");
	By duplicateWorkspaceRetrivedMsg = getElementLocator(prop.getProperty("duplicateWorkspaceRetrivedMsg"));
	
	public String updatedAccountName = prop.getProperty("updatedAccountName");
	public String updatedAccountDescription = prop.getProperty("updatedAccountDescription");
	public String NextGenAccountName = prop.getProperty("NextGenAccountName");
	public String NextGenAccountDesc = prop.getProperty("NextGenAccountDesc");
	
	public String NextGenWorkspaceName = prop.getProperty("NextGenWorkspaceName");
	public String NextGenWorkspaceDesc = prop.getProperty("NextGenWorkspaceDesc");
	
	public String workspaceUpdatedNameDetails = prop.getProperty("workspaceUpdatedNameDetails");
	public String workspaceUpdatedDescDetails = prop.getProperty("workspaceUpdatedDescDetails");
	By newWorkspaceName = getElementLocator(prop.getProperty("Workspaces.WorkspaceName"));
	By workspaceDescdetails = getElementLocator(prop.getProperty("Workspaces.WorkspaceDescription"));
	String workspaceCreatedText = prop.getProperty("workspaceCreatedText");
	By workspaceCreatedMsg = getElementLocator(prop.getProperty("workspaceCreatedMsg"));
	
	public String iCEDQ_Account = prop.getProperty("iCEDQ_Account");
	public String iCEDQ_AccountDesc = prop.getProperty("iCEDQ_AccountDesc");
	public String iCEDQ_Workspace = prop.getProperty("iCEDQ_Workspace");
	public String iCEDQ_WorkspaceDesc = prop.getProperty("iCEDQ_WorkspaceDesc");
	
	public By WorkspaceDescription = getElementLocator(prop.getProperty("Workspaces.WorkspaceDescription"));
	
	public String Workspace = prop.getProperty("Workspace");
	public String sameWorkspaceName = prop.getProperty("sameWorkspaceName");
	public String sameWorkspaceDesc = prop.getProperty("sameWorkspaceDesc");
	public By accountSearchFirstRow = getElementLocator(prop.getProperty("accountSearchFirstRow"));
	public String searchNextGenWorkspaceName = prop.getProperty("searchNextGenWorkspaceName");
	public String updateContrWorkspaceDetails = prop.getProperty("updateContrWorkspaceDetails");
	
	public String updateAccContrWS = prop.getProperty("updateAccContrWS");
	
	public By ownerOptionInDropDown= getElementLocator(prop.getProperty("ownerOptionInDropDown"));
	public By contributorOptionInDropDown= getElementLocator(prop.getProperty("contributorOptionInDropDown"));
	public By executorOptionInDropDown= getElementLocator(prop.getProperty("executorOptionInDropDown"));
	public By readerOptionInDropDown= getElementLocator(prop.getProperty("readerOptionInDropDown"));
	public By removeUserCheckbox= getElementLocator(prop.getProperty("removeUserCheckbox"));
	public By firstRowInPage= getElementLocator(prop.getProperty("firstRowInPage"));
	public String ExecutorAccount = prop.getProperty("ExecutorAccount");
	public String ExecutorWorkspace = prop.getProperty("ExecutorWorkspace");
	public String ExecutorWS = prop.getProperty("ExecutorWS");
	
	public String ContributorAccount = prop.getProperty("ContributorAccount");
	
	public By table_element1= getElementLocator(prop.getProperty("table_element1"));
	public By tableData= getElementLocator(prop.getProperty("tableData"));
	public By workspaceClickInsideAcc= getElementLocator(prop.getProperty("workspaceClickInsideAcc"));
	public By inheritedAccNameInWSTab= getElementLocator(prop.getProperty("inheritedAccNameInWSTab"));
	public By groupTypeInsideAccount= getElementLocator(prop.getProperty("groupTypeInsideAccount"));
	public String groupDetailsForAccExe = prop.getProperty("groupDetailsForAccExe");
	public By searchB= getElementLocator(prop.getProperty("searchB"));
	public By searchC= getElementLocator(prop.getProperty("searchC"));
	
	public String ReaderAccount = prop.getProperty("ReaderAccount");
	public String ReaderWorkspace = prop.getProperty("ReaderWorkspace");
	public String groupDetailsForAccReader = prop.getProperty("groupDetailsForAccReader");
	public By groupTypeDetails= getElementLocator(prop.getProperty("groupTypeDetails"));
	public By inheritedAccNameInWSTabForReader= getElementLocator(prop.getProperty("inheritedAccNameInWSTabForReader"));
	public By workspaceClickInsideAccForReader= getElementLocator(prop.getProperty("workspaceClickInsideAccForReader"));

	public String ContributorWorkspace = prop.getProperty("ContributorWorkspace");
	public String AccReaderWorkspaceDetails = prop.getProperty("AccReaderWorkspaceDetails");

	public String WorkspaceAccount = prop.getProperty("WorkspaceAccount");
	
	
	public void accountPageGridDetails() {

		String accountPageDetails = "Name/Description/Created By/Last Modified";

		if ((isDisplayed(driver, AccountNameCol)) && (isDisplayed(driver, AccountDescriptionCol))
				&& (isDisplayed(driver, AccountCreatedByCol)) && (isDisplayed(driver, AccountLastModifiedCol))) {
			BaseSuite.reportLog("Checking Columns in the Grid details of Account page!");
			BaseSuite.reportLog(accountPageDetails + " labels are displayed properly in the Account Page!");
			BaseSuite.validationReportLog("Columns in the Account page are displaying properly!");

		} else {
			BaseSuite.reportFailLog(accountPageDetails + " are not displaying in the page",
					"verifyAccountPageGridDetails");
		}
	}

	public void defaultAccountPageVerification() {

		BaseSuite.reportLog("Verifying New Button in the Account page");

		boolean newAccountButton = isEnabled(driver, NewAccountsBtn);

		if (newAccountButton) {
			BaseSuite.validationReportLog("New Account creation button is enabled");
		} else {
			BaseSuite.reportFailLog("New Account creation button is disabled", "verifyDefaultAccountPage");
		}

		BaseSuite.reportLog("Verifying Refresh Button in the Account page");

		boolean refreshButton = isEnabled(driver, RefreshAccountsBtn);

		if (refreshButton) {
			BaseSuite.validationReportLog("Refresh button is enabled");

		} else {

			BaseSuite.reportFailLog("Refresh button is disabled", "verifyDefaultAccountPage");
		}

		BaseSuite.reportLog("Verifying Delete button in the Account Page");

		boolean deleteUser = isDisplayed(driver, DeleteAccountsBtn);

		if (deleteUser) {

			BaseSuite.validationReportLog("Delete user button is disabled");

		} else {

			BaseSuite.reportFailLog("Delete user button is enabled", "verifyDefaultAccountPage");
		}

	}

	public void numberOfAccounts() throws InterruptedException {
		isDisplayedInLoop(driver, 20, NumberOfAccounts);
		Thread.sleep(3000);
		BaseSuite.reportLog("Verifying the total number of Accounts");
		String numbers = getText(driver, NumberOfAccounts);
		if(!numbers.isEmpty()) {
		BaseSuite.validationReportLog("Number of Accounts are available for the login user");
		BaseSuite.reportLog("Available Accounts " + numbers);
		BaseSuite.validationReportLog(numbers + " number of Accounts  are displaying in the Accounts Page!!!");

		}
		else
		{
			BaseSuite.reportFailLog("Number of Accounts are not displaying in the workspace page!", "numberOfAccounts");

		}
		
		
		
		
	}

	// previous method
	public void CreateAccountWithValidInvalidData(SoftAssert softAssert, String name, String description,
			String Scenario) {
		try {
			clickOnAccountsMenu();

			Thread.sleep(3000);
			isDisplayedInLoop(driver, 30, NewAccountsBtn);
			click(driver, NewAccountsBtn);

			isDisplayedInLoop(driver, 30, AccountName);
			click(driver, AccountName);
			sendKeys(driver, AccountName, name);

			isDisplayedInLoop(driver, 30, AccountDescription);
			click(driver, AccountDescription);
			sendKeys(driver, AccountDescription, description);

			if (isDisplayed(driver, AccountSaveBtn) && Scenario.equalsIgnoreCase("Valid")) {
				click(driver, AccountSaveBtn);
				BaseSuite.reportLog("New Account created successfully: Account Name is " + name);
				BaseSuite.validationReportLog("New Account created successfully");
				System.out.println("New Account created successfully");

				Thread.sleep(3000);
				clickOnAccountsMenu();

			} else if (isDisplayed(driver, AccountDiscardBtn) && Scenario.equalsIgnoreCase("Invalid")) {

				isDisplayedInLoop(driver, 40, AccountDiscardBtn);
				click(driver, AccountDiscardBtn);
				Thread.sleep(3000);
				isDisplayedInLoop(driver, 40, AccountDiscardBtnYes);
				javascript(driver, "arguments[0].click();", AccountDiscardBtnYes);

				isDisplayedInLoop(driver, 30, NewAccountsBtn);

				BaseSuite.reportLog("Account creation has been discarded " + name);
				BaseSuite.reportErrorLog("Entered data is invalid");

				System.out.println("Account creation has been discarded " + name);
				BaseSuite.validationReportLog("Account creation has been discarded successfully");
			}

			else if (isDisplayed(driver, AccountSaveBtn) && isDisplayed(driver, AccountDiscardBtn)
					&& Scenario.equalsIgnoreCase("Duplicate")) {

				click(driver, AccountSaveBtn);
				BaseSuite.reportLog("Clicked on the save button");

				if (isEnabled(driver, AccountDiscardBtn)) {
					BaseSuite.reportLog(
							"Failed to save Account :: Error: Account with same name already present in system "
									+ name);

					isDisplayedInLoop(driver, 40, AccountDiscardBtn);
					javascript(driver, "arguments[0].click();", AccountDiscardBtn);
					Thread.sleep(3000);

					isDisplayedInLoop(driver, 40, AccountDiscardBtnYes);
					javascript(driver, "arguments[0].click();", AccountDiscardBtnYes);
					isDisplayedInLoop(driver, 30, NewAccountsBtn);
				} else {
					BaseSuite.reportErrorLog("Able to create Account with same:: Account name:  " + name);
				}

				BaseSuite.reportLog("Account creation has been discarded for the duplicate account ");
			}

			else {
				BaseSuite.reportLog("Not able to create the Account");
			}

		}

		catch (Exception ex) {
			throw new AssertionError("User not able to create new account", ex);
		}
	}

	public void deleteUserOrGroupFromExistingAccount(String user_search) throws Exception {

		isDisplayedInLoop(driver, 30, User_GroupTab);
		javascript(driver, "arguments[0].click();", User_GroupTab);

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

		BaseSuite.reportLog("User/Group searched successfully!");

		Thread.sleep(2000);

		javascript(driver, "arguments[0].click();", UserCheckbox);
		javascript(driver, "arguments[0].click();", RemoveAddedUserBtn);
		BaseSuite.reportLog("Clicked on Removed button");

		// javascript(driver, "arguments[0].click();", UserRemoveBtnClickYes);
		// BaseSuite.reportLog("Clicked on removed button - Yes");
		Thread.sleep(3000);
		BaseSuite.reportLog("Deleted user from the account is " + user_search);
		System.out.println("Deleted user from the account is " + user_search);

	}

	public void roleAssignmentToGroup(String role, String accessTo, String selectDetails) throws Exception {

		verifyRoleAssignmentWindow();

		if (role.equalsIgnoreCase("Owner")) {

			role_assignment(role, accessTo, selectDetails);
		} else if (role.equalsIgnoreCase("Contributor")) {
			role_assignment(role, accessTo, selectDetails);
		}

		else if (role.equalsIgnoreCase("Executor")) {
			role_assignment(role, accessTo, selectDetails);
		} else if (role.equalsIgnoreCase("Reader")) {
			role_assignment(role, accessTo, selectDetails);
		} else {
			BaseSuite.reportFailLog("Unable to perform Role Assignment to Group", "roleAssignmentToUser");
		}

	}

	public void role_assignment(String role, String accessTo, String selectDetails) throws InterruptedException {
		try {
		BaseSuite.validationReportLog("::::Assignment of Role Started:::::");

		BaseSuite.reportLog("Checking the Role dropdown");
		isDisplayedInLoop(driver, 30, roleDropDown);
		BaseSuite.reportLog("Entering the Role details");
		sendKeys(driver, roleDropDown, role);
		BaseSuite.validationReportLog("Added Role is :::::::::::::::: " + role);

		BaseSuite.reportLog("Checking the AccessTo");
		isDisplayedInLoop(driver, 30, AccessTo);
		click(driver, AccessTo);
		Thread.sleep(2000);
		BaseSuite.reportLog("Entering the AccessTo details");
		sendKeys(driver, AccessTo, accessTo);
		click(driver, AccessTo);
		BaseSuite.reportLog("Clicked on Access Assign to");
		BaseSuite.validationReportLog("Role Assign to :::::::::::::::: " + accessTo);

		BaseSuite.reportLog("Selecting the details of User/Group");
		isDisplayedInLoop(driver, 30, SelectDetails);
		driver.findElement(By.xpath("//input[@class='e-dropdownbase']")).sendKeys(selectDetails);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='e-dropdownbase']")).sendKeys(Keys.ENTER);
		BaseSuite.validationReportLog("Selected User/Group details :::::::::::::::: " + selectDetails);
		Thread.sleep(3000);
		BaseSuite.reportLog("Checking the Add role button");
		isDisplayedInLoop(driver, 30, AddRoleBtn);
		BaseSuite.reportLog("Clicking on the Add role button");
		click(driver, AddRoleBtn);

		
			captureToastMsg(driver, roleAssignmentRetrivedMsg, toastMsgClosedBtn, roleAssignmentRetrivedText,
					"Role Assignment");
		} catch (Exception e) {
			e.printStackTrace();
		}

		BaseSuite.reportLog("Roles assignment successfully!!");
		BaseSuite.validationReportLog("Roles assignment successfully done for the User/Group :::::::::::::::: " + role);

	}

	public void accountPageUIDetails() throws InterruptedException {

		BaseSuite.reportLog("Checking the Account Page UI details.....");

		String accountPageDetails = "Home Link/Account Link/Account Menu/New Account Option/Refresh Button/Delete Button/Number of Accounts";

		if ((isDisplayed(driver, HomeLink)) && (isDisplayed(driver, accountLink)) && (isDisplayed(driver, AccountsMenu))
				&& (isDisplayed(driver, NewAccountsBtn)) && (isDisplayed(driver, RefreshAccountsBtn))
				&& (isDisplayed(driver, DeleteAccountsBtn)) && (isDisplayed(driver, NumberOfAccounts))) {
			BaseSuite.reportLog(accountPageDetails + " details of Account page are displayed!");
			BaseSuite.validationReportLog("Links, Menus and Buttons are dispayed!");

		} else {
			BaseSuite.reportFailLog(accountPageDetails + " are not displaying in the page", "accountPageUIDetails");
		}

	}

	public void clickOnAccountsMenu() throws InterruptedException {

		isDisplayedInLoop(driver, 30, AccountsMenu);
		click(driver, AccountsMenu);
		BaseSuite.validationReportLog("Clicked on the Account Menu");
		Thread.sleep(2000);
		BaseSuite.reportLog("Verifying account landing page details ");
		defaultAccountPageVerification();
		accountPageUIDetails();
		accountPageGridDetails();

		try {
			isDisplayedInLoop(driver, 30, AccountsMenu);
			click(driver, AccountsMenu);
			BaseSuite.validationReportLog("Clicked on the Account Menu");
			inVisible(driver, spinner, Constant.ruleWait);
			BaseSuite.reportLog("Verifying group landing page details ");
			defaultAccountPageVerification();
			accountPageUIDetails();
			accountPageGridDetails();
		} catch (Exception e) {
			e.getMessage();
		}


	}

	public void clickOnNewAccountButton() throws InterruptedException {
		isDisplayedInLoop(driver, 30, NewAccountsBtn);
		click(driver, NewAccountsBtn);
		BaseSuite.validationReportLog(" Clicked on the New Account button!");

		validateInputFields(driver, NewAccountInput, 1);
		validateButtons(driver, NewAccountButtons, 2);
		verifyIndividualLabel(driver, AccountNameLabel, "Account Name");
		verifyIndividualLabel(driver, AccountDescLabel, "Account Description");
		isClickable(driver, HomeLink, "Home", true);
		getAllLinkAndVerifyLinkText(driver, HomeLink, "Home");
	}

	public void clickOnSaveAccountBtn() throws InterruptedException {
		try {
		BaseSuite.reportLog("Clicking on the Save button..");
		isDisplayedInLoop(driver, 40, AccountSaveBtn);
		click(driver, AccountSaveBtn);
		BaseSuite.validationReportLog("Save button clicked successfully..");
		inVisible(driver, spinner, Constant.ruleWait);
		
			captureToastMsg(driver, accountCreatedMsg, toastMsgClosedBtn, accountCreateText, "Account Created");
			validateInputFields(driver, NewAccountInput, 1);
			validateButtons(driver, NewAccountButtons, 2);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		

	}

	public void verifyRoleAssignmentWindow() {
		try {
		BaseSuite.validationReportLog("Clicking on the User/Group tab");
		BaseSuite.reportLog("Verifying the add user/group button");
		isDisplayedInLoop(driver, 30, AddUser_GroupBtn);

		BaseSuite.reportLog("Clicking on the Add button");
		click(driver, AddUser_GroupBtn);
		BaseSuite.validationReportLog("Clicked on the Add button");

		BaseSuite.reportLog("::::::::::::: Verifying the Role Assignment Window :::::::::::::");
		isDisplayedInLoop(driver, 30, RoleAssignmentLabel);
		BaseSuite.validationReportLog("Role Assignment window is opened to add roles to the User/Group");
		validateInputFields(driver, roleAssignmentInputs, 3);
		validateButtons(driver, roleAssignmentButtons, 2);
		verifyIndividualLabel(driver, roleAssignmentRoleLabel, "Role");
		verifyIndividualLabel(driver, roleAssignmentAssignAccessToLabel, "Assign Access To");
		verifyIndividualLabel(driver, roleAssignmentSelectLabel, "Select");

		BaseSuite.reportLog("Verifying Add button");
		boolean add = isEnabled(driver, AddRoleBtn);
		if (add) {
			BaseSuite.validationReportLog("Add button is enabled");
		} else {
			BaseSuite.reportFailLog("Add is disabled", "verifyRoleAssignmentWindow");
		}

		BaseSuite.reportLog("Verifying Discard button");
		boolean discard = isDisplayed(driver, DiscardRoleBtn);
		if (discard) {

			BaseSuite.validationReportLog("Discard button is enabled");
		} else {
			BaseSuite.reportFailLog("Discard is disabled", "verifyRoleAssignmentWindow");
		}
		}
		catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
    
	}

	public void accountNameValidate(String specialCharacter, String specialCharacterKey, By locator1, By locator2,
			String backSpaceKey, String lable, String specialCharErrorMsg, String backSpaceErrorMsg, By locator3)
			throws InterruptedException {

		mandatoryFieldValidation(specialCharacter, specialCharacterKey, locator1, locator2, backSpaceKey, lable,
				specialCharErrorMsg, backSpaceErrorMsg, locator3);

		driver.navigate().refresh();
		Thread.sleep(3000);
		visible(driver, AccountName, Constant.ruleWait);
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

	public boolean accountNameWithMoreThan50Char(String exceedAccountName, By locator2, String lable, String errorMess,
			SoftAssert soft) throws InterruptedException {

		BaseSuite.reportLog("Entering the details of the Account Name with more than 50 characters:::");

		clear_Click_SendKeys(driver, 30, AccountName, exceedAccountName);
		BaseSuite.reportLog("Entered Account name: " + exceedAccountName);

		String accountNameErrmsg = getText(driver, locator2).trim();
		BaseSuite.validationReportLog("Retrived Message for " + lable + " field is :" + accountNameErrmsg);
		BaseSuite.validationReportLog("Expected Message for " + lable + " field is :" + errorMess);

		boolean status = false;
		if (!accountNameErrmsg.isEmpty()) {
			soft.assertEquals(accountNameErrmsg.trim(), errorMess.trim());
			status = true;
			BaseSuite.validationReportLog(lable + "Field Error Message Successfully Matched");
		} else {
			BaseSuite.reportFailLog(lable + "Field Error Message not Matched", "userNameWithMoreThan50Char");
			status = false;
		}
		return status;

	}

	public boolean accountDescriptionWithMoreThan250Char(String exceedAccountDescription, By locator2, String lable,
			String errorMess, SoftAssert soft) throws InterruptedException {

		BaseSuite.reportLog("Entering the details of the Account Description with more than 250 characters:::");

		clear_Click_SendKeys(driver, 30, AccountDescription, exceedAccountDescription);
		BaseSuite.reportLog("Entered Account description: " + exceedAccountDescription);

		String accountDescriptionErrmsg = getText(driver, locator2).trim();
		BaseSuite.validationReportLog("Retrived Message for " + lable + " field is :" + accountDescriptionErrmsg);
		BaseSuite.validationReportLog("Expected Message for " + lable + " field is :" + errorMess);

		boolean status = false;
		if (!accountDescriptionErrmsg.isEmpty()) {
			soft.assertEquals(accountDescriptionErrmsg.trim(), errorMess.trim());
			status = true;
			BaseSuite.validationReportLog(lable + "Field Error Message Successfully Matched");
		} else {
			BaseSuite.reportFailLog(lable + "Field Error Message not Matched", "userNameWithMoreThan50Char");
			status = false;
		}
		return status;
	}

	public void accountNameWithBlankData(By locator1, By locator2, String keysToSend, SoftAssert soft, String lable,
			String errorMess) {
		BaseSuite.reportLog("Checking validation message for Account Name textbox with blank data");
		otherMandatoryField(driver, locator1, locator2, keysToSend, soft, lable, errorMess);
		BaseSuite.validationReportLog("Account Name textbox is showing proper validation message ");
	}

	public void accountSearchFromListOfAccounts(String accountSearch) throws InterruptedException {
		BaseSuite.reportLog("Searching for Account: " + accountSearch);

		isDisplayedInLoop(driver, 30, accountSearchBar);

		javascript(driver, "arguments[0].click();", accountSearchBar);

		isDisplayedInLoop(driver, 30, accountSearchBar);

		clear_SendKeys(driver, accountSearchBar, accountSearch);

		isDisplayedInLoop(driver, 30, accountSearchClick);

		javascript(driver, "arguments[0].click();", accountSearchClick);

		BaseSuite.reportLog("Clicked on the search for the Account");

		Thread.sleep(3000);

		visible(driver, returnElement(accountSearchList, "$User", accountSearch), Constant.ruleWait);
		try {

			BaseSuite.reportLog("Click on Searched Account");

			javascript(driver, "arguments[0].click();", returnElement(accountSearchList, "$User", accountSearch));

			BaseSuite.reportLog("Clicked on Account: " + accountSearch);

			captureToastMsg(driver, retrivedMsg, toastMsgClosedBtn, accountDetailsRetrivedText,
					"Accounts detail retrieved");

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void verifyWorkspaceAssignmentWindow() throws InterruptedException {
		BaseSuite.validationReportLog("Clicking on the Workspace tab");
		BaseSuite.reportLog("Verifying the add Workspace button");

		isDisplayedInLoop(driver, 30, workspaceTab);
		click(driver, workspaceTab);
		BaseSuite.reportLog("Clicking on the Add button");
		isDisplayedInLoop(driver, 30, workspaceAdd);
		click(driver, workspaceAdd);
		BaseSuite.validationReportLog("Clicked on the Add button");
		Thread.sleep(3000);
		BaseSuite.reportLog("Verifying the Workspace Assignment Window");
		isDisplayedInLoop(driver, 30, addWorkspaceLabel);
		BaseSuite.validationReportLog("Workspace Assignment window is opened to Workspace in the Account!");
		validateInputFields(driver, workspaceAssignInput, 2);
		validateButtons(driver, workspaceAssignButtons, 2);
		verifyIndividualLabel(driver, workspaceNameLabel, "Workspace Name");
		verifyIndividualLabel(driver, workspaceDescriptionLabel, "Workspace Description");
		verifyIndividualLabel(driver, workspaceTypeLabelInAccount, "Workspace Type");

		BaseSuite.reportLog("Verifying Add button");
		boolean add = isDisplayed(driver, addWorkspaceButton);
		if (add) {
			BaseSuite.validationReportLog("Add button is disabled");
		} else {
			BaseSuite.reportFailLog("Add is displaying in the page", "verifyWorkspaceAssignmentWindow");
		}

		boolean discard = isEnabled(driver, discardWorkspaceButton);
		if (discard) {
			BaseSuite.validationReportLog("Discard is displaying in the page");

		} else {
			BaseSuite.reportFailLog("Discard is not displaying in the page", "verifyWorkspaceAssignmentWindow");
		}

		BaseSuite.reportLog("Checking the Workspace Types");
		BaseSuite.reportLog("Clicking on the Type dropdown option");
		click(driver, workspaceTypeDropdown);
		isDisplayed(driver, privateTypeOption);
		BaseSuite.validationReportLog("Private type is available in the Type dropdown option!");
		isDisplayed(driver, sharedTypeOption);
		BaseSuite.validationReportLog("Shared type is available in the Type dropdown option!");

	}
	
	
	public void validateDuplicateAccountCreation(String name, String description) throws InterruptedException
	{
		try {
		BaseSuite.reportLog("Verifying New Account button");
		isDisplayedInLoop(driver, 30, NewAccountsBtn);
		click(driver, NewAccountsBtn);
		BaseSuite.validationReportLog("Clicked on the New Account button!");

		BaseSuite.reportLog("Verifying New Account input field");
		isDisplayedInLoop(driver, 30, AccountName);
		click(driver, AccountName);
		BaseSuite.reportLog("Clicked on the New Account input field and entering the details..");
		sendKeys(driver, AccountName, name);
		BaseSuite.validationReportLog("::::::::: Entered Account Name " + name);

		BaseSuite.reportLog("Verifying New Account Description input field");
		isDisplayedInLoop(driver, 30, AccountDescription);
		click(driver, AccountDescription);
		BaseSuite.reportLog("Clicked on the New Description input field and entering the details..");
		sendKeys(driver, AccountDescription, description);
		BaseSuite.validationReportLog("::::::::: Entered Account Description " + description);
		
		BaseSuite.reportLog("Verifying Account Save button");
		isDisplayedInLoop(driver, 30, AccountSaveBtn);
		click(driver, AccountSaveBtn);
		Thread.sleep(1000);
		BaseSuite.validationReportLog("Clicked on the Save Account button");
		
	
			captureToastMsg(driver, duplicateAccountValidationMsg, toastMsgClosedBtn, duplicateAccountValidationText,"Account name already exist");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
	}
	
	
	
	

	// =============AK code=========================

	void searchGroup(String Account_search) throws Exception {

		BaseSuite.validationReportLog("Searching for account: " + Account_search);
		isDisplayedInLoop(driver, 30, UserSearchTextbox);
		javascript(driver, "arguments[0].click();", UserSearchTextbox);
		clear(driver, UserSearchTextbox);

		isDisplayedInLoop(driver, 30, UserSearchTextbox);
		BaseSuite.reportLog("Search Name");
		sendKeys(driver, UserSearchTextbox, Account_search);
		BaseSuite.reportLog("Click On searched");

		isDisplayedInLoop(driver, 30, UserSearchTextboxButton);
		javascript(driver, "arguments[0].click();", UserSearchTextboxButton);
		BaseSuite.validationReportLog("Searched account displayed successfully and name is :" + Account_search);

	}

	public void searchAccountAndClick(String Account_search) throws Exception {

		BaseSuite.validationReportLog("Searching for Account: " + Account_search);
		waitForElement(driver, UserSearchTextbox);
		isDisplayedInLoop(driver, 30, UserSearchTextbox);		
		click(driver, UserSearchTextbox);
		clear(driver, UserSearchTextbox);
		sendKeys(driver, UserSearchTextbox, Account_search);
		BaseSuite.reportLog("Entered Details of Account::::::" + Account_search );
		Thread.sleep(2000);
		isDisplayedInLoop(driver, 30, UserSearchTextboxButton);
		click(driver, UserSearchTextboxButton);
		BaseSuite.reportLog("Clicked on Searched account icon");
		Thread.sleep(3000);

		try {

			isDisplayedInLoop(driver, 30, UserSearchTextboxButton);
			BaseSuite.reportLog("Checking the listed searched account");
			boolean available = isDisplayed(driver, firstRowInPage);
			if(available) {
			click(driver, returnElement(AccountSearchList, "$User", Account_search));
			BaseSuite.validationReportLog("Clicked on account: " + Account_search);
			waitForElement(driver, toastMsgClosedBtn);
			captureToastMsg(driver, retrivedMsg, toastMsgClosedBtn, accountDetailsRetrivedText,"Accounts detail retrieved");
			
			BaseSuite.validationReportLog("Accounts Details retrieved successfully for account " + Account_search);
			}
			else
			{
				BaseSuite.reportLog("No records to display by given account name: " + Account_search + "::::::::::::::::::::::::");
			}
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

	public void discardDetailsInExistingAccount(String DiscardaccountName, String Description, String DiscardalertYes,String Account_search) throws Exception {
		clickOnAccountsMenu();

		try {

			BaseSuite.reportLog("Searching the existing account using search bar");
			Thread.sleep(2000);
			searchAccountAndClick(Account_search);
//			isDisplayedInLoop(driver, 20, newaccountName);
//			inVisible(driver, spinner, Constant.ruleWait);
//			waitForElement(driver, commonToastMsg);
//			captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, RetriveDetailsMsg, "Details retrive");
			BaseSuite.validationReportLog("existing account page is opened");

			BaseSuite.reportLog(":::Entering the details of the account:::");
			if (isEditable(driver, newaccountName, "DiscardaccountName")) {
				waitForElement(driver, newaccountName);
				Thread.sleep(2000);
				clear(driver, newaccountName);
				clear_Click_SendKeys(driver, 20, newaccountName, DiscardaccountName);
				BaseSuite.validationReportLog("Entered Users account name: " + DiscardaccountName);
				waitForElement(driver, accountDescription);
				clear(driver, accountDescription);
				clear_Click_SendKeys(driver, 20, accountDescription, Description);
				BaseSuite.validationReportLog("Entered account Description: " + Description);

				if (isEnabled(driver, DiscardButton)) {
					BaseSuite.reportLog("Clicking on the discard button");
					waitForElement(driver, DiscardButton);

					isDisplayedInLoop(driver, 30, DiscardButton);
					javascript(driver, "arguments[0].click();", DiscardButton);
					// displayAndClick(DiscardButton);

					String discardmsg = getText(driver, DiscardMsg);
					BaseSuite.validationReportLog("Alert message displaying successfully:" + discardmsg);
					if (DiscardalertYes.contains("Yes")) {
						BaseSuite.validationReportLog("Discarding account details with option 'Yes' ");
						javascript(driver, "arguments[0].click();", DiscardAlertYes);
						// click(driver, DiscardAlertYes);

					} else {
						BaseSuite.validationReportLog("User not discarding existing account details with option 'No");
						javascript(driver, "arguments[0].click();", DiscardAlertNo);
					}

					BaseSuite.validationReportLog("Existing account details discarded successfully");
				} else {
					BaseSuite.reportFailLog("Discard button not enabled", "discardDetailsInExistingAccount");
				}
			}
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void discardDetailsInNewAccount(String DiscardaccountName, String Description, String DiscardalertYes)
			throws Exception {

		clickOnAccountsMenu();

		try {
			
			clickOnNewAccountButton();
			BaseSuite.reportLog(":::Entering the details in the account:::");
			if (isEditable(driver, newaccountName, "DiscardaccountName")) {

				clear_Click_SendKeys(driver, 30, newaccountName, DiscardaccountName);
				BaseSuite.validationReportLog("Entered Users account name: " + DiscardaccountName);

				clear_Click_SendKeys(driver, 30, accountDescription, Description);
				BaseSuite.reportLog("Entered account Description: " + Description);
				waitForElement(driver, AccountSaveBtn);
				if (isEnabled(driver, AccountSaveBtn)) {
					BaseSuite.validationReportLog("To create new account save button is enabled");
					if (isEnabled(driver, DiscardButton)) {
						isDisplayedInLoop(driver, 30, DiscardButton);
						BaseSuite.reportLog("Clicking on the discard button");
						click(driver, DiscardButton);

						String discardmsg = getText(driver, DiscardMsg);
						BaseSuite.validationReportLog("Alert message displaying successfully:" + discardmsg);
						if (DiscardalertYes.contains("Yes")) {
							BaseSuite.validationReportLog("Discarding user details with option 'Yes' ");
							isDisplayedInLoop(driver, 30, DiscardAlertYes);
							click(driver, DiscardAlertYes);

						} else {
							BaseSuite.validationReportLog("User not discarding existing user details with option 'No");
							waitForElement(driver, DiscardAlertNo);
							javascript(driver, "arguments[0].click();", DiscardAlertNo);
						}

						BaseSuite.validationReportLog("New Account details discarded successfully");
					} else {
						BaseSuite.reportFailLog("Discard button not enabled", "discardDetailsInNewAccount");
					}
				} else {
					BaseSuite.reportFailLog("Save button is not enabled", "discardDetailsInNewGroup");
				}
			}
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void createValidAccount(String DiscardaccountName, String Description, String NewAccountName)
			throws Exception {
		clickOnAccountsMenu();
		try {
			Thread.sleep(2000);
			clickOnNewAccountButton();
			BaseSuite.reportLog(":::Entering the details in the Account:::");
			if (isEditable(driver, newaccountName, "AccountName")) {
				BaseSuite.reportLog("Entering new account name in account name field");
				clear_Click_SendKeys(driver, 30, newaccountName, DiscardaccountName);
				BaseSuite.validationReportLog("Entered account name is: " + DiscardaccountName);
				BaseSuite.reportLog("Entering description in description field");
				clear_Click_SendKeys(driver, 30, accountDescription, Description);
				BaseSuite.reportLog("Entered account description is: " + Description);

				if (isEnabled(driver, AccountSaveBtn)) {
					BaseSuite.reportLog("Checking for Save button is enabled or not");
					isDisplayedInLoop(driver, 30, AccountSaveBtn);
					BaseSuite.validationReportLog("New account created successfully");
					BaseSuite.reportLog("Clicking on the Save button..");
					isDisplayedInLoop(driver, 40, AccountSaveBtn);
					click(driver, AccountSaveBtn);
					BaseSuite.validationReportLog("Save button clicked successfully..");
					inVisible(driver, spinner, Constant.ruleWait);
					waitForElement(driver,toastMsgClosedBtn);
					captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, accountCreateText, "Account Created");
					driver.navigate().refresh();
					Thread.sleep(2000);

				} else {
					BaseSuite.reportFailLog("New account not created successfully: Test case failed",
							"createValidAccount");
				}

			} else {
				BaseSuite.reportFailLog("New account fields are not editable.", "createValidAccount");
			}
			clickOnAccountsMenu();
			
			searchGroup(NewAccountName);
			Thread.sleep(2000);
			String Newaccount = getText(driver, AccountSearchList1);
			BaseSuite.validationReportLog("Created account found in the list and the name of account is :" + Newaccount);
			if (getText(driver, AccountSearchList1).contains(Newaccount)) {
				BaseSuite.validationReportLog(
						"New account listed in the account list so it is confirmed that account created successfully and account name is :"
								+ Newaccount);
			} else {
				BaseSuite.reportFailLog("New account not listed in the account list", "createValidGroups");
			}
			isDisplayedInLoop(driver, 30, HomeLink);
			javascript(driver, "arguments[0].click();", HomeLink);
			driver.navigate().refresh();
			Thread.sleep(2000);

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void verifyUpdateDetailsInExistingAccountCreatedByAdmin(String UpdatedAccountName, String UpdatedDescription,
			String NewAccountName) throws Exception {
		clickOnAccountsMenu();

		try {
			Thread.sleep(2000);
			BaseSuite.reportLog("Searching the existing account using search bar");
			searchAccountAndClick(NewAccountName);
			inVisible(driver, spinner, Constant.ruleWait);
			waitForElement(driver, toastMsgClosedBtn);
			captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, RetriveDetailsMsg, "Details retrive");
			isDisplayedInLoop(driver, 30, newaccountName);
			
			BaseSuite.validationReportLog("existing account page is opened");

			BaseSuite.reportLog(":::Entering the details of the account:::");
			if (isEditable(driver, newaccountName, "UpdatedAccountName")) {
				waitForElement(driver, newaccountName);
				Thread.sleep(2000);
				clear(driver, newaccountName);
				Date d = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("M.d.yyyy_hhmm");				
				clear_Click_SendKeys(driver, 20, newaccountName, UpdatedAccountName + sdf.format(d));
				BaseSuite.validationReportLog("Entered updated account name: " + UpdatedAccountName + sdf.format(d));
				waitForElement(driver, accountDescription);
				clear(driver, accountDescription);
				clear_Click_SendKeys(driver, 20, accountDescription, UpdatedDescription);
				BaseSuite.validationReportLog("Entered account updated description: " + UpdatedDescription);

				if (isEnabled(driver, AccountSaveBtn)) {
					BaseSuite.reportLog("Checking for Save button is enabled or not");
					isDisplayedInLoop(driver, 30, AccountSaveBtn);

					BaseSuite.reportLog("Clicking on the Save button..");
					isDisplayedInLoop(driver, 40, AccountSaveBtn);
					click(driver, AccountSaveBtn);
					BaseSuite.validationReportLog("Save button clicked successfully..");
					inVisible(driver, spinner, Constant.ruleWait);
					waitForElement(driver,commonToastMsg);
					captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, accountCreateText, "Account Created");
					
					BaseSuite.validationReportLog("Existing account updated successfully and name of updated accout is :"
									+ UpdatedAccountName + sdf.format(d));
					driver.navigate().refresh();
					waitForElement(driver,AccountsMenu);
					Thread.sleep(2000);

				} else {
					BaseSuite.reportFailLog("Existing account not updated successfully: Test case failed",
							"updateDetailsInExistingAccount");
				}

			} else {
				BaseSuite.reportFailLog("Existing account fields are not editable.", "updateDetailsInExistingAccount");
			}
			clickOnAccountsMenu();			
			searchGroup(UpdatedAccountName);
			String updatedaccount = getText(driver, AccountSearchList1);
			BaseSuite.validationReportLog("Updated account found in the list and the name of newly updated account is :" + updatedaccount);
			if (getText(driver, AccountSearchList1).contains(updatedaccount)) {
				BaseSuite.validationReportLog("Updated account listed in the account list so it is confirmed that account updated successfully and account name is :" + updatedaccount);
			} else {
				BaseSuite.reportFailLog("Updated account not listed in the account list",
						"updateDetailsInExistingAccount");
			}
			isDisplayedInLoop(driver, 30, HomeLink);
			javascript(driver, "arguments[0].click();", HomeLink);
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void searchUserInUserGroupTabAccount(String Account_search, String userGroupSearch) throws Exception {
		
		try {
			clickOnAccountsMenu();
			//inVisible(driver, spinner, Constant.ruleWait);
			BaseSuite.reportLog("Searching the existing account using search bar");
			searchAccountAndClick(Account_search);

			//inVisible(driver, spinner, Constant.ruleWait);
			Thread.sleep(3000);
			isDisplayedInLoop(driver, 30, userGroupTab);
			BaseSuite.reportLog("Clicking on userGroup label");
			click(driver, userGroupTab);
			BaseSuite.validationReportLog("User able to see the list of assigned accounts");
			String AccountLabelsColumns = "Name /Type/ Role /Scope";
			if ((isDisplayed(driver, nameLabel)) && (isDisplayed(driver, roleLabel))
					&& (isDisplayed(driver, scopeLabel)) && (isDisplayed(driver, typeLabel))) {
				BaseSuite.validationReportLog(
						"In user/group section all the user/group labels name displaying successfully:"
								+ AccountLabelsColumns);
			} else {
				BaseSuite.reportFailLog("user/group labels are not available", "searchUserInUserGroupTabAccount");
			}
			isDisplayedInLoop(driver, 40, UG_SearchBar);

			BaseSuite.reportLog("Searching for assigned user/group");

			searchUserGroupAssignInAccount(userGroupSearch);
			Thread.sleep(2000);
			
			if(isAvailableInPage(driver,userGroupSearch))
			{
			waitForElement(driver, UG_SearchData);

			isDisplayedInLoop(driver, 20, UG_SearchData);

			String Name = getText(driver, UG_SearchData);
			BaseSuite.validationReportLog("Capturing the name of the search user/group and name is :" + Name);

			if (Name.equalsIgnoreCase(userGroupSearch)) {

				BaseSuite.validationReportLog("In account section assigned user/group searched successfully:" + Name);
			} 
			}
			else {
				BaseSuite.validationReportLog("Assigned user/group is not available under the account section or page not loading the user/group in the list");
			}
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void searchWorkspaceInWorkspaceTabAccount(String Account_search, String workspaceSearch) throws Exception {
		clickOnAccountsMenu();
		try {
			inVisible(driver, spinner, Constant.ruleWait);
			BaseSuite.reportLog("Searching the existing account using search bar");
			searchAccountAndClick(Account_search);
			inVisible(driver, spinner, Constant.ruleWait);
			waitForElement(driver, toastMsgClosedBtn);
			captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, RetriveDetailsMsg, "Details retrive");
			waitForElement(driver, workspaceTab);
			isDisplayedInLoop(driver, 30, workspaceTab);
			BaseSuite.reportLog("Clicking on account label");
			click(driver, workspaceTab);
			inVisible(driver, spinner, Constant.ruleWait);
			BaseSuite.validationReportLog("User able to see the list of assigned accounts");
			String AccountLabelsColumns = "Name /Description / Account  /Last Modified ";
			if ((isDisplayed(driver, workNameLabel)) && (isDisplayed(driver, descLabel))
					&& (isDisplayed(driver, accountLabel)) && (isDisplayed(driver, lastmodLabel))) {
				BaseSuite.validationReportLog(
						"In workspace section all the workspace labels name displaying successfully:"
								+ AccountLabelsColumns);
			} else {
				BaseSuite.reportFailLog("Workspace labels are not available", "searchWorkspaceInWorkspaceTabAccount");
			}
			isDisplayedInLoop(driver, 40, WS_SearchBar);

			BaseSuite.reportLog("Searching for assigned workspace");

			searchWorkspaceAssignInAccount(workspaceSearch);
			Thread.sleep(2000);
			if(isAvailableInPage(driver,workspaceSearch))
			{
			//waitForElement(driver, WS_SearchData);
				Thread.sleep(2000);
			isDisplayedInLoop(driver, 20, WS_SearchData);

			String Name = getText(driver, WS_SearchData);
			BaseSuite.validationReportLog("Capturing the name of the search workspace and name is :" + Name);

			if (Name.equalsIgnoreCase(workspaceSearch)) {

				BaseSuite.validationReportLog("In workspace section assigned workspace searched successfully:" + Name);
			}
			}
			else {
				BaseSuite.validationReportLog("Assigned workspace is not available under the workspace section or page not loading the workspace list");
			}
		}
		 catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void roleAssignWindowWithoutRoleSelection(String Account_search, String AssignUserInAccount)
			throws Exception {
		clickOnAccountsMenu();
		try {
			inVisible(driver, spinner, Constant.ruleWait);
			BaseSuite.reportLog("Searching the existing account using search bar");
			searchAccountAndClick(Account_search);
			inVisible(driver, spinner, Constant.ruleWait);
			waitForElement(driver, toastMsgClosedBtn);
			captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, RetriveDetailsMsg, "Details retrive");
			BaseSuite.validationReportLog("existing account page is opened");
			isDisplayedInLoop(driver, 30, userGroupTab);
			BaseSuite.reportLog("Clicking on userGroup label");
			click(driver, userGroupTab);

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
						clear_Click_SendKeys(driver, 30, userTextBox, AssignUserInAccount);
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
								"roleAssignWindowWithoutRoleSelection");
					}

				} else {
					BaseSuite.reportFailLog("Role assign window not getting opened",
							"roleAssignWindowWithoutRoleSelection");
				}
			}

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void roleAssignWindowWithoutUserGroupSelection(String Account_search, String AssignRoleInAccount)
			throws Exception {
		clickOnAccountsMenu();
		try {
			inVisible(driver, spinner, Constant.ruleWait);
			BaseSuite.reportLog("Searching the existing account using search bar");
			searchAccountAndClick(Account_search);
			inVisible(driver, spinner, Constant.ruleWait);
			waitForElement(driver, toastMsgClosedBtn);
			captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, RetriveDetailsMsg, "Details retrive");
			BaseSuite.validationReportLog("existing account page is opened");
			isDisplayedInLoop(driver, 30, userGroupTab);
			BaseSuite.reportLog("Clicking on userGroup label");
			click(driver, userGroupTab);

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
						isDisplayedInLoop(driver, 30, roleDropLabel);
						isDisplayedInLoop(driver, 20, roleTextbox);
						waitForElement(driver, roleTextbox);
						javascript(driver, "arguments[0].click();", roleTextbox);
						BaseSuite.reportLog("Selecting role to assign");
						// click(driver,roleTextbox);
						sendKeys(driver, roleTextbox, AssignRoleInAccount);
						BaseSuite.validationReportLog("User selected the role : " + AssignRoleInAccount);
						// clear_Click_SendKeys(driver, 30, roleTextbox, AssignRoleInAccount);

						// sendKeys(driver, addUserTextBox, AssignUserName);
						Thread.sleep(2000);
						
						// driver.findElement(roleTextbox).sendKeys(Keys.ENTER);
						isDisplayedInLoop(driver, 30, assignBtnLabel);
						BaseSuite.reportLog("Click on add button");
						javascript(driver, "arguments[0].click();", assignBtnLabel);
						// click(driver, assignBtnLabel);
						// Thread.sleep(2000);
						BaseSuite.reportLog("Validation message should be display for select role field ");
						waitForElement(driver, commonToastMsg);
						captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, UserGroupvalidationToast,
								"Select user/group field");

						BaseSuite.validationReportLog(
								"Correct validation alert message getting displayed for select user/group field");

					} else {
						BaseSuite.reportFailLog(
								"User able to add the user without selection of user/group or user/group name selected by default",
								"roleAssignWindowWithoutUserGroupSelection");
					}

				} else {
					BaseSuite.reportFailLog("Role assign window not getting opened",
							"roleAssignWindowWithoutUserGroupSelection");
				}
			}

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void removeRoleCheckInGroup(String Account_search, String removedGroupSearch, String existingGroupSearch,String roleAssign,String groupAssign)
			throws Exception {
		clickOnAccountsMenu();
		try {
			inVisible(driver, spinner, Constant.ruleWait);
			BaseSuite.reportLog("Searching the existing account using search bar");
			searchAccountAndClick(Account_search);
			inVisible(driver, spinner, Constant.ruleWait);
			waitForElement(driver, toastMsgClosedBtn);
			captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, RetriveDetailsMsg, "Details retrive");
			Thread.sleep(2000);
			assigRoles(roleAssign,groupAssign);
			assignSingleUserGroup(removedGroupSearch);
			addRoleAssignButton();
			Thread.sleep(2000);
			searchUserGroupAssignInAccount(removedGroupSearch);
			inVisible(driver, spinner, Constant.ruleWait);
			BaseSuite.validationReportLog("Group searched successfully :" + removedGroupSearch);
			BaseSuite.reportLog("Select searched group checkbox to remove the group from the account");
			isDisplayedInLoop(driver, 20, groupSelectCheck);
			javascript(driver, "arguments[0].click();", groupSelectCheck);
			BaseSuite.reportLog("Searched group selected succussfully");

			BaseSuite.reportLog("Check remove button enabled or not after selection of group");
			if (isEnabled(driver, removedBtn)) {
				BaseSuite.validationReportLog("Remove button enabled after selection of group");
				isDisplayedInLoop(driver, 20, removedBtn);
				BaseSuite.reportLog("Clicking on the remove button");
				javascript(driver, "arguments[0].click();", removedBtn);
				visible(driver, removeBtnYes, Constant.ruleWait);

				boolean flag = isDisplayed(driver, removeBtnYes);
				if (flag) {
					BaseSuite.validationReportLog(
							"User/Group remove discard pop up is dispalyed in the page after clickog on Remove button");
					displayAndClick(driver, removeBtnYes);
					BaseSuite.validationReportLog("User/Group remove conformation message accept successfully");
				} else {
					BaseSuite.reportFailLog(
							"User/Group remove discard pop up is not dispalyed in the page after clickog on Remove button",
							"removeRoleCheckInGroup");
				}
				inVisible(driver, spinner, Constant.ruleWait);
				BaseSuite.reportLog("Validating the correct toast message after removing the group from account");
				waitForElement(driver, commonToastMsg);
				captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, revoRemoveToastMsg, "Group remove");
			} else {
				BaseSuite.reportFailLog("Remove button not enabled after the selection of group",
						"removeRoleCheckInGroup");
			}

			Groups grp = new Groups(driver);
			grp.clickOnGroupsMenu();
			inVisible(driver, spinner, Constant.ruleWait);
			grp.searchGroupAndClick(existingGroupSearch);

			isDisplayedInLoop(driver, 30, labelAccouttab);

			BaseSuite.reportLog("Clicking on the Account tab");
			javascript(driver, "arguments[0].click();", labelAccouttab);
			inVisible(driver, spinner, Constant.ruleWait);
			BaseSuite.validationReportLog("Account tab opened successfully");
			BaseSuite.reportLog("Searching for account from which group has been deleted");
			grp.searchAccountAssignInGroup(Account_search);

			boolean flag = !isAvailableInPage(driver, Account_search);
			if (flag) {
				BaseSuite.validationReportLog("Assigned group deleted successfully from account");
			} else {
				BaseSuite.reportFailLog("Assigned group not deleted from the account", "removeRoleCheckInGroup");
			}
		} catch (Exception e) {

		}
	}

	public void accountSearchWithPagination(String PaginationPoint) throws Exception
	{
		clickOnAccountsMenu();
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
	
	
	
	
	
	// ==========Dhawal's Code===================//

	public void adminCanRefreshUserGroupListUsingRefreshButton(String accountSearch, String accHeaderName,
			String accHeaderType, String accHeaderRole) throws InterruptedException {

		clickOnAccountsMenu();
		accountSearchFromList(accountSearch);
		accountInsideUserGroupPageGridDetails();
		refereshButtonClick(accHeaderName, accHeaderType, accHeaderRole);

	}

	public void accountSearchFromList(String accountSearch) {
		BaseSuite.reportLog("Searching for Account: " + accountSearch);

		isDisplayedInLoop(driver, 30, accountSearchBar);

		javascript(driver, "arguments[0].click();", accountSearchBar);

		isDisplayedInLoop(driver, 30, accountSearchBar);

		clear_SendKeys(driver, accountSearchBar, accountSearch);

		isDisplayedInLoop(driver, 30, accountSearchClick);

		javascript(driver, "arguments[0].click();", accountSearchClick);

		BaseSuite.reportLog("Clicked on the search for the Account");

		visible(driver, returnElement(accountSearchList, "$User", accountSearch), Constant.ruleWait);
		try {

			BaseSuite.reportLog("Click on Searched Account");

			javascript(driver, "arguments[0].click();", returnElement(accountSearchList, "$User", accountSearch));

			BaseSuite.reportLog("Clicked on Account: " + accountSearch);

			inVisible(driver, spinner, Constant.ruleWait);

			captureToastMsg(driver, retrivedMsg, toastMsgClosedBtn, accountDetailsRetrivedText,
					"Accounts detail retrieved");

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void assigRoles(String role, String accessto) throws InterruptedException {

		isDisplayed(driver, User_GroupTab);
		javascript(driver, "arguments[0].click();", User_GroupTab);
		BaseSuite.validationReportLog("Clicked on the User/Group tab");

		isDisplayedInLoop(driver, 30, AddUser_GroupBtn);
		BaseSuite.reportLog("Clicking on the Add User/Group button ");
		javascript(driver, "arguments[0].click();", AddUser_GroupBtn);
		BaseSuite.validationReportLog("Clicked on the Add User/Group button");

		BaseSuite.reportLog("Checking the Role dropdown");
		isDisplayedInLoop(driver, 30, roleDropDown);
		BaseSuite.reportLog("Entering the Role details");
		sendKeys(driver, roleDropDown, role);
		BaseSuite.validationReportLog("Added Role is :::: " + role);

		BaseSuite.reportLog("Checking the AccessTo");
		isDisplayedInLoop(driver, 30, accessTo);
		click(driver, accessTo);
		Thread.sleep(2000);
		BaseSuite.reportLog("Entering the AccessTo details");
		sendKeys(driver, assignDropDown, accessto);
		click(driver, accessTo);
		BaseSuite.reportLog("Clicked on Access Assign to");
		BaseSuite.validationReportLog("Role Assign to :::: " + accessto);

	}

	public void assignMultipleUserGroup(String colName) {
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
				BaseSuite.validationReportLog("Selected Group/User details is --" + add);
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void assignSingleUserGroup(String selectUserGroup) {

		try {
			BaseSuite.reportLog("Selecting the details of Group/User");
			isDisplayedInLoop(driver, 30, selectUserName);
			driver.findElement(selectUserName).sendKeys(selectUserGroup);
			Thread.sleep(2000);
			driver.findElement(selectUserName).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			BaseSuite.validationReportLog("Selected Group/User details is :::: " + selectUserGroup);
		} catch (Exception e) {
			e.getMessage();

		}

	}

	public void addRoleAssignButton() {
		try {
		BaseSuite.reportLog("Checking the Add role button");
		isDisplayedInLoop(driver, 30, addRoleBtn);
		BaseSuite.reportLog("Clicking on the Add role button");
		displayAndClick(driver, addRoleBtn);
		inVisible(driver, spinner, Constant.ruleWait);
		waitForElement(driver,userGroupAddMess);
		
			captureToastMsg(driver, userGroupAddMess, toastMsgClosedBtn, userGroupAddText, "Role Assignment");
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}
	
	public void userDetailsShouldDisplayedCorrectlyAfterUserHasBeenAddedByAdminOnAccount(String usersearch,String accountSearch,String roleType)
	{

		try {
			
			BaseSuite.validationReportLog("Revisiting in User Tab to check the addition of Account details");
			Users user = new Users(driver);
			user.clickOnUsersMenu();
			user.searchUser(usersearch);
			isDisplayedInLoop(driver, 20, AccountLabel);
			BaseSuite.reportLog("Clicking on account label");
			displayAndClick(driver, AccountLabel);
			inVisible(driver, spinner, Constant.ruleWait);
			BaseSuite.validationReportLog("Account tab clicked successfully");
			String AccountLabelsColumns = "Name /Role /Scope";
			if ((isDisplayed(driver, AccountNameLabel)) && (isDisplayed(driver, AccountRoleLabel))
					&& (isDisplayed(driver, AccountScopeLabel))) {
				BaseSuite.validationReportLog("In account section all the account labels name displaying successfully:"
						+ AccountLabelsColumns);
			} else {
				BaseSuite.reportFailLog("Account labels are not available", "accountAssignDetails");
			}
			BaseSuite.reportLog("Searching for assigned accounts");
			javascript(driver, "window.scrollTo(0, document.body.scrollHeight)");
			BaseSuite.reportLog("Searching for workspace/account/group: ");
			isDisplayedInLoop(driver, 30, userAccountSearchbar);
			javascript(driver, "arguments[0].click();", userAccountSearchbar);
			clear(driver, userAccountSearchbar);

			isDisplayedInLoop(driver, 30, userAccountSearchbar);
			BaseSuite.reportLog("Search Name");
			sendKeys(driver, userAccountSearchbar, accountSearch);
			BaseSuite.reportLog("Click on searched");
			
			isDisplayedInLoop(driver, 30, userAccountSearchClick);
			javascript(driver, "arguments[0].click();", userAccountSearchClick);
			
			
			BaseSuite.reportLog("Verifying Account datials after User has been added to Account");
			
			String nameUserGroupValue = getText(driver, returnElement(userGroupName, "$User", accountSearch)).trim();
			if (nameUserGroupValue.equalsIgnoreCase(accountSearch.trim())) {
				BaseSuite.validationReportLog("Account Name detailed in User page matched successfully : " + accountSearch);
			} else {
				BaseSuite.reportFailLog("Account Name detailed in User page not matched", "UserDetailsShouldDisplayedCorrectlyAfterUserHasBeenAddedToWorkspace");

			}
			
			
			String roleUserGroupValue = getText(driver,  returnElement(userGroupTypeRole, "$User", roleType)).trim();

			if (roleUserGroupValue.equalsIgnoreCase(roleType.trim())) {
				BaseSuite.validationReportLog("Account Role detailed in User page matched successfully : " + roleType);
			} else {
				BaseSuite.reportFailLog("Account Role detailed in User page not matched", "UserDetailsShouldDisplayedCorrectlyAfterUserHasBeenAddedToWorkspace");

			}
	}catch (Exception e) {
		e.getMessage();
	}

	}
	
	public void groupDetailsShouldDisplayedCorrectlyAfterGroupHasBeenAddedByAdminOnAccount(String groupsearch,String accountSearch,String roleType)
	{

		try {
			
			BaseSuite.validationReportLog("Revisiting in Group Tab to check the addition of Account details");
			Groups grp = new Groups(driver);
			grp.clickOnGroupsMenu();
			grp.searchGroupAndClick(groupsearch);
			isDisplayedInLoop(driver, 20, AccountLabel);
			BaseSuite.reportLog("Clicking on account label");
			displayAndClick(driver, AccountLabel);
			inVisible(driver, spinner, Constant.ruleWait);
			BaseSuite.validationReportLog("Account tab clicked successfully");
			String AccountLabelsColumns = "Name /Role /Scope";
			if ((isDisplayed(driver, AccountNameLabel)) && (isDisplayed(driver, AccountRoleLabel))
					&& (isDisplayed(driver, AccountScopeLabel))) {
				BaseSuite.validationReportLog("In account section all the account labels name displaying successfully:"
						+ AccountLabelsColumns);
			} else {
				BaseSuite.reportFailLog("Account labels are not available", "accountAssignDetails");
			}
			BaseSuite.reportLog("Searching for assigned accounts");
			javascript(driver, "window.scrollTo(0, document.body.scrollHeight)");
			BaseSuite.reportLog("Searching for workspace/account/group: ");
			isDisplayedInLoop(driver, 30, userAccountSearchbar);
			javascript(driver, "arguments[0].click();", userAccountSearchbar);
			clear(driver, userAccountSearchbar);

			isDisplayedInLoop(driver, 30, userAccountSearchbar);
			BaseSuite.reportLog("Search Name");
			sendKeys(driver, userAccountSearchbar, accountSearch);
			BaseSuite.reportLog("Click on searched");
			
			isDisplayedInLoop(driver, 30, userAccountSearchClick);
			javascript(driver, "arguments[0].click();", userAccountSearchClick);
			
			
			BaseSuite.reportLog("Verifying Account datials after Group has been added to Account");
			
			String nameUserGroupValue = getText(driver, returnElement(userGroupName, "$User", accountSearch)).trim();
			if (nameUserGroupValue.equalsIgnoreCase(accountSearch.trim())) {
				BaseSuite.validationReportLog("Account Name detailed in Group page matched successfully : " + accountSearch);
			} else {
				BaseSuite.reportFailLog("Account Name detailed in Group page not matched", "UserDetailsShouldDisplayedCorrectlyAfterUserHasBeenAddedToWorkspace");

			}
			
			
			String roleUserGroupValue = getText(driver,  returnElement(userGroupTypeRole, "$User", roleType)).trim();

			if (roleUserGroupValue.equalsIgnoreCase(roleType.trim())) {
				BaseSuite.validationReportLog("Account Role detailed in Group page matched successfully : " + roleType);
			} else {
				BaseSuite.reportFailLog("Account Role detailed in Group page not matched", "UserDetailsShouldDisplayedCorrectlyAfterUserHasBeenAddedToWorkspace");

			}
	}catch (Exception e) {
		e.getMessage();
	}

	}
	
	

	public void refereshButtonClick(String accHeaderName, String accHeaderType, String accHeaderRole) {
		try {
		BaseSuite.reportLog("Clicking on Referesh Button");

		displayAndClick(driver, refreshAccountsBtn);

		BaseSuite.validationReportLog("Referesh Button clicked Successfully ");

		boolean flag = isDisplayed(driver, spinner);

		if (flag) {
			BaseSuite.validationReportLog("Referesh spinner is visible after clicking on Referesh button");
		} else {
			BaseSuite.reportFailLog("Referesh spinner is not visible after clicking on Referesh button",
					"refereshButtonClick");

		}

		
			captureToastMsg(driver, retrivedMsg, toastMsgClosedBtn, accountDetailsRetrivedText,
					"Accounts detail retrieved");
		} catch (Exception e) {
		
			e.printStackTrace();
		}

		String name = getText(driver, headerUser_GroupName).trim();

		if (name.equalsIgnoreCase(accHeaderName.trim())) {
			BaseSuite.validationReportLog(
					"User/Group Name in Accounts detailed page matched successfully : " + accHeaderName);
		} else {
			BaseSuite.reportFailLog("User/Group Name in Accounts detailed page not matched", "refereshButtonClick");

		}

		String type = getText(driver, headerUser_GroupType).trim();

		if (type.equalsIgnoreCase(accHeaderType.trim())) {
			BaseSuite.validationReportLog(
					"User/Group Type in Accounts detailed page matched successfully : " + accHeaderType);
		} else {
			BaseSuite.reportFailLog("User/Group Type in Accounts detailed page not matched", "refereshButtonClick");

		}

		String role = getText(driver, headerUser_GroupRole).trim();

		if (role.equalsIgnoreCase(accHeaderRole.trim())) {
			BaseSuite.validationReportLog(
					"User/Group Role in Accounts detailed page matched successfully : " + accHeaderRole);
		} else {
			BaseSuite.reportFailLog("User/Group Role in Accounts detailed page not matched", "refereshButtonClick");

		}

		displayAndClick(driver, singleCheckbox);

		displayAndClick(driver, refreshAccountsBtn);

		inVisible(driver, spinner, Constant.ruleWait);

		try {
			captureToastMsg(driver, retrivedMsg, toastMsgClosedBtn, accountDetailsRetrivedText,
					"Accounts detail retrieved");
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		boolean singleSelectFlag = isSelected(driver, singleCheckbox);

		if (singleSelectFlag) {
			BaseSuite.reportFailLog(
					"Single Select functionality is not getting unselect after clicking on Referesh button",
					"rolesRefereshFunctionality");

		} else {
			BaseSuite.validationReportLog(
					"Single Select functionality is getting unselect after clicking on Referesh button");
		}

	}

	public void accountInsideUserGroupPageGridDetails() {

		String userPageDetails = "Name/Type/Role/Scope";

		if ((isDisplayed(driver, headerTextName)) && (isDisplayed(driver, headerTextType))
				&& (isDisplayed(driver, headerTextRole)) && (isDisplayed(driver, headerTextScope))) {
			BaseSuite.reportLog("Checking Columns in the Grid details of Account Inside page!");
			BaseSuite.reportLog(userPageDetails + " labels are displayed properly in the Account Inside Page!");
			BaseSuite.validationReportLog("Columns Inside Account page are displaying properly!");

		} else {
			BaseSuite.reportFailLog(userPageDetails + " are not displaying in the page",
					"accountInsidePageGridDetails");
		}

		userGroupTab();
	}

	public void accountInsideWorkspacePageGridDetails() {

		String userPageDetails = "Name/Description/Account/Last Modified";

		if ((isDisplayed(driver, headerTextName)) && (isDisplayed(driver, headerDescription))
				&& (isDisplayed(driver, headerAccount)) && (isDisplayed(driver, headerLastModified))) {
			BaseSuite.reportLog("Checking Columns in the Grid details of Account Inside Workspace page!");
			BaseSuite.reportLog(userPageDetails + " labels are displayed properly in the Account Inside Page!");
			BaseSuite.validationReportLog("Columns Inside Account page are displaying properly!");

		} else {
			BaseSuite.reportFailLog(userPageDetails + " are not displaying in the page",
					"accountInsideWorkspacePageGridDetails");
		}
	}

	public void worspaceTab() throws InterruptedException {
		BaseSuite.reportLog("Clicking on Workspace Tab");

		displayAndClick(driver, workspaceTab);

		Thread.sleep(3000);
		BaseSuite.validationReportLog(" Workspace Tab clicked Successfully ");

		accountInsideWorkspacePageGridDetails();

		boolean add = isEnabled(driver, addWorkspace);
		if (add) {
			BaseSuite.validationReportLog("Add is displaying in the page");

		} else {
			BaseSuite.reportFailLog("Add is not displaying in the page", "worspaceTab");
		}

		boolean refresh = isEnabled(driver, refreshWorkspace);
		if (refresh) {
			BaseSuite.validationReportLog("Refresh is displaying in the page");

		} else {
			BaseSuite.reportFailLog("Refresh is not displaying in the page", "worspaceTab");
		}

		boolean remove = isDisplayed(driver, removeWorkspace);

		if (remove) {
			BaseSuite.validationReportLog("Remove is not displaying in the page");
		} else {
			BaseSuite.reportFailLog("Remove is displaying in the page", "worspaceTab");
		}
	}

	public void userGroupTab() {
		boolean add = isEnabled(driver, addUser_GroupBtn);
		if (add) {
			BaseSuite.validationReportLog("Add is displaying in the page");

		} else {
			BaseSuite.reportFailLog("Add is not displaying in the page", "worspaceTab");
		}

		boolean refresh = isEnabled(driver, refreshAccountsBtn);
		if (refresh) {
			BaseSuite.validationReportLog("Refresh is displaying in the page");

		} else {
			BaseSuite.reportFailLog("Refresh is not displaying in the page", "worspaceTab");
		}

		boolean remove = isDisplayed(driver, removeAddedUserBtn);

		if (remove) {
			BaseSuite.validationReportLog("Remove is not displaying in the page");
		} else {
			BaseSuite.reportFailLog("Remove is displaying in the page", "worspaceTab");
		}
	}

	public void verifyAddWorkspacePage() {

		validateInputFields(driver, wrokspaceWindowInputField, 2);

		validateTextFields(driver, wrokspaceWindowTextField, 1);

		String userPageDetails = "Add Wrokspace Text/Workspace Field/Description Field/Type Field";

		if ((isDisplayed(driver, addWorkspaceText)) && (isDisplayed(driver, workspaceInputField))
				&& (isDisplayed(driver, workspaceDescriptionInputField))
				&& (isDisplayed(driver, workspaceTypeInputField))) {
			BaseSuite.reportLog("Checking Text/Field label in Add Workspace page!");
			BaseSuite.reportLog(userPageDetails + " labels are displayed properly in Add Workspace page!");
			BaseSuite.validationReportLog("Text/Field label in Add Workspace page are displaying properly!");

		} else {
			BaseSuite.reportFailLog(userPageDetails + " are not displaying in the page", "verifyAddWorkspacePage");
		}

		boolean add = isDisplayed(driver, addRoleBtn);
		if (add) {
			BaseSuite.validationReportLog("Add is not displaying in the page");
		} else {
			BaseSuite.reportFailLog("Add is displaying in the page", "worspaceTab");
		}

		boolean discard = isDisplayed(driver, discardRoleBtn);
		if (discard) {
			BaseSuite.validationReportLog("Discard is displaying in the page");

		} else {
			BaseSuite.reportFailLog("Discard is not displaying in the page", "worspaceTab");
		}

	}

	public void assignWorkspace(String workspaceName, String decs) {
		try {
		BaseSuite.reportLog("Clicking on Add button to assign Workspace");

		displayAndClick(driver, addWorkspace);

		BaseSuite.validationReportLog("Add button clicked Successfully to assign Workspace");

		visible(driver, addWorkspaceText, Constant.ruleWait);

		verifyAddWorkspacePage();

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String WSname = workspaceName + timeStamp;
		String WSDesc = workspaceName + timeStamp;
		
		
		BaseSuite.reportLog("Entering Workspace name in workspace field");

		displayAndClick(driver, addWorkspaceName);

		sendKeys(driver, addWorkspaceName, WSname);

		BaseSuite.validationReportLog("Workspace name entered successfully in workspace field ::: " + WSname);

		BaseSuite.reportLog("Entering Workspace Description in description field " + WSname);

		displayAndClick(driver, addWorkspaceDescription);

		sendKeys(driver, addWorkspaceDescription, WSDesc);

		BaseSuite.validationReportLog("Workspace Description entered successfully in description field ::: " + WSDesc);

		BaseSuite.reportLog("Clicking on Add button to add Workspace");

		displayAndClick(driver, addRoleBtn);

		BaseSuite.validationReportLog("Add button clicked Successfully to add Workspace");

		inVisible(driver, spinner, Constant.ruleWait);

		
			captureToastMsg(driver, workspaceAddMsg, toastMsgClosedBtn, workspaceAddText, "Add Workspace");
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	public void verifyAddedWorkspace(String workspaceName, String workspaceDec) {

		isDisplayedInLoop(driver, 30, refreshWorkspace);
		javascript(driver, "arguments[0].click();", refreshWorkspace);
		
		BaseSuite.reportLog("Searching for Workspace: " + workspaceName);
		isDisplayedInLoop(driver, 30, workspaceSearchbar);

		javascript(driver, "arguments[0].click();", workspaceSearchbar);
		clear(driver, workspaceSearchbar);

		isDisplayedInLoop(driver, 30, workspaceSearchbar);
		BaseSuite.reportLog("Entering search Name in search bar");
		sendKeys(driver, workspaceSearchbar, workspaceName);
		BaseSuite.reportLog("searched name entered successfully");

		isDisplayedInLoop(driver, 30, workspaceSearchClick);

		javascript(driver, "arguments[0].click();", workspaceSearchClick);

		BaseSuite.validationReportLog("Clicked on the search for the role");
		try {

			isDisplayedInLoop(driver, 30, returnElement(nameWorkspace, "$User", workspaceName));

			String workspaceN = getText(driver, returnElement(nameWorkspace, "$User", workspaceName));

			if (workspaceN.equalsIgnoreCase(workspaceName)) {
				BaseSuite.validationReportLog("Workspace Name matched successfully : " + workspaceName);
			} else {
				BaseSuite.reportFailLog("Workspace Name not matched", "verifysearchRole");

			}

			isDisplayedInLoop(driver, 30, returnElement(workspaceAcc, "$User", workspaceDec));

			String workspaceD = getText(driver, returnElement(workspaceAcc, "$User", workspaceDec));

			if (workspaceD.equalsIgnoreCase(workspaceDec)) {
				BaseSuite.validationReportLog("Workspace Description matched successfully : " + workspaceDec);
			} else {
				BaseSuite.reportFailLog("Workspace Description not matched", "verifysearchRole");

			}

		} catch (Exception e) {
			e.getMessage();

		}

	}

	public void adminCanAddNewWorkspaceFromWorkspaceTab(String accountSearch, String workspaceName, String decs) {
		try {
			clickOnAccountsMenu();
			accountSearchFromList(accountSearch);
			worspaceTab();
			assignWorkspace(workspaceName, decs);
			verifyAddedWorkspace(workspaceName, decs);
		} catch (InterruptedException e) {
			e.getMessage();
		}

	}

	public void adminUserShouldNotAbleToRemoveWorkspaceFromWorkspaceTab(String accountSearch) {
		try {
			clickOnAccountsMenu();
			accountSearchFromList(accountSearch);
			worspaceTab();
			displayAndClick(driver, workspaceSelectAllCheckbox);
			boolean remove = isDisplayed(driver, removeWorkspace);
			if (remove) {
				BaseSuite.validationReportLog(
						"Remove button is not displaying in the page after clicking on selectall checkbox");
			} else {
				BaseSuite.reportFailLog("Remove button is displaying in the page after clicking on selectall checkbox",
						"adminUserShouldNotAbleToRemoveWorkspaceFromWorkspaceTab");
			}

			displayAndClick(driver, workspaceSelectAllCheckbox);

			displayAndClick(driver, workspaceSingleCheckbox);
			boolean remove1 = isDisplayed(driver, removeWorkspace);
			if (remove1) {
				BaseSuite.validationReportLog(
						"Remove button is not displaying in the page after clicking on single select checkbox");
			} else {
				BaseSuite.reportFailLog(
						"Remove button is displaying in the page after clicking on single select checkbox",
						"adminUserShouldNotAbleToRemoveWorkspaceFromWorkspaceTab");
			}

			displayAndClick(driver, workspaceSingleCheckbox);
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

		displayAndClick(driver, accountUserGroupSearchClick);

		BaseSuite.validationReportLog("Clicked on the search for the User/Group");

	}

	public void accountDetailsShouldBeDisplayedCorrectlyWhenUserIsRemovedFromAccount(String accountSearch,
			String userGroupSearchName) {
		try {
			clickOnAccountsMenu();
			accountSearchFromList(accountSearch);
			accountInsideUserGroupPageGridDetails();
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
						"accountDetailsShouldBeDisplayedCorrectlyWhenUserIsRemovedFromAccount");
			}

			inVisible(driver, spinner, Constant.ruleWait);

			captureToastMsg(driver, userGroupRemoveMess, toastMsgClosedBtn, userGroupRemoveText, "Remove User/Group");

			searchUserGroup(userGroupSearchName);

			boolean flag1 = isDisplayed(driver, userGroupRecord);

			if (flag1) {
				BaseSuite.validationReportLog("User/Group details also removed successfully from User/Group tab list");

			} else {
				BaseSuite.reportFailLog("User/Group details is not removed successfully from User/Group tab list",
						"accountDetailsShouldBeDisplayedCorrectlyWhenUserIsRemovedFromAccount");
			}

		} catch (Exception e) {

			e.getMessage();
		}

	}

	public void adminCanRemoveGroupFromAccountWhereAccountIsCreatedByAdmin(int rowNum,String accountSearch,
			String userGroupSearchName) {

		try {
			if (rowNum <= 0) {
			clickOnAccountsMenu();
			accountSearchFromList(accountSearch);
			accountInsideUserGroupPageGridDetails();
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
						"adminCanRemoveUserFromAccountCreatedBynonAdminUser");
			}

			inVisible(driver, spinner, Constant.ruleWait);

			captureToastMsg(driver, userGroupRemoveMess, toastMsgClosedBtn, userGroupRemoveText, "Remove User/Group");

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void adminCanAssignRolesToUserOnAccountCreatedByAdmin(String accountSearch, String role, String accessto,
			String selectDetails, String userGroupSearchName) {
		try {
			clickOnAccountsMenu();
			accountSearchFromList(accountSearch);
			accountInsideUserGroupPageGridDetails();
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

				String roleVale = add[1];

				searchUserGroup(name);

				String nameUserGroupValue = getText(driver, returnElement(userGroupName, "$User", name)).trim();

				if (nameUserGroupValue.equalsIgnoreCase(name.trim())) {
					BaseSuite.validationReportLog(
							"User/Group Name in Accounts detailed page matched successfully : " + name);
				} else {
					BaseSuite.reportFailLog("User/Group Name in Accounts detailed page not matched",
							"adminCanAssignRolesToUserOnAccountCreatedByAdmin");

				}

				String typeUserGroupValue = getText(driver, returnElement(userGroupTypeRole, "$User", type)).trim();

				if (typeUserGroupValue.equalsIgnoreCase(type.trim())) {
					BaseSuite.validationReportLog(
							"User/Group Type in Accounts detailed page matched successfully : " + type);
				} else {
					BaseSuite.reportFailLog("User/Group Type in Accounts detailed page not matched",
							"adminCanAssignRolesToUserOnAccountCreatedByAdmin");

				}

				String roleUserGroupValue = getText(driver, returnElement(userGroupTypeRole, "$User", roleVale)).trim();

				if (roleUserGroupValue.equalsIgnoreCase(roleVale.trim())) {
					BaseSuite.validationReportLog(
							"User/Group Role in Accounts detailed page matched successfully : " + roleVale);
				} else {
					BaseSuite.reportFailLog("User/Group Role in Accounts detailed page not matched",
							"adminCanAssignRolesToUserOnAccountCreatedByAdmin");

				}

			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void userDetailsShouldBeDisplayedCorrectlyAfterUserHasBeenRemovedFromAccount(String usersearch,
			String accountsearch) {

		try {

			BaseSuite.validationReportLog("Revisiting in User Tab to check the removal of Account details");
			Users user = new Users(driver);
			user.clickOnUsersMenu();
			user.searchUser(usersearch);
			isDisplayedInLoop(driver, 20, AccountLabel);
			BaseSuite.reportLog("Clicking on account label");
			click(driver, AccountLabel);
			displayAndClick(driver, AccountLabel);
			inVisible(driver, spinner, Constant.ruleWait);
			BaseSuite.validationReportLog("Account tab clicked successfully");
			String AccountLabelsColumns = "Name /Role /Scope";
			if ((isDisplayed(driver, AccountNameLabel)) && (isDisplayed(driver, AccountRoleLabel))
					&& (isDisplayed(driver, AccountScopeLabel))) {
				BaseSuite.validationReportLog("In account section all the account labels name displaying successfully:"
						+ AccountLabelsColumns);
			} else {
				BaseSuite.reportFailLog("Account labels are not available", "accountAssignDetails");
			}
			BaseSuite.reportLog("Searching for assigned accounts");
			javascript(driver, "window.scrollTo(0, document.body.scrollHeight)");
			BaseSuite.reportLog("Searching for workspace/account/group: ");
			isDisplayedInLoop(driver, 30, userAccountSearchbar);
			javascript(driver, "arguments[0].click();", userAccountSearchbar);
			clear(driver, userAccountSearchbar);

			isDisplayedInLoop(driver, 30, userAccountSearchbar);
			BaseSuite.reportLog("Search Name");
			sendKeys(driver, userAccountSearchbar, accountsearch);
			BaseSuite.reportLog("Click on searched");
			
			isDisplayedInLoop(driver, 30, userAccountSearchClick);
			javascript(driver, "arguments[0].click();", userAccountSearchClick);
			visible(driver, userAccountRecord, Constant.ruleWait);
			boolean flag = isDisplayed(driver, userAccountRecord);
			if (flag) {
				BaseSuite.validationReportLog(
						"Account removed successfully from User tab when it removing from Account tab");

			} else {
				BaseSuite.reportFailLog(
						"Account is not removed successfully from User tab when it removing from Account tab",
						"userDetailsShouldBeDisplayedCorrectlyAfterUserHasBeenRemovedFromAccount");
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void adminAssignMutipleRolesToUserGroupOnAccountHighestPreceedingOneShouldBeDisplayed(int rowNum,
			String accountSearch, String role, String accessto, String selectUserGroup) {
		try {

			if (rowNum <= 0) {
				clickOnAccountsMenu();
				accountSearchFromList(accountSearch);
				accountInsideUserGroupPageGridDetails();
			}
			assigRoles(role, accessto);
			assignSingleUserGroup(selectUserGroup);
			addRoleAssignButton();
			
			searchUserGroup(selectUserGroup);

			BaseSuite.reportLog(
					"Verifying mutiple roles to user/group on account highest preceeding one should be displayed");

			String nameUserGroupValue = getText(driver, returnElement(userGroupName, "$User", selectUserGroup)).trim();
			if (nameUserGroupValue.equalsIgnoreCase(selectUserGroup.trim())) {
				BaseSuite.validationReportLog(
						"User/Group Name in Accounts detailed page matched successfully : " + selectUserGroup);
			} else {
				BaseSuite.reportFailLog("User/Group Name in Accounts detailed page not matched",
						"adminCanAssignRolesToUserOnAccountCreatedByAdmin");

			}

			String typeUserGroupValue = getText(driver, returnElement(userGroupTypeRole, "$User", accessto)).trim();

			if (typeUserGroupValue.equalsIgnoreCase(accessto.trim())) {
				BaseSuite.validationReportLog(
						"User/Group Type in Accounts detailed page matched successfully : " + accessto);
			} else {
				BaseSuite.reportFailLog("User/Group Type in Accounts detailed page not matched",
						"adminCanAssignRolesToUserOnAccountCreatedByAdmin");

			}

			String roleUserGroupValue = getText(driver, returnElement(userGroupTypeRole, "$User", "Owner")).trim();

			if (roleUserGroupValue.equalsIgnoreCase("Owner")) {
				BaseSuite.validationReportLog(
						"User/Group assign multiple Roles in Accounts detailed page showing preciding one : "
								+ roleUserGroupValue);
			} else {
				BaseSuite.reportFailLog(
						"User/Group assign multiple Roles in Accounts detailed page not showing preciding one",
						"adminCanAssignRolesToUserOnAccountCreatedByAdmin");

			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void sequenceOfRoleWhileRemovingMultipleRolesFromUserGroupOnAccount(int rowNum, String accountSearch,
			String userGroupSearchName, String role) {
		try {
			if (rowNum <= 0 && rowNum <= 4) {
				clickOnAccountsMenu();
				accountSearchFromList(accountSearch);
				accountInsideUserGroupPageGridDetails();
			}

			searchUserGroup(userGroupSearchName);

			String roleUserGroupValue = getText(driver, returnElement(userGroupTypeRole, "$User", role)).trim();

			if (roleUserGroupValue.equalsIgnoreCase(role)) {
				BaseSuite.validationReportLog(
						"Verifyimg the Sequence of Role while removing multiple Roles from User/Group");

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
							"accountDetailsShouldBeDisplayedCorrectlyWhenUserIsRemovedFromAccount");
				}

				inVisible(driver, spinner, Constant.ruleWait);

				captureToastMsg(driver, userGroupRemoveMess, toastMsgClosedBtn, userGroupRemoveText,
						"Remove User/Group");

				BaseSuite.validationReportLog(
						"Sequence of Role while removing multiple Roles from User/Group is matched");
			} else {
				BaseSuite.reportFailLog("Sequence of Role while removing multiple Roles from User/Group is not matched",
						"sequenceOfRoleWhileRemovingMultipleRolesFromUserGroupOnAccount");

			}
		} catch (Exception e) {
			e.getMessage();

		}

	}

	// Verify that save button should be enabled when user enter all details.
	// NG21-672

	public void enableSaveButtonAfterEnteringAllData(SoftAssert softAssert) {
		try {
			log.info(
					"*********************************enableSaveButtonAfterEnteringAllData execution started*****************************************");
			clickOnAccountsMenu();
			isDisplayedInLoop(driver, 30, NewAccountsBtn);
			// click(driver, NewAccountsB);
			javascript(driver, "arguments[0].click();", NewAccountsBtn);
			BaseSuite.reportLog("Clicked on new account button.");
			BaseSuite.reportLog("Verifying account name is displayed?");
			isDisplayedInLoop(driver, 30, AccountNametxt);
			BaseSuite.reportLog("Account name is displayed :: Yes");
			sendKeys(driver, AccountNametxt, "Auto_Account_nk_1");
			BaseSuite.reportLog("Text entered in account name.");
			BaseSuite.reportLog("Verifying account description is displayed?");
			isDisplayedInLoop(driver, 30, AccountDesctxtarea);
			BaseSuite.reportLog("Account description is displayed :: Yes");
			sendKeys(driver, AccountDesctxtarea, "Account created by automation script");
			BaseSuite.reportLog("Text entered in account description.");
			BaseSuite.reportLog("Verifying is save button is enabled?");
			if (isDisplayed(driver, Acc_SaceBtn)) {
				boolean enable = isEnabled(driver, Acc_SaceBtn);
				if (enable) {
					assertTrue(enable);
					BaseSuite.reportLog("Save button is enabled :: Yes");
					BaseSuite.validationReportLog("Save button is enabled after entering all data");
				} else {
					if (enable == false) {
						assertTrue(enable);
						BaseSuite.reportFailLog("Save button is still disabled even when all data is entered.",
								"enableSaveButtonAfterEnteringAllData");
					}

					log.info("****Kindly verify :: save button is enabled but still test case failing***");
				}
				log.info("Save button is ==  " + enable);
			}

			isDisplayedInLoop(driver, 30, AccountsSideBar);
			click(driver, AccountsSideBar);
			isDisplayedInLoop(driver, 40, AccountDiscardBtnYes);
			javascript(driver, "arguments[0].click();", AccountDiscardBtnYes);
			
			log.info("*********************************enableSaveButtonAfterEnteringAllData execution ended*****************************************");
		} catch (Exception e) {
			
		}
	}

//	Verify Account should be searched from the List of Account. NG21-653

	public void Acc_SearchfromAccountlisting(String acc_Search, SoftAssert softAssert) {
		try {
			clickOnAccountsMenu();
			// account creation

			// Search account
			Acc_SearchCreatedAccount(acc_Search);
			assertEquals(acc_Search, Acc_namesearch);
			BaseSuite.validationReportLog(acc_Search + ":: searched and retrived successfully");

		} catch (Exception e) {
			e.getMessage();
		}

	}

//NG21-652-Verify New Account Button button should be enabled and Delete Account button should be disabled on the Account listing page.

	public void VerifyButtonsVisiblity(SoftAssert softAssert) {
		isDisplayedInLoop(driver, 30, AccountsSideBar);
		click(driver, AccountsSideBar);
		BaseSuite.reportLog(" Clicked on the Accounts menu!");

		// check visibility of new account
		BaseSuite.reportLog("Verifying New Button in the Account page");
		boolean New_Acc_btn = isEnabled(driver, NewAccountsBtn);
		if (New_Acc_btn) {
			assertTrue(New_Acc_btn);
			BaseSuite.validationReportLog("New Account creation button is enabled");
		} else {
			assertTrue(New_Acc_btn);
			BaseSuite.reportFailLog("New Account creation button is disabled", "VerifyButtonsVisiblity");
		}
		// check visibility of Refresh Button
		BaseSuite.reportLog("Verifying Refresh Button in the Account page");
		boolean Acc_refresh_Btn = isEnabled(driver, RefreshAccountsBtn);

		if (Acc_refresh_Btn) {
			BaseSuite.validationReportLog("Refresh button is enabled");

		} else {

			BaseSuite.reportFailLog("Refresh button is disabled", "VerifyButtonsVisiblity");
		}

		boolean acc_delete_btn = isEnabled(driver, DeleteAccountsBtn);

		if (acc_delete_btn) {

			assertTrue(acc_delete_btn);
			BaseSuite.validationReportLog("Delete user button is disabled by default");

		} else {

			BaseSuite.reportFailLog("Delete user button is enabled", "verifyDefaultAccountPage");
		}
	}

	// NG21-649 - Verify admin can refresh workspace list using refresh button

	public void refreshWorkspaceButton(String AccountName, SoftAssert soft) {
		try {
			String message;
			int totalChk = 0, totalUnchk = 0;
			Groups grpObj = new Groups(driver);
			
			isDisplayedInLoop(driver, 30, AccountsMenu);
			click(driver, AccountsMenu);
			BaseSuite.validationReportLog("Clicked on the Account Menu");
			inVisible(driver, spinner, Constant.ruleWait);
			
			Acc_SearchCreatedAccount(AccountName);
			// click on workspace tab
			isDisplayedInLoop(driver, 30, WorkspaceTab); 
			click(driver, WorkspaceTab);
			BaseSuite.reportLog("Clicked on workspace tab");
			// Click on refresh button
			isDisplayedInLoop(driver, 30, Acc_WksRefreshTab);
			Thread.sleep(2000);
			boolean flag = isEnabled(driver, Acc_WksRefreshTab);
			WebElement label = driver.findElement(By.xpath("//div[@id='e-content-element_1']//span[@class='e-pagecountmsg']"));
			message = label.getText();
			String[] stritems = message.substring(1).split(" ");
			BaseSuite.reportLog(
					"Number of workspaces in accounts :: " + AccountName + " before refresh are : " + stritems[0]);
			// click select all workspace checkbox
			isDisplayedInLoop(driver, 30, Acc_wksSelectAll);
			javascript(driver, "arguments[0].click();", Acc_wksSelectAll);
			//click(driver, Acc_wksSelectAll);

			isDisplayedInLoop(driver, 30, Acc_wkslist);
			totalChk = grpObj.getCheckboxSelectionCount(driver, Acc_wkslist);

			BaseSuite.reportLog("Total no of workspace's checkbox checked before refresh are : " + totalChk);

			if (flag) {
				click(driver, Acc_WksRefreshTab);
				BaseSuite.validationReportLog("clicked on Refresh button.");
				// Check spinner
				boolean flagSpin = isDisplayed(driver, Spinner);
				if (flagSpin) {
					BaseSuite.validationReportLog("Spinner displayed after refresh button is clicked");

					Thread.sleep(3000);

					label = driver
							.findElement(By.xpath("//div[@id='e-content-element_1']//span[@class='e-pagecountmsg']"));
					message = label.getText();
					// getText(driver, GlabelTotalusers);
					stritems = message.substring(1).split(" ");
					BaseSuite.reportLog("Number of workspaces in accounts :: " + AccountName + " after refresh are : "
							+ stritems[0]);

					totalUnchk = grpObj.getCheckboxUnSelectionCount(driver, Acc_wkslist);
					BaseSuite.reportLog("Number of workspaces  unchecked after refresh : " + totalUnchk);
					log.info("Total checkboxes : " + totalUnchk);
					log.info("Total workspaces in account " + stritems[0]);
					// total number of workspaces before refresh & after refresh
				} else {
					BaseSuite.reportFailLog("Spinner is not displayed after clicking refresh button",
							"refreshWorkspaceButton");
				}
			} else {
				BaseSuite.reportFailLog("Refresh button is disabled by default", "refreshWorkspaceButton");
			}
			isDisplayedInLoop(driver, 30, AccountsSideBar);
			click(driver, AccountsSideBar);

		} catch (Exception e) {
			e.getMessage();
		}

	}
	// NG21-872: Verify refresh button functionality at account listing page

	public void RefreshAccountListingPage(SoftAssert soft) {
		try {
			String message;
			int Total_Account, TotalAfterRe;

			isDisplayedInLoop(driver, 30, AccountsMenu);
			click(driver, AccountsMenu);
			BaseSuite.validationReportLog("Clicked on the Account Menu");
			inVisible(driver, spinner, Constant.ruleWait);
			
			Groups grpObj = new Groups(driver);
			isDisplayedInLoop(driver, 30, NewAccountsBtn);
			isDisplayedInLoop(driver, 30, RefreshAccountsBtn);
			BaseSuite.reportLog("Refresh button is displayed");
			Thread.sleep(3000);
			boolean flag = isEnabled(driver, RefreshAccountsBtn);
			WebElement label = driver.findElement(By.xpath("//span[@class='e-pagecountmsg']"));
			message = label.getText();
			// getText(driver, GlabelTotalusers);
			String[] stritems = message.substring(1).split(" ");
			BaseSuite.reportLog("Number of accounts available before refresh : " + stritems[0]);

			isDisplayedInLoop(driver, 30, Acc_SelectAllAccChk);
			click(driver, Acc_SelectAllAccChk);

			Thread.sleep(1000);

			Total_Account = grpObj.getCheckboxSelectionCount(driver, AccCheckbox);

			BaseSuite.reportLog("Number of accounts checked before refresh : " + Total_Account);
			log.info("Total checkboxes : " + Total_Account);

			if (flag) {
				click(driver, RefreshAccountsBtn);
				BaseSuite.validationReportLog("refresh button is clicked.");

				if (isDisplayed(driver, Spinner)) {
					BaseSuite.validationReportLog("Spinner is displayed.");
					// Need to checck checked and unchecked checkboxes
					Thread.sleep(3000);
					TotalAfterRe = grpObj.getCheckboxUnSelectionCount(driver, AccCheckbox); // need to show dhawal
					Thread.sleep(2000);
					BaseSuite.reportLog("Number of accounts unchecked after refresh : " + TotalAfterRe);
					log.info("Total checkboxes : " + Total_Account);

					// total number of accounts before & after refresh
					message = label.getText();
					stritems = message.substring(1).split(" ");
					BaseSuite.reportLog("Number of accounts available after refresh : " + stritems[0]);

				} else {
					BaseSuite.reportFailLog("Spinner is not displayed kindly report a bug",
							"RefreshAccountListingPage");
				}

			} else {
				BaseSuite.reportFailLog("Refresh button is disabled by default, kindly report a bug ",
						"RefreshAccountListingPage");
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// Methods in use.

	public void Acc_SearchCreatedAccount(String acc_name) throws InterruptedException {

		BaseSuite.reportLog("Searching for Account: " + acc_name);
		BaseSuite.reportLog("Verifying is search text box displayed?");
		isDisplayedInLoop(driver, 30, Acc_Searchtxt);

		BaseSuite.reportLog("Search text box displayed :: Yes");
		sendKeys(driver, Acc_Searchtxt, acc_name);
		BaseSuite.reportLog("Entered account name for search ::" + acc_name);

		/*
		 * isDisplayedInLoop(driver, 30, Acc_Searchbtn); click(driver, Acc_Searchbtn);
		 */
		isDisplayedInLoop(driver, 30, accountSearchClick);

		javascript(driver, "arguments[0].click();", accountSearchClick);
		BaseSuite.reportLog("Search button is displayed & clicked");
		Thread.sleep(2000);
		visible(driver, Acc_Searcheddatalbl, Constant.ruleWait);
		// visible(driver, returnElement(accountSearchList, "$User", acc_name),
		// Constant.ruleWait);
		BaseSuite.reportLog("Click on Searched Account");
		// javascript(driver, "arguments[0].click();", returnElement(accountSearchList,
		// "$User", acc_name));

		click(driver, returnElement(Acc_searchedData_label, "$accountName", acc_name));

		BaseSuite.reportLog("Clicked on Account: " + acc_name);

		// captureToastMsg(driver, retrivedMsg, toastMsgClosedBtn,
		// accountDetailsRetrivedText,"Accounts detail retrieved");

		isDisplayedInLoop(driver, 30, AccountNametxt);
		String AccountNameReceived = driver.findElement(AccountNametxt).getText().trim();
		log.info("Account searched :: " + acc_name + "Account retrived :: " + AccountNameReceived);

	}
	
	
		//********************************** Account Owner *********************** //

	
	
	public void accountDropDownShouldShowListOfAccounts(String acc1, String acc2) throws InterruptedException {
		try {
		Workspaces w = new Workspaces(driver);
		w.clickOnWorkspaceMenu();
		w.clickOnNewWorkspaceButton();
		BaseSuite.reportLog("Checking the details of account::::");
		selectAccount(acc1);
		BaseSuite.reportLog("Checking the details of account::::");
		selectAccount(acc2);
		driver.navigate().refresh();
		Thread.sleep(3000);
	} catch (Exception e) {
		throw new AssertionError("Error occured in this method", e);
	}
	}

	public void selectAccount(String account) throws InterruptedException {
		try {
		BaseSuite.reportLog("Selecting the Account:::: " + account);
		isDisplayedInLoop(driver, 30, AccountDropdown);
		click(driver, AccountDropdown);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Select Account']")).sendKeys(account);
		Thread.sleep(2000);

		String accName = getAttribute(driver, selectedAccount, "aria-label");

		if (accName.equals(account)) {
			BaseSuite.validationReportLog("Selected Account is " + account);
			BaseSuite.validationReportLog("Account Owner has access on the selected account");
		} else {
			BaseSuite.reportErrorLog("Not showing the list of account");
		}
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	
	
	public void createPrivateWorkspaceFromWorkspaceSectionByAccountOwner(String account, String workspaceName, String workspaceDesc,  String type) throws Exception
	{
		try {
		Workspaces w = new Workspaces(driver);
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String WSname = workspaceName + timeStamp;
		String WSDesc = workspaceName + timeStamp;
		
		w.createWorkspace(account, WSname, WSDesc, type);
		w.clickOnWorkspaceMenu();
		w.searchWorkspaceAndClick(WSname);
		BaseSuite.validationReportLog("Created workspace listed in the workspace list so it is confirmed that workspace created successfully and created workspace name is :"+ WSname);
		}
		catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	public void createSharedWorkspaceFromWorkspaceSectionByAccountOwner(String account, String workspaceName,
			String workspaceDesc, String type) throws Exception {
		try {
			Workspaces w = new Workspaces(driver);

			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String WSname = workspaceName + timeStamp;
			String WSDesc = workspaceName + timeStamp;

			w.createWorkspace(account, WSname, WSDesc, type);
			w.clickOnWorkspaceMenu();
			w.searchWorkspaceAndClick(WSname);
			BaseSuite.validationReportLog(
					"Created workspace listed in the workspace list so it is confirmed that workspace created successfully and created workspace name is :"
							+ WSname);
		}

		catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}

	}
	
	
	
	public void accountAndTypeAfterSavingOrRevisitingWorkspace(String workspaceName) throws Exception {
		try {
			Workspaces w = new Workspaces(driver);
			w.clickOnWorkspaceMenu();
			w.searchWorkspaceAndClick(workspaceName);
			BaseSuite.reportLog("Checking the Account selection to edit the details");
			isDisplayedInLoop(driver, 30, AccountDropdown);

			boolean ac = isEnabled(driver, AccountDropdown);
			if (ac) {
				BaseSuite.validationReportLog("Unable to edit account selection");

			} else {
				BaseSuite.reportFailLog("Able to edit the account", "accountAndTypeAfterSavingOrRevisitingWorkspace");

			}
			BaseSuite.reportLog("Checking the Type selection to edit the details");
			isDisplayedInLoop(driver, 30, Workspacetype);

			boolean ws = isEnabled(driver, Workspacetype);
			if (ws) {
				BaseSuite.validationReportLog("Unable to edit workspace type selection");

			} else {
				BaseSuite.reportFailLog("Able to edit the workspace type",
						"accountAndTypeAfterSavingOrRevisitingWorkspace");

			}

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	public void workspaceShouldShowRoleInheritedWhenUserAddFromAccountSection(String account, String role,
			String accessto, String selectUser, String workspaceName, String inheritedRoleDetailsText)
			throws Exception {
		try {
			clickOnAccountsMenu();
			accountSearchFromListOfAccounts(account);
			Thread.sleep(3000);
			assigRoles(role, accessto);
			assignSingleUserGroup(selectUser);
			addRoleAssignButton();

			Workspaces w = new Workspaces(driver);
			w.clickOnWorkspaceMenu();
			w.searchWorkspaceAndClick(workspaceName);
			w.searchUserGroup(selectUser);

			BaseSuite.reportLog("Checking the Role column details");
			isDisplayedInLoop(driver, 30, roleInheritedColumnDetails);
			BaseSuite.validationReportLog("Role column is displaying properly");

			String inheritedRoleDetails = getText(driver, roleInheritedColumnDetails);
			if (inheritedRoleDetails.equalsIgnoreCase(inheritedRoleDetailsText.trim())) {
				BaseSuite.reportLog("Checking the role details in the workspace ::::" + workspaceName);
				BaseSuite.validationReportLog(
						"Workspace showing role as Owner(Inherited) when user is added from the account section!!!");

			} else {
				BaseSuite.reportFailLog(
						"Details in the workpace is not showing proper when user is added from the account section",
						"workspaceShouldShowRoleInheritedWhenUserAddFromAccountSection");
			}
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	public void workspaceShouldShowRoleOwnerWhenUserAddFromWorkspaceSection(String workspaceName, String role,
			String accessto, String selectUserDetails) throws Exception {
		try {
			Workspaces w = new Workspaces(driver);
			w.clickOnWorkspaceMenu();
			w.searchWorkspaceAndClick(workspaceName);
			w.workspaceInsideUserGroupPageGridDetails();
			Thread.sleep(5000);
			w.roleAssignment(role, accessto, selectUserDetails);
			w.addRoleAssignButton();
			w.searchUserGroup(selectUserDetails);

			String ownerRoleDetails = getText(driver, roleOwnerColumnDetails);
			if (ownerRoleDetails.equalsIgnoreCase(ownerRoleDetailsText.trim())) {
				BaseSuite.reportLog("Checking the role details in the workspace ::::" + workspaceName);
				BaseSuite.validationReportLog(
						"Workspace showing role as Owner when user is added from the workspace section!!!");

			} else {
				BaseSuite.reportFailLog(
						"Details in the workpace is not showing proper when user is added from the workspace section",
						"workspaceShouldShowRoleOwnerWhenUserAddFromWorkspaceSection");
			}
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}

	}
	
	public void numberOfWorkspacesForAccountOwner() throws InterruptedException {
		try {
			Workspaces w = new Workspaces(driver);
			w.clickOnWorkspaceMenu();
			w.numberOfWorkspaces();
			BaseSuite.validationReportLog("Number of workspace showing for the Account Owner!!");
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	public void accountOwnerShouldNotAccessUserGroupSection() throws Exception {
		try {
			Users user = new Users(driver);
			Groups group = new Groups(driver);
			Thread.sleep(5000);
			user.clickOnUserMenuForNonAdminUser();
			group.clickOnGroupMenuForNonAdminUser();
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	
	public void accountOwnerAccessOnListOfAccounts() throws InterruptedException {
		clickOnAccountsMenu();
		numberOfAccounts();
		BaseSuite.validationReportLog("Account Owner is able to access on the listed Account!");

	}
	
	
	
	public void accountOwnerAccessOnListOfWorkspaces() throws InterruptedException {
		try {
		Workspaces w = new Workspaces(driver);
		w.clickOnWorkspaceMenu();
		w.numberOfWorkspaces();
		BaseSuite.validationReportLog("Account Owner is able to access on the listed Workspaces!");
		}
		catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	public void accountOwnerAccessOnListOfRoles() throws Exception {
		Roles role = new Roles(driver);
		role.clickOnRolesMenu();
		role.verifyRolesPage();
		BaseSuite.validationReportLog("Account Owner is able to access on the listed Roles!");

	}
	
	
	
	public void accountSearchByAccountOwner(String accountName) throws Exception
	{
		try {
			clickOnAccountsMenu();
			boolean available = isDisplayed(driver, firstRowInPage);
			if(available) {
			searchAccountAndClick(accountName);}
			else
			{
				BaseSuite.reportLog("No records to display :::::::::::::::::::::::: ");
			}
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	public void accountOwnerShouldNotAbleToCreateNewAccount(String name, String description)
			throws Exception {
		try {
		clickOnAccountsMenu();
		Thread.sleep(3000);
		BaseSuite.reportLog("Verifying New Account button");
		isDisplayedInLoop(driver, 30, NewAccountsBtn);
		click(driver, NewAccountsBtn);
		BaseSuite.validationReportLog("Clicked on the New Account button!");

		BaseSuite.reportLog("Verifying New Account input field");
		isDisplayedInLoop(driver, 30, AccountName);
		click(driver, AccountName);
		BaseSuite.reportLog("Clicked on the New Account input field and entering the details..");
		sendKeys(driver, AccountName, name);
		BaseSuite.validationReportLog("::::::::: Entered Account Name " + name);

		BaseSuite.reportLog("Verifying New Account Description input field");
		isDisplayedInLoop(driver, 30, AccountDescription);
		click(driver, AccountDescription);
		BaseSuite.reportLog("Clicked on the New Description input field and entering the details..");
		sendKeys(driver, AccountDescription, description);
		BaseSuite.validationReportLog("::::::::: Entered Account Description " + description);
		Thread.sleep(3000);
		BaseSuite.reportLog("Verifying Account Save button");
		isDisplayedInLoop(driver, 30, AccountSaveBtn);
		click(driver, AccountSaveBtn);
		BaseSuite.validationReportLog("Clicked on the Save Account button");
		BaseSuite.reportLog("Verifying validation message for the User");

		inVisible(driver, spinner, Constant.ruleWait);
		waitForElement(driver, toastMsgClosedBtn);
		captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, nonAdminValidationText, "Insufficient privileges");
		driver.navigate().refresh();
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}

	}
	
	public void accountOwnerShouldNotAbleToUpdateExistingAccount(String accountName, String updatedAccountName,
			String updatedAccountDescription) throws Exception {
		try {
		clickOnAccountsMenu();
		searchAccountAndClick(accountName);

		BaseSuite.reportLog("Verifying New Account input field");
		isDisplayedInLoop(driver, 30, AccountName);
		BaseSuite.reportLog("Clicked on the Account input field and updating the details....");
		clear_Click_SendKeys(driver, 30, AccountName, updatedAccountName);
		BaseSuite.validationReportLog("::::::::: Entered Account Name " + updatedAccountName);

		BaseSuite.reportLog("Verifying New Account Description input field");
		isDisplayedInLoop(driver, 30, AccountDescription);
		BaseSuite.reportLog("Clicked on the Description input field and updating the details....");
		clear_Click_SendKeys(driver, 30, AccountDescription, updatedAccountDescription);
		BaseSuite.validationReportLog("::::::::: Entered Account Description " + updatedAccountDescription);

		BaseSuite.reportLog("Verifying Account Save button");
		isDisplayedInLoop(driver, 30, AccountSaveBtn);
		click(driver, AccountSaveBtn);
		Thread.sleep(2000);
		BaseSuite.validationReportLog("Clicked on the Save Account button");
		BaseSuite.reportLog("Verifying validation message for the Account Owner");

		waitForElement(driver, toastMsgClosedBtn);
		captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, nonAdminValidationText, "Insufficient privileges");
		Thread.sleep(3000);
		}
		catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	public void verifyAccountOwnerViewAndAccessTheAccount(String accountName) throws Exception
	{
		accountOwnerAccessOnListOfAccounts();
		searchAccountAndClick(accountName);
		BaseSuite.validationReportLog("Account Owner is able to View and Access the Account on which user has owner access!");

	}
	
	
	public void accountOwnerShouldReadAllListedUserGroupsAndWorkspaceInsideTheAccount(String accountName)
			throws Exception {
		try {
			clickOnAccountsMenu();
			searchAccountAndClick(accountName);
			BaseSuite.reportLog("Checking the User_GroupTab");
			isDisplayedInLoop(driver, 30, User_GroupTab);
			click(driver, User_GroupTab);
			BaseSuite.validationReportLog("Clicked on the User_GroupTab");
			Thread.sleep(3000);

			//WebElement table_element = driver.findElement(By.id("grid_1473797328_0_content_table"));
			
			WebElement table_element = driver.findElement(By.xpath("//table[@class='e-table']"));
			

			List<WebElement> tr_collection = table_element
					.findElements(By.xpath("//td[@class='e-rowcell e-templatecell']"));

			BaseSuite.validationReportLog(
					"Number of Users/Groups assign in the Account :::::::: " + tr_collection.size());
			BaseSuite.validationReportLog("Account Owner able to read the all listed user/group");
			int row_num, col_num;
			row_num = 1;
			BaseSuite.reportLog("Reading the name of User/Group which assign to account " + accountName);
			for (WebElement tdElement : tr_collection) {
				row_num = 1;
				System.out.println("Assign User/Group ::::::" + tdElement.getText());
				BaseSuite.validationReportLog(
						"Assign User/Group to account " + accountName + "::::::" + tdElement.getText());
			}

			isDisplayedInLoop(driver, 30, WorkspaceTab);
			click(driver, WorkspaceTab);

			WebElement table_element1 = driver.findElement(By.xpath("//table[starts-with(@id,'grid_')]"));
			List<WebElement> tr_collection1 = table_element1
					.findElements(By.xpath("//td[@class='e-rowcell e-templatecell']"));

			BaseSuite.validationReportLog(
					"Number of Workspaces assign in the Account :::::::: " + tr_collection1.size());
			BaseSuite.validationReportLog("Account Owner able to read the all listed Workspaces");
			int row_num1, col_num1;
			row_num1 = 1;
			BaseSuite.reportLog("Reading the name of Workspaces which assign to account " + accountName);
			for (WebElement tdElement1 : tr_collection1) {
				row_num1 = 1;
				System.out.println("Assign Workspaces ::::::" + tdElement1.getText());
				BaseSuite.validationReportLog(
						"Assign Workspaces to account " + accountName + "::::::" + tdElement1.getText());
			}
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	
	
	public void accountOwnerShouldAbleToAddUserToAccount(String accountName, String role, String accessto,
			String selectUserGroup) throws Exception {
		try {
			clickOnAccountsMenu();
			searchAccountAndClick(accountName);
			assigRoles(role, accessto);
			assignSingleUserGroup(selectUserGroup);
			addRoleAssignButton();
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	
	public void accountOwnerShouldAbleToAddGroupToAccount(String accountName, String role, String accessto,
			String selectUserGroup) throws Exception {
		try {
			clickOnAccountsMenu();
			searchAccountAndClick(accountName);
			assigRoles(role, accessto);
			assignSingleUserGroup(selectUserGroup);
			addRoleAssignButton();
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	
	public void accountOwnerShouldAbleToAddUserAndGroup(String accountName, String role, String accessto_User,
			String selectUserGroup_User, String accessto_Group, String selectUserGroup_Group) throws Exception {
		try {
			clickOnAccountsMenu();
			searchAccountAndClick(accountName);

			BaseSuite.validationReportLog(":::::::::::::::: ADDING USER TO THE ACCOUNT ::::::::::::::::");
			assigRoles(role, accessto_User);
			assignSingleUserGroup(selectUserGroup_User);
			addRoleAssignButton();

			BaseSuite.validationReportLog(":::::::::::::::: ADDING GROUP TO THE ACCOUNT ::::::::::::::::");
			assigRoles(role, accessto_Group);
			assignSingleUserGroup(selectUserGroup_Group);
			addRoleAssignButton();
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	public void refreshBtnShouldUpdateDetailsInAddedListOfUserGroup(String accountName,String role, String accessto,String selectUserGroup) throws Exception
	{
		try {
		clickOnAccountsMenu();
		searchAccountAndClick(accountName);
		BaseSuite.validationReportLog("Verifying number of users/groups added in the account "+ accountName);
		
		isDisplayedInLoop(driver, 20, NumberOfAccounts);
		Thread.sleep(3000);
		BaseSuite.reportLog("::: Verifying the total number of User/Groups before addding the User/Groups :::");
		String numbers = getText(driver, NumberOfAccounts);
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
		captureToastMsg(driver, retrivedMsg, toastMsgClosedBtn, accountDetailsRetrivedText,	"Accounts detail retrieved");
		
		isDisplayedInLoop(driver, 30, NumberOfAccounts);
		Thread.sleep(3000);
		BaseSuite.reportLog("::: Verifying the total number of User/Groups before addding the User/Groups :::");
		String numbers1 = getText(driver, NumberOfAccounts);
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
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	public void userGroupTabShouldShowColumnNames(String accountName) throws Exception {
		try {
			clickOnAccountsMenu();
			searchAccountAndClick(accountName);
			BaseSuite.reportLog("Verifying the User/Group tab");
			isDisplayedInLoop(driver, 30, User_GroupTab);
			click(driver, User_GroupTab);
			BaseSuite.validationReportLog("Clicked on the User/Group tab.!!");

			WebElement table_element = driver.findElement(By.xpath("//table[starts-with(@id,'grid')]"));
			List<WebElement> tr_collection = table_element.findElements(By.xpath("//span[@class='e-headertext']"));
			BaseSuite.validationReportLog(
					"Number ofcolumn's available in the User/Group tab :::::::: " + tr_collection.size());
			int row_num, col_num;
			row_num = 1;
			BaseSuite.reportLog("Reading the name of column's available in the User/Group tab");
			for (WebElement tdElement : tr_collection) {
				row_num = 1;
				System.out.println("Name of column's ::::::" + tdElement.getText());
				BaseSuite.validationReportLog("Name of column's ::::::" + tdElement.getText());
			}
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	public void accountOwnerShouldAbleToRemoveTheUserGroupFromAccount(String accountName, String userGroupSearchName)
			throws Exception {
		try {
			clickOnAccountsMenu();
			searchAccountAndClick(accountName);
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
						"accountDetailsShouldBeDisplayedCorrectlyWhenUserIsRemovedFromAccount");
			}

			inVisible(driver, spinner, Constant.ruleWait);

			captureToastMsg(driver, userGroupRemoveMess, toastMsgClosedBtn, userGroupRemoveText, "Remove User/Group");

			searchUserGroup(userGroupSearchName);

			boolean flag1 = isDisplayed(driver, userGroupRecord);

			if (flag1) {
				BaseSuite.validationReportLog("User/Group details also removed successfully from User/Group tab list");

			} else {
				BaseSuite.reportFailLog("User/Group details is not removed successfully from User/Group tab list",
						"accountDetailsShouldBeDisplayedCorrectlyWhenUserIsRemovedFromAccount");
			}

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	public void accountOwnerCanAddNewWorkspaceFromWorkspaceTab(String accountName, String workspaceName, String decs)
			throws Exception {
		try {
			clickOnAccountsMenu();
			searchAccountAndClick(accountName);
			worspaceTab();

			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String name = workspaceName + timeStamp;
			String decs1 = workspaceName + timeStamp;

			assignWorkspace(name, decs1);
			click(driver, refreshWorkspace);

			verifyAddedWorkspace(name, decs1);
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}

	}
	
	
	public void createdWorkspaceFromAccountSectionShouldListedInTheWorkspaceMenu(String accountName, String workspaceName, String decs)
			throws Exception {
		try {
			clickOnAccountsMenu();
			searchAccountAndClick(accountName);
			worspaceTab();

			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String name = workspaceName + timeStamp;
			String decs1 = workspaceName + timeStamp;

			assignWorkspace(name, decs1);
			click(driver, refreshWorkspace);

			Workspaces w = new Workspaces(driver);
			w.clickOnWorkspaceMenu();
			w.workspaceSearchFromListOfWorkspaces(name);
			
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}

	}
	
	
	public void workspaceWithSameInSameAccountShouldNotBeCreated(String accountName, String workspaceName, String desc) throws Exception
	{
		try {
			clickOnAccountsMenu();
			searchAccountAndClick(accountName);
			worspaceTab();

			
			BaseSuite.reportLog("Clicking on Add button to assign Workspace");

			displayAndClick(driver, addWorkspace);

			BaseSuite.validationReportLog("Add button clicked Successfully to assign Workspace");

			verifyAddWorkspacePage();

			BaseSuite.reportLog("Entering Workspace name in workspace field");
			displayAndClick(driver, addWorkspaceName);
			sendKeys(driver, addWorkspaceName, workspaceName);
			BaseSuite.validationReportLog("Workspace name entered successfully in workspace field ::: " + workspaceName);

			BaseSuite.reportLog("Entering Workspace Description in description field " + workspaceName);
			displayAndClick(driver, addWorkspaceDescription);
			sendKeys(driver, addWorkspaceDescription, desc);
			BaseSuite.validationReportLog("Workspace Description entered successfully in description field ::: " + desc);

			BaseSuite.reportLog("Clicking on Add button to add Workspace");
			displayAndClick(driver, addRoleBtn);
			BaseSuite.validationReportLog("Add button clicked Successfully to add Workspace");
			waitForElement(driver, toastMsgClosedBtn);
			captureToastMsg(driver, duplicateWorkspaceRetrivedMsg, toastMsgClosedBtn, duplicateWorkspaceRetrivedText, "Workspace with same name");
			
		 } catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}

	}
	
	
	public void acountOwnerShouldAbleToAddWorskspaceInAccount(String accountName, String workspaceName,
			String WorkspaceDesc, String type) throws Exception {
		try {
			clickOnAccountsMenu();
			searchAccountAndClick(accountName);
			worspaceTab();

			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String name = workspaceName + timeStamp;
			String WSDesc = workspaceName + timeStamp;

			BaseSuite.reportLog("Clicking on Add button to assign Workspace");
			displayAndClick(driver, addWorkspace);
			BaseSuite.validationReportLog("Add button clicked Successfully to assign Workspace");
			verifyAddWorkspacePage();

			BaseSuite.reportLog("Entering Workspace name in workspace field");
			displayAndClick(driver, addWorkspaceName);
			sendKeys(driver, addWorkspaceName, name);
			BaseSuite.validationReportLog("Workspace name entered successfully in workspace field ::: " + name);

			BaseSuite.reportLog("Entering Workspace Description in description field " + name);
			displayAndClick(driver, addWorkspaceDescription);
			sendKeys(driver, addWorkspaceDescription, WSDesc);
			BaseSuite.validationReportLog("Workspace Description entered successfully in description field ::: " + WSDesc);

			BaseSuite.reportLog("Selecting the Workspace type:::: " + type);
			isDisplayed(driver, Workspacetype);

			click(driver, Workspacetype);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"ddlelement\"]/span/input[@placeholder='Select Type']")).sendKeys(type);
			Thread.sleep(3000);

			BaseSuite.reportLog("Clicking on Add button to add Workspace");
			displayAndClick(driver, addRoleBtn);
			BaseSuite.validationReportLog("Add button clicked Successfully to add Workspace");

			waitForElement(driver, toastMsgClosedBtn);
			captureToastMsg(driver, workspaceAddMsg, toastMsgClosedBtn, workspaceAddText, "Add Workspace");
			BaseSuite.reportLog("Verifying the refresh button after adding workspace to the account");
			isDisplayedInLoop(driver, 40, refreshWorkspace);
			click(driver, refreshWorkspace);
			BaseSuite.reportLog("Clicking the refresh button after adding workspace to the account");	
			BaseSuite.validationReportLog(":::: Account Owner user able to add " + type + " workspace in the account section ::::");
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}

	}
	
	
	public void workapceDetailsShouldBeDiscardOnClickDiscardBtn(String accountName, String workspaceName,
			String WorkspaceDesc, String type) throws Exception
	{
		try {
			clickOnAccountsMenu();
			searchAccountAndClick(accountName);
			worspaceTab();
			BaseSuite.reportLog("Clicking on Add button to assign Workspace");
			displayAndClick(driver, addWorkspace);
			BaseSuite.validationReportLog("Add button clicked Successfully to assign Workspace");
			verifyAddWorkspacePage();

			BaseSuite.reportLog("Entering Workspace name in workspace field");
			displayAndClick(driver, addWorkspaceName);
			sendKeys(driver, addWorkspaceName, workspaceName);
			BaseSuite.validationReportLog("Workspace name entered successfully in workspace field ::: " + workspaceName);

			BaseSuite.reportLog("Entering Workspace Description in description field " + workspaceName);
			displayAndClick(driver, addWorkspaceDescription);
			sendKeys(driver, addWorkspaceDescription, WorkspaceDesc);
			BaseSuite.validationReportLog("Workspace Description entered successfully in description field ::: " + WorkspaceDesc);

			BaseSuite.reportLog("Selecting the Workspace type:::: " + type);
			isDisplayed(driver, Workspacetype);

			click(driver, Workspacetype);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"ddlelement\"]/span/input[@placeholder='Select Type']")).sendKeys(type);
			Thread.sleep(3000);

			BaseSuite.reportLog("Clicking on Discard button avaialbel in the add Workspace page");
			displayAndClick(driver, DiscardRoleBtn);
			BaseSuite.reportLog("Discard button clicked Successfully to discard Workspace creation");
			BaseSuite.validationReportLog("Workspace be discarded successfully!!!");
	
			driver.navigate().refresh();
			Thread.sleep(3000);
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	public void accountOwnerShouldAbleToViewListOfWorkspacesAndClickOnAssignWorkspace(String workspaceName) throws Exception
	{
		try {
		numberOfWorkspacesForAccountOwner();
		Workspaces w = new Workspaces(driver);
		w.clickOnWorkspaceMenu();
		w.searchWorkspaceAndClick(workspaceName);
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	
	public void accountOwnerShouldAbleToCreateAndUpdateWorkspaceDetails(String account, String workspaceName, String workspaceDesc,  String type) throws InterruptedException
	{try {
		Workspaces w = new Workspaces(driver);
		w.createWorkspace(account, workspaceName, workspaceDesc, type);
		w.clickOnWorkspaceMenu();
		w.searchWorkspaceAndClick(workspaceName);
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String updatedWSName = workspaceName + timeStamp;
		String updatedWSDesc = workspaceDesc + timeStamp;
		
		BaseSuite.validationReportLog("::::::::::: Updating the Workspace details :::::::::::");
		
		
		BaseSuite.reportLog("Entering the Workspace Name:::: " + updatedWSName);
		isDisplayedInLoop(driver, 20, newWorkspaceName);
		clear_Click_SendKeys(driver, 30, newWorkspaceName, updatedWSName);
		BaseSuite.validationReportLog("Entered Workspace Name:: " + updatedWSName);

		BaseSuite.reportLog("Entering the Workspace Description:::: " + updatedWSDesc);
		isDisplayedInLoop(driver, 20, workspaceDescdetails);
		clear_Click_SendKeys(driver, 30, workspaceDescdetails, updatedWSDesc);
		BaseSuite.validationReportLog("Entered Workspace Description: " + updatedWSDesc);
		Thread.sleep(3000);
		BaseSuite.reportLog("Clicking on the Save button..");
		isDisplayedInLoop(driver, 40, WorkspaceSaveBtn);
		click(driver, WorkspaceSaveBtn);
		BaseSuite.validationReportLog("Save button clicked successfully..");
		waitForElement(driver, toastMsgClosedBtn);
		captureToastMsg(driver, workspaceCreatedMsg, toastMsgClosedBtn, workspaceCreatedText, "Workspace Created");
		BaseSuite.validationReportLog("Workspace Updated successfully :::::::::::");
		Thread.sleep(3000);
		w.clickOnWorkspaceMenu();
		BaseSuite.reportLog("Searching for updated workspace");
		w.searchWorkspaceAndClick(updatedWSName);
		BaseSuite.validationReportLog("Updated workspace listed in the workspace list so it is confirmed that workspace updated successfully and Updated workspace name is :"+ updatedWSName);
		
	} catch (Exception e) {
		throw new AssertionError("Error occured in this method", e);
	}
	}
	
	
	public void createWorkspaceWithSameNameHavingDifferentAccountSelection(String account1, String workspaceName,
			String workspaceDesc, String type, String account2) throws Exception {
		Workspaces w = new Workspaces(driver);
		try {
			w.clickOnWorkspaceMenu();
			w.searchWorkspaceAndClick(workspaceName);
			BaseSuite.validationReportLog(":::::::: " + workspaceName + " is available in the Account :::::::: " + account1);

			BaseSuite.reportLog(":::::::::::  Creating the workspace with same name in the same account " + account1);

			w.clickWSMenu();
			isDisplayedInLoop(driver, 40, NewAccountBtn);
			click(driver, NewAccountBtn);
			Thread.sleep(2000);
			BaseSuite.reportLog("Selecting the Account:::: " + account1);
			isDisplayedInLoop(driver, 30, AccountDropdown);
			click(driver, AccountDropdown);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Select Account']")).sendKeys(account1);
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
			driver.findElement(By.xpath("//*[@id=\"ddlelement\"]/span/input[@placeholder='Select Type']"))
					.sendKeys(type);
			Thread.sleep(3000);

			BaseSuite.reportLog("Verifying Save button");
			isDisplayedInLoop(driver, 30, WorkspaceSaveBtn);
			BaseSuite.validationReportLog("Save Workspace button is enabled");

			waitForElement(driver, WorkspaceSaveBtn);
			BaseSuite.reportLog("Clicking the workspace save button...");
			click(driver, WorkspaceSaveBtn);

			waitForElement(driver, toastMsgClosedBtn);
			captureToastMsg(driver, duplicateWorkspaceRetrivedMsg, toastMsgClosedBtn, duplicateWorkspaceRetrivedText,
					"Workspace with same name");

			BaseSuite.validationReportLog(
					"Unable to create Workspace with same name having same account selection ::::::::::::::");
			driver.navigate().refresh();

			BaseSuite.reportLog(
					":::::::::::  Creating the workspace with same name in the different account " + account2);
			w.clickWSMenu();
			w.createWorkspace(account2, workspaceName, workspaceDesc, type);
			BaseSuite.validationReportLog("Workspace is created with same name having different account selection ::::::::::::::");

			BaseSuite.reportLog("::::::::::: Searching the worksapce ");
			w.clickWSMenu();
			w.searchWorkspaceAndClick(workspaceName);
			BaseSuite.validationReportLog(
					"Workspace is created with same name having different account selection search successfully::::::::::::::");

			BaseSuite.reportLog("::::::::::: Updating the worksapce for the next execution ");
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String updatedWSName = account2 + timeStamp;
			String updatedWSDesc = account2 + timeStamp;

			isDisplayed(driver, WorkspaceName);
			click(driver, WorkspaceName);
			BaseSuite.reportLog("Clicked on the Workspace Name");
			BaseSuite.reportLog("Updating the Workspace Name");
			clear_Click_SendKeys(driver, 30, WorkspaceName, updatedWSName);
			BaseSuite.validationReportLog("Entered the workspace name with details :::::" + updatedWSName);

			BaseSuite.reportLog("Clicked on the Workspace Description");
			BaseSuite.reportLog("Updating the Workspace Description");
			clear_Click_SendKeys(driver, 30, WorkspaceDescription, updatedWSDesc);
			BaseSuite.validationReportLog("Entered the workspace description with details :::::" + updatedWSDesc);

			waitForElement(driver, WorkspaceSaveBtn);
			BaseSuite.reportLog("Clicking the workspace save button...");
			click(driver, WorkspaceSaveBtn);
			Thread.sleep(3000);

			BaseSuite.reportLog("Workspace saved successfully");
			BaseSuite.validationReportLog(workspaceName + " Workspace updated");

			BaseSuite.reportLog("Existing workspace updated successfully!!");
			BaseSuite.validationReportLog("Updated workspace name is :::::" + updatedWSDesc);

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	// ******************** Account Contributor ********************
	
	public void accountContributorShouldNotAccessUserSection() throws Exception {
		try {
			Users user = new Users(driver);
			Thread.sleep(5000);
			user.clickOnUserMenuForNonAdminUser();
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);

		}
	}

	public void accountContributorShouldNotAccessGroupSection() throws InterruptedException {
		try {
		Groups group = new Groups(driver);
		Thread.sleep(5000);
		group.clickOnGroupMenuForNonAdminUser();
	
	} catch (Exception e) {
		throw new AssertionError("Error occured in this method", e);

	}
	}

	public void accountContributorAccessOnListOfAccounts() throws Exception {
		try {
			clickOnAccountsMenu();
			numberOfAccounts();
			BaseSuite.validationReportLog("Account Contributor is able to access on the listed Account!");
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	public void accountSearchByAccountContributor(String accountName) throws Exception {
		try {
			clickOnAccountsMenu();
			boolean available = isDisplayed(driver, firstRowInPage);
			if(available) {
			searchAccountAndClick(accountName);}
			else
			{
				BaseSuite.reportLog("No records to display :::::::::::::::::::::::: ");
			}
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	public void acountContributorShouldAbleToAddWorskspaceInAccount(String accountName, String workspaceName,
			String WorkspaceDesc, String type) throws Exception
	{
		try {
			acountOwnerShouldAbleToAddWorskspaceInAccount(accountName, workspaceName, WorkspaceDesc, type);
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	public void accountContributorShouldNotAbleToAddUserGroupInAccount(String accountName, String role, String accessto, String selectUserGroup) throws Exception
	{
		try {
			clickOnAccountsMenu();
			searchAccountAndClick(accountName);
			assigRoles(role, accessto);
			assignSingleUserGroup(selectUserGroup);
			
			BaseSuite.reportLog("Checking the Add role button");
			isDisplayedInLoop(driver, 30, addRoleBtn);
			BaseSuite.reportLog("Clicking on the Add role button");
			displayAndClick(driver, addRoleBtn);
			inVisible(driver, spinner, Constant.ruleWait);
			waitForElement(driver, toastMsgClosedBtn);
			captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, nonAdminValidationText, "Insufficient privileges");
			

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	public void accountContributorShouldNotAbleToAddUserGroupInWorkspace(String workspaceName, String role, String accessto, String selectUserGroup) throws Exception
	{
	try {
		
	
			Workspaces w = new Workspaces(driver);
			w.clickOnWorkspaceMenu();
			w.searchWorkspaceAndClick(workspaceName);
			w.assigRoles(role, accessto);
			w.assignSingleUserGroup(selectUserGroup);
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
			
		
	}
	
	public void accountContributorShouldAbleToViewWorkspacePageAndListOfWorkspaces()
	{
		Workspaces w = new Workspaces(driver);
		try {
			w.clickOnWorkspaceMenu();
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
		
	}

	public void accountContAbleToRefreshWorkspaceList(SoftAssert soft)
	{
		Workspaces w = new Workspaces(driver);
		try {
			w.refresh_Workspace_Tab_Listing(soft);
			w.numberOfWorkspaces();
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	
	public void accountContShouldDiscardUnSavedChangesInExistingWorksapce(String workspaceName) {
		try {
			Workspaces w = new Workspaces(driver);
			w.clickOnWorkspaceMenu();
			w.searchWorkspaceAndClick(workspaceName);
			Thread.sleep(3000);
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String WSname = workspaceName + timeStamp;
			String WSDesc = workspaceName + timeStamp;

			clear_Click_SendKeys(driver, 20, newWorkspaceName, WSname);
			BaseSuite.validationReportLog("Entered worspace name: " + WSname);
			waitForElement(driver, workspaceDescdetails);
			clear(driver, workspaceDescdetails);
			clear_Click_SendKeys(driver, 20, workspaceDescdetails, WSDesc);
			BaseSuite.validationReportLog("Entered workspace Description: " + WSDesc);

			if (isEnabled(driver, DiscardButton)) {
				BaseSuite.reportLog("Clicking on the discard button");
				waitForElement(driver, DiscardButton);

				isDisplayedInLoop(driver, 30, DiscardButton);
				click(driver, DiscardButton);

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
				BaseSuite.reportFailLog("Discard button not enabled", "discardDetailsInExistingAccount");
			}

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	public void roleAssignWindowDetailsForWorkspace() {
		try {
			verifyRoleAssignmentWindow();

			BaseSuite.reportLog("Checking the Role dropdown");
			isDisplayedInLoop(driver, 30, roleDropDown);
			BaseSuite.reportLog("Entering the Role details");
			sendKeys(driver, roleDropDown, "Owner");
			BaseSuite.reportLog("Entering the details of Owner in the Role Dropdown");
			Thread.sleep(2000);
			String ownerDetails = getAttribute(driver, ownerOptionInDropDown, "aria-label");
			BaseSuite.reportLog("Checking Owner option in the Dropdown");
			if (ownerDetails.equalsIgnoreCase("Owner")) {
				BaseSuite.validationReportLog(ownerDetails + " available in the Dropdown option");
			} else {
				BaseSuite.reportFailLog("Dropdown option is not available", "roleAssignWindowDetailsForWorkspace");
			}

			BaseSuite.reportLog("Entering the Role details");
			sendKeys(driver, roleDropDown, "Contributor");
			BaseSuite.reportLog("Entering the details of Contributor in the Role Dropdown");
			Thread.sleep(2000);
			String contributorDetails = getAttribute(driver, contributorOptionInDropDown, "aria-label");
			BaseSuite.reportLog("Checking Contributor option in the Dropdown");
			if (contributorDetails.equalsIgnoreCase("Contributor")) {
				BaseSuite.validationReportLog(contributorDetails + " available in the Dropdown option");
			} else {
				BaseSuite.reportFailLog("Dropdown option is not available", "roleAssignWindowDetailsForWorkspace");
			}

			BaseSuite.reportLog("Entering the Role details");
			sendKeys(driver, roleDropDown, "Executor");
			BaseSuite.reportLog("Entering the details of Executor in the Role Dropdown");
			Thread.sleep(2000);
			String executorDetails = getAttribute(driver, executorOptionInDropDown, "aria-label");
			BaseSuite.reportLog("Checking Executor option in the Dropdown");
			if (executorDetails.equalsIgnoreCase("Executor")) {
				BaseSuite.validationReportLog(executorDetails + " available in the Dropdown option");
			} else {
				BaseSuite.reportFailLog("Dropdown option is not available", "roleAssignWindowDetailsForWorkspace");
			}

			BaseSuite.reportLog("Entering the Role details");
			sendKeys(driver, roleDropDown, "Reader");
			BaseSuite.reportLog("Entering the details of Reader in the Role Dropdown");
			Thread.sleep(2000);
			String readerDetails = getAttribute(driver, readerOptionInDropDown, "aria-label");
			BaseSuite.reportLog("Checking Reader option in the Dropdown");
			if (readerDetails.equalsIgnoreCase("Reader")) {
				BaseSuite.validationReportLog(readerDetails + " available in the Dropdown option");
			} else {
				BaseSuite.reportFailLog("Dropdown option is not available", "roleAssignWindowDetailsForWorkspace");
			}

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	

	public void workspaceNameShouldNotAcceptInvalidData(SoftAssert soft)
	{
		try {
		Workspaces w = new Workspaces(driver);
		BaseSuite.reportLog("Verifying workspace name with more than 50Char ::::::::::::::::::::::::::::::");
		w.workspaceNameWithMoreThan50Char(w.ExceedCharactersTextDetails, w.ExceedCharValMsg, "WorkspaceName",
				w.NameExceedCharErrorMsgText, soft);
		driver.navigate().refresh();
		Thread.sleep(3000);
		BaseSuite.reportLog("Verifying workspace name with Blank Data ::::::::::::::::::::::::::::::");
		w.workspaceNameWithBlankData(w.WorkspaceName, w.workspaceNameMandatoryVal, "WorkspaceNameDetails", soft,
				"WorkspaceName", w.workspaceNameMandatoryText);
		driver.navigate().refresh();
		Thread.sleep(3000);
		BaseSuite.reportLog("Verifying workspace name with Invalid special characters ::::::::::::::::::::::::::::::");
		}
		catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	
	public void accountContributorShouldAbleToAddWorkspaceFromWorkspaceSection(String account, String workspaceName, String workspaceDesc, String type)
	{
		try {
		Workspaces w = new Workspaces(driver);
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String WSname = workspaceName + timeStamp;
		String WSDesc = workspaceName + timeStamp;
		
		w.createWorkspace(account, WSname, WSDesc, type);
		driver.navigate().refresh();
		}
		catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	
	public void removeUserGroupForNonAdminUser() {
		try {
			BaseSuite.reportLog("Verifying User/Group tab");
			isDisplayedInLoop(driver, 30, userGroupTab);
			click(driver, userGroupTab);
			BaseSuite.reportLog("Clicked on the  User/Group tab");

			BaseSuite.reportLog("Selecting the User/Group:::");
			click(driver, removeUserCheckbox);
			BaseSuite.validationReportLog("User/Group is selected to remove");

			BaseSuite.reportLog("Check remove button enabled or not after selection of User/Group");
			if (isEnabled(driver, removedBtn)) {
				BaseSuite.validationReportLog("Remove button enabled after selection of User/Group");
				isDisplayedInLoop(driver, 20, removedBtn);
				BaseSuite.reportLog("Clicking on the remove button");
				click(driver, removedBtn);
				isDisplayedInLoop(driver, 40, removeBtnYes);

				boolean flag = isDisplayed(driver, removeBtnYes);
				if (flag) {
					BaseSuite.validationReportLog(
							"User/Group remove discard pop up is dispalyed in the page after clickog on Remove button");
					displayAndClick(driver, removeBtnYes);
					BaseSuite.validationReportLog("User/Group remove conformation message accept successfully");
				} else {
					BaseSuite.reportFailLog(
							"User/Group remove discard pop up is not dispalyed in the page after clicking on Remove button",
							"removeUserGroupForNonAdminUser");
				}
				BaseSuite.reportLog("Validating the correct toast message after removing the User/Group");
				waitForElement(driver, commonToastMsg);
				captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, nonAdminValidationText,"Insufficient privileges");

			} else {
				BaseSuite.reportFailLog("Remove button not enabled after the selection of group",
						"removeUserGroupForNonAdminUser");
			}

			driver.navigate().refresh();

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	
	
	public void accountContributorShouldNotAbleToRemoveUserFromTheAccount(String accountName)
	{
		try {
			clickOnAccountsMenu();
			searchAccountAndClick(accountName);
			Thread.sleep(3000);
			removeUserGroupForNonAdminUser();
			driver.navigate().refresh();
		}
		catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	public void accountContributorShouldNotAbleToRemoveUserFromTheWorkspace(String workspaceName) {
		try {
			Workspaces w = new Workspaces(driver);
			w.clickOnWorkspaceMenu();
			w.searchWorkspaceAndClick(workspaceName);
			Thread.sleep(3000);
			removeUserGroupForNonAdminUser();
			Thread.sleep(3000);
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	
	public void accountContributorShouldNotAbleToCreateAccount(String name, String description)
	{
		try {
			accountOwnerShouldNotAbleToCreateNewAccount(name, description);
			driver.navigate().refresh();
		} catch (Exception e) {
			
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	public void accountContributorShouldNotAbleToUpdateExistingAccount(String accountName, String updatedAccountName,
			String updatedAccountDescription) {
		try {
			accountOwnerShouldNotAbleToUpdateExistingAccount(accountName, updatedAccountName,
					updatedAccountDescription);
			driver.navigate().refresh();
		} catch (Exception e) {

			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	// ******************** Account Executor ********************

	
	
	public void accountExecutorShouldNotAccessUserSection() throws Exception {
		try {
			Users user = new Users(driver);
			Thread.sleep(5000);
			user.clickOnUserMenuForNonAdminUser();
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);

		}
	}

	public void accountExecutorShouldNotAccessGroupSection() throws Exception {
		try {
		Groups group = new Groups(driver);
		Thread.sleep(5000);
		group.clickOnGroupMenuForNonAdminUser();
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);

		}
	}

	public void accountExecutorAccessOnListOfAccounts() throws Exception {
		try {
			clickOnAccountsMenu();
			numberOfAccounts();
			BaseSuite.validationReportLog("Account Executor is able to access on the listed Account!");
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	
	public void accountExecutorCanRefreshAccountListingPage()
	{
		SoftAssert soft = new SoftAssert();
		try {
			RefreshAccountListingPage(soft);
		}
		catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	public void accountSearchByAccountExecutor(String accountName) throws Exception {
		try {
			clickOnAccountsMenu();
			boolean available = isDisplayed(driver, firstRowInPage);
			if(available) {
			searchAccountAndClick(accountName);}
			else
			{
				BaseSuite.reportLog("No records to display :::::::::::::::::::::::: ");
			}
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	
	public void accountExecutorAbleToDiscardUnsavedChangesInAccount(String DiscardaccountName, String Description, String DiscardalertYes,String Account_search) throws Exception {
		try {
			discardDetailsInExistingAccount(DiscardaccountName, Description, DiscardalertYes, Account_search);
			driver.navigate().refresh();
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	public void accountExecutorAbleToReadAccountDetails(String accountName) {
		try {
			accountSearchByAccountExecutor(accountName);
			String accountName1	=getAttribute(driver, AccountName, "value");
			if (accountName.equals(accountName1)) {
				BaseSuite.reportLog("Account Name details is showing properly as per searched account details ");
				BaseSuite.validationReportLog("Account Name displayed::::" + accountName);

			} else {
				BaseSuite.reportFailLog("Unable to read the account name", "accountExecutorAbleToReadAccountDetails");

			}
			String accountdesc	=getAttribute(driver, AccountDescription, "value");
			BaseSuite.validationReportLog("Account Description displayed ::::" + accountdesc);

		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	public void accountExecutorShouldNotAbleToUpdateExistingAccount(String accountName, String updatedAccountName,String updatedAccountDescription) {
		try {
			accountOwnerShouldNotAbleToUpdateExistingAccount(accountName, updatedAccountName,updatedAccountDescription);
			driver.navigate().refresh();
		} catch (Exception e) {

			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	public void accountExecutorShouldNotAbleToAddUserGroupInAccount(String accountName, String role, String accessto, String selectUserGroup)
	{
		try {
			accountContributorShouldNotAbleToAddUserGroupInAccount(accountName, role, accessto, selectUserGroup);
			driver.navigate().refresh();
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	public void numberOfUserGroupInsideAccount(String accountName)
	{
		try {
		BaseSuite.validationReportLog("Verifying number of users/groups added in the account "+ accountName);
		
		isDisplayedInLoop(driver, 20, NumberOfAccounts);
		Thread.sleep(3000);
		BaseSuite.reportLog("::::: Verifying the total number of User/Groups :::::");
		String numbers = getText(driver, NumberOfAccounts);
		if(!numbers.isEmpty())
		{
		BaseSuite.validationReportLog("Number of User/Groups are available for the login user");
		BaseSuite.reportLog("Available User/Groups " + numbers);
		BaseSuite.validationReportLog(numbers + " number of User/Groups are displaying in the Page!!!");
		}
		else
		{
			BaseSuite.reportFailLog("Number of User/Groups are not displaying in the page!", "numberOfUserGroupInsideAccount");

		}
		}
		catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);		}
	}
	public void numberOfWorkspacesInsideAccount(String accountName)
	{
		try {
		BaseSuite.validationReportLog("Verifying number of Workspaces added in the account "+ accountName);
		
		isDisplayedInLoop(driver, 20, NumberOfAccounts);
		Thread.sleep(3000);
		BaseSuite.reportLog("::::: Verifying the total number of Workspaces :::::");
		String numbers = getText(driver, NumberOfAccounts);
		if(!numbers.isEmpty())
		{
		BaseSuite.validationReportLog("Number of Workspaces are available for the login user");
		BaseSuite.reportLog("Available Workspaces " + numbers);
		BaseSuite.validationReportLog(numbers + " number of Workspaces are displaying in the Page!!!");
		}
		else
		{
			BaseSuite.reportFailLog("Number of Workspaces are not displaying in the page!", "numberOfWorkspacesInsideAccount");

		}
		}
		catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);		}
	}
	
	public void accountExecutorCanRefreshUserListUnderUserGroupTabInAccount(String accountName) {
		try {
			clickOnAccountsMenu();
			searchAccountAndClick(accountName);
			BaseSuite.reportLog("Verifying the total number of User/Groups before clicking refresh button :::::::::::::");
			numberOfUserGroupInsideAccount(accountName);
			BaseSuite.reportLog("Verifying refresh button");
			isDisplayedInLoop(driver, 30, RefreshAccountsBtn);
			click(driver, RefreshAccountsBtn);
			BaseSuite.validationReportLog("Clicked on the refresh button!!!");
			BaseSuite.reportLog("Verifying the total number of User/Groups after clicking refresh button :::::::::::::");
			numberOfUserGroupInsideAccount(accountName);
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	public void accountExecutorShouldNotAbleToRemoveUserFromTheAccount(String accountName) 
	{
		accountContributorShouldNotAbleToRemoveUserFromTheAccount(accountName);
	}
	
	
	public void accountExecutorShouldReadAllListedWorkspaceInsideTheAccount(String accountName) {
		try {
			clickOnAccountsMenu();
			searchAccountAndClick(accountName);

			isDisplayedInLoop(driver, 30, WorkspaceTab);
			click(driver, WorkspaceTab);
			BaseSuite.validationReportLog("Clicked on the Workspace tab");
			Thread.sleep(3000);
			getElement(driver, table_element1);
			List<WebElement> tr_collection1 = getElements(driver, tableData);

			int size = tr_collection1.size() - 1;

			BaseSuite.validationReportLog("Number of Workspaces assign in the Account :::::::: " + size);
			BaseSuite.validationReportLog("User is able to read the all listed Workspaces");
			int row_num1, col_num1;
			row_num1 = 1;
			BaseSuite.reportLog("Reading the name of Workspaces which assign to account ::: " + accountName);
			for (WebElement tdElement1 : tr_collection1) {
				row_num1 = 1;
				System.out.println("Assign Workspaces ::::::" + tdElement1.getText());
				BaseSuite.validationReportLog("Assign User/Groups/Workspaces to account " + accountName + "::::::" + tdElement1.getText());
			}
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	
	public void accountExecutorShouldNotAbleToCreateWorkspaceFromAccountSection(String accountName, String name, String WSDesc, String type) {
		try {

			clickOnAccountsMenu();
			searchAccountAndClick(accountName);
			worspaceTab();

			BaseSuite.reportLog("Clicking on Add button to assign Workspace");
			displayAndClick(driver, addWorkspace);
			BaseSuite.validationReportLog("Add button clicked Successfully to assign Workspace");
			verifyAddWorkspacePage();

			BaseSuite.reportLog("Entering Workspace name in workspace field");
			displayAndClick(driver, addWorkspaceName);
			sendKeys(driver, addWorkspaceName, name);
			BaseSuite.validationReportLog("Workspace name entered successfully in workspace field ::: " + name);

			BaseSuite.reportLog("Entering Workspace Description in description field " + name);
			displayAndClick(driver, addWorkspaceDescription);
			sendKeys(driver, addWorkspaceDescription, WSDesc);
			BaseSuite.validationReportLog(
					"Workspace Description entered successfully in description field ::: " + WSDesc);

			BaseSuite.reportLog("Selecting the Workspace type:::: " + type);
			isDisplayed(driver, Workspacetype);

			click(driver, Workspacetype);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"ddlelement\"]/span/input[@placeholder='Select Type']"))
					.sendKeys(type);
			Thread.sleep(3000);

			BaseSuite.reportLog("Clicking on Add button to add Workspace");
			displayAndClick(driver, addRoleBtn);
			BaseSuite.validationReportLog("Add button clicked Successfully to add Workspace");

			waitForElement(driver, toastMsgClosedBtn);
			captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, nonAdminValidationText,"Insufficient privileges");

			driver.navigate().refresh();
		} catch (Exception e) {

			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	public void accountExecutorCanRefreshUserListUnderWorkspaceTabInAccount(String accountName) {
		try {
			clickOnAccountsMenu();
			searchAccountAndClick(accountName);
			BaseSuite.reportLog("Verifying the total number of Workspaces before clicking refresh button :::::::::::::");
			numberOfWorkspacesInsideAccount(accountName);
			BaseSuite.reportLog("Verifying refresh button");
			isDisplayedInLoop(driver, 30, RefreshAccountsBtn);
			click(driver, RefreshAccountsBtn);
			BaseSuite.validationReportLog("Clicked on the refresh button!!!");
			BaseSuite.reportLog("Verifying the total number of Workspaces after clicking refresh button :::::::::::::");
			numberOfWorkspacesInsideAccount(accountName);
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	public void accountExecutorAccessOnListOfWorkspaces() throws InterruptedException {
		try {
		Workspaces w = new Workspaces(driver);
		w.clickOnWorkspaceMenu();
		w.numberOfWorkspaces();
		BaseSuite.validationReportLog("Account Executor is able to access on the listed Workspaces!");
		}
		catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	
	
	public void accountExecutorWithInheritedWorkspacesList(String accountName)
	{
		try {
		Workspaces w = new Workspaces(driver);
		accountExecutorShouldReadAllListedWorkspaceInsideTheAccount(accountName);
		
		isDisplayedInLoop(driver, 40, inheritedAccNameInWSTab);
		String accName = getText(driver, inheritedAccNameInWSTab);
		BaseSuite.reportLog("Checking the inherited details for the workspace listed in the account :::: " + accountName);
		if(accName.equalsIgnoreCase(accountName))
		{
			BaseSuite.validationReportLog("Child workspace in the account is inherited the account role!!!");
		}
		else
		{
			BaseSuite.reportFailLog("Listed workspaces is not showing inherited account details", "accountExecutorWithInheritedWorkspacesList");
		}
		isDisplayedInLoop(driver, 30, workspaceClickInsideAcc);
		click(driver, workspaceClickInsideAcc);
		BaseSuite.reportLog("Clicked on the listed workspace");
		waitForElement(driver, toastMsgClosedBtn);
		captureToastMsg(driver, w.workspaceRetrivedMsg, toastMsgClosedBtn, w.workDetailMsg, "Workspace detail retrieved");
		BaseSuite.validationReportLog(":::::::::::::::::::: User able to access the inherited Workspace from the Account section");

	}
		catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	
	
	public void accountExecutorShouldNotCreateWorkspaceFromWorkspaceSection(String account, String workspaceName, String workspaceDesc, String type)
	{
		try {
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
			waitForElement(driver, toastMsgClosedBtn);
			captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, nonAdminValidationText, "Insufficient privileges");
			BaseSuite.validationReportLog("User is not able to create the workspace from workspace section :::::::");
			driver.navigate().refresh();
			Thread.sleep(3000);

		} else {

			BaseSuite.reportFailLog("User is able to create the workspace", "accountExecutorShouldNotCreateWorkspaceFromWorkspaceSection");
		}
		}
		catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	public void accountExecutorShouldNotUpdateExistingWorkspace(String WSName, String updatedWSName, String updatedWSDesc)
	{
		try {
		Workspaces w = new Workspaces(driver);
		w.clickOnWorkspaceMenu();
		w.searchWorkspaceAndClick(WSName);
		
		BaseSuite.reportLog("Entering the Workspace Name:::: " + updatedWSName);
		isDisplayedInLoop(driver, 30, newWorkspaceName);
		clear_Click_SendKeys(driver, 30, newWorkspaceName, updatedWSName);
		BaseSuite.validationReportLog("Entered updated workspace name: " + updatedWSName);

		BaseSuite.reportLog("Entering the Workspace Description:::: " + updatedWSDesc);
		isDisplayedInLoop(driver, 20, workspaceDescdetails);
		clear_Click_SendKeys(driver, 30, workspaceDescdetails, updatedWSDesc);
		BaseSuite.validationReportLog("Entered updated workspace description: " + updatedWSDesc);
		
		BaseSuite.reportLog("Verifying the Save button..");
		isDisplayedInLoop(driver, 30, WorkspaceSaveBtn);
		click(driver, WorkspaceSaveBtn);
		BaseSuite.validationReportLog("Clicked on the Save button");

		waitForElement(driver, toastMsgClosedBtn);
		captureToastMsg(driver, commonToastMsg, toastMsgClosedBtn, nonAdminValidationText, "Insufficient privileges");
	
		BaseSuite.validationReportLog("User is not able to update the workspace from workspace section :::::::");
		driver.navigate().refresh();
		Thread.sleep(3000);
	}
		catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	
	public void accountExecutorShouldNotAbleToAddUserGroupInWorkspace(String workspaceName, String role,
			String accessto, String selectUserGroup) {
		try {
			accountContributorShouldNotAbleToAddUserGroupInWorkspace(workspaceName, role, accessto, selectUserGroup);
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	

	public void accountExecutorCanAccessAccountWhenRoleAssignedAtGrouplevel(String accName, String UserGroup_search,
			String typeDetails) {
		try {
			Users user = new Users(driver);
			Groups group = new Groups(driver);
			Thread.sleep(5000);
			user.clickOnUserMenuForNonAdminUser();
			group.clickOnGroupMenuForNonAdminUser();
			clickOnAccountsMenu();
			searchAccountAndClick(accName);

			BaseSuite.reportLog("Searching for user/group : " + UserGroup_search);
			isDisplayedInLoop(driver, 30, searchB);
			click(driver, searchB);
			clear(driver, searchB);

			isDisplayedInLoop(driver, 30, searchB);
			BaseSuite.reportLog("Search Name of listed User/Group");
			sendKeys(driver, searchB, UserGroup_search);
			BaseSuite.reportLog("Click on searched button");

			isDisplayedInLoop(driver, 30, searchC);
			click(driver, searchC);

			isDisplayedInLoop(driver, 30, groupTypeInsideAccount);
			BaseSuite.reportLog("Verifying the Group Type inside the account..");
			String groupTypeFound = getText(driver, groupTypeInsideAccount);
			if (groupTypeFound.equalsIgnoreCase(typeDetails)) {
				BaseSuite.validationReportLog("User can access account when role assigned at group level :::::::");
			} else {
				BaseSuite.reportFailLog("Unable to find the User/group type for the search User/Group inside the Account", "accountExecutorCanAccessAccountWhenRoleAssignedAtGrouplevel");
			}
			
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}

	
	
	
	
	

	// ******************** Account Reader ********************

	
	public void accountReaderShouldNotAccessUserSection() throws Exception {
		try {
			Users user = new Users(driver);
			Thread.sleep(5000);
			user.clickOnUserMenuForNonAdminUser();
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);

		}
	}

	public void accountReaderShouldNotAccessGroupSection() throws Exception {
		try {
		Groups group = new Groups(driver);
		Thread.sleep(5000);
		group.clickOnGroupMenuForNonAdminUser();
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);

		}
	}
	
	
	public void accountReaderAccessOnListOfAccounts() throws Exception {
		try {
			clickOnAccountsMenu();
			numberOfAccounts();
			BaseSuite.validationReportLog("Account Reader is able to access on the listed Account!");
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	public void accountReaderAccessOnListOfWorkspaces() throws Exception {
		try {
		Workspaces w = new Workspaces(driver);
		w.clickOnWorkspaceMenu();
		w.numberOfWorkspaces();
		BaseSuite.validationReportLog("Account Reader is able to access on the listed Workspaces!");
		}
		catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	public void accountReaderAccessOnListOfRoles() throws Exception {
		try {
		Roles role = new Roles(driver);
		role.clickOnRolesMenu();
		role.verifyRolesPage();
		BaseSuite.validationReportLog("Account Reader is able to access on the listed Roles!");
		}
		catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	public void accountSearchByAccountReader(String accountName)
	{
		try {
			accountSearchByAccountExecutor(accountName);
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);

		}
	}
	
	
	public void accountReaderShouldNotAbleToCreateAccount(String name, String description)
	{
		try {
			accountOwnerShouldNotAbleToCreateNewAccount(name, description);
			driver.navigate().refresh();
		} catch (Exception e) {
			
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	public void accountReaderShouldNotAbleToUpdateExistingAccount(String accountName, String updatedAccountName,String updatedAccountDescription) {
		try {
			accountOwnerShouldNotAbleToUpdateExistingAccount(accountName, updatedAccountName,updatedAccountDescription);
			driver.navigate().refresh();
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	public void accountReaderAbleToReadAccountDetails(String accName) throws Exception {
		try {
			clickOnAccountsMenu();
			numberOfAccounts();
			accountExecutorAbleToReadAccountDetails(accName);
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	public void accountReaderShouldReadAllListedUserGroupsAndWorkspaceInsideTheAccount(String accountName)
	{
		try {
			accountOwnerShouldReadAllListedUserGroupsAndWorkspaceInsideTheAccount(accountName);
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	public void accountReaderShouldNotAbleToAddUserGroupInAccount(String accountName, String role, String accessto, String selectUserGroup)
	{
		try {
			accountContributorShouldNotAbleToAddUserGroupInAccount(accountName, role, accessto, selectUserGroup);
			driver.navigate().refresh();
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	public void accountReaderShouldNotAbleToRemoveUserFromTheAccount(String accountName) 
	{
		accountContributorShouldNotAbleToRemoveUserFromTheAccount(accountName);
	}
	
	
	public void accountReaderShouldNotAbleToCreateWorkspaceFromAccountSection(String accountName, String name, String WSDesc, String type )
	{
		accountExecutorShouldNotAbleToCreateWorkspaceFromAccountSection(accountName, name, WSDesc, type);
	}
	
	public void accountReaderAccessOnListOfWorkspacesAndClick(String workspaceName) throws InterruptedException {
		try {
		Workspaces w = new Workspaces(driver);
		w.clickOnWorkspaceMenu();
		w.numberOfWorkspaces();
		w.searchWorkspaceAndClick(workspaceName);
		BaseSuite.validationReportLog("User is able to access and click on the listed Workspaces!");
		}
		catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	public void accountReaderShouldNotUpdateExistingWorkspace(String WSName, String updatedWSName, String updatedWSDesc)
	{
		accountExecutorShouldNotUpdateExistingWorkspace(WSName, updatedWSName, updatedWSDesc);
	}
	
	public void accountReaderShouldNotCreateWorkspaceFromWorkspaceSection(String account, String workspaceName, String workspaceDesc, String type)
	{
		accountExecutorShouldNotCreateWorkspaceFromWorkspaceSection(account, workspaceName, workspaceDesc, type);
	}
	
	
	public void accountReaderShouldNotAbleToAddUserGroupInWorkspace(String workspaceName, String role,String accessto, String selectUserGroup)
	{
		accountExecutorShouldNotAbleToAddUserGroupInWorkspace(workspaceName, role, accessto, selectUserGroup);
	}
	
	
	public void accountReaderShouldNotAbleToRemoveUserFromTheWorkspace(String workspaceName) {
		try {
			Workspaces w = new Workspaces(driver);
			w.clickOnWorkspaceMenu();
			w.searchWorkspaceAndClick(workspaceName);
			Thread.sleep(3000);
			removeUserGroupForNonAdminUser();
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	public void accountReaderAbleToDiscardUnsavedChangesInAccount(String DiscardaccountName, String Description, String DiscardalertYes,String Account_search) throws Exception {
		try {
			discardDetailsInExistingAccount(DiscardaccountName, Description, DiscardalertYes, Account_search);
			driver.navigate().refresh();
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	public void accountReaderAbleToRefreshWorkspaceList(SoftAssert soft)
	{
		Workspaces w = new Workspaces(driver);
		try {
			w.refresh_Workspace_Tab_Listing(soft);
			w.numberOfWorkspaces();
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}


	
	public void accountReaderCanAccessAccountWhenRoleAssignedAtGrouplevel(String accName, String UserGroup_search,String typeDetails, String workspaceName)
	{
		try {
			Users user = new Users(driver);
			Groups group = new Groups(driver);
			Thread.sleep(5000);
			user.clickOnUserMenuForNonAdminUser();
			group.clickOnGroupMenuForNonAdminUser();
			clickOnAccountsMenu();
			searchAccountAndClick(accName);

			BaseSuite.reportLog("Searching for user/group : " + UserGroup_search);
			isDisplayedInLoop(driver, 30, searchB);
			click(driver, searchB);
			clear(driver, searchB);

			isDisplayedInLoop(driver, 30, searchB);
			BaseSuite.reportLog("Search Name of listed User/Group");
			sendKeys(driver, searchB, UserGroup_search);
			BaseSuite.reportLog("Click on searched button");

			isDisplayedInLoop(driver, 30, searchC);
			click(driver, searchC);

			isDisplayedInLoop(driver, 30, groupTypeDetails);
			BaseSuite.reportLog("Verifying the Group Type inside the account..");
			String groupTypeFound = getText(driver, groupTypeDetails);
			if (groupTypeFound.equalsIgnoreCase(typeDetails)) {
				BaseSuite.validationReportLog("User can access account when role assigned at group level :::::::");
			} else {
				BaseSuite.reportFailLog("Unable to find the User/group type for the search User/Group inside the Account", "accountReaderCanAccessAccountWhenRoleAssignedAtGrouplevel");
			}
			
			
			Workspaces w = new Workspaces(driver);
			w.clickOnWorkspaceMenu();
			w.searchWorkspaceAndClick(workspaceName);

			BaseSuite.reportLog("Searching for user/group : " + UserGroup_search);
			isDisplayedInLoop(driver, 30, searchB);
			click(driver, searchB);
			clear(driver, searchB);

			isDisplayedInLoop(driver, 30, searchB);
			BaseSuite.reportLog("Search Name of listed User/Group");
			sendKeys(driver, searchB, UserGroup_search);
			BaseSuite.reportLog("Click on searched button");

			isDisplayedInLoop(driver, 30, searchC);
			click(driver, searchC);

			isDisplayedInLoop(driver, 30, groupTypeDetails);
			BaseSuite.reportLog("Verifying the Group Type inside the account..");
			String groupTypeFound1 = getText(driver, groupTypeDetails);
			if (groupTypeFound1.equalsIgnoreCase(typeDetails)) {
				BaseSuite.validationReportLog("User can access Workspace when role assigned at group level :::::::");
			} else {
				BaseSuite.reportFailLog("Unable to find the User/group type for the search User/Group inside the Workspace", "accountReaderCanAccessAccountWhenRoleAssignedAtGrouplevel");
			}
			
		} catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	public void accountReaderWithInheritedWorkspacesList(String accountName)
	{
		try {
		Workspaces w = new Workspaces(driver);
		accountExecutorShouldReadAllListedWorkspaceInsideTheAccount(accountName);
		
		isDisplayedInLoop(driver, 40, inheritedAccNameInWSTabForReader);
		String accName = getText(driver, inheritedAccNameInWSTabForReader);
		BaseSuite.reportLog("Checking the inherited details for the workspace listed in the account :::: " + accountName);
		if(accName.equalsIgnoreCase(accountName))
		{
			BaseSuite.validationReportLog("Child workspace in the account is inherited the account role!!!");
		}
		else
		{
			BaseSuite.reportFailLog("Listed workspaces is not showing inherited account details", "accountReaderWithInheritedWorkspacesList");
		}
		isDisplayedInLoop(driver, 30, workspaceClickInsideAccForReader);
		click(driver, workspaceClickInsideAccForReader);
		BaseSuite.reportLog("Clicked on the listed workspace");
		waitForElement(driver, toastMsgClosedBtn);
		captureToastMsg(driver, w.workspaceRetrivedMsg, toastMsgClosedBtn, w.workDetailMsg, "Workspace detail retrieved");
		BaseSuite.validationReportLog("User able to access the inherited Workspace from the Account section");

	}
		catch (Exception e) {
			throw new AssertionError("Error occured in this method", e);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	}