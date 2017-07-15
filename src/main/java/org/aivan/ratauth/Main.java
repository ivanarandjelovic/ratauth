package org.aivan.ratauth;

import org.aivan.ratauth.handlers.TestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ratpack.server.RatpackServer;

public class Main {

	static Logger log = LoggerFactory.getLogger(Main.class);

	static TestHandler testHandler = new TestHandler();
	
	public static void main(String[] args) throws Exception {

		log.info("Ola from ratauth!");

		RatpackServer
				.start(serverSpec -> serverSpec
						.handlers(chain -> chain.prefix("api/1", prefix -> prefix.get(testHandler))));

		log.info("Bye from ratauth!");
	}

}
