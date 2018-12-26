package lamda;

public class ThreadDemo {
	public static void main(String[] args) {
		Runnable r = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("inr thread with lamda");
			}
		};
		Thread t = new Thread(r);
		t.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("in main Thread");
		}
	}
}
