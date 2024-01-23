package com.muthukumarasamy.User;

public class User {

	private String name;
	private String password;
	private String email;

	public User(String name, String password, String email) {
		setName(name);
		setPassword(password);
		setEmail(email);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
