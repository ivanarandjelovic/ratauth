package org.aivan.ratauth.handlers;

import static org.junit.Assert.*;

import org.junit.Test;

import ratpack.test.handling.HandlingResult;
import ratpack.test.handling.RequestFixture;

public class PingHandlerTest {

	@Test
	public void response() throws Exception {
		HandlingResult result = RequestFixture.handle(new PingHandler(), fixture -> {
		});
		assertEquals("pong", result.rendered(String.class));
	}

}
