<%@page import="java.util.ArrayList"%>
<%@page import="com.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- <%!
	List<Student> stu=new ArrayList<Student>();
		public String doSome(String s) {
			return s;
		}
		
	%><!--  -->
	<%
		String test=doSome("new ");
	%>
	<%
		out.println(test);
	%> --%>
	<form action="Ins" method="post">
		<table align="center">
			<tr>
				<td>ID : <input type="text" placeholder="ID" name="id"></td>
			</tr>
			<tr>
				<td>Name : <input type="text" placeholder="name" name="name"></td>
			</tr>
			<tr>
				<td>Email : <input type="text" placeholder="email" name="email"></td>
			</tr>
			<tr>
				<td>Password : <input type="password" placeholder="password"
					name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>

		</table>
	</form>
</body>
</html>