<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout</title>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
<!-- load bootstrap css -->
<style>
body {
	padding-top: 80px;
}
</style>
</head>
<body>

<div align="right">
		<form action="signout" method="post">
			<button type="submit" class="btn btn-default btn-sm">SignOut</button>
		</form>
	</div>
	<div align="right">
			<form method="post" action="cart">
				<button type="submit" class="btn btn-primary btn-lg">
					<span class="glyphicon glyphicon-shopping-cart"></span> Cart
				</button>
			</form>
		</div>
	<div class="container">
	<%
				if (session.getAttribute("creditcarderror") != null) {
			%>
			<span class="label label-danger"><%=session.getAttribute("creditcarderror")%></span>
			<%
				}
			%>
	
		<div class="col-sm-3 col-sm-offset-3">
			<form action="ship" method="post">
				<div class="form-group">
					<label>Full Name:</label> <input type="text" class="form-control"
						name="fullname" required="true">
				</div>
				<div class="form-group">
					<label>Address:</label> <input type="text" class="form-control"
						name="address" required="true">
				</div>
				<div class="form-group">
					<label>City</label> <input type="text" class="form-control"
						name="city" required="true">
				</div>
				<div class="form-group">
					<label>State/Province/Region</label> <input type="text"
						class="form-control" name="location" required="true">
				</div>
				<div class="form-group">
					<label>Zip</label> <input type="text" class="form-control"
						name="zip" required="true">
				</div>
				<div class="form-group">
					<label>Country</label> <input type="text" class="form-control"
						name="country" required="true">
				</div>
				<div class="form-group">
					<label>Phone Number</label> <input type="text" class="form-control"
						name="phno" required="true">
				</div>
				<h1>
					<span class="fa fa-sign-in"></span> Credit Card Information
				</h1>
				<div class="form-group">
					<label>Card Number</label> <input type="text" class="form-control"
						size="16" name="cardno" required="true">
				</div>
				<div class="form-group">
					<label>CVC</label> <input type="text" class="form-control" size="3"
						name="cvc" required="true">
				</div>
				<button type="submit" class="btn btn-info btn-bg">Pay</button>
			</form>
		</div>
	</div>
</body>
</html>