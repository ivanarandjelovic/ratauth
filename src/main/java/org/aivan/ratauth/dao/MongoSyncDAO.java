package org.aivan.ratauth.dao;

import static com.mongodb.client.model.Filters.eq;

import org.aivan.ratauth.domain.Token;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoSyncDAO implements AuthSyncDao {

	static Logger log = LoggerFactory.getLogger(MongoSyncDAO.class);
	
	MongoClient mongoClient;
	protected MongoDatabase database;
	MongoCollection<Document> tokenColl;

	public MongoSyncDAO(MongoClient mongoClient) {
		super();
		database = mongoClient.getDatabase("ratauth");
		tokenColl = database.getCollection("token");
		log.warn("Created");
	}

	/* (non-Javadoc)
	 * @see org.aivan.ratauth.mongo.AuthDao#loadToken(java.lang.String)
	 */
	@Override
	public Token loadToken(String token) {
		Document tokenDoc = tokenColl.find(eq("token", token)).first();
		log.debug("Document for token="+token+", ="+tokenDoc);
		return new Token(tokenDoc);
	}
}
