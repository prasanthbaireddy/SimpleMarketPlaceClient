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
<title>ShoppingCart</title>
</head>
<body>
	<div align="right">
		<form action="signout" method="post">
			<button type="submit" class="btn btn-default btn-sm">SignOut</button>
		</form>
	</div>
	<div class="container">
		<div class="col-sm-6 col-sm-offset-0">
		
		<c:if test="${empty sessionScope.cartlist}">
			<h3><span class="label label-warning">Your Shopping Cart is Empty</span></h3>
		</c:if>
			<form action="updatecart" method="post">
				<table class="table table-hover">

					<c:forEach var="product" items="${sessionScope.cartlist}"
						varStatus="cartCount">

						<tr>
							<form action="updatecart" method="post">
								<c:forEach var="item" items="${product.value}"
									varStatus="countVar">
									<c:set var="index" value="${countVar.count}" />

									<td><c:out value="${item}" /></td>
								<input type="hidden" name="id" value="${product.key}">
								</c:forEach>
								<td><input type="integer" class="form-control" name="quant"
									min="1"></input></td>
								<td><button name="act" value="update" type="submit" class="btn btn-success btn-sm">Update</button></td>
								<td><button name="act" value="remove" type="submit" class="btn btn-danger btn-sm">
					<span class="glyphicon glyphicon-remove"></span> 
				</button></td>
							</form>
						</tr>
					</c:forEach>
				</table>
				<c:if test="${not empty sessionScope.cartlist}">
				<button name="act" value="checkout" type="submit" class="btn btn-info btn-sm">Proceed to Checkout</button>
				</c:if>
				
				<button name="act" value="shop" type="submit" class="btn btn-info btn-sm">Shop More</button>
			</form>
		</div>
	</div>
</body>
</html>