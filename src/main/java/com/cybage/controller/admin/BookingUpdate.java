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


@WebServlet("/booking_update")
public class BookingUpdate extends HttpServlet {
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		int booking_id = Integer.parseInt(request.getParameter("booking_id"));
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		BookingService booking_service = new BookingServiceImpl();
		booking_service.changeBookingToUser(booking_id, user_id);
		List<Booking> bookings_list = booking_service.getAllBooking();
		context.setAttribute("booking_list", bookings_list);
		
		request.getRequestDispatcher("admin_booking_dashboard.jsp").forward(request, response);
		
	}

}
