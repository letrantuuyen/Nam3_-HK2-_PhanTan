package baitap2.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import baitap2.entity.Address;
import baitap2.entity.Person;
import baitap2.entity.Phone;

public class Mapper {
	
	public static String toJson(Person p) {
//		String json = "";
		
		JsonObjectBuilder builder = Json.createObjectBuilder();
		JsonObject jo = builder.add("firstName", p.getFirstName())
		.add("lastName", p.getLastName())
		.add("age", p.getAge())
		.add("address", toJson(p.getAddress()))
		.add("phoneNumbers", toJson(p.getPhoneNumbers()))
		.build();
		
		return jo.toString();
	}
	
	private static JsonValue toJson(List<Phone> phoneNumbers) {
		
		JsonArrayBuilder builder = Json.createArrayBuilder();
		for(Phone ph : phoneNumbers) {
			JsonObject jsonPh = toJson(ph);
			builder.add(jsonPh);
		}
		
		return builder.build();
	}

	private static JsonObject toJson(Phone ph) {
		return Json.createObjectBuilder()
				.add("type", ph.getType())
				.add("number", ph.getNumber())
				.build();
	}

	private static JsonValue toJson(Address address) {
		return Json.createObjectBuilder()
				.add("streetAddress", address.getStreetAddress())
				.add("city", address.getCity())
				.add("state", address.getState())
				.add("postalCode", address.getPostalCode())
				.build();
	}

	public static Person fromJson2(String fileName) throws FileNotFoundException  {
		Person p = null;
		
		JsonReader reader = Json.createReader(new FileReader(fileName));
		JsonObject jo = reader.readObject();
		
		if(jo != null) {
			p = new Person();
			p.setFirstName(jo.getString("firstName"));
			p.setLastName(jo.getString("lastName"));
		}
		
		return p;
	}
	
	public static Person fromJson(String fileName) throws FileNotFoundException {

		Person p = null;
		Address add = null;
		List<Phone> phones = null;
		String keyName = "";
		
		JsonParser parser = Json.createParser(new FileReader(fileName));
		
		while(parser.hasNext()) {
			Event event = parser.next();
			switch (event) {
			case START_OBJECT:
				if(keyName.equals("address")) 
					add = new Address();
				else 
					p = new Person();
				break;
			case KEY_NAME:
				keyName = parser.getString();
				break;
			case VALUE_STRING:
				String valStr = parser.getString();
				setValue(p, add, keyName, valStr);
				break;
			case VALUE_NUMBER:
				JsonNumber number = (JsonNumber) parser.getValue();
				if(keyName.equals("age"))
					p.setAge(number.intValue());
				else if(keyName.equals("postalCode"))
					add.setPostalCode(number.intValue());
				break;
				
			case START_ARRAY: 
				phones = new ArrayList<Phone>();
				JsonArray ja = parser.getArray();
				
				for(JsonValue jv : ja) {
					JsonObject jo = (JsonObject) jv;
					Phone ph = new Phone(jo.getString("type"), jo.getString("number"));
					phones.add(ph);
				}
				
				break;
			default:
				break;
			}
		}

		p.setAddress(add);
		p.setPhoneNumbers(phones);
		
		return p;

	}

	private static void setValue(Person p, Address add, String keyName, String valStr) {
		switch (keyName) {
		case "firstName":
			p.setFirstName(valStr);
			break;
		case "lastName":
			p.setLastName(valStr);
			break;
		case "streetAddress":
			add.setStreetAddress(valStr);
			break;
		case "city":
			add.setCity(valStr);
			break;
		case "state":
			add.setState(valStr);
			break;
		default:
			break;
		}
	}

	
}
