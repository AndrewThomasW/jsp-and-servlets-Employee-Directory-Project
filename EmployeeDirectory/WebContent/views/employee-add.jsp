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
		<h1>Employee Directory App | Add Form</h1>
	</header>

	<div class = "container">
		<br><hr><br>
		<br><hr><br>
		<!-- Add Form -->
		
		<form  action  = "${pageContext.request.contextPath}/EmployeeServletController" id  = "myform"  method = "POST">
			<div class="form-group">
			<label>Name</label><br>
			<input type = "text" name = "name" class="form-control" placeholder = "enter name">
			</div><br>
			<div class="form-group">
			<label>Date of birth</label><br>
			<input type = "date" name = "dob" class="form-control" placeholder = "enter dob">
			</div><br>
			<div class="form-group">
			<label>Department</label><br>
			<input type = "text" name = "department" class="form-control" placeholder = "enter department">
			</div><br>
			
			<button type = "submit" class="btn btn-primary btn-block" >Add Employee</button>
		</form>
		
	</div>



</body>

</html>














