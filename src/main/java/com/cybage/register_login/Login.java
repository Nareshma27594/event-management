package com.cybage.register_login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.bean.Organizer;
import com.cybage.bean.User;
import com.cybage.services.OragizerServiceImpl;
import com.cybage.services.OrganizerService;
import com.cybage.services.UserService;
import com.cybage.services.UserServideImpl;
import com.cybage.utility.Hash;


@WebServlet("/login")
public class Login extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role list");
		password = Hash.getHash(password);
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();
		if(role.equals("user")) {
			UserService usrService = new UserServideImpl();
			User user = usrService.getUserById(usrService.getUserIdByEmail(email)) ;
			if( user.getEmail().equals(email) && user.getPassword().equals(password)) {
				response.getWriter().println("Login Complete");
			}
			else {
				out.println("<center><h6><p style='color:red';>Incorrect Password</p></center>");
				RequestDispatcher rd = request.getRequestDispatcher("/Login.html");
				rd.include(request, response);
			}
		}
		else if(role.equals("organizer")) {
			OrganizerService orgService = new OragizerServiceImpl();
			Organizer org = orgService.getOrganizerById(orgService.getOrganizerIdByEmail(email)) ;
			if( org.getEmail().equals(email) && org.getPassword().equals(password)) {
				response.getWriter().println("Login Complete");
			}
			else {
				out.println("<center><h6><p style='color:red';>Incorrect Password</p></center>");
				RequestDispatcher rd = request.getRequestDispatcher("/Login.html");
				rd.include(request, response);
			}
		}
		else {
			if(email.equals("admin") && password.equals("123")) {
				response.getWriter().println("Login Complete");
			}
			else {
				out.println("<center><h6><p style='color:red';>Incorrect Password</p></center>");
				RequestDispatcher rd = request.getRequestDispatcher("/Login.html");
				rd.include(request, response);
			}
		}
		
	}

}
