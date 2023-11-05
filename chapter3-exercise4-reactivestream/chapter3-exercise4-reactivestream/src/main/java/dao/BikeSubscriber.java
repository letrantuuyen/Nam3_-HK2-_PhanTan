package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class BikeSubscriber<T> implements Subscriber<T>{
	
	private List<T> results ;
	private Subscription sub;
	private CountDownLatch latch;
	
	public BikeSubscriber() {
		results = new ArrayList<>();
		latch = new CountDownLatch(1);
	}
	

	@Override
	public void onSubscribe(Subscription s) {
		this.sub = s;
		this.sub.request(1);
	}

	@Override
	public void onNext(T t) {
		results.add(t);
		this.sub.request(1);
	}

	@Override
	public void onError(Throwable t) {
		t.printStackTrace();
	}

	@Override
	public void onComplete() {
		latch.countDown();
//		System.out.println("Done");
	}

	public List<T> getResults() {
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	public T getSingleResult() {
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(results.size() == 0)
			throw new RuntimeException("Not found!");
		
		return results.get(0);
	}
}
