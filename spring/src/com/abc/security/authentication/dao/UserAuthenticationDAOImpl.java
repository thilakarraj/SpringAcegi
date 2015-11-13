package com.abc.security.authentication.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.abc.security.ABCSecurityException;
import com.abc.security.SecurityConstants;
import com.abc.security.authentication.data.AuthenticationResponse;
import com.abc.security.authentication.data.UserProfileDTO;

/**
 * 
 * This <code>UserAuthenticationDAO</code> implementation uses data available
 * in memory to authenticate the user.
 * 
 * <DL>
 * <DT><B>History: </B>
 * <DD>Aug 31, 2007</DD>
 * </DL>
 * 
 * @author ShriKant
 * @version 1.0, Aug 31, 2007
 * 
 * @since v1.0, Aug 31, 2007
 * 
 */
public class UserAuthenticationDAOImpl implements UserAuthenticationDAO {
	private Map<String, UserProfileDTO> users = new HashMap<String, UserProfileDTO>();

	/**
	 * Creates a default <code>UserAuthenticationDAOImpl</code> object.
	 */
	public UserAuthenticationDAOImpl() {
		initUsers();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.abc.security.authentication.dao.UserAuthenticationDAO#authenticateUser(java.lang.String,
	 *      java.lang.String)
	 */
	public AuthenticationResponse authenticateUser(String userId,
			String password) throws ABCSecurityException {
		UserProfileDTO user = users.get(userId);
		if (user == null)
			throw new ABCSecurityException("User " + userId + " doesn't exist");
		AuthenticationResponse response = null;
		if (password.equals(password) && user.isActive()) {
			response = new AuthenticationResponse(
					SecurityConstants.AUTHENTICATION_SUCCESS, user);
		}
		return response;
	}

	private void initUsers() {
		UserProfileDTO user;
		List<String> roles = new ArrayList<String>();
		roles.add("ROLE_TECHNICIAN");
		user = new UserProfileDTO("james", "tom@1231", true, roles);
		users.put(user.getUserId(), user);

		roles = new ArrayList<String>();
		roles.add("ROLE_TECHNICIAN");
		user = new UserProfileDTO("krishna", "krish2341", true, roles);
		users.put(user.getUserId(), user);

		roles = new ArrayList<String>();
		roles.add("ROLE_ADMIN");
		user = new UserProfileDTO("smith", "pravah@001", true, roles);
		users.put(user.getUserId(), user);
	}
}
