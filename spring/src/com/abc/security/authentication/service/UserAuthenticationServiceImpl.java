package com.abc.security.authentication.service;

import com.abc.security.ABCSecurityException;
import com.abc.security.authentication.dao.UserAuthenticationDAO;
import com.abc.security.authentication.data.AuthenticationResponse;

/**
 * It uses <code>UserAuthenticationDAO</code> for authentication.
 *
 * <DL>
 * <DT><B>History: </B>
 * <DD>Aug 31, 2007</DD>
 * </DL>
 * 
 * @author ShriKant
 * @version 1.0, Sep 26, 2007
 * 
 * @since v1.0, Sep 26, 2007
 * 
 */
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

	private UserAuthenticationDAO authenticationDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.abc.security.authentication.service.UserAuthenticationService#authenticateUser(java.lang.String,
	 *      java.lang.String)
	 */
	public AuthenticationResponse authenticateUser(String userId,
			String password) throws ABCSecurityException {
		return authenticationDAO.authenticateUser(userId, password);
	}

	/**
	 * Sets the authenticationDAO
	 * 
	 * @param authenticationDAO
	 *            The authenticationDAO to set.
	 */
	public void setAuthenticationDAO(UserAuthenticationDAO authenticationDAO) {
		this.authenticationDAO = authenticationDAO;
	}

}