package org.aivan.ratauth.domain;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.aivan.ratauth.mongo.BaseMongoDBTest;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;
import static com.mongodb.client.model.Filters.*;
import static org.junit.Assert.*;

import com.mongodb.client.MongoCollection;

public class TokenIntegrationTest extends BaseMongoDBTest {

	MongoCollection<Document> tokenColl;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	
	@Before
	public void setup() throws IOException {
		super.setup();
		tokenColl = database.getCollection("token");
	}
	
	@Test
	public void loadToken() throws ParseException {
		Document doc = tokenColl.find(eq("token", "token_expired")).first();
		Token t = new Token(doc);
		assertNotNull(t);
		assertNotNull(t.getId());
		assertEquals("token_expired",t.getToken());
		assertEquals(sdf.parse("2017-01-30T01:02:03.004"),t.getExpires());
		assertEquals(1,t.getScopes().size());
		assertEquals("read",t.getScopes().get(0));
		assertEquals("5974dc2babff2d2642f16e41",t.getUserId());
	}
	
	@Test
	public void loadNonExistingToken() throws ParseException {
		Document doc = tokenColl.find(eq("token", "NON_EXISTING_TOKEN")).first();
		Token t = new Token(doc);
		assertNotNull(t);
		assertNull(t.getId());
		assertNull(t.getToken());
		assertNull(t.getExpires());
		assertNull(t.getScopes());
		assertNull(t.getUserId());
	}
}
