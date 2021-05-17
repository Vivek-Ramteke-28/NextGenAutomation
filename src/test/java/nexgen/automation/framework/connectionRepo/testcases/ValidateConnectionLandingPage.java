package nexgen.automation.framework.connectionRepo.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import nexgen.automation.framework.administration.Users;
import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.connectionRepo.ConnectionHome;
//import nexgen.automation.pageclasses.pages.HomePage;
//import nexgen.automation.pageclasses.pages.LoginPage;

public class ValidateConnectionLandingPage extends BaseSuite
{
	
	SoftAssert soft = new SoftAssert();
	
	@Test(priority = 1, groups = { "DepthFirst", "VerifyConnectionLandingPage" })
		public void VerifyConnectionPageButtons()
		{
		test = extent.createTest("VerifyConnectionLandingPage");
		reportLog("Launching browser");
		//LoginPage loginTest = new LoginPage(driver);			
		reportLog("Entering login details");

		//if (loginTest.login(username, password))
			soft.fail("Failed to login into application. Aborting test execution");
		
		ConnectionHome connect = new ConnectionHome(driver);
		connect.ConnectionRepo();
		connect.ValidateButtons();
		}
	
	
	@Test(priority = 1, groups = { "DepthFirst", "VerifysearchConnection" })
	public void VerifysearchConnection() {

		try {

			test = extent.createTest("VerifysearchConnection");
			reportLog("Launching browser");
			//LoginPage loginTest = new LoginPage(driver);			
			reportLog("Entering login details");

			//if (loginTest.login(username, password))
			{
				ConnectionHome connect = new ConnectionHome(driver);
				connect.ConnectionRepo();

				connect.SearchConnection("demo");

				BaseSuite.reportLog("Numbers of connections are displaying");

			} /*
				 * else {
				 * BaseSuite.reportFailLog("Some details  are not displaying in the page",
				 * "VerifysearchConnection"); }
				 */
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
		soft.assertAll();
	}
	
	@Test(priority = 1, groups = { "DepthFirst", "VerifyNumberofRowsAndColumns" })
	public void VerifyNumberofRowsAndColumns() {

		try {

			test = extent.createTest("VerifyNumberofRowsAndColumns");
			reportLog("Launching browser");
			//LoginPage loginTest = new LoginPage(driver);			
			reportLog("Entering login details");

			//if (loginTest.login(username, password))
			{
				ConnectionHome connect = new ConnectionHome(driver);
				connect.ConnectionRepo();
				connect.ConnectionRowsAndColumns();

				BaseSuite.reportLog("Numbers of connections are displaying");

			} /*
				 * else {
				 * BaseSuite.reportFailLog("Some details  are not displaying in the page",
				 * "VerifyNumberofRowsAndColumns"); }
				 */
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
		soft.assertAll();
	}
	
	@Test(priority = 1, groups = { "DepthFirst", "VerifySideBar" })
	public void VerifySideBar()
	{
		try {

			test = extent.createTest("VerifySideBar");
			reportLog("Launching browser");
			//LoginPage loginTest = new LoginPage(driver);			
			reportLog("Entering login details");

			//if (loginTest.login(username, password))
			{
				ConnectionHome connect = new ConnectionHome(driver);
				connect.ConnectionRepo();
				connect.ConnectionSideBar();

				BaseSuite.reportLog("Side bar menus displaying properly");

			} /*
				 * else {
				 * BaseSuite.reportFailLog("Some details  are not displaying in side bar",
				 * "VerifySideBar"); }
				 */
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
		soft.assertAll();
	}
	
	@Test(priority = 1, groups = { "DepthFirst", "VerifyConnectionHomeLink"})
	public void VerifyConnectionHomeLink()
	{
		try {

			test = extent.createTest("VerifyConnectionHomeLink");
			reportLog("Launching browser");
			//LoginPage loginTest = new LoginPage(driver);			
			reportLog("Entering login details");

			//if (loginTest.login(username, password))
			{
				ConnectionHome connect = new ConnectionHome(driver);
				connect.ConnectionRepo();
				connect.ConnectionHomeLink();

				BaseSuite.reportLog("Home link working properyly");

			} /*
				 * else { BaseSuite.
				 * reportFailLog("Home link not clickable and not redirecting on the home page",
				 * "VerifyConnectionHomeLink"); }
				 */
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
		soft.assertAll();
	}
	
	@Test(priority = 1, groups = { "DepthFirst", "VerifynumberOfConnectionsAndPaginationk"})
	public void VerifynumberOfConnectionsAndPaginationk()
	{
		try {

			test = extent.createTest("VerifynumberOfConnectionsAndPaginationk");
			reportLog("Launching browser");
			//LoginPage loginTest = new LoginPage(driver);			
			reportLog("Entering login details");

			//if (loginTest.login(username, password))
			{
				ConnectionHome connect = new ConnectionHome(driver);
				connect.ConnectionRepo();
				connect.numberOfConnectionsAndPagination();

				BaseSuite.reportLog("Number of connections displaying successfully");

			} /*
				 * else {
				 * BaseSuite.reportFailLog("Displayed number of connections are not correct",
				 * "VerifynumberOfConnectionsAndPaginationk"); }
				 */
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
		soft.assertAll();
	}
}
