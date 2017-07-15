package org.aivan.ratauth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ratpack.server.RatpackServer;

public class Main {

	static Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) throws Exception {

		log.info("Ola from ratauth!");

		RatpackServer
				.start(serverSpec -> serverSpec.handlers(chain -> chain.prefix("api/1", prefix -> prefix.get(ctx -> {
					log.debug("get 1 start");

					ctx.render("test1");
				}))));

		log.info("Bye from ratauth!");
	}

}
