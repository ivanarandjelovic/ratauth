package org.aivan.ratauth.dao;

import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.eq;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.text.ParseException;

import org.aivan.ratauth.domain.Token;
import org.aivan.ratauth.domain.TokenTest;

public class MongoDAOTest {

	MongoSyncDAO dao;
	
	MongoClient mongoClient;
	MongoDatabase database;
	MongoCollection<Document> tokenColl;

	@SuppressWarnings("unchecked")
	@Before
	public void setup() {
		mongoClient = mock(MongoClient.class);
		database = mock(MongoDatabase.class);
		tokenColl = mock(MongoCollection.class);
		when(mongoClient.getDatabase(any())).thenReturn(database);
		when(database.getCollection(any())).thenReturn(tokenColl);
		
		dao = new MongoSyncDAO(mongoClient);
	}

	@Test
	public void loadNonExistingToken() {
		@SuppressWarnings("unchecked")
		FindIterable<Document> findResult = mock(FindIterable.class);
		when(tokenColl.find(eq("token", any()))).thenReturn(findResult);
		when(findResult.first()).thenReturn(null);

		Token t = dao.loadToken("xx");
		assertNotNull(t);
		assertNull(t.getExpires());
		assertNull(t.getId());
		assertNull(t.getScopes());
		assertNull(t.getToken());
		assertNull(t.getUserId());
	}
	
	@Test
	public void loadExistingToken() throws ParseException {
		@SuppressWarnings("unchecked")
		FindIterable<Document> findResult = mock(FindIterable.class);
		when(tokenColl.find(eq("token", any()))).thenReturn(findResult);
		when(findResult.first()).thenReturn(TokenTest.createDocumentForToken());

		Token t = dao.loadToken("xx");
		TokenTest.validateToken(t);
	}
	
}
