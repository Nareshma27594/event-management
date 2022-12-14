package com.cybage.register_login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cybage.bean.Organizer;
import com.cybage.bean.User;
import com.cybage.services.AdminService;
import com.cybage.services.AdminServiceImpl;
import com.cybage.services.OragizerServiceImpl;
import com.cybage.services.OrganizerService;
import com.cybage.services.UserService;
import com.cybage.services.UserServideImpl;
import com.cybage.utility.Hash;


@WebServlet("/login")
public class Login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("get in log");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
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
				session.setAttribute("login", true);
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
				session.setAttribute("login", true);
				response.getWriter().println("Login Complete");
			}
			else {
				out.println("<center><h6><p style='color:red';>Incorrect Password</p></center>");
				RequestDispatcher rd = request.getRequestDispatcher("/Login.html");
				rd.include(request, response);
			}
		}
		else {
			AdminService adminService = new AdminServiceImpl();
//			adminService.getPassword(email);
			System.out.println(password);
			if(password.equals(adminService.getPassword(email))) {
				
				getServletContext().setAttribute("admin_email",email);

				session.setAttribute("login", "true");
				request.getRequestDispatcher("admin_after_login.jsp").forward(request, response);
				
			}
			else {
				out.println("<center><h6><p style='color:red';>Incorrect Password</p></center>");
				RequestDispatcher rd = request.getRequestDispatcher("/Login.html");
				rd.include(request, response);
			}
		}
		
	}

}
