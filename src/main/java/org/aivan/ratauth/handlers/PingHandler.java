package org.aivan.ratauth.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ratpack.handling.Context;
import ratpack.handling.Handler;

public class PingHandler implements Handler {

	static Logger log = LoggerFactory.getLogger(PingHandler.class);

	@Override
	public void handle(Context ctx) throws Exception {
		ctx.render("pong");
	}

}
