package com.cmc.gdp05.group4.entity;

public class Account {
	private String username;
	private String password;
	private String remember;

	public Account(String username, String password, String remember) {
		this.username = username;
		this.password = password;
		this.remember = remember;
	}

	public Account() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemember() {
		return remember;
	}

	public void setRemember(String remember) {
		this.remember = remember;
	}

	@Override
	public String toString() {
		return "Account [username=" + username + ", password=" + password + ", remember=" + remember + "]";
	}

}
