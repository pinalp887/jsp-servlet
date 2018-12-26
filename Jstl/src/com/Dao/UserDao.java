package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;
import com.util.DbUtil;

public class UserDao {

	public static Connection getcon() {
		Connection con = null;
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static int insert(Student s) {
		int status = 0;
		try {
			Connection con = DbUtil.getcon();
			PreparedStatement ps = con.prepareStatement(
					"insert into student(name,email,password,address,city,state,nationality,gender)values(?,?,?,?,?,?,?,?)");
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getPassword());
			ps.setString(4, s.getAddress());
			ps.setString(5, s.getCity());
			ps.setString(6, s.getState());
			ps.setString(7, s.getNationality());
			ps.setString(8, s.getGender());
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static List<Student> getAll() throws SQLException {

		Connection con = DbUtil.getcon();
		PreparedStatement ps = con.prepareStatement("select * from student");
		ResultSet rs = ps.executeQuery();
		List<Student> list = new ArrayList<Student>();
		while (rs.next()) {
			Student s = new Student();
			s.setId(rs.getInt("id"));
			s.setName(rs.getString("name"));
			s.setEmail(rs.getString("email"));
			s.setPassword(rs.getString("password"));
			s.setAddress(rs.getString("address"));
			s.setCity(rs.getString("city"));
			s.setState(rs.getString("state"));
			s.setNationality(rs.getString("nationality"));
			s.setGender(rs.getString("gender"));
			list.add(s);
		}

		return list;
	}
}
