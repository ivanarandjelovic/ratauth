package org.aivan.ratauth.handlers;

import static org.junit.Assert.*;

import org.junit.Test;

import ratpack.test.handling.HandlingResult;
import ratpack.test.handling.RequestFixture;

public class AuthHandlerTest {

	@Test
	public void response() throws Exception {
		HandlingResult result = RequestFixture.handle(new AuthHandler(), fixture -> {});
		assertEquals("auth", result.rendered(String.class));
	}
	
	@Test
	public void response2() throws Exception {
		HandlingResult result = RequestFixture.handle(new AuthHandler(), fixture -> fixture.uri("/auth"));
		assertEquals("auth", result.rendered(String.class));
	}
}
