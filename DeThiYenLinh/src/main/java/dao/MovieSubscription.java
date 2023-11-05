package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;


public class MovieSubscription<T> implements Subscriber<T> {
	private CountDownLatch latch;
	private  List<T> result;
	private Subscription subscription;
	
	// khởi tạo các biến
	public MovieSubscription() {
		super();
		this.latch = new CountDownLatch(1);
		this.result = new ArrayList<T>();
		
	}
	@Override
	// nếu subscribe
	// khởi tạo cái subsription
	public void onSubscribe(Subscription s) {
		// TODO Auto-generated method stub
		this.subscription = s;
		this.subscription.request(1);
		
	}
	@Override
	// nếu onNext thì thêm vào mảng 
	public void onNext(T t) {
		// TODO Auto-generated method stub
		this.result.add(t);
		this.subscription.request(1);
	}
	@Override
	// nếu lỗi
	public void onError(Throwable t) {
		// TODO Auto-generated method stub
		t.printStackTrace();
	}
	@Override
	public void onComplete() {
		// TODO Auto-generated method stub
		// đếm ngược 
		latch.countDown();
		System.out.println("Complete");
		
	}
	// viết các phương thức trả về
	public List<T> getResult(){
		try {
			latch.await();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	public T getSingleResult() {
		try {
			latch.await();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result.get(0);
	}
	

	
	

}
