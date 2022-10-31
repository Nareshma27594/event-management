package com.cybage.services;

import java.util.List;

import com.cybage.bean.Booking;
import com.cybage.bean.Event;
import com.cybage.dao.DAO;
import com.cybage.dao.DAOImpl;

public class BookingServiceImpl implements BookingService{
    public static DAO dao = new DAOImpl();
	@Override
	public List<Booking> getAllBooking() {
		
		return dao.getAllBooking();
	}

	@Override
	public boolean addBooking(Booking booking) {
		
		return dao.addBooking(booking);
	}

	@Override
	public boolean deleteBookingById(int booking_id) {
		
		return dao.deleteBookingById(booking_id);
	}

	@Override
	public boolean deleteBookingByUserId(int user_id) {
		
		return dao.deleteBookingByUserId(user_id);
	}

	@Override
	public boolean deleteBookingByEventId(int event_id) {
		
		return dao.deleteBookingByEventId(event_id);
	}

	/**
	 * @param takes user_id as a parameter
	 * Returns the events booked by User
	 * @return list of the events booked by User List<Event>
	 * */
	@Override
	public List<Event> getBookedEvents(int user_id) {
		
		return dao.getBookedEvents(user_id);
	}

	@Override
	public Booking getBooking(int booking_id) {
		
		return dao.getBooking(booking_id);
	}

	@Override
	public boolean changeBookingToUser(int booking_id, int user_id) {
		
		return dao.changeBookingToUser(booking_id, user_id);
	}

}
