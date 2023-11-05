package executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import tasks.CheckPrimeNumberTask;

public class TaskExecutor {
	
	

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Random rd = new Random();
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		List<Callable<Boolean>> tasks = new ArrayList<Callable<Boolean>>();
		
		
		for (int i = 0; i < 10; i++) {
			int n = rd.nextInt(100) + 1;
			System.out.println(n);
			tasks.add(new CheckPrimeNumberTask(n));
		}
		
		List<Future<Boolean>> fus = service.invokeAll(tasks);
		
		service.shutdown();
		
		while(!service.isTerminated()) {} //doi den khi cac cong viec xong
		
		for(Future<Boolean> f : fus) {
			System.out.println(f.get());
		}
		
		
//		
//		Callable<Boolean> call = new CheckPrimeNumberTask(7);
//		FutureTask<Boolean> fu = new FutureTask<>(call);
//
//		Thread thread2 = new Thread(fu);
//		thread2.start();
//		
//		Boolean result = fu.get();
//		System.out.println(result);
		
	}

}
