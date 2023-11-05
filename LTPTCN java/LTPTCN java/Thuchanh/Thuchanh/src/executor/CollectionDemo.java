package executor;

import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CollectionDemo {
	
	static List<Integer> list = new Vector<Integer>();
//	static List<Integer> list = new ArrayList<Integer>(); //
	
	
	public static void main(String[] args) {
		
		Runnable task = () -> {
			Random rd = new Random();
			list.add(rd.nextInt(100));
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		for (int i = 0; i < 100; i++) {
			service.submit(task);
		}
		
		service.shutdown();
		while(!service.isTerminated()) {}
		
		
		System.out.println(list.size());
	}
}
