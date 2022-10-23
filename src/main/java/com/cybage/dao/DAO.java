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
    public boolean setUserName(int id);
    public boolean setUserEmail(int id);
    public boolean setUserPassword(int id);
    public int getUserIdByEmail(String email);
    
    public boolean setOrganizerName(int id);
    public boolean setOrganizerEmail(int id);
    public boolean setOrganizerPassword(int id);
    public int getOrganizerIdByEmail(String email);
    public boolean addOrganizer(Organizer organizer);
    
    
    
    public List<User> getAllUser();
    public List<Event> getAllEvents();
    public List<Event> getBookedEvents(int id);
    public List<Event> getEventsByCategory(String category);
    public List<Booking> getAllBooking();
    
}
