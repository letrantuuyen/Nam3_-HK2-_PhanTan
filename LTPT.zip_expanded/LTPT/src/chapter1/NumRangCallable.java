package chapter1;

import java.util.Iterator;
import java.util.concurrent.Callable;

public class NumRangCallable implements Callable<Long> {

	private long a;
	private long b;
	
	public NumRangCallable(long a, long b) {
		super();
		this.a = a;
		this.b = b;
	}

	@Override
	public Long call() throws Exception {
		// TODO Auto-generated method stub
		long total = 0l;
		
		for(long i=0;i<b;i++) {
			total +=i;
		}
		
		return total;
	}

}
