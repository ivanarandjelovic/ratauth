package org.aivan.ratauth.domain;

import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

public class Token {
	String id;
	String token;
	Date expires;
	List<String> scopes;
	String userId;

	/**
	 * Constructor from BSON document
	 * 
	 * @param document
	 *            BSON document
	 */
	@SuppressWarnings("unchecked")
	public Token(Document document) {
		if (document != null) {
			ObjectId oId = document.getObjectId("_id");
			if (oId != null) {
				this.id = document.getObjectId("_id").toHexString();
			}
			this.token = document.getString("token");
			this.expires = document.getDate("expires");
			this.scopes = (List<String>) document.get("scopes");
			ObjectId userId = document.getObjectId("userId");
			if (userId != null) {
				this.userId = userId.toHexString();
			}
		}
	}

	public String getId() {
		return id;
	}

	public Date getExpires() {
		return expires;
	}

	public List<String> getScopes() {
		return scopes;
	}

	public String getUserId() {
		return userId;
	}

	public String getToken() {
		return token;
	}

}
