package baiTapVeNha;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class GreetingClient {
	public static void main(String[] args) throws Exception{
		try {
			Socket socket = new Socket("172.27.38.2", 900);
			DataInputStream din = new DataInputStream(socket.getInputStream());
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
			Scanner in = new Scanner(System.in);
			
			while(true) {
				System.out.print("Lui Lui: ");
				dout.writeUTF(in.nextLine());
				dout.flush();
				String response = din.readUTF();
				if(response.equalsIgnoreCase("bye bye!")) {
					break;
				}else {
					System.out.println("Chung Chung: "+response);
				}
			}
			din.close();
			dout.close();
			socket.close();
		} catch (Exception e) {
			System.out.println("Loi ket noi!!!");
		}
	}
}
