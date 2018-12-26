package com.test;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class NewConnectionPool {

	static Connection con=null;
	static {
		try {
			Context context=new InitialContext();
			DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/testcon");
			con=ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getcon()
	{
		return con;
	}
}
