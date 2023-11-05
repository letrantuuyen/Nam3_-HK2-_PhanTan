package exer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBinaryData {
	public static void main(String[] args) throws FileNotFoundException, IOException {
//		Files.copy(Path.of("data/big.txt"), new FileOutputStream("data/bigV2.txt"));
		
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		
		try {
			
			in = new BufferedInputStream(new FileInputStream("data/big.txt"));
			out = new BufferedOutputStream(new FileOutputStream("data/big_v2.txt"));
			
			int len = 1024;
			byte[] buff = new byte[len];
			
			while(in.available() > 0) {
				int n = in.read(buff, 0, len);
				out.write(buff, 0, n);
			}
			
		}finally {
			in.close();
			out.close();
		}
		
		
	}
}
