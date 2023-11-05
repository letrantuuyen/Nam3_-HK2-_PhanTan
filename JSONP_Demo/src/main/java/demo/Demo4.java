package demo;

import java.io.FileWriter;
import java.io.IOException;

import jakarta.json.Json;
import jakarta.json.stream.JsonGenerator;

public class Demo4 {
	public static void main(String[] args) throws IOException {
		
		Student student = new Student("19232321", "Nguyen Thanh Hung", 21, true);
//		String json = {"id": "19232321", "fullName":"Nguyen Thanh Hung", "age": 21, active: 21};
		System.out.println(student);
		
		//The streaming APIs
		JsonGenerator jsonGenerator = Json.createGenerator(new FileWriter("data/student2.json"));
		jsonGenerator.writeStartObject()
		.write("id", student.getId())
		.write("fullName", student.getFullName())
		.write("age", student.getAge())
		.write("active", student.isActive())
		.writeEnd();
		
		jsonGenerator.close();
	}
}
