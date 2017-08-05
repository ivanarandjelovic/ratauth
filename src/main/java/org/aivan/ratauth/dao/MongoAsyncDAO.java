package org.aivan.ratauth.dao;

import static com.mongodb.client.model.Filters.eq;

import org.aivan.ratauth.domain.Token;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.async.client.FindIterable;
import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoCollection;
import com.mongodb.async.client.MongoDatabase;

import ratpack.exec.Promise;

public class MongoAsyncDAO implements AuthAsyncDao {

	static Logger log = LoggerFactory.getLogger(MongoAsyncDAO.class);

	MongoClient mongoClient;
	protected MongoDatabase database;
	MongoCollection<Document> tokenColl;

	public MongoAsyncDAO(MongoClient mongoClient) {
		super();
		database = mongoClient.getDatabase("ratauth");
		tokenColl = database.getCollection("token");
		log.warn("Created");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aivan.ratauth.mongo.AuthDao#loadToken(java.lang.String)
	 */
	@Override
	public Promise<Token> loadToken(String token) {
		FindIterable<Document> find = tokenColl.find(eq("token", token));
		return Promise.async(down -> {
			find.first( (res,t) -> {
				if(t==null) {
					down.success(new Token(res));
				} else {
					down.error(t);
				}
			});
		}
		);
	}
}
