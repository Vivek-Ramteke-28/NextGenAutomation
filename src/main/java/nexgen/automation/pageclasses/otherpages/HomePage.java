package nexgen.automation.pageclasses.otherpages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.util.PageUtil;

public class HomePage extends PageUtil {

	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;

	}

	public By AdministrationLabel = getElementLocator(prop.getProperty("LandingPage.AdministrationLabel"));
	By DataConnectionsLabel = getElementLocator(prop.getProperty("LandingPage.DataConnectionsLabel"));
	By WelcomeHeader = getElementLocator(prop.getProperty("Landingpage.WelcomeHeader"));
	By WelcomeUser = getElementLocator(prop.getProperty("Landingpage.WelcomeUser"));
	By UserName = getElementLocator(prop.getProperty("Landingpage.UserName"));
	
	
	By UserOption = getElementLocator(prop.getProperty("LandingPage.UserOptions"));
	By Profile = getElementLocator(prop.getProperty("LandingPage.Profile"));
	By Logout = getElementLocator(prop.getProperty("LandingPage.Logout"));
	

	By RuleConfigurationLabel = getElementLocator(prop.getProperty("LandingPage.RuleConfigurationLabel"));
	By TestLabLabel = getElementLocator(prop.getProperty("LandingPage.TestLabLabel"));
	By SchedulerLabel = getElementLocator(prop.getProperty("LandingPage.SchedulerLabel"));
	By OrchestrationLabel = getElementLocator(prop.getProperty("LandingPage.OrchestrationLabel"));
	By CodeRepositoryLabel = getElementLocator(prop.getProperty("LandingPage.CodeRepositoryLabel"));
	By DataCatalogLabel = getElementLocator(prop.getProperty("LandingPage.DataCatalogLabel"));
	By ListIcon = getElementLocator(prop.getProperty("LandingPage.ListIcon"));
	By ListIconAdministration = getElementLocator(prop.getProperty("LandingPage.ListIcon.Administration"));
	By ListIconDataConnection = getElementLocator(prop.getProperty("LandingPage.ListIcon.DataConnection"));
	By ListIconRuleConfiguration = getElementLocator(prop.getProperty("LandingPage.ListIcon.RuleConfiguration"));
	
	By AdministrationHomePageLabel = getElementLocator(prop.getProperty("LandingPage.AdministrationHomePageLabel"));
	By ToastMsgClosedBtn = getElementLocator(prop.getProperty("ToastMsgClosedBtn"));
	
	//Side nmenus
	By UserMenu = getElementLocator(prop.getProperty("Admin.UserMenu"));
	By GroupsMenu = getElementLocator(prop.getProperty("Admin.GroupsMenu"));
	By RolesMenu = getElementLocator(prop.getProperty("Admin.RolesMenu"));
	By AccountsMenu = getElementLocator(prop.getProperty("Admin.AccountsMenu"));
	By WorkspaceMenu = getElementLocator(prop.getProperty("Admin.WorkspaceMenu"));
	

	public void verifyLandingPage_Services() {
		
		String msg = "Admin/RuleConfiguration/TestLab/Scheduler/Orchestration/CodeRepository/DataCatalog";
		
		if ((isEnabled(driver, AdministrationLabel)) && (isEnabled(driver, RuleConfigurationLabel)) && (isEnabled(driver, TestLabLabel))
				&& (isEnabled(driver, SchedulerLabel)) && (isEnabled(driver, OrchestrationLabel))
				&& (isEnabled(driver, CodeRepositoryLabel)) && (isEnabled(driver, DataCatalogLabel))) {
		
			BaseSuite.reportLog(msg+ " options are displaying in the page");
			BaseSuite.validationReportLog("Serives are displaying on the Landing Page!!");

		} else {
			BaseSuite.reportFailLog(msg+ " is not displaying in the page", "verifyLandingPage_Services");
		}

	
	}

	public void administration() throws Exception {

		verifyLandingPage_Services(); // landing page verification
		BaseSuite.reportLog("Checking for the Administration service");
		isDisplayedInLoop(driver, 30, AdministrationLabel);

		click(driver, AdministrationLabel);
		BaseSuite.validationReportLog("Clicked on the Administration service!!");
		getWindowHandler(driver);
		
		Thread.sleep(3000);
		isDisplayed(driver, AdministrationHomePageLabel);
		BaseSuite.reportLog("Landed on Administration service page!");
		BaseSuite.validationReportLog("Welcome to Administration Section, With Aministration Section, you can manage users, accounts and workspaces!!");
		/*
		 * waitForElement(driver, ToastMsgClosedBtn); click(driver, ToastMsgClosedBtn);
		 */
		verifySideMenus();
	}

	
	public void verifySideMenus()
	{
		String msg = "Users/Groups/Roles/Accounts/Workspace";
		BaseSuite.reportLog("Checking the side bar options in the Administration Section!!");

		if ((isEnabled(driver, UserMenu)) && (isEnabled(driver, GroupsMenu)) && (isEnabled(driver, RolesMenu))
				&& (isEnabled(driver, AccountsMenu)) && (isEnabled(driver, WorkspaceMenu))) {
		
			BaseSuite.reportLog(msg+ " options are displaying in the administration page");
			BaseSuite.validationReportLog("Sidebar menus are displaying in the Administration Home page!!");

		} else {
			BaseSuite.reportFailLog(msg+ " is not displaying in the page", "verifySideMenus");
		}
	}
	
	public void dataConnections() {

		isDisplayedInLoop(driver, 20, DataConnectionsLabel);

		click(driver, DataConnectionsLabel);
		BaseSuite.reportLog("Landed on Data Connection service page!");
	}

	public void ruleConfiguration() {

		isDisplayedInLoop(driver, 20, RuleConfigurationLabel);

		click(driver, RuleConfigurationLabel);
		BaseSuite.reportLog("Landed on Rule Configuration service page!");
	}

	public void testLab() {

		isDisplayedInLoop(driver, 20, TestLabLabel);

		click(driver, TestLabLabel);
		BaseSuite.reportLog("Landed on Test Lab service page!");
	}

	public void scheduler() {

		isDisplayedInLoop(driver, 20, SchedulerLabel);

		click(driver, SchedulerLabel);
		BaseSuite.reportLog("Landed on Scheduler service page!");
	}

	public void orchestration() {

		isDisplayedInLoop(driver, 20, OrchestrationLabel);

		click(driver, OrchestrationLabel);
		BaseSuite.reportLog("Landed on Orchestration service page!");
	}

	public void codeRepository() {

		isDisplayedInLoop(driver, 20, CodeRepositoryLabel);

		click(driver, CodeRepositoryLabel);
		BaseSuite.reportLog("Landed on Code Repository service page!");
	}

	public void dataCatalog() {

		isDisplayedInLoop(driver, 20, DataCatalogLabel);

		click(driver, DataCatalogLabel);
		BaseSuite.reportLog("Landed on Data Catalog service page!");
	}

