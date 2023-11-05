package nhan;

import java.io.FileWriter;
import java.io.IOException;

import jakarta.json.Json;
import jakarta.json.stream.JsonGenerator;

public class Demo4 {
	public static void main(String[] args) throws IOException {
		Profile student = new Profile("20064261","Hoang Trong Nhan", 20, true);
		System.out.println(student);
		
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
