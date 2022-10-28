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
	<div class="container">
		<table class="table table-sm">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Number</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${applicationScope.organizer_list}"
					var="organizerList">

					<tr>
						<th scope="row"><c:out value="${organizerList.id}" /></th>
						
						<td><c:out value="${organizerList.name}" /></td>
						<td><c:out value="${organizerList.email}" /></td>
					    <td><c:out value="${organizerList.phoneNumber}" /></td>
						<td><a
							href="oragnizer_delete?organizer_id=${organizerList.id}">Delete</a><br>
						<br><a href="organizer_edit?organizer_id=${organizerList.id}">Edit</a></td>
					</tr>

				</c:forEach>


			</tbody>
		</table>
	</div>
	<a href="admin_after_login.html">Go to dashboard</a>
</body>
</html>