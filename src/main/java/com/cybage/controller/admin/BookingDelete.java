package com.cybage.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.bean.Booking;
import com.cybage.services.BookingService;
import com.cybage.services.BookingServiceImpl;


@WebServlet("/booking_delete")
public class BookingDelete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  int booking_id = Integer.parseInt(request.getParameter("booking_id"));
		  BookingService booking_service = new BookingServiceImpl();
		  ServletContext context = getServletContext();
		  List<Booking> bookings_list = booking_service.getAllBooking();
			context.setAttribute("booking_list", bookings_list);
		  System.out.println(booking_service.deleteBookingById(booking_id));
		  request.getRequestDispatcher("admin_booking_dashboard.jsp").forward(request, response);
	}
	
}
