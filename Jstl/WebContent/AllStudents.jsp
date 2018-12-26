<%@page import="java.util.ArrayList"%>
<%@page import="com.Dao.UserDao"%>
<%@page import="com.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<table border="1px">
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Email</td>
			<td>Password</td>
			<td>Address</td>
			<td>City</td>
			<td>State</td>
			<td>Nationality</td>
			<td>Gender</td>
			<td>Edit</td>
			<td>Delete</td>
		</tr>
	
		 <c:forEach items="${slist}" var="s">
			<tr>
				<td>
				<c:out value="${s.name}"></c:out>
				 </td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>