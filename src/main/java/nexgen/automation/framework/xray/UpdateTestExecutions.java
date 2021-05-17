package nexgen.automation.framework.xray;

import org.apache.http.entity.StringEntity;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
//import com.fasterxml.jackson.databind.ObjectMapper;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.config.ReadConfig;
import nexgen.automation.framework.util.BaseClassUtil;
import nexgen.automation.framework.util.ClientSecret;
import nexgen.automation.framework.util.RestClientExceptionHandler;


public class UpdateTestExecutions {

	static ReadConfig readconfig = new ReadConfig();
	public static final String TOKEN_REQUEST_URL = readconfig.TokenRequestUrl();
	public static final String XRAY_TESTNG_URL = readconfig.xRayTestingUrl();
	public static final String CLIENT_ID = readconfig.xRayClientID();
	public static final String CLIENT_SECRET = readconfig.xRayClientSeret();
	static final  Logger log = Logger.getLogger(UpdateTestExecutions.class);
	public static void updateXrayTestResults() {
		try {
			BaseClassUtil util = new BaseClassUtil();
			String auth=generateToken();

			//HttpClient httpClient = HttpClientBuilder.create().build();
			RestTemplate template = new RestTemplate();
			template.setErrorHandler(new RestClientExceptionHandler());
			HttpHeaders headers = new HttpHeaders();
			String Url=XRAY_TESTNG_URL+"?projectKey="+BaseSuite.projectKey+"&testExecKey="+BaseSuite.executionKey+"&testPlanKey="+BaseSuite.planKey+"";

			//HttpPost postRequest = new HttpPost(XRAY_TESTNG_URL+"?projectKey="+BaseSuite.projectKey+"&testExecKey="+BaseSuite.executionKey+"&testPlanKey="+BaseSuite.planKey+"");

			headers.add("Authorization", "Bearer " + auth);

			headers.add("Content-Type", "text/xml");

			log.info("Thread ID- " + Thread.currentThread().getId() + " For " + Thread.currentThread().getName());

			String filePath = System.getProperty("user.dir") + "/target/surefire-reports-"+BaseSuite.seqNumber+ "/testng-results.xml";

			String data = util.writeXmlDocumentToXmlFile(filePath);

			StringEntity se = new StringEntity(data);
			HttpEntity<String> entity = new HttpEntity<>(se.toString(), headers);
			ResponseEntity<String> response = template.exchange(Url, HttpMethod.POST, entity,
					String.class);

			//postRequest.setEntity(se);

			//HttpResponse response12 = httpClient.execute(postRequest);
			
			log.info(response.toString());

		} catch (Exception exn) {
			
			log.error(exn.getMessage());
		}
	}
public  static String generateToken() {
		
		String auth = null;
		
	try {

		RestTemplate template = new RestTemplate();

		template.setErrorHandler(new RestClientExceptionHandler());

		ClientSecret clientSecret = new ClientSecret();

		clientSecret.setClientId(CLIENT_ID);

		clientSecret.setClientSecret(CLIENT_SECRET);

		HttpHeaders headers = new HttpHeaders();

		headers.add("Content-Type", "application/json");

		HttpEntity<String> entity = new HttpEntity<>(clientSecret.toString(), headers);

		ResponseEntity<String> response = template.exchange(TOKEN_REQUEST_URL, HttpMethod.POST, entity,
				String.class);

		log.info("response : {}"+new ObjectMapper().writeValueAsString(response));

		log.info("response status : {}"+new ObjectMapper().writeValueAsString(response.getStatusCode()));

		log.info("response body : {}"+new ObjectMapper().writeValueAsString(response.getBody()));

		auth = new ObjectMapper().writeValueAsString(response.getBody());
	
		auth = auth.substring(3);
		
		auth = auth.substring(0, auth.indexOf("\\\""));

		
	} catch (Exception exn) {
		
		log.error(exn.getMessage());
	}
	
	return auth;
}
}