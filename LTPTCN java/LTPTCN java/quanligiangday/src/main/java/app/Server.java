package app;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;


import dao.FacultyDao;
import dao.ISFacultyDao;

public class Server {

	public static void main(String[] args) throws  Exception {
		
	
		ISFacultyDao facultyDao = new FacultyDao();
		
		Hashtable<String, String> env = new Hashtable<>();
		env.put("java.security.policy", "policy/policy.policy");
		Context context = new InitialContext(env);
		LocateRegistry.createRegistry(9090);
		context.bind("rmi://LAPTOP-F8R9ISQD:9090/facultyDao", facultyDao);
		System.out.println("Ready...");
		
	}

}


