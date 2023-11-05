package demo;

import java.util.List;

import entity.Address;
import entity.Person;
import entity.Phone;
import mapper.Mapper;

public class FromPersnToJsonTask {
	public static void main(String[] args) {
		
		Person p = new Person("An", "Nguyen", 20, new Address("vs", "df", "sdf", 11000), List.of(
					new Phone("fax", "012323454")
				));
	
		String json = Mapper.toJson(p);
		
		System.out.println(json);
		
	}
}
