<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);%>
    <style type="text/css">
    	.valid{
		border:1px solid green
	}
	.error{
		color:red
	}
    </style>
</head>
<body>
<form action="LoginController" method="post" id="LoginForm">
	<table>
		<tr>
			<td>Email :</td>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
			<td>Password :</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td><input type="submit" value="Log In"></td>
		</tr>
	</table>
	<a href="index.jsp">Register here!</a>
	<a href="forgot.jsp">forgot password!</a>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>
		<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.js"></script>
		<script type="text/javascript">
			$(document).ready(function () {
				$("#LoginForm").validate({
					rules:{
						email:{
							required:true,
							email:true,
						},
						password:{
							required:true,
							minlength:6
						},
					},
				}); 
			});
		</script>
</form>
</body>
</html>