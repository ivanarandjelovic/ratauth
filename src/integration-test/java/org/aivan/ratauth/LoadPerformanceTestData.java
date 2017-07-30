package org.aivan.ratauth;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;

import org.aivan.ratauth.dao.Util;
import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class LoadPerformanceTestData {

	private static long RECORD_COUNT = 1000000L;

	static NumberFormat idFormat = new DecimalFormat("000000000000000000000000");

	static MongoClient mongoClient;
	protected static MongoDatabase database;

	public static void main(String[] args) throws IOException {
		mongoClient = Util.newMongoClient();
		database = mongoClient.getDatabase("ratauth");
		loadClients();
		loadUsers();
		loadTokens();
		mongoClient.close();
	}

	private static void loadTokens() {
		MongoCollection<Document> collection = database.getCollection("token");
		for (long i = 0; i < RECORD_COUNT; i++) {
			Document doc = new Document();
			doc.put("_id", new ObjectId(idFormat.format(i)));
			doc.put("token", "token_" + i);
			if(i< (RECORD_COUNT/2)) {
				doc.put("expires", new Date(System.currentTimeMillis() - 100L));
			} else {
				doc.put("expires", new Date(System.currentTimeMillis() + 100000000000L));
			}
			doc.put("scopes", new ArrayList<String>());
			doc.put("userId", new ObjectId(idFormat.format(i)));
			collection.insertOne(doc);
		}
	}

	private static void loadUsers() {
		MongoCollection<Document> collection = database.getCollection("user");
		for (long i = 0; i < RECORD_COUNT; i++) {
			Document doc = new Document();
			doc.put("_id", new ObjectId(idFormat.format(i)));
			doc.put("username", "username_" + i);
			doc.put("password", "password_" + i);
			collection.insertOne(doc);
		}

	}

	private static void loadClients() {
		MongoCollection<Document> collection = database.getCollection("client");
		for (long i = 0; i < RECORD_COUNT; i++) {
			Document doc = new Document();
			doc.put("name", "name_" + i);
			doc.put("website", "website_" + i);
			doc.put("redirectUri", "redirectUri_" + i);
			doc.put("clientId", "clientId_" + i);
			collection.insertOne(doc);
		}

	}

}
