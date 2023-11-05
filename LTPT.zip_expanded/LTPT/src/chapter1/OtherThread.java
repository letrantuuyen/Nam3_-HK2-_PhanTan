package chapter1;


// Thread là nhiều luồng, chạy độc lập
public class OtherThread extends Thread {
	
	private int n;
	
	
	public OtherThread(int n) {
		super();
		this.n = n;
	}

// Phương thức sleep, thời gian nghỉ của từng biến
	@Override
	public void run() {
		for(int i=0 ;i<n; i++) {
			 try {
				 System.out.println(i);
				 Thread.sleep(500);
			 } catch(InterruptedException e) {
				 e.printStackTrace();
			 }
		}

	}

}
