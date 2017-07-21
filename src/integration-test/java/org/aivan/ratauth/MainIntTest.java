package org.aivan.ratauth;

import org.junit.Test;

//import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.any;

import ratpack.server.RatpackServerSpec;

public class MainIntTest {

	@Test
	public void setup() throws Exception {
		RatpackServerSpec ratpackServerSpec = mock(RatpackServerSpec.class);
		Main.setupServer().execute(ratpackServerSpec);
		verify(ratpackServerSpec, atLeast(1)).handlers(any());
		verifyNoMoreInteractions(ratpackServerSpec);
	}
}
