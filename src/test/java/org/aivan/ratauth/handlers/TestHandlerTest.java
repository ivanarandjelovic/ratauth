package org.aivan.ratauth.handlers;

import static org.junit.Assert.*;

import org.junit.Test;

import ratpack.test.handling.HandlingResult;
import ratpack.test.handling.RequestFixture;

public class TestHandlerTest {

	@Test
	public void response() throws Exception {
		HandlingResult result = RequestFixture.handle(new TestHandler(), fixture -> {});
		assertEquals("test1", result.rendered(String.class));
	}
	
	@Test
	public void response2() throws Exception {
		HandlingResult result = RequestFixture.handle(new TestHandler(), fixture -> fixture.uri("/api/2"));
		assertEquals("test1", result.rendered(String.class));
	}
}
