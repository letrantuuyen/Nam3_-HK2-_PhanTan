package chapter1;

//Yield là phương thức nhường 
public class ThreadDemoYield {

	public static void main(String[] args) {
		CharPrinter task1 = new CharPrinter('U', 20);
		CharPrinter task2 = new CharPrinter('V', 20);
		
		OtherThreadYield task3 = new OtherThreadYield(20);
		
		
		Thread thread1 = new Thread(task1);
		Thread thread2 = new Thread(task2);
		Thread thread3 = new Thread(task3);
		
		thread3.setPriority(9);
	//	thread1.setPriority(3);
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		
		
	}
}
