package com.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.invalidate();
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String status = EmpDao.activateStatus(request.getParameter("email"));
		if (status.equalsIgnoreCase("not")) {
			out.println("<h1 style='color:red'>Please first verify your account  </h1>");
			request.getRequestDispatcher("login.jsp").include(request, response);
		} else {
			if (EmpDao.login(request.getParameter("email"), request.getParameter("password"))) {
				System.out.println("done");
				HttpSession session=request.getSession();
				//System.out.println( request.getParameter("email"));
				String email=request.getParameter("email");
				session.setAttribute("email", email);
				response.sendRedirect("welcome.jsp");
			} else {
				out.print("<h1 style='color:red;'>Please Enter Correct Details</h1>");
				request.getRequestDispatcher("login.jsp").include(request, response);
			}
		}

	}

}
