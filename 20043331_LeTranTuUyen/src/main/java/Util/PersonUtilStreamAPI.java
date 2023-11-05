package Util;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import entity.Address;
import entity.Person;
import entity.Phone;

public class PersonUtilStreamAPI {
	
	public static  Person StreamAPI(String FileStream) {
		
		FileStream = " {\r\n"
				+ " \"firstName\": \"John\",\r\n"
				+ " \"lastName\": \"Smith\",\r\n"
				+ " \"age\": 25,\r\n"
				+ " \"address\": {\r\n"
				+ " \"streetAddress\": \"21 2nd Street\",\r\n"
				+ " \"city\": \"New York\",\r\n"
				+ " \"state\": \"NY\",\r\n"
				+ " \"postalCode\": 10021\r\n"
				+ " },\r\n"
				+ " \"phoneNumbers\": [\r\n"
				+ " {\r\n"
				+ " \"type\": \"home\",\r\n"
				+ " \"number\": \"212 555-1234\"\r\n"
				+ " },\r\n"
				+ " {\r\n" 
				+ " \"type\": \"fax\",\r\n"
				+ " \"number\": \"646 555-4567\"\r\n"
				+ " }\r\n"
				+ " ] \r\n"
				+ "}";
		
		JsonParser parser = Json.createParser(new StringReader(FileStream));
		Person person = null;
		String keyName = "";
		Address ad = null;
		List<Phone> phoneNums = null;
		while(parser.hasNext()) {
			Event event = parser.next();
			switch (event) {
			case START_OBJECT: 
				if(keyName.equals("address"))
					ad = new Address();
				else
					person = new Person();
				break;
			
			case KEY_NAME:
				keyName = parser.getString();
				break;
			
			case VALUE_STRING: 
				String value = parser.getString();
				if(keyName.equals("firstName"))
					person.setFirstName(value);
				else if(keyName.equals("lastName"))
					person.setLastName(value);
				else if(keyName.equals("streetAddress"))
					ad.setSteetAddress(value);
				else if(keyName.equals("city"))
					ad.setCity(value);
				else if(keyName.equalsIgnoreCase("state"))
					ad.setState(value);
					
				break;
			
			case VALUE_NUMBER:
				if(parser.isIntegralNumber()) {
					int valueInt = parser.getInt();
					if(keyName.equals("age"))
						person.setAge(valueInt);
					else if(keyName.equals("postalCode"))
						ad.setPostalCode(valueInt);
				}
				break;
			
			case START_ARRAY:
				phoneNums = new ArrayList<>();
				JsonArray ja = parser.getArray();
				for (JsonValue jsonValue : ja) {
					JsonObject o = jsonValue.asJsonObject();
					Phone p = new Phone(o.getString("type"), o.getString("number"));
					phoneNums.add(p);
				}
				break;
			
			case END_ARRAY:
				break;
			
			case END_OBJECT:
				break;
			
			}
			person.setAddress(ad);
			person.setPhones(phoneNums);
		}
		
		
		return person;
	}

}
