package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Server {
	
	public static void main(String[] args) throws RemoteException, NamingException {
		
		Context context = new InitialContext();
		LocateRegistry.createRegistry(2222);
		Brandrmi brmi = new BrandImpl();
		context.bind("rmi://DESKTOP-DKAF2J0:2222/brmi", brmi);
		System.out.println("server is ready");
	}

}
