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
    public boolean deleteUserById(int id);
    
    public boolean setOrganizerName(int id, String name);
    public boolean setOrganizerEmail(int id, String email);
    public boolean setOrganizerPassword(int id, String password);
    public int getOrganizerIdByEmail(String email);
    public boolean addOrganizer(Organizer organizer);
    public boolean deleteOrganizerById(int organizer_id);
    
    public boolean setEventName(int event_id,String event_name);
    public boolean addEvent(Event event);
    public boolean setEventVenue(int event_id,String venue);
    public boolean setEventPrice(int event_id,int price);
    public boolean setEventCategory(int event_id,String venue);
    public boolean setEventDateTime(int event_id,String dateTime);
    public boolean deleteEventById(int event_id);
    public boolean deleteEventByOrganizerId(int organizer_id);
    
    public boolean addBooking(Booking booking);
    public boolean deleteBookingById(int booking_id);
    public boolean deleteBookingByUserId(int user_id);
    public boolean deleteBookingByOrganizerId(int organizer_id);
    
    public List<User> getAllUser();
    public List<Event> getAllEvents();
    public List<Event> getBookedEvents(int id);
    public List<Event> getEventsByCategory(String category);
    public List<Booking> getAllBooking();
    
}
