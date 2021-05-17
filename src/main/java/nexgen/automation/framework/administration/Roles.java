package nexgen.automation.framework.administration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.util.PageUtil;

public class Roles extends PageUtil {

	
	WebDriver driver;

	public Roles(WebDriver driver) {

		this.driver = driver;

	}
	
	
	By rolesSidebar = getElementLocator(prop.getProperty("Roles.RolesSidebar"));
	By refreshBtn = getElementLocator(prop.getProperty("Roles.RefreshBtn"));
	By deleteBtn = getElementLocator(prop.getProperty("Roles.DeleteBtn"));
	By searchBar = getElementLocator(prop.getProperty("Roles.SearchBar"));
	By searchClick = getElementLocator(prop.getProperty("Roles.SearchClick"));
	By sumberOfRoles = getElementLocator(prop.getProperty("Roles.NumberOfRoles"));
	By searchList1 = getElementLocator(prop.getProperty("Roles.SearchList"));
	By searchDataDetails = getElementLocator(prop.getProperty("Roles.SearchDataDetails"));
	By numberOfRoles = getElementLocator(prop.getProperty("Roles.NumberOfRoles"));
	By rolesName = getElementLocator(prop.getProperty("Roles.RolesName"));
	By rolesDescription = getElementLocator(prop.getProperty("Roles.RolesDescription"));
	By rolesPriviligesSearchBar = getElementLocator(prop.getProperty("Roles.RolesPriviligesSearchBar"));
	By rolesInputField = getElementLocator(prop.getProperty("Roles.RolesInputField"));
	By rolesTextField = getElementLocator(prop.getProperty("Roles.RolesTextField"));
	By Spinner = getElementLocator(prop.getProperty("Spinner"));
	By applicationAdmin = getElementLocator(prop.getProperty("Roles.ApplicationAdmin"));
	By owner = getElementLocator(prop.getProperty("Roles.Owner"));
	By contributor = getElementLocator(prop.getProperty("Roles.Contributor"));
	By executor = getElementLocator(prop.getProperty("Roles.Executor"));
	By reader = getElementLocator(prop.getProperty("Roles.Reader"));
	By selectAllCheckbox = getElementLocator(prop.getProperty("Roles.SelectAllCheckbox"));
	By singleCheckbox = getElementLocator(prop.getProperty("Roles.SingleCheckbox"));
	By accounts = getElementLocator(prop.getProperty("Accounts"));
	
	By roleGridDetailsName = getElementLocator(prop.getProperty("Roles.GridDetailsName"));
	By roleGridDetailsDescription = getElementLocator(prop.getProperty("Roles.GridDetailsDescription"));
	By pagination = getElementLocator(prop.getProperty("Roles.pagination"));
	By roleNames = getElementLocator(prop.getProperty("Roles.RoleNames"));
	By homeLink = getElementLocator(prop.getProperty("Roles.HomeLink"));
	By rolesLink = getElementLocator(prop.getProperty("Roles.RolesLink"));
	String SearchList = prop.getProperty("Roles.SearchList");
	String searchPriviligesList = prop.getProperty("Roles.SearchPriviligesList");
	String searchRoleName = prop.getProperty("Roles.SearchRoleName");
	
