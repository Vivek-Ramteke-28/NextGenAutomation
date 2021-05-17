package nexgen.automation.framework.integration;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import com.sun.jersey.core.util.Base64;

import nexgen.automation.framework.config.ReadConfig;

public class HPALM {
	final Logger log = Logger.getLogger(HPALM.class);

	 ReadConfig readconfig = new ReadConfig();
	
	 String hpalmBaseURL = readconfig.hpalmBaseURL();

	 String hpalmauthentication = readconfig.hpalmauthentication();

	 String hpalmSession = readconfig.hpalmSession();

	 String hpalmUserName = readconfig.hpalmUserName();

	 String hpalmPassword = readconfig.hpalmPassword();

	 String LWSSO_COOKIE_KEY = "";

	public  void getAuthAndSession(HttpClient httpClient) {
		
		try
		{

		HttpGet getRequest = new HttpGet(hpalmBaseURL + hpalmauthentication);

		String auth = new String(Base64.encode(hpalmUserName + ":" + hpalmPassword));

		getRequest.setHeader("Authorization", "Basic " + auth);

		getRequest.setHeader("Content-Type", "application/json");

		getRequest.setHeader("Accept", "application/json");

		HttpResponse response;

		response = httpClient.execute(getRequest);

		Header[] headerFields = response.getAllHeaders();

		Header cookie = headerFields[1];

		String LWSSO = cookie.getValue();

		String[] LW = LWSSO.split(";");

		String[] LW1 = LW[0].split("=");

		String LW2 = LW1[1];


		LWSSO_COOKIE_KEY = LW2;

		HttpPost postRequest = new HttpPost(hpalmBaseURL + hpalmSession);

		postRequest.setHeader("LWSSO_COOKIE_KEY", LWSSO_COOKIE_KEY);
		httpClient.execute(postRequest);

		
		}catch (IOException e) {

			log.error(e.getMessage());
		}
		

	}

	public  void addTestCase(HttpClient httpClient, String domain, String project, String testSetID,
			String testCaseID) 
	{
     try
     {
		String queryParam = "{cycle-id[" + testSetID + "]}";

		String testCaseAddUrl = "/rest/domains/" + domain + "/projects/" + project + "/test-instances?query="
				+ URLEncoder.encode(queryParam, "UTF-8");

		StringEntity data = new StringEntity("{\"Fields\": [{\"Name\": \"test-id\",\"values\": [{\"value\": \""
				+ testCaseID
				+ "\"}]},{\"Name\": \"subtype-id\",\"values\": [{\"value\": \"hp.qc.test-instance.MANUAL\"}]},{\"Name\": \"cycle-id\",\"values\": [{\"value\": \""
				+ testSetID + "\"}]},{\"Name\": \"owner\",\"values\": [{\"value\": \"admin\"}]}]}");

		HttpPost postRequest = new HttpPost(hpalmBaseURL + testCaseAddUrl);

		postRequest.setHeader("Content-Type", "application/json");

		postRequest.setHeader("Accept", "application/json");

		postRequest.setHeader("LWSSO_COOKIE_KEY", LWSSO_COOKIE_KEY);

		postRequest.setEntity(data);
		httpClient.execute(postRequest);
     }
     catch (IOException e) {

    	 log.error(e.getMessage());
		}

	}

	public  void deleteTestCase(HttpClient httpClient, String domain, String project, String testSetID,
			String testCaseID) throws UnsupportedEncodingException, URISyntaxException, MalformedURLException {
      try
      {
		String queryParam = "{cycle-id[" + testSetID + "];test-id[" + testCaseID + "]}";

		String testCaseAddUrl = "/rest/domains/" + domain + "/projects/" + project + "/test-instances?query="
				+ URLEncoder.encode(queryParam, "UTF-8");

		HttpDelete deleteRequest = new HttpDelete(hpalmBaseURL + testCaseAddUrl);

		deleteRequest.setHeader("LWSSO_COOKIE_KEY", LWSSO_COOKIE_KEY);

		httpClient.execute(deleteRequest);

      }catch (IOException e) {

    	  log.error(e.getMessage());
		}
      

	}

	public  String getStatus(HttpClient httpClient, String domain, String project, String testSetID,
			String testCaseID)  {
		String finalvalue = "";
		try
		{
		
		String queryParam = "{cycle-id[" + testSetID + "];test-id[" + testCaseID + "]}";

		String testCaseAddUrl = "/rest/domains/" + domain + "/projects/" + project + "/test-instances?query="
				+ URLEncoder.encode(queryParam, "UTF-8");

		HttpGet getRequest = new HttpGet(hpalmBaseURL + testCaseAddUrl);

		getRequest.setHeader("Content-Type", "application/json");

		getRequest.setHeader("Accept", "application/json");

		getRequest.setHeader("LWSSO_COOKIE_KEY", LWSSO_COOKIE_KEY);

		HttpResponse response;

		response = httpClient.execute(getRequest);

		HttpEntity entity1 = response.getEntity();

		log.info(entity1.toString());

		String string1 = null;

		string1 = EntityUtils.toString(entity1);

		JSONObject testcases = new JSONObject(string1);

		JSONArray issueskeys = testcases.getJSONArray("entities");

		log.info(issueskeys);

		for (int i = 0; i < issueskeys.length(); i++) {

			JSONObject jsonObj = (JSONObject) issueskeys.get(i);

			
			JSONArray arrayFields = (JSONArray) jsonObj.get("Fields");
			
			
			for (int j = 0; j < arrayFields.length(); j++) {
				
				JSONObject intObj = (JSONObject) arrayFields.get(j);
				
				String obj = (String) intObj.get("Name");

				if ("status".equals(obj)) {
					JSONArray finArr = (JSONArray) intObj.get("values");

					for (int k = 0; k < finArr.length(); k++) {
						JSONObject 	finObj = (JSONObject) finArr.get(k);
						finalvalue  = (String) finObj.get("value");
					}
				}
				
				}
		}
		}
		catch (IOException e) {

			log.error(e.getMessage());
		}
		
		return finalvalue;
	}
	
}
