package org.aivan.ratauth.handlers.request;

import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class AuthorizeRequest {

	String clientId;
	String redirectUri;
	String responseType;
	String scope;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	
	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public static AuthorizeRequest loadFrom(Map<String, String> map) {
		AuthorizeRequest request = new AuthorizeRequest();

		request.clientId = map.get("client_id");
		request.redirectUri = map.get("redirect_uri");
		request.responseType = map.get("response_type");
		request.scope = map.get("scope");
		
		return request;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).
			       append("clientId", clientId).
			       append("redirectUri", redirectUri).
			       append("responseType", responseType).
			       append("scope", scope).
			       toString();
	}
	
	
}
