package org.aivan.ratauth.dao;

import static com.mongodb.client.model.Filters.eq;

import java.io.IOException;

import org.aivan.ratauth.domain.Token;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDAO implements AuthDao {

	static Logger log = LoggerFactory.getLogger(MongoDAO.class);
	
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
