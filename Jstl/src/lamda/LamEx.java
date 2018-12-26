package lamda;

interface i {
	public void hel(int a,int b);
	default void m1() {
		System.out.println("default method ");
	}
	static void m2()
	{
		System.out.println("static  method");
	}
	
}

public class LamEx {
	public static void main(String[] args) 
	{	
		i i1 =(a,b)->System.out.println(a+b);
		i1.hel(10,20);
		i1.m1();
		i.m2();
	}
}
