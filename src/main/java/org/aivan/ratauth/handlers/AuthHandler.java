package org.aivan.ratauth.handlers;

import org.aivan.ratauth.handlers.request.AuthorizeRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.http.Request;

public class AuthHandler implements Handler {

	static Logger log = LoggerFactory.getLogger(AuthHandler.class);

	@Override
	public void handle(Context ctx) throws Exception {
		log.debug("start");
		
		Request req = ctx.getRequest();
		
		AuthorizeRequest authRequest = AuthorizeRequest.loadFrom(req.getQueryParams());
		
		ctx.render("auth, authRequest="+authRequest);
		
		log.debug("end");
	}

}
