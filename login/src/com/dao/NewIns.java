package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.model.Student;

public class NewIns {

	static int insert(Student s)
	{
		 List<Student> student=new ArrayList<Student>();
		int status=0;
		try {
			s.getId();
			s.getName();
			s.getEmail();
			s.getPassword();
			student.add(s);
			System.out.println(student.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
}
