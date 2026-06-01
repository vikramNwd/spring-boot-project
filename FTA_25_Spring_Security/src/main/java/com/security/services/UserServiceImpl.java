package com.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.security.Fta25SpringSecurityApplication;
import com.security.entities.MyUser;
import com.security.repositories.UserRepository;

/*
 userdetails ==> 
 1. UserDetails, User:username,password,roles
 2. UserDetailsService : loadUserByUsername()
 */

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	UserRepository userrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MyUser u = userrepo.findByUname(username);
		//password ==> match with db password
		//MyUser(user-defined) ==> User(spring security)(UserDetails)b ==>UserBuilder
		
		return User.builder()
			.username(u.getUname())
			.password(u.getUpassword())
			.roles(u.getRole())
			.build();
			
	}
	
}