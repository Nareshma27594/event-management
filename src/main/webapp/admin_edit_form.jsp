<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.cybage.bean.Admin, com.cybage.services.AdminService,com.cybage.services.AdminServiceImpl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	<style>body {
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
<% AdminService adminService = new AdminServiceImpl();
String email= (String)application.getAttribute("admin_email");
String password = adminService.getPassword(email);%>
<div class="main">
		<div class="form_container">
			<center>
				<div class="title_container">
					<h2>Admin Data</h2>
				</div>
     <form action="admin_update" method="post">
					<div class="input_field">
						<span>Email<i aria-hidden="true" class="fa fa-user"></i></span> <input
							type="email" name="email" value="<%=email%>" />
					</div>
					<div class="input_field">
						<span>Password<i aria-hidden="true" class="fa fa-envelope"></i></span> <input
							type="text" name="password" value="<%=password%>"/>
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