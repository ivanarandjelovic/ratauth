package org.aivan.ratauth.handlers;

import static org.junit.Assert.*;

import org.junit.Test;

import ratpack.test.handling.HandlingResult;
import ratpack.test.handling.RequestFixture;

public class VerifyHandlerTest {

	@Test
	public void responseNoParams() throws Exception {
		HandlingResult result = RequestFixture.handle(new VerifyHandler(), fixture -> fixture.uri("/verify"));
		assertTrue(result.rendered(String.class).matches("verify, .*VerifyRequest.*null.*"));
	}

	@Test
	public void responseWithParams() throws Exception {
		HandlingResult result = RequestFixture.handle(new VerifyHandler(), fixture -> fixture.uri("/verify?token=1"));
		assertTrue(result.rendered(String.class).matches("verify, .*VerifyRequest.*token=1.*"));
	}

}
