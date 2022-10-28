<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.cybage.bean.Organizer,com.cybage.services.*"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Event</title>
<style>
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

String organizer_id = request.getParameter("organizer_id");
OrganizerService org_service = new OragizerServiceImpl();
Organizer organizer = org_service.getOrganizerById(Integer.parseInt(organizer_id));
int id = organizer.getId();
String name = organizer.getName();
String email = organizer.getEmail();
int number = organizer.getPhoneNumber();
%>

				<form action="organizer_update" method="post">
					<div class="input_field">
						<span><i aria-hidden="true" class="fa fa-user"></i></span> <input
							type="text" name="organizer_id" value="<%=id%>" readonly />
					</div>
					<div class="input_field">
						<span><i aria-hidden="true" class="fa fa-envelope"></i></span> <input
							type="text" name="name" value="<%=name%>" />
					</div>
					<div class="input_field">
						<span><i aria-hidden="true" class="fa fa-lock"></i></span> <input
							type="email" name="email" value="<%=email%>" />
					</div>
					<div class="input_field">
						<span><i aria-hidden="true" class="fa fa-lock"></i></span> <input
							type="password" name="password" value="" />
					</div>
					<div class="input_field">
						<span><i aria-hidden="true" class="fa fa-lock"></i></span> <input
							type="tel" name="phone_number" value="<%=number%>" />
					</div>

					<div class="buttonWrapper">
						<input type="submit" style="background-color: #065492"
							class="submitButton">
						<div>Update</div>

					</div>
				</form>
			</center>
		</div>
	</div>
</body>

</html>