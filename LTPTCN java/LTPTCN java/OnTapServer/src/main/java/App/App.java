package App;

import java.time.LocalDate;
import java.util.Date;

import Dao.Employee_dao;
import Dao.ProjectDao;
import Entity.Employee;
import Entity.Project;

public class App {
		public static void main(String[] args) {
			ProjectDao dao = new ProjectDao();
			Employee_dao employee_dao = new Employee_dao();
			Project p = new Project(10, "12", "abc", "xyz", "def", new Date());
//			boolean add = dao.addProject(p);
//			System.out.println(add);
			Employee find = employee_dao.findEmployeeByName("Adam");
			System.out.println(find);
		}
}
