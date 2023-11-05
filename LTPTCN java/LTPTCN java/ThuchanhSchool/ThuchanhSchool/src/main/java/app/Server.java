package app;

import java.rmi.registry.LocateRegistry;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import dao.IStudentDao;
import dao.StudentDao;

public class Server {
	public static void main(String[] args) throws Exception {
		
		IStudentDao studentDao = new StudentDao();
		
		Hashtable<String, String> env = new Hashtable<>();
		env.put("java.security.policy", "policy/policy.policy");
		Context context = new InitialContext(env );
		
		LocateRegistry.createRegistry(9090);
		
		context.bind("rmi://h82m18:9090/studentDao", studentDao);
		
		System.out.println("Ready...");
		
	}
}
