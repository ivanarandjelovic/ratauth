package org.aivan.ratauth.handlers.request;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class AuthorizeRequestTest {

	@Test
	public void defaultValues() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		
		AuthorizeRequest request = AuthorizeRequest.loadFrom(params);
		
		assertNull(request.getClientId());
		assertNull(request.getRedirectUri());
		assertNull(request.getResponseType());
		assertNull(request.getScope());
	}

	@Test
	public void clientId() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("client_id", "clientId1");
		
		AuthorizeRequest request = AuthorizeRequest.loadFrom(params);
		
		assertEquals("clientId1", request.getClientId());
		assertNull(request.getRedirectUri());
		assertNull(request.getResponseType());
		assertNull(request.getScope());
	}

	@Test
	public void allParams() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("client_id", "clientId1");
		params.put("redirect_uri", "redirect_uri1");
		params.put("response_type", "response_type1");
		params.put("scope", "scope1");
		
		AuthorizeRequest request = AuthorizeRequest.loadFrom(params);
		
		assertEquals("clientId1", request.getClientId());
		assertEquals("redirect_uri1", request.getRedirectUri());
		assertEquals("response_type1", request.getResponseType());
		assertEquals("scope1", request.getScope());
	}

}
