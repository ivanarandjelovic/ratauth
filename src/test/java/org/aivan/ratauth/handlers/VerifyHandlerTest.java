package org.aivan.ratauth.handlers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.aivan.ratauth.dao.AuthSyncDao;
import org.aivan.ratauth.domain.Token;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ratpack.test.handling.HandlingResult;
import ratpack.test.handling.RequestFixture;

public class VerifyHandlerTest {

	static Logger log = LoggerFactory.getLogger(VerifyHandlerTest.class);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	
	@Test
	public void responseNoParams() throws Exception {
		HandlingResult result = RequestFixture.handle(new VerifyHandler(), fixture -> {
			fixture.registry(reg -> {
				reg.add(mock(AuthSyncDao.class));
			});
			fixture.uri("/verify");
		});
		assertEquals(400, result.getStatus().getCode());
	}

	@Test
	public void responseWithParams() throws Exception {
		HandlingResult result = RequestFixture.handle(new VerifyHandler(), fixture -> {
			fixture.registry(reg -> {
				reg.add(mock(AuthSyncDao.class));
			});
			fixture.uri("/verify?token=1");
		});
		assertEquals(400, result.getStatus().getCode());
	}
	
	@Test
	public void responseForGoodToken() throws Exception {
		HandlingResult result = RequestFixture.handle(new VerifyHandler(), fixture -> {
			fixture.registry(reg -> {
				AuthSyncDao dao = mock(AuthSyncDao.class);
				Document doc = new Document();
				doc.put("_id", new ObjectId("5974dc2babff2d2642f16e41"));
				doc.put("token", "token");
				doc.put("expires", new Date(System.currentTimeMillis()+10000000000L));
				doc.put("scopes", new ArrayList<String>());
				doc.put("userId", new ObjectId("5974dc2babff2d2642f16e42"));
				Token token = new Token(doc);
				when(dao.loadToken(any())).thenReturn(token);
				reg.add(dao);
			});
			fixture.uri("/verify?token=whatever");
		});
		assertEquals(200, result.getStatus().getCode());
	}
	
	@Test
	public void responseForExpiredToken() throws Exception {
		HandlingResult result = RequestFixture.handle(new VerifyHandler(), fixture -> {
			fixture.registry(reg -> {
				AuthSyncDao dao = mock(AuthSyncDao.class);
				Document doc = new Document();
				doc.put("_id", new ObjectId("5974dc2babff2d2642f16e41"));
				doc.put("token", "token");
				doc.put("expires", new Date(System.currentTimeMillis()-1L));
				doc.put("scopes", new ArrayList<String>());
				doc.put("userId", new ObjectId("5974dc2babff2d2642f16e42"));
				Token token = new Token(doc);
				when(dao.loadToken(any())).thenReturn(token);
				reg.add(dao);
			});
			fixture.uri("/verify?token=whatever");
		});
		assertEquals(400, result.getStatus().getCode());
	}
	
	@Test
	public void responseForEmptyToken() throws Exception {
		HandlingResult result = RequestFixture.handle(new VerifyHandler(), fixture -> {
			fixture.registry(reg -> {
				AuthSyncDao dao = mock(AuthSyncDao.class);
				Document doc = new Document();
				Token token = new Token(doc);
				when(dao.loadToken(any())).thenReturn(token);
				reg.add(dao);
			});
			fixture.uri("/verify?token=whatever");
		});
		assertEquals(400, result.getStatus().getCode());
	}

}
