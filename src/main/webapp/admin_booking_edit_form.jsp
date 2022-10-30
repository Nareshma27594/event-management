<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.cybage.services.*,com.cybage.bean.*"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
body {
	font-family: Verdana, Geneva, sans-serif;
	font-size: 14px;
	background: #f2f2f2;
}

.main {
	display: flex;
	align-items: center;
	justify-content: center;
	height: 100vh;
}

span {
	position: absolute;
	left: 0;
	top: 0;
	height: 100%;
	text-align: center;
	width: 30px;
}

i {
	padding-top: 10px;
}

.input_field {
	position: relative;
	margin-bottom: 20px;
	animation: bounce 0.6s ease-out;
}

.form_container {
	border: 2px solid;
	background-color: mediumaquamarine;
	justify-content: center;
	height: 60%;
	width: 50%;
}

input {
	height: 40px;
	font-size: 20px;
	border-radius: 4px;
	border: none;
	border: solid 1px #ccc;
	padding: 0 11px;
}

.title_container {
	justify-content: center;
}

.buttonWrapper {
	margin-top: 40px;
}

.submitButton {
	width: 50%;
	height: 40px;
	margin: auto;
	display: block;
	border-radius: 4px;
	font-size: 15px;
	cursor: pointer;
	color: #f2f2f2;
}
</style>
</head>
<body>
	<div class="main">
		<div class="form_container">
			<center>
				<div class="title_container">
					<h2>Organizer Data</h2>
				</div>

				<%
				
int booking_id = Integer.parseInt(request.getParameter("booking_id"));
BookingService booking_service = new BookingServiceImpl();
EventService event_service = new EventServiceImpl();
UserService user_service = new UserServideImpl();
Booking booking = booking_service.getBooking(booking_id);
int event_id = booking.getEvent_id();
int user_id = booking.getUser_id();
String user_name = user_service.getUserById(user_id).getName();
Event event = event_service.getEventById(event_id);
String event_name = event.getName();
String venue = event.getVenue();
String date = event.getDate();

%>

				<form action="event_update" method="post">
					<div class="input_field">
						<span>Booking Id<i aria-hidden="true" class="fa fa-user"></i></span> <input
							type="text" name="event_id" value="<%=booking_id%>" readonly />
					</div>
					<div class="input_field">
						<span>Name<i aria-hidden="true" class="fa fa-envelope"></i></span> <input
							type="text" name="name" value="<%=user_name%>" />
					</div>
					<div class="input_field">
						<span>Venue<i aria-hidden="true" class="fa fa-lock"></i></span> <input
							type="text" name="venue" value="<%=user_id%>" />
					</div>
					<div class="input_field">
						<span>Price<i aria-hidden="true" class="fa fa-lock"></i></span> <input
							type="text" name="price" value="<%=event_id%>" />
					</div>
					<div class="input_field">
						<span>Organizer Id<i aria-hidden="true" class="fa fa-lock"></i></span> <input
							type="text" name="organizer_id" value="<%=event_name%>" />
					</div>
					<div class="input_field">
						<span>Category<i aria-hidden="true" class="fa fa-lock"></i></span> <input
							type="text" name="category" value="<%=venue%>" />
					</div>
			 		<div class="input_field">
						<span>Date<i aria-hidden="true" class="fa fa-lock"></i></span> <input
							type="text" name="date" value="<%=date%>"/>
					</div>
					
					
					
					<div class="buttonWrapper">
						<input type="submit" style="background-color: #065492"
							class="submitButton" value="Update">
						

					</div>
				</form>
			</center>
		</div>
	</div>
</body>
</html>