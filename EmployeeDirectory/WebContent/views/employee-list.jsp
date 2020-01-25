<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Employee Directory</title>
	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<style>
	body {
		font-size: 17 px;
		font-family: arial;
		background: #f4f4f4;
		line-height: 1.5 em;
	}
	
	header {
		color: white;
		text-align: center;
		background-color: #000;
		padding: 20px;
		border: 3px #ff6347 solid;
		margin: 5px;
		background-color: #000;
	}
</style>
</head>
<body>
	<header>
		<h1>Employee Directory App | List Employees</h1>
	</header>

	<div class = "container">
		<br>
		<hr>
		<br>
		<!-- Add Button -->
		<button class="btn btn-primary btn-block" onclick = " window.location.href= 'views/employee-add.jsp' " >ADD EMPLOYEE</button>
		<h3 style = "color : red" >${message}</h3>
		<br>
		<hr>
		<br>
		<!-- Employee table -->
		<table class="table table-dark table-striped" >
			<thead>
				<tr>
					<th>NAME</th>
					<th>DOB</th>
					<th>DEPARTMENT</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employees}" var="employee">
					<tr>
						<td>${employee.name}</td>
						<td>${employee.dob}</td>
						<td>${employee.department}</td>
						<td>
						
							<a href = "${pageContext.request.contextPath}/EmployeeServletController?action=EDIT&id=${employee.id}">edit</a> |
							<a href = "${pageContext.request.contextPath}/EmployeeServletController?action=DELETE&id=${employee.id}">delete</a>
						
						
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>



</body>
</html>