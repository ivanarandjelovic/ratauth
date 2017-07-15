package org.aivan.ratauth;

import org.aivan.ratauth.handlers.TestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ratpack.func.Action;
import ratpack.server.RatpackServer;
import ratpack.server.RatpackServerSpec;

public class Main {

	static Logger log = LoggerFactory.getLogger(Main.class);

	static TestHandler testHandler = new TestHandler();
	
	public static void main(String[] args) throws Exception {

		log.info("Ola from ratauth!");

		RatpackServer
				.start(setupServer());

		log.info("Bye from ratauth!");
	}

	// function to setup Ratpack server
	protected static Action<? super RatpackServerSpec> setupServer() {
		return serverSpec -> serverSpec
				.handlers(chain -> chain.prefix("api/1", prefix -> prefix.get(testHandler)));
	}

}
