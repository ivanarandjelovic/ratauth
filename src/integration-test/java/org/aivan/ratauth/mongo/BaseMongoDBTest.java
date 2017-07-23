package org.aivan.ratauth.mongo;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class BaseMongoDBTest {

	MongoClient mongoClient;
	MongoDatabase database;
	String[] collectionNames = new String[] { "client", "user", "token" };

	@Before
	public void setup() throws IOException {
		// Load the data before the test
		mongoClient = new MongoClient();
		database = mongoClient.getDatabase("ratauth");
		for (String collectionName : collectionNames) {
			loadCollection(collectionName);
		}
	}

	private void loadCollection(String collectionName) throws IOException {
		MongoCollection<Document> collection = database.getCollection(collectionName);

		boolean clientFileFound = true;
		int counter = 0;
		while (clientFileFound) {
			try (InputStream is = this.getClass().getClassLoader()
					.getResourceAsStream("data/" + collectionName + counter + ".json")) {
				if (is == null) {
					clientFileFound = false;
				} else {
					try (Scanner scan = new Scanner(is)) {
						String json = scan.useDelimiter("\\Z").next();
						Document client = Document.parse(json);
						collection.insertOne(client);
					}
					counter++;
				}
			}
		}
	}

	@After
	public void teardown() throws IOException {
		// Delete all the data from the database
		for (String collectionName : collectionNames) {
			dropCollection(collectionName);
		}
		mongoClient.close();
	}

	private void dropCollection(String collectionName) throws IOException {
		MongoCollection<Document> collection = database.getCollection(collectionName);
		collection.drop();
	}

	@Test
	public void dummy() {
		assertTrue(true);
	}

}
