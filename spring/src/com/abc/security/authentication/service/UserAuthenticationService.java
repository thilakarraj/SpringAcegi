package com.abc.security.authentication.service;

import com.abc.security.ABCSecurityException;
import com.abc.security.authentication.data.AuthenticationResponse;

/**
 * A business service to authenticate the user.
 * 
 * <DL>
 * <DT><B>History: </B>
 * <DD>Sep 26, 2007</DD>
 * </DL>
 * 
 * @author ShriKant
 * @version 1.0, Sep 26, 2007
 * 
 * @since v1.0, Sep 26, 2007
 * 
 */
public interface UserAuthenticationService {
	/**
	 * Performs authentication based on passed <code>userId</code> and
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
	 */
	AuthenticationResponse authenticateUser(String userId, String password)
			throws ABCSecurityException;
}
