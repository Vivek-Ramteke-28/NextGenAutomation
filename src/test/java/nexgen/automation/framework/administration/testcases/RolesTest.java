package nexgen.automation.framework.administration.testcases;

import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.administration.Roles;
import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.config.ReadConfig;
import nexgen.automation.framework.constant.ExecutionResult;
import nexgen.automation.framework.reports.ListenerTest;
import nexgen.automation.framework.util.XLUtils;


@Listeners(ListenerTest.class)
public class RolesTest extends BaseSuite  {
	
	String roles = System.getProperty("user.dir") + "/src/main/resources/testdata/Roles/roles.xlsx";

	XLUtils xl = new XLUtils();
	
	ReadConfig mailconfig = new ReadConfig();

	@Test(groups = { "Roles Section" })
	public void verifyPermissionSearchedShouldSearchedFromTheListOPpermissions()
	{
		
		try {
		test = extent.createTest("verifyPermissionSearchedShouldSearchedFromTheListOPpermissions_NG21-600");
		ExecutionResult.issueKey = "NG21-600";
		test.log(Status.INFO, "X-ray Test Case URL");
		test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-600");
		int rowNumber = 0;
		int rowCount = xl.getRowCount(roles, "Sheet1");
		SoftAssert soft = new SoftAssert();
		Roles role =new Roles(driver);
		PageUtil pageUtil = new PageUtil();
		
		for (int rowNum = 0; rowNum < rowCount; rowNum++) {

			rowNumber = rowNum + 1;
			
			BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");
			
			List<String> inputs = pageUtil.getColumnNamesUsingSheet(roles, "Sheet1");

			List<String> output = xl.getDetails(inputs, rowNumber, "Sheet1", xl, roles);

			role.permissionSearchedShouldSearchedFromTheListOPpermissions(output.get(0), output.get(0), output.get(1), output.get(2));;
			
		}
		
		soft.assertAll();
		}
		catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Roles Section" })
	public void verifyPermissionsShouldDisplayedOnTheSpecificRole()
	{
		
		try {
		test = extent.createTest("verifyPermissionsShouldDisplayedOnTheSpecificRole_NG21-598");
		ExecutionResult.issueKey = "NG21-598";
		test.log(Status.INFO, "X-ray Test Case URL");
		test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-598");
		int rowNumber = 0;
		int rowCount = xl.getRowCount(roles, "Sheet2");
		SoftAssert soft = new SoftAssert();
		Roles role =new Roles(driver);
		PageUtil pageUtil = new PageUtil();
		
		for (int rowNum = 0; rowNum < rowCount; rowNum++) {

			rowNumber = rowNum + 1;
			
			BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");
			
			List<String> inputs = pageUtil.getColumnNamesUsingSheet(roles, "Sheet2");

			List<String> output = xl.getDetails(inputs, rowNumber, "Sheet2", xl, roles);

			role.permissionSearchedShouldSearchedFromTheListOPpermissions(output.get(0), output.get(0), output.get(1), output.get(2));;
			
		}
		
		soft.assertAll();
		}
		catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Roles Section" })
	public void verifyDetailsRoleShouldDisplayedOnClickSpecificRole() {

		try {
			test = extent.createTest("verifyDetailsRoleShouldDisplayedOnClickSpecificRole_NG21-597");
			ExecutionResult.issueKey = "NG21-597";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-597");
			int rowNumber = 0;
			int rowCount = xl.getRowCount(roles, "Sheet1");
			SoftAssert soft = new SoftAssert();
			Roles role = new Roles(driver);
			PageUtil pageUtil = new PageUtil();

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {

				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

				List<String> inputs = pageUtil.getColumnNamesUsingSheet(roles, "Sheet1");

				List<String> output = xl.getDetails(inputs, rowNumber, "Sheet1", xl, roles);

				role.detailsRoleShouldDisplayedOnClickSpecificRole(output.get(0), output.get(0), output.get(1));

			}

			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Roles Section" })
	public void verifyRolesShouldSearchedFromListOfRoles() {

		try {
			test = extent.createTest("verifyRolesShouldSearchedFromListOfRoles_NG21-595");
			ExecutionResult.issueKey = "NG21-595";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-595");
			int rowNumber = 0;
			int rowCount = xl.getRowCount(roles, "Sheet3");
			SoftAssert soft = new SoftAssert();
			Roles role = new Roles(driver);
			PageUtil pageUtil = new PageUtil();
			role.clickOnRolesMenu();

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {

				rowNumber = rowNum + 1;

				BaseSuite.reportLog(":::::::::::::::: Starting Execution With " + rowNumber + " Iteration");

				List<String> inputs = pageUtil.getColumnNamesUsingSheet(roles, "Sheet3");

				List<String> output = xl.getDetails(inputs, rowNumber, "Sheet3", xl, roles);

				role.rolesShouldSearchedFromListOfRoles(output.get(0), output.get(1));

			}
			
			role.navigateToRoles();
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Roles Section" })
	public void verifyListOfRolesShouldDisplayedOnClickRoleSideBar() {

		try {
			test = extent.createTest("verifyListOfRolesShouldDisplayedOnClickRoleSideBar_NG21-591");
			ExecutionResult.issueKey = "NG21-591";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-591");
			SoftAssert soft = new SoftAssert();
			Roles role = new Roles(driver);
			role.listOfRolesShouldDisplayedOnClickRoleSideBar();
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	@Test(groups = { "Roles Section" })
	public void verifyDeleteRoleButtonShouldDisabledOnSelectAndDeselectTheRole() {

		try {
			test = extent.createTest("verifyDeleteRoleButtonShouldDisabledOnSelectAndDeselectTheRole_NG21-594");
			ExecutionResult.issueKey = "NG21-594";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-594");
			SoftAssert soft = new SoftAssert();
			Roles role = new Roles(driver);
			role.deleteRoleButtonShouldDisabledOnSelectAndDeselectTheRole();
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
	@Test(groups = { "Roles Section" })
	public void verifyRolesRefereshFunctionality() {

		try {
			test = extent.createTest("verifyRolesRefereshFunctionality_NG21-881");
			ExecutionResult.issueKey = "NG21-881";
			test.log(Status.INFO, "X-ray Test Case URL");
			test.log(Status.INFO, mailconfig.xRayBaseUrl() + "NG21-881");
			SoftAssert soft = new SoftAssert();
			Roles role = new Roles(driver);
			role.rolesRefereshFunctionality();
			soft.assertAll();
		} catch (Exception e) {
			reportLog("Error observed while running the test case" + e.getMessage());
		}
	}
	
	
}
