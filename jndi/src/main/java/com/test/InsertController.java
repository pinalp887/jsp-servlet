package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Student s = new Student();
		s.setName(request.getParameter("name"));
		s.setEmail(request.getParameter("email"));
		s.setPassword(request.getParameter("password"));
		s.setAddress(request.getParameter("address"));
		s.setCity(request.getParameter("city"));
		s.setState(request.getParameter("state"));
		s.setNationality(request.getParameter("nationality"));
		s.setGender(request.getParameter("gender"));
		int status=DatabseJNDI.insert(s);
		out.println(status);
	}

}
