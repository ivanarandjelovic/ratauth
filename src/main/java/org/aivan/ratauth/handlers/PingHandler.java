package org.aivan.ratauth.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ratpack.func.Block;
import ratpack.handling.Context;

public class PingHandler extends RatauthHandler {

	static Logger log = LoggerFactory.getLogger(PingHandler.class);

	@Override
	public void ratAuthHandle(Context ctx, Block block) throws Exception {
		ctx.render("pong");
		block.execute();
	}

}
