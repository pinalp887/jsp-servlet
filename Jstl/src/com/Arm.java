package com;

public class Arm {
public static void main(String[] args) {
	int num=153;
	int n=num;
	int sum=0;
	while(num>0)
	{
		int r=num%10;
		System.out.println(r);
		sum=sum+r*r*r;
		System.out.println(sum);
		num=num/10;
		System.out.println(num);
	}
}
}
