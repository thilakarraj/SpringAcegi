package com.abc.security.authorization.service;

import java.util.List;

import com.abc.security.authorization.dao.AuthorizationDAO;
import com.abc.security.authorization.data.Role;
import com.abc.security.authorization.data.SecureResource;

public class AuthorizationServiceImpl implements AuthorizationService {

	AuthorizationDAO authDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.abc.security.authorization.service.AuthorizationService#getSecureObject(java.lang.String)
	 */
	public SecureResource getSecureObject(String secObjectName) {
		return authDAO.getSecureObject(secObjectName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.abc.security.authorization.service.AuthorizationService#getSecureObjectRoles(com.abc.security.authorization.data.SecureResource)
	 */
	public List<Role> getSecureObjectRoles(SecureResource secureObject) {
		return authDAO.getSecureObjectRoles(secureObject);
	}

	/**
	 * Sets the authDAO
	 * 
	 * @param authDAO
	 *            The authDAO to set.
	 */
	public void setAuthDAO(AuthorizationDAO authDAO) {
		this.authDAO = authDAO;
	}
}