//	public void ruleMonitor() {
//		isDisplayedInLoop(driver, 20, RuleMonitor );
//	    click(driver,RuleMonitor);
//	  //  RuleMonitorPage rm =new RuleMonitorPage(driver);
//	  //  rm.verifyRuleMonitorLandingPage();
//	    
//	    BaseSuite.reportLog("Landed on Rule Monitor page");
//	}

	
	
	public void verifyLoginUser(String username)
	{
		isDisplayedInLoop(driver, 10, WelcomeUser);
		if(isEnabled(driver, WelcomeUser))
		{
			isDisplayed(driver, UserName);
			BaseSuite.reportLog(username+ " is displaying in the page");
			BaseSuite.validationReportLog(username + " this user is displaying on the page the Landing Page!!");
			
		}
		else
		{
			BaseSuite.reportLog(username+ " is not displaying in the page");
		}
		
	}
	
	public boolean verifyUserOption()
	{
		String options = "Profile/Logout";
		
		boolean flag = false;
		if(isEnabled(driver, WelcomeUser))
		{
		click(driver, UserOption);
		isDisplayedInLoop(driver, 20, Profile);
		isDisplayedInLoop(driver, 20, Logout);
		click(driver, UserOption);
		BaseSuite.reportLog(options + " Options are displaying in the User Dropdown");
		
		flag = true;
		}
		else
		{
			BaseSuite.reportLog(options + " Options are not displaying in the User Dropdown");
		}
		
		return flag;
	}
	
	//Added comments
	
	
	
}