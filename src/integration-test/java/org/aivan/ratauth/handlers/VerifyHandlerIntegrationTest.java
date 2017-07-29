package org.aivan.ratauth.handlers;

import static org.junit.Assert.*;

import java.io.IOException;

import org.aivan.ratauth.Main;
import org.aivan.ratauth.dao.BaseMongoDBTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ratpack.test.MainClassApplicationUnderTest;

public class VerifyHandlerIntegrationTest extends BaseMongoDBTest {

	MainClassApplicationUnderTest app;
	
	@Before
	public void setup() throws IOException {
		super.setup();
		app = new MainClassApplicationUnderTest(Main.class);
	}

	@After
	public void teardown() throws IOException {
		super.teardown();
		app.close();
	}
	
	@Test
	public void verifyValidToken() throws Exception {
		app.test(testHttpClient -> assertEquals(200, testHttpClient.get("/verify?token=token_valid").getStatusCode()));
	}

}
