package com.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ForgotPasswordController extends HttpServlet {
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
			HttpSession session=request.getSession();
			session.setAttribute("email",request.getParameter("email"));
			response.sendRedirect("resetPassword.jsp");
		}
		else
		{
			System.out.println("not done");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (EmpDao.isEmailExixst(request.getParameter("email"))) {
			EmpDao.resetAccount(request.getParameter("email"));
		} else {
			out.println("<h1 style='color:red'>This email id is not registered </h1>");
			request.getRequestDispatcher("forgot.jsp").include(request, response);
		}
	}

}
