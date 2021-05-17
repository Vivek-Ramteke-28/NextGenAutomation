
package nexgen.automation.framework.jira;

import java.io.File; 
import java.io.IOException; 
import org.apache.http.HttpEntity; 
import org.apache.http.HttpResponse; 
import org.apache.http.client.HttpClient; 
import org.apache.http.client.methods.HttpGet; 
import org.apache.http.client.methods.HttpPost; 
import org.apache.http.entity.StringEntity; 
import org.apache.http.entity.mime.MultipartEntityBuilder; 
import org.apache.http.entity.mime.content.FileBody; 
import org.apache.http.impl.client.HttpClientBuilder; 
import org.apache.http.util.EntityUtils; 
import org.json.JSONArray; 
import org.json.JSONObject; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

import com.sun.jersey.core.util.Base64;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.config.ReadConfig;
import nexgen.automation.framework.constant.ExecutionResult;
import nexgen.automation.framework.util.BaseClassUtil;
import nexgen.automation.framework.util.XLUtils;

public class JiraIntegration { 

	private static final Logger log = LoggerFactory.getLogger(JiraIntegration.class); 

	static ReadConfig readconfig = new ReadConfig();

	private static String jiraBaseUrl = readconfig.jiraBaseURL();

	private static String jiraCreateIssueURL = readconfig.jiraCreateIssueURL();

	private static String jiraAtachmentURL = readconfig.jiraAtachmentURL();

	private static String jiraLinkIssueURL = readconfig.jiraLinkIssueURL();

	private static String jiraUserName = readconfig.jiraUserName();

	private static String jiraPassword = readconfig.jiraPassword();

	public static void create() {

		try { if(BaseSuite.createIssue==true) {


			String zephyrReportDoc =System.getProperty("user.dir")+ExecutionResult.reportDocPath; 
			XLUtils xlReader = new XLUtils(); 
			int rowCount = xlReader.getRowCount(zephyrReportDoc, "Sheet1");

					for(int rowNum =0; rowNum<rowCount; rowNum++ ) {

						int rowNumber = rowNum +1;

						String resultStatus = xlReader.getCellData(zephyrReportDoc, "Sheet1",rowNumber, 2);

						if(resultStatus.equals("2")) {

							String failedTestCase = xlReader.getCellData(zephyrReportDoc, "Sheet1", rowNumber, 1);

							String summary = xlReader.getCellData(zephyrReportDoc, "Sheet1", rowNumber,3);

							String screenShotPath = xlReader.getCellData(zephyrReportDoc, "Sheet1",rowNumber, 4);

							String components = xlReader.getCellData(zephyrReportDoc, "Sheet1",rowNumber, 5);

							String lables = xlReader.getCellData(zephyrReportDoc, "Sheet1", rowNumber,6);

							String description = xlReader.getCellData(zephyrReportDoc, "Sheet1",rowNumber, 7);

							String environment = xlReader.getCellData(zephyrReportDoc, "Sheet1",rowNumber, 8);

							String[] numberOfBugs = isIssueExistsOnJira();

							String totalCount = numberOfBugs[0];

							String issueNumber = numberOfBugs[1];

							int result = Integer.parseInt(totalCount);

							if(result==0) {

								createIssue(jiraBaseUrl,jiraCreateIssueURL, jiraAtachmentURL,
										jiraLinkIssueURL, jiraUserName, jiraPassword,summary,
										failedTestCase,screenShotPath,components,lables,description,environment);
							}else {

								addComment(issueNumber, environment);

							} } } } } catch (IOException e) {

								log.error(e.getMessage()); } }

