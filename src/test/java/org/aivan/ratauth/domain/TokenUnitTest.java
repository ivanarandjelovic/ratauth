package org.aivan.ratauth.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.Test;

public class TokenUnitTest {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

	@Test
	public void fromNullDocumemt() {
		Token t = new Token(null);
		assertNotNull(t);
		assertNull(t.getId());
		assertNull(t.getToken());
		assertNull(t.getExpires());
		assertNull(t.getScopes());
		assertNull(t.getUserId());
	}
	
	@Test
	public void fromDocumemt() throws ParseException {
		Document doc = new Document();
		doc.put("_id", new ObjectId("5974dc2babff2d2642f16e41"));
		doc.put("token", "token");
		doc.put("expires", sdf.parse("2017-01-30T01:02:03.004"));
		doc.put("scopes", new ArrayList<String>());
		doc.put("userId", new ObjectId("5974dc2babff2d2642f16e42"));
		Token t = new Token(doc);
		assertNotNull(t);
		assertEquals("5974dc2babff2d2642f16e41", t.getId());
		assertEquals("token",t.getToken());
		assertEquals(sdf.parse("2017-01-30T01:02:03.004"),t.getExpires());
		assertEquals(0,t.getScopes().size());
		assertEquals("5974dc2babff2d2642f16e42",t.getUserId());
	}
}
