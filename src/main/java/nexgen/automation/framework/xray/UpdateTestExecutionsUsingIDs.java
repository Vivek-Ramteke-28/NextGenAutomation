package nexgen.automation.framework.xray;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import com.sun.jersey.core.util.Base64;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.config.ReadConfig;
import nexgen.automation.framework.constant.ExecutionResult;
import nexgen.automation.framework.util.XLUtils;



public class UpdateTestExecutionsUsingIDs {

	
	
static ReadConfig readconfig = new ReadConfig();

	static final   Logger log = Logger.getLogger(UpdateTestExecutionsUsingIDs.class);

	public static final String XRAY_GrafQL = readconfig.xRayGrafQL();

	private static String jiraBaseUrl = readconfig.jiraBaseURL();
	private static String jiraIssueUrl = readconfig.jiraIssueUrl();
	private static String jiraUserName = readconfig.jiraUserName();
	private static String jiraPassword = readconfig.jiraPassword();
	private static String jiraAtachmentURL = readconfig.jiraAtachmentURL();
	private static String jiraAttUrl = readconfig.jira();
	
	public void updateTestExecutions()
			throws IOException {

		String testExecution = BaseSuite.executionKey;
		
		String executionID = getIssueIDs(testExecution);
			
		log.info(executionID);
		
		String reportDoc = ExecutionResult.reportDocPath;
		XLUtils xlReader = new XLUtils();
		int rowCount = xlReader.getRowCount(reportDoc, "Sheet1");
		
		for(int rowNum =0; rowNum<rowCount; rowNum++ ) {
			
			int rowNumber = rowNum +1;
		
			String issueKey = xlReader.getCellData(reportDoc, "Sheet1", rowNumber, 1);
			
			String status = xlReader.getCellData(reportDoc, "Sheet1", rowNumber, 2);
			
			String issueID = getIssueIDs(issueKey);
			
			String exeStatus = addStatus(status);
			
			log.info(issueID);
			
			try {
				
				String auth = UpdateTestExecutions.generateToken();
				
				log.info(auth);

				String exeID = getExecutionIDs(auth, issueID,executionID);
				
				log.info(exeID);
				
				updateStatus(exeID,exeStatus,auth);
				
				//File pathname = getLastModified("D:\\NextGen_iCEDQ_RuleX_Automation\\ng_icedq_rulex_automation\\reports\\LoginFunctionallty-reports");
				
			//addJiraAttachments(pathname.toString(), jiraBaseUrl, jiraAtachmentURL, testExecution, jiraUserName, jiraPassword);
				
				
			} catch (Exception e) {
				log.error(e.getMessage());
				
			}
			
			
		}
		
	}

	
	public String addStatus(String status) {
		
		String updateStatus=null;
		
		if(status.equals("1")) {
			
			updateStatus = "Passed";
			
		}else if(status.equals("2")) {
			
			updateStatus = "Failed";
			
		}else if(status.equals("3")) {
			
			updateStatus = "UNEXECUTED";
			
		}
			
	return updateStatus;
		
	}
	
public  String getExecutionIDs(String auth,String testCaseId,String executionId) throws IOException {
		
		String queryParam = "{getTestRun( testIssueId: \""+testCaseId+"\", testExecIssueId: \""+executionId+"\") {id status { name color description } gherkin examples { id status { name color description } } }}";

		String testCaseAddUrl = XRAY_GrafQL+"?query="+ URLEncoder.encode(queryParam, "UTF-8");
			
		HttpClient httpClient = HttpClientBuilder.create().build();
		
		HttpGet getRequest = new HttpGet(testCaseAddUrl);
		
		getRequest.setHeader("Authorization", "Bearer " + auth);
		
		getRequest.setHeader("Content-Type","application/json");
		
		getRequest.setHeader("Accept","application/json");
		
		HttpResponse response;
				
		response = httpClient.execute(getRequest);
				
		log.info("response----------------"+response);
				
		int statusCode = response.getStatusLine().getStatusCode();
		
		log.info("Status code for getting issues -----------"+statusCode);

		org.apache.http.HttpEntity entity1 = response.getEntity();
		
		String string1 = null;
		
		string1 = EntityUtils.toString((org.apache.http.HttpEntity) entity1);
			
		JSONObject allIssues = new JSONObject(string1);

		log.info(allIssues.toString());
	
		log.info(allIssues.getJSONObject("data").toString());
		
		JSONObject resp1 = allIssues.getJSONObject("data");
		
		log.info(resp1.getJSONObject("getTestRun").toString());
		
		JSONObject resp2 = resp1.getJSONObject("getTestRun");
		
		log.info(resp2.get("id").toString());
		
		return resp2.get("id").toString();

}
	
public  void updateStatus(String exeID, String status,String auth) throws  IOException {
	
	String queryParam = "mutation {updateTestRunStatus( id: \""+exeID+"\", status: \""+status+"\")}";

	String testCaseAddUrl = XRAY_GrafQL+"?query="+ URLEncoder.encode(queryParam, "UTF-8");
		
	HttpClient httpClient = HttpClientBuilder.create().build();
	
	HttpPost postRequest = new HttpPost(testCaseAddUrl);
	
	postRequest.setHeader("Authorization", "Bearer " + auth);
	
	postRequest.setHeader("Content-Type","application/json");
	
	postRequest.setHeader("Accept","application/json");
	
	HttpResponse response;
			
	response = httpClient.execute(postRequest);
			
	log.info("response----------------"+response);
			
	int statusCode = response.getStatusLine().getStatusCode();
	
	log.info("Status code for getting issues -----------"+statusCode);
}

