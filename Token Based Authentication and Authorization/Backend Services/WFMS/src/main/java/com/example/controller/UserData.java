package com.example.controller;

public class UserData {
	@Override
	public String toString() {
		return "UserData [userName=" + userName + ", password=" + password + ", email=" + email + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String[] getRoleList() {
		return roleList;
	}

	public void setRoleList(String[] roleList) {
		this.roleList = roleList;
	}

	String userName;
	String password;
	String email;
	String firstName;
	String lastName;
	private String[] roleList;
}
