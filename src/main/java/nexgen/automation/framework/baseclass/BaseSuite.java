package nexgen.automation.framework.baseclass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import nexgen.automation.framework.util.XLUtils;
import nexgen.automation.framework.config.ReadConfig;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ExecutionResult;
import nexgen.automation.framework.jira.JiraIntegration;
import nexgen.automation.framework.reports.WebEventListener;
import nexgen.automation.framework.sendmail.SendMailSSLWithAttachment;
import nexgen.automation.framework.util.BaseClassUtil;
import nexgen.automation.framework.util.PageUtil;
import nexgen.automation.framework.xray.UpdateTestExecutionsUsingIDs;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class BaseSuite {

	public final static Logger log = Logger.getLogger(BaseSuite.class);

	public static WebDriver driver;
	public static String reportname;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	protected static ReadConfig readconfig = new ReadConfig();
	public static String baseURL = "";
	public static String username = "";
	public static String password = "";
	public static String repo = "";
	public static String os = "";
	public static String dbName = "";
	public static String browserName = "";

	public static String xl = System.getProperty("user.dir") + Constant.DBDETAILS;
	public static String timesp;
	public static String endTime;
	public static String dbHost;
	public static String dbUserName;
	public static String dbPassword;
	public static String dbDriver;
	public ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;

	public static ExtentTest test;
	public static String cycleId;
	public static String versionId;
	public static String version;
	public static String fixVersionID;
	public static String projectId;
	public static String projectKey;
	public static String executionKey;
	public static String planKey;
	public static String assignee;
	public static boolean createIssue;
	public static boolean sendMail;
	public static String seqNumber;
	public static boolean updateXrayStatus;
	public static boolean logging;
	public static boolean beforeSuite;
	 public static String ReportDocument =null;

	BaseClassUtil util = new BaseClassUtil();
	XLUtils xlUtils = new XLUtils();

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) throws IOException {

		String staticMsg = "TEST CASE FAILED IS ";
		for (String group : result.getMethod().getGroups()) {
			test.assignCategory(group);

		}

		if (result.getStatus() == ITestResult.FAILURE) {

			test.log(Status.FAIL, staticMsg + result.getName()); // to add name in extent report
			String screenshotPath = util.takeScreenshotAtEndOfTest(result.getMethod().getMethodName(), driver);
			test.log(Status.FAIL, staticMsg + result.getThrowable()).addScreenCaptureFromBase64String(screenshotPath); // to
																														// add
																														// error/exception
																														// in

		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getMethod().getMethodName());
			String screenshotPath = util.takeScreenshotAtEndOfTest(result.getMethod().getMethodName(), driver);
			test.log(Status.SKIP, staticMsg + result.getThrowable()).addScreenCaptureFromBase64String(screenshotPath); // to
																														// add
																														// error/exception
																														// in

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case PASSED IS " + result.getMethod().getMethodName());
		}
	}

	@Parameters({"db", "version" })
	@BeforeTest(alwaysRun = true)
	public void beforeTest(String dbname, String versioncode, ITestContext result)
			throws IOException {

		version = versioncode;
		dbName = dbname;
		
		
		String sheetName = "";

		if (dbName.equalsIgnoreCase("Oracle")) {

			sheetName = "Oracle";

		} else if (dbName.equalsIgnoreCase("SQL")) {

			sheetName = "SQL";

		} else if (dbName.equalsIgnoreCase("Postgres")) {

			sheetName = "Postgres";

		}

		dbHost = xlUtils.getCellData(xl, sheetName, 1, 1);

		dbUserName = xlUtils.getCellData(xl, sheetName, 1, 2);

		dbPassword = xlUtils.getCellData(xl, sheetName, 1, 3);

		dbDriver = xlUtils.getCellData(xl, sheetName, 1, 4);
		
		
	}

	@Parameters({ "cycleId", "versionId", "version", "projectId", "projectKey", "executionKey", "planKey",
			"fixVersionId", "assignee", "createIssue","seqNumber", "updateXrayStatus" })
	@AfterTest(alwaysRun = true)
	public void afterTest(String cycleid, String versionid, String versioncode, String projectid, String projectkey,
			String executionkey, String plankey, String fixversionid, String assignto, boolean createissue,
			String seqnum, boolean updatexraytest, ITestContext Result) throws IOException {

		extent.setSystemInfo("instance URL", baseURL);
		extent.setSystemInfo("User", username);
		endTime = new SimpleDateFormat("HH.mm.ss-MM/dd/yyyy").format(new Date());
		extent.flush();

		ExecutionResult.totalcount = ExecutionResult.test - ExecutionResult.retryFlagCount;
		cycleId = cycleid;
		versionId = versionid;
		version = versioncode;
		fixVersionID = fixversionid;
		projectId = projectid;
		projectKey = projectkey;
		executionKey = executionkey;
		planKey = plankey;
		assignee = assignto;
		createIssue = createissue;
		//sendMail = sendmail;
		seqNumber = seqnum;
		updateXrayStatus = updatexraytest;

		/*
		 * if (sendMail) { SendMailSSLWithAttachment mailReport = new
		 * SendMailSSLWithAttachment(); mailReport.sendmail(); }
		 */
	}

	@Parameters({ "sendMail" })
	@AfterSuite
	public void afterSuite(boolean sendmail) throws Exception {
		
		sendMail = sendmail;
		
		if(beforeSuite)
		{
			driver.quit();
		}
		
		if (sendMail) {
			SendMailSSLWithAttachment mailReport = new SendMailSSLWithAttachment();
			mailReport.sendmail();
		}

		if (updateXrayStatus) {

			UpdateTestExecutionsUsingIDs obj = new UpdateTestExecutionsUsingIDs();

			obj.updateTestExecutions();

		}

		JiraIntegration.create();
	}

	
	@Parameters({"beforeSuiteLogin","browser", "applicationURL", "userName", "password", "os", "logging"})
	@BeforeSuite
	public void beforeSuite(ITestContext Result,boolean beforeSuiteLogin,String browser, String applicationURL, String userName, String passWord, String osName,
			ITestContext resultContext, ITestResult result, boolean logg) throws InterruptedException {

		PageUtil.beforesuite();
		
		ExecutionResult.suitename = Result.getCurrentXmlTest().getSuite().getName();
		
		String timeStampformail = new SimpleDateFormat("HH.mm.ss-MM/dd/yyyy").format(new Date());

		timesp = timeStampformail;

		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		String timeStampformail1 = new SimpleDateFormat("HH.mm.ss-MM/dd/yyyy").format(new Date());
		timesp = timeStampformail1;
		String repName = ExecutionResult.suitename + "-Suite-" + timeStamp + ".html";
		reportname = repName;
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/reports/" + ExecutionResult.suitename + "-reports" + "/" + repName);
		htmlReporter.config().setDocumentTitle(readconfig.subject());
		htmlReporter.config().setReportName(ExecutionResult.suitename);
		htmlReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", util.gethost());
		extent.setSystemInfo("OS", util.getOSName());
		extent.setSystemInfo("PC User", util.getuserName());
		
		beforeSuite = beforeSuiteLogin;
		browserName = browser;
		baseURL = applicationURL;
		username = userName;
		password = passWord;
		os = osName;
		logging = logg;
		
		if(beforeSuite)
		{
			driver = util.launchBrowser(driver, browserName, baseURL, username, password,log, logging,e_driver, eventListener);
		}
	
	}
	
	@Parameters({ "browser" })
	@BeforeSuite
	public void beforeSuitegetBrowser(String browser) {
		browserName = browser;
	}
	
	
	@BeforeClass
	public void beforeClass() throws InterruptedException {

		if(!beforeSuite)
		{
		driver = util.launchBrowser(driver, browserName, baseURL, username, password,log, logging, e_driver,
				eventListener);
		}
	}
	
	
	/*
	 * @Parameters({ "browser" })
	 * 
	 * @BeforeSuite public void beforeClassgetBrowser(String browser) {
	 * //browserName = browser; }
	 */
	
	
	@AfterClass
	public void quit()
	{
		if(!beforeSuite)
		{
			driver.quit();
		}
	}

	
	public static void reportLog(String message) {

		test.log(Status.INFO, MarkupHelper.createLabel(message, ExtentColor.TRANSPARENT));

		Reporter.log(message);

	}

	public static void validationReportLog(String message) {

		test.log(Status.INFO, MarkupHelper.createLabel(message, ExtentColor.GREEN));
		Reporter.log(message);

	}

	public static void reportFailLog(String message, String methodname) {

		test.log(Status.FAIL, MarkupHelper.createLabel(message, ExtentColor.RED));
		try {
			String screenshotPath = takeScreenshotForValidationFailure(methodname, driver);

			// test.log(Status.FAIL, "TEST CASE FAILED IS " +methodname +" ::::"+
			// test.addScreenCaptureFromBase64String(screenshotPath));
			test.log(Status.FAIL, message + "::::::::" + methodname,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());

		} catch (IOException e) {
			Reporter.log("Error observed while captruing screesnhot in reportFailLog method" + e.getMessage());
		}
		Reporter.log(message);
	}

	public static String takeScreenshotForValidationFailure(String methodName, WebDriver driver) throws IOException {
		String timeStampformail = new SimpleDateFormat("HH.mm.ss-MM-dd-yyyy").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		String dest = ts.getScreenshotAs(OutputType.BASE64);
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(Paths.get("").toAbsolutePath().toString() + "/reports/Screenshots/" + methodName + "/"
				+ methodName + timeStampformail + ".png");
		FileUtils.copyFile(source, target);
		return dest;

	}

	public static void reportErrorLog(String message) {

		test.log(Status.ERROR, MarkupHelper.createLabel(message, ExtentColor.TRANSPARENT));
		Reporter.log(message);
	}

	public static void reportPassLog(String string) {
		// TODO Auto-generated method stub
		
	}

}
