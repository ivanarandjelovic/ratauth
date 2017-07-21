package org.aivan.ratauth.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.http.Request;
import ratpack.util.MultiValueMap;

public class AuthHandler implements Handler {

	static Logger log = LoggerFactory.getLogger(AuthHandler.class);

	@Override
	public void handle(Context ctx) throws Exception {
		log.debug("start");
		
		Request req = ctx.getRequest();
		MultiValueMap<String, String> params = req.getQueryParams();
		
		String responseType = params.get("response_type");
		
		ctx.render("auth, response_type="+responseType);
		
		log.debug("end");
	}

}
