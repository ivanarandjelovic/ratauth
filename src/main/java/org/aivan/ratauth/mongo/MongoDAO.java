package org.aivan.ratauth.mongo;

import static com.mongodb.client.model.Filters.eq;

import java.io.IOException;

import org.aivan.ratauth.domain.Token;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDAO {

	MongoClient mongoClient;
	protected MongoDatabase database;
	MongoCollection<Document> tokenColl;

	public MongoDAO() {
		super();
		try {
			mongoClient = Util.newMongoClient();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		database = mongoClient.getDatabase("ratauth");
		tokenColl = database.getCollection("token");
	}

	public Token loadToken(String token) {
		Document tokenDoc = tokenColl.find(eq("token", token)).first();
		return new Token(tokenDoc);
	}
}
