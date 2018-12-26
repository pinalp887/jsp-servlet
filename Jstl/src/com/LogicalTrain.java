package com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.apache.tomcat.util.security.Escape;

public class LogicalTrain {
	static Map<Integer, List<Integer>> map=new HashMap<>();
	 List<Integer> list=null;
	 static Collection<List<Integer>> al;
	static int count=1;
public static void main(String[] args) {
	int n=1;
	List<Integer> list=null;
	
	for(int i=0;i<6;i++)
	{
		list=new ArrayList<>();
		for(int j=0;j<6;j++)
		{
			list.add(n);
			//System.out.println(n);
			n++;
		}
		map.put(i, list);
	}
	System.out.println(map.size());
	al=map.values();
	Scanner sc=new Scanner(System.in);
	int seat=sc.nextInt();
	for(List<Integer> li:al)
	{
		count++;
		if(count%2!=0)
		{
			Collections.reverse(li);
			
			System.out.println(li);
		}
		else
		{
			System.out.println(li);
			
		}
		//System.out.println("in odd"+li.contains(seat));
		//System.out.println("out  "+li.contains(seat));
		int index=li.indexOf(seat);
		if(index==0 || index==5)
		{
			System.out.println("Window Seat  "+seat);
		}else if(index==1 || index==4)
		{
			System.out.println("Middle seat "+seat);
		}
		else if (index==2 || index==3) {
			System.out.println("Asile Seat  " +seat);
		}
		//System.out.println("index ix "+index);
	
	}
	
}
}
