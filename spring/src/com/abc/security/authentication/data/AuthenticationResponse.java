package com.abc.security.authentication.data;

import java.io.Serializable;

/**
 * This class contains the data returned as a result of authentication process.
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
public class AuthenticationResponse implements Serializable {

	private static final long serialVersionUID = 1612657863838023154L;
	/**
	 * authentication status
	 */
	int authStatus;
	/**
	 * user profile information of the authenticated user.
	 */
	UserProfileDTO userDetails;

	/**
	 * Creates a AuthenticationResponse with <code>authStatus</code> and
	 * <code>userDetails</code> params.
	 * 
	 * @param authStatus
	 * @param userDetails
	 * 
	 */
	public AuthenticationResponse(int authStatus, UserProfileDTO userDetails) {
		this.authStatus = authStatus;
		this.userDetails = userDetails;
	}

	/**
	 * Returns the authStatus
	 * 
	 * @return int
	 */
	public int getAuthStatus() {
		return authStatus;
	}

	/**
	 * Sets the authStatus
	 * 
	 * @param authStatus
	 *            The authStatus to set.
	 */
	public void setAuthStatus(int authStatus) {
		this.authStatus = authStatus;
	}

	/**
	 * Returns the userDetails
	 * 
	 * @return UserProfileDTO
	 */
	public UserProfileDTO getUserDetails() {
		return userDetails;
	}

	/**
	 * Sets the userDetails
	 * 
	 * @param userDetails
	 *            The userDetails to set.
	 */
	public void setUserDetails(UserProfileDTO userDetails) {
		this.userDetails = userDetails;
	}
}
