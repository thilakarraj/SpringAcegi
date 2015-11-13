package com.abc.security.authorization.dao;

import java.util.List;

import com.abc.security.authorization.data.SecureResource;
import com.abc.security.authorization.data.Role;

public interface AuthorizationDAO {

	SecureResource getSecureObject(String secObjectName);

	List<Role> getSecureObjectRoles(SecureResource secureObject);

}
