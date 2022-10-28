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
import com.cybage.services.EventServiceImpl;
import com.cybage.services.EventService;

/**
 * Servlet implementation class EventDelete
 */
@WebServlet("/event_delete")
public class EventDelete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String event_id = request.getParameter("event_id");
		EventService event_service = new EventServiceImpl();
		event_service.deleteEventById(Integer.parseInt(event_id));
		List<Event> events_list = event_service.getAllEvents();
		ServletContext context = getServletContext();
		context.setAttribute("event_list", events_list);
		request.getRequestDispatcher("admin_events_dashboard.jsp").forward(request, response);

	}


}
