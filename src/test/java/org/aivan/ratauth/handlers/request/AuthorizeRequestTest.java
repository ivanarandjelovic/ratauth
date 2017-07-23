package org.aivan.ratauth.handlers.request;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class AuthorizeRequestTest {

	@Test
	public void responseNoParams() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("client_id","clientId1");
		AuthorizeRequest request = AuthorizeRequest.loadFrom(params);
		assertEquals("clientId1", request.getClientId());
		assertNull( request.getRedirectUri());
		assertNull( request.getResponseType());
		assertNull( request.getScope());
	}
	
}
