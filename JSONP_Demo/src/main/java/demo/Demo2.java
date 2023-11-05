package demo;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

public class Demo2 {
	public static void main(String[] args) {
		
		Student student = new Student("19232321", "Nguyen Thanh Hung", 21, true);
		System.out.println(student);
		
		JsonObjectBuilder builder = Json.createObjectBuilder();
		JsonObject jsonObject = builder
				.add("id", student.getId())
				.add("fullName", student.getFullName())
				.add("age", student.getAge())
				.add("active", student.isActive())
				.build();
		
		System.out.println(jsonObject);
	}
}
