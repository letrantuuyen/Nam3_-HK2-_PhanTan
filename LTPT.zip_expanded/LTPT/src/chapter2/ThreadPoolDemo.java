package chapter2;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import chapter1.SumTask;

public class ThreadPoolDemo {
	public static void main(String[] args) {
		
		SumTask sum1 = new SumTask(0, 100);
		SumTask sum2 = new SumTask(100, 200);
		SumTask sum3 = new SumTask(200, 300);
		SumTask sum4 = new SumTask(300, 400);
		
		// phương thức newFixedThreadPool(5) chỉ lấy n task dù có nhiều thread nhưng chỉ lấy n cái
	//	ExecutorService pool = Executors.newFixedThreadPool(5);
		// phương thức newCatched lấy tất cả các thread
		ExecutorService pool = Executors.newCachedThreadPool();
		pool.submit(sum1);
		pool.submit(sum2);
		pool.submit(sum3);
		pool.submit(sum4);
		
		pool.shutdown();
		
	}

}
