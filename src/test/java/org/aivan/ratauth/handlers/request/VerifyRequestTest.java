package org.aivan.ratauth.handlers.request;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class VerifyRequestTest {
	@Test
	public void defaultValues() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		
		VerifyRequest request = VerifyRequest.loadFrom(params);
		
		assertNull(request.getToken());
	}

	@Test
	public void withToken() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("token", "token1");
		
		VerifyRequest request = VerifyRequest.loadFrom(params);
		
		assertEquals("token1", request.getToken());
		assertTrue(request.toString().contains("token1"));
	}

}