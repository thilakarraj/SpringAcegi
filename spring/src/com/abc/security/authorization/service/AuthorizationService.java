package com.abc.security.authorization.service;

import java.util.List;

import com.abc.security.authorization.data.SecureResource;
import com.abc.security.authorization.data.Role;

public interface AuthorizationService {

	SecureResource getSecureObject(String secObjectName);

	List<Role> getSecureObjectRoles(SecureResource secureObject);

}
