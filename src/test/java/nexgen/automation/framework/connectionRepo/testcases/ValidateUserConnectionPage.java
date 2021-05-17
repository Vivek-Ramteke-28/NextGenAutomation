package nexgen.automation.framework.connectionRepo.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.connectionRepo.ConnectionHome;
import nexgen.automation.framework.connectionRepo.UserConnectionsHome;
//import nexgen.automation.pageclasses.pages.LoginPage;

public class ValidateUserConnectionPage extends BaseSuite
{
	SoftAssert soft = new SoftAssert();
	
	@Test(priority = 1, groups = { "DepthFirst", "VerifyUConnectionPageButtons" })
	public void VerifyUConnectionPageButtons()
	{
	test = extent.createTest("VerifyUConnectionPageButtons");
	reportLog("Launching browser");
	//LoginPage loginTest = new LoginPage(driver);			
	reportLog("Entering login details");

	//if (loginTest.login(username, password))
		soft.fail("Failed to login into application. Aborting test execution");
	
	ConnectionHome connect = new ConnectionHome(driver);
	connect.ConnectionRepo();
	UserConnectionsHome user = new UserConnectionsHome(driver);
	user.ValidateUButtons();
	}
	
	@Test(priority = 1, groups = { "DepthFirst", "VerifysearchUConnection" })
	public void VerifysearchUConnection() {

		try {

			test = extent.createTest("VerifysearchUConnection");
			reportLog("Launching browser");
			//LoginPage loginTest = new LoginPage(driver);			
			reportLog("Entering login details");

			//if (loginTest.login(username, password))
			{
				ConnectionHome connect = new ConnectionHome(driver);
				connect.ConnectionRepo();
				UserConnectionsHome user = new UserConnectionsHome(driver);
				user.SearchUConnection("demo");

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
	
	@Test(priority = 1, groups = { "DepthFirst", "VerifyNumberofURowsAndColumns" })
	public void VerifyNumberofURowsAndColumns() {

		try {

			test = extent.createTest("VerifyNumberofURowsAndColumns");
			reportLog("Launching browser");
			//LoginPage loginTest = new LoginPage(driver);			
			reportLog("Entering login details");

			//if (loginTest.login(username, password))
			{
				ConnectionHome connect = new ConnectionHome(driver);
				connect.ConnectionRepo();
				UserConnectionsHome user = new UserConnectionsHome(driver);
				user.UConnectionRowsAndColumns();

				BaseSuite.reportLog("Numbers of connections are displaying");

			} /*else {
				BaseSuite.reportFailLog("Some details  are not displaying in the page", "VerifyNumberofURowsAndColumns");
			}*/
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
		soft.assertAll();
	}
	
	@Test(priority = 1, groups = { "DepthFirst", "VerifyUConnectionHomeLink"})
	public void VerifyUConnectionHomeLink()
	{
		try {

			test = extent.createTest("VerifyUConnectionHomeLink");
			reportLog("Launching browser");
			//LoginPage loginTest = new LoginPage(driver);			
			reportLog("Entering login details");

			//if (loginTest.login(username, password))
			{
				ConnectionHome connect = new ConnectionHome(driver);
				connect.ConnectionRepo();
				UserConnectionsHome user = new UserConnectionsHome(driver);
				user.UConnectionHomeLink();

				BaseSuite.reportLog("Home link working properyly");

			} /*
				 * else { BaseSuite.
				 * reportFailLog("Home link not clickable and not redirecting on the home page",
				 * "VerifyUConnectionHomeLink"); }
				 */
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
		soft.assertAll();
	}
	
}
