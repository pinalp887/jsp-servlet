package com.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Employee;

public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Employee e=new Employee();
		e.setName(request.getParameter("name"));
		e.setEmail(request.getParameter("email"));
		e.setPassword(request.getParameter("password"));
		String email= request.getParameter("email");
		if(EmpDao.isEmailExixst(request.getParameter("email")) ) {
		//	System.out.println("email is exist");
			out.println("<h1 style='color:red'>This email id is already registered </h1>");
			request.getRequestDispatcher("index.jsp").include(request, response);
		}
		else {
		int status=EmpDao.insert(e);
		response.sendRedirect("login.jsp");
		}
		System.out.println("done");
	}

}
