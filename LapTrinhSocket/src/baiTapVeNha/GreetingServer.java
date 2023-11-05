package baiTapVeNha;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class GreetingServer {
	public static void main(String[] args) throws Exception{
		try {
			ServerSocket server = new ServerSocket(8080);
			Socket socket = server.accept();
			System.out.println("Client da ket noi!");
			DataInputStream din = new DataInputStream(socket.getInputStream());
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
			
			Scanner in = new Scanner(System.in);
			while(true) {
				String request = din.readUTF();
				if(request.equalsIgnoreCase("bye")) {
					break;
				}else {
					System.out.println("Chung Chung: "+request);
				}
				System.out.print("Lui Lui: ");
				dout.writeUTF(in.nextLine());
				dout.flush();
			}
			din.close();
			dout.close();
			socket.close();
			server.close();
		} catch (IOException e) {
			System.out.println("Loi ket noi!!!");
		}
	}
}