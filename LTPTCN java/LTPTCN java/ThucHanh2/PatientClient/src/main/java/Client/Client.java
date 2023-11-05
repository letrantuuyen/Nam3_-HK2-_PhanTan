package Client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import entity.Patient;

public class Client {
	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		Socket socket = new Socket("DESKTOP-G8E3BC9", 9999);
		
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		
		
		while(true) {
			System.out.println("Enter patientId to search : ");
			String patientId = sc.nextLine();
			
			out.writeUTF(patientId);
			
			Patient patient = (Patient)in.readObject();
			System.out.println("Client receved: " + patient);
		}
		
	}
}
