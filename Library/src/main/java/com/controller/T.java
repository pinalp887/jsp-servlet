package com.controller;

import java.util.ArrayList;
import java.util.List;

import com.model.Library;
import com.model.Student;

public class T {
public static void main(String[] args) {
	Student s=new Student();
	s.setName("pinal");
	
	Library l=new Library();
	l.setB_name("java");
	
	Library l2=new Library();
	l2.setB_name("spring");
	
	//s.setBlist(blist);
	
	s.getBlist().add(l);
	s.getBlist().add(l2);
	l.setStudent(s);
	l2.setStudent(s);
	
	DbUtil.beginTransaction();
	
	DbUtil.manager.persist(s);
	DbUtil.commitTransaction();
}
}
