package demo;

import mapper.Mapper;

public class ReadJsonFromFileTask {
	public static void main(String[] args) {
		
//		String json = Mapper.getJsonFromFile("data/people.json", 0);
//		System.out.println(json);
		
		String json2 = Mapper.getJsonFromFile("data/person.json", 1);
		System.out.println(json2);
		
	}
}
