package org.aivan.ratauth.dao;

import org.aivan.ratauth.domain.Token;

import ratpack.exec.Promise;

/**
 * Asynchronous DAO
 * 
 * @author aivan
 *
 */
public interface AuthAsyncDao {

	Promise<Token> loadToken(String token);

}