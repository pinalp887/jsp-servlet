package com.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActivationUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String tok=request.getParameter("token");
		System.out.println("servlet  "+tok);
		String FinalToken=EmpDao.checkToken(request.getParameter("email"), tok);
		System.out.println("final  "+FinalToken);
		if(tok.equals(FinalToken))
		{
			EmpDao.activeAccount(request.getParameter("email"));
			response.sendRedirect("login.jsp");
		}
		else
		{
			System.out.println("not done");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
