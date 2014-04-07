<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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
		<li><a href="advertise.jsp">Advertise</a></li>
		<li class="active"><a href="#">Purchase</a></li>

	</ul>
	<div class="container">
	
		<div class="col-sm-15 col-sm-offset-0">
			<div>Advertisements</div>
			<%
		if (session.getAttribute("addstatus") != null) {
	%>
	<span class="label label-success"><%=session.getAttribute("addstatus")%></span>
	<%
		}
	%>
			<table class="table table-hover">
				<tr>
					<td><span class="label label-info">ProductName</span></td>
					<td><span class="label label-info">Product Description</span></td>
					<td><span class="label label-info">Seller Info</span></td>
					<td><span class="label label-info">Price(US $)</span></td>
					<td><span class="label label-info">Quantity Available</span></td>
				</tr>
				<c:forEach var="product" items="${sessionScope.products}">

					<c:set var="splittedString" value="${fn:split(product, ',')}" />
					<tr>
						<form action="addtocart" method="post">
							<c:forEach var="item" items="${splittedString}"
								varStatus="countVar">
								<c:set var="index" value="${countVar.count}" />

								<c:choose>
									<c:when test="${index != 6}">
										<td><c:out value="${item}" /></td>
									</c:when>
									<c:otherwise>
										<c:set var="id" value="${item}" />

									</c:otherwise>
								</c:choose>
								<c:if test="${index == 1}">
									<c:set var="pname" value="${item}" />
								</c:if>
								<c:if test="${index == 2}">
									<c:set var="pdescription" value="${item}" />
								</c:if>
								<c:if test="${index == 3}">
									<c:set var="sInfo" value="${item}" />
								</c:if>
								<c:if test="${index == 4}">
									<c:set var="price" value="${item}" />
								</c:if>
								<c:if test="${index == 5}">
									<c:set var="quantity" value="${item}" />
								</c:if>

							</c:forEach>
							<td><input type="number" min="1" max="${quantity}"
								class="form-control" name="squant"></td> <input type="hidden"
								name="id" value="${id}"> <input type="hidden"
								name="pname" value="${pname}"> <input type="hidden"
								name="pdescription" value="${pdescription}"> <input
								type="hidden" name="price" value="${price}">

							<td><button type="submit" class="btn btn-info btn-sm">Add
									to Cart</button></td>
						</form>
					</tr>

				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>