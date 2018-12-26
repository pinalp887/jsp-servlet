package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.model.Student;

public class TnewInst {
	static Student s=new Student();
	static Student insert(Student s) {
		//Student s = new Student();
		s.getId();
		s.getName();
		s.getEmail();
		s.getPassword();
		//list.add(s);
		return s;
		
	}

	public static void main(String[] args) {
		
		
		s.setId(1);
		s.setName("pinal");
		s.setEmail("p@gmail");
		s.setPassword("2134");
		List<Student> nlist=new ArrayList<Student>();
		nlist.add(insert(s));
		System.out.println(nlist);
		
		for(Student ss:nlist)
		{
			System.out.println(ss.getId());
			System.out.println(ss.getName());
			System.out.println(ss.getEmail());
			System.out.println(ss.getPassword());
		}
	}
}
