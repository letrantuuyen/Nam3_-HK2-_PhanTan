package chapter1;

public class SumTask implements Runnable {
	
	private int a;
	private int b;
	public SumTask(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	@Override
	public void run() {
		int total = 0;
		// TODO Auto-generated method stub
		for(int i=a; i<b ;i++) {
			total+= i;
		}
		System.out.println( Thread.currentThread().getName() +  "Total : " + total);
	}
	
	

}
