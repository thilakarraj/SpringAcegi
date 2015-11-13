package com.abc.security.authentication.dao;

import com.abc.security.ABCSecurityException;
import com.abc.security.authentication.data.AuthenticationResponse;

/**
 * This DAO is used for user authentication. Depending upon various data access
 * mechanisms (XML, database etc), it's implemented in different ways.
 * 
 * <DL>
 * <DT><B>History: </B>
 * <DD>Sep 15, 2007</DD>
 * </DL>
 * 
 * @author ShriKant
 * @version 1.0, Sep 15, 2007
 * 
 * @since v1.0, Sep 15, 2007
 * 
 */
public interface UserAuthenticationDAO {

	/**
	 * Performs authentication based on passed <code>userid</code> and
	 * <code>password</code> information.
	 * 
	 * @param userId
	 *            the user id
	 * @param password
	 *            password for the user
	 * @return <code>AuthenticationResponse</code> a response containing
	 *         authentication status and user profile information.
	 * @throws ABCSecurityException
	 * 
	 * 
	 */
	AuthenticationResponse authenticateUser(String userId, String password)
			throws ABCSecurityException;

}