package app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import dao.ProjectDao;
import entity.Project;

public class Server {
	public static void main(String[] args) throws IOException {
		
		ProjectDao projectDao = new ProjectDao();
		
		ServerSocket serverSocket = new ServerSocket(9898);
		System.out.println("Ready...");
		
		
		while(true) {
			Socket socket = serverSocket.accept();
			System.out.println(socket.getInetAddress().getHostName());
			
			new Thread(new Handler(socket, projectDao)).start();
		}
	}
}

class Handler implements Runnable{
	
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private ProjectDao projectDao;
	
	public Handler(Socket socket, ProjectDao projectDao) {
		super();
		this.socket = socket;
		this.projectDao = projectDao;
	}

	@Override
	public void run() {
		
		try {
			in = new ObjectInputStream(socket.getInputStream());
			out = new ObjectOutputStream(socket.getOutputStream());
			while(true) {
				String projectId = in.readUTF();
				System.out.println(projectId);
				Project p = projectDao.getProject(projectId);
				System.out.println(p);
				out.writeObject(p);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
