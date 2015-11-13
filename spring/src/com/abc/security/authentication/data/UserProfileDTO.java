package com.abc.security.authentication.data;

import java.io.Serializable;
import java.util.List;

/**
 * This DTO contains the information related to user profile. It contains user
 * information along with allocated roles.
 * 
 * <p>
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
public class UserProfileDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * the user id
	 */
	private String userId;
	/**
	 * password of the user.
	 */
	private String password;
	/**
	 * if the userid is active or not.
	 */
	private boolean active;

	/**
	 * roles available to the user
	 */
	List<String> roles;

	/**
	 * Creates a UserProfileDTO with <code>userId</code>,
	 * <code>password</code>, <code>active</code>, and <code>roles</code>
	 * params.
	 * 
	 * @param userId
	 * @param password
	 *            password of the user
	 * @param active
	 *            <code>true</code> if user is active.
	 * @param roles
	 *            roles available to the user
	 * 
	 */
	public UserProfileDTO(String userId, String password, boolean active,
			List<String> roles) {
		this.userId = userId;
		this.password = password;
		this.active = active;
		this.roles = roles;
	}

	/**
	 * Returns the userId
	 * 
	 * @return String
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the userId
	 * 
	 * @param userId
	 *            The userId to set.
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Returns the password
	 * 
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password
	 * 
	 * @param password
	 *            The password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Returns the active
	 * 
	 * @return boolean
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Sets the active
	 * 
	 * @param active
	 *            The active to set.
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Returns the roles
	 * 
	 * @return List<String>
	 */
	public List<String> getRoles() {
		return roles;
	}

	/**
	 * Sets the roles
	 * 
	 * @param roles
	 *            The roles to set.
	 */
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}