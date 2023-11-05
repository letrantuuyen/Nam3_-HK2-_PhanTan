package mapping;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import entity.Person;

public class Json2JavaPOJO {
	public static void main(String[] args) {
		
		String json = "{\"first_name\":\"John\",\"last_name\":\"Smith\",\"age\":24,\"email\":\"john.smith@gmail.com\"}";
		
		Person p = fromJson(json);
		
		System.out.println(p);
	}

	private static Person fromJson(String json) {
		
		StringReader s = new StringReader(json);
		
		JsonReader reader = Json.createReader(s);
		
		JsonObject jo = reader.readObject();
		
		return new Person(jo.getString("first_name"), 
				jo.getString("last_name"), 
				jo.getInt("age"), 
				jo.getString("email"));
	}
}
