package org.aivan.ratauth.handlers;

import static org.junit.Assert.*;

import org.junit.Test;

import ratpack.test.handling.HandlingResult;
import ratpack.test.handling.RequestFixture;

public class TokenHandlerTest {

	@Test
	public void responseNoParam() throws Exception {
		HandlingResult result = RequestFixture.handle(new TokenHandler(), fixture -> fixture.uri("/token"));
		assertTrue(result.rendered(String.class).matches("token, .*TokenRequest.*null.*null.*null.*null.*null.*null.*null.*null.*"));
	}

	@Test
	public void responseOneParam() throws Exception {
		HandlingResult result = RequestFixture.handle(new TokenHandler(), fixture -> fixture.uri("/token?client_id=1"));
		assertTrue(result.rendered(String.class).matches("token, .*TokenRequest.*clientId=1.*"));
	}

}
