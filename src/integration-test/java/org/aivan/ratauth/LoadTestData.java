package org.aivan.ratauth;

import java.io.IOException;

import org.aivan.ratauth.dao.BaseMongoDBTest;

public class LoadTestData {

	public static void main(String[] args) throws IOException {
		BaseMongoDBTest test = new BaseMongoDBTest();
		test.setup();
	}

}
