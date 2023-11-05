package app;

import java.io.FileNotFoundException;
import java.util.Arrays;

import baitap2.entity.Address;
import baitap2.entity.Person;
import baitap2.entity.Phone;
import baitap2.util.Mapper;

public class PersonApp {
	public static void main(String[] args){
		
		Person p = new Person("An", "Nguyen", 20, 
				new Address("123 Le Lai", "HCM", "No", 10000),
				Arrays.asList(new Phone("Fax", "02899906664"), new Phone("Mobil", "0903888999")));
		
		String json = Mapper.toJson(p);
		System.out.println(json);
		
//			Person p;
//			try {
//				p = Mapper.fromJson2("data/person.json");
//				System.out.println(p);
//			} catch (FileNotFoundException e) {
//				
//				e.printStackTrace();
//			}
			
		
	}
}
