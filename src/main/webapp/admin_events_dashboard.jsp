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

<div class="container justofy-containt-center text-center">
<a href="event_category_table" type="button" class="btn btn-outline-info btn-lg">Play with Categories</a></div>
<br>
<br>
<br>

<div class="container">
		<table class="table table-sm">
			<thead>
				<tr>
					<th scope="col">Event Id</th>
					<th scope="col">Name</th>
					<th scope="col">Venue</th>
					<th scope="col">Price</th>
					<th scope="col">Organizer Id</th>
					<th scope="col">Category</th>
					<th scope="col">Date</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${applicationScope.event_list}"
					var="eventList">
					<tr>
						<th scope="row"><c:out value="${eventList.event_id}" /></th>
						<td><c:out value="${eventList.name}" /></td>
						<td><c:out value="${eventList.venue}" /></td>
						<td><c:out value="${eventList.price}" /></td>
					    <td><c:out value="${eventList.organizer_id}" /></td>
					     <td><c:out value="${eventList.category}" /></td>
					      <td><c:out value="${eventList.date}" /></td>
						<td><a
							href="event_delete?event_id=${eventList.event_id}">Delete</a><br>
						<br><a href="event_edit?event_id=${eventList.event_id}">Edit</a></td>
					</tr>

				</c:forEach>


			</tbody>
		</table>
	</div>
	<a href="admin_after_login.jsp">Go to dashboard</a>
</body>
</html>