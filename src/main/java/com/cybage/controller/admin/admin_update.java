package com.cybage.controller.admin;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.services.AdminService;
import com.cybage.services.AdminServiceImpl;
import com.cybage.utility.Hash;

/**
 * Servlet implementation class admin_update
 */
@WebServlet(name = "AdminUpdate", urlPatterns = { "/admin_update" }) 
public class admin_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		String previous_email = (String)context.getAttribute("admin_email");
		String email  =  request.getParameter("email");
		String password  =  request.getParameter("password");
		AdminService adminService = new AdminServiceImpl();
		if(!password.isEmpty()) {
			//update apasword
			password = Hash.getHash(password);
			adminService.setPassword(email, password);
		}
		if(!email.isEmpty()) {
			adminService.setAdminEmail(previous_email, email);
		}
		
		
		
		
		request.getRequestDispatcher("admin_after_login.jsp").forward(request, response);

	}

}
