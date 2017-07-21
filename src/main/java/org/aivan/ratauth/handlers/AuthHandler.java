package org.aivan.ratauth.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ratpack.handling.Context;
import ratpack.handling.Handler;

public class AuthHandler implements Handler {

	static Logger log = LoggerFactory.getLogger(AuthHandler.class);

	@Override
	public void handle(Context ctx) throws Exception {
		log.debug("start");
		ctx.render("auth");
		log.debug("end");
	}

}
