package org.aivan.ratauth.handlers.request;

import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class TokenRequest {

	String clientId;
	String clientSecret;
	String grantType;
	String redirectUri;
	String code;
	String username;
	String password;
	String refreshToken;

	public String getClientId() {
		return clientId;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public String getGrantType() {
		return grantType;
	}

	public String getCode() {
		return code;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public static TokenRequest loadFrom(Map<String, String> map) {
		TokenRequest request = new TokenRequest();

		request.clientId = map.get("client_id");
		request.clientSecret = map.get("client_secret");
		request.grantType = map.get("garnt_type");
		request.redirectUri = map.get("redirect_uri");
		request.code = map.get("code");
		request.username = map.get("username");
		request.password = map.get("password");
		request.refreshToken = map.get("refresh_token");

		return request;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("clientId", clientId).append("clientSecret", clientSecret)
				.append("grantType", grantType).append("redirectUri", redirectUri).append("code", code)
				.append("username", username).append("password", password).append("refreshToken", refreshToken)
				.toString();
	}

}
