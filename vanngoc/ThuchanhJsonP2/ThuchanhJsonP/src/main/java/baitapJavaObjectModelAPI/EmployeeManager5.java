package baitapJavaObjectModelAPI;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;

public class EmployeeManager5 {
	public static void main(String[] args) {
		String json = "{\"emp_id\":1000,\"fullName\":\"Lan Nguyen\",\"salary\":20000.0}";
		Employee emp = fromJson(json);
		System.out.println(emp);
	}

	private static Employee fromJson(String json) {
		StringReader in = new StringReader(json);
		JsonObject jo = Json.createReader(in).readObject();
		
		return new Employee(jo.getJsonNumber("emp_id").longValue(), 
				jo.getString("fullName"), 
				jo.getJsonNumber("salary").doubleValue());
	}

	
}
