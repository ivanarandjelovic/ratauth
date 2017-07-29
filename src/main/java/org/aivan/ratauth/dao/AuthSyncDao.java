package org.aivan.ratauth.dao;

import org.aivan.ratauth.domain.Token;

/**
 * Synchronous DAO
 * 
 * @author aivan
 *
 */
public interface AuthSyncDao {

	Token loadToken(String token);

}