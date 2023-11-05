package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Server {
	public static void main(String[] args) throws NamingException, RemoteException {
		Context context = new InitialContext();
		
		LocateRegistry.createRegistry(8989);
		
		EmployeeService employeeService = new EmployeeServiceImpl();
		
		context.bind("rmi://b14m30:8989/employeeService", employeeService);
		
		System.out.println("Ready...");
	}
}
