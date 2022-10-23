package com.cybage.bean;

public class User {
	String name;
    int id;
    String email;
    String password;
    int phone;
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getEmail() {
		return email;
	}
   
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	
	public User(int id,String name, String email, String password, int number) {
		super();
		this.name = name;
		this.id = id;
		this.email = email;
		this.password = password;
		this.phone = number;
	}
	public User(String name, String email, String password, int number) {
		super();
		this.name = name;
		
		this.email = email;
		this.password = password;
		this.phone = number;
	}

@Override
public String toString() {
	return "name "+this.name+" email"+this.email;
}
	


	public void setPassword(String password) {
		this.password = password;
	}
	public int getPhone() {
		return this.phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
}
