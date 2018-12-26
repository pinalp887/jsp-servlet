package com.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.util.DbUtil;
@MultipartConfig(maxFileSize=169999999)
public class File extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Part part=request.getPart("file");
			System.out.println(part);
			InputStream inputStream=null;
			if(part!=null)
			{
				//long filesize=part.getSize();
				//String filecontent=part.getContentType();
				inputStream=part.getInputStream();
			}
			
			System.out.println(inputStream);
			Connection con=DbUtil.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into register(img) values(?)");
			ps.setBinaryStream(1, inputStream,part.getSize());
			int status=ps.executeUpdate();
			System.out.println(status);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
