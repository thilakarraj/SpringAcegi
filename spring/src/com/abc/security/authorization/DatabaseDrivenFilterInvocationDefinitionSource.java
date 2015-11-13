package com.abc.security.authorization;

import java.util.Iterator;
import java.util.List;

import org.acegisecurity.ConfigAttributeDefinition;
import org.acegisecurity.ConfigAttributeEditor;
import org.acegisecurity.intercept.web.AbstractFilterInvocationDefinitionSource;

import com.abc.security.authorization.data.SecureResource;
import com.abc.security.authorization.data.Role;
import com.abc.security.authorization.service.AuthorizationService;

/**
 * This <code>FilterInvocationDefinitionSource</code> implementation uses
 * database and in turn is used for dynamic authorization.
 * 
 * <DL>
 * <DT><B>History: </B>
 * <DD>Sep 13, 2007</DD>
 * </DL>
 * 
 * @author ShriKant
 * @version 1.0, Sep 26, 2007
 * 
 * @since v1.0, Sep 26, 2007
 * 
 */
public class DatabaseDrivenFilterInvocationDefinitionSource extends
		AbstractFilterInvocationDefinitionSource {

	/**
	 * TODO Comment for <code>authorizationService</code>
	 */
	AuthorizationService authorizationService;

	@Override
	public ConfigAttributeDefinition lookupAttributes(String url) {

		// Strip anything after a question mark symbol, as per SEC-161. See also
		// SEC-321
		int firstQuestionMarkIndex = url.indexOf("?");

		if (firstQuestionMarkIndex != -1) {
			url = url.substring(0, firstQuestionMarkIndex);
		}
		SecureResource secureObject = authorizationService.getSecureObject(url);
		if (secureObject == null)// if secure object not exist in database
			return null;
		// retrieving roles associated with this secure object
		List<Role> secureObjectRoles = authorizationService
				.getSecureObjectRoles(secureObject);
		// creating ConfigAttributeDefinition
		if (secureObjectRoles != null && !secureObjectRoles.isEmpty()) {
			ConfigAttributeEditor configAttrEditor = new ConfigAttributeEditor();
			StringBuffer rolesStr = new StringBuffer();
			for (int i = 0; i < secureObjectRoles.size(); i++) {
				Role sor = (Role) secureObjectRoles.get(i);
				rolesStr.append(sor.getName()).append(",");
			}
			configAttrEditor.setAsText(rolesStr.toString().substring(0,
					rolesStr.length() - 1));
			ConfigAttributeDefinition configAttrDef = (ConfigAttributeDefinition) configAttrEditor
					.getValue();
			return configAttrDef;
		}
		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.acegisecurity.intercept.ObjectDefinitionSource#getConfigAttributeDefinitions()
	 */
	public Iterator getConfigAttributeDefinitions() {
		return null;
	}

	/**
	 * Sets the authorizationService
	 * 
	 * @param authorizationService
	 *            The authorizationService to set.
	 */
	public void setAuthorizationService(AuthorizationService authService) {
		this.authorizationService = authService;
	}

}
