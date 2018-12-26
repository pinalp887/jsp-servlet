package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DatabseJNDI {

	public static DataSource getcon()
	{
		DataSource data=null;
		try {
			Context context=new InitialContext();
			Context env=(Context) context.lookup("java:/comp/env");
			data=(DataSource) env.lookup("jdbc/testcon");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public static int insert(Student s)
	{
		int status=0;
		try {
			Connection con=getcon().getConnection();
			PreparedStatement ps=con.prepareStatement("insert into student(name,email,password,address,city,state,nationality,gender) values(?,?,?,?,?,?,?,?)");
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getPassword());
			ps.setString(4, s.getAddress());
			ps.setString(5, s.getCity());
			ps.setString(6, s.getState());
			ps.setString(7, s.getNationality());
			ps.setString(8, s.getGender());
			status=ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
}
