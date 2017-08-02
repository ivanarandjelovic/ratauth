package org.aivan.ratauth.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ratpack.handling.Context;
import ratpack.handling.Handler;

public abstract class RatauthHandler implements Handler {

	static long activeRequestsCounter = 0;
	static long maxActiveRequestsCounter = 0;
	
	static Logger log = LoggerFactory.getLogger(RatauthHandler.class);
	
	protected synchronized static void startRequest() {
		activeRequestsCounter++;
		if(maxActiveRequestsCounter<activeRequestsCounter) {
			maxActiveRequestsCounter=activeRequestsCounter;
			log.warn("Maximum active requests = "+maxActiveRequestsCounter);
		}
	}
	
	
	
	@Override
	public void handle(Context ctx) throws Exception {
		startRequest();
		ratAuthHandle(ctx);
		endRequest();
		
	}



	protected abstract void ratAuthHandle(Context ctx) throws Exception;

	protected synchronized static void endRequest() {
		activeRequestsCounter--;
	}
}
