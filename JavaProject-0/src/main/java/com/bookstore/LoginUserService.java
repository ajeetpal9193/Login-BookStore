package com.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class LoginUserService implements UserDetailsService {
	
	@Autowired
	private LoginRepo loginrepo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Login login = loginrepo.findByEmail(email);
		if (login == null)
			throw new UsernameNotFoundException("User Not Found");
		return new LoginUserDetails(login) ;
	}

}