package mapper;

import java.io.FileReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import entity.Address;
import entity.Person;
import entity.Phone;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
import jakarta.json.stream.JsonGenerator;
import jakarta.json.stream.JsonParser;
import jakarta.json.stream.JsonParser.Event;

//The Streaming API

public class Mapper {
	
	public static String getJsonFromFile(String path, int x) {
		
		JsonReader reader = null;
		try {
			reader = Json.createReader(new FileReader(path));
		
			if(x == 0)
				return reader.readArray().toString();
			else
				return reader.readObject().toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			reader.close();
		}
		
		return null;
	}
	//form Json to Preson
	//The Stream
	public static Person fromJson(String jsonObject) {
		
		Person person = null;
		Address address = null;
		List<Phone> phones = null;
		String keyName = "";
		
		StringReader reader = new StringReader(jsonObject);
		
		JsonParser parser = null;
		
		try {
			parser = Json.createParser(reader);
			while(parser.hasNext()) {
				Event event = parser.next();
				switch (event) {
				case START_OBJECT:
					if(keyName.equals("address"))
						address = new Address();
					else 
						person = new Person();
					break;
				case KEY_NAME:
					keyName = parser.getString();
					break;
					
				case VALUE_STRING:
					String sValue = parser.getString();
					//nhận biết String này thuộc về Key value nào
					//set giá
					setStringValue(person, address, keyName, sValue);
					break;
				case VALUE_NUMBER:
					if(parser.isIntegralNumber()) {
						int iValue = parser.getInt();
						if(keyName.equals("age"))
							person.setAge(iValue);
						else if(keyName.equals("postalCode"))
							address.setPostalCode(iValue);
					}
					break;
				case START_ARRAY:
					phones = new ArrayList<>();
					JsonArray ja = parser.getArray();
					for(JsonValue jv : ja) {
						if(jv instanceof JsonObject) {
							JsonObject jo = (JsonObject) jv;
							Phone ph = new Phone(jo.getString("type"),
									jo.getString("number"));
							phones.add(ph);
						}
					}
					break;
				
				default:
					break;
				}
			}
		}catch (Exception e) {
		}
		finally {
			parser.close();
		}
		
		person.setAddress(address);
		person.setPhoneNumbers(phones);
		return person;
	}
	
	private static void setStringValue(Person person, Address address, String keyName, String sValue) {
		switch (keyName) {
		case "firstName":
			person.setFirstName(sValue);
			break;
		case "lastName":
			person.setLastName(sValue);
			break;
		case "streetAddress":
			address.setStreetAddress(sValue);
			break;
		case "city":
			address.setCity(sValue);
			break;
		case "state":
			address.setState(sValue);
			break;
		default:
			break;
		}
	}

	public static String toJson(Person person) {
		
		StringWriter wr = new StringWriter();
		
		JsonGenerator gen = null;
		
		try {
			
			gen = Json.createGenerator(wr);
			gen.writeStartObject()
			.write("firstName", person.getFirstName())
			.write("lastName", person.getLastName()) //...
			.write("age",person.getAge())
			.writeKey("address")
				.writeStartObject()
				.write("streetAddress",person.getAddress().getStreetAddress())
				//...
				.writeEnd()
			.writeKey("phoneNumbers")
				.writeStartArray();
				List<Phone> phones = person.getPhoneNumbers();
				for (Phone phone : phones) {
					gen.writeStartObject()
					.write("type",phone.getType())
					.write("number",phone.getNumber())
					.writeEnd();
				}
				gen.writeEnd()
			.writeEnd();
			
			
		}finally {
			gen.close();
		}
		
		return wr.toString();
	}
	
	public static List<Person> fromJsons(String jsonArray) {
		
		return null;
	}
	
	public static String toJson(List<Person> people) {
		
		return "";
	}
}
