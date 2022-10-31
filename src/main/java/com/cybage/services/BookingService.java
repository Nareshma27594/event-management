package com.cybage.services;

import java.util.List;

import com.cybage.bean.Booking;
import com.cybage.bean.Event;

public interface BookingService {
	public List<Booking> getAllBooking();
	public boolean addBooking(Booking booking);
    public boolean deleteBookingById(int booking_id);
    public boolean deleteBookingByUserId(int user_id);
    public boolean deleteBookingByEventId(int event_id);
    public List<Event> getBookedEvents(int user_id);
    public Booking getBooking(int booking_id);
    public boolean changeBookingToUser(int booking_id,int user_id);
}
