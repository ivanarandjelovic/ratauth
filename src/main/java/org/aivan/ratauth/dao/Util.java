package org.aivan.ratauth.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.mongodb.MongoClient;
import com.mongodb.async.client.MongoClients;

public class Util {

	private Util() {
		// static methods only!
	}

	public static com.mongodb.async.client.MongoClient newMongoAsyncClient() throws IOException {

		Properties appProps = loadApplicationProperties();

		String hostname = getMongoHostname(appProps);
		int port = getMongoPort(appProps);

		return MongoClients.create("mongodb://" + hostname + ":" + port);
	}

	public static MongoClient newMongoClient() throws IOException {

		Properties appProps = loadApplicationProperties();

		String hostname = getMongoHostname(appProps);
		int port = getMongoPort(appProps);

		return new MongoClient(hostname, port);
	}

	static int getMongoPort(Properties appProps) {
		int port = 27017;
		String newPort = appProps.getProperty("mongo_port");
		if (newPort != null) {
			port = Integer.parseInt(newPort);
		}
		return port;
	}

	static String getMongoHostname(Properties appProps) {
		String hostname = "localhost";
		String newHostname = appProps.getProperty("mongo_hostname");
		if (newHostname != null) {
			hostname = newHostname;
		}
		return hostname;
	}

	static Properties loadApplicationProperties() throws IOException {
		// Load the data before the test
		Properties appProps = new Properties();
		try (InputStream is = Util.class.getClassLoader().getResourceAsStream("app.properties")) {
			if (is != null) {
				appProps.load(is);
			}
		}
		return appProps;
	}

}
