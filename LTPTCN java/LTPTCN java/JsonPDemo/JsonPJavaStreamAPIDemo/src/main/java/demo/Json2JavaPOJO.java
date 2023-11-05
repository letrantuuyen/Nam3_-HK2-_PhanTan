package demo;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import entity.Person;

//The Java Streaming API
public class Json2JavaPOJO {
	private static final String FILE_NAME = "json/person.json";

	public static void main(String[] args) throws FileNotFoundException {

		Person p = fromJson(FILE_NAME);
		System.out.println(p);
	}

	private static Person fromJson(String fileName) throws FileNotFoundException {

		Person p = null;

		JsonParser parser = Json.createParser(new FileReader(fileName));

		String keyname = "";

		while(parser.hasNext()) {
			Event event = parser.next();
			switch (event) {
			case START_OBJECT -> p = new Person();
			case KEY_NAME -> keyname = parser.getString();
			case VALUE_STRING -> {
				String value = parser.getString();
				setPerson(p, keyname, value);
			}
			case VALUE_NUMBER -> {
				int value = parser.getInt();
				p.setAge(value);
			}
			
//			case END_OBJECT -> {
//				System.out.println("Finished!");
//			}
			
			default -> {break;}
			}
		}
		return p;
	}

	private static void setPerson(Person p, String keyname, String value) {

		switch (keyname) {
		case "first_name" -> p.setFirstName(value);
		case "last_name" -> p.setLastName(value);
		case "email" -> p.setEmail(value);
		
		default -> {break;}
		}

	}



}
