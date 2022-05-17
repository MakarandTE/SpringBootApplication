package com.gpg.springbootapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.gpg.springbootapp.dto.User;

public interface UserDao  extends CrudRepository<User, Integer>{
 
	public User findByuserName(String userName);
}
