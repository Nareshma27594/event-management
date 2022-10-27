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
import com.cybage.utility.Hash;

@WebServlet("/organizer_update")
public class OrganizerUpdate extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("organizer_id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int phone_number = Integer.parseInt(request.getParameter("phone_number"));
		OrganizerService org_service = new OragizerServiceImpl();
		org_service.setOrganizerEmail(id, email);
		org_service.setOrganizerName(id, name);
		org_service.setOrganizerNumber(id, phone_number);
		password = Hash.getHash(password);
		org_service.setOrganizerPassword(id, password);
		List<Organizer> organizer_list = org_service.getAllOrganizer();
		ServletContext context = getServletContext();
		context.setAttribute("organizer_list", organizer_list);
		request.getRequestDispatcher("admin_organizer_dashboard.jsp").forward(request, response);
		
	}

}
