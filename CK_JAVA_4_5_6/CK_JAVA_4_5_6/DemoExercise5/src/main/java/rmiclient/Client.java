package rmiclient;

import java.rmi.Naming;
import java.util.Map;

import entity.Employee;
import entity.EmployeeProject;
import entity.Project;
import rmi.service.RemoteInterface;

public class Client {
	public static void main(String[] args) {
		try {
			RemoteInterface clazzService =  (RemoteInterface) Naming.lookup("rmi://LAPTOP-5ABCG2KH:9731/ri");
            EmployeeProject ep = clazzService.getByIDEP(1,2);
            System.out.println(ep);
			
			Map<Employee, Integer> map = clazzService.getHoursOfEmployee(2);
            map.entrySet().iterator().forEachRemaining(en -> {
            	System.out.println(en.getKey().getLastName() + " : " + en.getValue());
            });
            Map<Project, Integer> map1 =  clazzService.getHoursForEachProject();
            map1.entrySet().iterator().forEachRemaining(en -> {
            	System.out.println(en.getKey().getProjectName() + " : " + en.getValue());
            });
            
            Project p = clazzService.getProjectByID(2);
			System.out.println(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
