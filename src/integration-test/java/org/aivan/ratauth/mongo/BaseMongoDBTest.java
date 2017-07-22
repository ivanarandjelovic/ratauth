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
	MongoCollection<Document> clientCollection;

	@Before
	public void setup() throws IOException {
		// Load the data before the test
		mongoClient = new MongoClient();
		database = mongoClient.getDatabase("ratauth");
		clientCollection = database.getCollection("client");

		boolean clientFileFound = true;
		int counter = 0;
		while (clientFileFound) {
			try (InputStream is = this.getClass().getClassLoader()
					.getResourceAsStream("data/client" + counter + ".json")) {
				if (is == null) {
					clientFileFound = false;
				} else {
					try (Scanner scan = new Scanner(is)) {
						String json = scan.useDelimiter("\\Z").next();
						Document client = Document.parse(json);
						clientCollection.insertOne(client);
					}
					counter++;
				}
			}
		}
	}

	@After
	public void teardown() {
		// Delete all the data from the database
		clientCollection.drop();
		mongoClient.close();
	}

	@Test
	public void dummy() {
		assertTrue(true);
	}

}
