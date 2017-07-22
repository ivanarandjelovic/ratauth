package org.aivan.ratauth.handlers;

import static org.junit.Assert.*;

import org.junit.Test;

import ratpack.test.handling.HandlingResult;
import ratpack.test.handling.RequestFixture;

public class TokenHandlerTest {

	@Test
	public void response2() throws Exception {
		HandlingResult result = RequestFixture.handle(new TokenHandler(), fixture -> fixture.uri("/token"));
		assertEquals("token", result.rendered(String.class));
	}

}
