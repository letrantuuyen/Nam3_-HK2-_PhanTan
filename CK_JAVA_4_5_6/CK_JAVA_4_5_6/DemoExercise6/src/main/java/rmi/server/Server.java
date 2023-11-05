package rmi.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import rmi.impl.RemoteImplement;
import rmi.service.RemoteInterface;

public class Server {
	public static void main(String[] args) throws RemoteException, NamingException {
		LocateRegistry.createRegistry(1111);
		Context context = new InitialContext();
		RemoteInterface ri = new RemoteImplement();
		context.bind("rmi://LAPTOP-5ABCG2KH:1111/ri", ri);
		System.out.println("Already");
	}
}
