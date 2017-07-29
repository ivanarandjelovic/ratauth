package org.aivan.ratauth.handlers;

import java.util.Date;

import org.aivan.ratauth.dao.AuthDao;
import org.aivan.ratauth.domain.Token;
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

		log.debug("pre get dao");
		AuthDao dao=null;
		try {
			dao = ctx.get(AuthDao.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug("got dao "+dao);
		
		Token token = dao.loadToken(verifyRequest.getToken());
		log.debug("token="+token);

		// existing token with valid date is OK, anything else is bad
		if (token != null && token.getExpires() != null
				&& token.getExpires().after(new Date(System.currentTimeMillis()))) {
			ctx.getResponse().status(200).send();
			log.debug("token VALID response 200");
		} else {
			ctx.getResponse().status(400).send();
			log.debug("token INVALID response 400");
		}

		log.debug("end");
	}

}
