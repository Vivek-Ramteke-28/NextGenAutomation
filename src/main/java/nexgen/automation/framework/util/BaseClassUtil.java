package nexgen.automation.framework.util;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import io.github.bonigarcia.wdm.WebDriverManager;
import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.config.ReadConfig;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ExecutionResult;
import nexgen.automation.framework.reports.WebEventListener;
import nexgen.automation.pageclasses.otherpages.LoginPage;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;



public class BaseClassUtil   {
	
	String key = "https://icedqngvm1.eastus.cloudapp.azure.com:8443/auth/realms/iam.icedq/protocol/openid-connect/auth?client_id=icedq.admin-ui&redirect_uri=http%3A%2F%2Ficedqngvm1.eastus.cloudapp.azure.com%3A4200%2F&state=36f36a05-728d-4464-9807-2c13726c345d&response_mode=fragment&response_type=code&scope=openid&nonce=1751d908-e11d-4731-b00d-4645f701b52c";

	SoftAssert soft = new SoftAssert();

	/**
	 * getuserName
	 *
	 */
	public String getuserName() {

		return System.getProperty("user.name");

	}

	public String getFileOperator() {
		String fileOperator = null;
		switch (System.getProperty("os.name")) {
		case "Linux":
			fileOperator = "/";
			break;
		case "Windows":
			fileOperator = "\\";
			break;
		default:
			break;
		}
		return fileOperator;

	}

	/**
	 * getOSName
	 *
	 */

	public String getOSName() {

		return System.getProperty("os.name");
		      

	}

	/**
	 * takeScreenshotAtEndOfTest
	 * 
	 * @param MethodName
	 * @throws IOException
	 */

	public String takeScreenshotAtEndOfTest(String methodName, WebDriver driver) throws IOException {
		String timeStampformail = new SimpleDateFormat("HH.mm.ss-MM-dd-yyyy").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		String dest = ts.getScreenshotAs(OutputType.BASE64);
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(Paths.get("").toAbsolutePath().toString() + "/reports/Screenshots/" + methodName + "/"
				+ methodName + timeStampformail + ".png");
		FileUtils.copyFile(source, target);
		return dest;

	}

	/**
	 * takeScreenshot
	 * 
	 * @param MethodName
	 * @throws IOException
	 */

	public String takeScreenshot(String methodName, WebDriver driver) throws IOException {
		String timeStampformail = new SimpleDateFormat("HH.mm.ss-MM-dd-yyyy").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		File target = new File(Paths.get("").toAbsolutePath().toString() + "/reports/Screenshots/" + methodName + "/"
				+ methodName + timeStampformail + ".png");
		FileUtils.copyFile(source, target);
		FileUtils.forceDelete(source);
		return target.toString();

	}

	/**
	 * 
	 * gethost Get the host name on which the test is running
	 * 
	 */

	public String gethost() {
		String hostname = "Unknown";
		try {
			InetAddress addr;
			addr = InetAddress.getLocalHost();
			hostname = addr.getHostName();
		} catch (UnknownHostException ex) {
			soft.fail("Hostname can not be resolved");
		}
		return hostname;
	}

	/**
	 * getcount
	 * 
	 * get count of the splitters
	 * 
	 * @param string
	 * @param type
	 * 
	 */
	public int getcount(String string, char type) {
		int commas = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == type)
				commas++;
		}
		return commas;

	}

	public String writeXmlDocumentToXmlFile(String xmlDocument)
			throws TransformerException, SAXException, IOException, ParserConfigurationException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
		dbf.setFeature("http://xml.org/sax/features/external-general-entities", false);
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(new File(xmlDocument));

		TransformerFactory tf = TransformerFactory.newInstance();
		tf.setFeature(XMLConstants.DEFAULT_NS_PREFIX, true);
//		tf.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
//		tf.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET,"");
		Transformer transformer= tf.newTransformer();

		//transformer = tf.newTransformer();
		StringWriter writer = new StringWriter();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

		// transform document to string
		transformer.transform(new DOMSource(document), new StreamResult(writer));

		return writer.getBuffer().toString();
		//String xmlString = writer.getBuffer().toString();

		//return xmlString;

	}

	public WebDriver launchBrowser(WebDriver driver, String br, String baseURL, String username, String password,
			Logger log, boolean logging, EventFiringWebDriver e_driver, WebEventListener eventListener)
			throws InterruptedException {

		 
		
		switch (br.toLowerCase()) {

		case "headlesschrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			options.addArguments("headless");
			options.addArguments("window-size=1366x786");
			options.addArguments("--no-sandbox");
			options.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(options);
			break;

		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions optionsHL = new ChromeOptions();
			optionsHL.addArguments("--disable-extensions");
			driver = new ChromeDriver(optionsHL);
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		default:
			log.info("Browser not defined.");
			break;
		}
		if (logging) {
			e_driver = new EventFiringWebDriver(driver);
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(baseURL);
		driver.get(key);
		driver.manage().timeouts().pageLoadTimeout(Constant.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		LoginPage login = new LoginPage(driver);
		login.login(username, password);
		return driver;

	}


	public void createReport(ReadConfig readconfig, BaseClassUtil util) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		String reportname = ExecutionResult.suitename + "-Suite-" + timeStamp + ".html";
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/reports/" + ExecutionResult.suitename + "-reports" + "/" + reportname);
		htmlReporter.config().setDocumentTitle(readconfig.subject());
		htmlReporter.config().setReportName(ExecutionResult.suitename);
		htmlReporter.config().setTheme(Theme.DARK);
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", util.gethost());
		extent.setSystemInfo("OS", util.getOSName());
		extent.setSystemInfo("PC User", util.getuserName());

	}
	

}
