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
		// ghi vào file json
		JsonWriter jsonWrite = Json.createWriter(new FileWriter("data/students.json"));
		// danh sách đối tượng
		List<Student> students = List.of(
				new Student("20043331", "Le Tran Tu Uyen", 20, true),
				new Student("15545", "Kieu Thi Thuy Duong", 20, true)
				);
		// chuyển sang json
		for (Student st : students) {
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
		jsonWrite.writeArray(jsonArray);
		jsonWrite.close();
		System.out.println("Finished");

	}

}
