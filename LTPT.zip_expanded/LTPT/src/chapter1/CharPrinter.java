package chapter1;

import java.util.Iterator;
// TẠO TASK

// Runnable là phương thức trừu tượng, chỉ có 1 
// dùng biểu thức lamda để viết code
// Runnable là hàm không trả về, trả về kiểu void
// 
public class CharPrinter implements Runnable {

	private char ch;
	private int num;
	// constructer
	public CharPrinter(char ch, int num) {
		super();
		this.ch = ch;
		this.num = num;
	}

	@Override
	public void run() {
		for(int i=0;i<num;i++) {
			System.out.print( ch +  " ");
		}
		System.out.println();
	} 
}