	public static void createIssue(String jiraBaseUrl,String jiraCreateIssueURL, String jiraAtachmentURL, String jiraLinkIssueURL, String jiraUserName, String jiraPassword , String summary
			,String failedTestCase, String screenShotPath, String components, String  lables,String description, String environment) {

		try { HttpClient httpClient = HttpClientBuilder.create().build();

		HttpPost postRequest = new HttpPost(jiraBaseUrl+jiraCreateIssueURL);

		String auth = new String(Base64.encode(jiraUserName + ":" + jiraPassword));

		postRequest.setHeader("Authorization", "Basic " + auth);

		postRequest.setHeader("Content-Type","application/json");

		postRequest.setHeader("Accept","application/json");

		StringEntity data;

		String[] components2 = components.split(","); 
		BaseClassUtil util = new BaseClassUtil(); 
		int count2 = util.getcount(components, ',');

		String comp1="";

		for(int colNum =0; colNum <= count2; colNum++) {

			String components3 = "{\r\n" +"        \"name\": \""+components2[colNum]+"\"\r\n" + "      },";

			comp1=comp1+components3;

		}

		comp1=comp1.substring(0, comp1.length()-1);

		String fixVersion = "";

		if((BaseSuite.fixVersionID).isEmpty()) 
		{ 
			
		}
		else { 
			String fixVersion1 ="{\"id\": \""+BaseSuite.fixVersionID+"\"}";
		    fixVersion = fixVersion1; 
		} 
		String version = "";

		if(BaseSuite.versionId.isEmpty()) 
		{

		}else {

			String version1 = "{\"id\": \""+BaseSuite.versionId+"\"}"; 
			version =version1;

		}

		data = new StringEntity("{\"fields\": {\r\n" +
				"    \"summary\": \""+summary+"\",\r\n" + " \"issuetype\": {\r\n" +
				"            \"name\": \"Bug\",\r\n" + "            \"id\": \"1\"\r\n" +
				"        },\r\n" + "\"components\": [" + comp1+ " ] ,  \"project\": {\r\n" +
				"      \"id\": \""+BaseSuite.projectId+"\"\r\n" + "    },\r\n" +
				"    \"description\": {\r\n" + "      \"type\": \"doc\",\r\n" +
				"      \"version\": 1,\r\n" + "      \"content\": [\r\n" + "        {\r\n" +
				"          \"type\": \"paragraph\",\r\n" + "          \"content\": [\r\n" +
				"            {\r\n" + "              \"text\": \""+description+"\",\r\n" +
				"              \"type\": \"text\"\r\n" + "            }\r\n" +
				"          ]\r\n" + "        }\r\n" + "      ]\r\n" + "    },\r\n" + "  \r\n"
				+ "   \r\n" + "    \r\n" + "    \r\n" + "    \"labels\": [\r\n" +lables+
				"    ],\r\n" + "\r\n" + "    \"environment\": {\r\n" +
				"      \"type\": \"doc\",\r\n" + "      \"version\": 1,\r\n" +
				"      \"content\": [\r\n" + "        {\r\n" +
				"          \"type\": \"paragraph\",\r\n" + "          \"content\": [\r\n" +
				"            {\r\n" + "              \"text\": \""+environment+"\",\r\n" +
				"              \"type\": \"text\"\r\n" + "            }\r\n" +
				"          ]\r\n" + "        }\r\n" + "      ]\r\n" + "    },\r\n" +
				"    \"versions\": [\r\n" + version+ "    ],\r\n" +
				"     \"fixVersions\": [\r\n" + fixVersion+ "      ],\r\n" + "\r\n" +
				"    \"assignee\": {\r\n" + "      \"name\": \"pdt\"\r\n" + "    }\r\n" +
				"  }\r\n" + "}");

		postRequest.setEntity(data);

		HttpResponse response;

		response = httpClient.execute(postRequest);

		int statusCode = response.getStatusLine().getStatusCode();

		if (statusCode >= 200 && statusCode < 300) {

			HttpEntity entity1 = response.getEntity();

			String string1 = null;


			string1 = EntityUtils.toString(entity1);

			// Getting the JSON Object from the Response Body 
			JSONObject allIssues = new JSONObject(string1);

			addJiraAttachments(screenShotPath,
					jiraBaseUrl,jiraCreateIssueURL,jiraAtachmentURL,
					allIssues.get("key").toString(), jiraUserName, jiraPassword);

			addJiraIssueLink(jiraBaseUrl,jiraLinkIssueURL,
					allIssues.get("key").toString(), failedTestCase,jiraUserName, jiraPassword);

		}


		} catch (IOException e) {

			log.error(e.getMessage()); }

	}

