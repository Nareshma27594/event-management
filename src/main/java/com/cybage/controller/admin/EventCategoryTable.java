package com.cybage.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.services.EventCategoryService;
import com.cybage.services.EventCategoryServiceImpl;

/**
 * Servlet implementation class EventCategoryTable
 */
@WebServlet("/event_category_table")
public class EventCategoryTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EventCategoryService categoryService = new EventCategoryServiceImpl();
//		response.getWriter().print("hi buddy");
		getServletContext().setAttribute("category_list", categoryService.getAllCategories());
		request.getRequestDispatcher("admin_event_category_dashboard.jsp").forward(request, response);

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
