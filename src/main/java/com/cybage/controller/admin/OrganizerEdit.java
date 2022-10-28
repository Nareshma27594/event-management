package com.cybage.controller.admin;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.bean.Organizer;
import com.cybage.services.OragizerServiceImpl;
import com.cybage.services.OrganizerService;

/**
 * Servlet implementation class OrganizerEdit
 */
@WebServlet("/organizer_edit")
public class OrganizerEdit extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String organizer_id = request.getParameter("organizer_id");
//		OrganizerService org_service = new OragizerServiceImpl();
//		Organizer organizer = org_service.getOrganizerById(Integer.parseInt(organizer_id));
//		ServletContext context = getServletContext();
//		context.setAttribute("organizer_object", organizer);
		// ------------
		request.getRequestDispatcher("admin_organizer_edit_form.jsp").forward(request, response);
//	    response.getWriter().println("organizer_edit");	
	}

}
