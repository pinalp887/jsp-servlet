package lamda;

interface A {
	public int squre(int n);
}

public class NewLam {

	public static void main(String[] args) {
		A a = n -> {return n * n;};
		System.out.println(a.squre(6));
	}
}
