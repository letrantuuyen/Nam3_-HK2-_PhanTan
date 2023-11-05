package demo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonWriter;

public class Demo3 {
	public static void main(String[] args) throws IOException {
		
		JsonArrayBuilder builder = Json.createArrayBuilder();
		JsonObjectBuilder oBuilder = Json.createObjectBuilder();
		JsonWriter jsonWriter = Json.createWriter(new FileWriter("data/students.json"));
		
		List<Student> students = List.of(
				new Student("19232321", "Nguyen Thanh Hung", 21, true),
				new Student("18232321", "Le Thanh", 22, true)
			);
		
		for(Student st : students) {
			JsonObject jsonObject = oBuilder
			.add("id", st.getId())
			.add("fullName", st.getFullName())
			.add("age", st.getAge())
			.add("active", st.isActive())
			.build();
			
			builder.add(jsonObject);
		}
		
		JsonArray jsonArray = builder.build();
		System.out.println(jsonArray);
		
		jsonWriter.writeArray(jsonArray);
		jsonWriter.close();
		System.out.println("Finished!");
	}
}