	public  String getIssueIDs(String id) throws org.apache.http.ParseException, IOException {

		HttpClient httpClient = HttpClientBuilder.create().build();
		
		HttpGet getRequest = new HttpGet(jiraBaseUrl+jiraIssueUrl+id);
		
		String auth = new String(Base64.encode(jiraUserName + ":" + jiraPassword));
		
		getRequest.setHeader("Authorization", "Basic " + auth);
		
		getRequest.setHeader("Content-Type","application/json");
		
		getRequest.setHeader("Accept","application/json");
		 
		 HttpResponse response;
				
		response = httpClient.execute(getRequest);
				
		log.info(response.toString());
				
		int statusCode = response.getStatusLine().getStatusCode();
		
		log.info("Status code for getting issues -----------"+statusCode);
		
		org.apache.http.HttpEntity entity1 = response.getEntity();
			
		String string1 = null;
		
		string1 = EntityUtils.toString((org.apache.http.HttpEntity) entity1);
			
		JSONObject allIssues = new JSONObject(string1);

		log.info(allIssues.toString());
		
		log.info("ID ------"+allIssues.get("id"));

		return allIssues.get("id").toString();
		
	}
	
	public static void addJiraAttachments(String pathname, String jiraBaseURL, String jiraAtachmentURL, String executionKey,
			String jiraUserName, String jiraPassword) {
		try {
			File fileUpload = new File(pathname);

			HttpClient httpClient = HttpClientBuilder.create().build();

			HttpPost postRequest = new HttpPost(jiraBaseURL + jiraAttUrl + executionKey + jiraAtachmentURL);

			String auth = new String(Base64.encode(jiraUserName + ":" + jiraPassword));

			postRequest.setHeader("Authorization", "Basic " + auth);

			postRequest.setHeader("X-Atlassian-Token", "nocheck");
			

			/*
			 * postRequest.setHeader("Authorization", "Bearer " + auth);
			 * 
			 * postRequest.setHeader("Content-Type","application/json");
			 * 
			 * postRequest.setHeader("Accept","application/json");
			 */

			MultipartEntityBuilder entity = MultipartEntityBuilder.create();

			entity.addPart("file", new FileBody(fileUpload));

			postRequest.setEntity(entity.build());

			HttpResponse response = httpClient.execute(postRequest);
			
			log.info("response----------------"+response);

		} catch (IOException e) {

			log.error(e.getMessage());
		}

	}
	
	public static File getLastModified(String directoryFilePath)
	{
	    File directory = new File(directoryFilePath);
	    File[] files = directory.listFiles(File::isFile);
	    long lastModifiedTime = Long.MIN_VALUE;
	    File chosenFile = null;

	    if (files != null)
	    {
	        for (File file : files)
	        {
	            if (file.lastModified() > lastModifiedTime)
	            {
	                chosenFile = file;
	                lastModifiedTime = file.lastModified();
	            }
	        }
	    }

	    return chosenFile;
	}


	
}
