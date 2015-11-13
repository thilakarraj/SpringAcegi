package com.abc.security;

/**
 * This exception is thrown when some security related problem occurs in the ABC
 * application.
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
public class ABCSecurityException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a default <code>ABCSecurityException</code> object
	 */
	public ABCSecurityException() {
		super();
	}

	/**
	 * Creates a <code>ABCSecurityException</code> with <code>message</code>
	 * and <code>cause</code> params
	 * 
	 * @param message
	 *            exception message
	 * @param cause
	 *            the root cause of exception
	 * 
	 */
	public ABCSecurityException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Creates a <code>ABCSecurityException</code> with <code>message</code>
	 * param
	 * 
	 * @param message
	 *            exception message
	 * 
	 */
	public ABCSecurityException(String message) {
		super(message);
	}

	/**
	 * Creates a <code>ABCSecurityException</code> with <code>cause</code>
	 * param
	 * 
	 * @param cause
	 *            the root cause of exception
	 * 
	 */
	public ABCSecurityException(Throwable cause) {
		super(cause);
	}
}
