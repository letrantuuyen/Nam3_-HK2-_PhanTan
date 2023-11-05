package chapter2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo2 {
	
	private static CountTask obj = new CountTask();
	
	public static void main(String[] args) throws InterruptedException {
		// biểu thức lamda
		Runnable task = () -> {
			obj.inc();
		};
		ExecutorService pool = Executors.newCachedThreadPool();
		for(int i=0; i<100; i++) {
			pool.submit(task);
		}
		// lúc nào cũng phải shutdown
		pool.shutdown();
		// hết 10 không lấy kết quả
		//cách 1
	//	pool.awaitTermination(10, TimeUnit.SECONDS);
		//cách 2
		while(!pool.isTerminated()){
			// đợi công việc
		}
		// isterminated trả về true
		System.out.println("Count :" + obj.getCount());
		
	}
	

}
