package nhan;

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
		JsonObjectBuilder obuilder = Json.createObjectBuilder();
		JsonWriter jsonWriter = Json.createWriter(new FileWriter("data/student1.json"));

		List<Profile> student = List.of(
				new Profile("20064261", "Hoang Trong Nhan", 20, true),
				new Profile("20053561", "Ho Quoc Huy", 20, true)
				);
		for(Profile st : student) {
			JsonObject jsonObject = obuilder
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
