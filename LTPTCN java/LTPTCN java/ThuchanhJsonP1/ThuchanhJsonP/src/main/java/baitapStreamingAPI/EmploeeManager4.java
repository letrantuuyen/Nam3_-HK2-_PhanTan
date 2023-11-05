package baitapStreamingAPI;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

import javax.json.Json;
import javax.json.stream.JsonGenerator;

import baitapJavaObjectModelAPI.Employee;

public class EmploeeManager4 {
	public static void main(String[] args) throws IOException {
		Employee emp3 = new Employee(3000l, "John Smith", 1500);
		Employee emp4 = new Employee(4000l, "John Nguyen", 3500);

		List<Employee> employees = Arrays.asList(emp3, emp4);
		
		String json = toJson(employees);
		System.out.println(json);
		
		writeJson2File(employees, "data/emps4.json");

	}

	private static String toJson(List<Employee> employees) {
		StringWriter writer = new StringWriter();
		JsonGenerator gen = Json.createGenerator(writer);
		gen.writeStartArray();
		
		for(Employee emp : employees) {
			gen.writeStartObject()
			.write("emp_id", emp.getId())
			.write("name", emp.getName())
			.write("salary", emp.getSalary())
			.writeEnd();
		}
		
		gen.writeEnd();
		gen.close();
		
		return writer.toString();
	}

	private static void writeJson2File(List<Employee> employees, String fileName) throws IOException {
		FileWriter writer = new FileWriter(fileName);
		JsonGenerator gen = Json.createGenerator(writer);
		gen.writeStartArray();
		
		for(Employee emp : employees) {
			gen.writeStartObject()
			.write("emp_id", emp.getId())
			.write("name", emp.getName())
			.write("salary", emp.getSalary())
			.writeEnd();
		}
		
		gen.writeEnd();
		gen.close();
	}
	
}
