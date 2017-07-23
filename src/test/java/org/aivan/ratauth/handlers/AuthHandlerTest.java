package org.aivan.ratauth.handlers;

import static org.junit.Assert.*;

import org.junit.Test;

import ratpack.test.handling.HandlingResult;
import ratpack.test.handling.RequestFixture;

public class AuthHandlerTest {

	@Test
	public void responseNoParams() throws Exception {
		HandlingResult result = RequestFixture.handle(new AuthHandler(), fixture -> {});
		assertTrue(result.rendered(String.class).matches("auth, .*AuthorizeRequest.*null.*null.*null.*null.*"));
	}
	
	@Test
	public void responseType() throws Exception {
		HandlingResult result = RequestFixture.handle(new AuthHandler(), fixture -> fixture.uri("/auth?response_type=1"));
		assertTrue(result.rendered(String.class).matches("auth, .*AuthorizeRequest.*responseType=1.*"));
	}
}
