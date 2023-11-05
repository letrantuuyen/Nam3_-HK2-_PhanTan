package chapter1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class NumberRangeCallableDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Callable<Long> task1 = new NumRangCallable(0, 50);
		Callable<Long> task2 = new NumRangCallable(50, 100);
		Callable<Long> task3 = new NumRangCallable(100, 150);
		Callable<Long> task4 = new NumRangCallable(150, 200);
		// tạo biến future để lưu task
		FutureTask<Long> f1 = new FutureTask<>(task1);
		FutureTask<Long> f2 = new FutureTask<>(task2);
		FutureTask<Long> f3 = new FutureTask<>(task3);
		FutureTask<Long> f4 = new FutureTask<>(task4);
		
		Thread thread1 = new Thread(f1);
		Thread thread2 = new Thread(f2);
		Thread thread3 = new Thread(f3);
		Thread thread4 = new Thread(f4);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		long total = f1.get() + f2.get() + f3.get() + f4.get();
		System.out.println("Total : "+ total);
		
		
	}
}
