package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import entity.Project;

public class Client {
	private static final Scanner SC = new Scanner(System.in);

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket = new Socket("H82M18", 9898);
		
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		
		while(true) {
			try {
				System.out.println("Enter project id to search: ");
				String id = SC.nextLine();
				out.writeUTF(id);
				out.flush();
				Project project = (Project) in.readObject();
				System.out.println(project);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
