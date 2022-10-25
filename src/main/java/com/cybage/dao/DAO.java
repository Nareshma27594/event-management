package com.cybage.dao;

import java.util.List;

import com.cybage.bean.Booking;
import com.cybage.bean.Event;
import com.cybage.bean.Organizer;
import com.cybage.bean.User;

public interface DAO {
	public User getUserById(int id);
    public Organizer getOrganizerById(int id);
    
    public boolean addUser(User user);
    public boolean setUserName(int id, String name);
    public boolean setUserEmail(int id, String email);
    public boolean setUserPassword(int id, String password);
    public int getUserIdByEmail(String email);
    
    public boolean setOrganizerName(int id, String name);
    public boolean setOrganizerEmail(int id, String email);
    public boolean setOrganizerPassword(int id, String password);
    public int getOrganizerIdByEmail(String email);
    public boolean addOrganizer(Organizer organizer);
    
    public boolean setEventName(int event_id,String event_name);
    // this.event_id = event_id;
//	this.name = name;
//	this.venue = venue;
//	this.price = price;
//	this.organizer_id = organizer_id;
//	this.category = category;
//	this.date = date;
    public boolean addEvent(Event event);
    public boolean setEventVenue(int event_id,String venue);
    public boolean setEventPrice(int event_id,int price);
    public boolean setEventCategory(int event_id,String venue);
    public boolean setEventDateTime(int event_id,String dateTime);
    
    
    
    
    public List<User> getAllUser();
    public List<Event> getAllEvents();
    public List<Event> getBookedEvents(int id);
    public List<Event> getEventsByCategory(String category);
    public List<Booking> getAllBooking();
    
}
