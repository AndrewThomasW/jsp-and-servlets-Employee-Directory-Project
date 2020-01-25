<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
	
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
		margin-bottom : 50px;
		background-color: #000;s
	}
</style>
	
</head>
<body>
	<header>
		<h1>Employee Directory App </h1>
	</header>
	<div class="container">
		
		
				<div class="card">
					<article class="card-body">
						<a href="" class="float-right btn btn-outline-primary">Sign up</a>
						<h4 class="card-title mb-4 mt-1">Sign in</h4>
						
						<form action = "${pageContext.request.contextPath}/LoginServletController" method = "POST">
							<div class="form-group">
								<label>Your email</label> 
								<input type="email" name="email" class="form-control" placeholder="Email" >
							</div>

							<div class="form-group">
								<label>Your password</label> 
								<input type="password" name="password" class="form-control"placeholder="******" >
							</div>

							<div class="form-group">
								<button type="submit" class="btn btn-primary btn-block">Login</button>
							</div>
						</form>
						
					</article>
				</div><!-- card.// -->
		
	</div>

</body>
</html>