package com.abc.security;

/**
 * Contains common constants related to application security implementation.
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
public class SecurityConstants {
	/**
	 * Resource type function invocation
	 */
	public static final String RESOURCE_TYPE_FI = "FI";

	/**
	 * A default private constructor to avoid instance creation of
	 * <code>SecurityConstants</code> class.
	 * 
	 */
	private SecurityConstants() {

	}

	/**
	 * A return code for authentication success.
	 */
	public static int AUTHENTICATION_SUCCESS = 0;
	/**
	 * A return code for authentication failure.
	 */
	public static int AUTHENTICATION_FAILED = 1;
}
