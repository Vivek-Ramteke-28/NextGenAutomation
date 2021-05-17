package nexgen.automation.framework.administration.testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.reports.ListenerTest;
import nexgen.automation.pageclasses.otherpages.HomePage;
import nexgen.automation.pageclasses.otherpages.LoginPage;

@Listeners(ListenerTest.class)
public class HomePageTest extends BaseSuite {

	SoftAssert soft = new SoftAssert();

	@Test(priority = 1, groups = { "DepthFirst", "HomePage" })
	public void LandingPageServicesTest() {

		try {

			test = extent.createTest("LandingPageServicesTest");
			reportLog("Launching browser");
			LoginPage login1 = new LoginPage(driver);
			reportLog("Entering login details");

			if (login1.login(username, password))

			{
				HomePage hp = new HomePage(driver);

				hp.verifyLandingPage_Services();
				// boolean b= hp.verifyLandingPage_Services();

				// hp.administration();
				// boolean b = hp.verifyLandingPage_Services();

				BaseSuite.reportLog("Landing page services are displayed properly");
			} else {
				BaseSuite.reportFailLog("Some services are not displaying in the page", "LandingPageServicesTest");
			}
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
		soft.assertAll();
	}

	@Test(priority = 2, groups = { "DepthFirst", "HomePage" })
	public void userNameTest() {

		try {

			test = extent.createTest("userNameTest");
			reportLog("Launching browser");
			LoginPage login1 = new LoginPage(driver);
			reportLog("Entering login details");

			if (login1.login(username, password))

			{
				HomePage hp = new HomePage(driver);

				hp.verifyLoginUser(username);

				BaseSuite.reportLog("User name is displayed");
			} else {
				BaseSuite.reportFailLog("User name is not displayed ", "userNameTest");
			}
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}

	}

	@Test(priority = 3, groups = { "DepthFirst", "HomePage" })
	public void userDropdownOptionsTest() {

		try {

			test = extent.createTest("userDropdownOptionsTest");
			reportLog("Launching browser");
			LoginPage login1 = new LoginPage(driver);
			reportLog("Entering login details");

			if (login1.login(username, password))

			{
				HomePage hp = new HomePage(driver);
				// hp.verifyUserOption();
				soft.assertEquals(hp.verifyUserOption(), true);

			} else {
				BaseSuite.reportFailLog("Some options are not displaying in the User Dropdown", "userDropdownOptions");
			}
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
		soft.assertAll();

	}

}
