package util;

import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import entity.Address;
import entity.Person;
import entity.phoneNumber;

public class PersonUtil {
	
	public static JsonObject getJsonObject(String file) {
		
		JsonReader reader = null;
		 try {
			 reader = Json.createReader(new FileReader(file));
			 
			 return reader.readObject();
		 }catch (Exception e) {
			 e.printStackTrace();
		 }finally {
			 reader.close();
		 }
		 return null;
	}
	// the streaming api
	public static Person fromJson(String json) {
		JsonParser parser = Json.createParser(new StringReader(json));
		
		Person person = null;
		Address address = null;
		List<phoneNumber> phones = null;
		String keyName = " ";
		
		
		while(parser.hasNext()) {
			Event event = parser.next();
			
			
			switch (event) {
			// lay gia trij dau
			case START_OBJECT: {
				if(keyName.equals("address"))
					address =  new Address();
				else
					person = new Person();
				break;
			}
			//lay ten
			case KEY_NAME:{
				keyName = parser.getString();
				break;
			}
			case VALUE_STRING:{
				String sValue = parser.getString();
				setStringValue(person,address,keyName,sValue);
				break;
			}
			case VALUE_NUMBER:{
				if(parser.isIntegralNumber()) {
					int iValue = parser.getInt();
					if(keyName.equals("age"))
						person.setAge(iValue);
					else if(keyName.equals("postalCode"))
					address.setPostalCode(iValue);
				}
				break;
			}
			case START_ARRAY:{
				phones = new ArrayList();
				JsonArray ja= parser.getArray();
				for (JsonValue jsonValue : ja) {
					JsonObject jo = jsonValue.asJsonObject();
					phoneNumber ph = new phoneNumber(jo.getString("type"),jo.getString("number"));
					phones.add(ph);
				}
				break;
			}
			case END_ARRAY:{
				break;
			}
			case END_OBJECT:{
				break;
			}
			default:
				break;
			}	
		}
		person.setAddress(address);
		person.setPhone(phones);
		
		return person;
	}
		public static void setStringValue(Person p, Address ad, String keyName, String sValue) {
			
			switch (keyName) {
			case "firstName": {
				p.setFirstName(sValue);
				break;
			}
			case "lastName":{
				p.setLastName(sValue);
				break;
			}
			case "streetAddress":{
				ad.setStreetAddress(sValue);
				break;
			}
			case "city":{
				ad.setCity(sValue);
				break;
			}
			case "state":
				ad.setState(sValue);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + keyName);
			}
		}
	

}
