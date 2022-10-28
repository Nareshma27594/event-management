package com.cybage.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.bean.Event;
import com.cybage.services.EventService;
import com.cybage.services.EventServiceImpl;

/**
 * Servlet implementation class EventUpdate
 */
@WebServlet("/event_update")
public class EventUpdate extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		EventService event_service = new EventServiceImpl();
		
		int event_id = Integer.parseInt(request.getParameter("event_id"));		
		String name = request.getParameter("name");
		String venue = request.getParameter("venue");
		int price = Integer.parseInt(request.getParameter("price"));
		int organizer_id = Integer.parseInt(request.getParameter("organizer_id"));
		String category = request.getParameter("category");
		String datetime = request.getParameter("date");
		
		event_service.setEventCategory(event_id, category);
		event_service.setEventDateTime(event_id, datetime);
		event_service.setEventName(event_id, name);
		event_service.setEventPrice(event_id, price);
		event_service.setEventVenue(event_id, venue);
		event_service.setOrganizerIdOfEventById(event_id, organizer_id);
		
		
		
		List<Event> events_list = event_service.getAllEvents();
		ServletContext context = getServletContext();
		context.setAttribute("event_list", events_list);
		request.getRequestDispatcher("admin_events_dashboard.jsp").forward(request, response);

	}

}
