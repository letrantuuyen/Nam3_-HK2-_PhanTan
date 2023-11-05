package rmi.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = new ServerSocket(3331);
		System.out.println("Server is ready...");
		
		
		while(true) {
			
			Socket socket = serverSocket.accept();
			 
			InetAddress iddr = socket.getInetAddress();
			
			String hostName = iddr.getHostName();
		}
	}

}
