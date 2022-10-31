<%@page import="com.cybage.services.*"%>
<%@page import="com.cybage.bean.*, java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hi buddy</title>
</head>
<body>

<%	List<Booking> bookings_list =(List<Booking>)application.getAttribute("booking_list");%>
<div class="container">
		<table class="table table-sm" border="3" bordercolor="yellow">
			<thead>
				<tr>
					<th scope="col">Booking Id</th>
					<th scope="col">User Name</th>
					<th scope="col">User Id</th>
					<th scope="col">Event Name</th>
					<th scope="col">Event Id</th>
					<th scope="col">Venue</th>
					<th scope="col">DateTime</th>
                    <th scope="col">Price</th>	
                    <th scope="col">Action</th>					
				</tr>
			</thead>
			
			<tbody>
			
			<% UserService userService = new UserServideImpl();
			EventService eventService = new EventServiceImpl();
			Event event;
			%>
			<% for(Booking booking : bookings_list){ %>
			     <tr>
						<th scope="row"><%= booking.getBooking_id() %>  </th>
						<td><%=  userService.getUserById(booking.getUser_id()).getName() %></td>
						<td><%=  booking.getUser_id() %>  </td>
						
						<% event = eventService.getEventById(booking.getEvent_id()); %>
						
						<td><%= event.getName() %></td>
						<td><%= booking.getEvent_id() %></td>
						<td><%= event.getVenue()  %></td>
						<td><%= event.getDate()  %></td>
						<td><%= event.getPrice()  %></td>
						<td><a type="button" class="btn btn-danger"
							href="booking_delete?booking_id=<%= booking.getBooking_id() %>">Delete</a><br>
						<br><a type="button" class="btn btn-warning" href="booking_edit?booking_id=<%= booking.getBooking_id() %>">Edit</a></td>
					</tr>
			
			<%} %>
			
			
			
				


			</tbody>
		</table>
	</div>
</body>
</html>