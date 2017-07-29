package org.aivan.ratauth.dao;

import org.aivan.ratauth.domain.Token;

public interface AuthDao {

	Token loadToken(String token);

}