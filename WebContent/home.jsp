<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<li class="active"><a href="#">Home</a></li>
		<li><a href="advertise.jsp">Advertise</a></li>
		<li><a href="purchase.jsp">Purchase</a></li>
	</ul>
<div class="col-sm-4 col-sm-offset-0">
	<table class="table table-hover">
<span class="label label-info">Purchased Items</span>
<tr>
<td>Product Name</td>
<td>Quantity Purchased</td>
</tr>
		<c:forEach var="product" items="${sessionScope.purchasedProducts}"
			varStatus="cartCount">

			<tr>
				<td>${product.key}</td>
				<td>${product.value}</td>
			</tr>
		</c:forEach>
<tr>
<td><c:if test="${empty sessionScope.purchasedProducts}">
	<h3 align="center">
		<span class="label label-warning">You Purchased 0 Items</span>
	</h3>
	</c:if>
</td>
</tr>
	</table>

</div>

<div class="col-sm-4 col-sm-offset-4">
	<table class="table table-hover">
<span class="label label-info">Sold Items</span>
<tr>
<td>Product Name</td>
<td>Quantity Sold</td>
</tr>
		<c:forEach var="product" items="${sessionScope.soldProducts}"
			varStatus="cartCount">

			<tr>
				<td>${product.key}</td>
				<td>${product.value}</td>
			</tr>
		</c:forEach>

<tr><td><c:if test="${empty sessionScope.soldProducts}">
	<h3 align="center">
		<span class="label label-warning">You Sold 0 Items</span>
	</h3>
	</c:if></td></tr>
	</table>

</div>

	
</body>
</html>