package nexgen.automation.framework.util;


import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;


public class RestClientExceptionHandler implements ResponseErrorHandler {

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		return !(response.getStatusCode().equals(HttpStatus.OK) || response.getStatusCode().equals(HttpStatus.ACCEPTED)
				|| response.getStatusCode().equals(HttpStatus.CREATED));
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		// nothting is needed here
	}

}