package nexgen.automation.framework.zephyr;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.thed.zephyr.cloud.rest.ZFJCloudRestClient;
import com.thed.zephyr.cloud.rest.client.JwtGenerator;

import nexgen.automation.framework.config.ReadConfig;
import nexgen.automation.framework.constant.ExecutionResult;
import nexgen.automation.framework.util.XLUtils;


public class UpdateTestCycle {

	static ReadConfig readconfig = new ReadConfig();
	private static String zephyrBaseUrl = readconfig.zapiCloudBaseUrl();
	private static String apiGetExecutions = readconfig.apiGetExecution();
	private static String apiUpdateExecution = readconfig.apiUpdateExecution();
	private static String accessKey = readconfig.accessKey();
	private static String secretKey = readconfig.secretKey();
	private static String userName = readconfig.zephyrUserName();
	static final   Logger log = Logger.getLogger(UpdateTestCycle.class);
	static ZFJCloudRestClient jwtClientInst = ZFJCloudRestClient.restBuilder(zephyrBaseUrl, accessKey, secretKey, userName).build();

	public static void zapiAPIRunner(String cycleId, String versionId, String projectId) 
	{
		 XLUtils xlReader = new XLUtils();
		try
		{
			int offset = 0;

			int totalCount = offset + 1;

			String zephyrReportDoc = System.getProperty("user.dir")+ExecutionResult.reportDocPath; 

			int rowCount = xlReader.getRowCount(zephyrReportDoc, "Sheet1");

			List<ExecutionObject> executionObjectList = new ArrayList<ExecutionObject>();

			List<ExecutionObject> finalObjectList = new ArrayList<ExecutionObject>();

			log.info("Total Count 1 :::::::::::: " + totalCount);

			for (; offset <= totalCount;) {
				log.info("Test Cases Retrieved : " + offset);
				executionObjectList = getExecutionByCycleId(jwtClientInst, accessKey,  offset, cycleId,
						versionId, projectId);
				finalObjectList.addAll(executionObjectList);
				log.info("executionObjectList size ::::: " + executionObjectList.size());

				// Getting the total count from the response
				totalCount = executionObjectList.get(0).getTotalCount();

				offset = offset + 50;

				log.info("offset === " + offset);
			}

			log.info("Successfully fetched records : " + totalCount);

			log.info("executionObjectList size :: "+finalObjectList.size());

			JSONObject statusObj = new JSONObject();

			JSONObject executeTestsObj = new JSONObject();
			executeTestsObj.put("status", statusObj);
			executeTestsObj.put("projectId", projectId);
			executeTestsObj.put("versionId", versionId);
			executeTestsObj.put("comment", "Executed by Selenium ");

			for(int rowNum =0; rowNum<rowCount; rowNum++ ) {

				int rowNumber = rowNum +1;

				String issueKey = xlReader.getCellData(zephyrReportDoc, "Sheet1", rowNumber, 1);

				String resultStatus = xlReader.getCellData(zephyrReportDoc, "Sheet1", rowNumber, 2);

				int getstatus = Integer.parseInt(resultStatus);

				statusObj.put("id", String.valueOf(getstatus));

				if(issueKey.isEmpty()) {

					log.info("issue key is empty");

				}else {

					for (ExecutionObject executionObject : finalObjectList) {

						String testCaseId = executionObject.getTestCaseId();

						log.info(" testCaseId ::: " + testCaseId + "issueKey ::::: " + issueKey);

						if (testCaseId.equals(issueKey)) {

							log.info("************* testCaseId :::- " + testCaseId + "-------------issueKey ::::: " + issueKey);

							String key = executionObject.getExecutionId();

							final String updateExecutionUri = apiUpdateExecution.replace("{ZephyrBaseURL}", zephyrBaseUrl) + key;

							executeTestsObj.put("issueId", executionObject.getIssueId());
							StringEntity executeTestsJSON = null;

								executeTestsJSON = new StringEntity(executeTestsObj.toString());
							
								log.info(")(*)&((*&%*&%&%====" + executeTestsJSON.toString());
							updateExecutions(updateExecutionUri, jwtClientInst, accessKey, executeTestsJSON);

						}
					}
				}
			}
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}

	private static List<ExecutionObject> getExecutionByCycleId(ZFJCloudRestClient client, String accessKey,
			int offset, String cycleId, String versionId, String projectId)
	{
		List<ExecutionObject> executionObjectList = new ArrayList<ExecutionObject>();
     try
     {
		

		final String getExecutionsUri = apiGetExecutions.replace("{ZephyrBaseURL}", zephyrBaseUrl)
				+ cycleId + "?projectId=" + projectId + "&versionId=" + versionId + "&offset=" + offset;

		URI uri = new URI(getExecutionsUri);
		log.info("uriStr ::::: " + getExecutionsUri);

		int expirationInSec = 360;
		JwtGenerator jwtGenerator = client.getJwtGenerator();
		String jwt = jwtGenerator.generateJWT("GET", uri, expirationInSec);

		log.info(uri.toString());
		log.info(jwt);

		HttpResponse response = null;
		HttpClient restClient = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet(uri);
		httpGet.setHeader("Authorization", jwt);
		httpGet.setHeader("zapiAccessKey", accessKey);

			response = restClient.execute(httpGet);
		

		int statusCode = response.getStatusLine().getStatusCode();
		
		if (statusCode >= 200 && statusCode < 300) {
			HttpEntity entity1 = response.getEntity();
			String	string1 = EntityUtils.toString(entity1);

			// Getting the JSON Object from the Response Body
			JSONObject allIssues = new JSONObject(string1);
			JSONArray IssuesArray = allIssues.getJSONArray("searchObjectList");

			if (IssuesArray.length() == 0) {
				return executionObjectList;
			}

			if (IssuesArray.length() == 0) {
				return executionObjectList;
			}

			// Retrieving the values required from Response JSON Object
			for (int j = 0; j <= IssuesArray.length() - 1; j++) {

				int totalCount = allIssues.getInt("totalCount");

				JSONObject jobj = IssuesArray.getJSONObject(j);
				String testCaseId = jobj.getString("issueKey");
				//String summary = jobj.getString("issueSummary");
				//String labels = jobj.getString("issueLabel");

				JSONObject executionJsonObject = jobj.getJSONObject("execution");
				String executionId = executionJsonObject.getString("id");
				long longIssueId = executionJsonObject.getLong("issueId");
				String issueId = String.valueOf(longIssueId);

				JSONObject statusArray = executionJsonObject.getJSONObject("status");
				String testStatus = statusArray.getString("name");

				// Creating and loading the object with the values obtained from response JSON.
				//executionObjectList.add(new ExecutionObject(issueId, testCaseId, executionId, totalCount, summary,
						//cycleId, testStatus, labels));

				executionObjectList.add(new ExecutionObject(issueId, testCaseId, executionId, totalCount,
						cycleId, testStatus));

			}
		} else {
			log.info("Bad Status Code : " + statusCode);
		}
     }
     catch(Exception e)
     {
    	 log.error(e.getMessage());
     }

		return executionObjectList;
	}

	public static String updateExecutions(String uriStr, ZFJCloudRestClient client, String accessKey,
			StringEntity executionJSON) throws URISyntaxException, JSONException, ParseException, IOException {
		String executionStatus = "No Test Executed";
		try
		{
		URI uri = new URI(uriStr);
		int expirationInSec = 360;
		JwtGenerator jwtGenerator = client.getJwtGenerator();
		String jwt = jwtGenerator.generateJWT("PUT", uri, expirationInSec);
		HttpResponse response = null;
		HttpClient restClient = HttpClientBuilder.create().build();

		HttpPut executeTest = new HttpPut(uri);
		executeTest.addHeader("Content-Type", "application/json");
		executeTest.addHeader("Authorization", jwt);
		executeTest.addHeader("zapiAccessKey", accessKey);
		executeTest.setEntity(executionJSON);

		response = restClient.execute(executeTest);

		int statusCode = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();

		if (statusCode >= 200 && statusCode < 300) {
			String string = null;
				string = EntityUtils.toString(entity);
				JSONObject executionResponseObj = new JSONObject(string);
				JSONObject descriptionResponseObj = executionResponseObj.getJSONObject("execution");
				JSONObject statusResponseObj = descriptionResponseObj.getJSONObject("status");
				executionStatus = statusResponseObj.getString("description");

		} else {

				String string = null;
				string = EntityUtils.toString(entity);
				JSONObject executionResponseObj = new JSONObject(string);
				log.info("executionResponseObj::" + executionResponseObj.getString("clientMessage"));
				throw new ClientProtocolException("Unexpected response status: " + statusCode);
		}
		log.info("STATUS::::" + executionStatus);
		}
		catch (Exception e)
		{
			log.error(e.getMessage());
		}
		return executionStatus;
	}

}