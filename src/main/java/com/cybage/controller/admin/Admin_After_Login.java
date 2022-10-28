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

import com.cybage.bean.Event;
import com.cybage.bean.Organizer;
import com.cybage.services.EventService;
import com.cybage.services.EventServiceImpl;
import com.cybage.services.OragizerServiceImpl;
import com.cybage.services.OrganizerService;


@WebServlet("/admin_after_login") 
public class Admin_After_Login extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String choice = request.getParameter("choice");
		if(choice.equals("user")) {
			
		}
		else if(choice.equals("organizer")) {
			//send reponse to the admin_organizer_dashboard.jsp
			OrganizerService org_service = new OragizerServiceImpl();
			List<Organizer> organizer_list = org_service.getAllOrganizer();
			ServletContext context = getServletContext();
			context.setAttribute("organizer_list", organizer_list);
			
		
			request.getRequestDispatcher("admin_organizer_dashboard.jsp").forward(request, response);
			
			
		}
		else if(choice.equals("event")) {
			
			EventService event_service = new EventServiceImpl();
			List<Event> events_list = event_service.getAllEvents();
			ServletContext context = getServletContext();
			context.setAttribute("event_list", events_list);
			
		
			request.getRequestDispatcher("admin_events_dashboard.jsp").forward(request, response);
			

			
		}
		else if(choice.equals("booking")) {
			
		}
		else {
			//this is for admin profile
			
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("hi get");	
		
	}

}
