package com.cybage.services;

import java.util.List;

import com.cybage.bean.Event;

public interface EventService {

	public boolean setEventName(int event_id,String event_name);
    public boolean addEvent(Event event);
    public boolean setEventVenue(int event_id,String venue);
    public boolean setEventPrice(int event_id,int price);
    public boolean setEventCategory(int event_id,String venue);
    public boolean setEventDateTime(int event_id,String dateTime);
    public boolean deleteEventById(int event_id);
    public Event getEventById(int id);
    public List<Event> getAllEvents();
    public boolean setOrganizerIdOfEventById(int event_id, int organizer_id);
	
}
