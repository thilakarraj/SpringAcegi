package com.abc.security.authentication;

import java.util.ArrayList;
import java.util.List;

import org.acegisecurity.Authentication;
import org.acegisecurity.AuthenticationException;
import org.acegisecurity.BadCredentialsException;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.GrantedAuthorityImpl;
import org.acegisecurity.providers.AuthenticationProvider;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.acegisecurity.userdetails.User;
import org.acegisecurity.userdetails.UserDetails;

import com.abc.security.ABCSecurityException;
import com.abc.security.SecurityConstants;
import com.abc.security.authentication.data.AuthenticationResponse;
import com.abc.security.authentication.data.UserProfileDTO;
import com.abc.security.authentication.service.UserAuthenticationService;

/**
 * This is a customized <code>AuthenticationProvider</code> used for dynamic
 * data based authentication for ABC application. Here authentication is
 * externalized and is performed by a common authentication service.
 * 
 * <DL>
 * <DT><B>History: </B>
 * <DD>Jul 13, 2007</DD>
 * </DL>
 * 
 * @author ShriKant
 * @version 1.0, Jul 13, 2007
 * 
 * @since v1.0, Jul 13, 2007
 * @see {@link org.acegisecurity.providers.AuthenticationProvider}
 * 
 */
public class ABCSecurityAuthenticationProvider implements
		AuthenticationProvider {

	private UserAuthenticationService authenticationService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.acegisecurity.providers.AuthenticationProvider#authenticate(org.acegisecurity.Authentication)
	 */
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		AuthenticationResponse authResponse = null;
		try {
			authResponse = authenticationService.authenticateUser(
					authentication.getPrincipal().toString(), authentication
							.getCredentials().toString());
		} catch (ABCSecurityException e) {
			throw new BadCredentialsException(
					"Exception occurred while executing service", e);
		}
		UserDetails user = null;
		if (authResponse.getAuthStatus() == SecurityConstants.AUTHENTICATION_SUCCESS) {
			UserProfileDTO userObj = authResponse.getUserDetails();
			List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

			List<String> roles = userObj.getRoles();

			for (int i = 0; i < roles.size(); i++) {
				list.add(new GrantedAuthorityImpl(roles.get(i)));
			}
			GrantedAuthority toReturn[] = { new GrantedAuthorityImpl("demo") };
			user = new User(authentication.getPrincipal().toString(),
					authentication.getCredentials().toString(), true, true,
					true, true, (GrantedAuthority[]) (GrantedAuthority[]) list
							.toArray(toReturn));
		} else
			throw new BadCredentialsException("Bad Credentials",
					true ? ((Object) (user)) : null);

		UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(
				user, authentication.getCredentials(), user.getAuthorities());
		result.setDetails(authentication.getDetails());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.acegisecurity.providers.AuthenticationProvider#supports(java.lang.Class)
	 */
	public boolean supports(Class authentication) {
		return (UsernamePasswordAuthenticationToken.class
				.isAssignableFrom(authentication));
	}

	/**
	 * Sets the authService
	 * 
	 * @param authService
	 *            The authService to set.
	 */
	public void setAuthenticationService(UserAuthenticationService authService) {
		this.authenticationService = authService;
	}
}
