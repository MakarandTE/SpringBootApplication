package com.gpg.springbootapp.dto;

public class LoginResponse {

	public String jwt;

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public LoginResponse(String jwt) {
		super();
		this.jwt = jwt;
	}
	
	
}
