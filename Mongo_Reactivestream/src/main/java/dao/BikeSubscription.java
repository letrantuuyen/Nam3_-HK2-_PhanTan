package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class BikeSubscription<T> implements Subscriber<T> {
	private Subscription subscription;
	private CountDownLatch latch;
	private List<T> result;
	
	

	public BikeSubscription() {
		super();
		this.latch = new CountDownLatch(1);
		this.result = new ArrayList<T>();
	}

	public void onSubscribe(Subscription s) {
		// TODO Auto-generated method stub
		this.subscription = s;
		this.subscription.request(1);
		
	}

	public void onNext(T t) {
		// TODO Auto-generated method stub
		this.result.add(t);
		this.subscription.request(1);
	}

	public void onError(Throwable t) {
		// TODO Auto-generated method stub
		t.printStackTrace();
		
	}

	public void onComplete() {
		// TODO Auto-generated method stub
		latch.countDown();
		System.out.println("Complete");
		
	}
	public void await() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<T> getResult() {
		await();
		
		return result;
	}
	public T getSingleResult() {
		await();
		return result.size() > 0 ? result.get(0) : null;
	}

}
