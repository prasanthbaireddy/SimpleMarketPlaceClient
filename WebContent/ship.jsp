<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
<!-- load bootstrap css -->
<style>
body {
	padding-top: 80px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<div align="right">
		<form action="signout" method="post">
			<button type="submit" class="btn btn-default btn-sm">SignOut</button>
		</form>
	</div>
	<div class="container">
	<h1 align="center"><span class="label label-warning">Simple Market Place</span></h1>
		<div class="col-sm-3 col-sm-offset-3">
			<form action="addtocart" method="post">
			<button type="submit" class="btn btn-warning btn-sm">Back To Home</button>
			</form>
			<hr>
			<p>
				<h2><span class="label label-success">Payment Successful.Your Items will be Shipped Shortly</span></h2>
				
				
			</p>
		</div>
	</div>
	<h4 align="center"><span class="label label-info">Thank You for Shopping with us</span></h4>

</body>
</html>