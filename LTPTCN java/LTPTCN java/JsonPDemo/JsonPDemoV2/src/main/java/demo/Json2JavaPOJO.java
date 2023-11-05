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
public class Json2JavaPOJO {
	private static final String FILE_NAME = "json/person.json";

	public static void main(String[] args) throws FileNotFoundException {
		
		
		Person p = fromJson(FILE_NAME);
		
		System.out.println(p);
		
	}

	private static Person fromJson(String fileName) throws FileNotFoundException {
		
		Person p = new Person();
		
		JsonReader reader = Json.createReader(new FileReader(fileName));
		JsonObject jo = reader.readObject();
		p.setFirstName(jo.getString("firstName"));
		p.setLastName(jo.getString("lastName"));
		p.setAge(jo.getInt("age"));
		p.setAddress(fromJson(jo.getJsonObject("address")));
		p.setPhoneNumbers(fromJson(jo.getJsonArray("phoneNumbers")));
		
		reader.close();
		
		return p;
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
