package com;

import java.util.Scanner;

public class Febo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int feb=sc.nextInt();
		int[] Febo=new int[feb];
		Febo[0]=1;
		Febo[1]=2;
		for(int i=2;i<feb;i++) {
			Febo[i]=Febo[i-1]+Febo[i-2];
		}
		for(int i=0;i<feb;i++)
		{
			System.out.print(Febo[i]+" ");
		}
	}

}
