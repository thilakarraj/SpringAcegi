/**
 * 
 */
package com.abc.security.authorization.data;

/**
 * A data abstraction for security role.
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
public class Role {

	/**
	 * name of the role.
	 */
	String name;

	/**
	 * description of the role.
	 */
	String description;

	/**
	 * Returns the name
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name
	 * 
	 * @param name
	 *            The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the description
	 * 
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description
	 * 
	 * @param description
	 *            The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Creates a Role with <code>name</code> and <code>description</code>
	 * parameters
	 * 
	 * @param name
	 * @param description
	 * 
	 */
	public Role(String name, String description) {
		this.name = name;
		this.description = description;
	}

}
