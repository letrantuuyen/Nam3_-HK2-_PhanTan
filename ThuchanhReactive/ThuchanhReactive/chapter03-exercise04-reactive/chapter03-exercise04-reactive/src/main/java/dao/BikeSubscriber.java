package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class BikeSubscriber<T> implements Subscriber<T> {
	
	private Subscription s;
	private List<T> results;
	private CountDownLatch latch;
	
	public BikeSubscriber() {
		results = new ArrayList<>();
		latch = new CountDownLatch(1);
	}
	
	@Override
	public void onSubscribe(Subscription s) {
		this.s = s;
		this.s.request(1);
	}

	@Override
	public void onNext(T t) {
		results.add(t);
		this.s.request(1);
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
		
		await();
		
		return results;
	}
	
	public void await() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public T getSingleResult() {
		
		await();
		
		return results.size() > 0 ? results.get(0) : null;
	}
}
