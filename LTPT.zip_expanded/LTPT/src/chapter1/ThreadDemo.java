package chapter1;

public class ThreadDemo {
	public static void main(String[] args) {
		// tính thời gian chạy 
		/*
		long startTime = System.nanoTime();
		
		// in 20 kí tự A và B theo từng task
		Runnable task1 = new CharPrinter('A',20);
		Runnable task2 = new CharPrinter('B',20);
		Thread thread1 = new Thread(task1);
		Thread thread2 = new Thread(task2);
		
		//thread1.setName("ThreadOne");
		//thread2.setName("ThreadTwo");

		
		//set độ ưu tiên
		thread1.setPriority(10);
		
		thread1.start();
		thread2.start();
		while(thread1.isAlive()) {
			long endTime = System.nanoTime();
			long totalTime = endTime - startTime;
			*/
			Thread t = Thread.currentThread();
		
	System.out.println(t);
	
		
	}

}
