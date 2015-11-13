package com.abc.security.authorization.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.abc.security.SecurityConstants;
import com.abc.security.authorization.data.SecureResource;
import com.abc.security.authorization.data.Role;

public class AuthorizationDAOImpl implements AuthorizationDAO {

	/**
	 * TODO Comment for <code>secObjects</code>
	 */
	private Map<String, SecureResource> secObjects = new HashMap<String, SecureResource>();

	/**
	 * TODO Comment for <code>secObjectToRoles</code>
	 */
	private Map<SecureResource, List<Role>> secObjectToRoles = new HashMap<SecureResource, List<Role>>();

	/**
	 * Creates a default <code>AuthorizationDAOImpl instance.
	 *
	 */
	public AuthorizationDAOImpl() {
		initAuthorizationInfo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.abc.security.authorization.dao.AuthorizationDAO#getSecureObject(java.lang.String)
	 */
	public SecureResource getSecureObject(String secObjectName) {
		return secObjects.get(secObjectName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.abc.security.authorization.dao.AuthorizationDAO#getSecureObjectRoles(com.abc.security.authorization.data.SecureResource)
	 */
	public List<Role> getSecureObjectRoles(SecureResource secureObject) {
		return secObjectToRoles.get(secureObject);
	}

	private void initAuthorizationInfo() {
		Role adminRole = new Role("ROLE_ADMIN", "Adminstrator role");
		Role technicianRole = new Role("ROLE_TECHNICIAN", "Technician role");
		Role anonRole = new Role("ROLE_ANONYMOUS", "Anonymous role");

		SecureResource secObject = new SecureResource("/index.jsp", SecurityConstants.RESOURCE_TYPE_FI);
		secObjects.put("/index.jsp", secObject);
		List<Role> roles = new ArrayList<Role>();
		roles.add(adminRole);
		roles.add(technicianRole);
		secObjectToRoles.put(secObject, roles);

		secObject = new SecureResource("/order/createOrder.jsp", SecurityConstants.RESOURCE_TYPE_FI);
		secObjects.put("/order/createOrder.jsp", secObject);
		roles = new ArrayList<Role>();
		roles.add(technicianRole);
		secObjectToRoles.put(secObject, roles);

		secObject = new SecureResource("/order/authorizeOrder.jsp", SecurityConstants.RESOURCE_TYPE_FI);
		secObjects.put("/order/authorizeOrder.jsp", secObject);
		roles = new ArrayList<Role>();
		roles.add(adminRole);
		secObjectToRoles.put(secObject, roles);

		secObject = new SecureResource("/login.jsp", SecurityConstants.RESOURCE_TYPE_FI);
		secObjects.put("/login.jsp", secObject);
		roles = new ArrayList<Role>();
		roles.add(technicianRole);
		roles.add(adminRole);
		roles.add(anonRole);
		secObjectToRoles.put(secObject, roles);
	}
}