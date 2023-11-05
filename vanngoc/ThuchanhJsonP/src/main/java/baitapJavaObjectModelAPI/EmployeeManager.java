package baitapJavaObjectModelAPI;

import javax.json.Json;

public class EmployeeManager {
	public static void main(String[] args) {
		Employee emp = new Employee(1000l, "Lan Nguyen", 20000);
		
		String json = toJson(emp);
		
		System.out.println(json);
		
	}

	private static String toJson(Employee emp) {
		return Json.createObjectBuilder()
				.add("emp_id", emp.getId())
				.add("fullName", emp.getName())
				.add("salary", emp.getSalary())
				.build()
				.toString();
	}
}
