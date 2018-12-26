package com.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Student;

@WebServlet("/Ins")
public class Ins extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ins() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Student s = new Student();
		s.setId(id);
		s.setName(name);
		s.setEmail(email);
		s.setPassword(password);
		List<Student> stu = new ArrayList<Student>();
		int status = NewIns.insert(s);
		stu.add(s);
		for (Student stud : stu) {

			if (status < 0) {
				out.println("not done");
			} else {
				out.println(stud.getId());
				out.println(stud.getName());
				out.println(stud.getEmail());
				out.println(stud.getPassword());
				out.println("<a href='index.jsp'>Add new </a>");
				// response.sendRedirect("list.jsp");
			}
		}
	}

}
