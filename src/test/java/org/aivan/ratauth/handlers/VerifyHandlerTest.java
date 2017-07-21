package org.aivan.ratauth.handlers;

import static org.junit.Assert.*;

import org.junit.Test;

import ratpack.test.handling.HandlingResult;
import ratpack.test.handling.RequestFixture;

public class VerifyHandlerTest {

	@Test
	public void response() throws Exception {
		HandlingResult result = RequestFixture.handle(new VerifyHandler(), fixture -> {
		});
		assertEquals("verify", result.rendered(String.class));
	}

	@Test
	public void response2() throws Exception {
		HandlingResult result = RequestFixture.handle(new VerifyHandler(), fixture -> fixture.uri("/token"));
		assertEquals("verify", result.rendered(String.class));
	}

}
