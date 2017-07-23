package org.aivan.ratauth.handlers.request;

import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class VerifyRequest {

	String token;

	public String getToken() {
		return token;
	}

	public static VerifyRequest loadFrom(Map<String, String> map) {
		VerifyRequest request = new VerifyRequest();

		request.token = map.get("token");

		return request;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("token", token).toString();
	}

}
