package com.cybage.bean;

public class Booking {
	int booking_id;
	int event_id;
	int user_id;
	
	public Booking(int booking_id, int event_id, int user_id) {
		this.booking_id = booking_id;
		this.event_id = event_id;
		this.user_id = user_id;
	}
	public int getBooking_id() {
		return booking_id;
	}
	public int getEvent_id() {
		return event_id;
	}
	public int getUser_id() {
		return user_id;
	}
}
