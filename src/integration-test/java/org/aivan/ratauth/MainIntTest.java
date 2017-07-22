package org.aivan.ratauth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//import static org.mockito.Mockito.spy;
import static org.junit.Assert.*;

import ratpack.test.MainClassApplicationUnderTest;

public class MainIntTest {

	MainClassApplicationUnderTest app;

	@Before
	public void setup() {
		app = new MainClassApplicationUnderTest(Main.class);
	}

	@After
	public void teardown() {
		app.close();
	}

	@Test
	public void serverAlive() throws Exception {
		app.test(testHttpClient -> assertEquals("pong", testHttpClient.getText("/ping")));
	}
}
