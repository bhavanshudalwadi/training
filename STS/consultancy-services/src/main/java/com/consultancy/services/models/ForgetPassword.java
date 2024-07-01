package com.consultancy.services.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ForgetPassword {
	@Id
	private String username;
	private String oldPassword;
	private String newPassword;
	
	public ForgetPassword() {
		super();
	}
	
	public ForgetPassword(String username, String oldPassword, String newPassword) {
		super();
		this.username = username;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}
