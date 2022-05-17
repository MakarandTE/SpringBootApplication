package com.gpg.springbootapp.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;
@Entity
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull
	private int userId;
	
	@NotNull
	@Size(min = 3, message = "User not valid")
	private String userName;
	@NotNull
	@NotEmpty
	@Size(min = 8, message = "password not valid")
	private String password;
	@NotEmpty
	private String language;
	@Email
	@Size(message = "invalid email")
	private String email;
	@NotNull

	private long mobileNo;
	@NotNull
	private String role;
	
	
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
	
	public User(@NotNull String role) {
		super();
		this.role = role;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public User(int userId, @NotNull @Size(min = 3, message = "User not valid") String userName,
			@NotNull @NotEmpty @Size(min = 8, message = "password not valid") String password,
			@NotEmpty String language, @Email @Size(message = "invalid email") String email,
			@Size(min = 10) long mobileNo) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.language = language;
		this.email = email;
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", language=" + language
				+ ", email=" + email + ", mobileNo=" + mobileNo + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
