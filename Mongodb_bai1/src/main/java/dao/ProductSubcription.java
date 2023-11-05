package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import com.mongodb.client.result.InsertOneResult;

public class ProductSubcription<T> implements Subscriber<T> {
	private List<T> result;
	private CountDownLatch latch;
	private Subscription subscription;
	
	

	public ProductSubcription() {
		super();
		this.result = new ArrayList<T>();
		this.latch = new CountDownLatch(1);
	}

	@Override
	public void onSubscribe(Subscription s) {
		// TODO Auto-generated method stub
		this.subscription = s;
		this.subscription.request(1);
		
	}

	@Override
	public void onNext(T t) {
		// TODO Auto-generated method stub
		this.result.add(t);
		this.subscription.request(1);
	}

	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub
		t.printStackTrace();
		
	}

	@Override
	public void onComplete() {
		// TODO Auto-generated method stub
		latch.countDown();
		System.out.println("complete");
		
	}
	public List<T> getResult(){
		
		try {
			latch.await();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return result;
	}
	
	public T getSingleResults() {
		try {
			latch.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result.size()>0 ? result.get(0):null;
	}


	
	
	
}
