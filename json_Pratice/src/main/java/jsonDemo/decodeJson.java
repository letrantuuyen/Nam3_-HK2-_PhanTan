package jsonDemo;

import java.io.FileNotFoundException;
import java.io.FileReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonReader;

public class decodeJson {
	public static void main(String[] args) throws FileNotFoundException {
		JsonReader reader = Json.createReader(new FileReader("data/emp.json"));
		JsonObject jsonobject = reader.readObject();
		System.out.println(jsonobject);
		Employee e  = new Employee();
		e.setId(jsonobject.getInt("id"));;
		e.setName(jsonobject.getString("name"));
		e.setSalary(jsonobject.getInt("salary"));
		System.out.println(e);
	}

}