	public String nameText = prop.getProperty("Roles.Name");
	public String descriptionText = prop.getProperty("Roles.Description");
	public String priviligesName = prop.getProperty("Roles.PriviligesName");
	public String priviligesDec = prop.getProperty("Roles.PriviligesDec");
	
	
	public void clickOnRolesMenu() throws Exception
	{
		isDisplayedInLoop(driver, 30, rolesSidebar);
		BaseSuite.reportLog("Clicked on the Roles menu!");
		click(driver, rolesSidebar);
		//Thread.sleep(2000);
		BaseSuite.validationReportLog("Roles Menu clicked successful");
		inVisible(driver, Spinner, Constant.ruleWait);
		verifyRolesPage();
	}
	
	
	
	
	public void verifyDefaultRolesPage() {

		try {
			clickOnRolesMenu();
			BaseSuite.reportLog("Verifying Refresh Button in the Roles page");

			boolean newRefreshButton = isEnabled(driver, refreshBtn);

			if (newRefreshButton) {
				BaseSuite.validationReportLog("New User creation button is enabled");
			} else {
				BaseSuite.reportFailLog("New User creation button is disabled", "verifyDefaultRolesPage");
			}

			BaseSuite.reportLog("Verifying Delete Role Button in the User page");

			
			boolean deleteRole = isDisplayed(driver, deleteBtn);

			if (deleteRole) {

				BaseSuite.validationReportLog("Delete role button is enabled");

			} else {

				BaseSuite.reportFailLog("Delete role button is disabled", "verifyDefaultRolesPage");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void verifyRolesPageDetails() {

		try {
			String rolePageDetails = "Refresh Button/Delete Role";

			clickOnRolesMenu();

			if ((isDisplayed(driver, refreshBtn)) && (isDisplayed(driver, deleteBtn) && (isDisplayed(driver, searchBar)))) {
				BaseSuite.validationReportLog("Roles Page Details for Links, Menus and Buttons!");
				BaseSuite.reportLog(rolePageDetails + " details of roles page are displayed!");
				
			} else {
				BaseSuite.reportFailLog(rolePageDetails + " are not displaying in the page", "verifyRolesPageDetails");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	public void verifyRolesGridDetailsInfo() {

		String gridDetails = "Name/Description grid details";
		
		if ((isDisplayed(driver, roleGridDetailsName)) && (isDisplayed(driver, roleGridDetailsDescription))) {
	
			BaseSuite.validationReportLog("Column in the Grid details of roles page!");
			BaseSuite.reportLog(gridDetails + " labels are displayed properly in the role Page!");

		} else {
			BaseSuite.reportFailLog(gridDetails + " some labels are missing from the roles", "verifyRolesGridDetailsInfo");
		}
		
		
		
		

	}

	
	
	public void verifynumberOfRoles(int count) throws InterruptedException
	{
		
		isDisplayedInLoop(driver, 20, numberOfRoles);
		Thread.sleep(3000);
		String numbers = getText(driver, numberOfRoles);
		
		if(numbers.contains(String.valueOf(count)))
		{
			BaseSuite.validationReportLog(numbers+"Number of roles are displaying in the Roles Page!");
		}
		else
		{
			BaseSuite.reportFailLog("Extra Number of roles are displaying in the Roles Page!", "verifynumberOfRoles");
		}
	
	

	}
	
	public void verifynumberOfPriviliges(String rolesName) throws InterruptedException
	{
		
		isDisplayedInLoop(driver, 20, numberOfRoles);
		
		String numbers = getText(driver, numberOfRoles);

		if (rolesName.equalsIgnoreCase("Owner") || rolesName.equalsIgnoreCase("ApplicationAdmin")) {

			if (numbers.contains(String.valueOf(3))) {
				BaseSuite.validationReportLog(numbers + "Number of Priviliges are displaying in the Roles Page!");
			} else {
				BaseSuite.reportFailLog("Extra Number of Priviliges are displaying in the Roles Page!",
						"verifynumberOfPriviliges");
			}
		}
		else if(rolesName.equalsIgnoreCase("Contributor"))
		{
			if (numbers.contains(String.valueOf(2))) {
				BaseSuite.validationReportLog(numbers + "Number of Priviliges are displaying in the Roles Page!");
			} else {
				BaseSuite.reportFailLog("Extra Number of Priviliges are displaying in the Roles Page!",
						"verifynumberOfPriviliges");
			}
			
		}
		else
		{
			if (numbers.contains(String.valueOf(1))) {
				BaseSuite.validationReportLog(numbers + "Number of Priviliges are displaying in the Roles Page!");
			} else {
				BaseSuite.reportFailLog("Extra Number of Priviliges are displaying in the Roles Page!",
						"verifynumberOfPriviliges");
			}
			
		}
	
	

	}
	
	

	public void searchRole(String roleSearch) throws Exception {
		
		BaseSuite.reportLog("Searching for Role:" + roleSearch);
		isDisplayedInLoop(driver, 30, searchBar);

		javascript(driver, "arguments[0].click();", searchBar);
		clear(driver, searchBar);

		isDisplayedInLoop(driver, 30, searchBar);
		BaseSuite.reportLog("Entering search Name in search bar");
		sendKeys(driver, searchBar, roleSearch);
		BaseSuite.reportLog("searched name entered successfuly");

		isDisplayedInLoop(driver, 30, searchClick);

		javascript(driver, "arguments[0].click();", searchClick);
		
		visible(driver, returnElement(SearchList, "$role_search", roleSearch), Constant.ruleWait);

		BaseSuite.validationReportLog("Clicked on the search for the role");
		
		BaseSuite.reportLog("Searching for Role:" + roleSearch);
		isDisplayedInLoop(driver, 30, searchBar);

		javascript(driver, "arguments[0].click();", searchBar);
		clear(driver, searchBar);

		isDisplayedInLoop(driver, 30, searchBar);
		BaseSuite.reportLog("Entering search Name in search bar");
		sendKeys(driver, searchBar, roleSearch);
		BaseSuite.reportLog("searched name entered successfuly");

		isDisplayedInLoop(driver, 30, searchClick);

		javascript(driver, "arguments[0].click();", searchClick);
		
		visible(driver, returnElement(SearchList, "$role_search", roleSearch), Constant.ruleWait);

		BaseSuite.validationReportLog("Clicked on the search for the role");
		try {

			BaseSuite.reportLog("Click on Searched Role");

			javascript(driver, "arguments[0].click();", returnElement(SearchList, "$role_search", roleSearch));

			BaseSuite.reportLog("Clicked on Role: " + roleSearch);
			BaseSuite.reportLog("Roles Details retrieved successfully  " + roleSearch);

		} catch (Exception e) {
			throw new Exception("Roles_search " + searchClick + " not found");
		}
	}
	
	public void verifyRolesPage()
	{
		try {
			verifyVisibilityOfButtons(driver, refreshBtn, "Referesh Button", true);
			verifyVisibilityOfButtons(driver, deleteBtn, "Delete Button", false);
			getAllLinkAndVerifyLinkText(driver, homeLink, "Home");
			isClickable(driver, homeLink, "Home", true);
			getAllLinkAndVerifyLinkText(driver, homeLink, "Home");
			isClickable(driver, homeLink, "Home", true);
			getAllLinkAndVerifyLinkText(driver, rolesLink, "roles");
			isClickable(driver, rolesLink, "Roles", true);
			inVisible(driver, Spinner, Constant.ruleWait);
			verifyRolesGridDetailsInfo();
			inVisible(driver, Spinner, Constant.ruleWait);
			verifynumberOfRoles(5);
		} catch (Exception e) {
			
			e.getMessage();
		}
		
		
		
	}
	
	public void verifySearchedPriviliges(String rolePriviliges)
	{
		
		int count = getcount(rolePriviliges, ';');

		String[] result = rolePriviliges.split(";");

		for (int colNum = 0; colNum <= count; colNum++) {

			String priviliges = result[colNum];

			String[] pri = priviliges.split(":");

			String name = pri[0];

			String des = pri[1];

			BaseSuite.reportLog("Searching for Role Priviliges:" + name);
			isDisplayedInLoop(driver, 30, rolesPriviligesSearchBar);

			javascript(driver, "arguments[0].click();", rolesPriviligesSearchBar);
			clear(driver, rolesPriviligesSearchBar);

			isDisplayedInLoop(driver, 30, rolesPriviligesSearchBar);
			BaseSuite.reportLog("Entering search Name in search bar");
			sendKeys(driver, rolesPriviligesSearchBar, name);
			BaseSuite.reportLog("searched name entered successfuly");

			isDisplayedInLoop(driver, 30, searchClick);

			javascript(driver, "arguments[0].click();", searchClick);

			BaseSuite.validationReportLog("Clicked on the search for the role");
			try {

				BaseSuite.reportLog("Click on Searched Role");

				javascript(driver, "arguments[0].click();", returnElement(searchPriviligesList, "$User", name));

				BaseSuite.reportLog("Clicked on Role Priviliges: " + name);
				
				isDisplayedInLoop(driver, 30, returnElement(searchPriviligesList, "$User", name));

				String priviligesName = getText(driver, returnElement(searchPriviligesList, "$User", name));
			

				if (priviligesName.equalsIgnoreCase(name)) {
					BaseSuite.validationReportLog("Priviliges Name matched successfully : " +name);
				} else {
					BaseSuite.reportFailLog("Priviliges Name not matched", "verifysearchRole");

				}
				
				isDisplayedInLoop(driver, 30, returnElement(searchPriviligesList, "$User", des));

				String priviligesDescription = getText(driver, returnElement(searchPriviligesList, "$User", des));

				if (priviligesDescription.equalsIgnoreCase(des)) {
					BaseSuite.validationReportLog("Priviliges Description matched successfully : " +des);
				} else {
					BaseSuite.reportFailLog("Priviliges Description not matched", "verifysearchRole");

				}

			} catch (Exception e) {
				e.getMessage();

			}
		}
	}
		
	
	public void verifyRolesSearch(String rolesName,String rolesDesc)
	{
		BaseSuite.reportLog("Searching for Role:" + rolesName);
		isDisplayedInLoop(driver, 30, searchBar);

		javascript(driver, "arguments[0].click();", searchBar);
		clear(driver, searchBar);

		isDisplayedInLoop(driver, 30, searchBar);
		BaseSuite.reportLog("Entering search Name in search bar");
		sendKeys(driver, searchBar, rolesName);
		BaseSuite.reportLog("searched name entered successfuly");

		isDisplayedInLoop(driver, 30, searchClick);

		javascript(driver, "arguments[0].click();", searchClick);

		visible(driver, returnElement(SearchList, "$role_search", rolesName), Constant.ruleWait);

		BaseSuite.validationReportLog("Clicked on the search for the role");

		BaseSuite.reportLog("Searching for Role:" + rolesName);
		isDisplayedInLoop(driver, 30, searchBar);

		javascript(driver, "arguments[0].click();", searchBar);
		clear(driver, searchBar);

		isDisplayedInLoop(driver, 30, searchBar);
		BaseSuite.reportLog("Entering search Name in search bar");
		sendKeys(driver, searchBar, rolesName);
		BaseSuite.reportLog("searched name entered successfuly");

		isDisplayedInLoop(driver, 30, searchClick);

		javascript(driver, "arguments[0].click();", searchClick);

		visible(driver, returnElement(SearchList, "$role_search", rolesName), Constant.ruleWait);

		BaseSuite.validationReportLog("Clicked on the search for the role");
		BaseSuite.reportLog("Verifying Searched Roles Name");
		isDisplayedInLoop(driver, 30, returnElement(searchRoleName, "$User", rolesName));

		String name = getText(driver, returnElement(searchRoleName, "$User", rolesName)).trim();

		if (name.equalsIgnoreCase(rolesName.trim())) {
			BaseSuite.validationReportLog("Roles Name matched successfully : " + rolesName);
		} else {
			BaseSuite.reportFailLog("Roles Name not matched", "verifysearchRole");

		}

		BaseSuite.reportLog("Verifying Searched Roles Description");
		isDisplayedInLoop(driver, 30, returnElement(searchPriviligesList, "$User", rolesDesc));

		String description = getText(driver, returnElement(searchPriviligesList, "$User", rolesDesc)).trim();

		if (description.equalsIgnoreCase(rolesDesc.trim())) {
			BaseSuite.validationReportLog("Roles Description matched successfully : " + rolesDesc);
		} else {
			BaseSuite.reportFailLog("Roles Description not matched", "verifysearchRole");

		}

	}
	
	public void permissionSearchedShouldSearchedFromTheListOPpermissions(String role_search,String nameRoles,String descriptionRoles,String rolePriviliges)
	{
		try {
			clickOnRolesMenu();
			searchRole(role_search);
			visible(driver, rolesName, Constant.ruleWait);
			validateInputFields(driver, rolesInputField, 1);
			validateTextFields(driver, rolesTextField, 1);
			verifyRetrivedValues(driver, rolesName, "Name", "value", nameRoles);
			verifyRetrivedValues(driver, rolesDescription, "Description", "value", descriptionRoles);
			verifynumberOfPriviliges(role_search);
			verifySearchedPriviliges(rolePriviliges);
		
		} catch (Exception e) {
			
			e.getMessage();
		}
		
	}
	
	public void detailsRoleShouldDisplayedOnClickSpecificRole(String roleSearch,String nameRoles,String descriptionRoles)
	{
		try {
			clickOnRolesMenu();
			searchRole(roleSearch);
			visible(driver, rolesName, Constant.ruleWait);
			validateInputFields(driver, rolesInputField, 1);
			validateTextFields(driver, rolesTextField, 1);
			verifyRetrivedValues(driver, rolesName, "Name", "value", nameRoles);
			verifyRetrivedValues(driver, rolesDescription, "Description", "value", descriptionRoles);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void rolesShouldSearchedFromListOfRoles(String roleSearch, String rolesDesc) {
		try {
			verifyRolesSearch(roleSearch, rolesDesc);
		} catch (Exception e) {
			e.getMessage();
		}

	}
	
	public void navigateToRoles()
	{
		displayAndClick(driver, accounts);
		
	}
	public void listOfRolesShouldDisplayedOnClickRoleSideBar() {
		
		try {
			clickOnRolesMenu();

			String gridDetails = "(Application Admin, Owner, Contributor, Executor, Reader)";
			
			BaseSuite.reportLog("Verifying Roles int he Roles Page!");
			
			if ((isDisplayed(driver, applicationAdmin)) && (isDisplayed(driver, owner)) && (isDisplayed(driver, contributor))
					&& (isDisplayed(driver, executor)) && (isDisplayed(driver, reader))) {

				BaseSuite.validationReportLog(gridDetails+ "Roles are displayed in the Roles page!");
			

			} else {
				BaseSuite.reportFailLog(gridDetails + " some Roles are missing from the Roles page!",
						"listOfRolesShouldDisplayedOnClickRoleSideBar");
			}
		} catch (Exception e) {
		
			e.getMessage();
		}

	}
	
	public void deleteRoleButtonShouldDisabledOnSelectAndDeselectTheRole()
	{
		try {
			clickOnRolesMenu();
			
			displayAndClick(driver,selectAllCheckbox);
			
			verifyVisibilityOfButtons(driver, deleteBtn, "Visibility of Delete button at Select All Functionality", true);
			
			displayAndClick(driver,selectAllCheckbox);
			
			verifyVisibilityOfButtons(driver, deleteBtn, "Visibility of Delete button at Unselect All Functionality", true);
			
			displayAndClick(driver,singleCheckbox);
			
			verifyVisibilityOfButtons(driver, deleteBtn, "Visibility of Delete button at single select Functionality", true);
			
			displayAndClick(driver,singleCheckbox);
			
			verifyVisibilityOfButtons(driver, deleteBtn, "Visibility of Delete button at single unselect Functionality", true);
		} catch (Exception e) {
			
			e.getMessage();
		}
		
	}
	
	public void rolesRefereshFunctionality()
	{
		try {
			clickOnRolesMenu();
			
			displayAndClick(driver,refreshBtn);
			
			boolean flag = isDisplayed(driver, Spinner);
			
			if (flag) {
				BaseSuite.validationReportLog("Referesh spinner is visible after clicking on Referesh button");
			} else {
				BaseSuite.reportFailLog("Referesh spinner is not visible after clicking on Referesh button", "rolesRefereshFunctionality");

			}
			
			displayAndClick(driver,selectAllCheckbox);
			
			displayAndClick(driver,refreshBtn);
			
			inVisible(driver, Spinner, Constant.ruleWait);
			
			boolean selectAllFlag = isSelected(driver, selectAllCheckbox); 

			if (selectAllFlag) {
				BaseSuite.reportFailLog(
						"Select all functionality is not getting unselect after clicking on Referesh button",
						"rolesRefereshFunctionality");

			} else {
				BaseSuite.validationReportLog(
						"Select all functionality is getting unselect after clicking on Referesh button");
			}
			
			displayAndClick(driver,singleCheckbox);
			
			displayAndClick(driver,refreshBtn);
			
			inVisible(driver, Spinner, Constant.ruleWait);
			
			boolean singleSelectFlag = isSelected(driver, singleCheckbox); 

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
