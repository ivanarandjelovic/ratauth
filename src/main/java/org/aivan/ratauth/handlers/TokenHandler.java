package org.aivan.ratauth.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ratpack.handling.Context;
import ratpack.handling.Handler;

public class TokenHandler implements Handler {

	static Logger log = LoggerFactory.getLogger(TokenHandler.class);

	@Override
	public void handle(Context ctx) throws Exception {
		log.debug("start");
		ctx.render("token");
		log.debug("end");
	}

}
