package chapter1;

public class ThreadDemo2 {
	public static void main(String[] args) {
	//	new Thread(new OtherThread(10)).start();
		new Thread(new OtherThreadYield(10)).start();
	}

}
