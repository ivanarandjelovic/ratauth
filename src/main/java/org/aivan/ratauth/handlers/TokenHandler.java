package org.aivan.ratauth.handlers;

import org.aivan.ratauth.handlers.request.TokenRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ratpack.func.Block;
import ratpack.handling.Context;
import ratpack.http.Request;

public class TokenHandler extends RatauthHandler {

	static Logger log = LoggerFactory.getLogger(TokenHandler.class);

	@Override
	public void ratAuthHandle(Context ctx, Block block) throws Exception {
		log.debug("start");

		Request req = ctx.getRequest();

		TokenRequest tokenRequest = TokenRequest.loadFrom(req.getQueryParams());

		ctx.render("token, tokenRequest=" + tokenRequest);

		block.execute();
		log.debug("end");
	}

}
