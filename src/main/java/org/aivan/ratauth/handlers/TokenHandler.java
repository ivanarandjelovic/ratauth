package org.aivan.ratauth.handlers;

import org.aivan.ratauth.handlers.request.TokenRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.http.Request;

public class TokenHandler implements Handler {

	static Logger log = LoggerFactory.getLogger(TokenHandler.class);

	@Override
	public void handle(Context ctx) throws Exception {
		log.debug("start");

		Request req = ctx.getRequest();

		TokenRequest tokenRequest = TokenRequest.loadFrom(req.getQueryParams());

		ctx.render("token, tokenRequest=" + tokenRequest);

		log.debug("end");
	}

}
