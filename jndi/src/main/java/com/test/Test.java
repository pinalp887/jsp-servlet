package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       static DataSource data=null;
       public static void all(PrintWriter out)
       {
    	   Connection con=null;
    	   PreparedStatement ps=null;
    	   try {
			String sql="select * from student";
			con=data.getConnection();
			ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String email=rs.getString(3);
				out.println(id);
				out.print(name);
				out.println(email);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
       }
    public void init(ServletConfig config)
    {
    	try {
			Context initcontext=new InitialContext();
			Context envContext=(Context) initcontext.lookup("java:/comp/env");
			data=(DataSource) envContext.lookup("jdbc/testcon");
			System.out.println(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		all(out);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
