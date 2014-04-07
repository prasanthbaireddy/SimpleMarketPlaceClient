<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
<!-- load bootstrap css -->
<style>
body {
	padding-top: 20px;
}
</style>
<title>Home</title>
</head>

<body>
	<div align="right">
		<form action="signout" method="post">
			<button type="submit" class="btn btn-default btn-sm">SignOut</button>
		</form>
	</div>
	<span class="label label-warning">Welcome <%=session.getAttribute("user")%></span>
	<span class="label label-info">Your last login was on : <%=session.getAttribute("logintime")%></span>


	<ul class="nav nav-tabs nav-justified">
		<div align="right">
			<form method="post" action="cart">
				<button type="submit" class="btn btn-primary btn-lg">
					<span class="glyphicon glyphicon-shopping-cart"></span> Cart
				</button>
			</form>
		</div>
		<li><a href="home.jsp">Home</a></li>
		<li class="active"><a href="#">Advertise</a></li>
		<li><a href="purchase.jsp">Purchase</a></li>

	</ul>
	<div class="container">

		<div class="col-sm-3 col-sm-offset-3">

			<form action="advertise" method="post">
				<div class="form-group">
					<label>Product Name</label> <input type="text" class="form-control"
						name="pname">
				</div>
				<div class="form-group">
					<label>Description</label>
					<textarea class="form-control" name="pdesc"></textarea>

				</div>
				<div class="form-group">
					<label>Seller Info</label>
					<textarea class="form-control" name="sinfo"></textarea>
				</div>
				<div class="form-group">
					<label>Quantity</label> <input type="number" min="1"
						class="form-control" name="quantity">
				</div>
				<div class="form-group">
					<label>Price</label> <input type="integer" class="form-control"
						name="price">
				</div>

				<button type="submit" class="btn btn-warning btn-sm">Submit</button>
			</form>
			<%
				if (session.getAttribute("status") != null) {
			%>
			<div>
				<span class="label label-danger"><%=session.getAttribute("status")%></span>
			</div>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>