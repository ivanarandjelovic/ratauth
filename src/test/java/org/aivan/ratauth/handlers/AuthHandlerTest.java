package org.aivan.ratauth.handlers;

import static org.junit.Assert.*;

import org.junit.Test;

import ratpack.test.handling.HandlingResult;
import ratpack.test.handling.RequestFixture;

public class AuthHandlerTest {

	@Test
	public void response() throws Exception {
		HandlingResult result = RequestFixture.handle(new AuthHandler(), fixture -> {});
		assertEquals("auth, response_type=null", result.rendered(String.class));
	}
	
	@Test
	public void response2() throws Exception {
		HandlingResult result = RequestFixture.handle(new AuthHandler(), fixture -> fixture.uri("/auth?response_type=1"));
		assertEquals("auth, response_type=1", result.rendered(String.class));
	}
}
