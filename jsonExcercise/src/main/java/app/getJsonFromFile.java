package app;

import javax.json.JsonObject;

import entity.Person;
import util.PersonUtil;

public class getJsonFromFile {
	public static void main(String[] args) {
		JsonObject oj = PersonUtil.getJsonObject("data/person.json");
		System.out.println(oj.toString());
		
		String json = "{\r\n"
				+ " \"firstName\": \"John\",\r\n"
				+ " \"lastName\": \"Smith\",\r\n"
				+ " \"age\": 25,\r\n"
				+ " \"address\": {\r\n"
				+ "\r\n"
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
				
		Person pe = PersonUtil.fromJson(json);
		System.out.println(pe);
		

	}
	
}
