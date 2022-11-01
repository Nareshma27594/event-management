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
<title>Insert title here</title>
</head>
<body>
<%! int i = 1; %>
<div class="container">
		<table class="table table-sm" border="3" bordercolor="yellow">
			<thead>
				<tr>
					<th scope="col">Event Category</th>
					<th scope="col">Action</th>
									
				</tr>
			</thead>
			
			<tbody>
			
			<c:forEach items="${applicationScope.category_list}"
					var="category">
			     <tr>
						<th scope="row">${category}</th>
						
						
						
						<td><a type="button" class="btn btn-danger"
							href="event_category_delete?event_category=${category}">>Delete</a><br>
						<br><a type="button" class="btn btn-warning" href="event_category_edit?event_category=${category}">Edit</a></td>
					</tr>
			
			//event_category_edit
			//category_edit_form
			</c:forEach>
			
			
				


			</tbody>
		</table>
	</div>
	<a href="admin_after_login.jsp">Go to dashboard</a>
</body>
</body>
</html>