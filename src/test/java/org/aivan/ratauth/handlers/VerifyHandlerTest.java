package org.aivan.ratauth.handlers;

import static org.junit.Assert.*;

import org.junit.Test;

import ratpack.test.handling.HandlingResult;
import ratpack.test.handling.RequestFixture;

public class VerifyHandlerTest {

	@Test
	public void responseNoParams() throws Exception {
		HandlingResult result = RequestFixture.handle(new VerifyHandler(), fixture -> fixture.uri("/verify"));
		assertEquals(400, result.getStatus().getCode());
	}

	@Test
	public void responseWithParams() throws Exception {
		HandlingResult result = RequestFixture.handle(new VerifyHandler(), fixture -> fixture.uri("/verify?token=1"));
		assertEquals(400, result.getStatus().getCode());
	}

}
