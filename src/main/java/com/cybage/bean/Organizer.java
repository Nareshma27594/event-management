package com.cybage.bean;
// select * from event where event_id IN ( select event_id from booking where user_id=7);
public class Organizer {

    int id;
    public Organizer(int id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
    public Organizer( String name, String email, String password) {
		super();
		
		this.name = name;
		this.email = email;
		this.password = password;
	}
    
    public Organizer(int id, String name, String email, String password, int number) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.number = number;
	}
    
	String name;
    String email;
    String password;
    int number;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPhoneNumber() {
		return this.number;
	}
	
	public void setPhoneNumber(int number) {
		this.number = number;
	}
	
}
