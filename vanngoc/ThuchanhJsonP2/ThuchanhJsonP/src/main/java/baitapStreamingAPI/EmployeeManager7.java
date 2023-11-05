package baitapStreamingAPI;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonNumber;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import baitapJavaObjectModelAPI.Employee;

public class EmployeeManager7 {
	public static void main(String[] args) {
		
		String json = "{\"emp_id\":3000,\"name\":\"John Smith\",\"salary\":1500.0}";
		
		Employee emp = fromJson(json);
		
		System.out.println(emp);
		
	}

	private static Employee fromJson(String json) {
		
		Employee emp = null;
		
		JsonParser parser = Json.createParser(new StringReader(json));
		String keyname = "";
		
		while(parser.hasNext()) {
			Event event = parser.next();
			
			switch (event) {
			case START_OBJECT:
				emp = new Employee();
				break;
			case KEY_NAME: 
				keyname = parser.getString();
//				System.out.println("keyname: " + keyname);
				break;
			case VALUE_STRING:
				String value = parser.getString();
				emp.setName(value);
				break;
				
			case VALUE_NUMBER: 
				JsonNumber value1 = (JsonNumber) parser.getValue(); 
				set(emp, keyname, value1);
				break;
			default:
				break;
			}
		}
		
		return emp;
	}

	private static void set(Employee emp, String keyname, JsonNumber value) {
		if(keyname.equals("emp_id"))
			emp.setId(value.longValue());
		else if(keyname.equals("salary"))
			emp.setSalary(value.doubleValue());
	}
}
