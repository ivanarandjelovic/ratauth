package org.aivan.ratauth.handlers;

import java.util.Date;

import org.aivan.ratauth.dao.AuthAsyncDao;
import org.aivan.ratauth.dao.AuthSyncDao;
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
		Request req = ctx.getRequest();

		VerifyRequest verifyRequest = VerifyRequest.loadFrom(req.getQueryParams());

		AuthAsyncDao dao = ctx.get(AuthAsyncDao.class);

		dao.loadToken(verifyRequest.getToken()).then(token -> {
			// existing token with valid date is OK, anything else is bad
			if (token != null && token.getExpires() != null
					&& token.getExpires().after(new Date(System.currentTimeMillis()))) {
				ctx.getResponse().status(200).send();
			} else {
				ctx.getResponse().status(400).send();
			}
		});
	}

}
