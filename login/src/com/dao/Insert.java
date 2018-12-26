package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.model.Student;

public class Insert {
	static List<Student> stu=new ArrayList<Student>();
	static Student s = new Student();

	static void ins() {

		s.setId(1);
		s.setName("pinal");
		s.setEmail("pinal@gmail.com");
		s.setPassword("1234");
		/*
		 * stu.add(new Student(1, "pinal", "p@gmail.com", "1234")); stu.add(new
		 * Student(2, "chintan", "c@gmail.com", "1234"));
		 */
		// System.out.println(stu);
		stu.add(s);

	}

	public static void main(String[] args) {

		ins();
		// System.out.println(stu);
		for (Student s : stu) {
			System.out.println(s.getId() + " " + s.getName());
		}
	}
}
