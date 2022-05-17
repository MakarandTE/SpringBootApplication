package com.gpg.springbootapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gpg.springbootapp.dao.UserDao;
import com.gpg.springbootapp.dto.MyUserDetails;
import com.gpg.springbootapp.dto.User;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UserDao dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		User user =dao.findByuserName(username);
		return new MyUserDetails(user);
	}

	public User addUser(User user) {
		return dao.save(user);
	}
	
	public User getUser(String userName) {
		return dao.findByuserName(userName);
	}

}
