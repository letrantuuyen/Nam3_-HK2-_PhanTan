package nhan;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

public class Demo2 {
	public static void main(String[] args) {
		Profile student = new Profile("20064261", "Hoang Trong Nhan", 21, true);
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
