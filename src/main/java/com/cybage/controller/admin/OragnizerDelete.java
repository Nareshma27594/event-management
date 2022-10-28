package com.cybage.controller.admin;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class OragnizerDelete
 */
@WebServlet("/oragnizer_delete")
public class OragnizerDelete extends HttpServlet {
	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String organizer_id = request.getParameter("organizer_id");
//		OrganizerService org_service = new OragizerServiceImpl();
//	    org_service.deleteOrganizer(Integer.parseInt(organizer_id));
//		List<Organizer> organizer_list = org_service.getAllOrganizer();
//		ServletContext context = getServletContext();
//		context.setAttribute("organizer_list", organizer_list);
//		request.getRequestDispatcher("admin_organizer_dashboard.jsp").forward(request, response);
//	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String organizer_id = request.getParameter("organizer_id");
		OrganizerService org_service = new OragizerServiceImpl();
	    org_service.deleteOrganizer(Integer.parseInt(organizer_id));
		List<Organizer> organizer_list = org_service.getAllOrganizer();
		ServletContext context = getServletContext();
		context.setAttribute("organizer_list", organizer_list);
		request.getRequestDispatcher("admin_organizer_dashboard.jsp").forward(request, response);

	}

}
