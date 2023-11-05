package Util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonValue;

import entity.Address;
import entity.Person;
import entity.Phone;

public class PersonUtilObjectAPI {

	public static Person readFile(String file) {
		JsonReader reader = null;
		Person person = new Person();
		
		try {
			reader = Json.createReader(new FileReader(file));
			JsonObject jsonObject = reader.readObject();
					person.setFirstName(jsonObject.getString("firstName"));
					person.setLastName(jsonObject.getString("lastName"));
					person.setAge(jsonObject.getInt("age"));
					
					
			JsonObject addressO = jsonObject.getJsonObject("address");
			Address address = new Address(
					addressO.getString("streetAddress"),
					addressO.getString("city"),
					addressO.getString("state"),
					addressO.getInt("postalCode"));
			
			person.setAddress(address);
			
		JsonArray jsonArray = jsonObject.getJsonArray("phoneNumbers");
		List<Phone> phoneNums = new ArrayList<Phone>();
		for (JsonValue phone : jsonArray) {
			if(phone instanceof JsonObject) {
				JsonObject o = phone.asJsonObject();
				Phone p = new Phone(o.getString("type"), o.getString("number"));
				phoneNums.add(p);
				
			
			}
			
		}
		person.setPhones(phoneNums);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(reader != null)
				reader.close();
		}
		return person;
	}
	
}