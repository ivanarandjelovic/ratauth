package org.aivan.ratauth;

import org.aivan.ratauth.handlers.AuthHandler;
import org.aivan.ratauth.handlers.TestHandler;
import org.aivan.ratauth.handlers.TokenHandler;
import org.aivan.ratauth.handlers.VerifyHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ratpack.func.Action;
import ratpack.server.RatpackServer;
import ratpack.server.RatpackServerSpec;

public class Main {

	static Logger log = LoggerFactory.getLogger(Main.class);

	static TestHandler testHandler = new TestHandler();
	static AuthHandler authHandler = new AuthHandler();
	static TokenHandler tokenHandler = new TokenHandler();
	static VerifyHandler verifyHandler = new VerifyHandler();

	public static void main(String[] args) throws Exception {

		log.info("Ola from ratauth!");

		RatpackServer.start(setupServer());

		log.info("Bye from ratauth!");
	}

	// function to setup Ratpack server
	protected static Action<? super RatpackServerSpec> setupServer() {
		return serverSpec -> serverSpec.handlers(chain -> chain.prefix("test", prefix -> prefix.get(testHandler))
				.prefix("auth", prefix -> prefix.get(authHandler))
				.prefix("token", prefix -> prefix.get(tokenHandler))
		.prefix("verify", prefix -> prefix.get(verifyHandler)));
	}

}
