<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.util.DbUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Blob"%>

<%@ page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Blob file = null;
		byte[] filedata = null;
		try {
			Connection con = DbUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("select img from register where id=36");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				file = rs.getBlob("img");
				filedata = file.getBytes(1, (int) file.length());
				response.setContentType("image/jpeg");
				response.getOutputStream().write(filedata);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>
</body>
</html>