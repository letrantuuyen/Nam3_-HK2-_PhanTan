package demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import entity.Address;
import entity.Person;
import entity.Phone;

//The Java Object Model API
public class Json2JavaPOJO2 {
	private static final String FILE_NAME = "json/people.json";

	public static void main(String[] args) throws FileNotFoundException {
		
		
		List<Person> persons = fromJson(FILE_NAME);
		
		persons.forEach(p -> System.out.println(p));
		
	}

	private static List<Person> fromJson(String fileName) throws FileNotFoundException {
		
		JsonReader reader = Json.createReader(new FileReader(fileName));
		JsonArray ja = reader.readArray();
		
		//Bài tập về nhà
		
		return null;
	}

	private static List<Phone> fromJson(JsonArray ja) {
		List<Phone> phones = new ArrayList<Phone>();
		
		ja.forEach(jv -> {
			JsonObject jo = jv.asJsonObject();
			Phone ph = new Phone(jo.getString("type"), jo.getString("number"));
			phones.add(ph);
		});
		
		return phones;
	}

	private static Address fromJson(JsonObject jo) {
		return new Address(jo.getString("streetAddress"), jo.getString("city"), jo.getString("state"), jo.getInt("postalCode"));
	}
}
