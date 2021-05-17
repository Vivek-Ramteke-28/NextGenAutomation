package nexgen.automation.framework.connectionRepo.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.connectionRepo.ConnectionHome;
import nexgen.automation.framework.connectionRepo.DisableConnections;
//import nexgen.automation.pageclasses.pages.LoginPage;

public class ValidateDisableConnectionTest extends BaseSuite{

	SoftAssert soft = new SoftAssert();
		
	
	@Test(priority = 1, groups = { "DepthFirst", "VerifyDisableExistingConnection" })
	public void VerifyDisableExistingConnection() {

		try {

			test = extent.createTest("VerifyDisableExistingConnection");
			reportLog("Launching browser");
			//LoginPage loginTest = new LoginPage(driver);			
			reportLog("Entering login details");

			//if (loginTest.login(username, password))
			{
				ConnectionHome connect = new ConnectionHome(driver);
				connect.ConnectionRepo();
				DisableConnections connection = new DisableConnections(driver);
				connection.DisableExistingConnection("Demo0");

				BaseSuite.reportLog("User able to disable the connection successfully");

			} /*
				 * else {
				 * BaseSuite.reportFailLog("Some details  are not displaying in the page",
				 * "VerifyDisableExistingConnection"); }
				 */
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
		soft.assertAll();
	}
	
}
