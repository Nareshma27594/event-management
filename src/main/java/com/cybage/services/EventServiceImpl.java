package com.cybage.services;

import java.util.List;

import com.cybage.bean.Event;
import com.cybage.dao.DAO;
import com.cybage.dao.DAOImpl;

public class EventServiceImpl implements EventService {
	public static DAO dao = new DAOImpl();
	public boolean setEventName(int event_id,String event_name) {
		return dao.setEventName(event_id, event_name);
	}
    public boolean addEvent(Event event) {
    	return dao.addEvent(event);
    }
    public boolean setEventVenue(int event_id,String venue) {
    	return dao.setEventVenue(event_id, venue);
    }
    public boolean setEventPrice(int event_id,int price) {
    	return dao.setEventPrice(event_id, price);
    }
    public boolean setEventCategory(int event_id,String venue) {
    	return dao.setEventCategory(event_id, venue);
    }
    public boolean setEventDateTime(int event_id,String dateTime) {
    	return dao.setEventDateTime(event_id, dateTime);
    }
    public boolean deleteEventById(int event_id) {
    	return dao.deleteEventById(event_id);
    }
	@Override
	public Event getEventById(int id) {
		
		return dao.getEventById(id);
	}
	@Override
	public List<Event> getAllEvents() {
		return dao.getAllEvents();
	}
	@Override
	public boolean setOrganizerIdOfEventById(int event_id, int organizer_id) {
		return dao.setOrganizerIdOfEventById(event_id, organizer_id);
	}
}
