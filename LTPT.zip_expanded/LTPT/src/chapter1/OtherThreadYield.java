package chapter1;
// Class này vừa yield vừa join vừa sleep
public class OtherThreadYield implements Runnable {
	
	private int n;
	
	
	public OtherThreadYield(int n) {
		super();
		this.n = n;
	}

// Phương thức sleep, thời gian nghỉ của từng biến
	@Override
	public void run() {
		Thread t = new Thread(new CharPrinter('H', 20));
		t.start();
		for(int i=0;i<n;i++) {
			
			try {
			System.out.print( "Vi tri: " + i + "\n");
			
				if(i == 5 )
					t.join();
				
			//	Thread.sleep(1000);
			//	Thread.yield();
			} catch(InterruptedException e) {
				e.printStackTrace();
				
			}
			
		}
		// TODO Auto-generated method stub
		
	}

}
