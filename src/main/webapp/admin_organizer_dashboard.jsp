<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    </tr>
  </thead>
  <tbody>
 <c:forEach items="${applicationScope.organizer_list}" var="organizerList">
 
 <tr>
      <th scope="row"><c:out value="${organizerList.}" /></th>
      <td><c:out value="${organizerList.id}" /></td>
      <td><c:out value="${organizerList.name}" /></td>
      <td><c:out value="${organizerList.email}" /></td>
      <td><c:out value="${organizerList.number}" /></td>
      <td><a href="oragnizer_delete?organizer_id=${organizerList.id}">Delete</a></td>
      <td><a href="organizer_edit?organizer_id=${organizerList.id}">Edit</a></td>
    </tr>
  
  </c:forEach>
    
    
    
    
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Larry the Bird</td>
      <td>Larry the Bird</td>
      <td>@twitter</td>
    </tr>
  </tbody>
</table>
</div>
</body>
</html>