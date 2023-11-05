package baitapJavaObjectModelAPI;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;

public class EmployeeManager2 {
	public static void main(String[] args) {
		Employee emp1 = new Employee(1000l, "Lan Nguyen", 20000);
		Employee emp2 = new Employee(2000l, "Hung Nguyen", 25000);
		
		List<Employee> employees = Arrays.asList(emp1, emp2);
		
		String json = toJson(employees);
		
		write2file(json, "data/emps2.json");
		
		System.out.println(json);
		
	}

	private static void write2file(String json, String fileName) {
		try {
			PrintWriter out = new PrintWriter(new FileWriter(fileName), true);
			out.write(json);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String toJson(List<Employee> employees) {
		
		JsonArrayBuilder builder = Json.createArrayBuilder();
		
		for(Employee emp : employees) {
			JsonObject jo = toJson(emp);
			builder.add(jo);
		}
		
		return builder.build().toString();
	}

	private static JsonObject toJson(Employee emp) {
		return Json.createObjectBuilder()
				.add("emp_id", emp.getId())
				.add("fullName", emp.getName())
				.add("salary", emp.getSalary())
				.build();
	}
}
