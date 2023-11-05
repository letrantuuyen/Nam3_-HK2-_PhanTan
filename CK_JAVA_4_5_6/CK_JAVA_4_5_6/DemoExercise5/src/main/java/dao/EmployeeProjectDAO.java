package dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import entity.Employee;
import entity.EmployeeProject;
import entity.Project;

public class EmployeeProjectDAO extends AbstractDao<EmployeeProject> {
	public EmployeeProjectDAO () {
		super (EmployeeProject.class);
	}
	public EmployeeProject getByIDEP (Object emID, Object proID) {
		return (EmployeeProject) em.createNativeQuery("select * from EmployeeProject where employeeID = "+ emID + " and projectID = " + proID, EmployeeProject.class).getResultList().get(0);
	}
	
	public Map<Employee, Integer> getHoursOfEmployee (Object proID) {
		Map<Employee, Integer> map = new LinkedHashMap<>();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<Object[]> objs = em.createNativeQuery("select ep.employeeID, sum(ep.hours) as hours \r\n"
				+ "from EmployeeProject ep\r\n"
				+ "where ep.projectID = "+proID+"\r\n"
				+ "group by ep.employeeID\r\n"
				+ "order by sum(ep.hours) Desc").getResultList();
		objs.forEach(o -> {
			Employee e = employeeDAO.getByID(o[0]);
			Integer hours = (Integer) o[1];
			map.put(e, hours);
		});
		return map;
	}
	
	public Map<Project, Integer> getHoursForEachProject () {
		Map<Project, Integer> map = new LinkedHashMap<>();
		ProjectDAO projectDAO = new ProjectDAO();
		List<Object[]> objs = em.createNativeQuery("select ep.projectID, sum(ep.hours) as hours\r\n"
				+ "from EmployeeProject ep\r\n"
				+ "group by ep.projectID\r\n"
				+ "order by sum(ep.hours) desc").getResultList();
		objs.forEach(o -> {
			Project p = projectDAO.getByID(o[0]);
			Integer hours = (Integer) o[1];
			map.put(p, hours);
		});
		return map;
	}
}