	public static String[] isIssueExistsOnJira() { String[] twoTags = new
			String[2]; try { HttpClient httpClient = HttpClientBuilder.create().build();

			HttpGet getRequest = new HttpGet(jiraBaseUrl+
					"rest/api/3/search?jql=project%20%3D%20IC2%20AND%20issuetype%20%3D%20Bug%20AND%20status%20in%20(%22In%20Progress%22%2C%20%22In%20Review%22%2C%20Open%2C%20Reopened%2C%20Resolved)%20AND%20summary%20~%20%22Execute_Folder_Group_Check_Mandatory_Fields_IC2_108%20Failed%22%20and%20assignee%20%3D%20pdt"
					);

			String auth = new String(Base64.encode(jiraUserName + ":" + jiraPassword));

			getRequest.setHeader("Authorization", "Basic " + auth);

			getRequest.setHeader("Content-Type","application/json");

			getRequest.setHeader("Accept","application/json");

			HttpResponse response;

			response = httpClient.execute(getRequest);

			HttpEntity entity1 = response.getEntity();

			String string1 = null;

			string1 = EntityUtils.toString(entity1);

			JSONObject allIssues = new JSONObject(string1);

			JSONArray issueskeys = allIssues.getJSONArray("issues");

			String issuekey2 = null;

			for (int i = 0; i < issueskeys.length(); ++i) {

				JSONObject rec = issueskeys.getJSONObject(i);

				issuekey2 = rec.getString("key");

			}

			twoTags[0] =allIssues.get("total").toString() ;

			twoTags[1] = issuekey2;

			} catch (IOException |org.apache.http.ParseException e) {

				log.error(e.getMessage()); 
				} 
			return twoTags;

	}

	public static void addComment(String issueNumber, String environment) {

		try { HttpClient httpClient = HttpClientBuilder.create().build();

		HttpPost postRequest = new
				HttpPost(jiraBaseUrl+"rest/api/3/issue/"+issueNumber+"/comment");

		String auth = new String(Base64.encode(jiraUserName + ":" + jiraPassword));

		postRequest.setHeader("Authorization", "Basic " + auth);//was commented need to check this method again

		postRequest.setHeader("Content-Type","application/json");

		postRequest.setHeader("Accept","application/json");

		String comment = "Failed on environment: "+environment;

		StringEntity data = new
				StringEntity("{\"body\": { \"type\": \"doc\",\"version\": 1, \"content\": [ {\"type\": \"paragraph\",\"content\": [ {\"text\": \""
						+comment+"\",\"type\": \"text\"}]}]}}");

		postRequest.setEntity(data);
		httpClient.execute(postRequest);

		} catch (IOException e) {

			log.error(e.getMessage()); }

	}

	public static void addJiraIssueLink(String jiraBaseURL,String
			jiraLinkIssueURL, String issueKey, String failedTestCase, String
			jiraUserName, String jiraPassword) {

		try {

			HttpClient httpClient = HttpClientBuilder.create().build();

			HttpPost postRequest = new HttpPost(jiraBaseURL+jiraLinkIssueURL);

			String auth = new String(Base64.encode(jiraUserName + ":" + jiraPassword));

			postRequest.setHeader("Authorization", "Basic " + auth);

			postRequest.setHeader("Content-Type","application/json");

			postRequest.setHeader("Accept","application/json");

			StringEntity data;

			data = new
					StringEntity(" { \"type\": { \"name\": \"Relates\" }, \"inwardIssue\": { \"key\": \""
							+issueKey+"\" }, \"outwardIssue\": { \"key\": \""+failedTestCase+"\" } }");

			postRequest.setEntity(data); httpClient.execute(postRequest); 

		} catch (IOException e) {

			log.error(e.getMessage()); } }

	public static void addJiraAttachments(String pathname, String jiraBaseURL,
			String jiraCreateIssueURL, String jiraAtachmentURL, String issueKey, String
			jiraUserName, String jiraPassword)  
	{ 
		try 
		{ 
			File fileUpload = new File(pathname);

	HttpClient httpClient = HttpClientBuilder.create().build();

	HttpPost postRequest = new
			HttpPost(jiraBaseURL+jiraCreateIssueURL+issueKey+jiraAtachmentURL);

	String auth = new String(Base64.encode(jiraUserName + ":" + jiraPassword));

	postRequest.setHeader("Authorization", "Basic " + auth);

	postRequest.setHeader("X-Atlassian-Token","nocheck");

	MultipartEntityBuilder entity=MultipartEntityBuilder.create();

	entity.addPart("file", new FileBody(fileUpload));

	postRequest.setEntity( entity.build());

	httpClient.execute(postRequest);

	} catch (IOException e) {

		log.error(e.getMessage()); }

	}

}

