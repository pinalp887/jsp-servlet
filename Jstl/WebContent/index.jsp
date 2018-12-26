<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="InsertController" method="post">

		<table>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><textarea rows="5" cols="15" name="address"></textarea></td>
			</tr>
			<tr>
				<td>City :</td>
				<td><input type="text" name="city"></td>
			</tr>
			<tr>
				<td>State :</td>
				<td><input type="text" name="state"></td>
			</tr>
			<tr>
				<td>Nationality :</td>
				<td><input type="text" name="nationality"></td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td><input type="radio" name="gender" value="male">Male
					<input type="radio" name="gender" value="female">Female</td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>

</body>
</html>