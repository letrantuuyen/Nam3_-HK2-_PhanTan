package tasks;

import java.util.concurrent.Callable;

public class CheckPrimeNumberTask implements Callable<Boolean>{
	
	private int n;

	public CheckPrimeNumberTask(int n) {
		super();
		this.n = n;
	}

	@Override
	public Boolean call() throws Exception {
		
		if(n <= 1) {
			return false;
		}
		for(int i = 2; i<n/2; i++) {
			if((n%i) == 0) {
				return false;
			}
		}
		
		
		return true;

	}


}
