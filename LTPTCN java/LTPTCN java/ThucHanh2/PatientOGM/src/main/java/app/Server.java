package app;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import dao.PatientDao;
import entity.Patient;

public class Server {
	public static void main(String[] args) throws IOException {
		
//		PatientDao patientDao = new PatientDao();
//		
//		new Thread(() -> {
//			ServerSocket serverSocket;
//			try {
//				serverSocket = new ServerSocket(9999);
//				System.out.println("Ready...");
//				
//				Socket socket = serverSocket.accept();
//				
//				DataInputStream in = new DataInputStream(socket.getInputStream());
//				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
//				
//				while(true) {
//					String id = in.readUTF();
//					System.out.println(id);
//					Patient patient = patientDao.getPatient(id);
//					System.out.println(patient);
//					out.writeObject(patient);
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			
//		}).start();
		ServerSocket serverSocket = new ServerSocket(9999);
		while(true) {
			Socket socket = serverSocket.accept();
			new Thread(new Handler(socket)).start();
		}
		
	}
}

class Handler implements Runnable{
	private Socket socket;
	private DataInputStream in;
	private ObjectOutputStream out;
	private PatientDao patientDao;

	public Handler(Socket socket) {
		super();
		this.socket = socket;
		 patientDao = new PatientDao();
	}



	@Override
	public void run() {
		 try {
			 in = new DataInputStream(socket.getInputStream());
			 out = new ObjectOutputStream(socket.getOutputStream());
			
			while(true) {
				String id = in.readUTF();
				System.out.println(id);
				Patient patient = patientDao.getPatient(id);
				System.out.println(patient);
				out.writeObject(patient);
			}
		 }catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
}
