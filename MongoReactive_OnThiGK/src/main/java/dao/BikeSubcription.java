package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import entity.Product;

public class BikeSubcription<T> implements Subscriber<T> {
	private CountDownLatch latch;
	private List<T> result;
	private Subscription s;

	public BikeSubcription() {
		super();
		result = new ArrayList<>();
		latch = new CountDownLatch(1);
	}

	public void onSubscribe(Subscription s) {
		this.s = s;
		this.s.request(1);
	}

	public void onNext(T t) {
		// TODO Auto-generated method stub
		result.add(t);
		this.s.request(1);
	}

	public void onError(Throwable t) {
		// TODO Auto-generated method stub
		t.printStackTrace();
	}

	public void onComplete() {
		// TODO Auto-generated method stub
		latch.countDown();
		
	}

	public void await() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public T getSingleResult() {
		await();
		return result.size() > 0 ? result.get(0) : null;
	}
	public List<T> getResult(){
		await();
		return result;
	}
}
