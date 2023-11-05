package baitapStreamingAPI;

import java.io.StringWriter;

import javax.json.Json;
import javax.json.stream.JsonGenerator;

import baitapJavaObjectModelAPI.Employee;

public class EmploeeManager3 {
	public static void main(String[] args) {
		Employee emp = new Employee(3000l, "John Smith", 1500);

		String json = toJson(emp);

		System.out.println(json);
	}

	private static String toJson(Employee emp) {
		StringWriter writer = new StringWriter();
		JsonGenerator gen = Json.createGenerator(writer);
		gen.writeStartObject()
		.write("emp_id", emp.getId())
		.write("name", emp.getName())
		.write("salary", emp.getSalary())
		.writeEnd();

		gen.close();

		return writer.toString();
	}
}
