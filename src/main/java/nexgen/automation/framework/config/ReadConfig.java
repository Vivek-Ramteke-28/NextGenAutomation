package nexgen.automation.framework.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ReadConfig {

	Properties pro;
	final  Logger log = Logger.getLogger(ReadConfig.class);
	public ReadConfig()
	{
		File src = new File(System.getProperty("user.dir")+"/src/main/resources/config/config.properties");
		try (FileInputStream fis = new FileInputStream(src)) 
		{
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			log.error("Exception is " + e.getMessage());
		}
	}
	
	public String mailUserName()
	{
		return pro.getProperty("MailUserName");
	}

	public String mailPassword()
	{
		return pro.getProperty("MailPassword");
	}
	public String emailHost()
	{
		return pro.getProperty("EmailHost");
	}
	
	public String mailPort()
	{
		return pro.getProperty("MailPort");
	}
	
	public String from()
	{
		return pro.getProperty("From");
	}
	
	public String to()
	{
		return pro.getProperty("To");
	}
	
	public String cc()
	{
		return pro.getProperty("CC");
	}
	
	public String bcc()
	{
		return pro.getProperty("BCC");
	}
	public String subject()
	{
		return pro.getProperty("Subject");
	}
	public String companyName()
	{
		return pro.getProperty("CompanyName");
	}
	public String mailSignatureName()
	{
		return pro.getProperty("MailSignatureName");
	}
	public String zapiCloudBaseUrl()
	{
		return pro.getProperty("ZAPI_CLOUD_BASE_URL");
	}
	public String apiGetExecution()
	{
		return pro.getProperty("API_GET_EXECUTIONS");
	}
	public String apiUpdateExecution()
	{
		return pro.getProperty("API_UPDATE_EXECUTION");
	}
	public String zephyrUserName()
	{
		return pro.getProperty("ZephyruserName");
	}
	public String accessKey()
	{
		return pro.getProperty("ACCESS_KEY");
	}
	public String secretKey()
	{
		return pro.getProperty("SECRET_KEY");
	}
	
	public String jira()
	{
		return pro.getProperty("Jira");
	}
	
	public String jiraBaseURL()
	{
		return pro.getProperty("JiraBaseURL");
	}
	public String jiraIssueUrl()
	{
		return  pro.getProperty("jiraIssueUrl");
	}
	
	public String createIssueURL()
	{
		return pro.getProperty("CreateIssueURL");
	}
	
	public String jiraUserName()
	{
		return pro.getProperty("JiraUserName");
	}
	
	public String jiraPassword()
	{
		return pro.getProperty("JiraPassword");
	}
	
	public String jiraLinkIssueURL()
	{
		return pro.getProperty("JiraLinkIssueURL");
	}
	
	public String jiraAtachmentURL()
	{
		return pro.getProperty("JiraAtachmentURL");
	}
	
	public String jiraCreateIssueURL()
	{
		return pro.getProperty("JiraCreateIssueURL");
	}
	public String TokenRequestUrl()
	{
		return pro.getProperty("TOKEN_REQUEST_URL");
	}
	public String xRayTestingUrl()
	{
		return pro.getProperty("XRAY_TESTNG_URL");
	}
	
	public String xRayClientID()
	{
		return pro.getProperty("XRAY_CLIENT_ID");
	}
	public String xRayClientSeret()
	{
		return pro.getProperty("XRAY_CLIENT_SECRET");
	}
	public String xRayGrafQL()
	{
		return pro.getProperty("XRAY_GrafQL");
	}
	
	public String xRayBaseUrl()
	{
		return pro.getProperty("XrayBaseURL");
	}
	
	public String retry()
	{
		return pro.getProperty("Retry");
	}
	
	public String emailSignature()
	{
		return pro.getProperty("EMAIL_SIGNATURE");
	}
	
	public String excelPath()
	{
		return pro.getProperty("ExcelPath");
	}
	
	public String dbDetails()
	{
		return pro.getProperty("dbDetails");
	}
	
	public String config()
	{
		return pro.getProperty("config");
	}
	
	public String loginDetails()
	{
		return pro.getProperty("loginDetails");
	}
	
	public String UserDetails()
	{
		return pro.getProperty("UserDetails");
	}
	
	public String pageLoadTimeout()
	{
		return pro.getProperty("pageLoadTimeout");
	}
	
	public String implicitWait()
	{
		return pro.getProperty("implicitWait");
	}
	
	public String shortWait()
	{
		return pro.getProperty("shortWait");
	}
	
	public String mediumWait()
	{
		return pro.getProperty("mediumWait");
	}
	
	public String longWait()
	{
		return pro.getProperty("longWait");
	}
	
	public String shortW()
	{
		return pro.getProperty("shortW");
	}
	
	public String mediumW()
	{
		return pro.getProperty("mediumW");
	}
	
	public String longW()
	{
		return pro.getProperty("longW");
	}
	public String hpalmBaseURL()
	{
		return pro.getProperty("hpalmBaseURL");
	}
	
	public String hpalmauthentication()
	{
		return pro.getProperty("hpalmauthentication");
	}
	
	public String hpalmauthenticated()
	{
		return pro.getProperty("hpalmauthenticated");
	}
	
	public String hpalmSession()
	{
		return pro.getProperty("hpalmSession");
	}
	
	public String hpalmUserName()
	{
		return pro.getProperty("hpalmUserName");
	}
	
	public String hpalmPassword()
	{
		return  pro.getProperty("hpalmPassword");
	}
	
	public String ruleWait()
    {
    String ruleWait=pro.getProperty("ruleWait");
    return ruleWait;
    }
}


