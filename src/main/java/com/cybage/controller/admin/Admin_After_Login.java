package com.cybage.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.bean.Booking;
import com.cybage.bean.Event;
import com.cybage.bean.Organizer;
import com.cybage.services.BookingService;
import com.cybage.services.BookingServiceImpl;
import com.cybage.services.EventService;
import com.cybage.services.EventServiceImpl;
import com.cybage.services.OragizerServiceImpl;
import com.cybage.services.OrganizerService;


@WebServlet("/admin_after_login")
public class Admin_After_Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String choice = request.getParameter("choice");
		ServletContext context = getServletContext();
		if(choice.equals("user")) {
			
		}
		else if(choice.equals("organizer")) {
			//send reponse to the admin_organizer_dashboard.jsp
			OrganizerService org_service = new OragizerServiceImpl();
			List<Organizer> organizer_list = org_service.getAllOrganizer();
			
			context.setAttribute("organizer_list", organizer_list);
			
		
			request.getRequestDispatcher("admin_organizer_dashboard.jsp").forward(request, response);
			
			
		}
		else if(choice.equals("event")) {
			
			EventService event_service = new EventServiceImpl();
			List<Event> events_list = event_service.getAllEvents();
			
			context.setAttribute("event_list", events_list);
			
		
			request.getRequestDispatcher("admin_events_dashboard.jsp").forward(request, response);
			

			
		}
		else if(choice.equals("booking")) {
			
			BookingService booking_service = new BookingServiceImpl();
			
			List<Booking> bookings_list = booking_service.getAllBooking();
			context.setAttribute("booking_list", bookings_list);
			
			request.getRequestDispatcher("admin_booking_dashboard.jsp").forward(request, response);
		}
		else {
			context.setAttribute("admin_email","admin@gmail.com");
			request.getRequestDispatcher("admin_edit_form.jsp").forward(request, response);
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("hi get admin_after_login servlet");	
		
	}

}
