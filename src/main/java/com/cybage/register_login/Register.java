package com.cybage.register_login;

import java.io.IOException;
import java.io.PrintWriter;
//import org.apache.commons.codec.digest.DigestUtils;
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


@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean flag = true;
		String name  = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String role = request.getParameter("role list");
		System.out.println(role+" role hash"+Hash.getHash(password));
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(!(name.matches("^[a-z A-Z]*$"))) {
		out.println("<center><h6><p style='color:red';>Name is not correct</p></h6></center>");
		System.out.println("name is not correct");
		flag = false;
		}
		else if(!(email.matches("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$"))) {
			out.println("<center><h6><p style='color:red';>Invalid Email</p></h6></center>");
			flag = false;
			System.out.println("email is not correct");
		}
		else if(!(password.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,16}"))) {
			out.println("<center><h6><p style='color:red';>"
					+ "<br> Password must contain: least one digit"
					+ "<br>at least one lower case letter "
					+ "<br>at least one upper case letter "
					+ "<br>at least one special character"
					+ "<br>lenght should be 8 characters to 16 characters long"
					+ "</p></h6></center>");
			flag = false;
			System.out.println("passworis not correct");
		}
		else if(!confirmPassword.equals(password)) {
			out.println("<center><h6><p style='color:red';>Password is not matching</p></h6></center>");
			System.out.println("Password in not matchinng");
		}
		else {
			UserService userService = new UserServideImpl();
			if( role.equals("user")&& 0<userService.getUserIdByEmail(email)) {
				out.println("<center><h6><p style='color:red';>User already exists</p></h6></center>");
				System.out.println("User exists already");
				flag = false;
			}
			else { 
				OrganizerService organizerService = new OragizerServiceImpl();
				if(role.equals("event organizer")&& 0<organizerService.getOrganizerIdByEmail(email)) {
					out.println("<center><h6><p style='color:red';>Event Organizer already exists</p></h6></center>");
					System.out.println("Organizer exists already");
					flag = false;
				}
			}	
			
		}
		
		password = Hash.getHash(password);
		if( flag && role.equals("user")){
			UserService userService = new UserServideImpl();
			userService.addUser(new User(name,email,password,29120));
			response.sendRedirect("/Login.html");
		}
		if( flag && role.equals("event organizer")){
			OrganizerService organizerService = new OragizerServiceImpl();
			
			organizerService.addOrganizer(new Organizer(name,email,password));
			response.sendRedirect("Login.html");
			
		}
		if(!flag) {
		RequestDispatcher rd = request.getRequestDispatcher("/Register.html");
		rd.include(request, response);
		}
		
		
	}

}
