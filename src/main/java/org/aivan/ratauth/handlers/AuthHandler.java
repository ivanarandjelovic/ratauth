package org.aivan.ratauth.handlers;

import org.aivan.ratauth.handlers.request.AuthorizeRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ratpack.func.Block;
import ratpack.handling.Context;
import ratpack.http.Request;

public class AuthHandler extends RatauthHandler {

	static Logger log = LoggerFactory.getLogger(AuthHandler.class);

	@Override
	public void ratAuthHandle(Context ctx, Block block) throws Exception {
		log.debug("start");
		
		Request req = ctx.getRequest();
		
		AuthorizeRequest authRequest = AuthorizeRequest.loadFrom(req.getQueryParams());
		
		ctx.render("auth, authRequest="+authRequest);
		
		block.execute();
		log.debug("end");
	}

}
