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
 * Servlet implementation class EventCategoryDelete
 */
@WebServlet("/event_category_delete")
public class EventCategoryDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.getWriter().println("Hi buddy delete category");
		String category = request.getParameter("event_category");
EventCategoryService categoryService = new EventCategoryServiceImpl();
        categoryService.removeCategory(category);
		getServletContext().setAttribute("category_list", categoryService.getAllCategories());
		request.getRequestDispatcher("admin_event_category_dashboard.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
