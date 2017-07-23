package org.aivan.ratauth.handlers.request;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TokenRequestTest {

	@Test
	public void defaultValues() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		
		TokenRequest request = TokenRequest.loadFrom(params);
		
		assertNull(request.getClientId());
		assertNull(request.getClientSecret());
		assertNull(request.getGrantType());
		assertNull(request.getRedirectUri());
		assertNull(request.getCode());
		assertNull(request.getUsername());
		assertNull(request.getPassword());
		assertNull(request.getRefreshToken());
	}

	@Test
	public void clientId() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("client_id", "clientId1");
		
		TokenRequest request = TokenRequest.loadFrom(params);
		
		assertEquals("clientId1", request.getClientId());
		assertNull(request.getClientSecret());
		assertNull(request.getGrantType());
		assertNull(request.getRedirectUri());
		assertNull(request.getCode());
		assertNull(request.getUsername());
		assertNull(request.getPassword());
		assertNull(request.getRefreshToken());
	}

	@Test
	public void allParams() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("client_id", "clientId1");
		params.put("client_secret", "client_secret1");
		params.put("garnt_type", "garnt_type1");
		params.put("redirect_uri", "redirect_uri1");
		params.put("code", "code1");
		params.put("username", "username1");
		params.put("password", "password1");
		params.put("refresh_token", "refresh_token1");
		
		TokenRequest request = TokenRequest.loadFrom(params);
		
		assertEquals("clientId1", request.getClientId());
		assertEquals("client_secret1", request.getClientSecret());
		assertEquals("garnt_type1", request.getGrantType());
		assertEquals("redirect_uri1", request.getRedirectUri());
		assertEquals("code1", request.getCode());
		assertEquals("username1", request.getUsername());
		assertEquals("password1", request.getPassword());
		assertEquals("refresh_token1", request.getRefreshToken());
	}

}
