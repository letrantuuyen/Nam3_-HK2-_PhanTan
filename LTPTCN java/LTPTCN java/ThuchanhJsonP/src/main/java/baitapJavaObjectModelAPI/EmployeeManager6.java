package baitapJavaObjectModelAPI;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

public class EmployeeManager6 {
	public static void main(String[] args) {
		String json = "[{\"emp_id\":1000,\"fullName\":\"Lan Nguyen\",\"salary\":20000.0},{\"emp_id\":2000,\"fullName\":\"Hung Nguyen\",\"salary\":25000.0}]";
		
		List<Employee> employees = fromJson(json);
		
		employees.forEach(emp -> System.out.println(emp));
	}

	private static List<Employee> fromJson(String json) {
		
		List<Employee> list = new ArrayList<Employee>();
		
		StringReader in = new StringReader(json);
		JsonReader reader = Json.createReader(in);
		JsonArray ja = reader.readArray();
		
		for(JsonValue jv : ja) {
			JsonObject jo = (JsonObject) jv;
			Employee emp = new Employee(jo.getJsonNumber("emp_id").longValue(), 
				jo.getString("fullName"), 
				jo.getJsonNumber("salary").doubleValue());
			list.add(emp);
		}
		
		
		return list;
	}
}
