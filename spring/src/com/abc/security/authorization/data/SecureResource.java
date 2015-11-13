/**
 * 
 */
package com.abc.security.authorization.data;

import java.io.Serializable;

import org.apache.commons.lang.builder.CompareToBuilder;

/**
 * Contains the information of a secured resource. They can be of two types. One
 * for filter invocation and another for method invocation.
 * 
 * <DL>
 * <DT><B>History: </B>
 * <DD>Sep 15, 2007</DD>
 * </DL>
 * 
 * @author ShriKant
 * @version 1.0, Sep 26, 2007
 * 
 * @since v1.0, Sep 26, 2007
 * 
 */
public class SecureResource implements Serializable, Comparable<SecureResource> {

	private static final long serialVersionUID = 1L;

	/**
	 * name of secured resource
	 */
	String resourceName;

	/**
	 * type of secured resource. One for function invocation and another for
	 * method invocation.
	 */
	String type;

	/**
	 * Returns the resourceName
	 * 
	 * @return String
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * Sets the resourceName
	 * 
	 * @param resourceName
	 *            The resourceName to set.
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	/**
	 * Returns the type
	 * 
	 * @return String
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type
	 * 
	 * @param type
	 *            The type to set.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Creates a SecureResource with <code>resourceName</code> and
	 * <code>type</code> params.
	 * 
	 * @param resourceName
	 *            secured resource. It can be URL or method name.
	 * @param type
	 *            there can be two types. "FI" for filter invocation and "MI"
	 *            for method invocation.
	 */
	public SecureResource(String resourceName, String type) {
		this.resourceName = resourceName;
		this.type = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(SecureResource o) {
		return CompareToBuilder.reflectionCompare(this, o);
	}
}
