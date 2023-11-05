package bai_1_Json;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class objectFromJson {

	public static void main(String[] args) throws FileNotFoundException {
		JsonReader reader = Json.createReader(new FileReader("data/emplpoyee.json"));
		JsonObject object = reader.readObject();
		System.out.println(object);
		Employee e = new Employee();
		e.setId(object.getInt("id"));
		e.setName(object.getString("name"));
		e.setSalary(object.getInt("salary"));
		
		System.out.println(object);
		
	}
}
