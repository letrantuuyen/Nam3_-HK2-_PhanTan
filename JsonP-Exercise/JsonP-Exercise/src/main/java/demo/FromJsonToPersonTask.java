package demo;

import entity.Person;
import mapper.Mapper;

public class FromJsonToPersonTask {
	public static void main(String[] args) {
		String json2 = Mapper.getJsonFromFile("data/person.json", 1);
		System.out.println(json2);
		
		Person person = Mapper.fromJson(json2);
		System.out.println(person);
	}
}
