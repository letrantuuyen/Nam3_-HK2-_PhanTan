package demo;

import java.io.FileNotFoundException;
import java.io.FileReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Demo {
	public static void main(String[] args) throws FileNotFoundException {
		
		JsonReader jsonReader = Json.createReader(new FileReader("data/student.json"));
		JsonObject jsonObject = jsonReader.readObject();
		System.out.println(jsonObject);
		
		Student student = new Student();
		student.setId(jsonObject.getString("id"));
		student.setFullName(jsonObject.getString("fullName"));
		student.setAge(jsonObject.getInt("age"));
		student.setActive(jsonObject.getBoolean("active"));
		
		System.out.println(student);
	}
}
