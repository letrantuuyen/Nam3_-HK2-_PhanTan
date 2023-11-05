import java.io.FileWriter;
import java.io.IOException;

import jakarta.json.Json;
import jakarta.json.stream.JsonGenerator;

public class Demo4 {

	public static void main(String[] args) throws IOException {
		Student student = new Student("20043331", "Le Tran Tu Uyen", 20, true);
		System.out.println(student);
		
		//ghi vào file json
		JsonGenerator jsonGenerator = Json.createGenerator(new FileWriter("data/student2.json"));
		jsonGenerator.writeStartObject()
		.write("id",student.getId())
		.write("fullName", student.getFullName())
		.write("age",student.getAge())
		.write("active",student.isActive())
		.writeEnd();
		
		jsonGenerator.close();
	}
}
