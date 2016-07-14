package com.dextratech.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.dextratech.services.UserService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	private UserService userService;
	
	@Override
	public Authentication authenticate(Authentication a)
			throws AuthenticationException {
		
		String principal = a.getName();
		String credentials = a.getCredentials().toString();
		User user = userService.getSecurityUserByName(principal);
		
		if (user != null) {
			if(credentials.equals(user.getPassword())) {
				return new UsernamePasswordAuthenticationToken(principal, credentials, user.getAuthorities());
			} else {
				throw new BadCredentialsException("Error de contraseña");
			}
		}else {
			System.out.println("Usuario incorrecto");
			throw new BadCredentialsException("Usuario incorrecto");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

	
}
