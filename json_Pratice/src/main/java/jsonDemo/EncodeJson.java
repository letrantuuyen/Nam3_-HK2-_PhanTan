package jsonDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

public class EncodeJson {

	public static void main(String[] args) throws FileNotFoundException {
		Employee e = new Employee(20043331, "Uyen", 50000);
		JsonObjectBuilder json = Json.createObjectBuilder();
		JsonObject jsonOj = json
				.add("id",e.getId())
				.add("name",e.getName())
				.add("salary", e.getSalary())
				.build();
		System.out.println(jsonOj);
	}
	
}
