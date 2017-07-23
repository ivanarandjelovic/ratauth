package org.aivan.ratauth.handlers;

import org.aivan.ratauth.handlers.request.VerifyRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.http.Request;

public class VerifyHandler implements Handler {

	static Logger log = LoggerFactory.getLogger(VerifyHandler.class);

	@Override
	public void handle(Context ctx) throws Exception {
		log.debug("start");

		Request req = ctx.getRequest();

		VerifyRequest verifyRequest = VerifyRequest.loadFrom(req.getQueryParams());

		ctx.render("verify, verifyRequest=" + verifyRequest);

		log.debug("end");
	}

}
