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

	<div class="container">
	<h1 align="center"><span class="label label-warning">Simple Market Place</span></h1>
		<div class="col-sm-3 col-sm-offset-3">
			<h1>
				<span class="fa fa-sign-in"></span> Login
			</h1>

			<!-- LOGIN FORM -->

			<%
				if (session.getAttribute("error") != null) {
			%>
			<span class="label label-danger"><%=session.getAttribute("error")%></span>
			<%
				}
			%>
			<form action="login" method="post">
				<div class="form-group">
					<label>Email</label> <input type="text" class="form-control"
						name="email" required="true">
				</div>
				<div class="form-group">
					<label>Password</label> <input type="password" class="form-control"
						name="password" required="true">
				</div>

				<button type="submit" class="btn btn-warning btn-sm">Login</button>
			</form>
			<hr>
			<p>
				Need an account? <a href="signup.jsp">Signup</a>
			</p>
		</div>
	</div>

</body>
</html>