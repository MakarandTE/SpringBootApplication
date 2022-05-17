package com.gpg.springbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gpg.springbootapp.dto.Login;
import com.gpg.springbootapp.dto.LoginResponse;
import com.gpg.springbootapp.dto.User;
import com.gpg.springbootapp.service.UserService;
import com.gpg.springbootapp.util.JwtUtil;


@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@Autowired
	private JwtUtil util;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/addUser")
	public ResponseEntity<?> addData(@RequestBody User user){
		User user2=service.addUser(user);
		return new ResponseEntity<User>(user,HttpStatus.OK);
		
	}
	@GetMapping("/getUser/{userName}")
	public ResponseEntity<?> getUser(@PathVariable String userName){
		User user =service.getUser(userName);
		if (user!=null) {
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("UserName not found",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Login login){
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUserName(), login.getPassword()));
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserDetails userDetails=service.loadUserByUsername(login.getUserName());
		String token=util.generateToken(userDetails);
		return ResponseEntity.ok(new LoginResponse(token));
	}
	}

